package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_aip extends class_aif {
	public static final class_apy[] a = new class_apy[] { class_apy.a("has_bottle_0"), class_apy.a("has_bottle_1"), class_apy.a("has_bottle_2") };

	public class_aip() {
		super(class_avq.f);
		this.j(M.b().a(a[0], Boolean.valueOf(false)).a(a[1], Boolean.valueOf(false)).a(a[2], Boolean.valueOf(false)));
	}

	@Override
	public String f() {
		return class_di.a("item.brewingStand.name");
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		return new class_aoj();
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, class_qx var6) {
		this.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.j();
		super.a(var1, var2, var3, var4, var5, var6);
	}

	@Override
	public void j() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			class_aoi var11 = var1.s(var2);
			if (var11 instanceof class_aoj) {
				var4.a((class_pp) ((class_aoj) var11));
				var4.b(class_nh.N);
			}

			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		if (var5.s()) {
			class_aoi var6 = var1.s(var2);
			if (var6 instanceof class_aoj) {
				((class_aoj) var6).a(var5.q());
			}
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		class_aoi var4 = var1.s(var2);
		if (var4 instanceof class_aoj) {
			class_pr.a(var1, var2, (class_aoj) var4);
		}

		super.c(var1, var2, var3);
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.bK;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(class_acq.bK);
	}

	@Override
	public boolean Q() {
		return true;
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		return class_zu.a(var1.s(var2));
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = S();

		for (int var3 = 0; var3 < 3; ++var3) {
			var2 = var2.a(a[var3], Boolean.valueOf((var1 & (1 << var3)) > 0));
		}

		return var2;
	}

	@Override
	public int c(class_apn var1) {
		int var2 = 0;

		for (int var3 = 0; var3 < 3; ++var3) {
			if (((Boolean) var1.b(a[var3])).booleanValue()) {
				var2 |= 1 << var3;
			}
		}

		return var2;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a[0], a[1], a[2] });
	}
}
