package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class EntityInsentient extends EntityLiving {
	
	private static final class_jz a;
	public int a_;
	protected int b_;
	private class_sd b;
	protected class_se f;
	protected class_sc g;
	private class_sa c;
	protected class_um h;
	protected final class_ss i;
	protected final class_ss bo;
	private EntityLiving br;
	private class_uq bs;
	private class_aco[] bt = new class_aco[2];
	protected float[] bp = new float[2];
	private class_aco[] bu = new class_aco[4];
	protected float[] bq = new float[4];
	private boolean bv;
	private boolean bw;
	private boolean bx;
	private Entity by;
	private class_dn bz;

	public EntityInsentient(class_ago var1) {
		super(var1);
		i = new class_ss((var1 != null) && (var1.B != null) ? var1.B : null);
		bo = new class_ss((var1 != null) && (var1.B != null) ? var1.B : null);
		b = new class_sd(this);
		f = new class_se(this);
		g = new class_sc(this);
		c = this.p();
		h = this.b(var1);
		bs = new class_uq(this);

		int var2;
		for (var2 = 0; var2 < bq.length; ++var2) {
			bq[var2] = 0.085F;
		}

		for (var2 = 0; var2 < bp.length; ++var2) {
			bp[var2] = 0.085F;
		}

	}

	@Override
	protected void be() {
		super.be();
		bE().b(class_yf.b).a(16.0D);
	}

	protected class_um b(class_ago var1) {
		return new class_ul(this, var1);
	}

	protected class_sa p() {
		return new class_sa(this);
	}

	public class_sd q() {
		return b;
	}

	public class_se r() {
		return f;
	}

	public class_sc s() {
		return g;
	}

	public class_um u() {
		return h;
	}

	public class_uq v() {
		return bs;
	}

	public EntityLiving w() {
		return br;
	}

	public void c(EntityLiving var1) {
		br = var1;
	}

	public boolean a(Class var1) {
		return var1 != EntityGhast.class;
	}

	public void x() {
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Byte.valueOf((byte) 0));
	}

	public int y() {
		return 80;
	}

	public void z() {
		String var1 = B();
		if (var1 != null) {
			this.a(var1, bI(), bJ());
		}

	}

	@Override
	public void M() {
		super.M();
		o.B.a("mobBaseTick");
		if (al() && (V.nextInt(1000) < a_++)) {
			a_ = -y();
			z();
		}

		o.B.b();
	}

	@Override
	protected int b(class_yu var1) {
		if (b_ > 0) {
			int var2 = b_;

			int var3;
			for (var3 = 0; var3 < bu.length; ++var3) {
				if ((bu[var3] != null) && (bq[var3] <= 1.0F)) {
					var2 += 1 + V.nextInt(3);
				}
			}

			for (var3 = 0; var3 < bt.length; ++var3) {
				if ((bt[var3] != null) && (bp[var3] <= 1.0F)) {
					var2 += 1 + V.nextInt(3);
				}
			}

			return var2;
		} else {
			return b_;
		}
	}

	public void A() {
		if (o.D) {
			for (int var1 = 0; var1 < 20; ++var1) {
				double var2 = V.nextGaussian() * 0.02D;
				double var4 = V.nextGaussian() * 0.02D;
				double var6 = V.nextGaussian() * 0.02D;
				double var8 = 10.0D;
				o.a(class_cy.a, (s + V.nextFloat() * J * 2.0F) - J - (var2 * var8), (t + V.nextFloat() * K) - (var4 * var8), (u + V.nextFloat() * J * 2.0F) - J - (var6 * var8), var2, var4, var6, new int[0]);
			}
		} else {
			o.a(this, (byte) 20);
		}

	}

	@Override
	public void r_() {
		super.r_();
		if (!o.D) {
			cs();
		}

	}

	@Override
	protected float h(float var1, float var2) {
		c.a();
		return var2;
	}

	protected String B() {
		return null;
	}

	protected Item D() {
		return null;
	}

	@Override
	protected void b(boolean var1, int var2) {
		Item var3 = D();
		if (var3 != null) {
			int var4 = V.nextInt(3);
			if (var2 > 0) {
				var4 += V.nextInt(var2 + 1);
			}

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("CanPickUpLoot", cq());
		var1.a("PersistenceRequired", bw);
		class_du var2 = new class_du();

		for (int var3 = 0; var3 < bu.length; ++var3) {
			class_dn var4 = new class_dn();
			if (bu[var3] != null) {
				bu[var3].b(var4);
			}

			var2.a(var4);
		}

		var1.a("ArmorItems", var2);
		class_du var8 = new class_du();

		for (int var9 = 0; var9 < bt.length; ++var9) {
			class_dn var5 = new class_dn();
			if (bt[var9] != null) {
				bt[var9].b(var5);
			}

			var8.a(var5);
		}

		var1.a("HandItems", var8);
		class_du var10 = new class_du();

		for (int var11 = 0; var11 < bq.length; ++var11) {
			var10.a((new class_dr(bq[var11])));
		}

		var1.a("ArmorDropChances", var10);
		class_du var12 = new class_du();

		for (int var6 = 0; var6 < bp.length; ++var6) {
			var12.a((new class_dr(bp[var6])));
		}

		var1.a("HandDropChances", var12);
		var1.a("Leashed", bx);
		if (by != null) {
			class_dn var13 = new class_dn();
			if (by instanceof EntityLiving) {
				UUID var7 = by.aQ();
				var13.a("UUID", var7);
			} else if (by instanceof class_wt) {
				class_cj var14 = ((class_wt) by).m();
				var13.a("X", var14.n());
				var13.a("Y", var14.o());
				var13.a("Z", var14.p());
			}

			var1.a("Leash", var13);
		}

		var1.a("LeftHanded", cx());
		if (cw()) {
			var1.a("NoAI", cw());
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("CanPickUpLoot", 1)) {
			this.j(var1.p("CanPickUpLoot"));
		}

		bw = var1.p("PersistenceRequired");
		class_du var2;
		int var3;
		if (var1.b("ArmorItems", 9)) {
			var2 = var1.c("ArmorItems", 10);

			for (var3 = 0; var3 < bu.length; ++var3) {
				bu[var3] = class_aco.a(var2.b(var3));
			}
		}

		if (var1.b("HandItems", 9)) {
			var2 = var1.c("HandItems", 10);

			for (var3 = 0; var3 < bt.length; ++var3) {
				bt[var3] = class_aco.a(var2.b(var3));
			}
		}

		if (var1.b("ArmorDropChances", 9)) {
			var2 = var1.c("ArmorDropChances", 5);

			for (var3 = 0; var3 < var2.c(); ++var3) {
				bq[var3] = var2.f(var3);
			}
		}

		if (var1.b("HandDropChances", 9)) {
			var2 = var1.c("HandDropChances", 5);

			for (var3 = 0; var3 < var2.c(); ++var3) {
				bp[var3] = var2.f(var3);
			}
		}

		bx = var1.p("Leashed");
		if (bx && var1.b("Leash", 10)) {
			bz = var1.o("Leash");
		}

		this.l(var1.p("LeftHanded"));
		this.k(var1.p("NoAI"));
	}

	public void o(float var1) {
		be = var1;
	}

	@Override
	public void l(float var1) {
		super.l(var1);
		this.o(var1);
	}

	@Override
	public void m() {
		super.m();
		o.B.a("looting");
		if (!o.D && cq() && !aT && o.S().b("mobGriefing")) {
			List var1 = o.a(EntityItem.class, aX().b(1.0D, 0.0D, 1.0D));
			Iterator var2 = var1.iterator();

			while (var2.hasNext()) {
				EntityItem var3 = (EntityItem) var2.next();
				if (!var3.I && (var3.j() != null) && !var3.r()) {
					this.a(var3);
				}
			}
		}

		o.B.b();
	}

	protected void a(EntityItem var1) {
		class_aco var2 = var1.j();
		class_rc var3 = c(var2);
		boolean var4 = true;
		class_aco var5 = this.a(var3);
		if (var5 != null) {
			if (var3.a() == class_rc.class_a_in_class_rc.a) {
				if ((var2.b() instanceof class_adv) && !(var5.b() instanceof class_adv)) {
					var4 = true;
				} else if ((var2.b() instanceof class_adv) && (var5.b() instanceof class_adv)) {
					class_adv var6 = (class_adv) var2.b();
					class_adv var7 = (class_adv) var5.b();
					if (var6.g() == var7.g()) {
						var4 = (var2.i() > var5.i()) || (var2.n() && !var5.n());
					} else {
						var4 = var6.g() > var7.g();
					}
				} else if ((var2.b() instanceof class_abg) && (var5.b() instanceof class_abg)) {
					var4 = var2.n() && !var5.n();
				} else {
					var4 = false;
				}
			} else if ((var2.b() instanceof class_aav) && !(var5.b() instanceof class_aav)) {
				var4 = true;
			} else if ((var2.b() instanceof class_aav) && (var5.b() instanceof class_aav)) {
				class_aav var9 = (class_aav) var2.b();
				class_aav var11 = (class_aav) var5.b();
				if (var9.c == var11.c) {
					var4 = (var2.i() > var5.i()) || (var2.n() && !var5.n());
				} else {
					var4 = var9.c > var11.c;
				}
			} else {
				var4 = false;
			}
		}

		if (var4 && this.a(var2)) {
			double var10;
			switch (EntityInsentient.SyntheticClass_1.a[var3.a().ordinal()]) {
				case 1:
					var10 = bp[var3.b()];
					break;
				case 2:
					var10 = bq[var3.b()];
					break;
				default:
					var10 = 0.0D;
			}

			if ((var5 != null) && (V.nextFloat() - 0.1F < var10)) {
				this.a(var5, 0.0F);
			}

			if ((var2.b() == Items.k) && (var1.m() != null)) {
				class_yu var8 = o.a(var1.m());
				if (var8 != null) {
					var8.b(class_my.x);
				}
			}

			this.a(var3, var2);
			switch (EntityInsentient.SyntheticClass_1.a[var3.a().ordinal()]) {
				case 1:
					bp[var3.b()] = 2.0F;
					break;
				case 2:
					bq[var3.b()] = 2.0F;
			}

			bw = true;
			this.a(var1, 1);
			var1.L();
		}

	}

	protected boolean a(class_aco var1) {
		return true;
	}

	protected boolean E() {
		return true;
	}

	protected void F() {
		if (bw) {
			aU = 0;
		} else {
			class_yu var1 = o.a(this, -1.0D);
			if (var1 != null) {
				double var2 = var1.s - s;
				double var4 = var1.t - t;
				double var6 = var1.u - u;
				double var8 = (var2 * var2) + (var4 * var4) + (var6 * var6);
				if (E() && (var8 > 16384.0D)) {
					L();
				}

				if ((aU > 600) && (V.nextInt(800) == 0) && (var8 > 1024.0D) && E()) {
					L();
				} else if (var8 < 1024.0D) {
					aU = 0;
				}
			}

		}
	}

	@Override
	protected final void bR() {
		++aU;
		o.B.a("checkDespawn");
		F();
		o.B.b();
		o.B.a("sensing");
		bs.a();
		o.B.b();
		o.B.a("targetSelector");
		bo.a();
		o.B.b();
		o.B.a("goalSelector");
		i.a();
		o.B.b();
		o.B.a("navigation");
		h.k();
		o.B.b();
		o.B.a("mob tick");
		cg();
		o.B.b();
		o.B.a("controls");
		o.B.a("move");
		f.c();
		o.B.c("look");
		b.a();
		o.B.c("jump");
		g.b();
		o.B.b();
		o.B.b();
	}

	protected void cg() {
	}

	public int ch() {
		return 40;
	}

	public int ci() {
		return 10;
	}

	public void a(Entity var1, float var2, float var3) {
		double var4 = var1.s - s;
		double var8 = var1.u - u;
		double var6;
		if (var1 instanceof EntityLiving) {
			EntityLiving var10 = (EntityLiving) var1;
			var6 = (var10.t + var10.aY()) - (t + aY());
		} else {
			var6 = ((var1.aX().b + var1.aX().e) / 2.0D) - (t + aY());
		}

		double var14 = MathHelper.a((var4 * var4) + (var8 * var8));
		float var12 = (float) ((MathHelper.b(var8, var4) * 180.0D) / 3.1415927410125732D) - 90.0F;
		float var13 = (float) (-((MathHelper.b(var6, var14) * 180.0D) / 3.1415927410125732D));
		z = this.b(z, var13, var3);
		y = this.b(y, var12, var2);
	}

	private float b(float var1, float var2, float var3) {
		float var4 = MathHelper.g(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	public boolean cj() {
		return true;
	}

	public boolean ck() {
		return o.a(aX(), this) && o.a(this, aX()).isEmpty() && !o.d(aX());
	}

	public int cn() {
		return 4;
	}

	@Override
	public int aK() {
		if (w() == null) {
			return 3;
		} else {
			int var1 = (int) (bu() - (bB() * 0.33F));
			var1 -= (3 - o.ac().a()) * 4;
			if (var1 < 0) {
				var1 = 0;
			}

			return var1 + 3;
		}
	}

	@Override
	public Iterable av() {
		return Arrays.asList(bt);
	}

	@Override
	public Iterable aw() {
		return Arrays.asList(bu);
	}

	@Override
	public class_aco a(class_rc var1) {
		class_aco var2 = null;
		switch (EntityInsentient.SyntheticClass_1.a[var1.a().ordinal()]) {
			case 1:
				var2 = bt[var1.b()];
				break;
			case 2:
				var2 = bu[var1.b()];
		}

		return var2;
	}

	@Override
	public void a(class_rc var1, class_aco var2) {
		switch (EntityInsentient.SyntheticClass_1.a[var1.a().ordinal()]) {
			case 1:
				bt[var1.b()] = var2;
				break;
			case 2:
				bu[var1.b()] = var2;
		}

	}

	@Override
	protected void a(boolean var1, int var2) {
		class_rc[] var3 = class_rc.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_rc var6 = var3[var5];
			class_aco var7 = this.a(var6);
			double var8;
			switch (EntityInsentient.SyntheticClass_1.a[var6.a().ordinal()]) {
				case 1:
					var8 = bp[var6.b()];
					break;
				case 2:
					var8 = bq[var6.b()];
					break;
				default:
					var8 = 0.0D;
			}

			boolean var10 = var8 > 1.0D;
			if ((var7 != null) && (var1 || var10) && (V.nextFloat() - (var2 * 0.01F) < var8)) {
				if (!var10 && var7.e()) {
					int var11 = Math.max(var7.j() - 25, 1);
					int var12 = var7.j() - V.nextInt(V.nextInt(var11) + 1);
					if (var12 > var11) {
						var12 = var11;
					}

					if (var12 < 1) {
						var12 = 1;
					}

					var7.b(var12);
				}

				this.a(var7, 0.0F);
			}
		}

	}

	protected void a(class_pt var1) {
		if (V.nextFloat() < (0.15F * var1.c())) {
			int var2 = V.nextInt(2);
			float var3 = o.ac() == class_ps.d ? 0.1F : 0.25F;
			if (V.nextFloat() < 0.095F) {
				++var2;
			}

			if (V.nextFloat() < 0.095F) {
				++var2;
			}

			if (V.nextFloat() < 0.095F) {
				++var2;
			}

			boolean var4 = true;
			class_rc[] var5 = class_rc.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				class_rc var8 = var5[var7];
				if (var8.a() == class_rc.class_a_in_class_rc.b) {
					class_aco var9 = this.a(var8);
					if (!var4 && (V.nextFloat() < var3)) {
						break;
					}

					var4 = false;
					if (var9 == null) {
						Item var10 = a(var8, var2);
						if (var10 != null) {
							this.a(var8, new class_aco(var10));
						}
					}
				}
			}
		}

	}

	public static class_rc c(class_aco var0) {
		return (var0.b() != Item.a(Blocks.PUMPKIN)) && (var0.b() != Items.cc) ? (var0.b() instanceof class_aav ? ((class_aav) var0.b()).b : class_rc.a) : class_rc.f;
	}

	public static Item a(class_rc var0, int var1) {
		switch (EntityInsentient.SyntheticClass_1.b[var0.ordinal()]) {
			case 1:
				if (var1 == 0) {
					return Items.S;
				} else if (var1 == 1) {
					return Items.ai;
				} else if (var1 == 2) {
					return Items.W;
				} else if (var1 == 3) {
					return Items.aa;
				} else if (var1 == 4) {
					return Items.ae;
				}
			case 2:
				if (var1 == 0) {
					return Items.T;
				} else if (var1 == 1) {
					return Items.aj;
				} else if (var1 == 2) {
					return Items.X;
				} else if (var1 == 3) {
					return Items.ab;
				} else if (var1 == 4) {
					return Items.af;
				}
			case 3:
				if (var1 == 0) {
					return Items.U;
				} else if (var1 == 1) {
					return Items.ak;
				} else if (var1 == 2) {
					return Items.Y;
				} else if (var1 == 3) {
					return Items.ac;
				} else if (var1 == 4) {
					return Items.ag;
				}
			case 4:
				if (var1 == 0) {
					return Items.V;
				} else if (var1 == 1) {
					return Items.al;
				} else if (var1 == 2) {
					return Items.Z;
				} else if (var1 == 3) {
					return Items.ad;
				} else if (var1 == 4) {
					return Items.ah;
				}
			default:
				return null;
		}
	}

	protected void b(class_pt var1) {
		float var2 = var1.c();
		if ((bG() != null) && (V.nextFloat() < (0.25F * var2))) {
			class_afl.a(V, bG(), (int) (5.0F + (var2 * V.nextInt(18))));
		}

		class_rc[] var3 = class_rc.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_rc var6 = var3[var5];
			if (var6.a() == class_rc.class_a_in_class_rc.b) {
				class_aco var7 = this.a(var6);
				if ((var7 != null) && (V.nextFloat() < (0.5F * var2))) {
					class_afl.a(V, var7, (int) (5.0F + (var2 * V.nextInt(18))));
				}
			}
		}

	}

	public class_rj a(class_pt var1, class_rj var2) {
		this.a(class_yf.b).b(new class_rr("Random spawn bonus", V.nextGaussian() * 0.05D, 1));
		if (V.nextFloat() < 0.05F) {
			this.l(true);
		} else {
			this.l(false);
		}

		return var2;
	}

	public boolean co() {
		return false;
	}

	public void cp() {
		bw = true;
	}

	public void a(class_rc var1, float var2) {
		switch (EntityInsentient.SyntheticClass_1.a[var1.a().ordinal()]) {
			case 1:
				bp[var1.b()] = var2;
				break;
			case 2:
				bq[var1.b()] = var2;
		}

	}

	public boolean cq() {
		return bv;
	}

	public void j(boolean var1) {
		bv = var1;
	}

	public boolean cr() {
		return bw;
	}

	@Override
	public final boolean a(class_yu var1, class_aco var2, class_pu var3) {
		if (cu() && (cv() == var1)) {
			this.a(true, !var1.bI.d);
			return true;
		} else {
			if ((var2 != null) && (var2.b() == Items.cs) && ct()) {
				if (!(this instanceof class_ro) || !((class_ro) this).cE()) {
					this.a(var1, true);
					--var2.b;
					return true;
				}

				if (((class_ro) this).d((EntityLiving) var1)) {
					this.a(var1, true);
					--var2.b;
					return true;
				}
			}

			return this.a(var1, var3, var2) ? true : super.a(var1, var2, var3);
		}
	}

	protected boolean a(class_yu var1, class_pu var2, class_aco var3) {
		return false;
	}

	protected void cs() {
		if (bz != null) {
			this.n();
		}

		if (bx) {
			if (!al()) {
				this.a(true, true);
			}

			if ((by == null) || by.I) {
				this.a(true, true);
			}
		}
	}

	public void a(boolean var1, boolean var2) {
		if (bx) {
			bx = false;
			by = null;
			if (!o.D && var2) {
				this.a(Items.cs, 1);
			}

			if (!o.D && var1 && (o instanceof class_ll)) {
				((class_ll) o).u().a(this, (new class_hm(1, this, (Entity) null)));
			}
		}

	}

	public boolean ct() {
		return !cu() && !(this instanceof class_xx);
	}

	public boolean cu() {
		return bx;
	}

	public Entity cv() {
		return by;
	}

	public void a(Entity var1, boolean var2) {
		bx = true;
		by = var1;
		if (!o.D && var2 && (o instanceof class_ll)) {
			((class_ll) o).u().a(this, (new class_hm(1, this, by)));
		}

	}

	private void n() {
		if (bx && (bz != null)) {
			if (bz.b("UUID")) {
				UUID var1 = bz.a("UUID");
				List var2 = o.a(EntityLiving.class, aX().b(10.0D, 10.0D, 10.0D));
				Iterator var3 = var2.iterator();

				while (var3.hasNext()) {
					EntityLiving var4 = (EntityLiving) var3.next();
					if (var4.aQ().equals(var1)) {
						by = var4;
						break;
					}
				}
			} else if (bz.b("X", 99) && bz.b("Y", 99) && bz.b("Z", 99)) {
				class_cj var5 = new class_cj(bz.h("X"), bz.h("Y"), bz.h("Z"));
				EntityLeash var6 = EntityLeash.b(o, var5);
				if (var6 == null) {
					var6 = EntityLeash.a(o, var5);
				}

				by = var6;
			} else {
				this.a(false, true);
			}
		}

		bz = null;
	}

	@Override
	public boolean c(int var1, class_aco var2) {
		class_rc var3;
		if (var1 == 98) {
			var3 = class_rc.a;
		} else if (var1 == 99) {
			var3 = class_rc.b;
		} else if (var1 == (100 + class_rc.f.b())) {
			var3 = class_rc.f;
		} else if (var1 == (100 + class_rc.e.b())) {
			var3 = class_rc.e;
		} else if (var1 == (100 + class_rc.d.b())) {
			var3 = class_rc.d;
		} else {
			if (var1 != (100 + class_rc.c.b())) {
				return false;
			}

			var3 = class_rc.c;
		}

		if ((var2 != null) && !b(var3, var2) && (var3 != class_rc.f)) {
			return false;
		} else {
			this.a(var3, var2);
			return true;
		}
	}

	public static boolean b(class_rc var0, class_aco var1) {
		class_rc var2 = c(var1);
		return (var2 == var0) || ((var2 == class_rc.a) && (var0 == class_rc.b));
	}

	@Override
	public boolean bT() {
		return super.bT() && !cw();
	}

	public void k(boolean var1) {
		byte var2 = ((Byte) ac.a(a)).byteValue();
		ac.b(a, Byte.valueOf(var1 ? (byte) (var2 | 1) : (byte) (var2 & -2)));
	}

	public void l(boolean var1) {
		byte var2 = ((Byte) ac.a(a)).byteValue();
		ac.b(a, Byte.valueOf(var1 ? (byte) (var2 | 2) : (byte) (var2 & -3)));
	}

	public boolean cw() {
		return (((Byte) ac.a(a)).byteValue() & 1) != 0;
	}

	public boolean cx() {
		return (((Byte) ac.a(a)).byteValue() & 2) != 0;
	}

	static {
		a = DataWatcher.claimId(EntityInsentient.class, class_kb.a);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[class_rc.values().length];

		static {
			try {
				b[class_rc.f.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[class_rc.e.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[class_rc.d.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				b[class_rc.c.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			a = new int[class_rc.class_a_in_class_rc.values().length];

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

	public static enum class_a_in_class_rh {
		a,
		b,
		c;
	}
}
