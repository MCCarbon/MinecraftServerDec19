package net.minecraft.server;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

public abstract class class_ago implements class_ags {
	private int a = 63;
	protected boolean e;
	public final List f = Lists.newArrayList();
	protected final List g = Lists.newArrayList();
	public final List h = Lists.newArrayList();
	public final List i = Lists.newArrayList();
	private final List b = Lists.newArrayList();
	private final List c = Lists.newArrayList();
	public final List j = Lists.newArrayList();
	public final List k = Lists.newArrayList();
	protected final class_nu l = new class_nu();
	private long d = 16777215L;
	private int H;
	protected int m = (new Random()).nextInt();
	protected final int n = 1013904223;
	protected float o;
	protected float p;
	protected float q;
	protected float r;
	private int I;
	public final Random s = new Random();
	public final class_arc t;
	protected List u = Lists.newArrayList();
	protected class_aqk v;
	protected final class_axu w;
	protected class_axt x;
	protected boolean y;
	protected class_aye z;
	protected class_ux A;
	public final class_ob B;
	private final Calendar J = Calendar.getInstance();
	protected class_ays C = new class_ays();
	public final boolean D;
	protected boolean E = true;
	protected boolean F = true;
	private boolean K;
	private final class_aqg L;
	int[] G = new int['耀'];

	protected class_ago(class_axu var1, class_axt var2, class_arc var3, class_ob var4, boolean var5) {
		w = var1;
		B = var4;
		x = var2;
		t = var3;
		D = var5;
		L = var3.o();
	}

	public class_ago b() {
		return this;
	}

	public class_ahb b(final class_cj var1) {
		if (this.e(var1)) {
			class_aqn var2 = this.f(var1);

			try {
				return var2.a(var1, t.k());
			} catch (Throwable var6) {
				class_b var4 = class_b.a(var6, "Getting biome");
				class_c var5 = var4.a("Coordinates of biome request");
				var5.a("Location", new Callable() {
					public String a() throws Exception {
						return class_c.a(var1);
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				throw new class_e(var4);
			}
		} else {
			return t.k().a(var1, class_ahb.q);
		}
	}

	public class_ahf y() {
		return t.k();
	}

	protected abstract class_aqk m();

	public void a(class_agr var1) {
		x.d(true);
	}

	public Block c(class_cj var1) {
		class_cj var2;
		for (var2 = new class_cj(var1.n(), H(), var1.p()); !this.d(var2.a()); var2 = var2.a()) {
			;
		}

		return p(var2).c();
	}

	private boolean a(class_cj var1) {
		return (var1.n() >= -30000000) && (var1.p() >= -30000000) && (var1.n() < 30000000) && (var1.p() < 30000000) && (var1.o() >= 0) && (var1.o() < 256);
	}

	@Override
	public boolean d(class_cj var1) {
		return p(var1).c().v() == class_avq.a;
	}

	public boolean e(class_cj var1) {
		return this.a(var1, true);
	}

	public boolean a(class_cj var1, boolean var2) {
		return !this.a(var1) ? false : this.a(var1.n() >> 4, var1.p() >> 4, var2);
	}

	public boolean a(class_cj var1, int var2) {
		return this.a(var1, var2, true);
	}

	public boolean a(class_cj var1, int var2, boolean var3) {
		return this.a(var1.n() - var2, var1.o() - var2, var1.p() - var2, var1.n() + var2, var1.o() + var2, var1.p() + var2, var3);
	}

	public boolean a(class_cj var1, class_cj var2) {
		return this.a(var1, var2, true);
	}

	public boolean a(class_cj var1, class_cj var2, boolean var3) {
		return this.a(var1.n(), var1.o(), var1.p(), var2.n(), var2.o(), var2.p(), var3);
	}

	public boolean a(class_aua var1) {
		return this.b(var1, true);
	}

	public boolean b(class_aua var1, boolean var2) {
		return this.a(var1.a, var1.b, var1.c, var1.d, var1.e, var1.f, var2);
	}

	private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		if ((var5 >= 0) && (var2 < 256)) {
			var1 >>= 4;
		var3 >>= 4;
		var4 >>= 4;
		var6 >>= 4;

		for (int var8 = var1; var8 <= var4; ++var8) {
			for (int var9 = var3; var9 <= var6; ++var9) {
				if (!this.a(var8, var9, var7)) {
					return false;
				}
			}
		}

		return true;
		} else {
			return false;
		}
	}

	protected boolean a(int var1, int var2, boolean var3) {
		return v.a(var1, var2) && (var3 || !v.d(var1, var2).f());
	}

	public class_aqn f(class_cj var1) {
		return this.a(var1.n() >> 4, var1.p() >> 4);
	}

	public class_aqn a(int var1, int var2) {
		return v.d(var1, var2);
	}

	public boolean a(class_cj var1, class_apn var2, int var3) {
		if (!this.a(var1)) {
			return false;
		} else if (!D && (x.t() == class_agt.g)) {
			return false;
		} else {
			class_aqn var4 = this.f(var1);
			Block var5 = var2.c();
			class_apn var6 = var4.a(var1, var2);
			if (var6 == null) {
				return false;
			} else {
				Block var7 = var6.c();
				if ((var5.r() != var7.r()) || (var5.t() != var7.t())) {
					B.a("checkLight");
					x(var1);
					B.b();
				}

				if (((var3 & 2) != 0) && (!D || ((var3 & 4) == 0)) && var4.i()) {
					this.h(var1);
				}

				if (!D && ((var3 & 1) != 0)) {
					this.c(var1, var6.c());
					if (var5.Q()) {
						this.f(var1, var5);
					}
				}

				return true;
			}
		}
	}

	public boolean g(class_cj var1) {
		return this.a(var1, Blocks.AIR.S(), 3);
	}

	public boolean b(class_cj var1, boolean var2) {
		class_apn var3 = p(var1);
		Block var4 = var3.c();
		if (var4.v() == class_avq.a) {
			return false;
		} else {
			this.b(2001, var1, Block.f(var3));
			if (var2) {
				var4.b(this, var1, var3, 0);
			}

			return this.a(var1, Blocks.AIR.S(), 3);
		}
	}

	public boolean a(class_cj var1, class_apn var2) {
		return this.a(var1, var2, 3);
	}

	public void h(class_cj var1) {
		for (int var2 = 0; var2 < u.size(); ++var2) {
			((class_agq) u.get(var2)).a(var1);
		}

	}

	public void c(class_cj var1, Block var2) {
		if (x.t() != class_agt.g) {
			this.d(var1, var2);
		}

	}

	public void a(int var1, int var2, int var3, int var4) {
		int var5;
		if (var3 > var4) {
			var5 = var4;
			var4 = var3;
			var3 = var5;
		}

		if (!t.m()) {
			for (var5 = var3; var5 <= var4; ++var5) {
				this.c(class_agu.a, new class_cj(var1, var5, var2));
			}
		}

		this.b(var1, var3, var2, var1, var4, var2);
	}

	public void b(class_cj var1, class_cj var2) {
		this.b(var1.n(), var1.o(), var1.p(), var2.n(), var2.o(), var2.p());
	}

	public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
		for (int var7 = 0; var7 < u.size(); ++var7) {
			((class_agq) u.get(var7)).a(var1, var2, var3, var4, var5, var6);
		}

	}

	public void d(class_cj var1, Block var2) {
		this.e(var1.e(), var2);
		this.e(var1.f(), var2);
		this.e(var1.b(), var2);
		this.e(var1.a(), var2);
		this.e(var1.c(), var2);
		this.e(var1.d(), var2);
	}

	public void a(class_cj var1, Block var2, class_cq var3) {
		if (var3 != class_cq.e) {
			this.e(var1.e(), var2);
		}

		if (var3 != class_cq.f) {
			this.e(var1.f(), var2);
		}

		if (var3 != class_cq.a) {
			this.e(var1.b(), var2);
		}

		if (var3 != class_cq.b) {
			this.e(var1.a(), var2);
		}

		if (var3 != class_cq.c) {
			this.e(var1.c(), var2);
		}

		if (var3 != class_cq.d) {
			this.e(var1.d(), var2);
		}

	}

	public void e(class_cj var1, final Block var2) {
		if (!D) {
			class_apn var3 = p(var1);

			try {
				var3.c().a(this, var1, var3, var2);
			} catch (Throwable var7) {
				class_b var5 = class_b.a(var7, "Exception while updating neighbours");
				class_c var6 = var5.a("Block being updated");
				var6.a("Source block type", new Callable() {
					public String a() throws Exception {
						try {
							return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(Block.a(var2)), var2.a(), var2.getClass().getCanonicalName() });
						} catch (Throwable var2x) {
							return "ID #" + Block.a(var2);
						}
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				class_c.a(var6, var1, var3);
				throw new class_e(var5);
			}
		}
	}

	public boolean a(class_cj var1, Block var2) {
		return false;
	}

	public boolean i(class_cj var1) {
		return this.f(var1).d(var1);
	}

	public boolean j(class_cj var1) {
		if (var1.o() >= H()) {
			return i(var1);
		} else {
			class_cj var2 = new class_cj(var1.n(), H(), var1.p());
			if (!i(var2)) {
				return false;
			} else {
				for (var2 = var2.b(); var2.o() > var1.o(); var2 = var2.b()) {
					Block var3 = p(var2).c();
					if ((var3.r() > 0) && !var3.v().d()) {
						return false;
					}
				}

				return true;
			}
		}
	}

	public int k(class_cj var1) {
		if (var1.o() < 0) {
			return 0;
		} else {
			if (var1.o() >= 256) {
				var1 = new class_cj(var1.n(), 255, var1.p());
			}

			return this.f(var1).a(var1, 0);
		}
	}

	public int l(class_cj var1) {
		return this.c(var1, true);
	}

	public int c(class_cj var1, boolean var2) {
		if ((var1.n() >= -30000000) && (var1.p() >= -30000000) && (var1.n() < 30000000) && (var1.p() < 30000000)) {
			if (var2 && p(var1).c().u()) {
				int var8 = this.c(var1.a(), false);
				int var4 = this.c(var1.f(), false);
				int var5 = this.c(var1.e(), false);
				int var6 = this.c(var1.d(), false);
				int var7 = this.c(var1.c(), false);
				if (var4 > var8) {
					var8 = var4;
				}

				if (var5 > var8) {
					var8 = var5;
				}

				if (var6 > var8) {
					var8 = var6;
				}

				if (var7 > var8) {
					var8 = var7;
				}

				return var8;
			} else if (var1.o() < 0) {
				return 0;
			} else {
				if (var1.o() >= 256) {
					var1 = new class_cj(var1.n(), 255, var1.p());
				}

				class_aqn var3 = this.f(var1);
				return var3.a(var1, H);
			}
		} else {
			return 15;
		}
	}

	public class_cj m(class_cj var1) {
		int var2;
		if ((var1.n() >= -30000000) && (var1.p() >= -30000000) && (var1.n() < 30000000) && (var1.p() < 30000000)) {
			if (this.a(var1.n() >> 4, var1.p() >> 4, true)) {
				var2 = this.a(var1.n() >> 4, var1.p() >> 4).b(var1.n() & 15, var1.p() & 15);
			} else {
				var2 = 0;
			}
		} else {
			var2 = H() + 1;
		}

		return new class_cj(var1.n(), var2, var1.p());
	}

	public int b(int var1, int var2) {
		if ((var1 >= -30000000) && (var2 >= -30000000) && (var1 < 30000000) && (var2 < 30000000)) {
			if (!this.a(var1 >> 4, var2 >> 4, true)) {
				return 0;
			} else {
				class_aqn var3 = this.a(var1 >> 4, var2 >> 4);
				return var3.w();
			}
		} else {
			return H() + 1;
		}
	}

	public int b(class_agu var1, class_cj var2) {
		if (var2.o() < 0) {
			var2 = new class_cj(var2.n(), 0, var2.p());
		}

		if (!this.a(var2)) {
			return var1.c;
		} else if (!this.e(var2)) {
			return var1.c;
		} else {
			class_aqn var3 = this.f(var2);
			return var3.a(var1, var2);
		}
	}

	public void a(class_agu var1, class_cj var2, int var3) {
		if (this.a(var2)) {
			if (this.e(var2)) {
				class_aqn var4 = this.f(var2);
				var4.a(var1, var2, var3);
				n(var2);
			}
		}
	}

	public void n(class_cj var1) {
		for (int var2 = 0; var2 < u.size(); ++var2) {
			((class_agq) u.get(var2)).b(var1);
		}

	}

	public float o(class_cj var1) {
		return t.n()[l(var1)];
	}

	@Override
	public class_apn p(class_cj var1) {
		if (!this.a(var1)) {
			return Blocks.AIR.S();
		} else {
			class_aqn var2 = this.f(var1);
			return var2.g(var1);
		}
	}

	public boolean z() {
		return H < 4;
	}

	public class_ayl a(class_aym var1, class_aym var2) {
		return this.a(var1, var2, false, false, false);
	}

	public class_ayl a(class_aym var1, class_aym var2, boolean var3) {
		return this.a(var1, var2, var3, false, false);
	}

	public class_ayl a(class_aym var1, class_aym var2, boolean var3, boolean var4, boolean var5) {
		if (!Double.isNaN(var1.a) && !Double.isNaN(var1.b) && !Double.isNaN(var1.c)) {
			if (!Double.isNaN(var2.a) && !Double.isNaN(var2.b) && !Double.isNaN(var2.c)) {
				int var6 = MathHelper.c(var2.a);
				int var7 = MathHelper.c(var2.b);
				int var8 = MathHelper.c(var2.c);
				int var9 = MathHelper.c(var1.a);
				int var10 = MathHelper.c(var1.b);
				int var11 = MathHelper.c(var1.c);
				class_cj var12 = new class_cj(var9, var10, var11);
				class_apn var13 = p(var12);
				Block var14 = var13.c();
				if ((!var4 || (var14.a(this, var12, var13) != null)) && var14.a(var13, var3)) {
					class_ayl var15 = var14.a(this, var12, var1, var2);
					if (var15 != null) {
						return var15;
					}
				}

				class_ayl var40 = null;
				int var41 = 200;

				while (var41-- >= 0) {
					if (Double.isNaN(var1.a) || Double.isNaN(var1.b) || Double.isNaN(var1.c)) {
						return null;
					}

					if ((var9 == var6) && (var10 == var7) && (var11 == var8)) {
						return var5 ? var40 : null;
					}

					boolean var42 = true;
					boolean var16 = true;
					boolean var17 = true;
					double var18 = 999.0D;
					double var20 = 999.0D;
					double var22 = 999.0D;
					if (var6 > var9) {
						var18 = var9 + 1.0D;
					} else if (var6 < var9) {
						var18 = var9 + 0.0D;
					} else {
						var42 = false;
					}

					if (var7 > var10) {
						var20 = var10 + 1.0D;
					} else if (var7 < var10) {
						var20 = var10 + 0.0D;
					} else {
						var16 = false;
					}

					if (var8 > var11) {
						var22 = var11 + 1.0D;
					} else if (var8 < var11) {
						var22 = var11 + 0.0D;
					} else {
						var17 = false;
					}

					double var24 = 999.0D;
					double var26 = 999.0D;
					double var28 = 999.0D;
					double var30 = var2.a - var1.a;
					double var32 = var2.b - var1.b;
					double var34 = var2.c - var1.c;
					if (var42) {
						var24 = (var18 - var1.a) / var30;
					}

					if (var16) {
						var26 = (var20 - var1.b) / var32;
					}

					if (var17) {
						var28 = (var22 - var1.c) / var34;
					}

					if (var24 == -0.0D) {
						var24 = -1.0E-4D;
					}

					if (var26 == -0.0D) {
						var26 = -1.0E-4D;
					}

					if (var28 == -0.0D) {
						var28 = -1.0E-4D;
					}

					class_cq var36;
					if ((var24 < var26) && (var24 < var28)) {
						var36 = var6 > var9 ? class_cq.e : class_cq.f;
						var1 = new class_aym(var18, var1.b + (var32 * var24), var1.c + (var34 * var24));
					} else if (var26 < var28) {
						var36 = var7 > var10 ? class_cq.a : class_cq.b;
						var1 = new class_aym(var1.a + (var30 * var26), var20, var1.c + (var34 * var26));
					} else {
						var36 = var8 > var11 ? class_cq.c : class_cq.d;
						var1 = new class_aym(var1.a + (var30 * var28), var1.b + (var32 * var28), var22);
					}

					var9 = MathHelper.c(var1.a) - (var36 == class_cq.f ? 1 : 0);
					var10 = MathHelper.c(var1.b) - (var36 == class_cq.b ? 1 : 0);
					var11 = MathHelper.c(var1.c) - (var36 == class_cq.d ? 1 : 0);
					var12 = new class_cj(var9, var10, var11);
					class_apn var37 = p(var12);
					Block var38 = var37.c();
					if (!var4 || (var38.a(this, var12, var37) != null)) {
						if (var38.a(var37, var3)) {
							class_ayl var39 = var38.a(this, var12, var1, var2);
							if (var39 != null) {
								return var39;
							}
						} else {
							var40 = new class_ayl(class_ayl.class_a_in_class_ayl.a, var1, var36, var12);
						}
					}
				}

				return var5 ? var40 : null;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public void a(Entity var1, String var2, float var3, float var4) {
		for (int var5 = 0; var5 < u.size(); ++var5) {
			((class_agq) u.get(var5)).a(var2, var1.s, var1.t, var1.u, var3, var4);
		}

	}

	public void a(class_yu var1, String var2, float var3, float var4) {
		for (int var5 = 0; var5 < u.size(); ++var5) {
			((class_agq) u.get(var5)).a(var1, var2, var1.s, var1.t, var1.u, var3, var4);
		}

	}

	public void a(double var1, double var3, double var5, String var7, float var8, float var9) {
		for (int var10 = 0; var10 < u.size(); ++var10) {
			((class_agq) u.get(var10)).a(var7, var1, var3, var5, var8, var9);
		}

	}

	public void a(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
	}

	public void a(class_cj var1, String var2) {
		for (int var3 = 0; var3 < u.size(); ++var3) {
			((class_agq) u.get(var3)).a(var2, var1);
		}

	}

	public void a(class_cy var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
		this.a(var1.c(), var1.e(), var2, var4, var6, var8, var10, var12, var14);
	}

	private void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
		for (int var16 = 0; var16 < u.size(); ++var16) {
			((class_agq) u.get(var16)).a(var1, var2, var3, var5, var7, var9, var11, var13, var15);
		}

	}

	public boolean d(Entity var1) {
		k.add(var1);
		return true;
	}

	public boolean a(Entity var1) {
		int var2 = MathHelper.c(var1.s / 16.0D);
		int var3 = MathHelper.c(var1.u / 16.0D);
		boolean var4 = var1.n;
		if (var1 instanceof class_yu) {
			var4 = true;
		}

		if (!var4 && !this.a(var2, var3, true)) {
			return false;
		} else {
			if (var1 instanceof class_yu) {
				class_yu var5 = (class_yu) var1;
				j.add(var5);
				this.e();
			}

			this.a(var2, var3).a(var1);
			f.add(var1);
			this.b(var1);
			return true;
		}
	}

	protected void b(Entity var1) {
		for (int var2 = 0; var2 < u.size(); ++var2) {
			((class_agq) u.get(var2)).a(var1);
		}

	}

	protected void c(Entity var1) {
		for (int var2 = 0; var2 < u.size(); ++var2) {
			((class_agq) u.get(var2)).b(var1);
		}

	}

	public void e(Entity var1) {
		if (var1.l != null) {
			var1.l.a((Entity) null);
		}

		if (var1.m != null) {
			var1.a((Entity) null);
		}

		var1.L();
		if (var1 instanceof class_yu) {
			j.remove(var1);
			this.e();
			this.c(var1);
		}

	}

	public void f(Entity var1) {
		var1.L();
		if (var1 instanceof class_yu) {
			j.remove(var1);
			this.e();
		}

		int var2 = var1.ae;
		int var3 = var1.ag;
		if (var1.ad && this.a(var2, var3, true)) {
			this.a(var2, var3).b(var1);
		}

		f.remove(var1);
		this.c(var1);
	}

	public void a(class_agq var1) {
		u.add(var1);
	}

	public List a(Entity var1, class_ayk var2) {
		ArrayList var3 = Lists.newArrayList();
		int var4 = MathHelper.c(var2.a);
		int var5 = MathHelper.c(var2.d + 1.0D);
		int var6 = MathHelper.c(var2.b);
		int var7 = MathHelper.c(var2.e + 1.0D);
		int var8 = MathHelper.c(var2.c);
		int var9 = MathHelper.c(var2.f + 1.0D);
		class_aqg var10 = ah();
		boolean var11 = (var1 != null) && var1.aZ();
		boolean var12 = (var1 != null) && this.a(var10, var1);
		class_apn var13 = Blocks.STONE.S();
		class_cj.class_a_in_class_cj var14 = new class_cj.class_a_in_class_cj();

		for (int var15 = var4; var15 < var5; ++var15) {
			for (int var16 = var8; var16 < var9; ++var16) {
				if (this.e(var14.c(var15, 64, var16))) {
					for (int var17 = var6 - 1; var17 < var7; ++var17) {
						var14.c(var15, var17, var16);
						if (var1 != null) {
							if (var11 && var12) {
								var1.h(false);
							} else if (!var11 && !var12) {
								var1.h(true);
							}
						}

						class_apn var18 = var13;
						if (var10.a(var14) || !var12) {
							var18 = p(var14);
						}

						var18.c().a(this, var14, var18, var2, var3, var1);
					}
				}
			}
		}

		if (var1 != null) {
			double var21 = 0.25D;
			List var22 = this.b(var1, var2.b(var21, var21, var21));

			for (int var23 = 0; var23 < var22.size(); ++var23) {
				Entity var19 = (Entity) var22.get(var23);
				if ((var1.l != var19) && (var1.m != var19)) {
					class_ayk var20 = var19.V();
					if ((var20 != null) && var20.b(var2)) {
						var3.add(var20);
					}

					var20 = var1.j(var19);
					if ((var20 != null) && var20.b(var2)) {
						var3.add(var20);
					}
				}
			}
		}

		return var3;
	}

	public boolean a(class_aqg var1, Entity var2) {
		double var3 = var1.b();
		double var5 = var1.c();
		double var7 = var1.d();
		double var9 = var1.e();
		if (var2.aZ()) {
			++var3;
			++var5;
			--var7;
			--var9;
		} else {
			--var3;
			--var5;
			++var7;
			++var9;
		}

		return (var2.s > var3) && (var2.s < var7) && (var2.u > var5) && (var2.u < var9);
	}

	public List a(class_ayk var1) {
		ArrayList var2 = Lists.newArrayList();
		int var3 = MathHelper.c(var1.a);
		int var4 = MathHelper.c(var1.d + 1.0D);
		int var5 = MathHelper.c(var1.b);
		int var6 = MathHelper.c(var1.e + 1.0D);
		int var7 = MathHelper.c(var1.c);
		int var8 = MathHelper.c(var1.f + 1.0D);
		class_cj.class_a_in_class_cj var9 = new class_cj.class_a_in_class_cj();

		for (int var10 = var3; var10 < var4; ++var10) {
			for (int var11 = var7; var11 < var8; ++var11) {
				if (this.e(var9.c(var10, 64, var11))) {
					for (int var12 = var5 - 1; var12 < var6; ++var12) {
						var9.c(var10, var12, var11);
						class_apn var13;
						if ((var10 >= -30000000) && (var10 < 30000000) && (var11 >= -30000000) && (var11 < 30000000)) {
							var13 = p(var9);
						} else {
							var13 = Blocks.BEDROCK.S();
						}

						var13.c().a(this, var9, var13, var1, var2, (Entity) null);
					}
				}
			}
		}

		return var2;
	}

	public int a(float var1) {
		float var2 = this.c(var1);
		float var3 = 1.0F - ((MathHelper.b(var2 * 3.1415927F * 2.0F) * 2.0F) + 0.5F);
		var3 = MathHelper.a(var3, 0.0F, 1.0F);
		var3 = 1.0F - var3;
		var3 = (float) (var3 * (1.0D - (this.j(var1) * 5.0F / 16.0D)));
		var3 = (float) (var3 * (1.0D - (this.h(var1) * 5.0F / 16.0D)));
		var3 = 1.0F - var3;
		return (int) (var3 * 11.0F);
	}

	public float c(float var1) {
		return t.a(x.f(), var1);
	}

	public float B() {
		return class_arc.a[t.a(x.f())];
	}

	public float d(float var1) {
		float var2 = this.c(var1);
		return var2 * 3.1415927F * 2.0F;
	}

	public class_cj q(class_cj var1) {
		return this.f(var1).h(var1);
	}

	public class_cj r(class_cj var1) {
		class_aqn var2 = this.f(var1);

		class_cj var3;
		class_cj var4;
		for (var3 = new class_cj(var1.n(), var2.g() + 16, var1.p()); var3.o() >= 0; var3 = var4) {
			var4 = var3.b();
			class_avq var5 = var2.a(var4).v();
			if (var5.c() && (var5 != class_avq.j)) {
				break;
			}
		}

		return var3;
	}

	public boolean b(class_cj var1, Block var2) {
		return true;
	}

	public void a(class_cj var1, Block var2, int var3) {
	}

	public void a(class_cj var1, Block var2, int var3, int var4) {
	}

	public void b(class_cj var1, Block var2, int var3, int var4) {
	}

	public void k() {
		B.a("entities");
		B.a("global");

		int var1;
		Entity var2;
		class_b var4;
		class_c var5;
		for (var1 = 0; var1 < k.size(); ++var1) {
			var2 = (Entity) k.get(var1);

			try {
				++var2.W;
				var2.r_();
			} catch (Throwable var9) {
				var4 = class_b.a(var9, "Ticking entity");
				var5 = var4.a("Entity being ticked");
				if (var2 == null) {
					var5.a("Entity", "~~NULL~~");
				} else {
					var2.a(var5);
				}

				throw new class_e(var4);
			}

			if (var2.I) {
				k.remove(var1--);
			}
		}

		B.c("remove");
		f.removeAll(g);

		int var3;
		int var14;
		for (var1 = 0; var1 < g.size(); ++var1) {
			var2 = (Entity) g.get(var1);
			var3 = var2.ae;
			var14 = var2.ag;
			if (var2.ad && this.a(var3, var14, true)) {
				this.a(var3, var14).b(var2);
			}
		}

		for (var1 = 0; var1 < g.size(); ++var1) {
			this.c((Entity) g.get(var1));
		}

		g.clear();
		B.c("regular");

		for (var1 = 0; var1 < f.size(); ++var1) {
			var2 = (Entity) f.get(var1);
			if (var2.m != null) {
				if (!var2.m.I && (var2.m.l == var2)) {
					continue;
				}

				var2.m.l = null;
				var2.m = null;
			}

			B.a("tick");
			if (!var2.I) {
				try {
					this.g(var2);
				} catch (Throwable var8) {
					var4 = class_b.a(var8, "Ticking entity");
					var5 = var4.a("Entity being ticked");
					var2.a(var5);
					throw new class_e(var4);
				}
			}

			B.b();
			B.a("remove");
			if (var2.I) {
				var3 = var2.ae;
				var14 = var2.ag;
				if (var2.ad && this.a(var3, var14, true)) {
					this.a(var3, var14).b(var2);
				}

				f.remove(var1--);
				this.c(var2);
			}

			B.b();
		}

		B.c("blockEntities");
		K = true;
		Iterator var15 = i.iterator();

		while (var15.hasNext()) {
			TileEntity var10 = (TileEntity) var15.next();
			if (!var10.x() && var10.t()) {
				class_cj var12 = var10.v();
				if (this.e(var12) && L.a(var12)) {
					try {
						B.a(var10.getClass().getSimpleName());
						((class_ks) var10).c();
						B.b();
					} catch (Throwable var7) {
						class_b var16 = class_b.a(var7, "Ticking block entity");
						class_c var6 = var16.a("Block entity being ticked");
						var10.a(var6);
						throw new class_e(var16);
					}
				}
			}

			if (var10.x()) {
				var15.remove();
				h.remove(var10);
				if (this.e(var10.v())) {
					this.f(var10.v()).e(var10.v());
				}
			}
		}

		K = false;
		if (!c.isEmpty()) {
			i.removeAll(c);
			h.removeAll(c);
			c.clear();
		}

		B.c("pendingBlockEntities");
		if (!b.isEmpty()) {
			for (int var11 = 0; var11 < b.size(); ++var11) {
				TileEntity var13 = (TileEntity) b.get(var11);
				if (!var13.x()) {
					if (!h.contains(var13)) {
						this.a(var13);
					}

					if (this.e(var13.v())) {
						this.f(var13.v()).a(var13.v(), var13);
					}

					this.h(var13.v());
				}
			}

			b.clear();
		}

		B.b();
		B.b();
	}

	public boolean a(TileEntity var1) {
		boolean var2 = h.add(var1);
		if (var2 && (var1 instanceof class_ks)) {
			i.add(var1);
		}

		return var2;
	}

	public void b(Collection var1) {
		if (K) {
			b.addAll(var1);
		} else {
			Iterator var2 = var1.iterator();

			while (var2.hasNext()) {
				TileEntity var3 = (TileEntity) var2.next();
				h.add(var3);
				if (var3 instanceof class_ks) {
					i.add(var3);
				}
			}
		}

	}

	public void g(Entity var1) {
		this.a(var1, true);
	}

	public void a(Entity var1, boolean var2) {
		int var3 = MathHelper.c(var1.s);
		int var4 = MathHelper.c(var1.u);
		byte var5 = 32;
		if (!var2 || this.a(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5, true)) {
			var1.P = var1.s;
			var1.Q = var1.t;
			var1.R = var1.u;
			var1.A = var1.y;
			var1.B = var1.z;
			if (var2 && var1.ad) {
				++var1.W;
				if (var1.m != null) {
					var1.an();
				} else {
					var1.r_();
				}
			}

			B.a("chunkCheck");
			if (Double.isNaN(var1.s) || Double.isInfinite(var1.s)) {
				var1.s = var1.P;
			}

			if (Double.isNaN(var1.t) || Double.isInfinite(var1.t)) {
				var1.t = var1.Q;
			}

			if (Double.isNaN(var1.u) || Double.isInfinite(var1.u)) {
				var1.u = var1.R;
			}

			if (Double.isNaN(var1.z) || Double.isInfinite(var1.z)) {
				var1.z = var1.B;
			}

			if (Double.isNaN(var1.y) || Double.isInfinite(var1.y)) {
				var1.y = var1.A;
			}

			int var6 = MathHelper.c(var1.s / 16.0D);
			int var7 = MathHelper.c(var1.t / 16.0D);
			int var8 = MathHelper.c(var1.u / 16.0D);
			if (!var1.ad || (var1.ae != var6) || (var1.af != var7) || (var1.ag != var8)) {
				if (var1.ad && this.a(var1.ae, var1.ag, true)) {
					this.a(var1.ae, var1.ag).a(var1, var1.af);
				}

				if (!var1.bd() && !this.a(var6, var8, true)) {
					var1.ad = false;
				} else {
					this.a(var6, var8).a(var1);
				}
			}

			B.b();
			if (var2 && var1.ad && (var1.l != null)) {
				if (!var1.l.I && (var1.l.m == var1)) {
					this.g(var1.l);
				} else {
					var1.l.m = null;
					var1.l = null;
				}
			}

		}
	}

	public boolean b(class_ayk var1) {
		return this.a(var1, (Entity) null);
	}

	public boolean a(class_ayk var1, Entity var2) {
		List var3 = this.b((Entity) null, var1);

		for (int var4 = 0; var4 < var3.size(); ++var4) {
			Entity var5 = (Entity) var3.get(var4);
			if (!var5.I && var5.k && (var5 != var2) && ((var2 == null) || ((var2.m != var5) && (var2.l != var5)))) {
				return false;
			}
		}

		return true;
	}

	public boolean c(class_ayk var1) {
		int var2 = MathHelper.c(var1.a);
		int var3 = MathHelper.c(var1.d);
		int var4 = MathHelper.c(var1.b);
		int var5 = MathHelper.c(var1.e);
		int var6 = MathHelper.c(var1.c);
		int var7 = MathHelper.c(var1.f);
		class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

		for (int var9 = var2; var9 <= var3; ++var9) {
			for (int var10 = var4; var10 <= var5; ++var10) {
				for (int var11 = var6; var11 <= var7; ++var11) {
					Block var12 = p(var8.c(var9, var10, var11)).c();
					if (var12.v() != class_avq.a) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean d(class_ayk var1) {
		int var2 = MathHelper.c(var1.a);
		int var3 = MathHelper.c(var1.d);
		int var4 = MathHelper.c(var1.b);
		int var5 = MathHelper.c(var1.e);
		int var6 = MathHelper.c(var1.c);
		int var7 = MathHelper.c(var1.f);
		class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

		for (int var9 = var2; var9 <= var3; ++var9) {
			for (int var10 = var4; var10 <= var5; ++var10) {
				for (int var11 = var6; var11 <= var7; ++var11) {
					Block var12 = p(var8.c(var9, var10, var11)).c();
					if (var12.v().d()) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean e(class_ayk var1) {
		int var2 = MathHelper.c(var1.a);
		int var3 = MathHelper.c(var1.d + 1.0D);
		int var4 = MathHelper.c(var1.b);
		int var5 = MathHelper.c(var1.e + 1.0D);
		int var6 = MathHelper.c(var1.c);
		int var7 = MathHelper.c(var1.f + 1.0D);
		if (this.a(var2, var4, var6, var3, var5, var7, true)) {
			class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

			for (int var9 = var2; var9 < var3; ++var9) {
				for (int var10 = var4; var10 < var5; ++var10) {
					for (int var11 = var6; var11 < var7; ++var11) {
						Block var12 = p(var8.c(var9, var10, var11)).c();
						if ((var12 == Blocks.FIRE) || (var12 == Blocks.FLOWING_LAVA) || (var12 == Blocks.LAVA)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public boolean a(class_ayk var1, class_avq var2, Entity var3) {
		int var4 = MathHelper.c(var1.a);
		int var5 = MathHelper.c(var1.d + 1.0D);
		int var6 = MathHelper.c(var1.b);
		int var7 = MathHelper.c(var1.e + 1.0D);
		int var8 = MathHelper.c(var1.c);
		int var9 = MathHelper.c(var1.f + 1.0D);
		if (!this.a(var4, var6, var8, var5, var7, var9, true)) {
			return false;
		} else {
			boolean var10 = false;
			class_aym var11 = new class_aym(0.0D, 0.0D, 0.0D);
			class_cj.class_a_in_class_cj var12 = new class_cj.class_a_in_class_cj();

			for (int var13 = var4; var13 < var5; ++var13) {
				for (int var14 = var6; var14 < var7; ++var14) {
					for (int var15 = var8; var15 < var9; ++var15) {
						var12.c(var13, var14, var15);
						class_apn var16 = p(var12);
						Block var17 = var16.c();
						if (var17.v() == var2) {
							double var18 = var14 + 1 - class_alf.b(((Integer) var16.b(class_alf.b)).intValue());
							if (var7 >= var18) {
								var10 = true;
								var11 = var17.a(this, var12, var3, var11);
							}
						}
					}
				}
			}

			if ((var11.b() > 0.0D) && var3.aR()) {
				var11 = var11.a();
				double var20 = 0.014D;
				var3.v += var11.a * var20;
				var3.w += var11.b * var20;
				var3.x += var11.c * var20;
			}

			return var10;
		}
	}

	public boolean a(class_ayk var1, class_avq var2) {
		int var3 = MathHelper.c(var1.a);
		int var4 = MathHelper.c(var1.d + 1.0D);
		int var5 = MathHelper.c(var1.b);
		int var6 = MathHelper.c(var1.e + 1.0D);
		int var7 = MathHelper.c(var1.c);
		int var8 = MathHelper.c(var1.f + 1.0D);
		class_cj.class_a_in_class_cj var9 = new class_cj.class_a_in_class_cj();

		for (int var10 = var3; var10 < var4; ++var10) {
			for (int var11 = var5; var11 < var6; ++var11) {
				for (int var12 = var7; var12 < var8; ++var12) {
					if (p(var9.c(var10, var11, var12)).c().v() == var2) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean b(class_ayk var1, class_avq var2) {
		int var3 = MathHelper.c(var1.a);
		int var4 = MathHelper.c(var1.d + 1.0D);
		int var5 = MathHelper.c(var1.b);
		int var6 = MathHelper.c(var1.e + 1.0D);
		int var7 = MathHelper.c(var1.c);
		int var8 = MathHelper.c(var1.f + 1.0D);
		class_cj.class_a_in_class_cj var9 = new class_cj.class_a_in_class_cj();

		for (int var10 = var3; var10 < var4; ++var10) {
			for (int var11 = var5; var11 < var6; ++var11) {
				for (int var12 = var7; var12 < var8; ++var12) {
					class_apn var13 = p(var9.c(var10, var11, var12));
					Block var14 = var13.c();
					if (var14.v() == var2) {
						int var15 = ((Integer) var13.b(class_alf.b)).intValue();
						double var16 = var11 + 1;
						if (var15 < 8) {
							var16 = var11 + 1 - (var15 / 8.0D);
						}

						if (var16 >= var1.b) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public class_agk a(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
		return this.a(var1, var2, var4, var6, var8, false, var9);
	}

	public class_agk a(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
		class_agk var11 = new class_agk(this, var1, var2, var4, var6, var8, var9, var10);
		var11.a();
		var11.a(true);
		return var11;
	}

	public float a(class_aym var1, class_ayk var2) {
		double var3 = 1.0D / (((var2.d - var2.a) * 2.0D) + 1.0D);
		double var5 = 1.0D / (((var2.e - var2.b) * 2.0D) + 1.0D);
		double var7 = 1.0D / (((var2.f - var2.c) * 2.0D) + 1.0D);
		double var9 = (1.0D - (Math.floor(1.0D / var3) * var3)) / 2.0D;
		double var11 = (1.0D - (Math.floor(1.0D / var7) * var7)) / 2.0D;
		if ((var3 >= 0.0D) && (var5 >= 0.0D) && (var7 >= 0.0D)) {
			int var13 = 0;
			int var14 = 0;

			for (float var15 = 0.0F; var15 <= 1.0F; var15 = (float) (var15 + var3)) {
				for (float var16 = 0.0F; var16 <= 1.0F; var16 = (float) (var16 + var5)) {
					for (float var17 = 0.0F; var17 <= 1.0F; var17 = (float) (var17 + var7)) {
						double var18 = var2.a + ((var2.d - var2.a) * var15);
						double var20 = var2.b + ((var2.e - var2.b) * var16);
						double var22 = var2.c + ((var2.f - var2.c) * var17);
						if (this.a(new class_aym(var18 + var9, var20, var22 + var11), var1) == null) {
							++var13;
						}

						++var14;
					}
				}
			}

			return (float) var13 / (float) var14;
		} else {
			return 0.0F;
		}
	}

	public boolean a(class_yu var1, class_cj var2, class_cq var3) {
		var2 = var2.a(var3);
		if (p(var2).c() == Blocks.FIRE) {
			this.a(var1, 1004, var2, 0);
			this.g(var2);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TileEntity s(class_cj var1) {
		if (!this.a(var1)) {
			return null;
		} else {
			TileEntity var2 = null;
			int var3;
			TileEntity var4;
			if (K) {
				for (var3 = 0; var3 < b.size(); ++var3) {
					var4 = (TileEntity) b.get(var3);
					if (!var4.x() && var4.v().equals(var1)) {
						var2 = var4;
						break;
					}
				}
			}

			if (var2 == null) {
				var2 = this.f(var1).a(var1, class_aqn.class_a_in_class_aqn.a);
			}

			if (var2 == null) {
				for (var3 = 0; var3 < b.size(); ++var3) {
					var4 = (TileEntity) b.get(var3);
					if (!var4.x() && var4.v().equals(var1)) {
						var2 = var4;
						break;
					}
				}
			}

			return var2;
		}
	}

	public void a(class_cj var1, TileEntity var2) {
		if ((var2 != null) && !var2.x()) {
			if (K) {
				var2.a(var1);
				Iterator var3 = b.iterator();

				while (var3.hasNext()) {
					TileEntity var4 = (TileEntity) var3.next();
					if (var4.v().equals(var1)) {
						var4.y();
						var3.remove();
					}
				}

				b.add(var2);
			} else {
				this.a(var2);
				this.f(var1).a(var1, var2);
			}
		}

	}

	public void t(class_cj var1) {
		TileEntity var2 = s(var1);
		if ((var2 != null) && K) {
			var2.y();
			b.remove(var2);
		} else {
			if (var2 != null) {
				b.remove(var2);
				h.remove(var2);
				i.remove(var2);
			}

			this.f(var1).e(var1);
		}

	}

	public void b(TileEntity var1) {
		c.add(var1);
	}

	public boolean u(class_cj var1) {
		class_apn var2 = p(var1);
		class_ayk var3 = var2.c().a(this, var1, var2);
		return (var3 != null) && (var3.a() >= 1.0D);
	}

	public static boolean a(class_ags var0, class_cj var1) {
		class_apn var2 = var0.p(var1);
		Block var3 = var2.c();
		return var3.v().k() && var3.d() ? true : (var3 instanceof class_anf ? var2.b(class_anf.b) == class_anf.class_a_in_class_anf.a : (var3 instanceof BlockStepAbstract ? var2.b(BlockStepAbstract.a) == BlockStepAbstract.class_a_in_class_akq.a : (var3 instanceof BlockHopper ? true : (var3 instanceof class_ana ? ((Integer) var2.b(class_ana.a)).intValue() == 7 : false))));
	}

	public boolean d(class_cj var1, boolean var2) {
		if (!this.a(var1)) {
			return var2;
		} else {
			class_aqn var3 = v.a(var1);
			if (var3.f()) {
				return var2;
			} else {
				Block var4 = p(var1).c();
				return var4.v().k() && var4.d();
			}
		}
	}

	public void E() {
		int var1 = this.a(1.0F);
		if (var1 != H) {
			H = var1;
		}

	}

	public void a(boolean var1, boolean var2) {
		E = var1;
		F = var2;
	}

	public void d() {
		this.r();
	}

	protected void F() {
		if (x.o()) {
			p = 1.0F;
			if (x.m()) {
				r = 1.0F;
			}
		}

	}

	protected void r() {
		if (!t.m()) {
			if (!D) {
				int var1 = x.z();
				if (var1 > 0) {
					--var1;
					x.i(var1);
					x.f(x.m() ? 1 : 2);
					x.g(x.o() ? 1 : 2);
				}

				int var2 = x.n();
				if (var2 <= 0) {
					if (x.m()) {
						x.f(s.nextInt(12000) + 3600);
					} else {
						x.f(s.nextInt(168000) + 12000);
					}
				} else {
					--var2;
					x.f(var2);
					if (var2 <= 0) {
						x.a(!x.m());
					}
				}

				q = r;
				if (x.m()) {
					r = (float) (r + 0.01D);
				} else {
					r = (float) (r - 0.01D);
				}

				r = MathHelper.a(r, 0.0F, 1.0F);
				int var3 = x.p();
				if (var3 <= 0) {
					if (x.o()) {
						x.g(s.nextInt(12000) + 12000);
					} else {
						x.g(s.nextInt(168000) + 12000);
					}
				} else {
					--var3;
					x.g(var3);
					if (var3 <= 0) {
						x.b(!x.o());
					}
				}

				o = p;
				if (x.o()) {
					p = (float) (p + 0.01D);
				} else {
					p = (float) (p - 0.01D);
				}

				p = MathHelper.a(p, 0.0F, 1.0F);
			}
		}
	}

	protected void j() {
	}

	public void a(Block var1, class_cj var2, Random var3) {
		e = true;
		var1.b(this, var2, p(var2), var3);
		e = false;
	}

	public boolean v(class_cj var1) {
		return this.e(var1, false);
	}

	public boolean w(class_cj var1) {
		return this.e(var1, true);
	}

	public boolean e(class_cj var1, boolean var2) {
		class_ahb var3 = this.b(var1);
		float var4 = var3.a(var1);
		if (var4 > 0.15F) {
			return false;
		} else {
			if ((var1.o() >= 0) && (var1.o() < 256) && (this.b(class_agu.b, var1) < 10)) {
				class_apn var5 = p(var1);
				Block var6 = var5.c();
				if (((var6 == Blocks.WATER) || (var6 == Blocks.FLOWING_WATER)) && (((Integer) var5.b(class_alf.b)).intValue() == 0)) {
					if (!var2) {
						return true;
					}

					boolean var7 = this.F(var1.e()) && this.F(var1.f()) && this.F(var1.c()) && this.F(var1.d());
					if (!var7) {
						return true;
					}
				}
			}

			return false;
		}
	}

	private boolean F(class_cj var1) {
		return p(var1).c().v() == class_avq.h;
	}

	public boolean f(class_cj var1, boolean var2) {
		class_ahb var3 = this.b(var1);
		float var4 = var3.a(var1);
		if (var4 > 0.15F) {
			return false;
		} else if (!var2) {
			return true;
		} else {
			if ((var1.o() >= 0) && (var1.o() < 256) && (this.b(class_agu.b, var1) < 10)) {
				Block var5 = p(var1).c();
				if ((var5.v() == class_avq.a) && Blocks.SNOW_LAYER.c(this, var1)) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean x(class_cj var1) {
		boolean var2 = false;
		if (!t.m()) {
			var2 |= this.c(class_agu.a, var1);
		}

		var2 |= this.c(class_agu.b, var1);
		return var2;
	}

	private int a(class_cj var1, class_agu var2) {
		if ((var2 == class_agu.a) && i(var1)) {
			return 15;
		} else {
			Block var3 = p(var1).c();
			int var4 = var2 == class_agu.a ? 0 : var3.t();
			int var5 = var3.r();
			if ((var5 >= 15) && (var3.t() > 0)) {
				var5 = 1;
			}

			if (var5 < 1) {
				var5 = 1;
			}

			if (var5 >= 15) {
				return 0;
			} else if (var4 >= 14) {
				return var4;
			} else {
				class_cq[] var6 = class_cq.values();
				int var7 = var6.length;

				for (int var8 = 0; var8 < var7; ++var8) {
					class_cq var9 = var6[var8];
					class_cj var10 = var1.a(var9);
					int var11 = this.b(var2, var10) - var5;
					if (var11 > var4) {
						var4 = var11;
					}

					if (var4 >= 14) {
						return var4;
					}
				}

				return var4;
			}
		}
	}

	public boolean c(class_agu var1, class_cj var2) {
		if (!this.a(var2, 17, false)) {
			return false;
		} else {
			int var3 = 0;
			int var4 = 0;
			B.a("getBrightness");
			int var5 = this.b(var1, var2);
			int var6 = this.a(var2, var1);
			int var7 = var2.n();
			int var8 = var2.o();
			int var9 = var2.p();
			int var10;
			int var11;
			int var12;
			int var13;
			int var16;
			int var17;
			int var18;
			int var19;
			if (var6 > var5) {
				G[var4++] = 133152;
			} else if (var6 < var5) {
				G[var4++] = 133152 | (var5 << 18);

				label90: while (true) {
					int var14;
					do {
						do {
							class_cj var15;
							do {
								if (var3 >= var4) {
									var3 = 0;
									break label90;
								}

								var10 = G[var3++];
								var11 = ((var10 & 63) - 32) + var7;
								var12 = (((var10 >> 6) & 63) - 32) + var8;
								var13 = (((var10 >> 12) & 63) - 32) + var9;
								var14 = (var10 >> 18) & 15;
								var15 = new class_cj(var11, var12, var13);
								var16 = this.b(var1, var15);
							} while (var16 != var14);

							this.a(var1, var15, 0);
						} while (var14 <= 0);

						var17 = MathHelper.a(var11 - var7);
						var18 = MathHelper.a(var12 - var8);
						var19 = MathHelper.a(var13 - var9);
					} while ((var17 + var18 + var19) >= 17);

					class_cj.class_a_in_class_cj var20 = new class_cj.class_a_in_class_cj();
					class_cq[] var21 = class_cq.values();
					int var22 = var21.length;

					for (int var23 = 0; var23 < var22; ++var23) {
						class_cq var24 = var21[var23];
						int var25 = var11 + var24.g();
						int var26 = var12 + var24.h();
						int var27 = var13 + var24.i();
						var20.c(var25, var26, var27);
						int var28 = Math.max(1, p(var20).c().r());
						var16 = this.b(var1, var20);
						if ((var16 == (var14 - var28)) && (var4 < G.length)) {
							G[var4++] = ((var25 - var7) + 32) | (((var26 - var8) + 32) << 6) | (((var27 - var9) + 32) << 12) | ((var14 - var28) << 18);
						}
					}
				}
			}

			B.b();
			B.a("checkedPosition < toCheckCount");

			while (var3 < var4) {
				var10 = G[var3++];
				var11 = ((var10 & 63) - 32) + var7;
				var12 = (((var10 >> 6) & 63) - 32) + var8;
				var13 = (((var10 >> 12) & 63) - 32) + var9;
				class_cj var29 = new class_cj(var11, var12, var13);
				int var30 = this.b(var1, var29);
				var16 = this.a(var29, var1);
				if (var16 != var30) {
					this.a(var1, var29, var16);
					if (var16 > var30) {
						var17 = Math.abs(var11 - var7);
						var18 = Math.abs(var12 - var8);
						var19 = Math.abs(var13 - var9);
						boolean var31 = var4 < (G.length - 6);
						if (((var17 + var18 + var19) < 17) && var31) {
							if (this.b(var1, var29.e()) < var16) {
								G[var4++] = (var11 - 1 - var7) + 32 + (((var12 - var8) + 32) << 6) + (((var13 - var9) + 32) << 12);
							}

							if (this.b(var1, var29.f()) < var16) {
								G[var4++] = ((var11 + 1) - var7) + 32 + (((var12 - var8) + 32) << 6) + (((var13 - var9) + 32) << 12);
							}

							if (this.b(var1, var29.b()) < var16) {
								G[var4++] = (var11 - var7) + 32 + (((var12 - 1 - var8) + 32) << 6) + (((var13 - var9) + 32) << 12);
							}

							if (this.b(var1, var29.a()) < var16) {
								G[var4++] = (var11 - var7) + 32 + ((((var12 + 1) - var8) + 32) << 6) + (((var13 - var9) + 32) << 12);
							}

							if (this.b(var1, var29.c()) < var16) {
								G[var4++] = (var11 - var7) + 32 + (((var12 - var8) + 32) << 6) + (((var13 - 1 - var9) + 32) << 12);
							}

							if (this.b(var1, var29.d()) < var16) {
								G[var4++] = (var11 - var7) + 32 + (((var12 - var8) + 32) << 6) + ((((var13 + 1) - var9) + 32) << 12);
							}
						}
					}
				}
			}

			B.b();
			return true;
		}
	}

	public boolean a(boolean var1) {
		return false;
	}

	public List a(class_aqn var1, boolean var2) {
		return null;
	}

	public List a(class_aua var1, boolean var2) {
		return null;
	}

	public List b(Entity var1, class_ayk var2) {
		return this.a(var1, var2, class_rb.d);
	}

	public List a(Entity var1, class_ayk var2, Predicate var3) {
		ArrayList var4 = Lists.newArrayList();
		int var5 = MathHelper.c((var2.a - 2.0D) / 16.0D);
		int var6 = MathHelper.c((var2.d + 2.0D) / 16.0D);
		int var7 = MathHelper.c((var2.c - 2.0D) / 16.0D);
		int var8 = MathHelper.c((var2.f + 2.0D) / 16.0D);

		for (int var9 = var5; var9 <= var6; ++var9) {
			for (int var10 = var7; var10 <= var8; ++var10) {
				if (this.a(var9, var10, true)) {
					this.a(var9, var10).a(var1, var2, var4, var3);
				}
			}
		}

		return var4;
	}

	public List a(Class var1, Predicate var2) {
		ArrayList var3 = Lists.newArrayList();
		Iterator var4 = f.iterator();

		while (var4.hasNext()) {
			Entity var5 = (Entity) var4.next();
			if (var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
				var3.add(var5);
			}
		}

		return var3;
	}

	public List b(Class var1, Predicate var2) {
		ArrayList var3 = Lists.newArrayList();
		Iterator var4 = j.iterator();

		while (var4.hasNext()) {
			Entity var5 = (Entity) var4.next();
			if (var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
				var3.add(var5);
			}
		}

		return var3;
	}

	public List a(Class var1, class_ayk var2) {
		return this.a(var1, var2, class_rb.d);
	}

	public List a(Class var1, class_ayk var2, Predicate var3) {
		int var4 = MathHelper.c((var2.a - 2.0D) / 16.0D);
		int var5 = MathHelper.c((var2.d + 2.0D) / 16.0D);
		int var6 = MathHelper.c((var2.c - 2.0D) / 16.0D);
		int var7 = MathHelper.c((var2.f + 2.0D) / 16.0D);
		ArrayList var8 = Lists.newArrayList();

		for (int var9 = var4; var9 <= var5; ++var9) {
			for (int var10 = var6; var10 <= var7; ++var10) {
				if (this.a(var9, var10, true)) {
					this.a(var9, var10).a(var1, var2, var8, var3);
				}
			}
		}

		return var8;
	}

	public Entity a(Class var1, class_ayk var2, Entity var3) {
		List var4 = this.a(var1, var2);
		Entity var5 = null;
		double var6 = Double.MAX_VALUE;

		for (int var8 = 0; var8 < var4.size(); ++var8) {
			Entity var9 = (Entity) var4.get(var8);
			if ((var9 != var3) && class_rb.d.apply(var9)) {
				double var10 = var3.h(var9);
				if (var10 <= var6) {
					var5 = var9;
					var6 = var10;
				}
			}
		}

		return var5;
	}

	public Entity a(int var1) {
		return (Entity) l.a(var1);
	}

	public void b(class_cj var1, TileEntity var2) {
		if (this.e(var1)) {
			this.f(var1).e();
		}

	}

	public int a(Class var1) {
		int var2 = 0;
		Iterator var3 = f.iterator();

		while (true) {
			Entity var4;
			do {
				if (!var3.hasNext()) {
					return var2;
				}

				var4 = (Entity) var3.next();
			} while ((var4 instanceof class_rh) && ((class_rh) var4).cr());

			if (var1.isAssignableFrom(var4.getClass())) {
				++var2;
			}
		}
	}

	public void a(Collection var1) {
		f.addAll(var1);
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			Entity var3 = (Entity) var2.next();
			this.b(var3);
		}

	}

	public void c(Collection var1) {
		g.addAll(var1);
	}

	public boolean a(Block var1, class_cj var2, boolean var3, class_cq var4, Entity var5, class_aco var6) {
		Block var7 = p(var2).c();
		class_ayk var8 = var3 ? null : var1.a(this, var2, var1.S());
		return (var8 != null) && !this.a(var8, var5) ? false : ((var7.v() == class_avq.q) && (var1 == Blocks.ANVIL) ? true : var7.v().j() && var1.a(this, var2, var4, var6));
	}

	public int H() {
		return a;
	}

	public void b(int var1) {
		a = var1;
	}

	@Override
	public int a(class_cj var1, class_cq var2) {
		class_apn var3 = p(var1);
		return var3.c().b(this, var1, var3, var2);
	}

	public class_agt I() {
		return x.t();
	}

	public int y(class_cj var1) {
		byte var2 = 0;
		int var3 = Math.max(var2, this.a(var1.b(), class_cq.a));
		if (var3 >= 15) {
			return var3;
		} else {
			var3 = Math.max(var3, this.a(var1.a(), class_cq.b));
			if (var3 >= 15) {
				return var3;
			} else {
				var3 = Math.max(var3, this.a(var1.c(), class_cq.c));
				if (var3 >= 15) {
					return var3;
				} else {
					var3 = Math.max(var3, this.a(var1.d(), class_cq.d));
					if (var3 >= 15) {
						return var3;
					} else {
						var3 = Math.max(var3, this.a(var1.e(), class_cq.e));
						if (var3 >= 15) {
							return var3;
						} else {
							var3 = Math.max(var3, this.a(var1.f(), class_cq.f));
							return var3 >= 15 ? var3 : var3;
						}
					}
				}
			}
		}
	}

	public boolean b(class_cj var1, class_cq var2) {
		return this.c(var1, var2) > 0;
	}

	public int c(class_cj var1, class_cq var2) {
		class_apn var3 = p(var1);
		Block var4 = var3.c();
		return var4.x() ? this.y(var1) : var4.a(this, var1, var3, var2);
	}

	public boolean z(class_cj var1) {
		return this.c(var1.b(), class_cq.a) > 0 ? true : (this.c(var1.a(), class_cq.b) > 0 ? true : (this.c(var1.c(), class_cq.c) > 0 ? true : (this.c(var1.d(), class_cq.d) > 0 ? true : (this.c(var1.e(), class_cq.e) > 0 ? true : this.c(var1.f(), class_cq.f) > 0))));
	}

	public int A(class_cj var1) {
		int var2 = 0;
		class_cq[] var3 = class_cq.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_cq var6 = var3[var5];
			int var7 = this.c(var1.a(var6), var6);
			if (var7 >= 15) {
				return 15;
			}

			if (var7 > var2) {
				var2 = var7;
			}
		}

		return var2;
	}

	public class_yu a(Entity var1, double var2) {
		return this.a(var1.s, var1.t, var1.u, var2);
	}

	public class_yu a(double var1, double var3, double var5, double var7) {
		double var9 = -1.0D;
		class_yu var11 = null;

		for (int var12 = 0; var12 < j.size(); ++var12) {
			class_yu var13 = (class_yu) j.get(var12);
			if (class_rb.d.apply(var13)) {
				double var14 = var13.e(var1, var3, var5);
				if (((var7 < 0.0D) || (var14 < (var7 * var7))) && ((var9 == -1.0D) || (var14 < var9))) {
					var9 = var14;
					var11 = var13;
				}
			}
		}

		return var11;
	}

	public boolean b(double var1, double var3, double var5, double var7) {
		for (int var9 = 0; var9 < j.size(); ++var9) {
			class_yu var10 = (class_yu) j.get(var9);
			if (class_rb.d.apply(var10)) {
				double var11 = var10.e(var1, var3, var5);
				if ((var7 < 0.0D) || (var11 < (var7 * var7))) {
					return true;
				}
			}
		}

		return false;
	}

	public class_yu a(Entity var1, double var2, double var4) {
		return this.a(var1.s, var1.t, var1.u, var2, var4);
	}

	public class_yu a(class_cj var1, double var2, double var4) {
		return this.a(var1.n() + 0.5F, var1.o() + 0.5F, var1.p() + 0.5F, var2, var4);
	}

	public class_yu a(double var1, double var3, double var5, double var7, double var9) {
		double var11 = -1.0D;
		class_yu var13 = null;

		for (int var14 = 0; var14 < j.size(); ++var14) {
			class_yu var15 = (class_yu) j.get(var14);
			if (!var15.bI.a && var15.al() && !var15.w()) {
				double var16 = var15.e(var1, var15.t, var5);
				double var18 = var7;
				if (var15.aA()) {
					var18 = var7 * 0.800000011920929D;
				}

				if (var15.aD()) {
					float var20 = var15.ch();
					if (var20 < 0.1F) {
						var20 = 0.1F;
					}

					var18 *= 0.7F * var20;
				}

				if (((var9 < 0.0D) || (Math.abs(var15.t - var3) < (var9 * var9))) && ((var7 < 0.0D) || (var16 < (var18 * var18))) && ((var11 == -1.0D) || (var16 < var11))) {
					var11 = var16;
					var13 = var15;
				}
			}
		}

		return var13;
	}

	public class_yu a(String var1) {
		for (int var2 = 0; var2 < j.size(); ++var2) {
			class_yu var3 = (class_yu) j.get(var2);
			if (var1.equals(var3.e_())) {
				return var3;
			}
		}

		return null;
	}

	public class_yu b(UUID var1) {
		for (int var2 = 0; var2 < j.size(); ++var2) {
			class_yu var3 = (class_yu) j.get(var2);
			if (var1.equals(var3.aQ())) {
				return var3;
			}
		}

		return null;
	}

	public void K() throws class_agp {
		w.c();
	}

	public long L() {
		return x.a();
	}

	public long M() {
		return x.e();
	}

	public long N() {
		return x.f();
	}

	public void b(long var1) {
		x.c(var1);
	}

	public class_cj O() {
		class_cj var1 = new class_cj(x.b(), x.c(), x.d());
		if (!ah().a(var1)) {
			var1 = this.m(new class_cj(ah().f(), 0.0D, ah().g()));
		}

		return var1;
	}

	public void B(class_cj var1) {
		x.a(var1);
	}

	public boolean a(class_yu var1, class_cj var2) {
		return true;
	}

	public void a(Entity var1, byte var2) {
	}

	public class_aqk P() {
		return v;
	}

	public void c(class_cj var1, Block var2, int var3, int var4) {
		var2.a(this, var1, p(var1), var3, var4);
	}

	public class_axu Q() {
		return w;
	}

	public class_axt R() {
		return x;
	}

	public class_agm S() {
		return x.w();
	}

	public void e() {
	}

	public float h(float var1) {
		return (q + ((r - q) * var1)) * this.j(var1);
	}

	public float j(float var1) {
		return o + ((p - o) * var1);
	}

	public boolean T() {
		return this.h(1.0F) > 0.9D;
	}

	public boolean U() {
		return this.j(1.0F) > 0.2D;
	}

	public boolean C(class_cj var1) {
		if (!U()) {
			return false;
		} else if (!i(var1)) {
			return false;
		} else if (q(var1).o() > var1.o()) {
			return false;
		} else {
			class_ahb var2 = this.b(var1);
			return var2.d() ? false : (this.f(var1, false) ? false : var2.e());
		}
	}

	public boolean D(class_cj var1) {
		class_ahb var2 = this.b(var1);
		return var2.f();
	}

	public class_aye V() {
		return z;
	}

	public void a(String var1, class_axj var2) {
		z.a(var1, var2);
	}

	public class_axj a(Class var1, String var2) {
		return z.a(var1, var2);
	}

	public int b(String var1) {
		return z.a(var1);
	}

	public void a(int var1, class_cj var2, int var3) {
		for (int var4 = 0; var4 < u.size(); ++var4) {
			((class_agq) u.get(var4)).a(var1, var2, var3);
		}

	}

	public void b(int var1, class_cj var2, int var3) {
		this.a((class_yu) null, var1, var2, var3);
	}

	public void a(class_yu var1, int var2, class_cj var3, int var4) {
		try {
			for (int var5 = 0; var5 < u.size(); ++var5) {
				((class_agq) u.get(var5)).a(var1, var2, var3, var4);
			}

		} catch (Throwable var8) {
			class_b var6 = class_b.a(var8, "Playing level event");
			class_c var7 = var6.a("Level event being played");
			var7.a("Block coordinates", class_c.a(var3));
			var7.a("Event source", var1);
			var7.a("Event type", Integer.valueOf(var2));
			var7.a("Event data", Integer.valueOf(var4));
			throw new class_e(var6);
		}
	}

	public int W() {
		return 256;
	}

	public int X() {
		return t.m() ? 128 : 256;
	}

	public Random a(int var1, int var2, int var3) {
		long var4 = (var1 * 341873128712L) + (var2 * 132897987541L) + R().a() + var3;
		s.setSeed(var4);
		return s;
	}

	public class_cj a(String var1, class_cj var2) {
		return P().a(this, var1, var2);
	}

	public class_c a(class_b var1) {
		class_c var2 = var1.a("Affected level", 1);
		var2.a("Level name", x == null ? "????" : x.j());
		var2.a("All players", new Callable() {
			public String a() {
				return j.size() + " total; " + j.toString();
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var2.a("Chunk stats", new Callable() {
			public String a() {
				return v.f();
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});

		try {
			x.a(var2);
		} catch (Throwable var4) {
			var2.a("Level Data Unobtainable", var4);
		}

		return var2;
	}

	public void c(int var1, class_cj var2, int var3) {
		for (int var4 = 0; var4 < u.size(); ++var4) {
			class_agq var5 = (class_agq) u.get(var4);
			var5.b(var1, var2, var3);
		}

	}

	public Calendar aa() {
		if ((M() % 600L) == 0L) {
			J.setTimeInMillis(MinecraftServer.aB());
		}

		return J;
	}

	public class_ays ab() {
		return C;
	}

	public void f(class_cj var1, Block var2) {
		Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

		while (var3.hasNext()) {
			class_cq var4 = (class_cq) var3.next();
			class_cj var5 = var1.a(var4);
			if (this.e(var5)) {
				class_apn var6 = p(var5);
				if (Blocks.UNPOWERED_COMPARATOR.e(var6.c())) {
					var6.c().a(this, var5, var6, var2);
				} else if (var6.c().x()) {
					var5 = var5.a(var4);
					var6 = p(var5);
					if (Blocks.UNPOWERED_COMPARATOR.e(var6.c())) {
						var6.c().a(this, var5, var6, var2);
					}
				}
			}
		}

	}

	public class_pt E(class_cj var1) {
		long var2 = 0L;
		float var4 = 0.0F;
		if (this.e(var1)) {
			var4 = this.B();
			var2 = this.f(var1).x();
		}

		return new class_pt(ac(), N(), var2, var4);
	}

	public class_ps ac() {
		return R().x();
	}

	public int ad() {
		return H;
	}

	public void c(int var1) {
		H = var1;
	}

	public void d(int var1) {
		I = var1;
	}

	public boolean af() {
		return y;
	}

	public class_ux ag() {
		return A;
	}

	public class_aqg ah() {
		return L;
	}

	public boolean c(int var1, int var2) {
		class_cj var3 = O();
		int var4 = ((var1 * 16) + 8) - var3.n();
		int var5 = ((var2 * 16) + 8) - var3.p();
		short var6 = 128;
		return (var4 >= -var6) && (var4 <= var6) && (var5 >= -var6) && (var5 <= var6);
	}
}
