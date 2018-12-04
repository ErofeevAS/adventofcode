package adventofcode2018.task4;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventofcode2018.FileReader;

public class Task4 {

	private List<PieceOfScheduler> scheduler = new ArrayList<PieceOfScheduler>();
	private List<Guard> guards = new ArrayList<Guard>();

	public List<PieceOfScheduler> getScheduler() {
		return scheduler;
	}

	public int getResult(String filename) throws IOException, ParseException {
		String[] data = FileReader.readFromFile(filename);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		for (int i = 0; i < data.length; i++) {
			String[] fields = data[i].split("]");
			String dataStr = fields[0].substring(1, fields[0].length());
			Date date = format.parse(dataStr);
			StringBuilder message = new StringBuilder(fields[1]);
			scheduler.add(new PieceOfScheduler(date, message.toString()));

		}
		Collections.sort(scheduler);
		int lazestGuardId = getIdMostLazyGuard();
		Guard guard = findById(lazestGuardId);
		int munuteForEscape = getMinuteForEscape(guard);
		return munuteForEscape * lazestGuardId;

	}

	public int getResult2() {
		int minute = 0;
		int freqAsleepGuardId = 0;
		int max = 0;

		for (Guard guard : guards) {
			if (getMaxChillingMinute(guard) > max) {
				max = getMaxChillingMinute(guard);
				minute = getMinuteForEscape(guard);
				freqAsleepGuardId = guard.getId();
			}
		}
		return minute * freqAsleepGuardId;

	}

	private Guard findById(int id) {
		for (Guard guard : guards) {
			if (guard.getId() == id) {
				return guard;
			}
		}
		return null;
	}

	private Guard isGuardInit(int id) {
		for (Guard guard : guards) {
			if (guard.getId() == id) {
				return guard;
			}
		}
		return null;
	}

	private int getIdMostLazyGuard() {
		initGuards();
		int maxMinutes = 0;
		int id = 0;
		for (Guard guard : guards) {
			if (guard.getSleep() > maxMinutes) {
				maxMinutes = guard.getSleep();
				id = guard.getId();
			}
		}

		return id;

	}

	private void initGuards() {
		Pattern p = Pattern.compile("^ Guard #(\\d{4}|\\d{3}|\\d{2}|\\d{1}) begins shift");
		Matcher m;
		Date startSleep = null;
		Date stopSleep = null;
		Guard guard = null;

		for (PieceOfScheduler pieceOfScheduler : scheduler) {
			m = p.matcher(pieceOfScheduler.getMessage());
			if (m.matches()) {
				if (guard != null) {
					guards.add(guard);
				}

				int id = Integer.parseInt(pieceOfScheduler.getMessage().split("\\s+")[2].substring(1));
				Guard checkedGuard = isGuardInit(id);
				if (checkedGuard != null) {
					guard = checkedGuard;

				} else {
					guard = new Guard();
					guard.setId(id);
				}

			}

			if (pieceOfScheduler.getMessage().equals(" falls asleep")) {
				startSleep = pieceOfScheduler.getDate();
			}

			if (pieceOfScheduler.getMessage().equals(" wakes up")) {
				stopSleep = pieceOfScheduler.getDate();
				long start = startSleep.getTime();
				long stop = stopSleep.getTime();
				long minutes = ((stop - start) / 60000);
				SleepTime sleepTime = new SleepTime(startSleep, stopSleep);
				guard.addSleepTimeToSheduler(sleepTime);
				guard.addToSleep((int) minutes);

			}

		}

	}

	private int getMinuteForEscape(Guard guard) {

		int start;
		int stop;
		List<SleepTime> sleepSheduler = guard.getSleepSheduler();
		int[] minutes = new int[60];
		int max = 0;
		int index = 0;

		for (int i = 0; i < sleepSheduler.size(); i++) {
			start = sleepSheduler.get(i).getStart().getMinutes();
			stop = sleepSheduler.get(i).getStop().getMinutes();
			for (int j = start; j < stop; j++) {
				minutes[j] = minutes[j] + 1;
			}
		}

		for (int i = 0; i < minutes.length; i++) {
			if (minutes[i] > max) {
				max = minutes[i];
				index = i;
			}
		}
		return index;
	}

	private int getMaxChillingMinute(Guard guard) {

		int start;
		int stop;
		List<SleepTime> sleepSheduler = guard.getSleepSheduler();
		int[] minutes = new int[60];
		int max = 0;
		int index = 0;

		for (int i = 0; i < sleepSheduler.size(); i++) {
			start = sleepSheduler.get(i).getStart().getMinutes();
			stop = sleepSheduler.get(i).getStop().getMinutes();
			for (int j = start; j < stop; j++) {
				minutes[j] = minutes[j] + 1;
			}
		}

		for (int i = 0; i < minutes.length; i++) {
			if (minutes[i] > max) {
				max = minutes[i];
				index = i;
			}
		}
		return max;
	}

}
