package net.minecraft.server;

public final class class_ko extends RuntimeException {
	public static final class_ko a = new class_ko();

	private class_ko() {
		setStackTrace(new StackTraceElement[0]);
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		setStackTrace(new StackTraceElement[0]);
		return this;
	}
}
