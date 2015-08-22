package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class class_ail {
	private static final class_ke a = new class_ke("air");
	public static final class_co c;
	public static final class_ct d;
	private class_abp b;
	public static final class_ail.class_d_in_class_ail e;
	public static final class_ail.class_d_in_class_ail f;
	public static final class_ail.class_d_in_class_ail g;
	public static final class_ail.class_d_in_class_ail h;
	public static final class_ail.class_d_in_class_ail i;
	public static final class_ail.class_d_in_class_ail j;
	public static final class_ail.class_d_in_class_ail k;
	public static final class_ail.class_d_in_class_ail l;
	public static final class_ail.class_d_in_class_ail m;
	public static final class_ail.class_d_in_class_ail n;
	public static final class_ail.class_d_in_class_ail o;
	public static final class_ail.class_d_in_class_ail p;
	public static final class_ail.class_d_in_class_ail q;
	protected boolean r;
	protected int s;
	protected boolean t;
	protected int u;
	protected boolean v;
	protected float w;
	protected float x;
	protected boolean y;
	protected boolean z;
	protected boolean A;
	protected double B;
	protected double C;
	protected double D;
	protected double E;
	protected double F;
	protected double G;
	public class_ail.class_d_in_class_ail H;
	public float I;
	protected final class_avq J;
	protected final class_avr K;
	public float L;
	protected final class_apo M;
	private class_apn N;
	private String O;

	public static int a(class_ail var0) {
		return c.a(var0);
	}

	public static int f(class_apn var0) {
		class_ail var1 = var0.c();
		return a(var1) + (var1.c(var0) << 12);
	}

	public static class_ail c(int var0) {
		return (class_ail) c.a(var0);
	}

	public static class_apn d(int var0) {
		int var1 = var0 & 4095;
		int var2 = (var0 >> 12) & 15;
		return c(var1).a(var2);
	}

	public static class_ail a(class_acm var0) {
		return var0 instanceof class_abb ? ((class_abb) var0).d() : null;
	}

	public static class_ail b(String var0) {
		class_ke var1 = new class_ke(var0);
		if (c.d(var1)) {
			return (class_ail) c.c(var1);
		} else {
			try {
				return (class_ail) c.a(Integer.parseInt(var0));
			} catch (NumberFormatException var3) {
				return null;
			}
		}
	}

	public boolean q() {
		return r;
	}

	public int r() {
		return s;
	}

	public int t() {
		return u;
	}

	public boolean u() {
		return v;
	}

	public class_avq v() {
		return J;
	}

	public class_avr g(class_apn var1) {
		return K;
	}

	public class_apn a(int var1) {
		return S();
	}

	public int c(class_apn var1) {
		if ((var1 != null) && !var1.a().isEmpty()) {
			throw new IllegalArgumentException("Don\'t know how to convert " + var1 + " back into data...");
		} else {
			return 0;
		}
	}

	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		return var1;
	}

	public class_apn a(class_apn var1, class_ail.class_c_in_class_ail var2) {
		return var1;
	}

	public class_apn a(class_apn var1, class_ail.class_a_in_class_ail var2) {
		return var1;
	}

	public class_ail(class_avq var1, class_avr var2) {
		y = true;
		H = e;
		I = 1.0F;
		L = 0.6F;
		J = var1;
		K = var2;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		r = this.c();
		s = this.c() ? 255 : 0;
		t = !var1.b();
		M = this.e();
		this.j(M.b());
	}

	protected class_ail(class_avq var1) {
		this(var1, var1.r());
	}

	protected class_ail a(class_ail.class_d_in_class_ail var1) {
		H = var1;
		return this;
	}

	protected class_ail e(int var1) {
		s = var1;
		return this;
	}

	protected class_ail a(float var1) {
		u = (int) (15.0F * var1);
		return this;
	}

	protected class_ail b(float var1) {
		x = var1 * 3.0F;
		return this;
	}

	public boolean w() {
		return J.c() && this.d();
	}

	public boolean x() {
		return J.k() && this.d() && !this.i();
	}

	public boolean y() {
		return J.c() && this.d();
	}

	public boolean d() {
		return true;
	}

	public boolean b(class_ags var1, class_cj var2) {
		return !J.c();
	}

	public int b() {
		return 3;
	}

	public boolean a(class_ago var1, class_cj var2) {
		return false;
	}

	protected class_ail c(float var1) {
		w = var1;
		if (x < (var1 * 5.0F)) {
			x = var1 * 5.0F;
		}

		return this;
	}

	protected class_ail z() {
		this.c(-1.0F);
		return this;
	}

	public float f(class_ago var1, class_cj var2) {
		return w;
	}

	protected class_ail a(boolean var1) {
		z = var1;
		return this;
	}

	public boolean A() {
		return z;
	}

	public boolean B() {
		return A;
	}

	protected final void a(float var1, float var2, float var3, float var4, float var5, float var6) {
		B = var1;
		C = var2;
		D = var3;
		E = var4;
		F = var5;
		G = var6;
	}

	public boolean b(class_ags var1, class_cj var2, class_cq var3) {
		return var1.p(var2).c().v().a();
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, class_qx var6) {
		class_ayk var7 = this.a(var1, var2, var3);
		if ((var7 != null) && var4.b(var7)) {
			var5.add(var7);
		}

	}

	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return new class_ayk(var2.n() + B, var2.o() + C, var2.p() + D, var2.n() + E, var2.o() + F, var2.p() + G);
	}

	public boolean c() {
		return true;
	}

	public boolean a(class_apn var1, boolean var2) {
		return C();
	}

	public boolean C() {
		return true;
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		this.b(var1, var2, var3, var4);
	}

	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
	}

	public void e(class_ago var1, class_cj var2, class_apn var3) {
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
	}

	public int a(class_ago var1) {
		return 10;
	}

	public void d(class_ago var1, class_cj var2, class_apn var3) {
	}

	public void c(class_ago var1, class_cj var2, class_apn var3) {
	}

	public int a(Random var1) {
		return 1;
	}

	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acm.a(this);
	}

	public float a(class_yu var1, class_ago var2, class_cj var3) {
		float var4 = this.f(var2, var3);
		return var4 < 0.0F ? 0.0F : (!var1.b(this) ? var1.a(this) / var4 / 100.0F : var1.a(this) / var4 / 30.0F);
	}

	public final void b(class_ago var1, class_cj var2, class_apn var3, int var4) {
		this.a(var1, var2, var3, 1.0F, var4);
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		if (!var1.D) {
			int var6 = this.a(var5, var1.s);

			for (int var7 = 0; var7 < var6; ++var7) {
				if (var1.s.nextFloat() <= var4) {
					class_acm var8 = this.a(var3, var1.s, var5);
					if (var8 != null) {
						a(var1, var2, new class_aco(var8, 1, this.a(var3)));
					}
				}
			}

		}
	}

	public static void a(class_ago var0, class_cj var1, class_aco var2) {
		if (!var0.D && var0.S().b("doTileDrops")) {
			float var3 = 0.5F;
			double var4 = var0.s.nextFloat() * var3 + ((1.0F - var3) * 0.5D);
			double var6 = var0.s.nextFloat() * var3 + ((1.0F - var3) * 0.5D);
			double var8 = var0.s.nextFloat() * var3 + ((1.0F - var3) * 0.5D);
			class_xg var10 = new class_xg(var0, var1.n() + var4, var1.o() + var6, var1.p() + var8, var2);
			var10.o();
			var0.a(var10);
		}
	}

	protected void b(class_ago var1, class_cj var2, int var3) {
		if (!var1.D) {
			while (var3 > 0) {
				int var4 = class_rd.a(var3);
				var3 -= var4;
				var1.a((new class_rd(var1, var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, var4)));
			}
		}

	}

	public int a(class_apn var1) {
		return 0;
	}

	public float a(class_qx var1) {
		return x / 5.0F;
	}

	public class_ayl a(class_ago var1, class_cj var2, class_aym var3, class_aym var4) {
		this.a((class_ags) var1, var2);
		var3 = var3.b((-var2.n()), (-var2.o()), (-var2.p()));
		var4 = var4.b((-var2.n()), (-var2.o()), (-var2.p()));
		class_aym var5 = var3.a(var4, B);
		class_aym var6 = var3.a(var4, E);
		class_aym var7 = var3.b(var4, C);
		class_aym var8 = var3.b(var4, F);
		class_aym var9 = var3.c(var4, D);
		class_aym var10 = var3.c(var4, G);
		if (!this.a(var5)) {
			var5 = null;
		}

		if (!this.a(var6)) {
			var6 = null;
		}

		if (!this.b(var7)) {
			var7 = null;
		}

		if (!this.b(var8)) {
			var8 = null;
		}

		if (!this.c(var9)) {
			var9 = null;
		}

		if (!this.c(var10)) {
			var10 = null;
		}

		class_aym var11 = null;
		if ((var5 != null) && ((var11 == null) || (var3.g(var5) < var3.g(var11)))) {
			var11 = var5;
		}

		if ((var6 != null) && ((var11 == null) || (var3.g(var6) < var3.g(var11)))) {
			var11 = var6;
		}

		if ((var7 != null) && ((var11 == null) || (var3.g(var7) < var3.g(var11)))) {
			var11 = var7;
		}

		if ((var8 != null) && ((var11 == null) || (var3.g(var8) < var3.g(var11)))) {
			var11 = var8;
		}

		if ((var9 != null) && ((var11 == null) || (var3.g(var9) < var3.g(var11)))) {
			var11 = var9;
		}

		if ((var10 != null) && ((var11 == null) || (var3.g(var10) < var3.g(var11)))) {
			var11 = var10;
		}

		if (var11 == null) {
			return null;
		} else {
			class_cq var12 = null;
			if (var11 == var5) {
				var12 = class_cq.e;
			}

			if (var11 == var6) {
				var12 = class_cq.f;
			}

			if (var11 == var7) {
				var12 = class_cq.a;
			}

			if (var11 == var8) {
				var12 = class_cq.b;
			}

			if (var11 == var9) {
				var12 = class_cq.c;
			}

			if (var11 == var10) {
				var12 = class_cq.d;
			}

			return new class_ayl(var11.b(var2.n(), var2.o(), var2.p()), var12, var2);
		}
	}

	private boolean a(class_aym var1) {
		return var1 == null ? false : (var1.b >= C) && (var1.b <= F) && (var1.c >= D) && (var1.c <= G);
	}

	private boolean b(class_aym var1) {
		return var1 == null ? false : (var1.a >= B) && (var1.a <= E) && (var1.c >= D) && (var1.c <= G);
	}

	private boolean c(class_aym var1) {
		return var1 == null ? false : (var1.a >= B) && (var1.a <= E) && (var1.b >= C) && (var1.b <= F);
	}

	public void a(class_ago var1, class_cj var2, class_agk var3) {
	}

	public boolean a(class_ago var1, class_cj var2, class_cq var3, class_aco var4) {
		return this.b(var1, var2, var3);
	}

	public boolean b(class_ago var1, class_cj var2, class_cq var3) {
		return this.c(var1, var2);
	}

	public boolean c(class_ago var1, class_cj var2) {
		return var1.p(var2).c().J.j();
	}

	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		return false;
	}

	public void a(class_ago var1, class_cj var2, class_qx var3) {
	}

	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return this.a(var7);
	}

	public void a(class_ago var1, class_cj var2, class_yu var3) {
	}

	public class_aym a(class_ago var1, class_cj var2, class_qx var3, class_aym var4) {
		return var4;
	}

	public void a(class_ags var1, class_cj var2) {
	}

	public final double D() {
		return B;
	}

	public final double E() {
		return E;
	}

	public final double F() {
		return C;
	}

	public final double G() {
		return F;
	}

	public final double H() {
		return D;
	}

	public final double I() {
		return G;
	}

	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return 0;
	}

	public boolean i() {
		return false;
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, class_qx var4) {
	}

	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return 0;
	}

	public void j() {
	}

	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, class_aoi var5, class_aco var6) {
		var2.b(class_nh.a(a(this)));
		var2.a(0.025F);
		if (K() && (class_afl.a(class_afn.q, var6) > 0)) {
			class_aco var8 = this.i(var4);
			if (var8 != null) {
				a(var1, var3, var8);
			}
		} else {
			int var7 = class_afl.a(class_afn.s, var6);
			this.b(var1, var3, var4, var7);
		}

	}

	protected boolean K() {
		return this.d() && !A;
	}

	protected class_aco i(class_apn var1) {
		int var2 = 0;
		class_acm var3 = class_acm.a(this);
		if ((var3 != null) && var3.k()) {
			var2 = this.c(var1);
		}

		return new class_aco(var3, 1, var2);
	}

	public int a(int var1, Random var2) {
		return this.a(var2);
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
	}

	public boolean g() {
		return !J.a() && !J.d();
	}

	public class_ail c(String var1) {
		O = var1;
		return this;
	}

	public String f() {
		return class_di.a(this.a() + ".name");
	}

	public String a() {
		return "tile." + O;
	}

	public boolean a(class_ago var1, class_cj var2, class_apn var3, int var4, int var5) {
		return false;
	}

	public boolean L() {
		return y;
	}

	protected class_ail M() {
		y = false;
		return this;
	}

	public int k() {
		return J.m();
	}

	public void a(class_ago var1, class_cj var2, class_qx var3, float var4) {
		var3.e(var4, 1.0F);
	}

	public void a(class_ago var1, class_qx var2) {
		var2.w = 0.0D;
	}

	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(class_acm.a(this), 1, this.a(var3));
	}

	public class_ail a(class_abp var1) {
		b = var1;
		return this;
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
	}

	public void i(class_ago var1, class_cj var2) {
	}

	public boolean P() {
		return true;
	}

	public boolean a(class_agk var1) {
		return true;
	}

	public boolean b(class_ail var1) {
		return this == var1;
	}

	public static boolean a(class_ail var0, class_ail var1) {
		return (var0 != null) && (var1 != null) ? (var0 == var1 ? true : var0.b(var1)) : false;
	}

	public boolean Q() {
		return false;
	}

	public int j(class_ago var1, class_cj var2) {
		return 0;
	}

	protected class_apo e() {
		return new class_apo(this, new class_aqc[0]);
	}

	public class_apo R() {
		return M;
	}

	protected final void j(class_apn var1) {
		N = var1;
	}

	public final class_apn S() {
		return N;
	}

	@Override
	public String toString() {
		return "Block{" + c.b(this) + "}";
	}

	public static void U() {
		a(0, a, (new class_aib()).c("air"));
		a(1, "stone", (new class_anj()).c(1.5F).b(10.0F).a(i).c("stone"));
		a(2, "grass", (new class_akm()).c(0.6F).a(h).c("grass"));
		a(3, "dirt", (new class_ajl()).c(0.5F).a(g).c("dirt"));
		class_ail var0 = (new class_ail(class_avq.e)).c(2.0F).b(10.0F).a(i).c("stonebrick").a(class_abp.b);
		a(4, "cobblestone", var0);
		class_ail var1 = (new class_aly()).c(2.0F).b(5.0F).a(f).c("wood");
		a(5, "planks", var1);
		a(6, "sapling", (new class_amu()).c(0.0F).a(h).c("sapling"));
		a(7, "bedrock", (new class_ail(class_avq.e)).z().b(6000000.0F).a(i).c("bedrock").M().a(class_abp.b));
		a(8, "flowing_water", (new class_ajr(class_avq.h)).c(100.0F).e(3).c("water").M());
		a(9, "water", (new class_anh(class_avq.h)).c(100.0F).e(3).c("water").M());
		a(10, "flowing_lava", (new class_ajr(class_avq.i)).c(100.0F).a(1.0F).c("lava").M());
		a(11, "lava", (new class_anh(class_avq.i)).c(100.0F).a(1.0F).c("lava").M());
		a(12, "sand", (new class_ams()).c(0.5F).a(m).c("sand"));
		a(13, "gravel", (new class_ako()).c(0.6F).a(g).c("gravel"));
		a(14, "gold_ore", (new class_alw()).c(3.0F).b(5.0F).a(i).c("oreGold"));
		a(15, "iron_ore", (new class_alw()).c(3.0F).b(5.0F).a(i).c("oreIron"));
		a(16, "coal_ore", (new class_alw()).c(3.0F).b(5.0F).a(i).c("oreCoal"));
		a(17, "log", (new class_alv()).c("log"));
		a(18, "leaves", (new class_alu()).c("leaves"));
		a(19, "sponge", (new class_anc()).c(0.6F).a(h).c("sponge"));
		a(20, "glass", (new class_akk(class_avq.s, false)).c(0.3F).a(k).c("glass"));
		a(21, "lapis_ore", (new class_alw()).c(3.0F).b(5.0F).a(i).c("oreLapis"));
		a(22, "lapis_block", (new class_ail(class_avq.f, class_avr.H)).c(3.0F).b(5.0F).a(i).c("blockLapis").a(class_abp.b));
		a(23, "dispenser", (new class_ajm()).c(3.5F).a(i).c("dispenser"));
		class_ail var2 = (new class_amt()).a(i).c(0.8F).c("sandStone");
		a(24, "sandstone", var2);
		a(25, "noteblock", (new class_als()).c(0.8F).c("musicBlock"));
		a(26, "bed", (new class_aij()).a(f).c(0.2F).c("bed").M());
		a(27, "golden_rail", (new class_amc()).c(0.7F).a(j).c("goldenRail"));
		a(28, "detector_rail", (new class_aji()).c(0.7F).a(j).c("detectorRail"));
		a(29, "sticky_piston", (new class_apg(true)).c("pistonStickyBase"));
		a(30, "web", (new class_aoa()).e(1).c(4.0F).c("web"));
		a(31, "tallgrass", (new class_ano()).c(0.0F).a(h).c("tallgrass"));
		a(32, "deadbush", (new class_ajh()).c(0.0F).a(h).c("deadbush"));
		a(33, "piston", (new class_apg(false)).c("pistonBase"));
		a(34, "piston_head", (new class_aph()).c("pistonBase"));
		a(35, "wool", (new class_ajb(class_avq.n)).c(0.8F).a(l).c("cloth"));
		a(36, "piston_extension", new class_apj());
		a(37, "yellow_flower", (new class_aof()).c(0.0F).a(h).c("flower1"));
		a(38, "red_flower", (new class_amj()).c(0.0F).a(h).c("flower2"));
		class_ail var3 = (new class_alk()).c(0.0F).a(h).a(0.125F).c("mushroom");
		a(39, "brown_mushroom", var3);
		class_ail var4 = (new class_alk()).c(0.0F).a(h).c("mushroom");
		a(40, "red_mushroom", var4);
		a(41, "gold_block", (new class_ail(class_avq.f, class_avr.F)).c(3.0F).b(10.0F).a(j).c("blockGold").a(class_abp.b));
		a(42, "iron_block", (new class_ail(class_avq.f, class_avr.h)).c(5.0F).b(10.0F).a(j).c("blockIron").a(class_abp.b));
		a(43, "double_stone_slab", (new class_akh()).c(2.0F).b(10.0F).a(i).c("stoneSlab"));
		a(44, "stone_slab", (new class_akr()).c(2.0F).b(10.0F).a(i).c("stoneSlab"));
		class_ail var5 = (new class_ail(class_avq.e, class_avr.D)).c(2.0F).b(10.0F).a(i).c("brick").a(class_abp.b);
		a(45, "brick_block", var5);
		a(46, "tnt", (new class_anq()).c(0.0F).a(h).c("tnt"));
		a(47, "bookshelf", (new class_aio()).c(1.5F).a(f).c("bookshelf"));
		a(48, "mossy_cobblestone", (new class_ail(class_avq.e)).c(2.0F).b(10.0F).a(i).c("stoneMoss").a(class_abp.b));
		a(49, "obsidian", (new class_alt()).c(50.0F).b(2000.0F).a(i).c("obsidian"));
		a(50, "torch", (new class_anr()).c(0.0F).a(0.9375F).a(f).c("torch"));
		a(51, "fire", (new class_akd()).c(0.0F).a(1.0F).a(l).c("fire").M());
		a(52, "mob_spawner", (new class_ali()).c(5.0F).a(j).c("mobSpawner").M());
		a(53, "oak_stairs", (new class_anf(var1.S().a(class_aly.a, class_aly.class_a_in_class_aly.a))).c("stairsWood"));
		a(54, "chest", (new class_aiw(0)).c(2.5F).a(f).c("chest"));
		a(55, "redstone_wire", (new class_amm()).c(0.0F).a(e).c("redstoneDust").M());
		a(56, "diamond_ore", (new class_alw()).c(3.0F).b(5.0F).a(i).c("oreDiamond"));
		a(57, "diamond_block", (new class_ail(class_avq.f, class_avr.G)).c(5.0F).b(10.0F).a(j).c("blockDiamond").a(class_abp.b));
		a(58, "crafting_table", (new class_aje()).c(2.5F).a(f).c("workbench"));
		a(59, "wheat", (new class_ajf()).c("crops"));
		class_ail var6 = (new class_aka()).c(0.6F).a(g).c("farmland");
		a(60, "farmland", var6);
		a(61, "furnace", (new class_akj(false)).c(3.5F).a(i).c("furnace").a(class_abp.c));
		a(62, "lit_furnace", (new class_akj(true)).c(3.5F).a(i).a(0.875F).c("furnace"));
		a(63, "standing_sign", (new class_ang()).c(1.0F).a(f).c("sign").M());
		a(64, "wooden_door", (new class_ajn(class_avq.d)).c(3.0F).a(f).c("doorOak").M());
		a(65, "ladder", (new class_alb()).c(0.4F).a(o).c("ladder"));
		a(66, "rail", (new class_ami()).c(0.7F).a(j).c("rail"));
		a(67, "stone_stairs", (new class_anf(var0.S())).c("stairsStone"));
		a(68, "wall_sign", (new class_any()).c(1.0F).a(f).c("sign").M());
		a(69, "lever", (new class_ale()).c(0.5F).a(f).c("lever"));
		a(70, "stone_pressure_plate", (new class_amd(class_avq.e, class_amd.class_a_in_class_amd.b)).c(0.5F).a(i).c("pressurePlateStone"));
		a(71, "iron_door", (new class_ajn(class_avq.f)).c(5.0F).a(j).c("doorIron").M());
		a(72, "wooden_pressure_plate", (new class_amd(class_avq.d, class_amd.class_a_in_class_amd.a)).c(0.5F).a(f).c("pressurePlateWood"));
		a(73, "redstone_ore", (new class_aml(false)).c(3.0F).b(5.0F).a(i).c("oreRedstone").a(class_abp.b));
		a(74, "lit_redstone_ore", (new class_aml(true)).a(0.625F).c(3.0F).b(5.0F).a(i).c("oreRedstone"));
		a(75, "unlit_redstone_torch", (new class_amo(false)).c(0.0F).a(f).c("notGate"));
		a(76, "redstone_torch", (new class_amo(true)).c(0.0F).a(0.5F).a(f).c("notGate").a(class_abp.d));
		a(77, "stone_button", (new class_anl()).c(0.5F).a(i).c("button"));
		a(78, "snow_layer", (new class_ana()).c(0.1F).a(n).c("snow").e(0));
		a(79, "ice", (new class_akz()).c(0.5F).e(3).a(k).c("ice"));
		a(80, "snow", (new class_amz()).c(0.2F).a(n).c("snow"));
		a(81, "cactus", (new class_ais()).c(0.4F).a(l).c("cactus"));
		a(82, "clay", (new class_aiz()).c(0.6F).a(g).c("clay"));
		a(83, "reeds", (new class_amp()).c(0.0F).a(h).c("reeds").M());
		a(84, "jukebox", (new class_ala()).c(2.0F).b(10.0F).a(i).c("jukebox"));
		a(85, "fence", (new class_akb(class_avq.d, class_aly.class_a_in_class_aly.a.c())).c(2.0F).b(5.0F).a(f).c("fence"));
		class_ail var7 = (new class_amf()).c(1.0F).a(f).c("pumpkin");
		a(86, "pumpkin", var7);
		a(87, "netherrack", (new class_alo()).c(0.4F).a(i).c("hellrock"));
		a(88, "soul_sand", (new class_anb()).c(0.5F).a(m).c("hellsand"));
		a(89, "glowstone", (new class_akl(class_avq.s)).c(0.3F).a(k).a(1.0F).c("lightgem"));
		a(90, "portal", (new class_alz()).c(-1.0F).a(k).a(0.75F).c("portal"));
		a(91, "lit_pumpkin", (new class_amf()).c(1.0F).a(f).a(1.0F).c("litpumpkin"));
		a(92, "cake", (new class_ait()).c(0.5F).a(l).c("cake").M());
		a(93, "unpowered_repeater", (new class_amq(false)).c(0.0F).a(f).c("diode").M());
		a(94, "powered_repeater", (new class_amq(true)).c(0.0F).a(f).c("diode").M());
		a(95, "stained_glass", (new class_and(class_avq.s)).c(0.3F).a(k).c("stainedGlass"));
		a(96, "trapdoor", (new class_ant(class_avq.d)).c(3.0F).a(f).c("trapdoor").M());
		a(97, "monster_egg", (new class_alj()).c(0.75F).c("monsterStoneEgg"));
		class_ail var8 = (new class_ank()).c(1.5F).b(10.0F).a(i).c("stonebricksmooth");
		a(98, "stonebrick", var8);
		a(99, "brown_mushroom_block", (new class_aky(class_avq.d, class_avr.l, var3)).c(0.2F).a(f).c("mushroom"));
		a(100, "red_mushroom_block", (new class_aky(class_avq.d, class_avr.D, var4)).c(0.2F).a(f).c("mushroom"));
		a(101, "iron_bars", (new class_anp(class_avq.f, true)).c(5.0F).b(10.0F).a(j).c("fenceIron"));
		a(102, "glass_pane", (new class_anp(class_avq.s, false)).c(0.3F).a(k).c("thinGlass"));
		class_ail var9 = (new class_alh()).c(1.0F).a(f).c("melon");
		a(103, "melon_block", var9);
		a(104, "pumpkin_stem", (new class_ani(var7)).c(0.0F).a(f).c("pumpkinStem"));
		a(105, "melon_stem", (new class_ani(var9)).c(0.0F).a(f).c("pumpkinStem"));
		a(106, "vine", (new class_anw()).c(0.2F).a(h).c("vine"));
		a(107, "fence_gate", (new class_akc(class_aly.class_a_in_class_aly.a)).c(2.0F).b(5.0F).a(f).c("fenceGate"));
		a(108, "brick_stairs", (new class_anf(var5.S())).c("stairsBrick"));
		a(109, "stone_brick_stairs", (new class_anf(var8.S().a(class_ank.a, class_ank.class_a_in_class_ank.a))).c("stairsStoneBrickSmooth"));
		a(110, "mycelium", (new class_all()).c(0.6F).a(h).c("mycel"));
		a(111, "waterlily", (new class_anz()).c(0.0F).a(h).c("waterlily"));
		class_ail var10 = (new class_alm()).c(2.0F).b(10.0F).a(i).c("netherBrick").a(class_abp.b);
		a(112, "nether_brick", var10);
		a(113, "nether_brick_fence", (new class_akb(class_avq.e, class_avr.K)).c(2.0F).b(10.0F).a(i).c("netherFence"));
		a(114, "nether_brick_stairs", (new class_anf(var10.S())).c("stairsNetherBrick"));
		a(115, "nether_wart", (new class_aln()).c("netherStalk"));
		a(116, "enchanting_table", (new class_ajs()).c(5.0F).b(2000.0F).c("enchantmentTable"));
		a(117, "brewing_stand", (new class_aip()).c(0.5F).a(0.125F).c("brewingStand"));
		a(118, "cauldron", (new class_aiv()).c(2.0F).c("cauldron"));
		a(119, "end_portal", (new class_aju(class_avq.E)).c(-1.0F).b(6000000.0F));
		a(120, "end_portal_frame", (new class_ajv()).a(k).a(0.125F).c(-1.0F).c("endPortalFrame").b(6000000.0F).a(class_abp.c));
		a(121, "end_stone", (new class_ail(class_avq.e, class_avr.d)).c(3.0F).b(15.0F).a(i).c("whiteStone").a(class_abp.b));
		a(122, "dragon_egg", (new class_ajp()).c(3.0F).b(15.0F).a(i).a(0.125F).c("dragonEgg"));
		a(123, "redstone_lamp", (new class_amn(false)).c(0.3F).a(k).c("redstoneLight").a(class_abp.d));
		a(124, "lit_redstone_lamp", (new class_amn(true)).c(0.3F).a(k).c("redstoneLight"));
		a(125, "double_wooden_slab", (new class_aki()).c(2.0F).b(5.0F).a(f).c("woodSlab"));
		a(126, "wooden_slab", (new class_akt()).c(2.0F).b(5.0F).a(f).c("woodSlab"));
		a(127, "cocoa", (new class_aja()).c(0.2F).b(5.0F).a(f).c("cocoa"));
		a(128, "sandstone_stairs", (new class_anf(var2.S().a(class_amt.a, class_amt.class_a_in_class_amt.c))).c("stairsSandStone"));
		a(129, "emerald_ore", (new class_alw()).c(3.0F).b(5.0F).a(i).c("oreEmerald"));
		a(130, "ender_chest", (new class_ajx()).c(22.5F).b(1000.0F).a(i).c("enderChest").a(0.5F));
		a(131, "tripwire_hook", (new class_anv()).c("tripWireSource"));
		a(132, "tripwire", (new class_anu()).c("tripWire"));
		a(133, "emerald_block", (new class_ail(class_avq.f, class_avr.I)).c(5.0F).b(10.0F).a(j).c("blockEmerald").a(class_abp.b));
		a(134, "spruce_stairs", (new class_anf(var1.S().a(class_aly.a, class_aly.class_a_in_class_aly.b))).c("stairsWoodSpruce"));
		a(135, "birch_stairs", (new class_anf(var1.S().a(class_aly.a, class_aly.class_a_in_class_aly.c))).c("stairsWoodBirch"));
		a(136, "jungle_stairs", (new class_anf(var1.S().a(class_aly.a, class_aly.class_a_in_class_aly.d))).c("stairsWoodJungle"));
		a(137, "command_block", (new class_ajc()).z().b(6000000.0F).c("commandBlock"));
		a(138, "beacon", (new class_aii()).c("beacon").a(1.0F));
		a(139, "cobblestone_wall", (new class_anx(var0)).c("cobbleWall"));
		a(140, "flower_pot", (new class_akf()).c(0.0F).a(e).c("flowerPot"));
		a(141, "carrots", (new class_aiu()).c("carrots"));
		a(142, "potatoes", (new class_ama()).c("potatoes"));
		a(143, "wooden_button", (new class_aoc()).c(0.5F).a(f).c("button"));
		a(144, "skull", (new class_amx()).c(1.0F).a(i).c("skull"));
		a(145, "anvil", (new class_aic()).c(5.0F).a(p).b(2000.0F).c("anvil"));
		a(146, "trapped_chest", (new class_aiw(1)).c(2.5F).a(f).c("chestTrap"));
		a(147, "light_weighted_pressure_plate", (new class_aob(class_avq.f, 15, class_avr.F)).c(0.5F).a(f).c("weightedPlate_light"));
		a(148, "heavy_weighted_pressure_plate", (new class_aob(class_avq.f, 150)).c(0.5F).a(f).c("weightedPlate_heavy"));
		a(149, "unpowered_comparator", (new class_ajd(false)).c(0.0F).a(f).c("comparator").M());
		a(150, "powered_comparator", (new class_ajd(true)).c(0.0F).a(0.625F).a(f).c("comparator").M());
		a(151, "daylight_detector", new class_ajg(false));
		a(152, "redstone_block", (new class_amb(class_avq.f, class_avr.f)).c(5.0F).b(10.0F).a(j).c("blockRedstone").a(class_abp.d));
		a(153, "quartz_ore", (new class_alw(class_avr.K)).c(3.0F).b(5.0F).a(i).c("netherquartz"));
		a(154, "hopper", (new class_akw()).c(3.0F).b(8.0F).a(j).c("hopper"));
		class_ail var11 = (new class_amh()).a(i).c(0.8F).c("quartzBlock");
		a(155, "quartz_block", var11);
		a(156, "quartz_stairs", (new class_anf(var11.S().a(class_amh.a, class_amh.class_a_in_class_amh.a))).c("stairsQuartz"));
		a(157, "activator_rail", (new class_amc()).c(0.7F).a(j).c("activatorRail"));
		a(158, "dropper", (new class_ajq()).c(3.5F).a(i).c("dropper"));
		a(159, "stained_hardened_clay", (new class_ajb(class_avq.e)).c(1.25F).b(7.0F).a(i).c("clayHardenedStained"));
		a(160, "stained_glass_pane", (new class_ane()).c(0.3F).a(k).c("thinStainedGlass"));
		a(161, "leaves2", (new class_alp()).c("leaves"));
		a(162, "log2", (new class_alq()).c("log"));
		a(163, "acacia_stairs", (new class_anf(var1.S().a(class_aly.a, class_aly.class_a_in_class_aly.e))).c("stairsWoodAcacia"));
		a(164, "dark_oak_stairs", (new class_anf(var1.S().a(class_aly.a, class_aly.class_a_in_class_aly.f))).c("stairsWoodDarkOak"));
		a(165, "slime", (new class_amy()).c("slime").a(q));
		a(166, "barrier", (new class_aie()).c("barrier"));
		a(167, "iron_trapdoor", (new class_ant(class_avq.f)).c(5.0F).a(j).c("ironTrapdoor").M());
		a(168, "prismarine", (new class_ame()).c(1.5F).b(10.0F).a(i).c("prismarine"));
		a(169, "sea_lantern", (new class_amv(class_avq.s)).c(0.3F).a(k).a(1.0F).c("seaLantern"));
		a(170, "hay_block", (new class_akv()).c(0.5F).a(h).c("hayBlock").a(class_abp.b));
		a(171, "carpet", (new class_aoe()).c(0.1F).a(l).c("woolCarpet").e(0));
		a(172, "hardened_clay", (new class_aku()).c(1.25F).b(7.0F).a(i).c("clayHardened"));
		a(173, "coal_block", (new class_ail(class_avq.e, class_avr.E)).c(5.0F).b(10.0F).a(i).c("blockCoal").a(class_abp.b));
		a(174, "packed_ice", (new class_alx()).c(0.5F).a(k).c("icePacked"));
		a(175, "double_plant", new class_ajo());
		a(176, "standing_banner", (new class_aid.class_a_in_class_aid()).c(1.0F).a(f).c("banner").M());
		a(177, "wall_banner", (new class_aid.class_b_in_class_aid()).c(1.0F).a(f).c("banner").M());
		a(178, "daylight_detector_inverted", new class_ajg(true));
		class_ail var12 = (new class_amk()).a(i).c(0.8F).c("redSandStone");
		a(179, "red_sandstone", var12);
		a(180, "red_sandstone_stairs", (new class_anf(var12.S().a(class_amk.a, class_amk.class_a_in_class_amk.c))).c("stairsRedSandStone"));
		a(181, "double_stone_slab2", (new class_akg()).c(2.0F).b(10.0F).a(i).c("stoneSlab2"));
		a(182, "stone_slab2", (new class_akp()).c(2.0F).b(10.0F).a(i).c("stoneSlab2"));
		a(183, "spruce_fence_gate", (new class_akc(class_aly.class_a_in_class_aly.b)).c(2.0F).b(5.0F).a(f).c("spruceFenceGate"));
		a(184, "birch_fence_gate", (new class_akc(class_aly.class_a_in_class_aly.c)).c(2.0F).b(5.0F).a(f).c("birchFenceGate"));
		a(185, "jungle_fence_gate", (new class_akc(class_aly.class_a_in_class_aly.d)).c(2.0F).b(5.0F).a(f).c("jungleFenceGate"));
		a(186, "dark_oak_fence_gate", (new class_akc(class_aly.class_a_in_class_aly.f)).c(2.0F).b(5.0F).a(f).c("darkOakFenceGate"));
		a(187, "acacia_fence_gate", (new class_akc(class_aly.class_a_in_class_aly.e)).c(2.0F).b(5.0F).a(f).c("acaciaFenceGate"));
		a(188, "spruce_fence", (new class_akb(class_avq.d, class_aly.class_a_in_class_aly.b.c())).c(2.0F).b(5.0F).a(f).c("spruceFence"));
		a(189, "birch_fence", (new class_akb(class_avq.d, class_aly.class_a_in_class_aly.c.c())).c(2.0F).b(5.0F).a(f).c("birchFence"));
		a(190, "jungle_fence", (new class_akb(class_avq.d, class_aly.class_a_in_class_aly.d.c())).c(2.0F).b(5.0F).a(f).c("jungleFence"));
		a(191, "dark_oak_fence", (new class_akb(class_avq.d, class_aly.class_a_in_class_aly.f.c())).c(2.0F).b(5.0F).a(f).c("darkOakFence"));
		a(192, "acacia_fence", (new class_akb(class_avq.d, class_aly.class_a_in_class_aly.e.c())).c(2.0F).b(5.0F).a(f).c("acaciaFence"));
		a(193, "spruce_door", (new class_ajn(class_avq.d)).c(3.0F).a(f).c("doorSpruce").M());
		a(194, "birch_door", (new class_ajn(class_avq.d)).c(3.0F).a(f).c("doorBirch").M());
		a(195, "jungle_door", (new class_ajn(class_avq.d)).c(3.0F).a(f).c("doorJungle").M());
		a(196, "acacia_door", (new class_ajn(class_avq.d)).c(3.0F).a(f).c("doorAcacia").M());
		a(197, "dark_oak_door", (new class_ajn(class_avq.d)).c(3.0F).a(f).c("doorDarkOak").M());
		a(198, "end_rod", (new class_ajw()).c(0.0F).a(0.9375F).a(f).c("endRod"));
		a(199, "chorus_plant", (new class_aiy()).c(0.4F).a(f).c("chorusPlant"));
		a(200, "chorus_flower", (new class_aix()).c(0.4F).a(f).c("chorusFlower"));
		class_ail var13 = (new class_ail(class_avq.e)).c(1.5F).b(10.0F).a(i).a(class_abp.b).c("purpurBlock");
		a(201, "purpur_block", var13);
		a(202, "purpur_pillar", (new class_amr(class_avq.e)).c(1.5F).b(10.0F).a(i).a(class_abp.b).c("purpurPillar"));
		a(203, "purpur_stairs", (new class_anf(var13.S())).c("stairsPurpur"));
		a(204, "purpur_double_slab", (new class_amg.class_a_in_class_amg()).c(2.0F).b(10.0F).a(i).c("purpurSlab"));
		a(205, "purpur_slab", (new class_amg.class_b_in_class_amg()).c(2.0F).b(10.0F).a(i).c("purpurSlab"));
		a(206, "end_bricks", (new class_ail(class_avq.e)).a(i).c(0.8F).a(class_abp.b).c("endBricks"));
		a(207, "beetroots", (new class_aik()).c("beetroots"));
		class_ail var14 = (new class_akn()).c(0.65F).a(h).c("grassPath").M();
		a(208, "grass_path", var14);
		a(209, "end_gateway", (new class_ajt(class_avq.E)).c(-1.0F).b(6000000.0F));
		a(210, "repeating_command_block", (new class_ajc()).z().b(6000000.0F).c("repeatingCommandBlock"));
		a(211, "chain_command_block", (new class_ajc()).z().b(6000000.0F).c("chainCommandBlock"));
		a(255, "structure_block", (new class_ann()).z().b(6000000.0F).c("structureBlock").a(1.0F));
		c.a();
		Iterator var15 = c.iterator();

		while (true) {
			class_ail var16;
			while (var15.hasNext()) {
				var16 = (class_ail) var15.next();
				if (var16.J == class_avq.a) {
					var16.v = false;
				} else {
					boolean var17 = false;
					boolean var18 = var16 instanceof class_anf;
					boolean var19 = var16 instanceof class_akq;
					boolean var20 = (var16 == var6) || (var16 == var14);
					boolean var21 = var16.t;
					boolean var22 = var16.s == 0;
					if (var18 || var19 || var20 || var21 || var22) {
						var17 = true;
					}

					var16.v = var17;
				}
			}

			var15 = c.iterator();

			while (var15.hasNext()) {
				var16 = (class_ail) var15.next();
				Iterator var23 = var16.R().a().iterator();

				while (var23.hasNext()) {
					class_apn var24 = (class_apn) var23.next();
					int var25 = (c.a(var16) << 4) | var16.c(var24);
					d.a(var24, var25);
				}
			}

			return;
		}
	}

	private static void a(int var0, class_ke var1, class_ail var2) {
		c.a(var0, var1, var2);
	}

	private static void a(int var0, String var1, class_ail var2) {
		a(var0, new class_ke(var1), var2);
	}

	static {
		c = new class_co(a);
		d = new class_ct();
		e = new class_ail.class_d_in_class_ail("stone", 1.0F, 1.0F);
		f = new class_ail.class_d_in_class_ail("wood", 1.0F, 1.0F);
		g = new class_ail.class_d_in_class_ail("gravel", 1.0F, 1.0F);
		h = new class_ail.class_d_in_class_ail("grass", 1.0F, 1.0F);
		i = new class_ail.class_d_in_class_ail("stone", 1.0F, 1.0F);
		j = new class_ail.class_d_in_class_ail("stone", 1.0F, 1.5F);
		k = new class_ail.class_d_in_class_ail("stone", 1.0F, 1.0F) {
			@Override
			public String a() {
				return "dig.glass";
			}

			@Override
			public String b() {
				return "step.stone";
			}
		};
		l = new class_ail.class_d_in_class_ail("cloth", 1.0F, 1.0F);
		m = new class_ail.class_d_in_class_ail("sand", 1.0F, 1.0F);
		n = new class_ail.class_d_in_class_ail("snow", 1.0F, 1.0F);
		o = new class_ail.class_d_in_class_ail("ladder", 1.0F, 1.0F) {
			@Override
			public String a() {
				return "dig.wood";
			}
		};
		p = new class_ail.class_d_in_class_ail("anvil", 0.3F, 1.0F) {
			@Override
			public String a() {
				return "dig.stone";
			}

			@Override
			public String b() {
				return "random.anvil_land";
			}
		};
		q = new class_ail.class_d_in_class_ail("slime", 1.0F, 1.0F) {
			@Override
			public String a() {
				return "mob.slime.big";
			}

			@Override
			public String b() {
				return "mob.slime.big";
			}

			@Override
			public String c() {
				return "mob.slime.small";
			}
		};
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[class_ail.class_a_in_class_ail.values().length];

		static {
			try {
				b[class_ail.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[class_ail.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			a = new int[class_ail.class_c_in_class_ail.values().length];

			try {
				a[class_ail.class_c_in_class_ail.a.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_ail.class_c_in_class_ail.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_ail.class_c_in_class_ail.c.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_ail.class_c_in_class_ail.d.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static class class_d_in_class_ail {
		public final String a;
		public final float b;
		public final float c;

		public class_d_in_class_ail(String var1, float var2, float var3) {
			a = var1;
			b = var2;
			c = var3;
		}

		public float d() {
			return b;
		}

		public float e() {
			return c;
		}

		public String a() {
			return "dig." + a;
		}

		public String c() {
			return "step." + a;
		}

		public String b() {
			return this.a();
		}
	}

	public static enum class_a_in_class_ail {
		a("no_mirror"),
		b("mirror_left_right"),
		c("mirror_front_back");

		private final String d;
		private static String[] e;

		private class_a_in_class_ail(String var3) {
			d = var3;
		}

		public int a(int var1, int var2) {
			int var3 = var2 / 2;
			int var4 = var1 > var3 ? var1 - var2 : var1;
			switch (class_ail.SyntheticClass_1.b[ordinal()]) {
				case 1:
					return (var2 - var4) % var2;
				case 2:
					return ((var3 - var4) + var2) % var2;
				default:
					return var1;
			}
		}

		public class_ail.class_c_in_class_ail a(class_cq var1) {
			class_cq.class_a_in_class_cq var2 = var1.k();
			return ((this != b) || (var2 != class_cq.class_a_in_class_cq.c)) && ((this != c) || (var2 != class_cq.class_a_in_class_cq.a)) ? class_ail.class_c_in_class_ail.a : class_ail.class_c_in_class_ail.c;
		}

		public class_cq b(class_cq var1) {
			switch (class_ail.SyntheticClass_1.b[ordinal()]) {
				case 1:
					if (var1 == class_cq.e) {
						return class_cq.f;
					} else {
						if (var1 == class_cq.f) {
							return class_cq.e;
						}

						return var1;
					}
				case 2:
					if (var1 == class_cq.c) {
						return class_cq.d;
					} else {
						if (var1 == class_cq.d) {
							return class_cq.c;
						}

						return var1;
					}
				default:
					return var1;
			}
		}

		static {
			e = new String[values().length];
			int var0 = 0;
			class_ail.class_a_in_class_ail[] var1 = values();
			int var2 = var1.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				class_ail.class_a_in_class_ail var4 = var1[var3];
				e[var0++] = var4.d;
			}

		}
	}

	public static enum class_c_in_class_ail {
		a("rotate_0"),
		b("rotate_90"),
		c("rotate_180"),
		d("rotate_270");

		private final String e;
		private static String[] f;

		private class_c_in_class_ail(String var3) {
			e = var3;
		}

		public class_ail.class_c_in_class_ail a(class_ail.class_c_in_class_ail var1) {
			switch (class_ail.SyntheticClass_1.a[var1.ordinal()]) {
				case 3:
					switch (class_ail.SyntheticClass_1.a[ordinal()]) {
						case 1:
							return c;
						case 2:
							return d;
						case 3:
							return a;
						case 4:
							return b;
					}
				case 4:
					switch (class_ail.SyntheticClass_1.a[ordinal()]) {
						case 1:
							return d;
						case 2:
							return a;
						case 3:
							return b;
						case 4:
							return c;
					}
				case 2:
					switch (class_ail.SyntheticClass_1.a[ordinal()]) {
						case 1:
							return b;
						case 2:
							return c;
						case 3:
							return d;
						case 4:
							return a;
					}
				default:
					return this;
			}
		}

		public class_cq a(class_cq var1) {
			if (var1.k() == class_cq.class_a_in_class_cq.b) {
				return var1;
			} else {
				switch (class_ail.SyntheticClass_1.a[ordinal()]) {
					case 2:
						return var1.e();
					case 3:
						return var1.d();
					case 4:
						return var1.f();
					default:
						return var1;
				}
			}
		}

		public int a(int var1, int var2) {
			switch (class_ail.SyntheticClass_1.a[ordinal()]) {
				case 2:
					return (var1 + (var2 / 4)) % var2;
				case 3:
					return (var1 + (var2 / 2)) % var2;
				case 4:
					return (var1 + ((var2 * 3) / 4)) % var2;
				default:
					return var1;
			}
		}

		static {
			f = new String[values().length];
			int var0 = 0;
			class_ail.class_c_in_class_ail[] var1 = values();
			int var2 = var1.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				class_ail.class_c_in_class_ail var4 = var1[var3];
				f[var0++] = var4.e;
			}

		}
	}
}
