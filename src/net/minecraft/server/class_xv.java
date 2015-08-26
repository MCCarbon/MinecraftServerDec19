package net.minecraft.server;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

public class class_xv extends class_yc {
	private static final UUID a = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final class_rr b;
	private static final Set c;
	private static final class_apn bt;
	private static final class_jz bu;
	private static final class_jz bv;
	private static final class_jz bw;
	private boolean bx;

	public class_xv(class_ago var1) {
		super(var1);
		this.a(0.6F, 2.9F);
		S = 1.0F;
		((class_ul) u()).a(true);
		i.a(0, new class_so(this));
		i.a(2, new class_sz(this, 1.0D, false));
		i.a(7, new class_tn(this, 1.0D));
		i.a(8, new class_sw(this, class_yu.class, 8.0F));
		i.a(8, new class_tm(this));
		i.a(10, new class_xv.class_a_in_class_xv(this));
		i.a(11, new class_xv.class_c_in_class_xv(this));
		bo.a(1, new class_uc(this, false, new Class[0]));
		bo.a(2, new class_xv.class_b_in_class_xv(this));
		bo.a(3, new class_uf(this, class_xw.class, 10, true, false, new Predicate() {
			public boolean a(class_xw var1) {
				return var1.n();
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((class_xw) var1);
			}
		}));
	}

	private boolean cL() {
		return cF() != bt;
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(40.0D);
		this.a(class_yf.d).a(0.30000001192092896D);
		this.a(class_yf.e).a(7.0D);
		this.a(class_yf.b).a(64.0D);
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bu, Integer.valueOf(0));
		ac.a(bv, Integer.valueOf(0));
		ac.a(bw, Boolean.valueOf(false));
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		class_apn var2 = cF();
		var1.a("carried", (short) Block.a(var2.c()));
		var1.a("carriedData", (short) var2.c().c(var2));
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		class_apn var2;
		if (var1.b("carried", 8)) {
			var2 = Block.b(var1.l("carried")).a(var1.g("carriedData") & '\uffff');
		} else {
			var2 = Block.c(var1.g("carried")).a(var1.g("carriedData") & '\uffff');
		}

		this.a(var2);
	}

	private boolean a(class_yu var1) {
		class_aco var2 = var1.bq.b[3];
		if ((var2 != null) && (var2.b() == Item.a(Blocks.PUMPKIN))) {
			return false;
		} else {
			class_aym var3 = var1.g(1.0F).a();
			class_aym var4 = new class_aym(s - var1.s, (aX().b + K / 2.0F) - (var1.t + var1.aY()), u - var1.u);
			double var5 = var4.b();
			var4 = var4.a();
			double var7 = var3.b(var4);
			return var7 > (1.0D - (0.025D / var5)) ? var1.t(this) : false;
		}
	}

	@Override
	public float aY() {
		return 2.55F;
	}

	@Override
	public void m() {
		if (o.D) {
			for (int var1 = 0; var1 < 2; ++var1) {
				o.a(class_cy.y, s + ((V.nextDouble() - 0.5D) * J), (t + (V.nextDouble() * K)) - 0.25D, u + ((V.nextDouble() - 0.5D) * J), (V.nextDouble() - 0.5D) * 2.0D, -V.nextDouble(), (V.nextDouble() - 0.5D) * 2.0D, new int[0]);
			}
		}

		bc = false;
		super.m();
	}

	@Override
	protected void cg() {
		if (X()) {
			this.a(class_qi.f, 1.0F);
		}

		if (cH() && !bx && (V.nextInt(100) == 0)) {
			this.a(false);
		}

		if (o.z()) {
			float var1 = this.f(1.0F);
			if ((var1 > 0.5F) && o.i(new class_cj(this)) && ((V.nextFloat() * 30.0F) < ((var1 - 0.4F) * 2.0F))) {
				this.c((class_rg) null);
				this.a(false);
				bx = false;
				this.n();
			}
		}

		super.cg();
	}

	protected boolean n() {
		double var1 = s + ((V.nextDouble() - 0.5D) * 64.0D);
		double var3 = t + (V.nextInt(64) - 32);
		double var5 = u + ((V.nextDouble() - 0.5D) * 64.0D);
		return a(this, var1, var3, var5);
	}

	protected boolean b(Entity var1) {
		class_aym var2 = new class_aym(s - var1.s, ((aX().b + K / 2.0F) - var1.t) + var1.aY(), u - var1.u);
		var2 = var2.a();
		double var3 = 16.0D;
		double var5 = (s + ((V.nextDouble() - 0.5D) * 8.0D)) - (var2.a * var3);
		double var7 = (t + (V.nextInt(16) - 8)) - (var2.b * var3);
		double var9 = (u + ((V.nextDouble() - 0.5D) * 8.0D)) - (var2.c * var3);
		return a(this, var5, var7, var9);
	}

	public static boolean a(class_rg var0, double var1, double var3, double var5) {
		double var7 = var0.s;
		double var9 = var0.t;
		double var11 = var0.u;
		var0.s = var1;
		var0.t = var3;
		var0.u = var5;
		boolean var13 = false;
		class_cj var14 = new class_cj(var0);
		class_ago var15 = var0.o;
		Random var16 = var0.bj();
		if (var15.e(var14)) {
			boolean var17 = false;

			while (!var17 && (var14.o() > 0)) {
				class_cj var18 = var14.b();
				Block var19 = var15.p(var18).c();
				if (var19.v().c()) {
					var17 = true;
				} else {
					--var0.t;
					var14 = var18;
				}
			}

			if (var17) {
				var0.a(var0.s, var0.t, var0.u);
				if (var15.a(var0, var0.aX()).isEmpty() && !var15.d(var0.aX())) {
					var13 = true;
				}
			}
		}

		if (!var13) {
			var0.a(var7, var9, var11);
			return false;
		} else {
			short var30 = 128;

			for (int var31 = 0; var31 < var30; ++var31) {
				double var32 = var31 / (var30 - 1.0D);
				float var21 = (var16.nextFloat() - 0.5F) * 0.2F;
				float var22 = (var16.nextFloat() - 0.5F) * 0.2F;
				float var23 = (var16.nextFloat() - 0.5F) * 0.2F;
				double var24 = var7 + ((var0.s - var7) * var32) + ((var16.nextDouble() - 0.5D) * var0.J * 2.0D);
				double var26 = var9 + ((var0.t - var9) * var32) + (var16.nextDouble() * var0.K);
				double var28 = var11 + ((var0.u - var11) * var32) + ((var16.nextDouble() - 0.5D) * var0.J * 2.0D);
				var15.a(class_cy.y, var24, var26, var28, var21, var22, var23, new int[0]);
			}

			var15.a(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
			var0.a("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	@Override
	protected String B() {
		return cH() ? "mob.endermen.scream" : "mob.endermen.idle";
	}

	@Override
	protected String bv() {
		return "mob.endermen.hit";
	}

	@Override
	protected String bw() {
		return "mob.endermen.death";
	}

	@Override
	protected Item D() {
		return Items.bw;
	}

	@Override
	protected void b(boolean var1, int var2) {
		Item var3 = D();
		if (var3 != null) {
			int var4 = V.nextInt(2 + var2);

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

		class_apn var6 = cF();
		if (var6 != bt) {
			this.a(new class_aco(var6.c(), 1, var6.c().c(var6)), 0.0F);
		}

	}

	public void a(class_apn var1) {
		ac.b(bu, Integer.valueOf(Block.f(var1) & '\uffff'));
	}

	public class_apn cF() {
		return Block.d(((Integer) ac.a(bu)).intValue() & '\uffff');
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if ((var1.j() == null) || !(var1.j() instanceof class_xw)) {
				if (!o.D) {
					this.a(true);
				}

				if ((var1 instanceof class_qj) && (var1.j() instanceof class_yu)) {
					if ((var1.j() instanceof class_lm) && ((class_lm) var1.j()).c.d()) {
						this.a(false);
					} else {
						bx = true;
					}
				}

				if (var1 instanceof class_qk) {
					bx = false;

					for (int var4 = 0; var4 < 64; ++var4) {
						if (this.n()) {
							return true;
						}
					}

					return false;
				}
			}

			boolean var3 = super.a(var1, var2);
			if (var1.e() && (V.nextInt(10) != 0)) {
				this.n();
			}

			return var3;
		}
	}

	public boolean cH() {
		return ((Boolean) ac.a(bw)).booleanValue();
	}

	public void a(boolean var1) {
		ac.b(bw, Boolean.valueOf(var1));
	}

	static {
		b = (new class_rr(a, "Attacking speed boost", 0.15000000596046448D, 0)).a(false);
		c = Sets.newIdentityHashSet();
		bt = Blocks.AIR.S();
		c.add(Blocks.GRASS);
		c.add(Blocks.DIRT);
		c.add(Blocks.SAND);
		c.add(Blocks.GRAVEL);
		c.add(Blocks.YELLOW_FLOWER);
		c.add(Blocks.RED_FLOWER);
		c.add(Blocks.BROWN_MUSHROOM);
		c.add(Blocks.RED_MUSHROOM);
		c.add(Blocks.TNT);
		c.add(Blocks.CACTUS);
		c.add(Blocks.CLAY);
		c.add(Blocks.PUMPKIN);
		c.add(Blocks.MELON_BLOCK);
		c.add(Blocks.MYCELIUM);
		bu = class_kc.a(class_xv.class, class_kb.b);
		bv = class_kc.a(class_xv.class, class_kb.b);
		bw = class_kc.a(class_xv.class, class_kb.g);
	}

	static class class_c_in_class_xv extends class_sr {
		private class_xv a;

		public class_c_in_class_xv(class_xv var1) {
			a = var1;
		}

		@Override
		public boolean a() {
			return a.cL() ? false : (!a.o.S().b("mobGriefing") ? false : a.bj().nextInt(20) == 0);
		}

		@Override
		public void e() {
			Random var1 = a.bj();
			class_ago var2 = a.o;
			int var3 = class_oa.c((a.s - 2.0D) + (var1.nextDouble() * 4.0D));
			int var4 = class_oa.c(a.t + (var1.nextDouble() * 3.0D));
			int var5 = class_oa.c((a.u - 2.0D) + (var1.nextDouble() * 4.0D));
			class_cj var6 = new class_cj(var3, var4, var5);
			class_apn var7 = var2.p(var6);
			Block var8 = var7.c();
			if (class_xv.c.contains(var8)) {
				a.a(var7);
				var2.a(var6, class_xv.bt);
			}

		}
	}

	static class class_a_in_class_xv extends class_sr {
		private class_xv a;

		public class_a_in_class_xv(class_xv var1) {
			a = var1;
		}

		@Override
		public boolean a() {
			return !a.cL() ? false : (!a.o.S().b("mobGriefing") ? false : a.bj().nextInt(2000) == 0);
		}

		@Override
		public void e() {
			Random var1 = a.bj();
			class_ago var2 = a.o;
			int var3 = class_oa.c((a.s - 1.0D) + (var1.nextDouble() * 2.0D));
			int var4 = class_oa.c(a.t + (var1.nextDouble() * 2.0D));
			int var5 = class_oa.c((a.u - 1.0D) + (var1.nextDouble() * 2.0D));
			class_cj var6 = new class_cj(var3, var4, var5);
			Block var7 = var2.p(var6).c();
			Block var8 = var2.p(var6.b()).c();
			if (this.a(var2, var6, a.cF().c(), var7, var8)) {
				var2.a(var6, a.cF(), 3);
				a.a(class_xv.bt);
			}

		}

		private boolean a(class_ago var1, class_cj var2, Block var3, Block var4, Block var5) {
			return !var3.c(var1, var2) ? false : (var4.v() != class_avq.a ? false : (var5.v() == class_avq.a ? false : var5.d()));
		}
	}

	static class class_b_in_class_xv extends class_uf {
		private class_yu g;
		private int h;
		private int i;
		private class_xv j;

		public class_b_in_class_xv(class_xv var1) {
			super(var1, class_yu.class, true);
			j = var1;
		}

		@Override
		public boolean a() {
			double var1 = this.f();
			List var3 = e.o.a(class_yu.class, e.aX().b(var1, 4.0D, var1), c);
			Collections.sort(var3, b);
			if (var3.isEmpty()) {
				return false;
			} else {
				g = (class_yu) var3.get(0);
				return true;
			}
		}

		@Override
		public void c() {
			h = 5;
			i = 0;
		}

		@Override
		public void d() {
			g = null;
			j.a(false);
			class_rq var1 = j.a(class_yf.d);
			var1.c(class_xv.b);
			super.d();
		}

		@Override
		public boolean b() {
			if (g != null) {
				if (!j.a(g)) {
					return false;
				} else {
					j.bx = true;
					j.a(g, 10.0F, 10.0F);
					return true;
				}
			} else {
				return super.b();
			}
		}

		@Override
		public void e() {
			if (g != null) {
				if (--h <= 0) {
					d = g;
					g = null;
					super.c();
					j.a("mob.endermen.stare", 1.0F, 1.0F);
					j.a(true);
					class_rq var1 = j.a(class_yf.d);
					var1.b(class_xv.b);
				}
			} else {
				if (d != null) {
					if ((d instanceof class_yu) && j.a((class_yu) d)) {
						if (d.h(j) < 16.0D) {
							j.n();
						}

						i = 0;
					} else if ((d.h(j) > 256.0D) && (i++ >= 30) && j.b((Entity) d)) {
						i = 0;
					}
				}

				super.e();
			}

		}
	}
}
