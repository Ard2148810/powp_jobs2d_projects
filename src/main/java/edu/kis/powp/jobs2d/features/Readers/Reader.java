package edu.kis.powp.jobs2d.features.Readers;

import edu.kis.powp.jobs2d.command.ComplexCommand;

public interface Reader {
    public ComplexCommand read(String contentToParse);
}
