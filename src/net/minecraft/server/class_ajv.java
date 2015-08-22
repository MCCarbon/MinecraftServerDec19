package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_ajv extends class_ail {
	public static final class_apz a;
	public static final class_apy b;

	public class_ajv() {
		super(class_avq.e, class_avr.C);
		this.j(M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)));
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public void j() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, class_qx var6) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		if (((Boolean) var1.p(var2).b(b)).booleanValue()) {
			this.a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		this.j();
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(a, var8.aV().d()).a(b, Boolean.valueOf(false));
	}

	@Override
	public boolean Q() {
		return true;
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		return ((Boolean) var1.p(var2).b(b)).booleanValue() ? 15 : 0;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(b, Boolean.valueOf((var1 & 4) != 0)).a(a, class_cq.b(var1 & 3));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(a)).b();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 4;
		}

		return var3;
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b });
	}

	static {
		a = class_akx.O;
		b = class_apy.a("eye");
	}
}
