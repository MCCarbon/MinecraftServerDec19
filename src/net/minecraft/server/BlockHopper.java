package net.minecraft.server;

import java.util.List;

import com.google.common.base.Predicate;

public class BlockHopper extends class_aif {
	public static final class_apz a = class_apz.a("facing", new Predicate() {
		public boolean a(class_cq var1) {
			return var1 != class_cq.b;
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_cq) var1);
		}
	});
	public static final class_apy b = class_apy.a("enabled");

	public BlockHopper() {
		super(class_avq.f, class_avr.m);
		this.j(M.b().a(a, class_cq.a).a(b, Boolean.valueOf(true)));
		this.a(class_abp.d);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, Entity var6) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		float var7 = 0.125F;
		this.a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
		super.a(var1, var2, var3, var4, var5, var6);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		class_cq var9 = var3.d();
		if (var9 == class_cq.b) {
			var9 = class_cq.a;
		}

		return getBlockData().a(a, var9).a(b, Boolean.valueOf(true));
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aov();
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, EntityLiving var4, class_aco var5) {
		super.a(var1, var2, var3, var4, var5);
		if (var5.s()) {
			TileEntity var6 = var1.s(var2);
			if (var6 instanceof class_aov) {
				((class_aov) var6).a(var5.q());
			}
		}

	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		this.f(var1, var2, var3);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			TileEntity var11 = var1.s(var2);
			if (var11 instanceof class_aov) {
				var4.a((class_pp) ((class_aov) var11));
				var4.b(StatisticList.Q);
			}

			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		this.f(var1, var2, var3);
	}

	private void f(class_ago var1, class_cj var2, class_apn var3) {
		boolean var4 = !var1.z(var2);
		if (var4 != ((Boolean) var3.b(b)).booleanValue()) {
			var1.a(var2, var3.a(b, Boolean.valueOf(var4)), 4);
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		TileEntity var4 = var1.s(var2);
		if (var4 instanceof class_aov) {
			class_pr.a(var1, var2, (class_aov) var4);
			var1.f(var2, this);
		}

		super.c(var1, var2, var3);
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	public static class_cq b(int var0) {
		return class_cq.a(var0 & 7);
	}

	public static boolean f(int var0) {
		return (var0 & 8) != 8;
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
		return getBlockData().a(a, b(var1)).a(b, Boolean.valueOf(f(var1)));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(a)).a();
		if (!((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b });
	}
}
