package net.minecraft.server;


public class class_yi extends class_rh implements class_xx {
	private static final class_jz br;
	public float a;
	public float b;
	public float c;
	private boolean bs;

	public class_yi(class_ago var1) {
		super(var1);
		f = new class_yi.class_d_in_class_yi(this);
		i.a(1, new class_yi.class_b_in_class_yi(this));
		i.a(2, new class_yi.class_a_in_class_yi(this));
		i.a(3, new class_yi.class_e_in_class_yi(this));
		i.a(5, new class_yi.class_c_in_class_yi(this));
		bo.a(1, new class_ue(this));
		bo.a(3, new class_ud(this, class_vp.class));
	}

	@Override
	protected void h() {
		super.h();
		ac.a(br, Integer.valueOf(1));
	}

	protected void a(int var1) {
		ac.b(br, Integer.valueOf(var1));
		this.a(0.51000005F * var1, 0.51000005F * var1);
		this.b(s, t, u);
		this.a(class_yf.a).a((double) (var1 * var1));
		this.a(class_yf.d).a(0.2F + (0.1F * var1));
		this.c(bB());
		b_ = var1;
	}

	public int cF() {
		return ((Integer) ac.a(br)).intValue();
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Size", cF() - 1);
		var1.a("wasOnGround", bs);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		int var2 = var1.h("Size");
		if (var2 < 0) {
			var2 = 0;
		}

		this.a(var2 + 1);
		bs = var1.p("wasOnGround");
	}

	protected class_cy n() {
		return class_cy.H;
	}

	protected String cD() {
		return "mob.slime." + (cF() > 1 ? "big" : "small");
	}

	@Override
	public void r_() {
		if (!o.D && (o.ac() == class_ps.a) && (cF() > 0)) {
			I = true;
		}

		b += (a - b) * 0.5F;
		c = b;
		super.r_();
		if (C && !bs) {
			int var1 = cF();

			for (int var2 = 0; var2 < (var1 * 8); ++var2) {
				float var3 = V.nextFloat() * 3.1415927F * 2.0F;
				float var4 = (V.nextFloat() * 0.5F) + 0.5F;
				float var5 = class_oa.a(var3) * var1 * 0.5F * var4;
				float var6 = class_oa.b(var3) * var1 * 0.5F * var4;
				class_ago var10000 = o;
				class_cy var10001 = this.n();
				double var10002 = s + var5;
				double var10004 = u + var6;
				var10000.a(var10001, var10002, aX().b, var10004, 0.0D, 0.0D, 0.0D, new int[0]);
			}

			if (cE()) {
				this.a(cD(), bI(), (((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F) / 0.8F);
			}

			a = -0.5F;
		} else if (!C && bs) {
			a = 1.0F;
		}

		bs = C;
		cA();
	}

	protected void cA() {
		a *= 0.6F;
	}

	protected int cz() {
		return V.nextInt(20) + 10;
	}

	protected class_yi cy() {
		return new class_yi(o);
	}

	@Override
	public void a(class_jz var1) {
		if (var1 == br) {
			int var2 = cF();
			this.a(0.51000005F * var2, 0.51000005F * var2);
			y = aO;
			aM = aO;
			if (Y() && (V.nextInt(20) == 0)) {
				aa();
			}
		}

		super.a(var1);
	}

	@Override
	public void L() {
		int var1 = cF();
		if (!o.D && (var1 > 1) && (bu() <= 0.0F)) {
			int var2 = 2 + V.nextInt(3);

			for (int var3 = 0; var3 < var2; ++var3) {
				float var4 = ((var3 % 2 - 0.5F) * var1) / 4.0F;
				float var5 = ((var3 / 2 - 0.5F) * var1) / 4.0F;
				class_yi var6 = cy();
				if (k_()) {
					var6.c(aS());
				}

				if (cr()) {
					var6.cp();
				}

				var6.a(var1 / 2);
				var6.b(s + var4, t + 0.5D, u + var5, V.nextFloat() * 360.0F, 0.0F);
				o.a(var6);
			}
		}

		super.L();
	}

	@Override
	public void i(Entity var1) {
		super.i(var1);
		if ((var1 instanceof class_vp) && cB()) {
			this.d((class_rg) var1);
		}

	}

	@Override
	public void d(class_yu var1) {
		if (cB()) {
			this.d((class_rg) var1);
		}

	}

	protected void d(class_rg var1) {
		int var2 = cF();
		if (this.t(var1) && (this.h(var1) < (0.6D * var2 * 0.6D * var2)) && var1.a(class_qi.a(this), cC())) {
			this.a("mob.attack", 1.0F, ((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F);
			this.a(this, var1);
		}

	}

	@Override
	public float aY() {
		return 0.625F * K;
	}

	protected boolean cB() {
		return cF() > 1;
	}

	protected int cC() {
		return cF();
	}

	@Override
	protected String bv() {
		return "mob.slime." + (cF() > 1 ? "big" : "small");
	}

	@Override
	protected String bw() {
		return "mob.slime." + (cF() > 1 ? "big" : "small");
	}

	@Override
	protected Item D() {
		return cF() == 1 ? Items.aO : null;
	}

	@Override
	public boolean cj() {
		class_cj var1 = new class_cj(class_oa.c(s), 0, class_oa.c(u));
		class_aqn var2 = o.f(var1);
		if ((o.R().t() == class_agt.c) && (V.nextInt(4) != 1)) {
			return false;
		} else {
			if (o.ac() != class_ps.a) {
				class_ahb var3 = o.b(var1);
				if ((var3 == class_ahb.v) && (t > 50.0D) && (t < 70.0D) && (V.nextFloat() < 0.5F) && (V.nextFloat() < o.B()) && (o.l(new class_cj(this)) <= V.nextInt(8))) {
					return super.cj();
				}

				if ((V.nextInt(10) == 0) && (var2.a(987234911L).nextInt(10) == 0) && (t < 40.0D)) {
					return super.cj();
				}
			}

			return false;
		}
	}

	@Override
	protected float bI() {
		return 0.4F * cF();
	}

	@Override
	public int ch() {
		return 0;
	}

	protected boolean cG() {
		return cF() > 0;
	}

	protected boolean cE() {
		return cF() > 2;
	}

	@Override
	protected void bM() {
		w = 0.41999998688697815D;
		ai = true;
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		int var3 = V.nextInt(3);
		if ((var3 < 2) && (V.nextFloat() < (0.5F * var1.c()))) {
			++var3;
		}

		int var4 = 1 << var3;
		this.a(var4);
		return super.a(var1, var2);
	}

	static {
		br = class_kc.a(class_yi.class, class_kb.b);
	}

	static class class_c_in_class_yi extends class_sr {
		private class_yi a;

		public class_c_in_class_yi(class_yi var1) {
			a = var1;
			this.a(5);
		}

		@Override
		public boolean a() {
			return true;
		}

		@Override
		public void e() {
			((class_yi.class_d_in_class_yi) a.r()).a(1.0D);
		}
	}

	static class class_b_in_class_yi extends class_sr {
		private class_yi a;

		public class_b_in_class_yi(class_yi var1) {
			a = var1;
			this.a(5);
			((class_ul) var1.u()).d(true);
		}

		@Override
		public boolean a() {
			return a.Y() || a.ae();
		}

		@Override
		public void e() {
			if (a.bj().nextFloat() < 0.8F) {
				a.s().a();
			}

			((class_yi.class_d_in_class_yi) a.r()).a(1.2D);
		}
	}

	static class class_e_in_class_yi extends class_sr {
		private class_yi a;
		private float b;
		private int c;

		public class_e_in_class_yi(class_yi var1) {
			a = var1;
			this.a(2);
		}

		@Override
		public boolean a() {
			return (a.w() == null) && (a.C || a.Y() || a.ae());
		}

		@Override
		public void e() {
			if (--c <= 0) {
				c = 40 + a.bj().nextInt(60);
				b = a.bj().nextInt(360);
			}

			((class_yi.class_d_in_class_yi) a.r()).a(b, false);
		}
	}

	static class class_a_in_class_yi extends class_sr {
		private class_yi a;
		private int b;

		public class_a_in_class_yi(class_yi var1) {
			a = var1;
			this.a(2);
		}

		@Override
		public boolean a() {
			class_rg var1 = a.w();
			return var1 == null ? false : (!var1.al() ? false : !(var1 instanceof class_yu) || !((class_yu) var1).bI.a);
		}

		@Override
		public void c() {
			b = 300;
			super.c();
		}

		@Override
		public boolean b() {
			class_rg var1 = a.w();
			return var1 == null ? false : (!var1.al() ? false : ((var1 instanceof class_yu) && ((class_yu) var1).bI.a ? false : --b > 0));
		}

		@Override
		public void e() {
			a.a(a.w(), 10.0F, 10.0F);
			((class_yi.class_d_in_class_yi) a.r()).a(a.y, a.cB());
		}
	}

	static class class_d_in_class_yi extends class_se {
		private float g;
		private int h;
		private class_yi i;
		private boolean j;

		public class_d_in_class_yi(class_yi var1) {
			super(var1);
			i = var1;
		}

		public void a(float var1, boolean var2) {
			g = var1;
			j = var2;
		}

		public void a(double var1) {
			e = var1;
			f = true;
		}

		@Override
		public void c() {
			a.y = this.a(a.y, g, 30.0F);
			a.aO = a.y;
			a.aM = a.y;
			if (!f) {
				a.o(0.0F);
			} else {
				f = false;
				if (a.C) {
					a.l((float) (e * a.a(class_yf.d).e()));
					if (h-- <= 0) {
						h = i.cz();
						if (j) {
							h /= 3;
						}

						i.s().a();
						if (i.cG()) {
							i.a(i.cD(), i.bI(), (((i.bj().nextFloat() - i.bj().nextFloat()) * 0.2F) + 1.0F) * 0.8F);
						}
					} else {
						i.bd = i.be = 0.0F;
						a.l(0.0F);
					}
				} else {
					a.l((float) (e * a.a(class_yf.d).e()));
				}

			}
		}
	}
}
