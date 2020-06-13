package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.TestJobs2dApp;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectAddCommandManagerWindowCommandChangeObserver implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		CommandsFeature
				.getDriverCommandManager()
				.addChangeSubscriber(TestJobs2dApp.getWindowObserver());

	}
}
