package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BiomeBase {
	private static final Logger aD = LogManager.getLogger();
	protected static final BiomeBase.class_a_in_class_aez a = new BiomeBase.class_a_in_class_aez(0.1F, 0.2F);
	protected static final BiomeBase.class_a_in_class_aez b = new BiomeBase.class_a_in_class_aez(-0.5F, 0.0F);
	protected static final BiomeBase.class_a_in_class_aez c = new BiomeBase.class_a_in_class_aez(-1.0F, 0.1F);
	protected static final BiomeBase.class_a_in_class_aez d = new BiomeBase.class_a_in_class_aez(-1.8F, 0.1F);
	protected static final BiomeBase.class_a_in_class_aez e = new BiomeBase.class_a_in_class_aez(0.125F, 0.05F);
	protected static final BiomeBase.class_a_in_class_aez f = new BiomeBase.class_a_in_class_aez(0.2F, 0.2F);
	protected static final BiomeBase.class_a_in_class_aez g = new BiomeBase.class_a_in_class_aez(0.45F, 0.3F);
	protected static final BiomeBase.class_a_in_class_aez h = new BiomeBase.class_a_in_class_aez(1.5F, 0.025F);
	protected static final BiomeBase.class_a_in_class_aez i = new BiomeBase.class_a_in_class_aez(1.0F, 0.5F);
	protected static final BiomeBase.class_a_in_class_aez j = new BiomeBase.class_a_in_class_aez(0.0F, 0.025F);
	protected static final BiomeBase.class_a_in_class_aez k = new BiomeBase.class_a_in_class_aez(0.1F, 0.8F);
	protected static final BiomeBase.class_a_in_class_aez l = new BiomeBase.class_a_in_class_aez(0.2F, 0.3F);
	protected static final BiomeBase.class_a_in_class_aez m = new BiomeBase.class_a_in_class_aez(-0.2F, 0.1F);
	private static final BiomeBase[] aE = new BiomeBase[256];
	public static final Set n = Sets.newHashSet();
	public static final Map o = Maps.newHashMap();
	public static final BiomeBase p;
	public static final BiomeBase q;
	public static final BiomeBase r;
	public static final BiomeBase s;
	public static final BiomeBase t;
	public static final BiomeBase u;
	public static final BiomeBase v;
	public static final BiomeBase w;
	public static final BiomeBase x;
	public static final BiomeBase y;
	public static final BiomeBase z;
	public static final BiomeBase A;
	public static final BiomeBase B;
	public static final BiomeBase C;
	public static final BiomeBase D;
	public static final BiomeBase E;
	public static final BiomeBase F;
	public static final BiomeBase G;
	public static final BiomeBase H;
	public static final BiomeBase I;
	public static final BiomeBase J;
	public static final BiomeBase K;
	public static final BiomeBase L;
	public static final BiomeBase M;
	public static final BiomeBase N;
	public static final BiomeBase O;
	public static final BiomeBase P;
	public static final BiomeBase Q;
	public static final BiomeBase R;
	public static final BiomeBase S;
	public static final BiomeBase T;
	public static final BiomeBase U;
	public static final BiomeBase V;
	public static final BiomeBase W;
	public static final BiomeBase X;
	public static final BiomeBase Y;
	public static final BiomeBase Z;
	public static final BiomeBase aa;
	public static final BiomeBase ab;
	public static final BiomeBase ac;
	public static final BiomeBase ad;
	protected static final class_atb ae;
	protected static final class_atb af;
	protected static final class_aqh ag;
	public String ah;
	public int ai;
	public int aj;
	public IBlockData ak;
	public IBlockData al;
	public int am;
	public float an;
	public float ao;
	public float ap;
	public float aq;
	public int ar;
	public class_afc as;
	protected List at;
	protected List au;
	protected List av;
	protected List aw;
	protected boolean ax;
	protected boolean ay;
	public final int az;
	protected class_arn aA;
	protected class_apx aB;
	protected class_arl aC;

	protected BiomeBase(int var1) {
		this.ak = Blocks.GRASS.getBlockData();
		this.al = Blocks.DIRT.getBlockData();
		this.am = 5169201;
		this.an = a.a;
		this.ao = a.b;
		this.ap = 0.5F;
		this.aq = 0.5F;
		this.ar = 16777215;
		this.at = Lists.newArrayList();
		this.au = Lists.newArrayList();
		this.av = Lists.newArrayList();
		this.aw = Lists.newArrayList();
		this.ay = true;
		this.aA = new class_arn(false);
		this.aB = new class_apx(false);
		this.aC = new class_arl();
		this.az = var1;
		aE[var1] = this;
		this.as = this.a();
		this.au.add(new BiomeBase.class_c_in_class_aez(EntitySheep.class, 12, 4, 4));
		this.au.add(new BiomeBase.class_c_in_class_aez(EntityRabbit.class, 10, 3, 3));
		this.au.add(new BiomeBase.class_c_in_class_aez(EntityPig.class, 10, 4, 4));
		this.au.add(new BiomeBase.class_c_in_class_aez(EntityChicken.class, 10, 4, 4));
		this.au.add(new BiomeBase.class_c_in_class_aez(EntityCow.class, 8, 4, 4));
		this.at.add(new BiomeBase.class_c_in_class_aez(EntitySpider.class, 100, 4, 4));
		this.at.add(new BiomeBase.class_c_in_class_aez(EntityZombie.class, 100, 4, 4));
		this.at.add(new BiomeBase.class_c_in_class_aez(EntitySkeleton.class, 100, 4, 4));
		this.at.add(new BiomeBase.class_c_in_class_aez(EntityCreeper.class, 100, 4, 4));
		this.at.add(new BiomeBase.class_c_in_class_aez(EntitySlime.class, 100, 4, 4));
		this.at.add(new BiomeBase.class_c_in_class_aez(EntityEnderman.class, 10, 1, 4));
		this.at.add(new BiomeBase.class_c_in_class_aez(EntityWitch.class, 5, 1, 1));
		this.av.add(new BiomeBase.class_c_in_class_aez(EntitySquid.class, 10, 4, 4));
		this.aw.add(new BiomeBase.class_c_in_class_aez(EntityBat.class, 10, 8, 8));
	}

	protected class_afc a() {
		return new class_afc();
	}

	protected BiomeBase a(float var1, float var2) {
		if (var1 > 0.1F && var1 < 0.2F) {
			throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
		} else {
			this.ap = var1;
			this.aq = var2;
			return this;
		}
	}

	protected final BiomeBase a(BiomeBase.class_a_in_class_aez var1) {
		this.an = var1.a;
		this.ao = var1.b;
		return this;
	}

	protected BiomeBase b() {
		this.ay = false;
		return this;
	}

	public class_apw a(Random var1) {
		return (class_apw) (var1.nextInt(10) == 0 ? this.aB : this.aA);
	}

	public class_aql b(Random var1) {
		return new class_arm(BlockLongGrass.EnumTallGrassType.GRASS);
	}

	public BlockFlowers.EnumFlowerVarient a(Random var1, BlockPosition var2) {
		return var1.nextInt(3) > 0 ? BlockFlowers.EnumFlowerVarient.DANDELION : BlockFlowers.EnumFlowerVarient.POPPY;
	}

	protected BiomeBase c() {
		this.ax = true;
		return this;
	}

	protected BiomeBase a(String var1) {
		this.ah = var1;
		return this;
	}

	protected BiomeBase a(int var1) {
		this.am = var1;
		return this;
	}

	protected BiomeBase b(int var1) {
		this.a(var1, false);
		return this;
	}

	protected BiomeBase c(int var1) {
		this.aj = var1;
		return this;
	}

	protected BiomeBase a(int var1, boolean var2) {
		this.ai = var1;
		if (var2) {
			this.aj = (var1 & 16711422) >> 1;
		} else {
			this.aj = var1;
		}

		return this;
	}

	public List a(class_qc var1) {
		switch (BiomeBase.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
				return this.at;
			case 2:
				return this.au;
			case 3:
				return this.av;
			case 4:
				return this.aw;
			default:
				return Collections.emptyList();
		}
	}

	public boolean d() {
		return this.j();
	}

	public boolean e() {
		return this.j() ? false : this.ay;
	}

	public boolean f() {
		return this.aq > 0.85F;
	}

	public float g() {
		return 0.1F;
	}

	public final int h() {
		return (int) (this.aq * 65536.0F);
	}

	public final float a(BlockPosition var1) {
		if (var1.getY() > 64) {
			float var2 = (float) (ae.a((double) var1.getX() * 1.0D / 8.0D, (double) var1.getZ() * 1.0D / 8.0D) * 4.0D);
			return this.ap - (var2 + (float) var1.getY() - 64.0F) * 0.05F / 30.0F;
		} else {
			return this.ap;
		}
	}

	public void a(World var1, Random var2, BlockPosition var3) {
		this.as.a(var1, var2, this, var3);
	}

	public boolean j() {
		return this.ax;
	}

	public void a(World var1, Random var2, class_aph var3, int var4, int var5, double var6) {
		this.b(var1, var2, var3, var4, var5, var6);
	}

	public final void b(World var1, Random var2, class_aph var3, int var4, int var5, double var6) {
		int var8 = var1.G();
		IBlockData var9 = this.ak;
		IBlockData var10 = this.al;
		int var11 = -1;
		int var12 = (int) (var6 / 3.0D + 3.0D + var2.nextDouble() * 0.25D);
		int var13 = var4 & 15;
		int var14 = var5 & 15;
		BlockPosition.MutableBlockPosition var15 = new BlockPosition.MutableBlockPosition();

		for (int var16 = 255; var16 >= 0; --var16) {
			if (var16 <= var2.nextInt(5)) {
				var3.a(var14, var16, var13, Blocks.BEDROCK.getBlockData());
			} else {
				IBlockData var17 = var3.a(var14, var16, var13);
				if (var17.getBlock().getMaterial() == Material.AIR) {
					var11 = -1;
				} else if (var17.getBlock() == Blocks.STONE) {
					if (var11 == -1) {
						if (var12 <= 0) {
							var9 = null;
							var10 = Blocks.STONE.getBlockData();
						} else if (var16 >= var8 - 4 && var16 <= var8 + 1) {
							var9 = this.ak;
							var10 = this.al;
						}

						if (var16 < var8 && (var9 == null || var9.getBlock().getMaterial() == Material.AIR)) {
							if (this.a((BlockPosition) var15.setPosition(var4, var16, var5)) < 0.15F) {
								var9 = Blocks.ICE.getBlockData();
							} else {
								var9 = Blocks.WATER.getBlockData();
							}
						}

						var11 = var12;
						if (var16 >= var8 - 1) {
							var3.a(var14, var16, var13, var9);
						} else if (var16 < var8 - 7 - var12) {
							var9 = null;
							var10 = Blocks.STONE.getBlockData();
							var3.a(var14, var16, var13, Blocks.GRAVEL.getBlockData());
						} else {
							var3.a(var14, var16, var13, var10);
						}
					} else if (var11 > 0) {
						--var11;
						var3.a(var14, var16, var13, var10);
						if (var11 == 0 && var10.getBlock() == Blocks.SAND) {
							var11 = var2.nextInt(4) + Math.max(0, var16 - 63);
							var10 = var10.get(BlockSand.VARIANT) == BlockSand.EnumSandVariant.RED_SAND ? Blocks.RED_SANDSTONE.getBlockData() : Blocks.SANDSTONE.getBlockData();
						}
					}
				}
			}
		}

	}

	protected BiomeBase k() {
		return this.d(this.az + 128);
	}

	protected BiomeBase d(int var1) {
		return new class_afn(var1, this);
	}

	public Class l() {
		return this.getClass();
	}

	public boolean a(BiomeBase var1) {
		return var1 == this ? true : (var1 == null ? false : this.l() == var1.l());
	}

	public BiomeBase.class_b_in_class_aez m() {
		return (double) this.ap < 0.2D ? BiomeBase.class_b_in_class_aez.b : ((double) this.ap < 1.0D ? BiomeBase.class_b_in_class_aez.c : BiomeBase.class_b_in_class_aez.d);
	}

	public static BiomeBase[] n() {
		return aE;
	}

	public static BiomeBase e(int var0) {
		return a(var0, (BiomeBase) null);
	}

	public static BiomeBase a(int var0, BiomeBase var1) {
		if (var0 >= 0 && var0 <= aE.length) {
			BiomeBase var2 = aE[var0];
			return var2 == null ? var1 : var2;
		} else {
			aD.warn("Biome ID is out of bounds: " + var0 + ", defaulting to 0 (Ocean)");
			return p;
		}
	}

	static {
		p = (new class_afo(0)).b(112).a("Ocean").a(c);
		q = (new class_afp(1)).b(9286496).a("Plains");
		r = (new class_afe(2)).b(16421912).a("Desert").b().a(2.0F, 0.0F).a(e);
		s = (new class_aff(3, false)).b(6316128).a("Extreme Hills").a(i).a(0.2F, 0.3F);
		t = (new class_afh(4, 0)).b(353825).a("Forest");
		u = (new class_afv(5, 0)).b(747097).a("Taiga").a(5159473).a(0.25F, 0.8F).a(f);
		v = (new class_afu(6)).b(522674).a("Swampland").a(9154376).a(m).a(0.8F, 0.9F);
		w = (new class_afr(7)).b(255).a("River").a(b);
		x = (new class_afi(8)).b(16711680).a("Hell").b().a(2.0F, 0.0F);
		y = (new class_afw(9)).b(8421631).a("The End").b();
		z = (new class_afo(10)).b(9474208).a("FrozenOcean").c().a(c).a(0.0F, 0.5F);
		A = (new class_afr(11)).b(10526975).a("FrozenRiver").c().a(b).a(0.0F, 0.5F);
		B = (new class_afj(12, false)).b(16777215).a("Ice Plains").c().a(0.0F, 0.5F).a(e);
		C = (new class_afj(13, false)).b(10526880).a("Ice Mountains").c().a(g).a(0.0F, 0.5F);
		D = (new class_afm(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).a(l);
		E = (new class_afm(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).a(j);
		F = (new class_aey(16)).b(16440917).a("Beach").a(0.8F, 0.4F).a(j);
		G = (new class_afe(17)).b(13786898).a("DesertHills").b().a(2.0F, 0.0F).a(g);
		H = (new class_afh(18, 0)).b(2250012).a("ForestHills").a(g);
		I = (new class_afv(19, 0)).b(1456435).a("TaigaHills").a(5159473).a(0.25F, 0.8F).a(g);
		J = (new class_aff(20, true)).b(7501978).a("Extreme Hills Edge").a(i.a()).a(0.2F, 0.3F);
		K = (new class_afk(21, false)).b(5470985).a("Jungle").a(5470985).a(0.95F, 0.9F);
		L = (new class_afk(22, false)).b(2900485).a("JungleHills").a(5470985).a(0.95F, 0.9F).a(g);
		M = (new class_afk(23, true)).b(6458135).a("JungleEdge").a(5470985).a(0.95F, 0.8F);
		N = (new class_afo(24)).b(48).a("Deep Ocean").a(d);
		O = (new class_aft(25)).b(10658436).a("Stone Beach").a(0.2F, 0.3F).a(k);
		P = (new class_aey(26)).b(16445632).a("Cold Beach").a(0.05F, 0.3F).a(j).c();
		Q = (new class_afh(27, 2)).a("Birch Forest").b(3175492);
		R = (new class_afh(28, 2)).a("Birch Forest Hills").b(2055986).a(g);
		S = (new class_afh(29, 3)).b(4215066).a("Roofed Forest");
		T = (new class_afv(30, 0)).b(3233098).a("Cold Taiga").a(5159473).c().a(-0.5F, 0.4F).a(f).c(16777215);
		U = (new class_afv(31, 0)).b(2375478).a("Cold Taiga Hills").a(5159473).c().a(-0.5F, 0.4F).a(g).c(16777215);
		V = (new class_afv(32, 1)).b(5858897).a("Mega Taiga").a(5159473).a(0.3F, 0.8F).a(f);
		W = (new class_afv(33, 1)).b(4542270).a("Mega Taiga Hills").a(5159473).a(0.3F, 0.8F).a(g);
		X = (new class_aff(34, true)).b(5271632).a("Extreme Hills+").a(i).a(0.2F, 0.3F);
		Y = (new class_afs(35)).b(12431967).a("Savanna").a(1.2F, 0.0F).b().a(e);
		Z = (new class_afs(36)).b(10984804).a("Savanna Plateau").a(1.0F, 0.0F).b().a(h);
		aa = (new class_afl(37, false, false)).b(14238997).a("Mesa");
		ab = (new class_afl(38, false, true)).b(11573093).a("Mesa Plateau F").a(h);
		ac = (new class_afl(39, false, false)).b(13274213).a("Mesa Plateau").a(h);
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
		BiomeBase[] var0 = aE;
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			BiomeBase var3 = var0[var2];
			if (var3 != null) {
				if (o.containsKey(var3.ah)) {
					throw new Error("Biome \"" + var3.ah + "\" is defined as both ID " + ((BiomeBase) o.get(var3.ah)).az + " and " + var3.az);
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
		ae = new class_atb(new Random(1234L), 1);
		af = new class_atb(new Random(2345L), 1);
		ag = new class_aqh();
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_qc.values().length];

		static {
			try {
				a[class_qc.a.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_qc.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_qc.d.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_qc.c.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static class class_c_in_class_aez extends class_oc.class_a_in_class_oc {
		public Class b;
		public int c;
		public int d;

		public class_c_in_class_aez(Class var1, int var2, int var3, int var4) {
			super(var2);
			this.b = var1;
			this.c = var3;
			this.d = var4;
		}

		public String toString() {
			return this.b.getSimpleName() + "*(" + this.c + "-" + this.d + "):" + this.a;
		}
	}

	public static class class_a_in_class_aez {
		public float a;
		public float b;

		public class_a_in_class_aez(float var1, float var2) {
			this.a = var1;
			this.b = var2;
		}

		public BiomeBase.class_a_in_class_aez a() {
			return new BiomeBase.class_a_in_class_aez(this.a * 0.8F, this.b * 0.6F);
		}
	}

	public static enum class_b_in_class_aez {
		a, b, c, d;
	}
}
