package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.MacroDriverDecorator;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.features.MacroFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectLoadMacroDriverListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MacroDriverDecorator macroDriverDecorator = MacroFeature.getMacroDriverDecorator();

        CommandsFeature.getDriverCommandManager().setCurrentCommand(macroDriverDecorator.getDriverCommandList(), "Macro");
        DriverFeature.getDriverManager().setCurrentDriver(macroDriverDecorator.getCoreJob2dDriver());
    }
}
