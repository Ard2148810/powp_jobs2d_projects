package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * Implementation of Job2dDriverCommand for operateTo command functionality.
 */
public class OperateToCommand implements DriverCommand {

	private int posX, posY;

	public OperateToCommand(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public void movePoint(int x, int y) {
		this.posX += x;
		this.posY += y;
	}

	@Override
	public void execute(Job2dDriver driver) {
		driver.operateTo(posX, posY);
	}

	@Override
	public DriverCommand clone() throws CloneNotSupportedException {
		return (OperateToCommand) super.clone();
	}

}
