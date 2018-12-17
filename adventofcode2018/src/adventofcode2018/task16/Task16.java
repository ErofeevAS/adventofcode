package adventofcode2018.task16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventofcode2018.FileReader;

public class Task16 {

	private int counter = 0;
	List<Command> commands = new ArrayList<Command>();

	private void init(String fileName) throws IOException {
		String[] data = FileReader.readFromFile(fileName);
		String before;
		String opCode;
		String after;

		for (int i = 0; i < data.length; i += 4) {
			Command command = new Command();
			opCode = data[i + 1];
			String[] opCodeSeq = opCode.split("\\s+");
			for (String string : opCodeSeq) {
				string.replaceAll("\\s+", "");
				command.addCommand(Integer.parseInt(string));
			}

			Pattern p = Pattern.compile("\\[.*\\]");
			Matcher matcher = p.matcher(data[i]);
			while (matcher.find()) {
				before = data[i].substring(matcher.start() + 1, matcher.end() - 1);
				before = before.replaceAll("\\s+", "");
				String[] beforeSeq = before.split(",");
				for (String string : beforeSeq) {

					command.addRegBefore(Integer.parseInt(string));
				}

			}
			matcher = p.matcher(data[i + 2]);
			while (matcher.find()) {
				after = data[i + 2].substring(matcher.start() + 1, matcher.end() - 1);
				after = after.replaceAll("\\s+", "");
				String[] afterSeq = after.split(",");
				for (String string : afterSeq) {

					command.addRegAfter(Integer.parseInt(string));
				}

			}

			commands.add(command);
		}

	}

	public void getResult(String fileName) throws IOException {
		this.init(fileName);
		for (Command command : commands) {
			command.getOperation().addi();
			command.getOperation().addr();
			command.getOperation().multi();
			command.getOperation().multr();
			command.getOperation().bandi();
			command.getOperation().bandr();
			command.getOperation().bori();
			command.getOperation().borr();
			command.getOperation().setr();
			command.getOperation().seti();
			command.getOperation().gtir();
			command.getOperation().gtri();
			command.getOperation().gtrr();
			command.getOperation().eqir();
			command.getOperation().eqri();
			command.getOperation().eqrr();

			if (command.getMatchCounter() >= 3) {
				counter++;
			}

		}
		System.out.println(counter);

	}

}
