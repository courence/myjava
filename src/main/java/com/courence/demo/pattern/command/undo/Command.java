package com.courence.demo.pattern.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
