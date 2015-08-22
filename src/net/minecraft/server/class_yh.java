package net.minecraft.server;

import java.util.Calendar;

public class class_yh extends class_yc implements class_ye {
	private static final class_jz a;
	private static final class_jz b;
	private class_tp c = new class_tp(this, 1.0D, 20, 60, 15.0F);
	private class_sz bt = new class_sz(this, class_yu.class, 1.2D, false) {
		@Override
		public void d() {
			super.d();
			class_yh.this.a(false);
		}

		@Override
		public void c() {
			super.c();
			class_yh.this.a(true);
		}
	};

	public class_yh(class_ago var1) {
		super(var1);
		i.a(1, new class_so(this));
		i.a(2, new class_tr(this));
		i.a(3, new class_sn(this, 1.0D));
		i.a(3, new class_sg(this, class_vr.class, 6.0F, 1.0D, 1.2D));
		i.a(4, new class_tn(this, 1.0D));
		i.a(6, new class_sw(this, class_yu.class, 8.0F));
		i.a(6, new class_tm(this));
		bo.a(1, new class_uc(this, false, new Class[0]));
		bo.a(2, new class_uf(this, class_yu.class, true));
		bo.a(3, new class_uf(this, class_vp.class, true));
		if ((var1 != null) && !var1.D) {
			this.n();
		}

	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.d).a(0.25D);
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Integer.valueOf(0));
		ac.a(b, Boolean.valueOf(false));
	}

	@Override
	protected String B() {
		return "mob.skeleton.say";
	}

	@Override
	protected String bv() {
		return "mob.skeleton.hurt";
	}

	@Override
	protected String bw() {
		return "mob.skeleton.death";
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.skeleton.step", 0.15F, 1.0F);
	}

	@Override
	public boolean r(Entity var1) {
		if (super.r(var1)) {
			if ((cF() == 1) && (var1 instanceof class_rg)) {
				((class_rg) var1).c(new class_qr(class_qs.t, 200));
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public class_rl bF() {
		return class_rl.b;
	}

	@Override
	public void m() {
		if (o.z() && !o.D) {
			float var1 = this.f(1.0F);
			class_cj var2 = new class_cj(s, Math.round(t), u);
			if ((var1 > 0.5F) && ((V.nextFloat() * 30.0F) < ((var1 - 0.4F) * 2.0F)) && o.i(var2)) {
				boolean var3 = true;
				class_aco var4 = this.a(class_rc.f);
				if (var4 != null) {
					if (var4.e()) {
						var4.b(var4.h() + V.nextInt(2));
						if (var4.h() >= var4.j()) {
							this.b(var4);
							this.a(class_rc.f, (class_aco) null);
						}
					}

					var3 = false;
				}

				if (var3) {
					this.e(8);
				}
			}
		}

		if (o.D && (cF() == 1)) {
			this.a(0.72F, 2.535F);
		}

		super.m();
	}

	@Override
	public void an() {
		super.an();
		if (m instanceof class_rn) {
			class_rn var1 = (class_rn) m;
			aM = var1.aM;
		}

	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if ((var1.i() instanceof class_yx) && (var1.j() instanceof class_yu)) {
			class_yu var2 = (class_yu) var1.j();
			double var3 = var2.s - s;
			double var5 = var2.u - u;
			if (((var3 * var3) + (var5 * var5)) >= 2500.0D) {
				var2.b(class_my.v);
			}
		} else if ((var1.j() instanceof class_xu) && ((class_xu) var1.j()).n() && ((class_xu) var1.j()).cI()) {
			((class_xu) var1.j()).cJ();
			this.a(new class_aco(Items.cc, 1, cF() == 1 ? 1 : 0), 0.0F);
		}

	}

	@Override
	protected Item D() {
		return Items.g;
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3;
		int var4;
		if (cF() == 1) {
			var3 = V.nextInt(3 + var2) - 1;

			for (var4 = 0; var4 < var3; ++var4) {
				this.a(Items.j, 1);
			}
		} else {
			var3 = V.nextInt(3 + var2);

			for (var4 = 0; var4 < var3; ++var4) {
				this.a(Items.g, 1);
			}
		}

		var3 = V.nextInt(3 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.aZ, 1);
		}

	}

	@Override
	protected void bx() {
		if (cF() == 1) {
			this.a(new class_aco(Items.cc, 1, 1), 0.0F);
		}

	}

	@Override
	protected void a(class_pt var1) {
		super.a(var1);
		this.a(class_rc.a, new class_aco(Items.f));
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		var2 = super.a(var1, var2);
		if ((o.t instanceof class_are) && (bj().nextInt(5) > 0)) {
			i.a(4, bt);
			this.a(1);
			this.a(class_rc.a, new class_aco(Items.s));
			this.a(class_yf.e).a(4.0D);
		} else {
			i.a(4, c);
			this.a(var1);
			this.b(var1);
		}

		this.j(V.nextFloat() < (0.55F * var1.c()));
		if (this.a(class_rc.f) == null) {
			Calendar var3 = o.aa();
			if (((var3.get(2) + 1) == 10) && (var3.get(5) == 31) && (V.nextFloat() < 0.25F)) {
				this.a(class_rc.f, new class_aco(V.nextFloat() < 0.1F ? Blocks.aZ : Blocks.aU));
				bq[class_rc.f.b()] = 0.0F;
			}
		}

		return var2;
	}

	public void n() {
		i.a(bt);
		i.a(c);
		class_aco var1 = bG();
		if ((var1 != null) && (var1.b() == Items.f)) {
			i.a(4, c);
		} else {
			i.a(4, bt);
		}

	}

	@Override
	public void a(class_rg var1, float var2) {
		class_yx var3 = new class_yx(o, this);
		double var4 = var1.s - s;
		double var6 = (var1.aX().b + var1.K / 3.0F) - var3.t;
		double var8 = var1.u - u;
		double var10 = class_oa.a((var4 * var4) + (var8 * var8));
		var3.c(var4, var6 + (var10 * 0.20000000298023224D), var8, 1.6F, 14 - (o.ac().a() * 4));
		int var12 = class_afl.a(class_afn.t, this);
		int var13 = class_afl.a(class_afn.u, this);
		var3.b(var2 * 2.0F + (V.nextGaussian() * 0.25D) + o.ac().a() * 0.11F);
		if (var12 > 0) {
			var3.b(var3.j() + (var12 * 0.5D) + 0.5D);
		}

		if (var13 > 0) {
			var3.a(var13);
		}

		if ((class_afl.a(class_afn.v, this) > 0) || (cF() == 1)) {
			var3.e(100);
		}

		this.a("random.bow", 1.0F, 1.0F / ((bj().nextFloat() * 0.4F) + 0.8F));
		o.a(var3);
	}

	public int cF() {
		return ((Integer) ac.a(a)).intValue();
	}

	public void a(int var1) {
		ac.b(a, Integer.valueOf(var1));
		ab = var1 == 1;
		if (var1 == 1) {
			this.a(0.72F, 2.535F);
		} else {
			this.a(0.6F, 1.95F);
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("SkeletonType", 99)) {
			byte var2 = var1.f("SkeletonType");
			this.a(var2);
		}

		this.n();
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("SkeletonType", (byte) cF());
	}

	@Override
	public void a(class_rc var1, class_aco var2) {
		super.a(var1, var2);
		if (!o.D && (var1 == class_rc.a)) {
			this.n();
		}

	}

	@Override
	public float aY() {
		return cF() == 1 ? super.aY() : 1.74F;
	}

	@Override
	public double ap() {
		return i_() ? 0.0D : -0.35D;
	}

	public void a(boolean var1) {
		ac.b(b, Boolean.valueOf(var1));
	}

	static {
		a = class_kc.a(class_yh.class, class_kb.b);
		b = class_kc.a(class_yh.class, class_kb.g);
	}
}
