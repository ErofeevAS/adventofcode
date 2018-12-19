package adventofcode2018.task16.operations;

import java.util.ArrayList;
import java.util.List;

import adventofcode2018.task16.Command;

public class Seti extends AbstractOperation {

	public Seti(Command command) {
		super(command);

	}

	@Override
	public void execute() {
		int valueA = opCode.get(1);
		int addressRegC = opCode.get(3);
		int regC = valueA;
		List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
		regAfter.set(addressRegC, regC);
		isMatch(regAfter);

	}

}
