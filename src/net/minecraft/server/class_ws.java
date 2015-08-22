package net.minecraft.server;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Predicate;

public class class_ws extends class_rg {
	private static final class_dc h = new class_dc(0.0F, 0.0F, 0.0F);
	private static final class_dc i = new class_dc(0.0F, 0.0F, 0.0F);
	private static final class_dc bo = new class_dc(-10.0F, 0.0F, -10.0F);
	private static final class_dc bp = new class_dc(-15.0F, 0.0F, 10.0F);
	private static final class_dc bq = new class_dc(-1.0F, 0.0F, -1.0F);
	private static final class_dc br = new class_dc(1.0F, 0.0F, 1.0F);
	public static final class_jz a;
	public static final class_jz b;
	public static final class_jz c;
	public static final class_jz d;
	public static final class_jz e;
	public static final class_jz f;
	public static final class_jz g;
	private static final Predicate bs;
	private final class_aco[] bt;
	private final class_aco[] bu;
	private boolean bv;
	private long bw;
	private int bx;
	private boolean by;
	private class_dc bz;
	private class_dc bA;
	private class_dc bB;
	private class_dc bC;
	private class_dc bD;
	private class_dc bE;

	public class_ws(class_ago var1) {
		super(var1);
		bt = new class_aco[2];
		bu = new class_aco[4];
		bz = h;
		bA = i;
		bB = bo;
		bC = bp;
		bD = bq;
		bE = br;
		this.b(true);
		T = this.p();
		this.a(0.5F, 1.975F);
	}

	public class_ws(class_ago var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
	}

	@Override
	public boolean bT() {
		return super.bT() && !this.p();
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Byte.valueOf((byte) 0));
		ac.a(b, h);
		ac.a(c, i);
		ac.a(d, bo);
		ac.a(e, bp);
		ac.a(f, bq);
		ac.a(g, br);
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
		switch (class_ws.SyntheticClass_1.a[var1.a().ordinal()]) {
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
		switch (class_ws.SyntheticClass_1.a[var1.a().ordinal()]) {
			case 1:
				bt[var1.b()] = var2;
				break;
			case 2:
				bu[var1.b()] = var2;
		}

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

		if ((var2 != null) && !class_rh.b(var3, var2) && (var3 != class_rc.f)) {
			return false;
		} else {
			this.a(var3, var2);
			return true;
		}
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		class_du var2 = new class_du();

		for (int var3 = 0; var3 < bu.length; ++var3) {
			class_dn var4 = new class_dn();
			if (bu[var3] != null) {
				bu[var3].b(var4);
			}

			var2.a(var4);
		}

		var1.a("ArmorItems", var2);
		class_du var6 = new class_du();

		for (int var7 = 0; var7 < bt.length; ++var7) {
			class_dn var5 = new class_dn();
			if (bt[var7] != null) {
				bt[var7].b(var5);
			}

			var6.a(var5);
		}

		var1.a("HandItems", var6);
		if (aT() && ((aS() == null) || aS().isEmpty())) {
			var1.a("CustomNameVisible", aT());
		}

		var1.a("Invisible", aD());
		var1.a("Small", this.n());
		var1.a("ShowArms", this.q());
		var1.a("DisabledSlots", bx);
		var1.a("NoGravity", this.p());
		var1.a("NoBasePlate", this.r());
		if (this.s()) {
			var1.a("Marker", this.s());
		}

		var1.a("Pose", A());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
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

		this.f(var1.p("Invisible"));
		this.j(var1.p("Small"));
		this.l(var1.p("ShowArms"));
		bx = var1.h("DisabledSlots");
		this.k(var1.p("NoGravity"));
		this.m(var1.p("NoBasePlate"));
		this.n(var1.p("Marker"));
		by = !this.s();
		T = this.p();
		class_dn var4 = var1.o("Pose");
		this.g(var4);
	}

	private void g(class_dn var1) {
		class_du var2 = var1.c("Head", 5);
		this.a(var2.c_() ? h : new class_dc(var2));
		class_du var3 = var1.c("Body", 5);
		this.b(var3.c_() ? i : new class_dc(var3));
		class_du var4 = var1.c("LeftArm", 5);
		this.c(var4.c_() ? bo : new class_dc(var4));
		class_du var5 = var1.c("RightArm", 5);
		this.d(var5.c_() ? bp : new class_dc(var5));
		class_du var6 = var1.c("LeftLeg", 5);
		this.e(var6.c_() ? bq : new class_dc(var6));
		class_du var7 = var1.c("RightLeg", 5);
		this.f(var7.c_() ? br : new class_dc(var7));
	}

	private class_dn A() {
		class_dn var1 = new class_dn();
		if (!h.equals(bz)) {
			var1.a("Head", bz.a());
		}

		if (!i.equals(bA)) {
			var1.a("Body", bA.a());
		}

		if (!bo.equals(bB)) {
			var1.a("LeftArm", bB.a());
		}

		if (!bp.equals(bC)) {
			var1.a("RightArm", bC.a());
		}

		if (!bq.equals(bD)) {
			var1.a("LeftLeg", bD.a());
		}

		if (!br.equals(bE)) {
			var1.a("RightLeg", bE.a());
		}

		return var1;
	}

	@Override
	public boolean ah() {
		return false;
	}

	@Override
	protected void s(class_qx var1) {
	}

	@Override
	protected void bS() {
		List var1 = o.a(this, aX(), bs);

		for (int var2 = 0; var2 < var1.size(); ++var2) {
			class_qx var3 = (class_qx) var1.get(var2);
			if (this.h(var3) <= 0.2D) {
				var3.i(this);
			}
		}

	}

	@Override
	public class_pw a(class_yu var1, class_aym var2, class_aco var3, class_pu var4) {
		if (this.s()) {
			return class_pw.b;
		} else if (!o.D && !var1.w()) {
			class_rc var5 = class_rc.a;
			boolean var6 = var3 != null;
			class_acm var7 = var6 ? var3.b() : null;
			if (var6 && (var7 instanceof class_aav)) {
				var5 = ((class_aav) var7).b;
			}

			if (var6 && ((var7 == class_acq.cc) || (var7 == class_acm.a(class_aim.aU)))) {
				var5 = class_rc.f;
			}

			double var8 = 0.1D;
			double var10 = 0.9D;
			double var12 = 0.4D;
			double var14 = 1.6D;
			class_rc var16 = class_rc.a;
			boolean var17 = this.n();
			double var18 = var17 ? var2.b * 2.0D : var2.b;
			if ((var18 >= 0.1D) && (var18 < (0.1D + (var17 ? 0.8D : 0.45D))) && (this.a(class_rc.c) != null)) {
				var16 = class_rc.c;
			} else if ((var18 >= (0.9D + (var17 ? 0.3D : 0.0D))) && (var18 < (0.9D + (var17 ? 1.0D : 0.7D))) && (this.a(class_rc.e) != null)) {
				var16 = class_rc.e;
			} else if ((var18 >= 0.4D) && (var18 < (0.4D + (var17 ? 1.0D : 0.8D))) && (this.a(class_rc.d) != null)) {
				var16 = class_rc.d;
			} else if ((var18 >= 1.6D) && (this.a(class_rc.f) != null)) {
				var16 = class_rc.f;
			}

			boolean var20 = this.a(var16) != null;
			boolean var21 = this.b(var16);
			if (var21 || this.b(var5)) {
				var16 = var5;
				if (var21) {
					if (this.b(class_rc.a)) {
						return class_pw.c;
					}

					var16 = class_rc.a;
				}
			}

			if (var6 && (var5 == class_rc.a) && !this.q()) {
				return class_pw.c;
			} else {
				if (var6) {
					this.a(var1, var5, var3, var4);
				} else if (var20) {
					this.a(var1, var16, var3, var4);
				}

				return class_pw.a;
			}
		} else {
			return class_pw.a;
		}
	}

	private boolean b(class_rc var1) {
		return (bx & (1 << var1.c())) != 0;
	}

	private void a(class_yu var1, class_rc var2, class_aco var3, class_pu var4) {
		class_aco var5 = this.a(var2);
		if ((var5 == null) || ((bx & (1 << (var2.c() + 8))) == 0)) {
			if ((var5 != null) || ((bx & (1 << (var2.c() + 16))) == 0)) {
				class_aco var6;
				if (var1.bI.d && ((var5 == null) || (var5.b() == class_acm.a(class_aim.a))) && (var3 != null)) {
					var6 = var3.k();
					var6.b = 1;
					this.a(var2, var6);
				} else if ((var3 != null) && (var3.b > 1)) {
					if (var5 == null) {
						var6 = var3.k();
						var6.b = 1;
						this.a(var2, var6);
						--var3.b;
					}
				} else {
					this.a(var2, var3);
					var1.a(var4, var5);
				}
			}
		}
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (o.D) {
			return false;
		} else if (class_qi.j.equals(var1)) {
			L();
			return false;
		} else if (!this.b(var1) && !bv && !this.s()) {
			if (var1.c()) {
				E();
				L();
				return false;
			} else if (class_qi.a.equals(var1)) {
				if (ay()) {
					this.a(0.15F);
				} else {
					this.e(5);
				}

				return false;
			} else if (class_qi.c.equals(var1) && (bu() > 0.5F)) {
				this.a(4.0F);
				return false;
			} else {
				boolean var3 = "arrow".equals(var1.p());
				boolean var4 = "player".equals(var1.p());
				if (!var4 && !var3) {
					return false;
				} else {
					if (var1.i() instanceof class_yx) {
						var1.i().L();
					}

					if ((var1.j() instanceof class_yu) && !((class_yu) var1.j()).bI.e) {
						return false;
					} else if (var1.u()) {
						B();
						L();
						return false;
					} else {
						long var5 = o.M();
						if (((var5 - bw) > 5L) && !var3) {
							bw = var5;
						} else {
							D();
							B();
							L();
						}

						return false;
					}
				}
			}
		} else {
			return false;
		}
	}

	private void B() {
		if (o instanceof class_ll) {
			((class_ll) o).a(class_cy.M, s, t + (K / 1.5D), u, 10, J / 4.0F, K / 4.0F, J / 4.0F, 0.05D, new int[] { class_ail.f(class_aim.f.S()) });
		}

	}

	private void a(float var1) {
		float var2 = bu();
		var2 -= var1;
		if (var2 <= 0.5F) {
			E();
			L();
		} else {
			this.c(var2);
		}

	}

	private void D() {
		class_ail.a(o, new class_cj(this), new class_aco(class_acq.co));
		E();
	}

	private void E() {
		int var1;
		for (var1 = 0; var1 < bt.length; ++var1) {
			if ((bt[var1] != null) && (bt[var1].b > 0)) {
				if (bt[var1] != null) {
					class_ail.a(o, (new class_cj(this)).a(), bt[var1]);
				}

				bt[var1] = null;
			}
		}

		for (var1 = 0; var1 < bu.length; ++var1) {
			if ((bu[var1] != null) && (bu[var1].b > 0)) {
				if (bu[var1] != null) {
					class_ail.a(o, (new class_cj(this)).a(), bu[var1]);
				}

				bu[var1] = null;
			}
		}

	}

	@Override
	protected float h(float var1, float var2) {
		aN = A;
		aM = y;
		return 0.0F;
	}

	@Override
	public float aY() {
		return i_() ? K * 0.5F : K * 0.9F;
	}

	@Override
	public void g(float var1, float var2) {
		if (!this.p()) {
			super.g(var1, var2);
		}
	}

	@Override
	public void r_() {
		super.r_();
		class_dc var1 = (class_dc) ac.a(b);
		if (!bz.equals(var1)) {
			this.a(var1);
		}

		class_dc var2 = (class_dc) ac.a(c);
		if (!bA.equals(var2)) {
			this.b(var2);
		}

		class_dc var3 = (class_dc) ac.a(d);
		if (!bB.equals(var3)) {
			this.c(var3);
		}

		class_dc var4 = (class_dc) ac.a(e);
		if (!bC.equals(var4)) {
			this.d(var4);
		}

		class_dc var5 = (class_dc) ac.a(f);
		if (!bD.equals(var5)) {
			this.e(var5);
		}

		class_dc var6 = (class_dc) ac.a(g);
		if (!bE.equals(var6)) {
			this.f(var6);
		}

		boolean var7 = this.s();
		if (!by && var7) {
			this.a(false);
		} else {
			if (!by || var7) {
				return;
			}

			this.a(true);
		}

		by = var7;
	}

	private void a(boolean var1) {
		double var2 = s;
		double var4 = t;
		double var6 = u;
		if (var1) {
			this.a(0.5F, 1.975F);
		} else {
			this.a(0.0F, 0.0F);
		}

		this.b(var2, var4, var6);
	}

	@Override
	protected void C() {
		this.f(bv);
	}

	@Override
	public void f(boolean var1) {
		bv = var1;
		super.f(var1);
	}

	@Override
	public boolean i_() {
		return this.n();
	}

	@Override
	public void I() {
		L();
	}

	@Override
	public boolean bb() {
		return aD();
	}

	private void j(boolean var1) {
		ac.b(a, Byte.valueOf(this.a(((Byte) ac.a(a)).byteValue(), 1, var1)));
	}

	public boolean n() {
		return (((Byte) ac.a(a)).byteValue() & 1) != 0;
	}

	private void k(boolean var1) {
		ac.b(a, Byte.valueOf(this.a(((Byte) ac.a(a)).byteValue(), 2, var1)));
	}

	public boolean p() {
		return (((Byte) ac.a(a)).byteValue() & 2) != 0;
	}

	private void l(boolean var1) {
		ac.b(a, Byte.valueOf(this.a(((Byte) ac.a(a)).byteValue(), 4, var1)));
	}

	public boolean q() {
		return (((Byte) ac.a(a)).byteValue() & 4) != 0;
	}

	private void m(boolean var1) {
		ac.b(a, Byte.valueOf(this.a(((Byte) ac.a(a)).byteValue(), 8, var1)));
	}

	public boolean r() {
		return (((Byte) ac.a(a)).byteValue() & 8) != 0;
	}

	private void n(boolean var1) {
		ac.b(a, Byte.valueOf(this.a(((Byte) ac.a(a)).byteValue(), 16, var1)));
	}

	public boolean s() {
		return (((Byte) ac.a(a)).byteValue() & 16) != 0;
	}

	private byte a(byte var1, int var2, boolean var3) {
		if (var3) {
			var1 = (byte) (var1 | var2);
		} else {
			var1 = (byte) (var1 & ~var2);
		}

		return var1;
	}

	public void a(class_dc var1) {
		bz = var1;
		ac.b(b, var1);
	}

	public void b(class_dc var1) {
		bA = var1;
		ac.b(c, var1);
	}

	public void c(class_dc var1) {
		bB = var1;
		ac.b(d, var1);
	}

	public void d(class_dc var1) {
		bC = var1;
		ac.b(e, var1);
	}

	public void e(class_dc var1) {
		bD = var1;
		ac.b(f, var1);
	}

	public void f(class_dc var1) {
		bE = var1;
		ac.b(g, var1);
	}

	public class_dc u() {
		return bz;
	}

	public class_dc v() {
		return bA;
	}

	@Override
	public boolean ag() {
		return super.ag() && !this.s();
	}

	static {
		a = class_kc.a(class_ws.class, class_kb.a);
		b = class_kc.a(class_ws.class, class_kb.h);
		c = class_kc.a(class_ws.class, class_kb.h);
		d = class_kc.a(class_ws.class, class_kb.h);
		e = class_kc.a(class_ws.class, class_kb.h);
		f = class_kc.a(class_ws.class, class_kb.h);
		g = class_kc.a(class_ws.class, class_kb.h);
		bs = new Predicate() {
			public boolean a(class_qx var1) {
				return (var1 instanceof class_xh) && (((class_xh) var1).s() == class_xh.class_a_in_class_xh.a);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((class_qx) var1);
			}
		};
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
