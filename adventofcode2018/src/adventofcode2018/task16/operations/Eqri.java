package adventofcode2018.task16.operations;

import java.util.ArrayList;
import java.util.List;

import adventofcode2018.task16.Command;

public class Eqri extends AbstractOperation {

	public Eqri(Command command) {
		super(command);

	}

	@Override
	public void execute() {
		int valueB = opCode.get(2);
		int addressRegA = opCode.get(1);
		int addressRegC = opCode.get(3);
		int regA = regBeforeCommand.get(addressRegA);
		int regC = 0;
		if (regA == valueB) {
			regC = 1;
		}
		List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
		regAfter.set(addressRegA, regA);
		regAfter.set(addressRegC, regC);
		isMatch(regAfter);

	}

}
