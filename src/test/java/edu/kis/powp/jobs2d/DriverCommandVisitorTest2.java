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

public class DriverCommandVisitorTest2 implements ActionListener {

	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		logger.info("Testing Command Visitor");
		CommandCounterVisitor commandCounterVisitor = new CommandCounterVisitor();
		List<DriverCommand> driverCommands = new ArrayList<>();
		int expectedNumberOfSetPositionMethodCall = 1;
		int expectedNumberOfOperateMethodCall = 52;
		int expectedNumberOfAllOperationsCall = 53;
		driverCommands.add(new SetPositionCommand(0, -50));
		for (int i = 0; i < expectedNumberOfOperateMethodCall; i++) {
			driverCommands.add(new OperateToCommand(-20 + i, -50 + i));
		}
		driverCommands.forEach((c) -> c.accept(commandCounterVisitor));

		if (expectedNumberOfOperateMethodCall == commandCounterVisitor.getOperateToCommandCounter() && expectedNumberOfSetPositionMethodCall == commandCounterVisitor.getSetPositionCommandCounter()
			&& expectedNumberOfAllOperationsCall == commandCounterVisitor.getAllCommandsCounter()) {
			logger.info("Driver Command Visitor test2 Passed");
		} else {
			logger.info("Driver Command Visitor test2 Failed");
		}

	}
}
