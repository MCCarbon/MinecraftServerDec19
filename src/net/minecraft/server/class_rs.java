package net.minecraft.server;


public abstract class class_rs implements class_rp {
	private final class_rp a;
	private final String b;
	private final double c;
	private boolean d;

	protected class_rs(class_rp var1, String var2, double var3) {
		a = var1;
		b = var2;
		c = var3;
		if (var2 == null) {
			throw new IllegalArgumentException("Name cannot be null!");
		}
	}

	@Override
	public String a() {
		return b;
	}

	@Override
	public double b() {
		return c;
	}

	@Override
	public boolean c() {
		return d;
	}

	public class_rs a(boolean var1) {
		d = var1;
		return this;
	}

	@Override
	public class_rp d() {
		return a;
	}

	@Override
	public int hashCode() {
		return b.hashCode();
	}

	@Override
	public boolean equals(Object var1) {
		return (var1 instanceof class_rp) && b.equals(((class_rp) var1).a());
	}
}
