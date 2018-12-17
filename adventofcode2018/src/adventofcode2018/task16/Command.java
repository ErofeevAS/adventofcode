package adventofcode2018.task16;

import java.util.ArrayList;
import java.util.List;

public class Command {

	private List<Integer> regBeforeCommand = new ArrayList<>();
	private List<Integer> command = new ArrayList<>();
	private List<Integer> regAfterCommand = new ArrayList<>();
	private Operation operation;
	private int matchCounter = 0;

	public Command() {
		super();
		operation = new Operation();
	}

	public int getMatchCounter() {
		return matchCounter;
	}

	public void setMatchCounter(int matchCounter) {
		this.matchCounter = matchCounter;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public List<Integer> getRegBeforeCommand() {
		return regBeforeCommand;
	}

	public void setRegBeforeCommand(List<Integer> regBeforeCommand) {
		this.regBeforeCommand = regBeforeCommand;
	}

	public List<Integer> getCommand() {
		return command;
	}

	public void setCommand(List<Integer> command) {
		this.command = command;
	}

	public List<Integer> getRegAfterCommand() {
		return regAfterCommand;
	}

	public void setRegAfterCommand(List<Integer> regAfterCommand) {
		this.regAfterCommand = regAfterCommand;
	}

	public void addRegBefore(int a) {
		regBeforeCommand.add(a);
	}

	public void addRegAfter(int a) {
		regAfterCommand.add(a);
	}

	public void addCommand(int a) {
		command.add(a);
	}

	class Operation {

		private void isMatch(List<Integer> reg) {
			if (reg.equals(regAfterCommand)) {
				matchCounter++;
			}
		}

		public List<Integer> addr() {
			
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int addressRegB = command.get(2);
			int addressRegC = command.get(3);
			
			int regA = regBeforeCommand.get(addressRegA);
			int regB = regBeforeCommand.get(addressRegB);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA + regB;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);
			regAfter.set(addressRegB, regB);
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> addi() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int valueB = command.get(2);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA + valueB;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);			
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> multr() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int addressRegB = command.get(2);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regB = regBeforeCommand.get(addressRegB);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA * regB;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);
			regAfter.set(addressRegB, regB);
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> multi() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int valueB = command.get(2);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA * valueB;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);		
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> bandr() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int addressRegB = command.get(2);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regB = regBeforeCommand.get(addressRegB);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA & regB;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);
			regAfter.set(addressRegB, regB);
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> bandi() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int valueB = command.get(2);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA & valueB;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);			
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> borr() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int addressRegB = command.get(2);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regB = regBeforeCommand.get(addressRegB);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA | regB;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);
			regAfter.set(addressRegB, regB);
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> bori() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int valueB = command.get(2);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA | valueB;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);		
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> setr() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regC = regBeforeCommand.get(addressRegC);
			regC = regA;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);			
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> seti() {
			int commandId = command.get(0);
			int valueA = command.get(1);
			int addressRegC = command.get(3);
			int regC = valueA;
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);			
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> gtir() {
			int commandId = command.get(0);
			int valueA = command.get(1);
			int addressRegB = command.get(2);
			int regB = regBeforeCommand.get(addressRegB);
			int addressRegC = command.get(3);
			int regC = 0;
			if (valueA > regB) {
				regC = 1;
			}
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);		
			regAfter.set(addressRegB, regB);	
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> gtri() {
			int commandId = command.get(0);
			int valueB = command.get(2);
			int addressRegA = command.get(1);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regC = 0;
			if (regA > valueB) {
				regC = 1;
			}
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);			
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> gtrr() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int addressRegB = command.get(2);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regB = regBeforeCommand.get(addressRegB);
			int regC = 0;
			if (regA > regB) {
				regC = 1;
			}
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);
			regAfter.set(addressRegB, regB);
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> eqir() {
			int commandId = command.get(0);
			int valueA = command.get(1);
			int addressRegB = command.get(2);
			int regB = regBeforeCommand.get(addressRegB);
			int addressRegC = command.get(3);
			int regC = 0;
			if (valueA == regB) {
				regC = 1;
			}
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);			
			regAfter.set(addressRegB, regB);
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> eqri() {
			int commandId = command.get(0);
			int valueB = command.get(2);
			int addressRegA = command.get(1);
			int addressRegC = command.get(3);
			int regA = regBeforeCommand.get(addressRegA);
			int regC = 0;
			if (regA == valueB) {
				regC = 1;
			}
			List<Integer> regAfter = new ArrayList<Integer>(regBeforeCommand);
			regAfter.set(addressRegA, regA);		
			regAfter.set(addressRegC, regC);
			isMatch(regAfter);
			return regAfterCommand;
		}

		public List<Integer> eqrr() {
			int commandId = command.get(0);
			int addressRegA = command.get(1);
			int addressRegB = command.get(2);
			int addressRegC = command.get(3);
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
			return regAfterCommand;
		}
	}

}
