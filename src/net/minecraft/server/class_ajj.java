package net.minecraft.server;

import java.util.Random;

public abstract class class_ajj extends class_akx {
	protected final boolean N;

	protected class_ajj(boolean var1) {
		super(class_avq.q);
		N = var1;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return class_ago.a(var1, var2.b()) ? super.c(var1, var2) : false;
	}

	public boolean d(class_ago var1, class_cj var2) {
		return class_ago.a(var1, var2.b());
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Random var4) {
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!this.b((class_ags) var1, var2, var3)) {
			boolean var5 = this.f(var1, var2, var3);
			if (N && !var5) {
				var1.a(var2, this.k(var3), 2);
			} else if (!N) {
				var1.a(var2, this.e(var3), 2);
				if (!var5) {
					var1.a(var2, this.e(var3).c(), m(var3), -1);
				}
			}

		}
	}

	protected boolean l(class_apn var1) {
		return N;
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return this.a(var1, var2, var3, var4);
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return !l(var3) ? 0 : (var3.b(O) == var4 ? this.a(var1, var2, var3) : 0);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (this.d(var1, var2)) {
			h(var1, var2, var3);
		} else {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			class_cq[] var5 = class_cq.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				class_cq var8 = var5[var7];
				var1.d(var2.a(var8), this);
			}

		}
	}

	protected void h(class_ago var1, class_cj var2, class_apn var3) {
		if (!this.b((class_ags) var1, var2, var3)) {
			boolean var4 = this.f(var1, var2, var3);
			if (((N && !var4) || (!N && var4)) && !var1.a(var2, this)) {
				byte var5 = -1;
				if (this.j(var1, var2, var3)) {
					var5 = -3;
				} else if (N) {
					var5 = -2;
				}

				var1.a(var2, this, this.d(var3), var5);
			}

		}
	}

	public boolean b(class_ags var1, class_cj var2, class_apn var3) {
		return false;
	}

	protected boolean f(class_ago var1, class_cj var2, class_apn var3) {
		return this.g(var1, var2, var3) > 0;
	}

	protected int g(class_ago var1, class_cj var2, class_apn var3) {
		class_cq var4 = (class_cq) var3.b(O);
		class_cj var5 = var2.a(var4);
		int var6 = var1.c(var5, var4);
		if (var6 >= 15) {
			return var6;
		} else {
			class_apn var7 = var1.p(var5);
			return Math.max(var6, var7.c() == Blocks.af ? ((Integer) var7.b(BlockRedstoneWire.P)).intValue() : 0);
		}
	}

	protected int c(class_ags var1, class_cj var2, class_apn var3) {
		class_cq var4 = (class_cq) var3.b(O);
		class_cq var5 = var4.e();
		class_cq var6 = var4.f();
		return Math.max(this.c(var1, var2.a(var5), var5), this.c(var1, var2.a(var6), var6));
	}

	protected int c(class_ags var1, class_cj var2, class_cq var3) {
		class_apn var4 = var1.p(var2);
		Block var5 = var4.c();
		return this.c(var5) ? (var5 == Blocks.af ? ((Integer) var4.b(BlockRedstoneWire.P)).intValue() : var1.a(var2, var3)) : 0;
	}

	@Override
	public boolean i() {
		return true;
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(O, var8.aV().d());
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		if (this.f(var1, var2, var3)) {
			var1.a(var2, this, 1);
		}

	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		this.i(var1, var2, var3);
	}

	protected void i(class_ago var1, class_cj var2, class_apn var3) {
		class_cq var4 = (class_cq) var3.b(O);
		class_cj var5 = var2.a(var4.d());
		var1.e(var5, this);
		var1.a(var5, this, var4);
	}

	@Override
	public void e(class_ago var1, class_cj var2, class_apn var3) {
		if (N) {
			class_cq[] var4 = class_cq.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				class_cq var7 = var4[var6];
				var1.d(var2.a(var7), this);
			}
		}

		super.e(var1, var2, var3);
	}

	@Override
	public boolean c() {
		return false;
	}

	protected boolean c(Block var1) {
		return var1.i();
	}

	protected int a(class_ags var1, class_cj var2, class_apn var3) {
		return 15;
	}

	public static boolean d(Block var0) {
		return Blocks.bb.e(var0) || Blocks.cj.e(var0);
	}

	public boolean e(Block var1) {
		return (var1 == this.e(S()).c()) || (var1 == this.k(S()).c());
	}

	public boolean j(class_ago var1, class_cj var2, class_apn var3) {
		class_cq var4 = ((class_cq) var3.b(O)).d();
		class_cj var5 = var2.a(var4);
		return d(var1.p(var5).c()) ? var1.p(var5).b(O) != var4 : false;
	}

	protected int m(class_apn var1) {
		return this.d(var1);
	}

	protected abstract int d(class_apn var1);

	protected abstract class_apn e(class_apn var1);

	protected abstract class_apn k(class_apn var1);

	@Override
	public boolean b(Block var1) {
		return this.e(var1);
	}
}
