package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.appbase.gui.WindowComponent;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.Readers.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CommandImportWindow extends JFrame implements WindowComponent {

	private DriverCommandManager commandManager;
	
    private JTextArea currentCommandField;
    private Reader reader;

    public CommandImportWindow(DriverCommandManager commandManager, Reader reader) {
        this.setTitle("Command Manager");
        this.setSize(400, 400);
        Container content = this.getContentPane();
        content.setLayout(new GridBagLayout());

        this.commandManager = commandManager;
        this.reader = reader;
        
        GridBagConstraints c = new GridBagConstraints();

        currentCommandField = new JTextArea("You code here!");
        currentCommandField.setEditable(true);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(currentCommandField, c);

        JButton btnLoadCommand = new JButton("Load command");
        btnLoadCommand.addActionListener((ActionEvent e) -> this.loadCommand());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(btnLoadCommand, c);
    }

    private void loadCommand() {
    	commandManager.setCurrentCommand(reader.read(currentCommandField.getText()));
    }

    @Override
    public void HideIfVisibleAndShowIfHidden() {
        this.setVisible(!this.isVisible());
    }
}
