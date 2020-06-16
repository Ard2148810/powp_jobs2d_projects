package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

import java.util.ArrayList;
import java.util.List;

public class MacroDriver implements Job2dDriver {
    private List<DriverCommand> driverCommandList = new ArrayList<>();
    private DriverComposite driverComposite;

    @Override
    public void setPosition(int x, int y) {
        driverCommandList.add(new SetPositionCommand(x, y));
        driverComposite.setPosition(x,y);
    }

    @Override
    public void operateTo(int x, int y) {
        driverCommandList.add(new OperateToCommand(x, y));
        driverComposite.operateTo(x,y);
    }

    public DriverComposite getDriverComposite() {
        return driverComposite;
    }

    public void setDriverComposite(DriverComposite driverComposite) {
        this.driverComposite = driverComposite;
    }

    public List<DriverCommand> getDriverCommandList() {
        return new ArrayList<>(driverCommandList);
    }

    public void clearMemory() {
        driverCommandList.clear();
    }

    @Override
    public String toString() {
        return "Macro";
    }
}
