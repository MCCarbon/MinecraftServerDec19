package net.minecraft.server;

import io.netty.util.internal.ThreadLocalRandom;

import java.util.UUID;

import org.apache.commons.lang3.Validate;

public class class_rr {
	private final double a;
	private final int b;
	private final String c;
	private final UUID d;
	private boolean e;

	public class_rr(String var1, double var2, int var4) {
		this(MathHelper.a(ThreadLocalRandom.current()), var1, var2, var4);
	}

	public class_rr(UUID var1, String var2, double var3, int var5) {
		e = true;
		d = var1;
		c = var2;
		a = var3;
		b = var5;
		Validate.notEmpty((CharSequence) var2, "Modifier name cannot be empty", new Object[0]);
		Validate.inclusiveBetween(0L, 2L, var5, "Invalid operation");
	}

	public UUID a() {
		return d;
	}

	public String b() {
		return c;
	}

	public int c() {
		return b;
	}

	public double d() {
		return a;
	}

	public boolean e() {
		return e;
	}

	public class_rr a(boolean var1) {
		e = var1;
		return this;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if ((var1 != null) && (this.getClass() == var1.getClass())) {
			class_rr var2 = (class_rr) var1;
			if (d != null) {
				if (!d.equals(var2.d)) {
					return false;
				}
			} else if (var2.d != null) {
				return false;
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return d != null ? d.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "AttributeModifier{amount=" + a + ", operation=" + b + ", name=\'" + c + '\'' + ", id=" + d + ", serialize=" + e + '}';
	}
}
