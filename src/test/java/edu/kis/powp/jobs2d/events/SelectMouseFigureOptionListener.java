package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.drivers.DriverManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectMouseFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private JPanel drawPanel;
	private Integer previousHeadXPosition;
	private Integer previousHeadYPosition;


	public SelectMouseFigureOptionListener(JPanel drawPanel, DriverManager driverManager) {
		this.drawPanel = drawPanel;
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cleanHeadPosition();
		int halfWindowHeight = drawPanel.getHeight()/2;
		int halfWindowWidth = drawPanel.getWidth()/2;

		this.drawPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(previousHeadXPosition == null || previousHeadYPosition == null){
					updatePreviousMousePosition(e, halfWindowWidth, halfWindowHeight);
				}

				driverManager.getCurrentDriver().setPosition(previousHeadXPosition, previousHeadYPosition);
				driverManager.getCurrentDriver().operateTo(e.getX()- halfWindowWidth, e.getY()- halfWindowHeight);

				updatePreviousMousePosition(e, halfWindowWidth, halfWindowHeight);
			}
		});
	}

	private void updatePreviousMousePosition(MouseEvent event, int halfWidth, int halfHeight){
		previousHeadXPosition = event.getX() - halfWidth;
		previousHeadYPosition = event.getY() - halfHeight;
	}

	private void cleanHeadPosition(){
		previousHeadYPosition = null;
		previousHeadXPosition = null;
	}
}
