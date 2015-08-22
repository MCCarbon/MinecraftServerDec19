package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class class_aiy extends class_ail {
	public static final class_apy a = class_apy.a("north");
	public static final class_apy b = class_apy.a("east");
	public static final class_apy N = class_apy.a("south");
	public static final class_apy O = class_apy.a("west");
	public static final class_apy P = class_apy.a("up");
	public static final class_apy Q = class_apy.a("down");

	protected class_aiy() {
		super(class_avq.k);
		this.a(class_abp.c);
		this.j(M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, Boolean.valueOf(false)));
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		class_ail var4 = var2.p(var3.b()).c();
		class_ail var5 = var2.p(var3.a()).c();
		class_ail var6 = var2.p(var3.c()).c();
		class_ail var7 = var2.p(var3.f()).c();
		class_ail var8 = var2.p(var3.d()).c();
		class_ail var9 = var2.p(var3.e()).c();
		return var1.a(Q, Boolean.valueOf((var4 == this) || (var4 == class_aim.cS) || (var4 == class_aim.bH))).a(P, Boolean.valueOf((var5 == this) || (var5 == class_aim.cS))).a(a, Boolean.valueOf((var6 == this) || (var6 == class_aim.cS))).a(b, Boolean.valueOf((var7 == this) || (var7 == class_aim.cS))).a(N, Boolean.valueOf((var8 == this) || (var8 == class_aim.cS))).a(O, Boolean.valueOf((var9 == this) || (var9 == class_aim.cS)));
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_apn var3 = this.a(var1.p(var2), var1, var2);
		float var4 = 0.1875F;
		float var5 = ((Boolean) var3.b(O)).booleanValue() ? 0.0F : 0.1875F;
		float var6 = ((Boolean) var3.b(Q)).booleanValue() ? 0.0F : 0.1875F;
		float var7 = ((Boolean) var3.b(a)).booleanValue() ? 0.0F : 0.1875F;
		float var8 = ((Boolean) var3.b(b)).booleanValue() ? 1.0F : 0.8125F;
		float var9 = ((Boolean) var3.b(P)).booleanValue() ? 1.0F : 0.8125F;
		float var10 = ((Boolean) var3.b(N)).booleanValue() ? 1.0F : 0.8125F;
		this.a(var5, var6, var7, var8, var9, var10);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, class_qx var6) {
		var3 = this.a(var3, var1, var2);
		float var7 = 0.1875F;
		float var8 = 0.8125F;
		this.a(0.1875F, 0.1875F, 0.1875F, 0.8125F, 0.8125F, 0.8125F);
		super.a(var1, var2, var3, var4, var5, var6);
		if (((Boolean) var3.b(O)).booleanValue()) {
			this.a(0.0F, 0.1875F, 0.1875F, 0.1875F, 0.8125F, 0.8125F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if (((Boolean) var3.b(b)).booleanValue()) {
			this.a(0.8125F, 0.1875F, 0.1875F, 1.0F, 0.8125F, 0.8125F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if (((Boolean) var3.b(P)).booleanValue()) {
			this.a(0.1875F, 0.8125F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if (((Boolean) var3.b(Q)).booleanValue()) {
			this.a(0.1875F, 0.0F, 0.1875F, 0.8125F, 0.1875F, 0.8125F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if (((Boolean) var3.b(a)).booleanValue()) {
			this.a(0.1875F, 0.1875F, 0.0F, 0.8125F, 0.8125F, 0.1875F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if (((Boolean) var3.b(N)).booleanValue()) {
			this.a(0.1875F, 0.1875F, 0.8125F, 0.8125F, 0.8125F, 1.0F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}

	@Override
	public int c(class_apn var1) {
		return 0;
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!this.d(var1, var2)) {
			var1.b(var2, true);
		}

	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.cL;
	}

	@Override
	public int a(Random var1) {
		return var1.nextInt(2);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return super.a(var1, var2, var3);
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return super.c(var1, var2) ? this.d(var1, var2) : false;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		if (!this.d(var1, var2)) {
			var1.a(var2, this, 1);
		}

	}

	public boolean d(class_ago var1, class_cj var2) {
		boolean var3 = var1.d(var2.a());
		boolean var4 = var1.d(var2.b());
		Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

		class_ail var9;
		do {
			class_cj var7;
			class_ail var8;
			do {
				if (!var5.hasNext()) {
					class_ail var10 = var1.p(var2.b()).c();
					if ((var10 != this) && (var10 != class_aim.bH)) {
						return false;
					}

					return true;
				}

				class_cq var6 = (class_cq) var5.next();
				var7 = var2.a(var6);
				var8 = var1.p(var7).c();
			} while (var8 != this);

			if (!var3 && !var4) {
				return false;
			}

			var9 = var1.p(var7.b()).c();
		} while ((var9 != this) && (var9 != class_aim.bH));

		return true;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, N, O, P, Q });
	}
}
