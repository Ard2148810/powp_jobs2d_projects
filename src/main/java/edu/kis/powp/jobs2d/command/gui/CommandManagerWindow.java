package edu.kis.powp.jobs2d.command.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import edu.kis.powp.appbase.gui.WindowComponent;
import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindow extends JFrame implements WindowComponent {

	private CommandManager commandManager;

	private JTextArea currentCommandField;

	private JTextArea observerListField;

	private final List<Subscriber> deletedSubscribers = new ArrayList<>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 9204679248304669948L;

	public CommandManagerWindow(CommandManager commandManager) {
		this.setTitle("Command Manager");
		this.setSize(400, 400);
		Container content = this.getContentPane();
		content.setLayout(new GridBagLayout());

		this.commandManager = commandManager;

		GridBagConstraints c = new GridBagConstraints();

		observerListField = new JTextArea("");
		observerListField.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(observerListField, c);
		updateObserverListField();

		currentCommandField = new JTextArea("");
		currentCommandField.setEditable(false);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(currentCommandField, c);
		updateCurrentCommandField();

        JButton btnRunCommand = new JButton("Run command");
        btnRunCommand.addActionListener((ActionEvent e) -> this.runCommand());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(btnRunCommand, c);

		JButton btnClearCommand = new JButton("Clear command");
		btnClearCommand.addActionListener((ActionEvent e) -> this.clearCommand());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnClearCommand, c);

		JToggleButton btnClearObservers = new JToggleButton("Delete observers");
		btnClearObservers.addActionListener(this::deleteObservers);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnClearObservers, c);
	}

	private void clearCommand() {
		commandManager.clearCurrentCommand();
		updateCurrentCommandField();
	}

    private void runCommand() {
		commandManager.runCommand();
    }

	public void updateCurrentCommandField() {
		currentCommandField.setText(commandManager.getCurrentCommandString());
	}

	public void deleteObservers(ActionEvent e) {
		JToggleButton button = (JToggleButton) e.getSource();
		if(button.isSelected()) {
			deletedSubscribers.addAll(commandManager.getChangeSubscribers());
			commandManager.clearChangeSubscribers();
			button.setText("Reset observers");
		} else {
			resetSubscribers();
			button.setText("Delete observers");
		}
		updateObserverListField();
	}

	private void resetSubscribers() {
		for(Subscriber subscriber : deletedSubscribers) {
			commandManager.addChangeSubscriber(subscriber);
		}
		deletedSubscribers.clear();
	}

	public void updateObserverListField() {
		StringBuilder observerListString = new StringBuilder();
		List<Subscriber> commandChangeSubscribers = commandManager.getChangeSubscribers();
		for (Subscriber observer : commandChangeSubscribers) {
			observerListString.append(observer.toString()).append(System.lineSeparator());
		}
		if (commandChangeSubscribers.isEmpty())
			observerListString = new StringBuilder("No observers loaded");

		observerListField.setText(observerListString.toString());
	}

	@Override
	public void HideIfVisibleAndShowIfHidden() {
		this.setVisible(!this.isVisible());
	}
}
