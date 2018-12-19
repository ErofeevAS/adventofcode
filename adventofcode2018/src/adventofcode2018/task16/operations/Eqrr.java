package adventofcode2018.task16.operations;

import java.util.ArrayList;
import java.util.List;

import adventofcode2018.task16.Command;

public class Eqrr extends AbstractOperation {

	public Eqrr(Command command) {
		super(command);

	}

	@Override
	public void execute() {
		int addressRegA = opCode.get(1);
		int addressRegB = opCode.get(2);
		int addressRegC = opCode.get(3);
		int regA = regBeforeCommand.get(addressRegA);
		int regB = regBeforeCommand.get(addressRegB);
		int regC = 0;
		if (regA == regB) {
			regC = 1;
		}
		List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
		regAfter.set(addressRegA, regA);
		regAfter.set(addressRegB, regB);
		regAfter.set(addressRegC, regC);
		isMatch(regAfter);

	}

}
