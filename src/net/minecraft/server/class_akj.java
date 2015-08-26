package net.minecraft.server;

import java.util.Random;

public class class_akj extends class_aif {
	public static final class_apz a;
	private final boolean b;
	private static boolean N;

	protected class_akj(boolean var1) {
		super(class_avq.e);
		this.j(M.b().a(a, class_cq.c));
		b = var1;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(Blocks.FURNACE);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		this.f(var1, var2, var3);
	}

	private void f(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			Block var4 = var1.p(var2.c()).c();
			Block var5 = var1.p(var2.d()).c();
			Block var6 = var1.p(var2.e()).c();
			Block var7 = var1.p(var2.f()).c();
			class_cq var8 = (class_cq) var3.b(a);
			if ((var8 == class_cq.c) && var4.q() && !var5.q()) {
				var8 = class_cq.d;
			} else if ((var8 == class_cq.d) && var5.q() && !var4.q()) {
				var8 = class_cq.c;
			} else if ((var8 == class_cq.e) && var6.q() && !var7.q()) {
				var8 = class_cq.f;
			} else if ((var8 == class_cq.f) && var7.q() && !var6.q()) {
				var8 = class_cq.e;
			}

			var1.a(var2, var3.a(a, var8), 2);
		}
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			TileEntity var11 = var1.s(var2);
			if (var11 instanceof class_aot) {
				var4.a((class_pp) ((class_aot) var11));
				var4.b(class_nh.Z);
			}

			return true;
		}
	}

	public static void a(boolean var0, class_ago var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		TileEntity var4 = var1.s(var2);
		N = true;
		if (var0) {
			var1.a(var2, Blocks.LIT_FURNACE.S().a(a, var3.b(a)), 3);
			var1.a(var2, Blocks.LIT_FURNACE.S().a(a, var3.b(a)), 3);
		} else {
			var1.a(var2, Blocks.FURNACE.S().a(a, var3.b(a)), 3);
			var1.a(var2, Blocks.FURNACE.S().a(a, var3.b(a)), 3);
		}

		N = false;
		if (var4 != null) {
			var4.D();
			var1.a(var2, var4);
		}

	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aot();
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(a, var8.aV().d());
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		var1.a(var2, var3.a(a, var4.aV().d()), 2);
		if (var5.s()) {
			TileEntity var6 = var1.s(var2);
			if (var6 instanceof class_aot) {
				((class_aot) var6).a(var5.q());
			}
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		if (!N) {
			TileEntity var4 = var1.s(var2);
			if (var4 instanceof class_aot) {
				class_pr.a(var1, var2, (class_aot) var4);
				var1.f(var2, this);
			}
		}

		super.c(var1, var2, var3);
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
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Blocks.FURNACE);
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public class_apn a(int var1) {
		class_cq var2 = class_cq.a(var1);
		if (var2.k() == class_cq.class_a_in_class_cq.b) {
			var2 = class_cq.c;
		}

		return S().a(a, var2);
	}

	@Override
	public int c(class_apn var1) {
		return ((class_cq) var1.b(a)).a();
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
		return new class_apo(this, new class_aqc[] { a });
	}

	static {
		a = class_akx.O;
	}
}
