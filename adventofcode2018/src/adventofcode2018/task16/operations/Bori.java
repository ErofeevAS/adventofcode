package adventofcode2018.task16.operations;

import java.util.ArrayList;
import java.util.List;

import adventofcode2018.task16.Command;

public class Bori extends AbstractOperation {

	public Bori(Command command) {
		super(command);

	}

	@Override
	public void execute() {
		int addressRegA = opCode.get(1);
		int valueB = opCode.get(2);
		int addressRegC = opCode.get(3);
		int regA = regBeforeCommand.get(addressRegA);
		int regC = regBeforeCommand.get(addressRegC);
		regC = regA | valueB;
		List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
		regAfter.set(addressRegA, regA);
		regAfter.set(addressRegC, regC);
		isMatch(regAfter);

	}

}
