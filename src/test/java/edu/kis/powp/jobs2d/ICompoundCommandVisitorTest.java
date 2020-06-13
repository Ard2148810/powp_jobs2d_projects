package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class ICompoundCommandVisitorTest implements ActionListener {

	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		logger.info("Testing ICompoundCommandVisitor");
		CommandCounterVisitor commandCounterVisitor = new CommandCounterVisitor();
		Job2dStub job2dStub = new Job2dStub();

		int expectedNumberOfSetPositionMethodCall = 3;
		int expectedNumberOfOperateMethodCall = 5;
		int expectedNumberOfAllOperationsCall = 8;

		List<DriverCommand> commands = new ArrayList<>();
		commands.add(new SetPositionCommand(-20, -50));
		commands.add(new OperateToCommand(-20, -50));
		commands.add(new SetPositionCommand(-20, -40));
		commands.add(new OperateToCommand(-20, 50));
		commands.add(new SetPositionCommand(0, -50));
		commands.add(new OperateToCommand(-56, 40));
		commands.add(new OperateToCommand(-25, 21));
		commands.add(new OperateToCommand(-11, 23));


		ICompoundCommand iCompoundCommand = new ICompoundCommand() {

			List<DriverCommand> driverCommands = commands;
			String name;

			@Override
			public void accept(Visitor visitor) {
				visitor.visit(this);
			}

			@Override
			public void execute(Job2dDriver driver) {
				driverCommands.forEach((c) -> c.execute(driver));
			}

			@Override
			public Iterator<DriverCommand> iterator() {
				return driverCommands.iterator();
			}

			@Override
			public ICompoundCommand clone() throws CloneNotSupportedException {
				List<DriverCommand> commands = new ArrayList<>();
				for (DriverCommand command : this.driverCommands) {
					commands.add(command.clone());
				}
				return new ComplexCommand(commands);
			}

			@Override
			public String toString() {
				return name;
			}
		};

		CommandCounterVisitor commandCounter = commandCounterVisitor;
		iCompoundCommand.accept(commandCounter);

		if (expectedNumberOfOperateMethodCall == commandCounterVisitor.getOperateToCommandCounter() && expectedNumberOfSetPositionMethodCall == commandCounterVisitor.getSetPositionCommandCounter()
			&& expectedNumberOfAllOperationsCall == commandCounterVisitor.getAllCommandsCounter()) {
			logger.info("ICompound Command Visitor Test Passed");
		} else {
			logger.info("ICompound Command Visitor TestFailed");
		}

	}

	class Job2dStub implements Job2dDriver{

		@Override
		public void setPosition(int i, int i1) {
			logger.info("Set position to " + i + " " + i1);
		}

		@Override
		public void operateTo(int i, int i1) {
			logger.info("Operate to " + i + " " + i1);
		}

	}
}
