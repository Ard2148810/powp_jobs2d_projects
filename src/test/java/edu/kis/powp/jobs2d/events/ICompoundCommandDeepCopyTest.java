package edu.kis.powp.jobs2d.events;

import classes_for_test.MutableOperateToCommand;
import classes_for_test.MutableSetPositionCommand;
import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ICompoundCommandDeepCopyTest implements ActionListener {

    private DriverManager driverManager;

    public ICompoundCommandDeepCopyTest(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<DriverCommand> commands = new ArrayList<DriverCommand>();

        MutableSetPositionCommand setCommand = new MutableSetPositionCommand(0, 0);
        MutableOperateToCommand firstCommand = new MutableOperateToCommand(0, -100);
        MutableOperateToCommand secondCommand = new MutableOperateToCommand(30, -100);

        commands.add(setCommand);
        commands.add(firstCommand);
        commands.add(secondCommand);
        ComplexCommand command = new ComplexCommand(commands);

        ComplexCommand copy = null;
        try {
            copy = command.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }

        firstCommand.movePoint(20, 20);
        secondCommand.movePoint(20, 20);
        setCommand.movePoint(20, 20);

        command.execute(driverManager.getCurrentDriver());
        copy.execute(driverManager.getCurrentDriver());
    }
}