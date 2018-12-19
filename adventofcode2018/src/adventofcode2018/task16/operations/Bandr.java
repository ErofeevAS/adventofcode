package adventofcode2018.task16.operations;

import java.util.ArrayList;
import java.util.List;

import adventofcode2018.task16.Command;

public class Bandr extends AbstractOperation {

	public Bandr(Command command) {
		super(command);

	}

	@Override
	public void execute() {

		int addressRegA = opCode.get(1);
		int addressRegB = opCode.get(2);
		int addressRegC = opCode.get(3);
		int regA = regBeforeCommand.get(addressRegA);
		int regB = regBeforeCommand.get(addressRegB);
		int regC = regBeforeCommand.get(addressRegC);
		regC = regA & regB;
		List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
		regAfter.set(addressRegA, regA);
		regAfter.set(addressRegB, regB);
		regAfter.set(addressRegC, regC);
		isMatch(regAfter);

	}

}
