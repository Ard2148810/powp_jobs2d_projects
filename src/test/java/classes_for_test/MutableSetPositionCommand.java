package classes_for_test;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.Visitor;

public class MutableSetPositionCommand implements DriverCommand {

    private int posX, posY;

    public MutableSetPositionCommand(int posX, int posY) {
        super();
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void execute(Job2dDriver driver) {
        driver.setPosition(posX, posY);
    }

    @Override
    public DriverCommand clone() throws CloneNotSupportedException {
        return (MutableSetPositionCommand) super.clone();
    }

    @Override
    public void accept(Visitor visitor) {}


    public void movePoint(int x, int y) {
        this.posX += x;
        this.posY += y;
    }
}
