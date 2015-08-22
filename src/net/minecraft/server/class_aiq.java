package net.minecraft.server;

import java.util.Random;

public class class_aiq extends class_ail {
	protected class_aiq() {
		this(class_avq.k);
	}

	protected class_aiq(class_avq var1) {
		this(var1, var1.r());
	}

	protected class_aiq(class_avq var1, class_avr var2) {
		super(var1, var2);
		this.a(true);
		float var3 = 0.2F;
		this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
		this.a(class_abp.c);
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return super.c(var1, var2) && this.c(var1.p(var2.b()).c());
	}

	protected boolean c(class_ail var1) {
		return (var1 == class_aim.c) || (var1 == class_aim.d) || (var1 == class_aim.ak);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		super.a(var1, var2, var3, var4);
		this.f(var1, var2, var3);
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		this.f(var1, var2, var3);
	}

	protected void f(class_ago var1, class_cj var2, class_apn var3) {
		if (!this.g(var1, var2, var3)) {
			this.b(var1, var2, var3, 0);
			var1.a(var2, class_aim.a.S(), 3);
		}

	}

	public boolean g(class_ago var1, class_cj var2, class_apn var3) {
		return this.c(var1.p(var2.b()).c());
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}
}
