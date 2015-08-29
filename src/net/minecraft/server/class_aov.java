package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_aov extends class_aow implements class_aou, class_ks {
	private class_aco[] a = new class_aco[5];
	private String f;
	private int g = -1;

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		class_du var2 = var1.c("Items", 10);
		a = new class_aco[n_()];
		if (var1.b("CustomName", 8)) {
			f = var1.l("CustomName");
		}

		g = var1.h("TransferCooldown");

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			byte var5 = var4.f("Slot");
			if ((var5 >= 0) && (var5 < a.length)) {
				a[var5] = class_aco.a(var4);
			}
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		class_du var2 = new class_du();

		for (int var3 = 0; var3 < a.length; ++var3) {
			if (a[var3] != null) {
				class_dn var4 = new class_dn();
				var4.a("Slot", (byte) var3);
				a[var3].b(var4);
				var2.a(var4);
			}
		}

		var1.a("Items", var2);
		var1.a("TransferCooldown", g);
		if (k_()) {
			var1.a("CustomName", f);
		}

	}

	@Override
	public int n_() {
		return a.length;
	}

	@Override
	public class_aco a(int var1) {
		return a[var1];
	}

	@Override
	public class_aco a(int var1, int var2) {
		if (a[var1] != null) {
			class_aco var3;
			if (a[var1].b <= var2) {
				var3 = a[var1];
				a[var1] = null;
				return var3;
			} else {
				var3 = a[var1].a(var2);
				if (a[var1].b == 0) {
					a[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public class_aco b(int var1) {
		if (a[var1] != null) {
			class_aco var2 = a[var1];
			a[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		a[var1] = var2;
		if ((var2 != null) && (var2.b > p_())) {
			var2.b = p_();
		}

	}

	@Override
	public String e_() {
		return k_() ? f : "container.hopper";
	}

	@Override
	public boolean k_() {
		return (f != null) && !f.isEmpty();
	}

	public void a(String var1) {
		f = var1;
	}

	@Override
	public int p_() {
		return 64;
	}

	@Override
	public boolean a(class_yu var1) {
		return b.s(c) != this ? false : var1.e(c.n() + 0.5D, c.o() + 0.5D, c.p() + 0.5D) <= 64.0D;
	}

	@Override
	public void b(class_yu var1) {
	}

	@Override
	public void c(class_yu var1) {
	}

	@Override
	public boolean b(int var1, class_aco var2) {
		return true;
	}

	@Override
	public void c() {
		if ((b != null) && !b.D) {
			--g;
			if (!n()) {
				d(0);
				m();
			}

		}
	}

	public boolean m() {
		if ((b != null) && !b.D) {
			if (!n() && BlockHopper.f(u())) {
				boolean var1 = false;
				if (!p()) {
					var1 = r();
				}

				if (!q()) {
					var1 = a(this) || var1;
				}

				if (var1) {
					d(8);
					o_();
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}

	private boolean p() {
		class_aco[] var1 = a;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_aco var4 = var1[var3];
			if (var4 != null) {
				return false;
			}
		}

		return true;
	}

	private boolean q() {
		class_aco[] var1 = a;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_aco var4 = var1[var3];
			if ((var4 == null) || (var4.b != var4.c())) {
				return false;
			}
		}

		return true;
	}

	private boolean r() {
		class_pp var1 = H();
		if (var1 == null) {
			return false;
		} else {
			class_cq var2 = BlockHopper.b(u()).d();
			if (this.a(var1, var2)) {
				return false;
			} else {
				for (int var3 = 0; var3 < n_(); ++var3) {
					if (this.a(var3) != null) {
						class_aco var4 = this.a(var3).k();
						class_aco var5 = a(var1, this.a(var3, 1), var2);
						if ((var5 == null) || (var5.b == 0)) {
							var1.o_();
							return true;
						}

						this.a(var3, var4);
					}
				}

				return false;
			}
		}
	}

	private boolean a(class_pp var1, class_cq var2) {
		if (var1 instanceof class_qf) {
			class_qf var7 = (class_qf) var1;
			int[] var8 = var7.a(var2);

			for (int var9 = 0; var9 < var8.length; ++var9) {
				class_aco var6 = var7.a(var8[var9]);
				if ((var6 == null) || (var6.b != var6.c())) {
					return false;
				}
			}
		} else {
			int var3 = var1.n_();

			for (int var4 = 0; var4 < var3; ++var4) {
				class_aco var5 = var1.a(var4);
				if ((var5 == null) || (var5.b != var5.c())) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean b(class_pp var0, class_cq var1) {
		if (var0 instanceof class_qf) {
			class_qf var2 = (class_qf) var0;
			int[] var3 = var2.a(var1);

			for (int var4 = 0; var4 < var3.length; ++var4) {
				if (var2.a(var3[var4]) != null) {
					return false;
				}
			}
		} else {
			int var5 = var0.n_();

			for (int var6 = 0; var6 < var5; ++var6) {
				if (var0.a(var6) != null) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean a(class_aou var0) {
		class_pp var1 = b(var0);
		if (var1 != null) {
			class_cq var2 = class_cq.a;
			if (b(var1, var2)) {
				return false;
			}

			if (var1 instanceof class_qf) {
				class_qf var3 = (class_qf) var1;
				int[] var4 = var3.a(var2);

				for (int var5 = 0; var5 < var4.length; ++var5) {
					if (a(var0, var1, var4[var5], var2)) {
						return true;
					}
				}
			} else {
				int var7 = var1.n_();

				for (int var9 = 0; var9 < var7; ++var9) {
					if (a(var0, var1, var9, var2)) {
						return true;
					}
				}
			}
		} else {
			Iterator var6 = a(var0.z(), var0.A(), var0.B() + 1.0D, var0.C()).iterator();

			while (var6.hasNext()) {
				EntityItem var8 = (EntityItem) var6.next();
				if (a(var0, var8)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean a(class_aou var0, class_pp var1, int var2, class_cq var3) {
		class_aco var4 = var1.a(var2);
		if ((var4 != null) && b(var1, var4, var2, var3)) {
			class_aco var5 = var4.k();
			class_aco var6 = a(var0, var1.a(var2, 1), (class_cq) null);
			if ((var6 == null) || (var6.b == 0)) {
				var1.o_();
				return true;
			}

			var1.a(var2, var5);
		}

		return false;
	}

	public static boolean a(class_pp var0, EntityItem var1) {
		boolean var2 = false;
		if (var1 == null) {
			return false;
		} else {
			class_aco var3 = var1.j().k();
			class_aco var4 = a(var0, var3, (class_cq) null);
			if ((var4 != null) && (var4.b != 0)) {
				var1.a(var4);
			} else {
				var2 = true;
				var1.L();
			}

			return var2;
		}
	}

	public static class_aco a(class_pp var0, class_aco var1, class_cq var2) {
		if ((var0 instanceof class_qf) && (var2 != null)) {
			class_qf var6 = (class_qf) var0;
			int[] var7 = var6.a(var2);

			for (int var5 = 0; (var5 < var7.length) && (var1 != null) && (var1.b > 0); ++var5) {
				var1 = c(var0, var1, var7[var5], var2);
			}
		} else {
			int var3 = var0.n_();

			for (int var4 = 0; (var4 < var3) && (var1 != null) && (var1.b > 0); ++var4) {
				var1 = c(var0, var1, var4, var2);
			}
		}

		if ((var1 != null) && (var1.b == 0)) {
			var1 = null;
		}

		return var1;
	}

	private static boolean a(class_pp var0, class_aco var1, int var2, class_cq var3) {
		return !var0.b(var2, var1) ? false : !(var0 instanceof class_qf) || ((class_qf) var0).a(var2, var1, var3);
	}

	private static boolean b(class_pp var0, class_aco var1, int var2, class_cq var3) {
		return !(var0 instanceof class_qf) || ((class_qf) var0).b(var2, var1, var3);
	}

	private static class_aco c(class_pp var0, class_aco var1, int var2, class_cq var3) {
		class_aco var4 = var0.a(var2);
		if (a(var0, var1, var2, var3)) {
			boolean var5 = false;
			if (var4 == null) {
				var0.a(var2, var1);
				var1 = null;
				var5 = true;
			} else if (a(var4, var1)) {
				int var6 = var1.c() - var4.b;
				int var7 = Math.min(var1.b, var6);
				var1.b -= var7;
				var4.b += var7;
				var5 = var7 > 0;
			}

			if (var5) {
				if (var0 instanceof class_aov) {
					class_aov var8 = (class_aov) var0;
					if (var8.o()) {
						var8.d(8);
					}

					var0.o_();
				}

				var0.o_();
			}
		}

		return var1;
	}

	private class_pp H() {
		class_cq var1 = BlockHopper.b(u());
		return b(z(), c.n() + var1.g(), c.o() + var1.h(), c.p() + var1.i());
	}

	public static class_pp b(class_aou var0) {
		return b(var0.z(), var0.A(), var0.B() + 1.0D, var0.C());
	}

	public static List a(class_ago var0, double var1, double var3, double var5) {
		return var0.a(EntityItem.class, new class_ayk(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D), class_rb.a);
	}

	public static class_pp b(class_ago var0, double var1, double var3, double var5) {
		Object var7 = null;
		int var8 = MathHelper.c(var1);
		int var9 = MathHelper.c(var3);
		int var10 = MathHelper.c(var5);
		class_cj var11 = new class_cj(var8, var9, var10);
		Block var12 = var0.p(var11).c();
		if (var12.B()) {
			TileEntity var13 = var0.s(var11);
			if (var13 instanceof class_pp) {
				var7 = var13;
				if ((var7 instanceof class_aok) && (var12 instanceof BlockChest)) {
					var7 = ((BlockChest) var12).e(var0, var11);
				}
			}
		}

		if (var7 == null) {
			List var14 = var0.a((Entity) null, (new class_ayk(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D)), class_rb.c);
			if (!var14.isEmpty()) {
				var7 = var14.get(var0.s.nextInt(var14.size()));
			}
		}

		return (class_pp) var7;
	}

	private static boolean a(class_aco var0, class_aco var1) {
		return var0.b() != var1.b() ? false : (var0.i() != var1.i() ? false : (var0.b > var0.c() ? false : class_aco.a(var0, var1)));
	}

	@Override
	public double A() {
		return c.n() + 0.5D;
	}

	@Override
	public double B() {
		return c.o() + 0.5D;
	}

	@Override
	public double C() {
		return c.p() + 0.5D;
	}

	public void d(int var1) {
		g = var1;
	}

	public boolean n() {
		return g > 0;
	}

	public boolean o() {
		return g <= 1;
	}

	@Override
	public String k() {
		return "minecraft:hopper";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aai(var1, this, var2);
	}

	@Override
	public int c(int var1) {
		return 0;
	}

	@Override
	public void b(int var1, int var2) {
	}

	@Override
	public int g() {
		return 0;
	}

	@Override
	public void l() {
		for (int var1 = 0; var1 < a.length; ++var1) {
			a[var1] = null;
		}

	}
}
