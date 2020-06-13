package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.observer.Subscriber;

import java.util.List;


public interface CommandManager {
	void clearCurrentCommand();

	void runCommand();

	String getCurrentCommandString();

	List<Subscriber> getChangeSubscribers();

	void addChangeSubscriber(Subscriber subscriber);

	void clearChangeSubscribers();
}
