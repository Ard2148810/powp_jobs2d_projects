package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.drivers.MacroDriverDecorator;

public class MacroFeature {

    private static MacroDriverDecorator macroDriverDecorator;

    public static void setupMacroDriverDecorator() {
        macroDriverDecorator = new MacroDriverDecorator();
    }

    public static MacroDriverDecorator getMacroDriverDecorator() {
        return macroDriverDecorator;
    }
}
