package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindowObserverChangeObserver implements Subscriber {

	private CommandManagerWindow commandManagerWindow;

	public CommandManagerWindowObserverChangeObserver(CommandManagerWindow commandManagerWindow) {
		super();
		this.commandManagerWindow = commandManagerWindow;
	}

	public String toString() {
		return "Current observer change observer for command manager window";
	}

	@Override
	public void update() {
		commandManagerWindow.updateObserverListField();
	}

}
