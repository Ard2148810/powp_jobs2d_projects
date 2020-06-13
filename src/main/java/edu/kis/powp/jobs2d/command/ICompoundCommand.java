package edu.kis.powp.jobs2d.command;

import java.util.Iterator;


/**
 * Interface extending Job2dDriverCommand to execute more than one command.
 */
public interface ICompoundCommand extends DriverCommand {

	Iterator<DriverCommand> iterator();

	public ICompoundCommand clone() throws CloneNotSupportedException;

	default void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
