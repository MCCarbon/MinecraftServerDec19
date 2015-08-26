package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.Maps;

public abstract class class_xh extends Entity implements class_qb {
	private static final class_jz a;
	private static final class_jz b;
	private static final class_jz c;
	private static final class_jz d;
	private static final class_jz e;
	private static final class_jz f;
	private boolean g;
	private String h;
	private static final int[][][] i;
	private int as;
	private double at;
	private double au;
	private double av;
	private double aw;
	private double ax;

	public class_xh(class_ago var1) {
		super(var1);
		k = true;
		this.a(0.98F, 0.7F);
	}

	public static class_xh a(class_ago var0, double var1, double var3, double var5, class_xh.class_a_in_class_xh var7) {
		switch (class_xh.SyntheticClass_1.a[var7.ordinal()]) {
			case 1:
				return new class_xi(var0, var1, var3, var5);
			case 2:
				return new class_xl(var0, var1, var3, var5);
			case 3:
				return new class_xp(var0, var1, var3, var5);
			case 4:
				return new class_xo(var0, var1, var3, var5);
			case 5:
				return new class_xm(var0, var1, var3, var5);
			case 6:
				return new class_xj(var0, var1, var3, var5);
			default:
				return new class_xn(var0, var1, var3, var5);
		}
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	protected void h() {
		ac.a(a, Integer.valueOf(0));
		ac.a(b, Integer.valueOf(1));
		ac.a(c, Float.valueOf(0.0F));
		ac.a(d, Integer.valueOf(0));
		ac.a(e, Integer.valueOf(6));
		ac.a(f, Boolean.valueOf(false));
	}

	@Override
	public class_ayk j(Entity var1) {
		return var1.ah() ? var1.aX() : null;
	}

	@Override
	public class_ayk V() {
		return null;
	}

	@Override
	public boolean ah() {
		return true;
	}

	public class_xh(class_ago var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
		v = 0.0D;
		w = 0.0D;
		x = 0.0D;
		p = var2;
		q = var4;
		r = var6;
	}

	@Override
	public double aq() {
		return 0.0D;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (!o.D && !I) {
			if (this.b(var1)) {
				return false;
			} else {
				this.j(-r());
				this.i(10);
				af();
				this.a(p() + (var2 * 10.0F));
				boolean var3 = (var1.j() instanceof class_yu) && ((class_yu) var1.j()).bI.d;
				if (var3 || (p() > 40.0F)) {
					if (l != null) {
						l.a((Entity) null);
					}

					if (var3 && !k_()) {
						L();
					} else {
						this.a(var1);
					}
				}

				return true;
			}
		} else {
			return true;
		}
	}

	public void a(class_qi var1) {
		L();
		if (o.S().b("doEntityDrops")) {
			class_aco var2 = new class_aco(Items.aB, 1);
			if (h != null) {
				var2.c(h);
			}

			this.a(var2, 0.0F);
		}

	}

	@Override
	public boolean ag() {
		return !I;
	}

	@Override
	public void L() {
		super.L();
	}

	@Override
	public void r_() {
		if (q() > 0) {
			this.i(q() - 1);
		}

		if (p() > 0.0F) {
			this.a(p() - 1.0F);
		}

		if (t < -64.0D) {
			Q();
		}

		int var2;
		if (!o.D && (o instanceof class_ll)) {
			o.B.a("portal");
			MinecraftServer var1 = ((class_ll) o).t();
			var2 = N();
			if (ak) {
				if (var1.E()) {
					if ((m == null) && (al++ >= var2)) {
						al = var2;
						aj = at();
						byte var3;
						if (o.t.p().a() == -1) {
							var3 = 0;
						} else {
							var3 = -1;
						}

						this.a(var3, (class_cj) null);
					}

					ak = false;
				}
			} else {
				if (al > 0) {
					al -= 4;
				}

				if (al < 0) {
					al = 0;
				}
			}

			if (aj > 0) {
				--aj;
			}

			o.B.b();
		}

		if (o.D) {
			if (as > 0) {
				double var15 = s + ((at - s) / as);
				double var17 = t + ((au - t) / as);
				double var18 = u + ((av - u) / as);
				double var7 = class_oa.g(aw - y);
				y = (float) (y + (var7 / as));
				z = (float) (z + ((ax - z) / as));
				--as;
				this.b(var15, var17, var18);
				this.b(y, z);
			} else {
				this.b(s, t, u);
				this.b(y, z);
			}

		} else {
			p = s;
			q = t;
			r = u;
			w -= 0.03999999910593033D;
			int var14 = class_oa.c(s);
			var2 = class_oa.c(t);
			int var16 = class_oa.c(u);
			if (class_aih.d(o, new class_cj(var14, var2 - 1, var16))) {
				--var2;
			}

			class_cj var4 = new class_cj(var14, var2, var16);
			class_apn var5 = o.p(var4);
			if (class_aih.d(var5)) {
				this.a(var4, var5);
				if (var5.c() == Blocks.ACTIVATOR_RAIL) {
					this.a(var14, var2, var16, ((Boolean) var5.b(class_amc.N)).booleanValue());
				}
			} else {
				this.n();
			}

			S();
			z = 0.0F;
			double var6 = p - s;
			double var8 = r - u;
			if (((var6 * var6) + (var8 * var8)) > 0.001D) {
				y = (float) ((class_oa.b(var8, var6) * 180.0D) / 3.141592653589793D);
				if (g) {
					y += 180.0F;
				}
			}

			double var10 = class_oa.g(y - A);
			if ((var10 < -170.0D) || (var10 >= 170.0D)) {
				y += 180.0F;
				g = !g;
			}

			this.b(y, z);
			Iterator var12 = o.b(this, aX().b(0.20000000298023224D, 0.0D, 0.20000000298023224D)).iterator();

			while (var12.hasNext()) {
				Entity var13 = (Entity) var12.next();
				if ((var13 != l) && var13.ah() && (var13 instanceof class_xh)) {
					var13.i(this);
				}
			}

			if ((l != null) && l.I) {
				if (l.m == this) {
					l.m = null;
				}

				l = null;
			}

			Z();
		}
	}

	protected double m() {
		return 0.4D;
	}

	public void a(int var1, int var2, int var3, boolean var4) {
	}

	protected void n() {
		double var1 = this.m();
		v = class_oa.a(v, -var1, var1);
		x = class_oa.a(x, -var1, var1);
		if (C) {
			v *= 0.5D;
			w *= 0.5D;
			x *= 0.5D;
		}

		this.d(v, w, x);
		if (!C) {
			v *= 0.949999988079071D;
			w *= 0.949999988079071D;
			x *= 0.949999988079071D;
		}

	}

	protected void a(class_cj var1, class_apn var2) {
		O = 0.0F;
		class_aym var3 = this.k(s, t, u);
		t = var1.o();
		boolean var4 = false;
		boolean var5 = false;
		class_aih var6 = (class_aih) var2.c();
		if (var6 == Blocks.GOLDEN_RAIL) {
			var4 = ((Boolean) var2.b(class_amc.N)).booleanValue();
			var5 = !var4;
		}

		double var7 = 0.0078125D;
		class_aih.class_b_in_class_aih var9 = (class_aih.class_b_in_class_aih) var2.b(var6.n());
		switch (class_xh.SyntheticClass_1.b[var9.ordinal()]) {
			case 1:
				v -= 0.0078125D;
				++t;
				break;
			case 2:
				v += 0.0078125D;
				++t;
				break;
			case 3:
				x += 0.0078125D;
				++t;
				break;
			case 4:
				x -= 0.0078125D;
				++t;
		}

		int[][] var10 = i[var9.a()];
		double var11 = var10[1][0] - var10[0][0];
		double var13 = var10[1][2] - var10[0][2];
		double var15 = Math.sqrt((var11 * var11) + (var13 * var13));
		double var17 = (v * var11) + (x * var13);
		if (var17 < 0.0D) {
			var11 = -var11;
			var13 = -var13;
		}

		double var19 = Math.sqrt((v * v) + (x * x));
		if (var19 > 2.0D) {
			var19 = 2.0D;
		}

		v = (var19 * var11) / var15;
		x = (var19 * var13) / var15;
		double var21;
		double var23;
		double var25;
		double var27;
		if (l instanceof class_rg) {
			var21 = ((class_rg) l).be;
			if (var21 > 0.0D) {
				var23 = -Math.sin((l.y * 3.1415927F) / 180.0F);
				var25 = Math.cos((l.y * 3.1415927F) / 180.0F);
				var27 = (v * v) + (x * x);
				if (var27 < 0.01D) {
					v += var23 * 0.1D;
					x += var25 * 0.1D;
					var5 = false;
				}
			}
		}

		if (var5) {
			var21 = Math.sqrt((v * v) + (x * x));
			if (var21 < 0.03D) {
				v *= 0.0D;
				w *= 0.0D;
				x *= 0.0D;
			} else {
				v *= 0.5D;
				w *= 0.0D;
				x *= 0.5D;
			}
		}

		var21 = 0.0D;
		var23 = var1.n() + 0.5D + (var10[0][0] * 0.5D);
		var25 = var1.p() + 0.5D + (var10[0][2] * 0.5D);
		var27 = var1.n() + 0.5D + (var10[1][0] * 0.5D);
		double var29 = var1.p() + 0.5D + (var10[1][2] * 0.5D);
		var11 = var27 - var23;
		var13 = var29 - var25;
		double var31;
		double var33;
		if (var11 == 0.0D) {
			s = var1.n() + 0.5D;
			var21 = u - var1.p();
		} else if (var13 == 0.0D) {
			u = var1.p() + 0.5D;
			var21 = s - var1.n();
		} else {
			var31 = s - var23;
			var33 = u - var25;
			var21 = ((var31 * var11) + (var33 * var13)) * 2.0D;
		}

		s = var23 + (var11 * var21);
		u = var25 + (var13 * var21);
		this.b(s, t, u);
		var31 = v;
		var33 = x;
		if (l != null) {
			var31 *= 0.75D;
			var33 *= 0.75D;
		}

		double var35 = this.m();
		var31 = class_oa.a(var31, -var35, var35);
		var33 = class_oa.a(var33, -var35, var35);
		this.d(var31, 0.0D, var33);
		if ((var10[0][1] != 0) && ((class_oa.c(s) - var1.n()) == var10[0][0]) && ((class_oa.c(u) - var1.p()) == var10[0][2])) {
			this.b(s, t + var10[0][1], u);
		} else if ((var10[1][1] != 0) && ((class_oa.c(s) - var1.n()) == var10[1][0]) && ((class_oa.c(u) - var1.p()) == var10[1][2])) {
			this.b(s, t + var10[1][1], u);
		}

		this.o();
		class_aym var37 = this.k(s, t, u);
		if ((var37 != null) && (var3 != null)) {
			double var38 = (var3.b - var37.b) * 0.05D;
			var19 = Math.sqrt((v * v) + (x * x));
			if (var19 > 0.0D) {
				v = (v / var19) * (var19 + var38);
				x = (x / var19) * (var19 + var38);
			}

			this.b(s, var37.b, u);
		}

		int var44 = class_oa.c(s);
		int var39 = class_oa.c(u);
		if ((var44 != var1.n()) || (var39 != var1.p())) {
			var19 = Math.sqrt((v * v) + (x * x));
			v = var19 * (var44 - var1.n());
			x = var19 * (var39 - var1.p());
		}

		if (var4) {
			double var40 = Math.sqrt((v * v) + (x * x));
			if (var40 > 0.01D) {
				double var42 = 0.06D;
				v += (v / var40) * var42;
				x += (x / var40) * var42;
			} else if (var9 == class_aih.class_b_in_class_aih.b) {
				if (o.p(var1.e()).c().x()) {
					v = 0.02D;
				} else if (o.p(var1.f()).c().x()) {
					v = -0.02D;
				}
			} else if (var9 == class_aih.class_b_in_class_aih.a) {
				if (o.p(var1.c()).c().x()) {
					x = 0.02D;
				} else if (o.p(var1.d()).c().x()) {
					x = -0.02D;
				}
			}
		}

	}

	protected void o() {
		if (l != null) {
			v *= 0.996999979019165D;
			w *= 0.0D;
			x *= 0.996999979019165D;
		} else {
			v *= 0.9599999785423279D;
			w *= 0.0D;
			x *= 0.9599999785423279D;
		}

	}

	@Override
	public void b(double var1, double var3, double var5) {
		s = var1;
		t = var3;
		u = var5;
		float var7 = J / 2.0F;
		float var8 = K;
		this.a((new class_ayk(var1 - var7, var3, var5 - var7, var1 + var7, var3 + var8, var5 + var7)));
	}

	public class_aym k(double var1, double var3, double var5) {
		int var7 = class_oa.c(var1);
		int var8 = class_oa.c(var3);
		int var9 = class_oa.c(var5);
		if (class_aih.d(o, new class_cj(var7, var8 - 1, var9))) {
			--var8;
		}

		class_apn var10 = o.p(new class_cj(var7, var8, var9));
		if (class_aih.d(var10)) {
			class_aih.class_b_in_class_aih var11 = (class_aih.class_b_in_class_aih) var10.b(((class_aih) var10.c()).n());
			int[][] var12 = i[var11.a()];
			double var13 = 0.0D;
			double var15 = var7 + 0.5D + (var12[0][0] * 0.5D);
			double var17 = var8 + 0.0625D + (var12[0][1] * 0.5D);
			double var19 = var9 + 0.5D + (var12[0][2] * 0.5D);
			double var21 = var7 + 0.5D + (var12[1][0] * 0.5D);
			double var23 = var8 + 0.0625D + (var12[1][1] * 0.5D);
			double var25 = var9 + 0.5D + (var12[1][2] * 0.5D);
			double var27 = var21 - var15;
			double var29 = (var23 - var17) * 2.0D;
			double var31 = var25 - var19;
			if (var27 == 0.0D) {
				var1 = var7 + 0.5D;
				var13 = var5 - var9;
			} else if (var31 == 0.0D) {
				var5 = var9 + 0.5D;
				var13 = var1 - var7;
			} else {
				double var33 = var1 - var15;
				double var35 = var5 - var19;
				var13 = ((var33 * var27) + (var35 * var31)) * 2.0D;
			}

			var1 = var15 + (var27 * var13);
			var3 = var17 + (var29 * var13);
			var5 = var19 + (var31 * var13);
			if (var29 < 0.0D) {
				++var3;
			}

			if (var29 > 0.0D) {
				var3 += 0.5D;
			}

			return new class_aym(var1, var3, var5);
		} else {
			return null;
		}
	}

	@Override
	protected void a(class_dn var1) {
		if (var1.p("CustomDisplayTile")) {
			Block var2;
			if (var1.b("DisplayTile", 8)) {
				var2 = Block.b(var1.l("DisplayTile"));
			} else {
				var2 = Block.c(var1.h("DisplayTile"));
			}

			int var3 = var1.h("DisplayData");
			this.a(var2 == null ? Blocks.AIR.S() : var2.a(var3));
			this.k(var1.h("DisplayOffset"));
		}

		if (var1.b("CustomName", 8) && !var1.l("CustomName").isEmpty()) {
			h = var1.l("CustomName");
		}

	}

	@Override
	protected void b(class_dn var1) {
		if (x()) {
			var1.a("CustomDisplayTile", true);
			class_apn var2 = t();
			class_ke var3 = (class_ke) Block.c.b(var2.c());
			var1.a("DisplayTile", var3 == null ? "" : var3.toString());
			var1.a("DisplayData", var2.c().c(var2));
			var1.a("DisplayOffset", v());
		}

		if ((h != null) && !h.isEmpty()) {
			var1.a("CustomName", h);
		}

	}

	@Override
	public void i(Entity var1) {
		if (!o.D) {
			if (!var1.T && !T) {
				if (var1 != l) {
					if ((var1 instanceof class_rg) && (s() == class_xh.class_a_in_class_xh.a) && (((v * v) + (x * x)) > 0.01D) && !(var1 instanceof class_yu) && !(var1 instanceof class_vp) && (l == null) && (var1.m == null)) {
						var1.a(this);
					}

					double var2 = var1.s - s;
					double var4 = var1.u - u;
					double var6 = (var2 * var2) + (var4 * var4);
					if (var6 >= 9.999999747378752E-5D) {
						var6 = class_oa.a(var6);
						var2 /= var6;
						var4 /= var6;
						double var8 = 1.0D / var6;
						if (var8 > 1.0D) {
							var8 = 1.0D;
						}

						var2 *= var8;
						var4 *= var8;
						var2 *= 0.10000000149011612D;
						var4 *= 0.10000000149011612D;
						var2 *= 1.0F - U;
						var4 *= 1.0F - U;
						var2 *= 0.5D;
						var4 *= 0.5D;
						if (var1 instanceof class_xh) {
							double var10 = var1.s - s;
							double var12 = var1.u - u;
							class_aym var14 = (new class_aym(var10, 0.0D, var12)).a();
							class_aym var15 = (new class_aym(class_oa.b((y * 3.1415927F) / 180.0F), 0.0D, class_oa.a((y * 3.1415927F) / 180.0F))).a();
							double var16 = Math.abs(var14.b(var15));
							if (var16 < 0.800000011920929D) {
								return;
							}

							double var18 = var1.v + v;
							double var20 = var1.x + x;
							if ((((class_xh) var1).s() == class_xh.class_a_in_class_xh.c) && (s() != class_xh.class_a_in_class_xh.c)) {
								v *= 0.20000000298023224D;
								x *= 0.20000000298023224D;
								this.g(var1.v - var2, 0.0D, var1.x - var4);
								var1.v *= 0.949999988079071D;
								var1.x *= 0.949999988079071D;
							} else if ((((class_xh) var1).s() != class_xh.class_a_in_class_xh.c) && (s() == class_xh.class_a_in_class_xh.c)) {
								var1.v *= 0.20000000298023224D;
								var1.x *= 0.20000000298023224D;
								var1.g(v + var2, 0.0D, x + var4);
								v *= 0.949999988079071D;
								x *= 0.949999988079071D;
							} else {
								var18 /= 2.0D;
								var20 /= 2.0D;
								v *= 0.20000000298023224D;
								x *= 0.20000000298023224D;
								this.g(var18 - var2, 0.0D, var20 - var4);
								var1.v *= 0.20000000298023224D;
								var1.x *= 0.20000000298023224D;
								var1.g(var18 + var2, 0.0D, var20 + var4);
							}
						} else {
							this.g(-var2, 0.0D, -var4);
							var1.g(var2 / 4.0D, 0.0D, var4 / 4.0D);
						}
					}

				}
			}
		}
	}

	public void a(float var1) {
		ac.b(c, Float.valueOf(var1));
	}

	public float p() {
		return ((Float) ac.a(c)).floatValue();
	}

	public void i(int var1) {
		ac.b(a, Integer.valueOf(var1));
	}

	public int q() {
		return ((Integer) ac.a(a)).intValue();
	}

	public void j(int var1) {
		ac.b(b, Integer.valueOf(var1));
	}

	public int r() {
		return ((Integer) ac.a(b)).intValue();
	}

	public abstract class_xh.class_a_in_class_xh s();

	public class_apn t() {
		return !x() ? u() : Block.d(((Integer) J().a(d)).intValue());
	}

	public class_apn u() {
		return Blocks.AIR.S();
	}

	public int v() {
		return !x() ? w() : ((Integer) J().a(e)).intValue();
	}

	public int w() {
		return 6;
	}

	public void a(class_apn var1) {
		J().b(d, Integer.valueOf(Block.f(var1)));
		this.a(true);
	}

	public void k(int var1) {
		J().b(e, Integer.valueOf(var1));
		this.a(true);
	}

	public boolean x() {
		return ((Boolean) J().a(f)).booleanValue();
	}

	public void a(boolean var1) {
		J().b(f, Boolean.valueOf(var1));
	}

	@Override
	public void c(String var1) {
		h = var1;
	}

	@Override
	public String e_() {
		return h != null ? h : super.e_();
	}

	@Override
	public boolean k_() {
		return h != null;
	}

	@Override
	public String aS() {
		return h;
	}

	@Override
	public class_eu f_() {
		if (k_()) {
			class_fa var2 = new class_fa(h);
			var2.b().a(aW());
			var2.b().a(aQ().toString());
			return var2;
		} else {
			class_fb var1 = new class_fb(e_(), new Object[0]);
			var1.b().a(aW());
			var1.b().a(aQ().toString());
			return var1;
		}
	}

	static {
		a = class_kc.a(class_xh.class, class_kb.b);
		b = class_kc.a(class_xh.class, class_kb.b);
		c = class_kc.a(class_xh.class, class_kb.c);
		d = class_kc.a(class_xh.class, class_kb.b);
		e = class_kc.a(class_xh.class, class_kb.b);
		f = class_kc.a(class_xh.class, class_kb.g);
		i = new int[][][] { { { 0, 0, -1 }, { 0, 0, 1 } }, { { -1, 0, 0 }, { 1, 0, 0 } }, { { -1, -1, 0 }, { 1, 0, 0 } }, { { -1, 0, 0 }, { 1, -1, 0 } }, { { 0, 0, -1 }, { 0, -1, 1 } }, { { 0, -1, -1 }, { 0, 0, 1 } }, { { 0, 0, 1 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { 1, 0, 0 } } };
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[class_aih.class_b_in_class_aih.values().length];

		static {
			try {
				b[class_aih.class_b_in_class_aih.c.ordinal()] = 1;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				b[class_aih.class_b_in_class_aih.d.ordinal()] = 2;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				b[class_aih.class_b_in_class_aih.e.ordinal()] = 3;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[class_aih.class_b_in_class_aih.f.ordinal()] = 4;
			} catch (NoSuchFieldError var7) {
				;
			}

			a = new int[class_xh.class_a_in_class_xh.values().length];

			try {
				a[class_xh.class_a_in_class_xh.b.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_xh.class_a_in_class_xh.c.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_xh.class_a_in_class_xh.d.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_xh.class_a_in_class_xh.e.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_xh.class_a_in_class_xh.f.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_xh.class_a_in_class_xh.g.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_xh {
		a(0, "MinecartRideable"),
		b(1, "MinecartChest"),
		c(2, "MinecartFurnace"),
		d(3, "MinecartTNT"),
		e(4, "MinecartSpawner"),
		f(5, "MinecartHopper"),
		g(6, "MinecartCommandBlock");

		private static final Map h;
		private final int i;
		private final String j;

		private class_a_in_class_xh(int var3, String var4) {
			i = var3;
			j = var4;
		}

		public int a() {
			return i;
		}

		public String b() {
			return j;
		}

		static {
			h = Maps.newHashMap();
			class_xh.class_a_in_class_xh[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_xh.class_a_in_class_xh var3 = var0[var2];
				h.put(Integer.valueOf(var3.a()), var3);
			}

		}
	}
}
