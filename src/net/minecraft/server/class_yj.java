package net.minecraft.server;

import java.util.Random;

public class class_yj extends class_yc {
	private static final class_jz a;

	public class_yj(class_ago var1) {
		super(var1);
		this.a(1.4F, 0.9F);
		i.a(1, new class_so(this));
		i.a(3, new class_sv(this, 0.4F));
		i.a(4, new class_yj.class_a_in_class_yj(this, class_yu.class));
		i.a(4, new class_yj.class_a_in_class_yj(this, class_vp.class));
		i.a(5, new class_tn(this, 0.8D));
		i.a(6, new class_sw(this, class_yu.class, 8.0F));
		i.a(6, new class_tm(this));
		bo.a(1, new class_uc(this, false, new Class[0]));
		bo.a(2, new class_yj.class_c_in_class_yj(this, class_yu.class));
		bo.a(3, new class_yj.class_c_in_class_yj(this, class_vp.class));
	}

	@Override
	public double aq() {
		return K * 0.5F;
	}

	@Override
	protected class_um b(class_ago var1) {
		return new class_un(this, var1);
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Byte.valueOf((byte) 0));
	}

	@Override
	public void r_() {
		super.r_();
		if (!o.D) {
			this.a(D);
		}

	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(16.0D);
		this.a(class_yf.d).a(0.30000001192092896D);
	}

	@Override
	protected String B() {
		return "mob.spider.say";
	}

	@Override
	protected String bv() {
		return "mob.spider.say";
	}

	@Override
	protected String bw() {
		return "mob.spider.death";
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		this.a("mob.spider.step", 0.15F, 1.0F);
	}

	@Override
	protected Item D() {
		return Items.H;
	}

	@Override
	protected void b(boolean var1, int var2) {
		super.b(var1, var2);
		if (var1 && ((V.nextInt(3) == 0) || (V.nextInt(1 + var2) > 0))) {
			this.a(Items.bG, 1);
		}

	}

	@Override
	public boolean j_() {
		return this.n();
	}

	@Override
	public void aG() {
	}

	@Override
	public class_rl bF() {
		return class_rl.c;
	}

	@Override
	public boolean d(class_qr var1) {
		return var1.a() == class_qs.s ? false : super.d(var1);
	}

	public boolean n() {
		return (((Byte) ac.a(a)).byteValue() & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = ((Byte) ac.a(a)).byteValue();
		if (var1) {
			var2 = (byte) (var2 | 1);
		} else {
			var2 &= -2;
		}

		ac.b(a, Byte.valueOf(var2));
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		Object var4 = super.a(var1, var2);
		if (o.s.nextInt(100) == 0) {
			class_yh var3 = new class_yh(o);
			var3.b(s, t, u, y, 0.0F);
			var3.a(var1, (class_rj) null);
			o.a(var3);
			var3.a((Entity) this);
		}

		if (var4 == null) {
			var4 = new class_yj.class_b_in_class_yj();
			if ((o.ac() == class_ps.d) && (o.s.nextFloat() < (0.1F * var1.c()))) {
				((class_yj.class_b_in_class_yj) var4).a(o.s);
			}
		}

		if (var4 instanceof class_yj.class_b_in_class_yj) {
			class_qq var5 = ((class_yj.class_b_in_class_yj) var4).a;
			if (var5 != null) {
				this.c(new class_qr(var5, Integer.MAX_VALUE));
			}
		}

		return (class_rj) var4;
	}

	@Override
	public float aY() {
		return 0.65F;
	}

	static {
		a = class_kc.a(class_yj.class, class_kb.a);
	}

	static class class_c_in_class_yj extends class_uf {
		public class_c_in_class_yj(class_yj var1, Class var2) {
			super(var1, var2, true);
		}

		@Override
		public boolean a() {
			float var1 = e.f(1.0F);
			return var1 >= 0.5F ? false : super.a();
		}
	}

	static class class_a_in_class_yj extends class_sz {
		public class_a_in_class_yj(class_yj var1, Class var2) {
			super(var1, var2, 1.0D, true);
		}

		@Override
		public boolean b() {
			float var1 = b.f(1.0F);
			if ((var1 >= 0.5F) && (b.bj().nextInt(100) == 0)) {
				b.c((class_rg) null);
				return false;
			} else {
				return super.b();
			}
		}

		@Override
		protected double a(class_rg var1) {
			return 4.0F + var1.J;
		}
	}

	public static class class_b_in_class_yj implements class_rj {
		public class_qq a;

		public void a(Random var1) {
			int var2 = var1.nextInt(5);
			if (var2 <= 1) {
				a = class_qs.a;
			} else if (var2 <= 2) {
				a = class_qs.e;
			} else if (var2 <= 3) {
				a = class_qs.j;
			} else if (var2 <= 4) {
				a = class_qs.n;
			}

		}
	}
}
