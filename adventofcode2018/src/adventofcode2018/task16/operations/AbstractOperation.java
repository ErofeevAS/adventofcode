package adventofcode2018.task16.operations;

import java.util.List;

import adventofcode2018.task16.Command;

public abstract class AbstractOperation {

	private int commandId;
	private Command command;
	protected List<Integer> opCode;
	protected List<Integer> regBeforeCommand;
	protected List<Integer> regAfterCommand;

	private int matchCounter = 0;

	protected void isMatch(List<Integer> reg) {
		if (reg.equals(regAfterCommand)) {
			matchCounter++;
			commandId = opCode.get(0);
		} else {

		}
	}

	public AbstractOperation(Command command) {
		super();
		this.command = command;
		this.opCode = command.getCommand();
		this.regBeforeCommand = command.getRegBeforeCommand();
		this.regAfterCommand = command.getRegAfterCommand();

	}

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int id) {
		this.commandId = id;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void execute() {
	}

	public int getMatchCounter() {
		return matchCounter;
	}

	public void setMatchCounter(int matchCounter) {
		this.matchCounter = matchCounter;
	}

	@Override
	public String toString() {
		return "AbstractOperation [commandId=" + commandId + ", command=" + command + ", opCode=" + opCode
				+ ", regBeforeCommand=" + regBeforeCommand + ", regAfterCommand=" + regAfterCommand + ", matchCounter="
				+ matchCounter + "]";
	}

}
