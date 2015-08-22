package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_aqg {
	private final List a = Lists.newArrayList();
	private double b = 0.0D;
	private double c = 0.0D;
	private double d = 6.0E7D;
	private double e;
	private long f;
	private long g;
	private int h;
	private double i;
	private double j;
	private int k;
	private int l;

	public class_aqg() {
		e = d;
		h = 29999984;
		i = 0.2D;
		j = 5.0D;
		k = 15;
		l = 5;
	}

	public boolean a(class_cj var1) {
		return (var1.n() + 1 > this.b()) && (var1.n() < d()) && (var1.p() + 1 > this.c()) && (var1.p() < e());
	}

	public boolean a(class_agi var1) {
		return (var1.e() > this.b()) && (var1.c() < d()) && (var1.f() > this.c()) && (var1.d() < e());
	}

	public boolean a(class_ayk var1) {
		return (var1.d > this.b()) && (var1.a < d()) && (var1.f > this.c()) && (var1.c < e());
	}

	public double a(Entity var1) {
		return this.b(var1.s, var1.u);
	}

	public double b(double var1, double var3) {
		double var5 = var3 - this.c();
		double var7 = e() - var3;
		double var9 = var1 - this.b();
		double var11 = d() - var1;
		double var13 = Math.min(var9, var11);
		var13 = Math.min(var13, var5);
		return Math.min(var13, var7);
	}

	public class_aqf a() {
		return e < d ? class_aqf.b : (e > d ? class_aqf.a : class_aqf.c);
	}

	public double b() {
		double var1 = f() - (h() / 2.0D);
		if (var1 < (-h)) {
			var1 = (-h);
		}

		return var1;
	}

	public double c() {
		double var1 = g() - (h() / 2.0D);
		if (var1 < (-h)) {
			var1 = (-h);
		}

		return var1;
	}

	public double d() {
		double var1 = f() + (h() / 2.0D);
		if (var1 > h) {
			var1 = h;
		}

		return var1;
	}

	public double e() {
		double var1 = g() + (h() / 2.0D);
		if (var1 > h) {
			var1 = h;
		}

		return var1;
	}

	public double f() {
		return b;
	}

	public double g() {
		return c;
	}

	public void c(double var1, double var3) {
		b = var1;
		c = var3;
		Iterator var5 = k().iterator();

		while (var5.hasNext()) {
			class_aqe var6 = (class_aqe) var5.next();
			var6.a(this, var1, var3);
		}

	}

	public double h() {
		if (this.a() != class_aqf.c) {
			double var1 = (float) (System.currentTimeMillis() - g) / (float) (f - g);
			if (var1 < 1.0D) {
				return d + ((e - d) * var1);
			}

			this.a(e);
		}

		return d;
	}

	public long i() {
		return this.a() != class_aqf.c ? f - System.currentTimeMillis() : 0L;
	}

	public double j() {
		return e;
	}

	public void a(double var1) {
		d = var1;
		e = var1;
		f = System.currentTimeMillis();
		g = f;
		Iterator var3 = k().iterator();

		while (var3.hasNext()) {
			class_aqe var4 = (class_aqe) var3.next();
			var4.a(this, var1);
		}

	}

	public void a(double var1, double var3, long var5) {
		d = var1;
		e = var3;
		g = System.currentTimeMillis();
		f = g + var5;
		Iterator var7 = k().iterator();

		while (var7.hasNext()) {
			class_aqe var8 = (class_aqe) var7.next();
			var8.a(this, var1, var3, var5);
		}

	}

	protected List k() {
		return Lists.newArrayList((Iterable) a);
	}

	public void a(class_aqe var1) {
		a.add(var1);
	}

	public void a(int var1) {
		h = var1;
	}

	public int l() {
		return h;
	}

	public double m() {
		return j;
	}

	public void b(double var1) {
		j = var1;
		Iterator var3 = k().iterator();

		while (var3.hasNext()) {
			class_aqe var4 = (class_aqe) var3.next();
			var4.c(this, var1);
		}

	}

	public double n() {
		return i;
	}

	public void c(double var1) {
		i = var1;
		Iterator var3 = k().iterator();

		while (var3.hasNext()) {
			class_aqe var4 = (class_aqe) var3.next();
			var4.b(this, var1);
		}

	}

	public int p() {
		return k;
	}

	public void b(int var1) {
		k = var1;
		Iterator var2 = k().iterator();

		while (var2.hasNext()) {
			class_aqe var3 = (class_aqe) var2.next();
			var3.a(this, var1);
		}

	}

	public int q() {
		return l;
	}

	public void c(int var1) {
		l = var1;
		Iterator var2 = k().iterator();

		while (var2.hasNext()) {
			class_aqe var3 = (class_aqe) var2.next();
			var3.b(this, var1);
		}

	}
}
