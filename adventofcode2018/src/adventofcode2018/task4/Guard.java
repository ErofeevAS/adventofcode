package adventofcode2018.task4;

import java.util.ArrayList;
import java.util.List;

public class Guard {
	private int id;
	private int sleep = 0;
	private List<SleepTime> sleepSheduler = new ArrayList<SleepTime>();

	public Guard() {
		super();
	}

	public Guard(int id, int sleep) {
		super();
		this.id = id;
		this.sleep = sleep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSleep() {
		return sleep;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	public void addToSleep(int minutes) {
		this.sleep = sleep + minutes;
	}

	public List<SleepTime> getSleepSheduler() {
		return sleepSheduler;
	}

	public void setSleepSheduler(List<SleepTime> sleepSheduler) {
		this.sleepSheduler = sleepSheduler;
	}

	public void addSleepTimeToSheduler(SleepTime date) {
		sleepSheduler.add(date);
	}

	@Override
	public String toString() {
		return "Guard [id=" + id + ", sleep=" + sleep + ", sleepSheduler=" + sleepSheduler + "]";
	}

}
