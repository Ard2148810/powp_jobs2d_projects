package edu.kis.powp.jobs2d.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Interface extending Job2dDriverCommand to execute more than one command.
 */
public interface ICompoundCommand extends DriverCommand, Iterable<DriverCommand> {

    public Iterator<DriverCommand> iterator();

    @Override
    default DriverCommand clone(){
        List<DriverCommand> commands = new ArrayList<>();
        for (DriverCommand command : this) {
            commands.add(command);
        }
        return new DefaultCompoundCommand(commands);
    }

}
