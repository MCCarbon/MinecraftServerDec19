package net.minecraft.server;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public abstract class class_ahb {
	private static final Logger aD = LogManager.getLogger();
	protected static final class_ahb.class_a_in_class_ahb a = new class_ahb.class_a_in_class_ahb(0.1F, 0.2F);
	protected static final class_ahb.class_a_in_class_ahb b = new class_ahb.class_a_in_class_ahb(-0.5F, 0.0F);
	protected static final class_ahb.class_a_in_class_ahb c = new class_ahb.class_a_in_class_ahb(-1.0F, 0.1F);
	protected static final class_ahb.class_a_in_class_ahb d = new class_ahb.class_a_in_class_ahb(-1.8F, 0.1F);
	protected static final class_ahb.class_a_in_class_ahb e = new class_ahb.class_a_in_class_ahb(0.125F, 0.05F);
	protected static final class_ahb.class_a_in_class_ahb f = new class_ahb.class_a_in_class_ahb(0.2F, 0.2F);
	protected static final class_ahb.class_a_in_class_ahb g = new class_ahb.class_a_in_class_ahb(0.45F, 0.3F);
	protected static final class_ahb.class_a_in_class_ahb h = new class_ahb.class_a_in_class_ahb(1.5F, 0.025F);
	protected static final class_ahb.class_a_in_class_ahb i = new class_ahb.class_a_in_class_ahb(1.0F, 0.5F);
	protected static final class_ahb.class_a_in_class_ahb j = new class_ahb.class_a_in_class_ahb(0.0F, 0.025F);
	protected static final class_ahb.class_a_in_class_ahb k = new class_ahb.class_a_in_class_ahb(0.1F, 0.8F);
	protected static final class_ahb.class_a_in_class_ahb l = new class_ahb.class_a_in_class_ahb(0.2F, 0.3F);
	protected static final class_ahb.class_a_in_class_ahb m = new class_ahb.class_a_in_class_ahb(-0.2F, 0.1F);
	private static final class_ahb[] aE = new class_ahb[256];
	public static final Set n = Sets.newHashSet();
	public static final Map o = Maps.newHashMap();
	public static final class_ahb p;
	public static final class_ahb q;
	public static final class_ahb r;
	public static final class_ahb s;
	public static final class_ahb t;
	public static final class_ahb u;
	public static final class_ahb v;
	public static final class_ahb w;
	public static final class_ahb x;
	public static final class_ahb y;
	public static final class_ahb z;
	public static final class_ahb A;
	public static final class_ahb B;
	public static final class_ahb C;
	public static final class_ahb D;
	public static final class_ahb E;
	public static final class_ahb F;
	public static final class_ahb G;
	public static final class_ahb H;
	public static final class_ahb I;
	public static final class_ahb J;
	public static final class_ahb K;
	public static final class_ahb L;
	public static final class_ahb M;
	public static final class_ahb N;
	public static final class_ahb O;
	public static final class_ahb P;
	public static final class_ahb Q;
	public static final class_ahb R;
	public static final class_ahb S;
	public static final class_ahb T;
	public static final class_ahb U;
	public static final class_ahb V;
	public static final class_ahb W;
	public static final class_ahb X;
	public static final class_ahb Y;
	public static final class_ahb Z;
	public static final class_ahb aa;
	public static final class_ahb ab;
	public static final class_ahb ac;
	public static final class_ahb ad;
	protected static final class_avh ae;
	protected static final class_avh af;
	protected static final class_asl ag;
	public String ah;
	public int ai;
	public int aj;
	public class_apn ak;
	public class_apn al;
	public int am;
	public float an;
	public float ao;
	public float ap;
	public float aq;
	public int ar;
	public class_ahe as;
	protected List at;
	protected List au;
	protected List av;
	protected List aw;
	protected boolean ax;
	protected boolean ay;
	public final int az;
	protected class_atr aA;
	protected class_asb aB;
	protected class_atp aC;

	protected class_ahb(int var1) {
		ak = class_aim.c.S();
		al = class_aim.d.S();
		am = 5169201;
		an = a.a;
		ao = a.b;
		ap = 0.5F;
		aq = 0.5F;
		ar = 16777215;
		at = Lists.newArrayList();
		au = Lists.newArrayList();
		av = Lists.newArrayList();
		aw = Lists.newArrayList();
		ay = true;
		aA = new class_atr(false);
		aB = new class_asb(false);
		aC = new class_atp();
		az = var1;
		aE[var1] = this;
		as = this.a();
		au.add(new class_ahb.class_c_in_class_ahb(class_vl.class, 12, 4, 4));
		au.add(new class_ahb.class_c_in_class_ahb(class_vk.class, 10, 3, 3));
		au.add(new class_ahb.class_c_in_class_ahb(class_vj.class, 10, 4, 4));
		au.add(new class_ahb.class_c_in_class_ahb(class_vd.class, 10, 4, 4));
		au.add(new class_ahb.class_c_in_class_ahb(class_ve.class, 8, 4, 4));
		at.add(new class_ahb.class_c_in_class_ahb(class_yj.class, 100, 4, 4));
		at.add(new class_ahb.class_c_in_class_ahb(class_yl.class, 100, 4, 4));
		at.add(new class_ahb.class_c_in_class_ahb(class_yh.class, 100, 4, 4));
		at.add(new class_ahb.class_c_in_class_ahb(class_xu.class, 100, 4, 4));
		at.add(new class_ahb.class_c_in_class_ahb(class_yi.class, 100, 4, 4));
		at.add(new class_ahb.class_c_in_class_ahb(class_xv.class, 10, 1, 4));
		at.add(new class_ahb.class_c_in_class_ahb(class_yk.class, 5, 1, 1));
		av.add(new class_ahb.class_c_in_class_ahb(class_vo.class, 10, 4, 4));
		aw.add(new class_ahb.class_c_in_class_ahb(class_va.class, 10, 8, 8));
	}

	protected class_ahe a() {
		return new class_ahe();
	}

	protected class_ahb a(float var1, float var2) {
		if ((var1 > 0.1F) && (var1 < 0.2F)) {
			throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
		} else {
			ap = var1;
			aq = var2;
			return this;
		}
	}

	protected final class_ahb a(class_ahb.class_a_in_class_ahb var1) {
		an = var1.a;
		ao = var1.b;
		return this;
	}

	protected class_ahb b() {
		ay = false;
		return this;
	}

	public class_asa a(Random var1) {
		return var1.nextInt(10) == 0 ? aB : aA;
	}

	public class_asp b(Random var1) {
		return new class_atq(class_ano.class_a_in_class_ano.b);
	}

	public class_ake.class_a_in_class_ake a(Random var1, class_cj var2) {
		return var1.nextInt(3) > 0 ? class_ake.class_a_in_class_ake.a : class_ake.class_a_in_class_ake.b;
	}

	protected class_ahb c() {
		ax = true;
		return this;
	}

	protected class_ahb a(String var1) {
		ah = var1;
		return this;
	}

	protected class_ahb a(int var1) {
		am = var1;
		return this;
	}

	protected class_ahb b(int var1) {
		this.a(var1, false);
		return this;
	}

	protected class_ahb c(int var1) {
		aj = var1;
		return this;
	}

	protected class_ahb a(int var1, boolean var2) {
		ai = var1;
		if (var2) {
			aj = (var1 & 16711422) >> 1;
		} else {
			aj = var1;
		}

		return this;
	}

	public List a(class_ri var1) {
		switch (class_ahb.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
				return at;
			case 2:
				return au;
			case 3:
				return av;
			case 4:
				return aw;
			default:
				return Collections.emptyList();
		}
	}

	public boolean d() {
		return j();
	}

	public boolean e() {
		return j() ? false : ay;
	}

	public boolean f() {
		return aq > 0.85F;
	}

	public float g() {
		return 0.1F;
	}

	public final int h() {
		return (int) (aq * 65536.0F);
	}

	public final float a(class_cj var1) {
		if (var1.o() > 64) {
			float var2 = (float) (ae.a((var1.n() * 1.0D) / 8.0D, (var1.p() * 1.0D) / 8.0D) * 4.0D);
			return ap - ((((var2 + var1.o()) - 64.0F) * 0.05F) / 30.0F);
		} else {
			return ap;
		}
	}

	public void a(class_ago var1, Random var2, class_cj var3) {
		as.a(var1, var2, this, var3);
	}

	public boolean j() {
		return ax;
	}

	public void a(class_ago var1, Random var2, class_arl var3, int var4, int var5, double var6) {
		this.b(var1, var2, var3, var4, var5, var6);
	}

	public final void b(class_ago var1, Random var2, class_arl var3, int var4, int var5, double var6) {
		int var8 = var1.H();
		class_apn var9 = ak;
		class_apn var10 = al;
		int var11 = -1;
		int var12 = (int) ((var6 / 3.0D) + 3.0D + (var2.nextDouble() * 0.25D));
		int var13 = var4 & 15;
		int var14 = var5 & 15;
		class_cj.class_a_in_class_cj var15 = new class_cj.class_a_in_class_cj();

		for (int var16 = 255; var16 >= 0; --var16) {
			if (var16 <= var2.nextInt(5)) {
				var3.a(var14, var16, var13, class_aim.h.S());
			} else {
				class_apn var17 = var3.a(var14, var16, var13);
				if (var17.c().v() == class_avq.a) {
					var11 = -1;
				} else if (var17.c() == class_aim.b) {
					if (var11 == -1) {
						if (var12 <= 0) {
							var9 = null;
							var10 = class_aim.b.S();
						} else if ((var16 >= (var8 - 4)) && (var16 <= (var8 + 1))) {
							var9 = ak;
							var10 = al;
						}

						if ((var16 < var8) && ((var9 == null) || (var9.c().v() == class_avq.a))) {
							if (this.a(var15.c(var4, var16, var5)) < 0.15F) {
								var9 = class_aim.aI.S();
							} else {
								var9 = class_aim.j.S();
							}
						}

						var11 = var12;
						if (var16 >= (var8 - 1)) {
							var3.a(var14, var16, var13, var9);
						} else if (var16 < (var8 - 7 - var12)) {
							var9 = null;
							var10 = class_aim.b.S();
							var3.a(var14, var16, var13, class_aim.n.S());
						} else {
							var3.a(var14, var16, var13, var10);
						}
					} else if (var11 > 0) {
						--var11;
						var3.a(var14, var16, var13, var10);
						if ((var11 == 0) && (var10.c() == class_aim.m)) {
							var11 = var2.nextInt(4) + Math.max(0, var16 - 63);
							var10 = var10.b(class_ams.a) == class_ams.class_a_in_class_ams.b ? class_aim.cM.S() : class_aim.A.S();
						}
					}
				}
			}
		}

	}

	protected class_ahb k() {
		return this.d(az + 128);
	}

	protected class_ahb d(int var1) {
		return new class_ahp(var1, this);
	}

	public Class l() {
		return this.getClass();
	}

	public boolean a(class_ahb var1) {
		return var1 == this ? true : (var1 == null ? false : l() == var1.l());
	}

	public class_ahb.class_b_in_class_ahb m() {
		return ap < 0.2D ? class_ahb.class_b_in_class_ahb.b : (ap < 1.0D ? class_ahb.class_b_in_class_ahb.c : class_ahb.class_b_in_class_ahb.d);
	}

	public static class_ahb[] n() {
		return aE;
	}

	public static class_ahb e(int var0) {
		return a(var0, (class_ahb) null);
	}

	public static class_ahb a(int var0, class_ahb var1) {
		if ((var0 >= 0) && (var0 <= aE.length)) {
			class_ahb var2 = aE[var0];
			return var2 == null ? var1 : var2;
		} else {
			aD.warn("Biome ID is out of bounds: " + var0 + ", defaulting to 0 (Ocean)");
			return p;
		}
	}

	static {
		p = (new class_ahq(0)).b(112).a("Ocean").a(c);
		q = (new class_ahr(1)).b(9286496).a("Plains");
		r = (new class_ahg(2)).b(16421912).a("Desert").b().a(2.0F, 0.0F).a(e);
		s = (new class_ahh(3, false)).b(6316128).a("Extreme Hills").a(i).a(0.2F, 0.3F);
		t = (new class_ahj(4, 0)).b(353825).a("Forest");
		u = (new class_ahx(5, 0)).b(747097).a("Taiga").a(5159473).a(0.25F, 0.8F).a(f);
		v = (new class_ahw(6)).b(522674).a("Swampland").a(9154376).a(m).a(0.8F, 0.9F);
		w = (new class_aht(7)).b(255).a("River").a(b);
		x = (new class_ahk(8)).b(16711680).a("Hell").b().a(2.0F, 0.0F);
		y = (new class_ahy(9)).b(8421631).a("The End").b();
		z = (new class_ahq(10)).b(9474208).a("FrozenOcean").c().a(c).a(0.0F, 0.5F);
		A = (new class_aht(11)).b(10526975).a("FrozenRiver").c().a(b).a(0.0F, 0.5F);
		B = (new class_ahl(12, false)).b(16777215).a("Ice Plains").c().a(0.0F, 0.5F).a(e);
		C = (new class_ahl(13, false)).b(10526880).a("Ice Mountains").c().a(g).a(0.0F, 0.5F);
		D = (new class_aho(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).a(l);
		E = (new class_aho(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).a(j);
		F = (new class_aha(16)).b(16440917).a("Beach").a(0.8F, 0.4F).a(j);
		G = (new class_ahg(17)).b(13786898).a("DesertHills").b().a(2.0F, 0.0F).a(g);
		H = (new class_ahj(18, 0)).b(2250012).a("ForestHills").a(g);
		I = (new class_ahx(19, 0)).b(1456435).a("TaigaHills").a(5159473).a(0.25F, 0.8F).a(g);
		J = (new class_ahh(20, true)).b(7501978).a("Extreme Hills Edge").a(i.a()).a(0.2F, 0.3F);
		K = (new class_ahm(21, false)).b(5470985).a("Jungle").a(5470985).a(0.95F, 0.9F);
		L = (new class_ahm(22, false)).b(2900485).a("JungleHills").a(5470985).a(0.95F, 0.9F).a(g);
		M = (new class_ahm(23, true)).b(6458135).a("JungleEdge").a(5470985).a(0.95F, 0.8F);
		N = (new class_ahq(24)).b(48).a("Deep Ocean").a(d);
		O = (new class_ahv(25)).b(10658436).a("Stone Beach").a(0.2F, 0.3F).a(k);
		P = (new class_aha(26)).b(16445632).a("Cold Beach").a(0.05F, 0.3F).a(j).c();
		Q = (new class_ahj(27, 2)).a("Birch Forest").b(3175492);
		R = (new class_ahj(28, 2)).a("Birch Forest Hills").b(2055986).a(g);
		S = (new class_ahj(29, 3)).b(4215066).a("Roofed Forest");
		T = (new class_ahx(30, 0)).b(3233098).a("Cold Taiga").a(5159473).c().a(-0.5F, 0.4F).a(f).c(16777215);
		U = (new class_ahx(31, 0)).b(2375478).a("Cold Taiga Hills").a(5159473).c().a(-0.5F, 0.4F).a(g).c(16777215);
		V = (new class_ahx(32, 1)).b(5858897).a("Mega Taiga").a(5159473).a(0.3F, 0.8F).a(f);
		W = (new class_ahx(33, 1)).b(4542270).a("Mega Taiga Hills").a(5159473).a(0.3F, 0.8F).a(g);
		X = (new class_ahh(34, true)).b(5271632).a("Extreme Hills+").a(i).a(0.2F, 0.3F);
		Y = (new class_ahu(35)).b(12431967).a("Savanna").a(1.2F, 0.0F).b().a(e);
		Z = (new class_ahu(36)).b(10984804).a("Savanna Plateau").a(1.0F, 0.0F).b().a(h);
		aa = (new class_ahn(37, false, false)).b(14238997).a("Mesa");
		ab = (new class_ahn(38, false, true)).b(11573093).a("Mesa Plateau F").a(h);
		ac = (new class_ahn(39, false, false)).b(13274213).a("Mesa Plateau").a(h);
		ad = p;
		q.k();
		r.k();
		t.k();
		u.k();
		v.k();
		B.k();
		K.k();
		M.k();
		T.k();
		Y.k();
		Z.k();
		aa.k();
		ab.k();
		ac.k();
		Q.k();
		R.k();
		S.k();
		V.k();
		s.k();
		X.k();
		V.d(W.az + 128).a("Redwood Taiga Hills M");
		class_ahb[] var0 = aE;
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			class_ahb var3 = var0[var2];
			if (var3 != null) {
				if (o.containsKey(var3.ah)) {
					throw new Error("Biome \"" + var3.ah + "\" is defined as both ID " + ((class_ahb) o.get(var3.ah)).az + " and " + var3.az);
				}

				o.put(var3.ah, var3);
				if (var3.az < 128) {
					n.add(var3);
				}
			}
		}

		n.remove(x);
		n.remove(y);
		n.remove(z);
		n.remove(J);
		ae = new class_avh(new Random(1234L), 1);
		af = new class_avh(new Random(2345L), 1);
		ag = new class_asl();
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_ri.values().length];

		static {
			try {
				a[class_ri.a.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_ri.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_ri.d.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_ri.c.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static class class_c_in_class_ahb extends class_oi.class_a_in_class_oi {
		public Class b;
		public int c;
		public int d;

		public class_c_in_class_ahb(Class var1, int var2, int var3, int var4) {
			super(var2);
			b = var1;
			c = var3;
			d = var4;
		}

		@Override
		public String toString() {
			return b.getSimpleName() + "*(" + c + "-" + d + "):" + a;
		}
	}

	public static class class_a_in_class_ahb {
		public float a;
		public float b;

		public class_a_in_class_ahb(float var1, float var2) {
			a = var1;
			b = var2;
		}

		public class_ahb.class_a_in_class_ahb a() {
			return new class_ahb.class_a_in_class_ahb(a * 0.8F, b * 0.6F);
		}
	}

	public static enum class_b_in_class_ahb {
		a,
		b,
		c,
		d;
	}
}
