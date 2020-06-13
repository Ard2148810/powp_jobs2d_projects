package edu.kis.powp.jobs2d.command;

import java.util.Iterator;


public class CommandCounterVisitor implements Visitor {

	private int operateToCommandCounter = 0;
	private int setPositionCommandCounter = 0;

	public int getOperateToCommandCounter() {
		return operateToCommandCounter;
	}

	public int getSetPositionCommandCounter() {
		return setPositionCommandCounter;
	}

	public int getAllCommandsCounter() {
		return setPositionCommandCounter + operateToCommandCounter;
	}

	@Override
	public void visit(OperateToCommand operateToCommand) {
		operateToCommandCounter++;
	}

	@Override
	public void visit(SetPositionCommand setPositionCommand) {
		setPositionCommandCounter++;
	}

	@Override
	public void visit(ICompoundCommand compoundCommand) {
		Iterator<DriverCommand> iterator = compoundCommand.iterator();
		while (iterator.hasNext())
		{
			DriverCommand driverCommand = iterator.next();
			driverCommand.accept(this);
		}
	}
}
