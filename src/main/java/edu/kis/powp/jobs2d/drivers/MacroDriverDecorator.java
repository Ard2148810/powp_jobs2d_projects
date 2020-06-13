package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

import java.util.ArrayList;
import java.util.List;

public class MacroDriverDecorator implements Job2dDriver {
    private List<DriverCommand> driverCommandList = new ArrayList<>();
    private Job2dDriver job2dDriver;

    public void setCoreJob2dDriver(Job2dDriver job2dDriver) {
        this.job2dDriver = job2dDriver;
    }

    public Job2dDriver getCoreJob2dDriver() {
        return job2dDriver;
    }

    public List<DriverCommand> getDriverCommandList() {
        return new ArrayList<>(driverCommandList);
    }

    public void clearMemory() {
        driverCommandList.clear();
    }

    @Override
    public void setPosition(int x, int y) {
        driverCommandList.add(new SetPositionCommand(x, y));
    }

    @Override
    public void operateTo(int x, int y) {
        driverCommandList.add(new OperateToCommand(x, y));
    }

    @Override
    public String toString() {
        return "Macro";
    }
}
