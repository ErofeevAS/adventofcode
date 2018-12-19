package adventofcode2018.task16.operations;

import java.util.ArrayList;
import java.util.List;

import adventofcode2018.task16.Command;

public class Eqir extends AbstractOperation {

	public Eqir(Command command) {
		super(command);

	}

	@Override
	public void execute() {
		int valueA = opCode.get(1);
		int addressRegB = opCode.get(2);
		int regB = regBeforeCommand.get(addressRegB);
		int addressRegC = opCode.get(3);
		int regC = 0;
		if (valueA == regB) {
			regC = 1;
		}
		List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
		regAfter.set(addressRegB, regB);
		regAfter.set(addressRegC, regC);
		isMatch(regAfter);

	}

}
