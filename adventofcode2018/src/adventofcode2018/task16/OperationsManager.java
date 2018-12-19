package adventofcode2018.task16;

import java.util.ArrayList;
import java.util.List;

import adventofcode2018.task16.operations.AbstractOperation;
import adventofcode2018.task16.operations.Addi;
import adventofcode2018.task16.operations.Addr;
import adventofcode2018.task16.operations.Bandi;
import adventofcode2018.task16.operations.Bandr;
import adventofcode2018.task16.operations.Bori;
import adventofcode2018.task16.operations.Borr;
import adventofcode2018.task16.operations.Eqir;
import adventofcode2018.task16.operations.Eqri;
import adventofcode2018.task16.operations.Eqrr;
import adventofcode2018.task16.operations.Gtir;
import adventofcode2018.task16.operations.Gtri;
import adventofcode2018.task16.operations.Gtrr;
import adventofcode2018.task16.operations.Muli;
import adventofcode2018.task16.operations.Mulr;
import adventofcode2018.task16.operations.Seti;
import adventofcode2018.task16.operations.Setr;

public class OperationsManager {

	private List<AbstractOperation> operations = new ArrayList<>();
	private List<AbstractOperation> matchedOperation = new ArrayList<AbstractOperation>();
	private Command command;

	public OperationsManager(Command command) {
		super();
		this.command = command;
		this.init();

	}

	private void init() {
		operations.add(new Addr(command));
		operations.add(new Addi(command));
		operations.add(new Mulr(command));
		operations.add(new Muli(command));
		operations.add(new Bandr(command));
		operations.add(new Bandi(command));
		operations.add(new Borr(command));
		operations.add(new Bori(command));
		operations.add(new Setr(command));
		operations.add(new Seti(command));
		operations.add(new Gtir(command));
		operations.add(new Gtri(command));
		operations.add(new Gtrr(command));
		operations.add(new Eqir(command));
		operations.add(new Eqri(command));
		operations.add(new Eqrr(command));

	}

	public List<AbstractOperation> getOperations() {
		return operations;
	}

	public void setOperations(List<AbstractOperation> operations) {
		this.operations = operations;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public List<AbstractOperation> findMatchedOperations() {
		for (AbstractOperation operation : operations) {
			operation.execute();
			if (operation.getMatchCounter() == 1) {
				matchedOperation.add(operation);
			}
		}
		return matchedOperation;
	}

}
