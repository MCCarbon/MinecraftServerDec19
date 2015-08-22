package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_vj extends class_vc {
	private static final class_jz bt;
	private static final Set bu;
	private final class_sk bv;

	public class_vj(class_ago var1) {
		super(var1);
		this.a(0.9F, 0.9F);
		((class_ul) u()).a(true);
		i.a(0, new class_so(this));
		i.a(1, new class_tj(this, 1.25D));
		i.a(2, bv = new class_sk(this, 0.3F));
		i.a(3, new class_sj(this, 1.0D));
		i.a(4, new class_tw(this, 1.2D, class_acq.cd, false));
		i.a(4, new class_tw(this, 1.2D, false, bu));
		i.a(5, new class_sq(this, 1.1D));
		i.a(6, new class_tn(this, 1.0D));
		i.a(7, new class_sw(this, class_yu.class, 6.0F));
		i.a(8, new class_tm(this));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(10.0D);
		this.a(class_yf.d).a(0.25D);
	}

	@Override
	public boolean co() {
		class_aco var1 = ((class_yu) l).bG();
		if ((var1 != null) && (var1.b() == class_acq.cd)) {
			return true;
		} else {
			var1 = ((class_yu) l).bH();
			return (var1 != null) && (var1.b() == class_acq.cd);
		}
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bt, Boolean.valueOf(false));
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Saddle", cE());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.m(var1.p("Saddle"));
	}

	@Override
	protected String B() {
		return "mob.pig.say";
	}

	@Override
	protected String bv() {
		return "mob.pig.say";
	}

	@Override
	protected String bw() {
		return "mob.pig.death";
	}

	@Override
	protected void a(class_cj var1, class_ail var2) {
		this.a("mob.pig.step", 0.15F, 1.0F);
	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if (super.a(var1, var2, var3)) {
			return true;
		} else if (!cE() || o.D || ((l != null) && (l != var1))) {
			return false;
		} else {
			var1.a((class_qx) this);
			return true;
		}
	}

	@Override
	protected class_acm D() {
		return ay() ? class_acq.ao : class_acq.an;
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(3) + 1 + V.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			if (ay()) {
				this.a(class_acq.ao, 1);
			} else {
				this.a(class_acq.an, 1);
			}
		}

		if (cE()) {
			this.a(class_acq.aC, 1);
		}

	}

	public boolean cE() {
		return ((Boolean) ac.a(bt)).booleanValue();
	}

	public void m(boolean var1) {
		if (var1) {
			ac.b(bt, Boolean.valueOf(true));
		} else {
			ac.b(bt, Boolean.valueOf(false));
		}

	}

	@Override
	public void a(class_xc var1) {
		if (!o.D && !I) {
			class_yd var2 = new class_yd(o);
			var2.a(class_rc.a, (new class_aco(class_acq.D)));
			var2.b(s, t, u, y, z);
			var2.k(cw());
			if (k_()) {
				var2.c(aS());
				var2.g(aT());
			}

			o.a(var2);
			L();
		}
	}

	@Override
	public void e(float var1, float var2) {
		super.e(var1, var2);
		if ((var1 > 5.0F) && (l instanceof class_yu)) {
			((class_yu) l).b(class_my.u);
		}

	}

	public class_vj b(class_qu var1) {
		return new class_vj(o);
	}

	@Override
	public boolean d(class_aco var1) {
		return (var1 != null) && bu.contains(var1.b());
	}

	public class_sk cF() {
		return bv;
	}

	// $FF: synthetic method
	@Override
	public class_qu a(class_qu var1) {
		return this.b(var1);
	}

	static {
		bt = class_kc.a(class_vj.class, class_kb.g);
		bu = Sets.newHashSet((Object[]) (new class_acm[] { class_acq.bW, class_acq.bX, class_acq.cO }));
	}
}
