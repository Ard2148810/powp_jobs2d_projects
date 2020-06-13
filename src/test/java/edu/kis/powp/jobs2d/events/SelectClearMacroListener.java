package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.features.MacroFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectClearMacroListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MacroFeature.getMacroDriverDecorator().clearMemory();
    }
}
