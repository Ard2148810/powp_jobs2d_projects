package edu.kis.powp.jobs2d.command;

public interface Visitor {
	void visit(OperateToCommand driver);

	void visit(SetPositionCommand driver);

	void visit(ICompoundCommand driver);
}
