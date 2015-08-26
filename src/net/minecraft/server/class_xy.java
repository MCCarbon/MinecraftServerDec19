package net.minecraft.server;

import java.util.Random;

public class class_xy extends class_re implements class_xx {
	private static final class_jz a;
	private int b = 1;

	public class_xy(class_ago var1) {
		super(var1);
		this.a(4.0F, 4.0F);
		ab = true;
		b_ = 5;
		f = new class_xy.class_b_in_class_xy(this);
		i.a(5, new class_xy.class_d_in_class_xy(this));
		i.a(7, new class_xy.class_a_in_class_xy(this));
		i.a(7, new class_xy.class_c_in_class_xy(this));
		bo.a(1, new class_ue(this));
	}

	public void a(boolean var1) {
		ac.b(a, Boolean.valueOf(var1));
	}

	public int cy() {
		return b;
	}

	@Override
	public void r_() {
		super.r_();
		if (!o.D && (o.ac() == class_ps.a)) {
			L();
		}

	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if ("fireball".equals(var1.p()) && (var1.j() instanceof class_yu)) {
			super.a(var1, 1000.0F);
			((class_yu) var1.j()).b(class_my.z);
			return true;
		} else {
			return super.a(var1, var2);
		}
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Boolean.valueOf(false));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(10.0D);
		this.a(class_yf.b).a(100.0D);
	}

	@Override
	protected String B() {
		return "mob.ghast.moan";
	}

	@Override
	protected String bv() {
		return "mob.ghast.scream";
	}

	@Override
	protected String bw() {
		return "mob.ghast.death";
	}

	@Override
	protected Item D() {
		return Items.J;
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(2) + V.nextInt(1 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.by, 1);
		}

		var3 = V.nextInt(3) + V.nextInt(1 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.J, 1);
		}

	}

	@Override
	protected float bI() {
		return 10.0F;
	}

	@Override
	public boolean cj() {
		return (V.nextInt(20) == 0) && super.cj() && (o.ac() != class_ps.a);
	}

	@Override
	public int cn() {
		return 1;
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("ExplosionPower", b);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.b("ExplosionPower", 99)) {
			b = var1.h("ExplosionPower");
		}

	}

	@Override
	public float aY() {
		return 2.6F;
	}

	static {
		a = class_kc.a(class_xy.class, class_kb.g);
	}

	static class class_c_in_class_xy extends class_sr {
		private class_xy b;
		public int a;

		public class_c_in_class_xy(class_xy var1) {
			b = var1;
		}

		@Override
		public boolean a() {
			return b.w() != null;
		}

		@Override
		public void c() {
			a = 0;
		}

		@Override
		public void d() {
			b.a(false);
		}

		@Override
		public void e() {
			class_rg var1 = b.w();
			double var2 = 64.0D;
			if ((var1.h(b) < (var2 * var2)) && b.t(var1)) {
				class_ago var4 = b.o;
				++a;
				if (a == 10) {
					var4.a((class_yu) null, 1007, new class_cj(b), 0);
				}

				if (a == 20) {
					double var5 = 4.0D;
					class_aym var7 = b.g(1.0F);
					double var8 = var1.s - (b.s + (var7.a * var5));
					double var10 = (var1.aX().b + var1.K / 2.0F) - (0.5D + b.t + b.K / 2.0F);
					double var12 = var1.u - (b.u + (var7.c * var5));
					var4.a((class_yu) null, 1008, new class_cj(b), 0);
					class_zc var14 = new class_zc(var4, b, var8, var10, var12);
					var14.a = b.cy();
					var14.s = b.s + (var7.a * var5);
					var14.t = b.t + b.K / 2.0F + 0.5D;
					var14.u = b.u + (var7.c * var5);
					var4.a(var14);
					a = -40;
				}
			} else if (a > 0) {
				--a;
			}

			b.a(a > 10);
		}
	}

	static class class_a_in_class_xy extends class_sr {
		private class_xy a;

		public class_a_in_class_xy(class_xy var1) {
			a = var1;
			this.a(2);
		}

		@Override
		public boolean a() {
			return true;
		}

		@Override
		public void e() {
			if (a.w() == null) {
				a.aM = a.y = (-((float) MathHelper.b(a.v, a.x)) * 180.0F) / 3.1415927F;
			} else {
				class_rg var1 = a.w();
				double var2 = 64.0D;
				if (var1.h(a) < (var2 * var2)) {
					double var4 = var1.s - a.s;
					double var6 = var1.u - a.u;
					a.aM = a.y = (-((float) MathHelper.b(var4, var6)) * 180.0F) / 3.1415927F;
				}
			}

		}
	}

	static class class_d_in_class_xy extends class_sr {
		private class_xy a;

		public class_d_in_class_xy(class_xy var1) {
			a = var1;
			this.a(1);
		}

		@Override
		public boolean a() {
			class_se var1 = a.r();
			if (!var1.a()) {
				return true;
			} else {
				double var2 = var1.d() - a.s;
				double var4 = var1.e() - a.t;
				double var6 = var1.f() - a.u;
				double var8 = (var2 * var2) + (var4 * var4) + (var6 * var6);
				return (var8 < 1.0D) || (var8 > 3600.0D);
			}
		}

		@Override
		public boolean b() {
			return false;
		}

		@Override
		public void c() {
			Random var1 = a.bj();
			double var2 = a.s + ((var1.nextFloat() * 2.0F) - 1.0F) * 16.0F;
			double var4 = a.t + ((var1.nextFloat() * 2.0F) - 1.0F) * 16.0F;
			double var6 = a.u + ((var1.nextFloat() * 2.0F) - 1.0F) * 16.0F;
			a.r().a(var2, var4, var6, 1.0D);
		}
	}

	static class class_b_in_class_xy extends class_se {
		private class_xy g;
		private int h;

		public class_b_in_class_xy(class_xy var1) {
			super(var1);
			g = var1;
		}

		@Override
		public void c() {
			if (f) {
				double var1 = b - g.s;
				double var3 = c - g.t;
				double var5 = d - g.u;
				double var7 = (var1 * var1) + (var3 * var3) + (var5 * var5);
				if (h-- <= 0) {
					h += g.bj().nextInt(5) + 2;
					var7 = MathHelper.a(var7);
					if (this.b(b, c, d, var7)) {
						g.v += (var1 / var7) * 0.1D;
						g.w += (var3 / var7) * 0.1D;
						g.x += (var5 / var7) * 0.1D;
					} else {
						f = false;
					}
				}

			}
		}

		private boolean b(double var1, double var3, double var5, double var7) {
			double var9 = (var1 - g.s) / var7;
			double var11 = (var3 - g.t) / var7;
			double var13 = (var5 - g.u) / var7;
			class_ayk var15 = g.aX();

			for (int var16 = 1; var16 < var7; ++var16) {
				var15 = var15.c(var9, var11, var13);
				if (!g.o.a(g, var15).isEmpty()) {
					return false;
				}
			}

			return true;
		}
	}
}
