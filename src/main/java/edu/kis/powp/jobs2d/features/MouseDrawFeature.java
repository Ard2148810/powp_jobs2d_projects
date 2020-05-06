package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseDrawFeature {
    private static final int WIDTH = 268;
    private static final int HEIGHT = 226;

    public static void SetMouseListener(JPanel panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int x = mouseEvent.getX() - WIDTH;
                int y = mouseEvent.getY() - HEIGHT;
                Job2dDriver driver = DriverFeature.getDriverManager().getCurrentDriver();
                if(SwingUtilities.isLeftMouseButton(mouseEvent))
                {
                    driver.operateTo(x, y);

                }else if(SwingUtilities.isRightMouseButton(mouseEvent))
                {
                    driver.setPosition(x, y);
                }
            }
        });
    }
}
