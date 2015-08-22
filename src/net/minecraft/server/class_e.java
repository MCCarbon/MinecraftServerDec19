package net.minecraft.server;


public class class_e extends RuntimeException {
	private final class_b a;

	public class_e(class_b var1) {
		a = var1;
	}

	public class_b a() {
		return a;
	}

	@Override
	public Throwable getCause() {
		return a.b();
	}

	@Override
	public String getMessage() {
		return a.a();
	}
}
