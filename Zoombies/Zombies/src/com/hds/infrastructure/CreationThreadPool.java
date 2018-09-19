package com.hds.infrastructure;

public abstract interface CreationThreadPool {
	public abstract void processCommand() throws RuntimeException;
}
