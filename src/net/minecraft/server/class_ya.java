package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Predicate;

public class class_ya extends class_yc {
	private static final class_jz a;
	private static final class_jz b;
	private float c;
	private float bt;
	private float bu;
	private float bv;
	private float bw;
	private class_rg bx;
	private int by;
	private boolean bz;
	private class_tn bA;

	public class_ya(class_ago var1) {
		super(var1);
		b_ = 10;
		this.a(0.85F, 0.85F);
		i.a(4, new class_ya.class_a_in_class_ya(this));
		class_td var2;
		i.a(5, var2 = new class_td(this, 1.0D));
		i.a(7, bA = new class_tn(this, 1.0D, 80));
		i.a(8, new class_sw(this, class_yu.class, 8.0F));
		i.a(8, new class_sw(this, class_ya.class, 12.0F, 0.01F));
		i.a(9, new class_tm(this));
		bA.a(3);
		var2.a(3);
		bo.a(1, new class_uf(this, class_rg.class, 10, true, false, new class_ya.class_b_in_class_ya(this)));
		f = new class_ya.class_c_in_class_ya(this);
		bt = c = V.nextFloat();
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.e).a(6.0D);
		this.a(class_yf.d).a(0.5D);
		this.a(class_yf.b).a(16.0D);
		this.a(class_yf.a).a(30.0D);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.a(var1.p("Elder"));
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Elder", cG());
	}

	@Override
	protected class_um b(class_ago var1) {
		return new class_uo(this, var1);
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Byte.valueOf((byte) 0));
		ac.a(b, Integer.valueOf(0));
	}

	private boolean a(int var1) {
		return (((Byte) ac.a(a)).byteValue() & var1) != 0;
	}

	private void a(int var1, boolean var2) {
		byte var3 = ((Byte) ac.a(a)).byteValue();
		if (var2) {
			ac.b(a, Byte.valueOf((byte) (var3 | var1)));
		} else {
			ac.b(a, Byte.valueOf((byte) (var3 & ~var1)));
		}

	}

	public boolean n() {
		return this.a(2);
	}

	private void m(boolean var1) {
		this.a(2, var1);
	}

	public int cF() {
		return cG() ? 60 : 80;
	}

	public boolean cG() {
		return this.a(4);
	}

	public void a(boolean var1) {
		this.a(4, var1);
		if (var1) {
			this.a(1.9975F, 1.9975F);
			this.a(class_yf.d).a(0.30000001192092896D);
			this.a(class_yf.e).a(8.0D);
			this.a(class_yf.a).a(80.0D);
			cp();
			bA.b(400);
		}

	}

	private void b(int var1) {
		ac.b(b, Integer.valueOf(var1));
	}

	public boolean cI() {
		return ((Integer) ac.a(b)).intValue() != 0;
	}

	public class_rg cJ() {
		if (!cI()) {
			return null;
		} else if (o.D) {
			if (bx != null) {
				return bx;
			} else {
				Entity var1 = o.a(((Integer) ac.a(b)).intValue());
				if (var1 instanceof class_rg) {
					bx = (class_rg) var1;
					return bx;
				} else {
					return null;
				}
			}
		} else {
			return w();
		}
	}

	@Override
	public void a(class_jz var1) {
		super.a(var1);
		if (var1 == a) {
			if (cG() && (J < 1.0F)) {
				this.a(1.9975F, 1.9975F);
			}
		} else if (var1 == b) {
			by = 0;
			bx = null;
		}

	}

	@Override
	public int y() {
		return 160;
	}

	@Override
	protected String B() {
		return !Y() ? "mob.guardian.land.idle" : (cG() ? "mob.guardian.elder.idle" : "mob.guardian.idle");
	}

	@Override
	protected String bv() {
		return !Y() ? "mob.guardian.land.hit" : (cG() ? "mob.guardian.elder.hit" : "mob.guardian.hit");
	}

	@Override
	protected String bw() {
		return !Y() ? "mob.guardian.land.death" : (cG() ? "mob.guardian.elder.death" : "mob.guardian.death");
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	public float aY() {
		return K * 0.5F;
	}

	@Override
	public float a(class_cj var1) {
		return o.p(var1).c().v() == class_avq.h ? (10.0F + o.o(var1)) - 0.5F : super.a(var1);
	}

	@Override
	public void m() {
		if (o.D) {
			bt = c;
			if (!Y()) {
				bu = 2.0F;
				if ((w > 0.0D) && bz && !T()) {
					o.a(s, t, u, "mob.guardian.flop", 1.0F, 1.0F, false);
				}

				bz = (w < 0.0D) && o.d((new class_cj(this)).b(), false);
			} else if (this.n()) {
				if (bu < 0.5F) {
					bu = 4.0F;
				} else {
					bu += (0.5F - bu) * 0.1F;
				}
			} else {
				bu += (0.125F - bu) * 0.2F;
			}

			c += bu;
			bw = bv;
			if (!Y()) {
				bv = V.nextFloat();
			} else if (this.n()) {
				bv += (0.0F - bv) * 0.25F;
			} else {
				bv += (1.0F - bv) * 0.06F;
			}

			if (this.n() && Y()) {
				class_aym var1 = this.g(0.0F);

				for (int var2 = 0; var2 < 2; ++var2) {
					o.a(class_cy.e, (s + ((V.nextDouble() - 0.5D) * J)) - (var1.a * 1.5D), (t + (V.nextDouble() * K)) - (var1.b * 1.5D), (u + ((V.nextDouble() - 0.5D) * J)) - (var1.c * 1.5D), 0.0D, 0.0D, 0.0D, new int[0]);
				}
			}

			if (cI()) {
				if (by < cF()) {
					++by;
				}

				class_rg var14 = cJ();
				if (var14 != null) {
					this.q().a(var14, 90.0F, 90.0F);
					this.q().a();
					double var15 = this.r(0.0F);
					double var4 = var14.s - s;
					double var6 = (var14.t + var14.K * 0.5F) - (t + aY());
					double var8 = var14.u - u;
					double var10 = Math.sqrt((var4 * var4) + (var6 * var6) + (var8 * var8));
					var4 /= var10;
					var6 /= var10;
					var8 /= var10;
					double var12 = V.nextDouble();

					while (var12 < var10) {
						var12 += (1.8D - var15) + (V.nextDouble() * (1.7D - var15));
						o.a(class_cy.e, s + (var4 * var12), t + (var6 * var12) + aY(), u + (var8 * var12), 0.0D, 0.0D, 0.0D, new int[0]);
					}
				}
			}
		}

		if (Y) {
			this.h(300);
		} else if (C) {
			w += 0.5D;
			v += ((V.nextFloat() * 2.0F) - 1.0F) * 0.4F;
			x += ((V.nextFloat() * 2.0F) - 1.0F) * 0.4F;
			y = V.nextFloat() * 360.0F;
			C = false;
			ai = true;
		}

		if (cI()) {
			y = aO;
		}

		super.m();
	}

	public float r(float var1) {
		return (by + var1) / cF();
	}

	@Override
	protected void cg() {
		super.cg();
		if (cG()) {
			boolean var1 = true;
			boolean var2 = true;
			boolean var3 = true;
			boolean var4 = true;
			if (((W + G()) % 1200) == 0) {
				class_qq var5 = class_qs.d;
				List var6 = o.b(class_lm.class, new Predicate() {
					public boolean a(class_lm var1) {
						return (class_ya.this.h(var1) < 2500.0D) && var1.c.c();
					}

					// $FF: synthetic method
					@Override
					public boolean apply(Object var1) {
						return this.a((class_lm) var1);
					}
				});
				Iterator var7 = var6.iterator();

				label30: while (true) {
					class_lm var8;
					do {
						if (!var7.hasNext()) {
							break label30;
						}

						var8 = (class_lm) var7.next();
					} while (var8.a(var5) && (var8.b(var5).c() >= 2) && (var8.b(var5).b() >= 1200));

					var8.a.a((new class_gn(10, 0.0F)));
					var8.c(new class_qr(var5, 6000, 2));
				}
			}

			if (!cD()) {
				this.a(new class_cj(this), 16);
			}
		}

	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(3) + V.nextInt(var2 + 1);
		if (var3 > 0) {
			this.a(new class_aco(Items.cH, var3, 0), 1.0F);
		}

		if (V.nextInt(3 + var2) > 1) {
			this.a(new class_aco(Items.aW, 1, class_acf.class_a_in_class_acf.a.a()), 1.0F);
		} else if (V.nextInt(3 + var2) > 1) {
			this.a(new class_aco(Items.cI), 1.0F);
		}

		if (var1 && cG()) {
			this.a(new class_aco(Blocks.SPONGE, 1, 1), 1.0F);
		}

	}

	@Override
	protected void bx() {
		class_aco var1 = ((class_wz) class_oi.a(V, class_wy.i())).a(V);
		this.a(var1, 1.0F);
	}

	@Override
	protected boolean m_() {
		return true;
	}

	@Override
	public boolean ck() {
		return o.a(aX(), this) && o.a(this, aX()).isEmpty();
	}

	@Override
	public boolean cj() {
		return ((V.nextInt(20) == 0) || !o.j(new class_cj(this))) && super.cj();
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (!this.n() && !var1.s() && (var1.i() instanceof class_rg)) {
			class_rg var3 = (class_rg) var1.i();
			if (!var1.c()) {
				var3.a(class_qi.a((Entity) this), 2.0F);
				var3.a("damage.thorns", 0.5F, 1.0F);
			}
		}

		bA.f();
		return super.a(var1, var2);
	}

	@Override
	public int ch() {
		return 180;
	}

	@Override
	public void g(float var1, float var2) {
		if (bT()) {
			if (Y()) {
				this.a(var1, var2, 0.1F);
				this.d(v, w, x);
				v *= 0.8999999761581421D;
				w *= 0.8999999761581421D;
				x *= 0.8999999761581421D;
				if (!this.n() && (w() == null)) {
					w -= 0.005D;
				}
			} else {
				super.g(var1, var2);
			}
		} else {
			super.g(var1, var2);
		}

	}

	static {
		a = class_kc.a(class_ya.class, class_kb.a);
		b = class_kc.a(class_ya.class, class_kb.b);
	}

	static class class_c_in_class_ya extends class_se {
		private class_ya g;

		public class_c_in_class_ya(class_ya var1) {
			super(var1);
			g = var1;
		}

		@Override
		public void c() {
			if (f && !g.u().m()) {
				double var1 = b - g.s;
				double var3 = c - g.t;
				double var5 = d - g.u;
				double var7 = (var1 * var1) + (var3 * var3) + (var5 * var5);
				var7 = class_oa.a(var7);
				var3 /= var7;
				float var9 = (float) ((class_oa.b(var5, var1) * 180.0D) / 3.1415927410125732D) - 90.0F;
				g.y = this.a(g.y, var9, 30.0F);
				g.aM = g.y;
				float var10 = (float) (e * g.a(class_yf.d).e());
				g.l(g.bP() + ((var10 - g.bP()) * 0.125F));
				double var11 = Math.sin((g.W + g.G()) * 0.5D) * 0.05D;
				double var13 = Math.cos((g.y * 3.1415927F) / 180.0F);
				double var15 = Math.sin((g.y * 3.1415927F) / 180.0F);
				g.v += var11 * var13;
				g.x += var11 * var15;
				var11 = Math.sin((g.W + g.G()) * 0.75D) * 0.05D;
				g.w += var11 * (var15 + var13) * 0.25D;
				g.w += g.bP() * var3 * 0.1D;
				class_sd var17 = g.q();
				double var18 = g.s + ((var1 / var7) * 2.0D);
				double var20 = g.aY() + g.t + ((var3 / var7) * 1.0D);
				double var22 = g.u + ((var5 / var7) * 2.0D);
				double var24 = var17.e();
				double var26 = var17.f();
				double var28 = var17.g();
				if (!var17.b()) {
					var24 = var18;
					var26 = var20;
					var28 = var22;
				}

				g.q().a(var24 + ((var18 - var24) * 0.125D), var26 + ((var20 - var26) * 0.125D), var28 + ((var22 - var28) * 0.125D), 10.0F, 40.0F);
				g.m(true);
			} else {
				g.l(0.0F);
				g.m(false);
			}
		}
	}

	static class class_a_in_class_ya extends class_sr {
		private class_ya a;
		private int b;

		public class_a_in_class_ya(class_ya var1) {
			a = var1;
			this.a(3);
		}

		@Override
		public boolean a() {
			class_rg var1 = a.w();
			return (var1 != null) && var1.al();
		}

		@Override
		public boolean b() {
			return super.b() && (a.cG() || (a.h(a.w()) > 9.0D));
		}

		@Override
		public void c() {
			b = -10;
			a.u().n();
			a.q().a(a.w(), 90.0F, 90.0F);
			a.ai = true;
		}

		@Override
		public void d() {
			a.b(0);
			a.c((class_rg) null);
			a.bA.f();
		}

		@Override
		public void e() {
			class_rg var1 = a.w();
			a.u().n();
			a.q().a(var1, 90.0F, 90.0F);
			if (!a.t(var1)) {
				a.c((class_rg) null);
			} else {
				++b;
				if (b == 0) {
					a.b(a.w().G());
					a.o.a(a, (byte) 21);
				} else if (b >= a.cF()) {
					float var2 = 1.0F;
					if (a.o.ac() == class_ps.d) {
						var2 += 2.0F;
					}

					if (a.cG()) {
						var2 += 2.0F;
					}

					var1.a(class_qi.b(a, a), var2);
					var1.a(class_qi.a(a), (float) a.a(class_yf.e).e());
					a.c((class_rg) null);
				} else if ((b >= 60) && ((b % 20) == 0)) {
					;
				}

				super.e();
			}
		}
	}

	static class class_b_in_class_ya implements Predicate {
		private class_ya a;

		public class_b_in_class_ya(class_ya var1) {
			a = var1;
		}

		public boolean a(class_rg var1) {
			return ((var1 instanceof class_yu) || (var1 instanceof class_vo)) && (var1.h(a) > 9.0D);
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_rg) var1);
		}
	}
}
