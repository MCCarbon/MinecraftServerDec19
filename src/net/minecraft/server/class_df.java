package net.minecraft.server;

import com.google.common.base.Objects;

public class class_df implements Comparable {
	public static final class_df b = new class_df(0, 0, 0);
	private final int a;
	private final int c;
	private final int d;

	public class_df(int var1, int var2, int var3) {
		a = var1;
		c = var2;
		d = var3;
	}

	public class_df(double var1, double var3, double var5) {
		this(class_oa.c(var1), class_oa.c(var3), class_oa.c(var5));
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_df)) {
			return false;
		} else {
			class_df var2 = (class_df) var1;
			return n() != var2.n() ? false : (o() != var2.o() ? false : p() == var2.p());
		}
	}

	@Override
	public int hashCode() {
		return ((o() + (p() * 31)) * 31) + n();
	}

	public int g(class_df var1) {
		return o() == var1.o() ? (p() == var1.p() ? n() - var1.n() : p() - var1.p()) : o() - var1.o();
	}

	public int n() {
		return a;
	}

	public int o() {
		return c;
	}

	public int p() {
		return d;
	}

	public class_df d(class_df var1) {
		return new class_df((o() * var1.p()) - (p() * var1.o()), (p() * var1.n()) - (n() * var1.p()), (n() * var1.o()) - (o() * var1.n()));
	}

	public double d(int var1, int var2, int var3) {
		double var4 = n() - var1;
		double var6 = o() - var2;
		double var8 = p() - var3;
		return Math.sqrt((var4 * var4) + (var6 * var6) + (var8 * var8));
	}

	public double c(double var1, double var3, double var5) {
		double var7 = n() - var1;
		double var9 = o() - var3;
		double var11 = p() - var5;
		return (var7 * var7) + (var9 * var9) + (var11 * var11);
	}

	public double d(double var1, double var3, double var5) {
		double var7 = (n() + 0.5D) - var1;
		double var9 = (o() + 0.5D) - var3;
		double var11 = (p() + 0.5D) - var5;
		return (var7 * var7) + (var9 * var9) + (var11 * var11);
	}

	public double i(class_df var1) {
		return c(var1.n(), var1.o(), var1.p());
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("x", n()).add("y", o()).add("z", p()).toString();
	}

	// $FF: synthetic method
	@Override
	public int compareTo(Object var1) {
		return g((class_df) var1);
	}
}
