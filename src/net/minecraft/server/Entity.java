package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public abstract class Entity implements ICommandListener {
	private static final class_ayk a = new class_ayk(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	private static int b;
	private int c;
	public double j;
	public boolean k;
	public Entity l;
	public Entity m;
	public boolean n;
	public class_ago o;
	public double p;
	public double q;
	public double r;
	public double s;
	public double t;
	public double u;
	public double v;
	public double w;
	public double x;
	public float y;
	public float z;
	public float A;
	public float B;
	private class_ayk f;
	public boolean C;
	public boolean D;
	public boolean E;
	public boolean F;
	public boolean G;
	protected boolean H;
	private boolean g;
	public boolean I;
	public float J;
	public float K;
	public float L;
	public float M;
	public float N;
	public float O;
	private int h;
	public double P;
	public double Q;
	public double R;
	public float S;
	public boolean T;
	public float U;
	protected Random V;
	public int W;
	public int X;
	private int i;
	protected boolean Y;
	public int Z;
	protected boolean aa;
	protected boolean ab;
	protected class_kc ac;
	private static final class_jz as;
	private static final class_jz at;
	private static final class_jz au;
	private static final class_jz av;
	private static final class_jz aw;
	private double ax;
	private double ay;
	public boolean ad;
	public int ae;
	public int af;
	public int ag;
	public boolean ah;
	public boolean ai;
	public int aj;
	protected boolean ak;
	protected int al;
	public int am;
	protected class_cj an;
	protected class_aym ao;
	protected class_cq ap;
	private boolean az;
	protected UUID aq;
	private final class_n aA;
	private final List aB;
	protected boolean ar;
	private final Set aC;
	private boolean aD;

	public Entity(class_ago var1) {
		c = b++;
		j = 1.0D;
		f = a;
		J = 0.6F;
		K = 1.8F;
		h = 1;
		V = new Random();
		X = 1;
		aa = true;
		aq = class_oa.a(V);
		aA = new class_n();
		aB = Lists.newArrayList();
		aC = Sets.newHashSet();
		o = var1;
		this.b(0.0D, 0.0D, 0.0D);
		if (var1 != null) {
			am = var1.t.p().a();
		}

		ac = new class_kc(this);
		ac.a(as, Byte.valueOf((byte) 0));
		ac.a(at, Integer.valueOf(300));
		ac.a(av, Boolean.valueOf(false));
		ac.a(au, "");
		ac.a(aw, Boolean.valueOf(false));
		this.h();
	}

	public int G() {
		return c;
	}

	public void d(int var1) {
		c = var1;
	}

	public Set H() {
		return aC;
	}

	public boolean a(String var1) {
		if (aC.size() >= 1024) {
			return false;
		} else {
			aC.add(var1);
			return true;
		}
	}

	public boolean b(String var1) {
		return aC.remove(var1);
	}

	public void I() {
		L();
	}

	protected abstract void h();

	public class_kc J() {
		return ac;
	}

	@Override
	public boolean equals(Object var1) {
		return var1 instanceof Entity ? ((Entity) var1).c == c : false;
	}

	@Override
	public int hashCode() {
		return c;
	}

	public void L() {
		I = true;
	}

	protected void a(float var1, float var2) {
		if ((var1 != J) || (var2 != K)) {
			float var3 = J;
			J = var1;
			K = var2;
			this.a(new class_ayk(aX().a, aX().b, aX().c, aX().a + J, aX().b + K, aX().c + J));
			if ((J > var3) && !aa && !o.D) {
				this.d(var3 - J, 0.0D, var3 - J);
			}
		}

	}

	protected void b(float var1, float var2) {
		y = var1 % 360.0F;
		z = var2 % 360.0F;
	}

	public void b(double var1, double var3, double var5) {
		s = var1;
		t = var3;
		u = var5;
		float var7 = J / 2.0F;
		float var8 = K;
		this.a(new class_ayk(var1 - var7, var3, var5 - var7, var1 + var7, var3 + var8, var5 + var7));
	}

	public void r_() {
		if (!o.D) {
			this.b(6, aC());
		}

		M();
	}

	public void M() {
		o.B.a("entityBaseTick");
		if ((m != null) && m.I) {
			m = null;
		}

		L = M;
		p = s;
		q = t;
		r = u;
		B = z;
		A = y;
		if (!o.D && (o instanceof class_ll)) {
			o.B.a("portal");
			MinecraftServer var1 = ((class_ll) o).t();
			int var2 = N();
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

		ab();
		Z();
		if (o.D) {
			i = 0;
		} else if (i > 0) {
			if (ab) {
				i -= 4;
				if (i < 0) {
					i = 0;
				}
			} else {
				if ((i % 20) == 0) {
					this.a(class_qi.c, 1.0F);
				}

				--i;
			}
		}

		if (ae()) {
			O();
			O *= 0.5F;
		}

		if (t < -64.0D) {
			Q();
		}

		if (!o.D) {
			this.b(0, i > 0);
		}

		aa = false;
		o.B.b();
	}

	public int N() {
		return 0;
	}

	protected void O() {
		if (!ab) {
			this.a(class_qi.d, 4.0F);
			this.e(15);
		}
	}

	public void e(int var1) {
		int var2 = var1 * 20;
		if (this instanceof class_rg) {
			var2 = class_aft.a((class_rg) this, var2);
		}

		if (i < var2) {
			i = var2;
		}

	}

	public void P() {
		i = 0;
	}

	protected void Q() {
		L();
	}

	public boolean c(double var1, double var3, double var5) {
		class_ayk var7 = aX().c(var1, var3, var5);
		return this.b(var7);
	}

	private boolean b(class_ayk var1) {
		return o.a(this, var1).isEmpty() && !o.d(var1);
	}

	public void d(double var1, double var3, double var5) {
		if (T) {
			this.a(aX().c(var1, var3, var5));
			this.m();
		} else {
			o.B.a("move");
			double var7 = s;
			double var9 = t;
			double var11 = u;
			if (H) {
				H = false;
				var1 *= 0.25D;
				var3 *= 0.05000000074505806D;
				var5 *= 0.25D;
				v = 0.0D;
				w = 0.0D;
				x = 0.0D;
			}

			double var13 = var1;
			double var15 = var3;
			double var17 = var5;
			boolean var19 = C && aA() && (this instanceof class_yu);
			if (var19) {
				double var20;
				for (var20 = 0.05D; (var1 != 0.0D) && o.a(this, aX().c(var1, -1.0D, 0.0D)).isEmpty(); var13 = var1) {
					if ((var1 < var20) && (var1 >= -var20)) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}
				}

				for (; (var5 != 0.0D) && o.a(this, aX().c(0.0D, -1.0D, var5)).isEmpty(); var17 = var5) {
					if ((var5 < var20) && (var5 >= -var20)) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}

				for (; (var1 != 0.0D) && (var5 != 0.0D) && o.a(this, aX().c(var1, -1.0D, var5)).isEmpty(); var17 = var5) {
					if ((var1 < var20) && (var1 >= -var20)) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}

					var13 = var1;
					if ((var5 < var20) && (var5 >= -var20)) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}
			}

			List var53 = o.a(this, aX().a(var1, var3, var5));
			class_ayk var21 = aX();

			class_ayk var23;
			for (Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(aX(), var3)) {
				var23 = (class_ayk) var22.next();
			}

			this.a(aX().c(0.0D, var3, 0.0D));
			boolean var54 = C || ((var15 != var3) && (var15 < 0.0D));

			class_ayk var24;
			Iterator var55;
			for (var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(aX(), var1)) {
				var24 = (class_ayk) var55.next();
			}

			this.a(aX().c(var1, 0.0D, 0.0D));

			for (var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(aX(), var5)) {
				var24 = (class_ayk) var55.next();
			}

			this.a(aX().c(0.0D, 0.0D, var5));
			if ((S > 0.0F) && var54 && ((var13 != var1) || (var17 != var5))) {
				double var56 = var1;
				double var25 = var3;
				double var27 = var5;
				class_ayk var29 = aX();
				this.a(var21);
				var3 = S;
				List var30 = o.a(this, aX().a(var13, var3, var17));
				class_ayk var31 = aX();
				class_ayk var32 = var31.a(var13, 0.0D, var17);
				double var33 = var3;

				class_ayk var36;
				for (Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.b(var32, var33)) {
					var36 = (class_ayk) var35.next();
				}

				var31 = var31.c(0.0D, var33, 0.0D);
				double var67 = var13;

				class_ayk var38;
				for (Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.a(var31, var67)) {
					var38 = (class_ayk) var37.next();
				}

				var31 = var31.c(var67, 0.0D, 0.0D);
				double var68 = var17;

				class_ayk var40;
				for (Iterator var39 = var30.iterator(); var39.hasNext(); var68 = var40.c(var31, var68)) {
					var40 = (class_ayk) var39.next();
				}

				var31 = var31.c(0.0D, 0.0D, var68);
				class_ayk var69 = aX();
				double var70 = var3;

				class_ayk var43;
				for (Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.b(var69, var70)) {
					var43 = (class_ayk) var42.next();
				}

				var69 = var69.c(0.0D, var70, 0.0D);
				double var71 = var13;

				class_ayk var45;
				for (Iterator var44 = var30.iterator(); var44.hasNext(); var71 = var45.a(var69, var71)) {
					var45 = (class_ayk) var44.next();
				}

				var69 = var69.c(var71, 0.0D, 0.0D);
				double var72 = var17;

				class_ayk var47;
				for (Iterator var46 = var30.iterator(); var46.hasNext(); var72 = var47.c(var69, var72)) {
					var47 = (class_ayk) var46.next();
				}

				var69 = var69.c(0.0D, 0.0D, var72);
				double var73 = (var67 * var67) + (var68 * var68);
				double var48 = (var71 * var71) + (var72 * var72);
				if (var73 > var48) {
					var1 = var67;
					var5 = var68;
					var3 = -var33;
					this.a(var31);
				} else {
					var1 = var71;
					var5 = var72;
					var3 = -var70;
					this.a(var69);
				}

				class_ayk var51;
				for (Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(aX(), var3)) {
					var51 = (class_ayk) var50.next();
				}

				this.a(aX().c(0.0D, var3, 0.0D));
				if (((var56 * var56) + (var27 * var27)) >= ((var1 * var1) + (var5 * var5))) {
					var1 = var56;
					var3 = var25;
					var5 = var27;
					this.a(var29);
				}
			}

			o.B.b();
			o.B.a("rest");
			this.m();
			D = (var13 != var1) || (var17 != var5);
			E = var15 != var3;
			C = E && (var15 < 0.0D);
			F = D || E;
			int var57 = class_oa.c(s);
			int var58 = class_oa.c(t - 0.20000000298023224D);
			int var59 = class_oa.c(u);
			class_cj var26 = new class_cj(var57, var58, var59);
			Block var60 = o.p(var26).c();
			if (var60.v() == class_avq.a) {
				Block var28 = o.p(var26.b()).c();
				if ((var28 instanceof class_akb) || (var28 instanceof class_anx) || (var28 instanceof class_akc)) {
					var60 = var28;
					var26 = var26.b();
				}
			}

			this.a(var3, C, var60, var26);
			if (var13 != var1) {
				v = 0.0D;
			}

			if (var17 != var5) {
				x = 0.0D;
			}

			if (var15 != var3) {
				var60.a(o, this);
			}

			if (U() && !var19 && (m == null)) {
				double var61 = s - var7;
				double var64 = t - var9;
				double var66 = u - var11;
				if (var60 != Blocks.LADDER) {
					var64 = 0.0D;
				}

				if ((var60 != null) && C) {
					var60.a(o, var26, this);
				}

				M = (float) (M + (class_oa.a((var61 * var61) + (var66 * var66)) * 0.6D));
				N = (float) (N + (class_oa.a((var61 * var61) + (var64 * var64) + (var66 * var66)) * 0.6D));
				if ((N > h) && (var60.v() != class_avq.a)) {
					h = (int) N + 1;
					if (Y()) {
						float var34 = class_oa.a((v * v * 0.20000000298023224D) + (w * w) + (x * x * 0.20000000298023224D)) * 0.35F;
						if (var34 > 1.0F) {
							var34 = 1.0F;
						}

						this.a(R(), var34, 1.0F + ((V.nextFloat() - V.nextFloat()) * 0.4F));
					}

					this.a(var26, var60);
				}
			}

			try {
				S();
			} catch (Throwable var52) {
				class_b var63 = class_b.a(var52, "Checking entity block collision");
				class_c var65 = var63.a("Entity being checked for collision");
				this.a(var65);
				throw new class_e(var63);
			}

			boolean var62 = X();
			if (o.e(aX().d(0.001D, 0.001D, 0.001D))) {
				this.f(1);
				if (!var62) {
					++i;
					if (i == 0) {
						this.e(8);
					}
				}
			} else if (i <= 0) {
				i = -X;
			}

			if (var62 && (i > 0)) {
				this.a("random.fizz", 0.7F, 1.6F + ((V.nextFloat() - V.nextFloat()) * 0.4F));
				i = -X;
			}

			o.B.b();
		}
	}

	private void m() {
		s = (aX().a + aX().d) / 2.0D;
		t = aX().b;
		u = (aX().c + aX().f) / 2.0D;
	}

	protected String R() {
		return "game.neutral.swim";
	}

	protected void S() {
		class_cj var1 = new class_cj(aX().a + 0.001D, aX().b + 0.001D, aX().c + 0.001D);
		class_cj var2 = new class_cj(aX().d - 0.001D, aX().e - 0.001D, aX().f - 0.001D);
		if (o.a(var1, var2)) {
			for (int var3 = var1.n(); var3 <= var2.n(); ++var3) {
				for (int var4 = var1.o(); var4 <= var2.o(); ++var4) {
					for (int var5 = var1.p(); var5 <= var2.p(); ++var5) {
						class_cj var6 = new class_cj(var3, var4, var5);
						class_apn var7 = o.p(var6);

						try {
							var7.c().a(o, var6, var7, this);
						} catch (Throwable var11) {
							class_b var9 = class_b.a(var11, "Colliding entity with block");
							class_c var10 = var9.a("Block being collided with");
							class_c.a(var10, var6, var7);
							throw new class_e(var9);
						}
					}
				}
			}
		}

	}

	protected void a(class_cj var1, Block var2) {
		Block.class_d_in_class_ail var3 = var2.H;
		if (o.p(var1.a()).c() == Blocks.SNOW_LAYER) {
			var3 = Blocks.SNOW_LAYER.H;
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		} else if (!var2.v().d()) {
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		}

	}

	public void a(String var1, float var2, float var3) {
		if (!T()) {
			o.a(this, var1, var2, var3);
		}

	}

	public boolean T() {
		return ((Boolean) ac.a(aw)).booleanValue();
	}

	public void b(boolean var1) {
		ac.b(aw, Boolean.valueOf(var1));
	}

	protected boolean U() {
		return true;
	}

	protected void a(double var1, boolean var3, Block var4, class_cj var5) {
		if (var3) {
			if (O > 0.0F) {
				if (var4 != null) {
					var4.a(o, var5, this, O);
				} else {
					this.e(O, 1.0F);
				}

				O = 0.0F;
			}
		} else if (var1 < 0.0D) {
			O = (float) (O - var1);
		}

	}

	public class_ayk V() {
		return null;
	}

	protected void f(int var1) {
		if (!ab) {
			this.a(class_qi.a, var1);
		}

	}

	public final boolean W() {
		return ab;
	}

	public void e(float var1, float var2) {
		if (l != null) {
			l.e(var1, var2);
		}

	}

	public boolean X() {
		return Y || o.C(new class_cj(s, t, u)) || o.C(new class_cj(s, t + K, u));
	}

	public boolean Y() {
		return Y;
	}

	public boolean Z() {
		if (o.a(aX().b(0.0D, -0.4000000059604645D, 0.0D).d(0.001D, 0.001D, 0.001D), class_avq.h, this)) {
			if (!Y && !aa) {
				aa();
			}

			O = 0.0F;
			Y = true;
			i = 0;
		} else {
			Y = false;
		}

		return Y;
	}

	protected void aa() {
		float var1 = class_oa.a((v * v * 0.20000000298023224D) + (w * w) + (x * x * 0.20000000298023224D)) * 0.2F;
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		this.a(ad(), var1, 1.0F + ((V.nextFloat() - V.nextFloat()) * 0.4F));
		float var2 = class_oa.c(aX().b);

		int var3;
		float var4;
		float var5;
		for (var3 = 0; var3 < (1.0F + (J * 20.0F)); ++var3) {
			var4 = ((V.nextFloat() * 2.0F) - 1.0F) * J;
			var5 = ((V.nextFloat() * 2.0F) - 1.0F) * J;
			o.a(class_cy.e, s + var4, var2 + 1.0F, u + var5, v, w - V.nextFloat() * 0.2F, x, new int[0]);
		}

		for (var3 = 0; var3 < (1.0F + (J * 20.0F)); ++var3) {
			var4 = ((V.nextFloat() * 2.0F) - 1.0F) * J;
			var5 = ((V.nextFloat() * 2.0F) - 1.0F) * J;
			o.a(class_cy.f, s + var4, var2 + 1.0F, u + var5, v, w, x, new int[0]);
		}

	}

	public void ab() {
		if (aB() && !Y()) {
			ac();
		}

	}

	protected void ac() {
		int var1 = class_oa.c(s);
		int var2 = class_oa.c(t - 0.20000000298023224D);
		int var3 = class_oa.c(u);
		class_cj var4 = new class_cj(var1, var2, var3);
		class_apn var5 = o.p(var4);
		Block var6 = var5.c();
		if (var6.b() != -1) {
			o.a(class_cy.L, s + ((V.nextFloat() - 0.5D) * J), aX().b + 0.1D, u + ((V.nextFloat() - 0.5D) * J), -v * 4.0D, 1.5D, -x * 4.0D, new int[] { Block.f(var5) });
		}

	}

	protected String ad() {
		return "game.neutral.swim.splash";
	}

	public boolean a(class_avq var1) {
		double var2 = t + aY();
		class_cj var4 = new class_cj(s, var2, u);
		class_apn var5 = o.p(var4);
		Block var6 = var5.c();
		if (var6.v() == var1) {
			float var7 = class_alf.b(var5.c().c(var5)) - 0.11111111F;
			float var8 = var4.o() + 1 - var7;
			boolean var9 = var2 < var8;
			return !var9 && (this instanceof class_yu) ? false : var9;
		} else {
			return false;
		}
	}

	public boolean ae() {
		return o.a(aX().b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), class_avq.i);
	}

	public void a(float var1, float var2, float var3) {
		float var4 = (var1 * var1) + (var2 * var2);
		if (var4 >= 1.0E-4F) {
			var4 = class_oa.c(var4);
			if (var4 < 1.0F) {
				var4 = 1.0F;
			}

			var4 = var3 / var4;
			var1 *= var4;
			var2 *= var4;
			float var5 = class_oa.a((y * 3.1415927F) / 180.0F);
			float var6 = class_oa.b((y * 3.1415927F) / 180.0F);
			v += (var1 * var6) - (var2 * var5);
			x += (var2 * var6) + (var1 * var5);
		}
	}

	public float f(float var1) {
		class_cj var2 = new class_cj(s, t + aY(), u);
		return o.e(var2) ? o.o(var2) : 0.0F;
	}

	public void a(class_ago var1) {
		o = var1;
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		p = s = var1;
		q = t = var3;
		r = u = var5;
		A = y = var7;
		B = z = var8;
		double var9 = A - var7;
		if (var9 < -180.0D) {
			A += 360.0F;
		}

		if (var9 >= 180.0D) {
			A -= 360.0F;
		}

		this.b(s, t, u);
		this.b(var7, var8);
	}

	public void a(class_cj var1, float var2, float var3) {
		this.b(var1.n() + 0.5D, var1.o(), var1.p() + 0.5D, var2, var3);
	}

	public void b(double var1, double var3, double var5, float var7, float var8) {
		P = p = s = var1;
		Q = q = t = var3;
		R = r = u = var5;
		y = var7;
		z = var8;
		this.b(s, t, u);
	}

	public float g(Entity var1) {
		float var2 = (float) (s - var1.s);
		float var3 = (float) (t - var1.t);
		float var4 = (float) (u - var1.u);
		return class_oa.c((var2 * var2) + (var3 * var3) + (var4 * var4));
	}

	public double e(double var1, double var3, double var5) {
		double var7 = s - var1;
		double var9 = t - var3;
		double var11 = u - var5;
		return (var7 * var7) + (var9 * var9) + (var11 * var11);
	}

	public double b(class_cj var1) {
		return var1.c(s, t, u);
	}

	public double c(class_cj var1) {
		return var1.d(s, t, u);
	}

	public double f(double var1, double var3, double var5) {
		double var7 = s - var1;
		double var9 = t - var3;
		double var11 = u - var5;
		return class_oa.a((var7 * var7) + (var9 * var9) + (var11 * var11));
	}

	public double h(Entity var1) {
		double var2 = s - var1.s;
		double var4 = t - var1.t;
		double var6 = u - var1.u;
		return (var2 * var2) + (var4 * var4) + (var6 * var6);
	}

	public void d(class_yu var1) {
	}

	public void i(Entity var1) {
		if ((var1.l != this) && (var1.m != this)) {
			if (!var1.T && !T) {
				double var2 = var1.s - s;
				double var4 = var1.u - u;
				double var6 = class_oa.a(var2, var4);
				if (var6 >= 0.009999999776482582D) {
					var6 = class_oa.a(var6);
					var2 /= var6;
					var4 /= var6;
					double var8 = 1.0D / var6;
					if (var8 > 1.0D) {
						var8 = 1.0D;
					}

					var2 *= var8;
					var4 *= var8;
					var2 *= 0.05000000074505806D;
					var4 *= 0.05000000074505806D;
					var2 *= 1.0F - U;
					var4 *= 1.0F - U;
					if (l == null) {
						this.g(-var2, 0.0D, -var4);
					}

					if (var1.l == null) {
						var1.g(var2, 0.0D, var4);
					}
				}

			}
		}
	}

	public void g(double var1, double var3, double var5) {
		v += var1;
		w += var3;
		x += var5;
		ai = true;
	}

	protected void af() {
		G = true;
	}

	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			af();
			return false;
		}
	}

	public class_aym g(float var1) {
		if (var1 == 1.0F) {
			return this.f(z, y);
		} else {
			float var2 = B + ((z - B) * var1);
			float var3 = A + ((y - A) * var1);
			return this.f(var2, var3);
		}
	}

	protected final class_aym f(float var1, float var2) {
		float var3 = class_oa.b((-var2 * 0.017453292F) - 3.1415927F);
		float var4 = class_oa.a((-var2 * 0.017453292F) - 3.1415927F);
		float var5 = -class_oa.b(-var1 * 0.017453292F);
		float var6 = class_oa.a(-var1 * 0.017453292F);
		return new class_aym(var4 * var5, var6, var3 * var5);
	}

	public boolean ag() {
		return false;
	}

	public boolean ah() {
		return false;
	}

	public void b(Entity var1, int var2) {
	}

	public boolean c(class_dn var1) {
		String var2 = aj();
		if (!I && (var2 != null)) {
			var1.a("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public boolean d(class_dn var1) {
		String var2 = aj();
		if (!I && (var2 != null) && (l == null)) {
			var1.a("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public void e(class_dn var1) {
		try {
			var1.a("Pos", this.a(new double[] { s, t, u }));
			var1.a("Motion", this.a(new double[] { v, w, x }));
			var1.a("Rotation", this.a(new float[] { y, z }));
			var1.a("FallDistance", O);
			var1.a("Fire", (short) i);
			var1.a("Air", (short) aF());
			var1.a("OnGround", C);
			var1.a("Dimension", am);
			var1.a("Invulnerable", az);
			var1.a("PortalCooldown", aj);
			var1.a("UUID", aQ());
			if ((aS() != null) && !aS().isEmpty()) {
				var1.a("CustomName", aS());
			}

			if (aT()) {
				var1.a("CustomNameVisible", aT());
			}

			aA.b(var1);
			if (T()) {
				var1.a("Silent", T());
			}

			if (ar) {
				var1.a("Glowing", ar);
			}

			if (aC.size() > 0) {
				class_du var2 = new class_du();
				Iterator var7 = aC.iterator();

				while (var7.hasNext()) {
					String var8 = (String) var7.next();
					var2.a((new class_ea(var8)));
				}

				var1.a("Tags", var2);
			}

			this.b(var1);
			if (m != null) {
				class_dn var6 = new class_dn();
				if (m.c(var6)) {
					var1.a("Riding", var6);
				}
			}

		} catch (Throwable var5) {
			class_b var3 = class_b.a(var5, "Saving entity NBT");
			class_c var4 = var3.a("Entity being saved");
			this.a(var4);
			throw new class_e(var3);
		}
	}

	public void f(class_dn var1) {
		try {
			class_du var2 = var1.c("Pos", 6);
			class_du var9 = var1.c("Motion", 6);
			class_du var10 = var1.c("Rotation", 5);
			v = var9.e(0);
			w = var9.e(1);
			x = var9.e(2);
			if (Math.abs(v) > 10.0D) {
				v = 0.0D;
			}

			if (Math.abs(w) > 10.0D) {
				w = 0.0D;
			}

			if (Math.abs(x) > 10.0D) {
				x = 0.0D;
			}

			p = P = s = var2.e(0);
			q = Q = t = var2.e(1);
			r = R = u = var2.e(2);
			A = y = var10.f(0);
			B = z = var10.f(1);
			this.i(y);
			this.j(y);
			O = var1.j("FallDistance");
			i = var1.g("Fire");
			this.h(var1.g("Air"));
			C = var1.p("OnGround");
			if (var1.e("Dimension")) {
				am = var1.h("Dimension");
			}

			az = var1.p("Invulnerable");
			aj = var1.h("PortalCooldown");
			if (var1.b("UUID")) {
				aq = var1.a("UUID");
			}

			this.b(s, t, u);
			this.b(y, z);
			if (var1.b("CustomName", 8)) {
				this.c(var1.l("CustomName"));
			}

			this.g(var1.p("CustomNameVisible"));
			aA.a(var1);
			this.b(var1.p("Silent"));
			ar = var1.p("Glowing");
			if (var1.b("Tags", 9)) {
				aC.clear();
				class_du var5 = var1.c("Tags", 8);
				int var6 = Math.min(var5.c(), 1024);

				for (int var7 = 0; var7 < var6; ++var7) {
					aC.add(var5.g(var7));
				}
			}

			this.a(var1);
			if (ai()) {
				this.b(s, t, u);
			}

		} catch (Throwable var8) {
			class_b var3 = class_b.a(var8, "Loading entity NBT");
			class_c var4 = var3.a("Entity being loaded");
			this.a(var4);
			throw new class_e(var3);
		}
	}

	protected boolean ai() {
		return true;
	}

	protected final String aj() {
		return EntityTypes.b(this);
	}

	protected abstract void a(class_dn var1);

	protected abstract void b(class_dn var1);

	public void ak() {
	}

	protected class_du a(double... var1) {
		class_du var2 = new class_du();
		double[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.a((new class_dp(var6)));
		}

		return var2;
	}

	protected class_du a(float... var1) {
		class_du var2 = new class_du();
		float[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			float var6 = var3[var5];
			var2.a((new class_dr(var6)));
		}

		return var2;
	}

	public class_xg a(Item var1, int var2) {
		return this.a(var1, var2, 0.0F);
	}

	public class_xg a(Item var1, int var2, float var3) {
		return this.a(new class_aco(var1, var2, 0), var3);
	}

	public class_xg a(class_aco var1, float var2) {
		if ((var1.b != 0) && (var1.b() != null)) {
			class_xg var3 = new class_xg(o, s, t + var2, u, var1);
			var3.o();
			o.a(var3);
			return var3;
		} else {
			return null;
		}
	}

	public boolean al() {
		return !I;
	}

	public boolean am() {
		if (T) {
			return false;
		} else {
			class_cj.class_a_in_class_cj var1 = new class_cj.class_a_in_class_cj(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

			for (int var2 = 0; var2 < 8; ++var2) {
				int var3 = class_oa.c(t + ((var2 >> 0) % 2 - 0.5F) * 0.1F + aY());
				int var4 = class_oa.c(s + ((var2 >> 1) % 2 - 0.5F) * J * 0.8F);
				int var5 = class_oa.c(u + ((var2 >> 2) % 2 - 0.5F) * J * 0.8F);
				if ((var1.n() != var4) || (var1.o() != var3) || (var1.p() != var5)) {
					var1.c(var4, var3, var5);
					if (o.p(var1).c().y()) {
						return true;
					}
				}
			}

			return false;
		}
	}

	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		return false;
	}

	public class_ayk j(Entity var1) {
		return null;
	}

	public void an() {
		if (m.I) {
			m = null;
		} else {
			v = 0.0D;
			w = 0.0D;
			x = 0.0D;
			r_();
			if (m != null) {
				m.ao();
				ay += m.y - m.A;

				for (ax += m.z - m.B; ay >= 180.0D; ay -= 360.0D) {
					;
				}

				while (ay < -180.0D) {
					ay += 360.0D;
				}

				while (ax >= 180.0D) {
					ax -= 360.0D;
				}

				while (ax < -180.0D) {
					ax += 360.0D;
				}

				double var1 = ay * 0.5D;
				double var3 = ax * 0.5D;
				float var5 = 10.0F;
				if (var1 > var5) {
					var1 = var5;
				}

				if (var1 < (-var5)) {
					var1 = (-var5);
				}

				if (var3 > var5) {
					var3 = var5;
				}

				if (var3 < (-var5)) {
					var3 = (-var5);
				}

				ay -= var1;
				ax -= var3;
			}
		}
	}

	public void ao() {
		if (l != null) {
			l.b(s, t + aq() + l.ap(), u);
		}
	}

	public double ap() {
		return 0.0D;
	}

	public double aq() {
		return K * 0.75D;
	}

	public void a(Entity var1) {
		ax = 0.0D;
		ay = 0.0D;
		if (var1 == null) {
			if (m != null) {
				this.b(m.s, m.aX().b + m.K, m.u, y, z);
				m.l = null;
			}

			m = null;
		} else {
			if (m != null) {
				m.l = null;
			}

			if (var1 != null) {
				for (Entity var2 = var1.m; var2 != null; var2 = var2.m) {
					if (var2 == this) {
						return;
					}
				}
			}

			m = var1;
			var1.l = this;
		}
	}

	public float ar() {
		return 0.1F;
	}

	public class_aym as() {
		return null;
	}

	public void d(class_cj var1) {
		if (aj > 0) {
			aj = at();
		} else {
			if (!o.D && !var1.equals(an)) {
				an = var1;
				class_apr.class_b_in_class_apr var2 = Blocks.PORTAL.e(o, var1);
				double var3 = var2.b().k() == class_cq.class_a_in_class_cq.a ? (double) var2.a().p() : (double) var2.a().n();
				double var5 = var2.b().k() == class_cq.class_a_in_class_cq.a ? u : s;
				var5 = Math.abs(class_oa.c(var5 - (var2.b().e().c() == class_cq.class_b_in_class_cq.b ? 1 : 0), var3, var3 - var2.d()));
				double var7 = class_oa.c(t - 1.0D, var2.a().o(), var2.a().o() - var2.e());
				ao = new class_aym(var5, var7, 0.0D);
				ap = var2.b();
			}

			ak = true;
		}
	}

	public int at() {
		return 300;
	}

	public Iterable av() {
		return aB;
	}

	public Iterable aw() {
		return aB;
	}

	public Iterable ax() {
		return Iterables.concat(av(), aw());
	}

	public void a(class_rc var1, class_aco var2) {
	}

	public boolean ay() {
		boolean var1 = (o != null) && o.D;
		return !ab && ((i > 0) || (var1 && this.g(0)));
	}

	public boolean az() {
		return m != null;
	}

	public boolean aA() {
		return this.g(1);
	}

	public void c(boolean var1) {
		this.b(1, var1);
	}

	public boolean aB() {
		return this.g(3);
	}

	public void d(boolean var1) {
		this.b(3, var1);
	}

	public boolean aC() {
		return ar || (o.D && this.g(6));
	}

	public boolean aD() {
		return this.g(5);
	}

	public class_ayu aE() {
		return o.ab().h(aQ().toString());
	}

	public boolean k(Entity var1) {
		return this.a(var1.aE());
	}

	public boolean a(class_ayu var1) {
		return aE() != null ? aE().a(var1) : false;
	}

	public void f(boolean var1) {
		this.b(5, var1);
	}

	protected boolean g(int var1) {
		return (((Byte) ac.a(as)).byteValue() & (1 << var1)) != 0;
	}

	protected void b(int var1, boolean var2) {
		byte var3 = ((Byte) ac.a(as)).byteValue();
		if (var2) {
			ac.b(as, Byte.valueOf((byte) (var3 | (1 << var1))));
		} else {
			ac.b(as, Byte.valueOf((byte) (var3 & ~(1 << var1))));
		}

	}

	public int aF() {
		return ((Integer) ac.a(at)).intValue();
	}

	public void h(int var1) {
		ac.b(at, Integer.valueOf(var1));
	}

	public void a(class_xc var1) {
		this.a(class_qi.b, 5.0F);
		++i;
		if (i == 0) {
			this.e(8);
		}

	}

	public void b(class_rg var1) {
	}

	protected boolean j(double var1, double var3, double var5) {
		class_cj var7 = new class_cj(var1, var3, var5);
		double var8 = var1 - var7.n();
		double var10 = var3 - var7.o();
		double var12 = var5 - var7.p();
		List var14 = o.a(aX());
		if (var14.isEmpty() && !o.u(var7)) {
			return false;
		} else {
			byte var15 = 3;
			double var16 = 9999.0D;
			if (!o.u(var7.e()) && (var8 < var16)) {
				var16 = var8;
				var15 = 0;
			}

			if (!o.u(var7.f()) && ((1.0D - var8) < var16)) {
				var16 = 1.0D - var8;
				var15 = 1;
			}

			if (!o.u(var7.a()) && ((1.0D - var10) < var16)) {
				var16 = 1.0D - var10;
				var15 = 3;
			}

			if (!o.u(var7.c()) && (var12 < var16)) {
				var16 = var12;
				var15 = 4;
			}

			if (!o.u(var7.d()) && ((1.0D - var12) < var16)) {
				var16 = 1.0D - var12;
				var15 = 5;
			}

			float var18 = (V.nextFloat() * 0.2F) + 0.1F;
			if (var15 == 0) {
				v = (-var18);
			}

			if (var15 == 1) {
				v = var18;
			}

			if (var15 == 3) {
				w = var18;
			}

			if (var15 == 4) {
				x = (-var18);
			}

			if (var15 == 5) {
				x = var18;
			}

			return true;
		}
	}

	public void aG() {
		H = true;
		O = 0.0F;
	}

	@Override
	public String e_() {
		if (k_()) {
			return aS();
		} else {
			String var1 = EntityTypes.b(this);
			if (var1 == null) {
				var1 = "generic";
			}

			return class_di.a("entity." + var1 + ".name");
		}
	}

	public Entity[] aH() {
		return null;
	}

	public boolean l(Entity var1) {
		return this == var1;
	}

	public float aI() {
		return 0.0F;
	}

	public void i(float var1) {
	}

	public void j(float var1) {
	}

	public boolean aJ() {
		return true;
	}

	public boolean m(Entity var1) {
		return false;
	}

	@Override
	public String toString() {
		return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[] { this.getClass().getSimpleName(), e_(), Integer.valueOf(c), o == null ? "~NULL~" : o.R().j(), Double.valueOf(s), Double.valueOf(t), Double.valueOf(u) });
	}

	public boolean b(class_qi var1) {
		return az && (var1 != class_qi.j) && !var1.u();
	}

	public void n(Entity var1) {
		this.b(var1.s, var1.t, var1.u, var1.y, var1.z);
	}

	private void b(Entity var1) {
		class_dn var2 = new class_dn();
		var1.e(var2);
		var2.q("Dimension");
		this.f(var2);
		aj = var1.aj;
		an = var1.an;
		ao = var1.ao;
		ap = var1.ap;
	}

	public Entity a(int var1, class_cj var2) {
		if (!o.D && !I) {
			o.B.a("changeDimension");
			MinecraftServer var3 = MinecraftServer.P();
			int var4 = am;
			class_ll var5 = var3.a(var4);
			class_ll var6 = var3.a(var1);
			am = var1;
			if ((var4 == 1) && (var1 == 1)) {
				var6 = var3.a(0);
				am = 0;
			}

			o.e(this);
			I = false;
			o.B.a("reposition");
			if (var2 == null) {
				if (var1 == 1) {
					var2 = var6.o();
				} else {
					double var7 = s;
					double var9 = u;
					double var11 = 8.0D;
					if (var1 == -1) {
						var7 = class_oa.a(var7 / var11, var6.ah().b() + 16.0D, var6.ah().d() - 16.0D);
						var9 = class_oa.a(var9 / var11, var6.ah().c() + 16.0D, var6.ah().e() - 16.0D);
					} else if (var1 == 0) {
						var7 = class_oa.a(var7 * var11, var6.ah().b() + 16.0D, var6.ah().d() - 16.0D);
						var9 = class_oa.a(var9 * var11, var6.ah().c() + 16.0D, var6.ah().e() - 16.0D);
					}

					var7 = class_oa.a((int) var7, -29999872, 29999872);
					var9 = class_oa.a((int) var9, -29999872, 29999872);
					float var13 = y;
					this.b(var7, t, var9, 90.0F, 0.0F);
					class_agw var14 = var6.w();
					var14.b(this, var13);
					var2 = new class_cj(this);
				}
			}

			var5.a(this, false);
			o.B.c("reloading");
			Entity var16 = EntityTypes.a(EntityTypes.b(this), var6);
			if (var16 != null) {
				var16.b(this);
				if ((var4 == 1) && (var1 == 1)) {
					class_cj var8 = var6.r(var6.O());
					var16.a(var8, var16.y, var16.z);
				} else {
					var16.a(var2, var16.y, var16.z);
				}

				boolean var15 = var16.n;
				var16.n = true;
				var6.a(var16);
				var16.n = var15;
				var6.a(var16, false);
			}

			I = true;
			o.B.b();
			var5.l();
			var6.l();
			o.B.b();
			return var16;
		} else {
			return null;
		}
	}

	public float a(class_agk var1, class_ago var2, class_cj var3, class_apn var4) {
		return var4.c().a(this);
	}

	public boolean a(class_agk var1, class_ago var2, class_cj var3, class_apn var4, float var5) {
		return true;
	}

	public int aK() {
		return 3;
	}

	public class_aym aM() {
		return ao;
	}

	public class_cq aN() {
		return ap;
	}

	public boolean aO() {
		return false;
	}

	public void a(class_c var1) {
		var1.a("Entity Type", new Callable() {
			public String a() throws Exception {
				return EntityTypes.b(Entity.this) + " (" + Entity.this.getClass().getCanonicalName() + ")";
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Entity ID", Integer.valueOf(c));
		var1.a("Entity Name", new Callable() {
			public String a() throws Exception {
				return Entity.this.e_();
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Entity\'s Exact location", String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(s), Double.valueOf(t), Double.valueOf(u) }));
		var1.a("Entity\'s Block location", class_c.a(class_oa.c(s), class_oa.c(t), class_oa.c(u)));
		var1.a("Entity\'s Momentum", String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(v), Double.valueOf(w), Double.valueOf(x) }));
		var1.a("Entity\'s Rider", new Callable() {
			public String a() throws Exception {
				return l.toString();
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var1.a("Entity\'s Vehicle", new Callable() {
			public String a() throws Exception {
				return m.toString();
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
	}

	public void a(UUID var1) {
		aq = var1;
	}

	public UUID aQ() {
		return aq;
	}

	public boolean aR() {
		return true;
	}

	@Override
	public class_eu f_() {
		class_fa var1 = new class_fa(class_ayp.a(aE(), e_()));
		var1.b().a(aW());
		var1.b().a(aQ().toString());
		return var1;
	}

	public void c(String var1) {
		ac.b(au, var1);
	}

	public String aS() {
		return (String) ac.a(au);
	}

	public boolean k_() {
		return !((String) ac.a(au)).isEmpty();
	}

	public void g(boolean var1) {
		ac.b(av, Boolean.valueOf(var1));
	}

	public boolean aT() {
		return ((Boolean) ac.a(av)).booleanValue();
	}

	public void a(double var1, double var3, double var5) {
		aD = true;
		this.b(var1, var3, var5, y, z);
		o.a(this, false);
	}

	public void a(class_jz var1) {
	}

	public class_cq aV() {
		return class_cq.b(class_oa.c((y * 4.0F) / 360.0F + 0.5D) & 3);
	}

	protected class_ew aW() {
		class_dn var1 = new class_dn();
		String var2 = EntityTypes.b(this);
		var1.a("id", aQ().toString());
		if (var2 != null) {
			var1.a("type", var2);
		}

		var1.a("name", e_());
		return new class_ew(class_ew.class_a_in_class_ew.d, new class_fa(var1.toString()));
	}

	public boolean a(class_lm var1) {
		return true;
	}

	public class_ayk aX() {
		return f;
	}

	public void a(class_ayk var1) {
		f = var1;
	}

	public float aY() {
		return K * 0.85F;
	}

	public boolean aZ() {
		return g;
	}

	public void h(boolean var1) {
		g = var1;
	}

	public boolean c(int var1, class_aco var2) {
		return false;
	}

	@Override
	public void a(class_eu var1) {
	}

	@Override
	public boolean a(int var1, String var2) {
		return true;
	}

	@Override
	public class_cj c() {
		return new class_cj(s, t + 0.5D, u);
	}

	@Override
	public class_aym d() {
		return new class_aym(s, t, u);
	}

	@Override
	public class_ago e() {
		return o;
	}

	@Override
	public Entity f() {
		return this;
	}

	@Override
	public boolean s_() {
		return false;
	}

	@Override
	public void a(class_n.class_a_in_class_n var1, int var2) {
		aA.a(this, var1, var2);
	}

	public class_n ba() {
		return aA;
	}

	public void o(Entity var1) {
		aA.a(var1.ba());
	}

	public class_pw a(class_yu var1, class_aym var2, class_aco var3, class_pu var4) {
		return class_pw.b;
	}

	public boolean bb() {
		return false;
	}

	protected void a(class_rg var1, Entity var2) {
		if (var2 instanceof class_rg) {
			class_afl.a(((class_rg) var2), var1);
		}

		class_afl.b(var1, var2);
	}

	public void b(class_lm var1) {
	}

	public void c(class_lm var1) {
	}

	public float a(Block.class_c_in_class_ail var1) {
		float var2 = class_oa.g(y);
		switch (Entity.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
				return var2 + 180.0F;
			case 2:
				return var2 + 270.0F;
			case 3:
				return var2 + 90.0F;
			default:
				return var2;
		}
	}

	public float a(Block.class_a_in_class_ail var1) {
		float var2 = class_oa.g(y);
		switch (Entity.SyntheticClass_1.b[var1.ordinal()]) {
			case 1:
				return -var2;
			case 2:
				return 180.0F - var2;
			default:
				return var2;
		}
	}

	public boolean bc() {
		return false;
	}

	public boolean bd() {
		boolean var1 = aD;
		aD = false;
		return var1;
	}

	static {
		as = class_kc.a(Entity.class, class_kb.a);
		at = class_kc.a(Entity.class, class_kb.b);
		au = class_kc.a(Entity.class, class_kb.d);
		av = class_kc.a(Entity.class, class_kb.g);
		aw = class_kc.a(Entity.class, class_kb.g);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_a_in_class_ail.values().length];

		static {
			try {
				b[Block.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[Block.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[Block.class_c_in_class_ail.values().length];

			try {
				a[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
