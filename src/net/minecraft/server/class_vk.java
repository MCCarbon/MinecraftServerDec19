package net.minecraft.server;


public class class_vk extends class_vc {
	private static final class_jz bt;
	private class_vk.class_c_in_class_vk bu;
	private int bv = 0;
	private int bx = 0;
	private boolean by = false;
	private boolean bz = false;
	private int bA = 0;
	private class_vk.class_b_in_class_vk bB;
	private int bC;
	private class_yu bD;

	public class_vk(class_ago var1) {
		super(var1);
		bB = class_vk.class_b_in_class_vk.b;
		bC = 0;
		bD = null;
		this.a(0.6F, 0.7F);
		g = new class_vk.class_e_in_class_vk(this);
		f = new class_vk.class_f_in_class_vk(this);
		((class_ul) u()).a(true);
		h.a(2.5F);
		i.a(1, new class_so(this));
		i.a(1, new class_vk.class_g_in_class_vk(this, 1.33D));
		i.a(2, new class_tw(this, 1.0D, Items.bW, false));
		i.a(2, new class_tw(this, 1.0D, Items.cb, false));
		i.a(2, new class_tw(this, 1.0D, Item.a(Blocks.YELLOW_FLOWER), false));
		i.a(3, new class_sj(this, 0.8D));
		i.a(5, new class_vk.class_h_in_class_vk(this));
		i.a(5, new class_tn(this, 0.6D));
		i.a(11, new class_sw(this, class_yu.class, 10.0F));
		bu = new class_vk.class_c_in_class_vk(this, class_vr.class, 16.0F, 1.33D, 1.33D);
		i.a(4, bu);
		this.b(0.0D);
	}

	@Override
	protected float bL() {
		return f.a() && (f.e() > (t + 0.5D)) ? 0.5F : bB.b();
	}

	public void a(class_vk.class_b_in_class_vk var1) {
		bB = var1;
	}

	public void b(double var1) {
		u().a(var1);
		f.a(f.d(), f.e(), f.f(), var1);
	}

	public void a(boolean var1, class_vk.class_b_in_class_vk var2) {
		super.i(var1);
		if (!var1) {
			if (bB == class_vk.class_b_in_class_vk.e) {
				bB = class_vk.class_b_in_class_vk.b;
			}
		} else {
			this.b(1.5D * var2.a());
			this.a(cF(), bI(), (((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F) * 0.8F);
		}

		by = var1;
	}

	public void b(class_vk.class_b_in_class_vk var1) {
		this.a(true, var1);
		bx = var1.d();
		bv = 0;
	}

	public boolean cE() {
		return by;
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bt, Integer.valueOf(0));
	}

	@Override
	public void cg() {
		if (f.b() > 0.8D) {
			this.a(class_vk.class_b_in_class_vk.d);
		} else if (bB != class_vk.class_b_in_class_vk.e) {
			this.a(class_vk.class_b_in_class_vk.b);
		}

		if (bA > 0) {
			--bA;
		}

		if (bC > 0) {
			bC -= V.nextInt(3);
			if (bC < 0) {
				bC = 0;
			}
		}

		if (C) {
			if (!bz) {
				this.a(false, class_vk.class_b_in_class_vk.a);
				cP();
			}

			if ((cG() == 99) && (bA == 0)) {
				class_rg var1 = w();
				if ((var1 != null) && (this.h(var1) < 16.0D)) {
					this.a(var1.s, var1.u);
					f.a(var1.s, var1.t, var1.u, f.b());
					this.b(class_vk.class_b_in_class_vk.e);
					bz = true;
				}
			}

			class_vk.class_e_in_class_vk var4 = (class_vk.class_e_in_class_vk) g;
			if (!var4.c()) {
				if (f.a() && (bA == 0)) {
					class_axc var2 = h.j();
					class_aym var3 = new class_aym(f.d(), f.e(), f.f());
					if ((var2 != null) && (var2.e() < var2.d())) {
						var3 = var2.a(this);
					}

					this.a(var3.a, var3.c);
					this.b(bB);
				}
			} else if (!var4.d()) {
				cM();
			}
		}

		bz = C;
	}

	@Override
	public void ab() {
	}

	private void a(double var1, double var3) {
		y = (float) ((class_oa.b(var3 - u, var1 - s) * 180.0D) / 3.1415927410125732D) - 90.0F;
	}

	private void cM() {
		((class_vk.class_e_in_class_vk) g).a(true);
	}

	private void cN() {
		((class_vk.class_e_in_class_vk) g).a(false);
	}

	private void cO() {
		bA = cH();
	}

	private void cP() {
		cO();
		cN();
	}

	@Override
	public void m() {
		super.m();
		if (bv != bx) {
			if ((bv == 0) && !o.D) {
				o.a(this, (byte) 1);
			}

			++bv;
		} else if (bx != 0) {
			bv = 0;
			bx = 0;
		}

	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(10.0D);
		this.a(class_yf.d).a(0.30000001192092896D);
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("RabbitType", cG());
		var1.a("MoreCarrotTicks", bC);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.k(var1.h("RabbitType"));
		bC = var1.h("MoreCarrotTicks");
	}

	protected String cF() {
		return "mob.rabbit.hop";
	}

	@Override
	protected String B() {
		return "mob.rabbit.idle";
	}

	@Override
	protected String bv() {
		return "mob.rabbit.hurt";
	}

	@Override
	protected String bw() {
		return "mob.rabbit.death";
	}

	@Override
	public boolean r(Entity var1) {
		if (cG() == 99) {
			this.a("mob.attack", 1.0F, ((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F);
			return var1.a(class_qi.a(this), 8.0F);
		} else {
			return var1.a(class_qi.a(this), 3.0F);
		}
	}

	@Override
	public int by() {
		return cG() == 99 ? 8 : super.by();
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		return this.b(var1) ? false : super.a(var1, var2);
	}

	@Override
	protected void bx() {
		this.a(new class_aco(Items.bt, 1), 0.0F);
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(2) + V.nextInt(1 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.bu, 1);
		}

		var3 = V.nextInt(2);

		for (var4 = 0; var4 < var3; ++var4) {
			if (ay()) {
				this.a(Items.br, 1);
			} else {
				this.a(Items.bq, 1);
			}
		}

	}

	private boolean a(Item var1) {
		return (var1 == Items.bW) || (var1 == Items.cb) || (var1 == Item.a(Blocks.YELLOW_FLOWER));
	}

	public class_vk b(class_qu var1) {
		class_vk var2 = new class_vk(o);
		if (var1 instanceof class_vk) {
			var2.k(V.nextBoolean() ? cG() : ((class_vk) var1).cG());
		}

		return var2;
	}

	@Override
	public boolean d(class_aco var1) {
		return (var1 != null) && this.a(var1.b());
	}

	public int cG() {
		return ((Integer) ac.a(bt)).intValue();
	}

	public void k(int var1) {
		if (var1 == 99) {
			i.a(bu);
			i.a(4, new class_vk.class_a_in_class_vk(this));
			bo.a(1, new class_uc(this, false, new Class[0]));
			bo.a(2, new class_uf(this, class_yu.class, true));
			bo.a(2, new class_uf(this, class_vr.class, true));
			if (!k_()) {
				this.c(class_di.a("entity.KillerBunny.name"));
			}
		}

		ac.b(bt, Integer.valueOf(var1));
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		Object var5 = super.a(var1, var2);
		int var3 = V.nextInt(6);
		boolean var4 = false;
		if (var5 instanceof class_vk.class_d_in_class_vk) {
			var3 = ((class_vk.class_d_in_class_vk) var5).a;
			var4 = true;
		} else {
			var5 = new class_vk.class_d_in_class_vk(var3);
		}

		this.k(var3);
		if (var4) {
			this.b(-24000);
		}

		return (class_rj) var5;
	}

	private boolean cQ() {
		return bC == 0;
	}

	protected int cH() {
		return bB.c();
	}

	protected void cI() {
		class_aiu var1 = (class_aiu) Blocks.CARROTS;
		class_apn var2 = var1.b(var1.n());
		o.a(class_cy.M, (s + V.nextFloat() * J * 2.0F) - J, t + 0.5D + V.nextFloat() * K, (u + V.nextFloat() * J * 2.0F) - J, 0.0D, 0.0D, 0.0D, new int[] { Block.f(var2) });
		bC = 100;
	}

	// $FF: synthetic method
	@Override
	public class_qu a(class_qu var1) {
		return this.b(var1);
	}

	static {
		bt = class_kc.a(class_vk.class, class_kb.b);
	}

	static enum class_b_in_class_vk {
		a(0.0F, 0.0F, 30, 1),
		b(0.8F, 0.2F, 20, 10),
		c(1.0F, 0.45F, 14, 14),
		d(1.75F, 0.4F, 1, 8),
		e(2.0F, 0.7F, 7, 8);

		private final float f;
		private final float g;
		private final int h;
		private final int i;

		private class_b_in_class_vk(float var3, float var4, int var5, int var6) {
			f = var3;
			g = var4;
			h = var5;
			i = var6;
		}

		public float a() {
			return f;
		}

		public float b() {
			return g;
		}

		public int c() {
			return h;
		}

		public int d() {
			return i;
		}
	}

	static class class_a_in_class_vk extends class_sz {
		public class_a_in_class_vk(class_vk var1) {
			super(var1, class_rg.class, 1.4D, true);
		}

		@Override
		protected double a(class_rg var1) {
			return 4.0F + var1.J;
		}
	}

	static class class_g_in_class_vk extends class_tj {
		private class_vk b;

		public class_g_in_class_vk(class_vk var1, double var2) {
			super(var1, var2);
			b = var1;
		}

		@Override
		public void e() {
			super.e();
			b.b(a);
		}
	}

	static class class_h_in_class_vk extends class_tc {
		private final class_vk c;
		private boolean d;
		private boolean e = false;

		public class_h_in_class_vk(class_vk var1) {
			super(var1, 0.699999988079071D, 16);
			c = var1;
		}

		@Override
		public boolean a() {
			if (a <= 0) {
				if (!c.o.S().b("mobGriefing")) {
					return false;
				}

				e = false;
				d = c.cQ();
			}

			return super.a();
		}

		@Override
		public boolean b() {
			return e && super.b();
		}

		@Override
		public void c() {
			super.c();
		}

		@Override
		public void d() {
			super.d();
		}

		@Override
		public void e() {
			super.e();
			c.q().a(b.n() + 0.5D, b.o() + 1, b.p() + 0.5D, 10.0F, c.ch());
			if (this.f()) {
				class_ago var1 = c.o;
				class_cj var2 = b.a();
				class_apn var3 = var1.p(var2);
				Block var4 = var3.c();
				if (e && (var4 instanceof class_aiu) && ((class_aiu) var4).e(var3)) {
					var1.a(var2, Blocks.AIR.S(), 2);
					var1.b(var2, true);
					c.cI();
				}

				e = false;
				a = 10;
			}

		}

		@Override
		protected boolean a(class_ago var1, class_cj var2) {
			Block var3 = var1.p(var2).c();
			if (var3 == Blocks.FARMLAND) {
				var2 = var2.a();
				class_apn var4 = var1.p(var2);
				var3 = var4.c();
				if ((var3 instanceof class_aiu) && ((class_aiu) var3).e(var4) && d && !e) {
					e = true;
					return true;
				}
			}

			return false;
		}
	}

	static class class_c_in_class_vk extends class_sg {
		private class_vk c;

		public class_c_in_class_vk(class_vk var1, Class var2, float var3, double var4, double var6) {
			super(var1, var2, var3, var4, var6);
			c = var1;
		}

		@Override
		public void e() {
			super.e();
		}
	}

	static class class_f_in_class_vk extends class_se {
		private class_vk g;

		public class_f_in_class_vk(class_vk var1) {
			super(var1);
			g = var1;
		}

		@Override
		public void c() {
			if (g.C && !g.cE()) {
				g.b(0.0D);
			}

			super.c();
		}
	}

	public class class_e_in_class_vk extends class_sc {
		private class_vk c;
		private boolean d = false;

		public class_e_in_class_vk(class_vk var2) {
			super(var2);
			c = var2;
		}

		public boolean c() {
			return a;
		}

		public boolean d() {
			return d;
		}

		public void a(boolean var1) {
			d = var1;
		}

		@Override
		public void b() {
			if (a) {
				c.b(class_vk.class_b_in_class_vk.c);
				a = false;
			}

		}
	}

	public static class class_d_in_class_vk implements class_rj {
		public int a;

		public class_d_in_class_vk(int var1) {
			a = var1;
		}
	}
}
