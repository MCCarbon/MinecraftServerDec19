package net.minecraft.server;

import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_km extends PrintStream {
	private static final Logger a = LogManager.getLogger();
	private final String b;

	public class_km(String var1, OutputStream var2) {
		super(var2);
		b = var1;
	}

	@Override
	public void println(String var1) {
		a(var1);
	}

	@Override
	public void println(Object var1) {
		a(String.valueOf(var1));
	}

	private void a(String var1) {
		StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
		StackTraceElement var3 = var2[Math.min(3, var2.length)];
		a.info("[{}]@.({}:{}): {}", new Object[] { b, var3.getFileName(), Integer.valueOf(var3.getLineNumber()), var1 });
	}
}
