package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.features.CommandsFeature;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectAddLoggerCommandChangeObserver implements ActionListener {
	public SelectAddLoggerCommandChangeObserver() {
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		CommandsFeature
				.getDriverCommandManager()
				.addChangeSubscriber(CommandsFeature.getLoggerObserver());

	}
}
