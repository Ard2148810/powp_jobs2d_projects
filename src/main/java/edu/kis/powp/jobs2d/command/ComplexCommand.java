package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ICompoundCommand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComplexCommand implements ICompoundCommand {

    private List<DriverCommand> commandList;

    public ComplexCommand(List<DriverCommand> commands) {
        this.commandList = commands;
    }

    @Override
    public void execute(Job2dDriver driver) {
        for(int i=0;i<commandList.size();i++) {
            commandList.get(i).execute(driver);
        }
    }

    @Override
    public Iterator<DriverCommand> iterator() {
        return commandList.iterator();
    }

    @Override
    public ComplexCommand clone() throws CloneNotSupportedException {
        List<DriverCommand> commands = new ArrayList<>();
        for (DriverCommand command : this.commandList) {
            commands.add(command.clone());
        }
        return new ComplexCommand(commands);
    }
}
