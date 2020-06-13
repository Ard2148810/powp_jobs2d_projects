package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.CommandCounterVisitor;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DriverCommandVisitorTest1 implements ActionListener {

	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		logger.info("Testing Command Visitor");
		CommandCounterVisitor commandCounterVisitor = new CommandCounterVisitor();

		int expectedNumberOfSetPositionMethodCall = 3;
		int expectedNumberOfOperateMethodCall = 2;
		int expectedNumberOfAllOperationsCall = 5;

		List<DriverCommand> driverCommands = new ArrayList<>();
		driverCommands.add(new SetPositionCommand(-20, -50));
		driverCommands.add(new OperateToCommand(-20, -50));
		driverCommands.add(new SetPositionCommand(-20, -40));
		driverCommands.add(new OperateToCommand(-20, 50));
		driverCommands.add(new SetPositionCommand(0, -50));

		driverCommands.forEach((c) -> c.accept(commandCounterVisitor));

		if (expectedNumberOfOperateMethodCall == commandCounterVisitor.getOperateToCommandCounter() && expectedNumberOfSetPositionMethodCall == commandCounterVisitor.getSetPositionCommandCounter()
			&& expectedNumberOfAllOperationsCall == commandCounterVisitor.getAllCommandsCounter()) {
			logger.info("Driver Command Visitor test1 Passed");
		} else {
			logger.info("Driver Command Visitor test1 Failed");
		}
	}
}
