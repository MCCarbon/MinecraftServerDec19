package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;

public abstract class EntityLiving extends Entity {
	private static final UUID a = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
	private static final class_rr b;
	protected static final class_jz as;
	private static final class_jz c;
	private static final class_jz f;
	private static final class_jz g;
	private static final class_jz h;
	private class_rt i;
	private final class_qh bo = new class_qh(this);
	private final Map bp = Maps.newHashMap();
	private final class_aco[] bq = new class_aco[2];
	private final class_aco[] br = new class_aco[4];
	public boolean at;
	public class_pu au;
	public int av;
	public int aw;
	public int ax;
	public int ay;
	public float az;
	public int aA;
	public float aB;
	public float aC;
	protected int aD;
	public float aE;
	public float aF;
	public float aG;
	public int aH = 20;
	public float aI;
	public float aJ;
	public float aK;
	public float aL;
	public float aM;
	public float aN;
	public float aO;
	public float aP;
	public float aQ = 0.02F;
	protected class_yu aR;
	protected int aS;
	protected boolean aT;
	protected int aU;
	protected float aV;
	protected float aW;
	protected float aX;
	protected float aY;
	protected float aZ;
	protected int ba;
	protected float bb;
	protected boolean bc;
	public float bd;
	public float be;
	public float bf;
	protected int bg;
	protected double bh;
	protected double bi;
	protected double bj;
	protected double bk;
	protected double bl;
	private boolean bs = true;
	private EntityLiving bt;
	private int bu;
	private EntityLiving bv;
	private int bw;
	private float bx;
	private int by;
	private float bz;
	protected class_aco bm;
	protected int bn;

	@Override
	public void I() {
		this.a(class_qi.j, Float.MAX_VALUE);
	}

	public EntityLiving(class_ago var1) {
		super(var1);
		be();
		this.c(bB());
		k = true;
		aL = (float) ((Math.random() + 1.0D) * 0.009999999776482582D);
		this.b(s, t, u);
		aK = (float) Math.random() * 12398.0F;
		y = (float) (Math.random() * 3.1415927410125732D * 2.0D);
		aO = y;
		S = 0.6F;
	}

	@Override
	protected void h() {
		ac.a(as, Byte.valueOf((byte) 0));
		ac.a(f, Integer.valueOf(0));
		ac.a(g, Boolean.valueOf(false));
		ac.a(h, Integer.valueOf(0));
		ac.a(c, Float.valueOf(1.0F));
	}

	protected void be() {
		bE().b(class_yf.a);
		bE().b(class_yf.c);
		bE().b(class_yf.d);
	}

	@Override
	protected void a(double var1, boolean var3, Block var4, class_cj var5) {
		if (!Y()) {
			Z();
		}

		if (!o.D && (O > 3.0F) && var3) {
			class_apn var6 = o.p(var5);
			Block var7 = var6.c();
			float var8 = MathHelper.f(O - 3.0F);
			if (var7.v() != class_avq.a) {
				double var9 = Math.min(0.2F + (var8 / 15.0F), 10.0F);
				if (var9 > 2.5D) {
					var9 = 2.5D;
				}

				int var11 = (int) (150.0D * var9);
				((class_ll) o).a(class_cy.M, s, t, u, var11, 0.0D, 0.0D, 0.0D, 0.15000000596046448D, new int[] { Block.f(var6) });
			}
		}

		super.a(var1, var3, var4, var5);
	}

	public boolean bf() {
		return false;
	}

	@Override
	public void M() {
		aB = aC;
		super.M();
		o.B.a("livingEntityBaseTick");
		boolean var1 = this instanceof class_yu;
		if (al()) {
			if (am()) {
				this.a(class_qi.e, 1.0F);
			} else if (var1 && !o.ah().a(aX())) {
				double var2 = o.ah().a(this) + o.ah().m();
				if (var2 < 0.0D) {
					this.a(class_qi.e, Math.max(1, MathHelper.c(-var2 * o.ah().n())));
				}
			}
		}

		if (W() || o.D) {
			P();
		}

		boolean var7 = var1 && ((class_yu) this).bI.a;
		if (al()) {
			if (this.a(class_avq.h)) {
				if (!bf() && !this.a(class_qs.m) && !var7) {
					this.h(this.c(aF()));
					if (aF() == -20) {
						this.h(0);

						for (int var3 = 0; var3 < 8; ++var3) {
							float var4 = V.nextFloat() - V.nextFloat();
							float var5 = V.nextFloat() - V.nextFloat();
							float var6 = V.nextFloat() - V.nextFloat();
							o.a(class_cy.e, s + var4, t + var5, u + var6, v, w, x, new int[0]);
						}

						this.a(class_qi.f, 2.0F);
					}
				}

				if (!o.D && az() && (m instanceof EntityLiving)) {
					this.a((Entity) null);
				}
			} else {
				this.h(300);
			}
		}

		if (al() && X()) {
			P();
		}

		aI = aJ;
		if (ax > 0) {
			--ax;
		}

		if ((Z > 0) && !(this instanceof class_lm)) {
			--Z;
		}

		if (bu() <= 0.0F) {
			bg();
		}

		if (aS > 0) {
			--aS;
		} else {
			aR = null;
		}

		if ((bv != null) && !bv.al()) {
			bv = null;
		}

		if (bt != null) {
			if (!bt.al()) {
				this.a((EntityLiving) null);
			} else if ((W - bu) > 100) {
				this.a((EntityLiving) null);
			}
		}

		bp();
		aY = aX;
		aN = aM;
		aP = aO;
		A = y;
		B = z;
		o.B.b();
	}

	public boolean i_() {
		return false;
	}

	protected void bg() {
		++aA;
		if (aA == 20) {
			int var1;
			if (!o.D && ((aS > 0) || bi()) && bh() && o.S().b("doMobLoot")) {
				var1 = this.b(aR);

				while (var1 > 0) {
					int var2 = EntityExperienceOrb.a(var1);
					var1 -= var2;
					o.a((new EntityExperienceOrb(o, s, t, u, var2)));
				}
			}

			L();

			for (var1 = 0; var1 < 20; ++var1) {
				double var8 = V.nextGaussian() * 0.02D;
				double var4 = V.nextGaussian() * 0.02D;
				double var6 = V.nextGaussian() * 0.02D;
				o.a(class_cy.a, (s + V.nextFloat() * J * 2.0F) - J, t + V.nextFloat() * K, (u + V.nextFloat() * J * 2.0F) - J, var8, var4, var6, new int[0]);
			}
		}

	}

	protected boolean bh() {
		return !i_();
	}

	protected int c(int var1) {
		int var2 = class_afl.c(this);
		return (var2 > 0) && (V.nextInt(var2 + 1) > 0) ? var1 : var1 - 1;
	}

	protected int b(class_yu var1) {
		return 0;
	}

	protected boolean bi() {
		return false;
	}

	public Random bj() {
		return V;
	}

	public EntityLiving bk() {
		return bt;
	}

	public int bl() {
		return bu;
	}

	public void a(EntityLiving var1) {
		bt = var1;
		bu = W;
	}

	public EntityLiving bm() {
		return bv;
	}

	public int bn() {
		return bw;
	}

	public void p(Entity var1) {
		if (var1 instanceof EntityLiving) {
			bv = (EntityLiving) var1;
		} else {
			bv = null;
		}

		bw = W;
	}

	public int bo() {
		return aU;
	}

	@Override
	public void b(class_dn var1) {
		var1.a("Health", bu());
		var1.a("HurtTime", (short) ax);
		var1.a("HurtByTimestamp", bu);
		var1.a("DeathTime", (short) aA);
		var1.a("AbsorptionAmount", bU());
		class_rc[] var2 = class_rc.values();
		int var3 = var2.length;

		int var4;
		class_rc var5;
		class_aco var6;
		for (var4 = 0; var4 < var3; ++var4) {
			var5 = var2[var4];
			var6 = this.a(var5);
			if (var6 != null) {
				bE().a(var6.a(var5));
			}
		}

		var1.a("Attributes", class_yf.a(bE()));
		var2 = class_rc.values();
		var3 = var2.length;

		for (var4 = 0; var4 < var3; ++var4) {
			var5 = var2[var4];
			var6 = this.a(var5);
			if (var6 != null) {
				bE().b(var6.a(var5));
			}
		}

		if (!bp.isEmpty()) {
			class_du var7 = new class_du();
			Iterator var8 = bp.values().iterator();

			while (var8.hasNext()) {
				class_qr var9 = (class_qr) var8.next();
				var7.a(var9.a(new class_dn()));
			}

			var1.a("ActiveEffects", var7);
		}

	}

	@Override
	public void a(class_dn var1) {
		this.n(var1.j("AbsorptionAmount"));
		if (var1.b("Attributes", 9) && (o != null) && !o.D) {
			class_yf.a(bE(), var1.c("Attributes", 10));
		}

		if (var1.b("ActiveEffects", 9)) {
			class_du var2 = var1.c("ActiveEffects", 10);

			for (int var3 = 0; var3 < var2.c(); ++var3) {
				class_dn var4 = var2.b(var3);
				class_qr var5 = class_qr.b(var4);
				if (var5 != null) {
					bp.put(var5.a(), var5);
				}
			}
		}

		if (var1.b("Health", 99)) {
			this.c(var1.j("Health"));
		}

		ax = var1.g("HurtTime");
		aA = var1.g("DeathTime");
		bu = var1.h("HurtByTimestamp");
		if (var1.b("Team", 8)) {
			String var6 = var1.l("Team");
			o.ab().a(aQ().toString(), var6);
		}

	}

	protected void bp() {
		Iterator var1 = bp.keySet().iterator();

		while (var1.hasNext()) {
			class_qq var2 = (class_qq) var1.next();
			class_qr var3 = (class_qr) bp.get(var2);
			if (!var3.a(this)) {
				if (!o.D) {
					var1.remove();
					this.b(var3);
				}
			} else if ((var3.b() % 600) == 0) {
				this.a(var3, false);
			}
		}

		if (bs) {
			if (!o.D) {
				C();
			}

			bs = false;
		}

		int var11 = ((Integer) ac.a(f)).intValue();
		boolean var12 = ((Boolean) ac.a(g)).booleanValue();
		if (var11 > 0) {
			boolean var4 = false;
			if (!aD()) {
				var4 = V.nextBoolean();
			} else {
				var4 = V.nextInt(15) == 0;
			}

			if (var12) {
				var4 &= V.nextInt(5) == 0;
			}

			if (var4 && (var11 > 0)) {
				double var5 = ((var11 >> 16) & 255) / 255.0D;
				double var7 = ((var11 >> 8) & 255) / 255.0D;
				double var9 = ((var11 >> 0) & 255) / 255.0D;
				o.a(var12 ? class_cy.q : class_cy.p, s + ((V.nextDouble() - 0.5D) * J), t + (V.nextDouble() * K), u + ((V.nextDouble() - 0.5D) * J), var5, var7, var9, new int[0]);
			}
		}

	}

	protected void C() {
		if (bp.isEmpty()) {
			bq();
			this.f(false);
		} else {
			Collection var1 = bp.values();
			ac.b(g, Boolean.valueOf(a(var1)));
			ac.b(f, Integer.valueOf(class_adb.a(var1)));
			this.f(this.a(class_qs.n));
		}

	}

	public static boolean a(Collection var0) {
		Iterator var1 = var0.iterator();

		class_qr var2;
		do {
			if (!var1.hasNext()) {
				return true;
			}

			var2 = (class_qr) var1.next();
		} while (var2.d());

		return false;
	}

	protected void bq() {
		ac.b(g, Boolean.valueOf(false));
		ac.b(f, Integer.valueOf(0));
	}

	public void br() {
		if (!o.D) {
			Iterator var1 = bp.values().iterator();

			while (var1.hasNext()) {
				this.b((class_qr) var1.next());
				var1.remove();
			}

		}
	}

	public Collection bs() {
		return bp.values();
	}

	public boolean a(class_qq var1) {
		return bp.containsKey(var1);
	}

	public class_qr b(class_qq var1) {
		return (class_qr) bp.get(var1);
	}

	public void c(class_qr var1) {
		if (this.d(var1)) {
			class_qr var2 = (class_qr) bp.get(var1.a());
			if (var2 == null) {
				bp.put(var1.a(), var1);
				this.a(var1);
			} else {
				var2.a(var1);
				this.a(var2, true);
			}

		}
	}

	public boolean d(class_qr var1) {
		if (bF() == class_rl.b) {
			class_qq var2 = var1.a();
			if ((var2 == class_qs.j) || (var2 == class_qs.s)) {
				return false;
			}
		}

		return true;
	}

	public boolean bt() {
		return bF() == class_rl.b;
	}

	public class_qr c(class_qq var1) {
		return (class_qr) bp.remove(var1);
	}

	public void d(class_qq var1) {
		class_qr var2 = this.c(var1);
		if (var2 != null) {
			this.b(var2);
		}

	}

	protected void a(class_qr var1) {
		bs = true;
		if (!o.D) {
			var1.a().b(this, bE(), var1.c());
		}

	}

	protected void a(class_qr var1, boolean var2) {
		bs = true;
		if (var2 && !o.D) {
			class_qq var3 = var1.a();
			var3.a(this, bE(), var1.c());
			var3.b(this, bE(), var1.c());
		}

	}

	protected void b(class_qr var1) {
		bs = true;
		if (!o.D) {
			var1.a().a(this, bE(), var1.c());
		}

	}

	public void b(float var1) {
		float var2 = bu();
		if (var2 > 0.0F) {
			this.c(var2 + var1);
		}

	}

	public final float bu() {
		return ((Float) ac.a(c)).floatValue();
	}

	public void c(float var1) {
		ac.b(c, Float.valueOf(MathHelper.a(var1, 0.0F, bB())));
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (o.D) {
			return false;
		} else {
			aU = 0;
			if (bu() <= 0.0F) {
				return false;
			} else if (var1.o() && this.a(class_qs.l)) {
				return false;
			} else {
				if (((var1 == class_qi.n) || (var1 == class_qi.o)) && (this.a(class_rc.f) != null)) {
					this.a(class_rc.f).a((int) ((var2 * 4.0F) + (V.nextFloat() * var2 * 2.0F)), this);
					var2 *= 0.75F;
				}

				boolean var3 = false;
				if ((var2 > 0.0F) && this.c(var1)) {
					this.k(var2);
					if (var1.a()) {
						var2 = 0.0F;
					} else {
						var2 *= 0.33F;
						if (var1.i() instanceof EntityLiving) {
							((EntityLiving) var1.i()).a(this, 0.5F, s - var1.i().s, u - var1.i().u);
						}
					}

					var3 = true;
				}

				aF = 1.5F;
				boolean var4 = true;
				if (Z > (aH / 2.0F)) {
					if (var2 <= bb) {
						return false;
					}

					this.d(var1, var2 - bb);
					bb = var2;
					var4 = false;
				} else {
					bb = var2;
					Z = aH;
					this.d(var1, var2);
					ax = ay = 10;
				}

				az = 0.0F;
				Entity var5 = var1.j();
				if (var5 != null) {
					if (var5 instanceof EntityLiving) {
						this.a((EntityLiving) var5);
					}

					if (var5 instanceof class_yu) {
						aS = 100;
						aR = (class_yu) var5;
					} else if (var5 instanceof EntityWolf) {
						EntityWolf var6 = (EntityWolf) var5;
						if (var6.cE()) {
							aS = 100;
							aR = null;
						}
					}
				}

				if (var4) {
					if (var3) {
						o.a(this, (byte) 29);
					} else {
						o.a(this, (byte) 2);
					}

					if ((var1 != class_qi.f) && (!var3 || (var2 > 0.0F))) {
						af();
					}

					if (var5 != null) {
						double var10 = var5.s - s;

						double var8;
						for (var8 = var5.u - u; ((var10 * var10) + (var8 * var8)) < 1.0E-4D; var8 = (Math.random() - Math.random()) * 0.01D) {
							var10 = (Math.random() - Math.random()) * 0.01D;
						}

						az = (float) (((MathHelper.b(var8, var10) * 180.0D) / 3.1415927410125732D) - y);
						this.a(var5, 0.4F, var10, var8);
					} else {
						az = (int) (Math.random() * 2.0D) * 180;
					}
				}

				String var11;
				if (bu() <= 0.0F) {
					var11 = bw();
					if (var4 && (var11 != null)) {
						this.a(var11, bI(), bJ());
					}

					this.a(var1);
				} else {
					var11 = bv();
					if (var4 && (var11 != null)) {
						this.a(var11, bI(), bJ());
					}
				}

				return true;
			}
		}
	}

	private boolean c(class_qi var1) {
		if (!var1.e() && cf()) {
			class_aym var2 = var1.v();
			if (var2 != null) {
				class_aym var3 = this.g(1.0F);
				class_aym var4 = var2.a(new class_aym(s, t, u)).a();
				var4 = new class_aym(var4.a, 0.0D, var4.c);
				if (var4.b(var3) < 0.0D) {
					return true;
				}
			}
		}

		return false;
	}

	public void b(class_aco var1) {
		this.a("random.break", 0.8F, 0.8F + (o.s.nextFloat() * 0.4F));

		for (int var2 = 0; var2 < 5; ++var2) {
			class_aym var3 = new class_aym((V.nextFloat() - 0.5D) * 0.1D, (Math.random() * 0.1D) + 0.1D, 0.0D);
			var3 = var3.a((-z * 3.1415927F) / 180.0F);
			var3 = var3.b((-y * 3.1415927F) / 180.0F);
			double var4 = ((-V.nextFloat()) * 0.6D) - 0.3D;
			class_aym var6 = new class_aym((V.nextFloat() - 0.5D) * 0.3D, var4, 0.6D);
			var6 = var6.a((-z * 3.1415927F) / 180.0F);
			var6 = var6.b((-y * 3.1415927F) / 180.0F);
			var6 = var6.b(s, t + aY(), u);
			o.a(class_cy.K, var6.a, var6.b, var6.c, var3.a, var3.b + 0.05D, var3.c, new int[] { Item.b(var1.b()) });
		}

	}

	public void a(class_qi var1) {
		Entity var2 = var1.j();
		EntityLiving var3 = bA();
		if ((ba >= 0) && (var3 != null)) {
			var3.b(this, ba);
		}

		if (var2 != null) {
			var2.b(this);
		}

		aT = true;
		bz().g();
		if (!o.D) {
			int var4 = 0;
			if (var2 instanceof class_yu) {
				var4 = class_afl.h((EntityLiving) var2);
			}

			if (bh() && o.S().b("doMobLoot")) {
				this.b(aS > 0, var4);
				this.a(aS > 0, var4);
				if ((aS > 0) && (V.nextFloat() < (0.025F + (var4 * 0.01F)))) {
					bx();
				}
			}
		}

		o.a(this, (byte) 3);
	}

	protected void a(boolean var1, int var2) {
	}

	public void a(Entity var1, float var2, double var3, double var5) {
		if (V.nextDouble() >= this.a(class_yf.c).e()) {
			ai = true;
			float var7 = MathHelper.a((var3 * var3) + (var5 * var5));
			v /= 2.0D;
			w /= 2.0D;
			x /= 2.0D;
			v -= (var3 / var7) * var2;
			w += var2;
			x -= (var5 / var7) * var2;
			if (w > 0.4000000059604645D) {
				w = 0.4000000059604645D;
			}

		}
	}

	protected String bv() {
		return "game.neutral.hurt";
	}

	protected String bw() {
		return "game.neutral.die";
	}

	protected void bx() {
	}

	protected void b(boolean var1, int var2) {
	}

	public boolean j_() {
		int var1 = MathHelper.c(s);
		int var2 = MathHelper.c(aX().b);
		int var3 = MathHelper.c(u);
		if ((this instanceof class_yu) && ((class_yu) this).w()) {
			return false;
		} else {
			class_cj var4 = new class_cj(var1, var2, var3);
			class_apn var5 = o.p(var4);
			Block var6 = var5.c();
			return (var6 != Blocks.LADDER) && (var6 != Blocks.VINE) ? (var6 instanceof class_ant) && this.a(var4, var5) : true;
		}
	}

	private boolean a(class_cj var1, class_apn var2) {
		if (((Boolean) var2.b(class_ant.b)).booleanValue()) {
			class_apn var3 = o.p(var1.b());
			if ((var3.c() == Blocks.LADDER) && (var3.b(class_alb.a) == var2.b(class_ant.a))) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean al() {
		return !I && (bu() > 0.0F);
	}

	@Override
	public void e(float var1, float var2) {
		super.e(var1, var2);
		class_qr var3 = this.b(class_qs.h);
		float var4 = var3 != null ? (float) (var3.c() + 1) : 0.0F;
		int var5 = MathHelper.f((var1 - 3.0F - var4) * var2);
		if (var5 > 0) {
			this.a(this.i(var5), 1.0F, 1.0F);
			this.a(class_qi.i, var5);
			int var6 = MathHelper.c(s);
			int var7 = MathHelper.c(t - 0.20000000298023224D);
			int var8 = MathHelper.c(u);
			Block var9 = o.p(new class_cj(var6, var7, var8)).c();
			if (var9.v() != class_avq.a) {
				Block.class_d_in_class_ail var10 = var9.H;
				this.a(var10.c(), var10.d() * 0.5F, var10.e() * 0.75F);
			}
		}

	}

	protected String i(int var1) {
		return var1 > 4 ? "game.neutral.hurt.fall.big" : "game.neutral.hurt.fall.small";
	}

	public int by() {
		int var1 = 0;
		Iterator var2 = aw().iterator();

		while (var2.hasNext()) {
			class_aco var3 = (class_aco) var2.next();
			if ((var3 != null) && (var3.b() instanceof class_aav)) {
				int var4 = ((class_aav) var3.b()).c;
				int var5 = var3.j();
				int var6 = var3.h();
				if (var6 > (var5 / 2)) {
					var4 = MathHelper.f((float) (var5 - var6) / (float) (var5 / 2));
				}

				var1 += var4;
			}
		}

		return var1;
	}

	protected void d(float var1) {
	}

	protected void k(float var1) {
	}

	protected float b(class_qi var1, float var2) {
		if (!var1.e()) {
			int var3 = 25 - by();
			float var4 = var2 * var3;
			this.d(var2);
			var2 = var4 / 25.0F;
		}

		return var2;
	}

	protected float c(class_qi var1, float var2) {
		if (var1.h()) {
			return var2;
		} else {
			int var3;
			int var4;
			float var5;
			if (this.a(class_qs.k) && (var1 != class_qi.j)) {
				var3 = (this.b(class_qs.k).c() + 1) * 5;
				var4 = 25 - var3;
				var5 = var2 * var4;
				var2 = var5 / 25.0F;
			}

			if (var2 <= 0.0F) {
				return 0.0F;
			} else {
				var3 = class_afl.a(aw(), var1);
				if (var3 > 20) {
					var3 = 20;
				}

				if ((var3 > 0) && (var3 <= 20)) {
					var4 = 25 - var3;
					var5 = var2 * var4;
					var2 = var5 / 25.0F;
				}

				return var2;
			}
		}
	}

	protected void d(class_qi var1, float var2) {
		if (!this.b(var1)) {
			var2 = this.b(var1, var2);
			var2 = this.c(var1, var2);
			float var3 = var2;
			var2 = Math.max(var2 - bU(), 0.0F);
			this.n(bU() - (var3 - var2));
			if (var2 != 0.0F) {
				float var4 = bu();
				this.c(var4 - var2);
				bz().a(var1, var4, var2);
				this.n(bU() - var2);
			}
		}
	}

	public class_qh bz() {
		return bo;
	}

	public EntityLiving bA() {
		return bo.c() != null ? bo.c() : (aR != null ? aR : (bt != null ? bt : null));
	}

	public final float bB() {
		return (float) this.a(class_yf.a).e();
	}

	public final int bC() {
		return ((Integer) ac.a(h)).intValue();
	}

	public final void j(int var1) {
		ac.b(h, Integer.valueOf(var1));
	}

	private int n() {
		return this.a(class_qs.c) ? 6 - ((1 + this.b(class_qs.c).c()) * 1) : (this.a(class_qs.d) ? 6 + ((1 + this.b(class_qs.d).c()) * 2) : 6);
	}

	public void a(class_pu var1) {
		if (!at || (av >= (this.n() / 2)) || (av < 0)) {
			av = -1;
			at = true;
			au = var1;
			if (o instanceof class_ll) {
				((class_ll) o).u().a(this, (new PacketPlayOutAnimation(this, var1 == class_pu.a ? 0 : 3)));
			}
		}

	}

	@Override
	protected void Q() {
		this.a(class_qi.j, 4.0F);
	}

	protected void bD() {
		int var1 = this.n();
		if (at) {
			++av;
			if (av >= var1) {
				av = 0;
				at = false;
			}
		} else {
			av = 0;
		}

		aC = (float) av / (float) var1;
	}

	public class_rq a(class_rp var1) {
		return bE().a(var1);
	}

	public class_rt bE() {
		if (i == null) {
			i = new class_rw();
		}

		return i;
	}

	public class_rl bF() {
		return class_rl.a;
	}

	public class_aco bG() {
		return this.a(class_rc.a);
	}

	public class_aco bH() {
		return this.a(class_rc.b);
	}

	public class_aco b(class_pu var1) {
		if (var1 == class_pu.a) {
			return this.a(class_rc.a);
		} else if (var1 == class_pu.b) {
			return this.a(class_rc.b);
		} else {
			throw new IllegalArgumentException("Invalid hand " + var1);
		}
	}

	public void a(class_pu var1, class_aco var2) {
		if (var1 == class_pu.a) {
			this.a(class_rc.a, var2);
		} else {
			if (var1 != class_pu.b) {
				throw new IllegalArgumentException("Invalid hand " + var1);
			}

			this.a(class_rc.b, var2);
		}

	}

	@Override
	public abstract Iterable aw();

	public abstract class_aco a(class_rc var1);

	@Override
	public abstract void a(class_rc var1, class_aco var2);

	@Override
	public void d(boolean var1) {
		super.d(var1);
		class_rq var2 = this.a(class_yf.d);
		if (var2.a(a) != null) {
			var2.c(b);
		}

		if (var1) {
			var2.b(b);
		}

	}

	protected float bI() {
		return 1.0F;
	}

	protected float bJ() {
		return i_() ? ((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.5F : ((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F;
	}

	protected boolean bK() {
		return bu() <= 0.0F;
	}

	public void q(Entity var1) {
		double var3 = var1.s;
		double var5 = var1.aX().b + var1.K;
		double var7 = var1.u;
		byte var9 = 1;

		for (int var10 = -var9; var10 <= var9; ++var10) {
			for (int var11 = -var9; var11 < var9; ++var11) {
				if ((var10 != 0) || (var11 != 0)) {
					int var12 = (int) (s + var10);
					int var13 = (int) (u + var11);
					class_ayk var2 = aX().c(var10, 1.0D, var11);
					if (o.a(var2).isEmpty()) {
						if (class_ago.a(o, (new class_cj(var12, (int) t, var13)))) {
							this.a(s + var10, t + 1.0D, u + var11);
							return;
						}

						if (class_ago.a(o, (new class_cj(var12, (int) t - 1, var13))) || (o.p(new class_cj(var12, (int) t - 1, var13)).c().v() == class_avq.h)) {
							var3 = s + var10;
							var5 = t + 1.0D;
							var7 = u + var11;
						}
					}
				}
			}
		}

		this.a(var3, var5, var7);
	}

	protected float bL() {
		return 0.42F;
	}

	protected void bM() {
		w = bL();
		if (this.a(class_qs.h)) {
			w += (this.b(class_qs.h).c() + 1) * 0.1F;
		}

		if (aB()) {
			float var1 = y * 0.017453292F;
			v -= MathHelper.a(var1) * 0.2F;
			x += MathHelper.b(var1) * 0.2F;
		}

		ai = true;
	}

	protected void bN() {
		w += 0.03999999910593033D;
	}

	protected void bO() {
		w += 0.03999999910593033D;
	}

	public void g(float var1, float var2) {
		double var3;
		float var10;
		if (bT()) {
			float var5;
			float var6;
			if (Y() && (!(this instanceof class_yu) || !((class_yu) this).bI.b)) {
				var3 = t;
				var5 = 0.8F;
				var6 = 0.02F;
				var10 = class_afl.d(this);
				if (var10 > 3.0F) {
					var10 = 3.0F;
				}

				if (!C) {
					var10 *= 0.5F;
				}

				if (var10 > 0.0F) {
					var5 += ((0.54600006F - var5) * var10) / 3.0F;
					var6 += (((bP() * 1.0F) - var6) * var10) / 3.0F;
				}

				this.a(var1, var2, var6);
				this.d(v, w, x);
				v *= var5;
				w *= 0.800000011920929D;
				x *= var5;
				w -= 0.02D;
				if (D && this.c(v, ((w + 0.6000000238418579D) - t) + var3, x)) {
					w = 0.30000001192092896D;
				}
			} else if (!ae() || ((this instanceof class_yu) && ((class_yu) this).bI.b)) {
				float var8 = 0.91F;
				if (C) {
					var8 = o.p(new class_cj(MathHelper.c(s), MathHelper.c(aX().b) - 1, MathHelper.c(u))).c().L * 0.91F;
				}

				float var4 = 0.16277136F / (var8 * var8 * var8);
				if (C) {
					var5 = bP() * var4;
				} else {
					var5 = aQ;
				}

				this.a(var1, var2, var5);
				var8 = 0.91F;
				if (C) {
					var8 = o.p(new class_cj(MathHelper.c(s), MathHelper.c(aX().b) - 1, MathHelper.c(u))).c().L * 0.91F;
				}

				if (j_()) {
					var6 = 0.15F;
					v = MathHelper.a(v, (-var6), var6);
					x = MathHelper.a(x, (-var6), var6);
					O = 0.0F;
					if (w < -0.15D) {
						w = -0.15D;
					}

					boolean var7 = aA() && (this instanceof class_yu);
					if (var7 && (w < 0.0D)) {
						w = 0.0D;
					}
				}

				this.d(v, w, x);
				if (D && j_()) {
					w = 0.2D;
				}

				if (this.a(class_qs.y)) {
					w += ((0.05D * (this.b(class_qs.y).c() + 1)) - w) * 0.2D;
				} else if (!o.D || (o.e(new class_cj((int) s, 0, (int) u)) && o.f(new class_cj((int) s, 0, (int) u)).p())) {
					w -= 0.08D;
				} else if (t > 0.0D) {
					w = -0.1D;
				} else {
					w = 0.0D;
				}

				w *= 0.9800000190734863D;
				v *= var8;
				x *= var8;
			} else {
				var3 = t;
				this.a(var1, var2, 0.02F);
				this.d(v, w, x);
				v *= 0.5D;
				w *= 0.5D;
				x *= 0.5D;
				w -= 0.02D;
				if (D && this.c(v, ((w + 0.6000000238418579D) - t) + var3, x)) {
					w = 0.30000001192092896D;
				}
			}
		}

		aE = aF;
		var3 = s - p;
		double var9 = u - r;
		var10 = MathHelper.a((var3 * var3) + (var9 * var9)) * 4.0F;
		if (var10 > 1.0F) {
			var10 = 1.0F;
		}

		aF += (var10 - aF) * 0.4F;
		aG += aF;
	}

	public float bP() {
		return bx;
	}

	public void l(float var1) {
		bx = var1;
	}

	public boolean r(Entity var1) {
		p(var1);
		return false;
	}

	public boolean bQ() {
		return false;
	}

	@Override
	public void r_() {
		super.r_();
		bZ();
		if (!o.D) {
			int var1 = bC();
			if (var1 > 0) {
				if (aw <= 0) {
					aw = 20 * (30 - var1);
				}

				--aw;
				if (aw <= 0) {
					this.j(var1 - 1);
				}
			}

			class_rc[] var2 = class_rc.values();
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				class_rc var5 = var2[var4];
				class_aco var6;
				switch (EntityLiving.SyntheticClass_1.a[var5.a().ordinal()]) {
					case 1:
						var6 = bq[var5.b()];
						break;
					case 2:
						var6 = br[var5.b()];
						break;
					default:
						continue;
				}

				class_aco var7 = this.a(var5);
				if (!class_aco.b(var7, var6)) {
					((class_ll) o).u().a(this, (new PacketPlayOutEntityEquipment(G(), var5, var7)));
					if (var6 != null) {
						bE().a(var6.a(var5));
					}

					if (var7 != null) {
						bE().b(var7.a(var5));
					}

					switch (EntityLiving.SyntheticClass_1.a[var5.a().ordinal()]) {
						case 1:
							bq[var5.b()] = var7 == null ? null : var7.k();
							break;
						case 2:
							br[var5.b()] = var7 == null ? null : var7.k();
					}
				}
			}

			if ((W % 20) == 0) {
				bz().g();
			}

			if (!ar) {
				boolean var10 = this.a(class_qs.x);
				if (this.g(6) != var10) {
					this.b(6, var10);
				}
			}
		}

		this.m();
		double var9 = s - p;
		double var11 = u - r;
		float var12 = (float) ((var9 * var9) + (var11 * var11));
		float var13 = aM;
		float var14 = 0.0F;
		aV = aW;
		float var8 = 0.0F;
		if (var12 > 0.0025000002F) {
			var8 = 1.0F;
			var14 = (float) Math.sqrt(var12) * 3.0F;
			var13 = (((float) MathHelper.b(var11, var9) * 180.0F) / 3.1415927F) - 90.0F;
		}

		if (aC > 0.0F) {
			var13 = y;
		}

		if (!C) {
			var8 = 0.0F;
		}

		aW += (var8 - aW) * 0.3F;
		o.B.a("headTurn");
		var14 = this.h(var13, var14);
		o.B.b();
		o.B.a("rangeChecks");

		while ((y - A) < -180.0F) {
			A -= 360.0F;
		}

		while ((y - A) >= 180.0F) {
			A += 360.0F;
		}

		while ((aM - aN) < -180.0F) {
			aN -= 360.0F;
		}

		while ((aM - aN) >= 180.0F) {
			aN += 360.0F;
		}

		while ((z - B) < -180.0F) {
			B -= 360.0F;
		}

		while ((z - B) >= 180.0F) {
			B += 360.0F;
		}

		while ((aO - aP) < -180.0F) {
			aP -= 360.0F;
		}

		while ((aO - aP) >= 180.0F) {
			aP += 360.0F;
		}

		o.B.b();
		aX += var14;
	}

	protected float h(float var1, float var2) {
		float var3 = MathHelper.g(var1 - aM);
		aM += var3 * 0.3F;
		float var4 = MathHelper.g(y - aM);
		boolean var5 = (var4 < -90.0F) || (var4 >= 90.0F);
		if (var4 < -75.0F) {
			var4 = -75.0F;
		}

		if (var4 >= 75.0F) {
			var4 = 75.0F;
		}

		aM = y - var4;
		if ((var4 * var4) > 2500.0F) {
			aM += var4 * 0.2F;
		}

		if (var5) {
			var2 *= -1.0F;
		}

		return var2;
	}

	public void m() {
		if (by > 0) {
			--by;
		}

		if (bg > 0) {
			double var1 = s + ((bh - s) / bg);
			double var3 = t + ((bi - t) / bg);
			double var5 = u + ((bj - u) / bg);
			double var7 = MathHelper.g(bk - y);
			y = (float) (y + (var7 / bg));
			z = (float) (z + ((bl - z) / bg));
			--bg;
			this.b(var1, var3, var5);
			this.b(y, z);
		} else if (!bT()) {
			v *= 0.98D;
			w *= 0.98D;
			x *= 0.98D;
		}

		if (Math.abs(v) < 0.005D) {
			v = 0.0D;
		}

		if (Math.abs(w) < 0.005D) {
			w = 0.0D;
		}

		if (Math.abs(x) < 0.005D) {
			x = 0.0D;
		}

		o.B.a("ai");
		if (bK()) {
			bc = false;
			bd = 0.0F;
			be = 0.0F;
			bf = 0.0F;
		} else if (bT()) {
			o.B.a("newAi");
			bR();
			o.B.b();
		}

		o.B.b();
		o.B.a("jump");
		if (bc) {
			if (Y()) {
				bN();
			} else if (ae()) {
				bO();
			} else if (C && (by == 0)) {
				bM();
				by = 10;
			}
		} else {
			by = 0;
		}

		o.B.b();
		o.B.a("travel");
		bd *= 0.98F;
		be *= 0.98F;
		bf *= 0.9F;
		this.g(bd, be);
		o.B.b();
		o.B.a("push");
		if (!o.D) {
			bS();
		}

		o.B.b();
	}

	protected void bR() {
	}

	protected void bS() {
		List var1 = o.a(this, aX().b(0.20000000298023224D, 0.0D, 0.20000000298023224D), Predicates.and(class_rb.d, new Predicate() {
			public boolean a(Entity var1) {
				return var1.ah();
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		}));
		if (!var1.isEmpty()) {
			for (int var2 = 0; var2 < var1.size(); ++var2) {
				Entity var3 = (Entity) var1.get(var2);
				s(var3);
			}
		}

	}

	protected void s(Entity var1) {
		var1.i(this);
	}

	@Override
	public void a(Entity var1) {
		if ((m != null) && (var1 == null)) {
			if (!o.D) {
				q(m);
			}

			if (m != null) {
				m.l = null;
			}

			m = null;
		} else {
			super.a(var1);
		}
	}

	@Override
	public void an() {
		super.an();
		aV = aW;
		aW = 0.0F;
		O = 0.0F;
	}

	public void i(boolean var1) {
		bc = var1;
	}

	public void a(Entity var1, int var2) {
		if (!var1.I && !o.D) {
			class_lg var3 = ((class_ll) o).u();
			if (var1 instanceof EntityItem) {
				var3.a(var1, (new PacketPlayOutCollect(var1.G(), G())));
			}

			if (var1 instanceof EntityArrow) {
				var3.a(var1, (new PacketPlayOutCollect(var1.G(), G())));
			}

			if (var1 instanceof EntityExperienceOrb) {
				var3.a(var1, (new PacketPlayOutCollect(var1.G(), G())));
			}
		}

	}

	public boolean t(Entity var1) {
		return o.a(new class_aym(s, t + aY(), u), new class_aym(var1.s, var1.t + var1.aY(), var1.u)) == null;
	}

	@Override
	public class_aym as() {
		return this.g(1.0F);
	}

	@Override
	public class_aym g(float var1) {
		if (var1 == 1.0F) {
			return this.f(z, aO);
		} else {
			float var2 = B + ((z - B) * var1);
			float var3 = aP + ((aO - aP) * var1);
			return this.f(var2, var3);
		}
	}

	public boolean bT() {
		return !o.D;
	}

	@Override
	public boolean ag() {
		return !I;
	}

	@Override
	public boolean ah() {
		return !I;
	}

	@Override
	protected void af() {
		G = V.nextDouble() >= this.a(class_yf.c).e();
	}

	@Override
	public float aI() {
		return aO;
	}

	@Override
	public void i(float var1) {
		aO = var1;
	}

	@Override
	public void j(float var1) {
		aM = var1;
	}

	public float bU() {
		return bz;
	}

	public void n(float var1) {
		if (var1 < 0.0F) {
			var1 = 0.0F;
		}

		bz = var1;
	}

	public void i() {
	}

	public void j() {
	}

	protected void bV() {
		bs = true;
	}

	public boolean bX() {
		return (((Byte) ac.a(as)).byteValue() & 1) > 0;
	}

	public class_pu bY() {
		return (((Byte) ac.a(as)).byteValue() & 2) > 0 ? class_pu.b : class_pu.a;
	}

	protected void bZ() {
		if (bX()) {
			class_aco var1 = this.b(bY());
			if (var1 == bm) {
				if ((cb() <= 25) && ((cb() % 4) == 0)) {
					this.a(bm, 5);
				}

				if ((--bn == 0) && !o.D) {
					this.t();
				}
			} else {
				ce();
			}
		}

	}

	public void c(class_pu var1) {
		class_aco var2 = this.b(var1);
		if ((var2 != null) && !bX()) {
			bm = var2;
			bn = var2.l();
			if (!o.D) {
				int var3 = 1;
				if (var1 == class_pu.b) {
					var3 |= 2;
				}

				ac.b(as, Byte.valueOf((byte) var3));
			}

		}
	}

	@Override
	public void a(class_jz var1) {
		super.a(var1);
		if ((var1 == as) && o.D) {
			if (bX() && (bm == null)) {
				bm = this.b(bY());
				if (bm != null) {
					bn = bm.l();
				}
			} else if (!bX() && (bm != null)) {
				bm = null;
				bn = 0;
			}
		}

	}

	protected void a(class_aco var1, int var2) {
		if ((var1 != null) && bX()) {
			if (var1.m() == class_ady.c) {
				this.a("random.drink", 0.5F, (o.s.nextFloat() * 0.1F) + 0.9F);
			}

			if (var1.m() == class_ady.b) {
				for (int var3 = 0; var3 < var2; ++var3) {
					class_aym var4 = new class_aym((V.nextFloat() - 0.5D) * 0.1D, (Math.random() * 0.1D) + 0.1D, 0.0D);
					var4 = var4.a((-z * 3.1415927F) / 180.0F);
					var4 = var4.b((-y * 3.1415927F) / 180.0F);
					double var5 = ((-V.nextFloat()) * 0.6D) - 0.3D;
					class_aym var7 = new class_aym((V.nextFloat() - 0.5D) * 0.3D, var5, 0.6D);
					var7 = var7.a((-z * 3.1415927F) / 180.0F);
					var7 = var7.b((-y * 3.1415927F) / 180.0F);
					var7 = var7.b(s, t + aY(), u);
					if (var1.f()) {
						o.a(class_cy.K, var7.a, var7.b, var7.c, var4.a, var4.b + 0.05D, var4.c, new int[] { Item.b(var1.b()), var1.i() });
					} else {
						o.a(class_cy.K, var7.a, var7.b, var7.c, var4.a, var4.b + 0.05D, var4.c, new int[] { Item.b(var1.b()) });
					}
				}

				this.a("random.eat", 0.5F + (0.5F * V.nextInt(2)), ((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F);
			}

		}
	}

	protected void t() {
		if ((bm != null) && bX()) {
			this.a(bm, 16);
			class_aco var1 = bm.a(o, this);
			if ((var1 != null) && (var1.b == 0)) {
				var1 = null;
			}

			this.a(bY(), var1);
			ce();
		}

	}

	public class_aco ca() {
		return bm;
	}

	public int cb() {
		return bn;
	}

	public int cc() {
		return bX() ? bm.l() - cb() : 0;
	}

	public void cd() {
		if (bm != null) {
			bm.a(o, this, cb());
		}

		ce();
	}

	public void ce() {
		if (!o.D) {
			ac.b(as, Byte.valueOf((byte) 0));
		}

		bm = null;
		bn = 0;
	}

	public boolean cf() {
		if (bX() && (bm != null)) {
			Item var1 = bm.b();
			return var1.f(bm) != class_ady.d ? false : (var1.e(bm) - bn) >= 10;
		} else {
			return false;
		}
	}

	static {
		b = (new class_rr(a, "Sprinting speed boost", 0.30000001192092896D, 2)).a(false);
		as = DataWatcher.claimId(EntityLiving.class, class_kb.a);
		c = DataWatcher.claimId(EntityLiving.class, class_kb.c);
		f = DataWatcher.claimId(EntityLiving.class, class_kb.b);
		g = DataWatcher.claimId(EntityLiving.class, class_kb.g);
		h = DataWatcher.claimId(EntityLiving.class, class_kb.b);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_rc.class_a_in_class_rc.values().length];

		static {
			try {
				a[class_rc.class_a_in_class_rc.a.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_rc.class_a_in_class_rc.b.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
