package net.minecraft.server;

import java.util.Random;

public class class_yg extends class_yc {
	private class_yg.class_b_in_class_yg a;

	public class_yg(class_ago var1) {
		super(var1);
		this.a(0.4F, 0.3F);
		i.a(1, new class_so(this));
		i.a(3, a = new class_yg.class_b_in_class_yg(this));
		i.a(4, new class_sz(this, class_yu.class, 1.0D, false));
		i.a(5, new class_yg.class_a_in_class_yg(this));
		bo.a(1, new class_uc(this, true, new Class[0]));
		bo.a(2, new class_uf(this, class_yu.class, true));
	}

	@Override
	public double ap() {
		return 0.2D;
	}

	@Override
	public float aY() {
		return 0.1F;
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(8.0D);
		this.a(class_yf.d).a(0.25D);
		this.a(class_yf.e).a(1.0D);
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	protected String B() {
		return "mob.silverfish.say";
	}

	@Override
	protected String bv() {
		return "mob.silverfish.hit";
	}

	@Override
	protected String bw() {
		return "mob.silverfish.kill";
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if ((var1 instanceof class_qj) || (var1 == class_qi.l)) {
				a.f();
			}

			return super.a(var1, var2);
		}
	}

	@Override
	protected void a(class_cj var1, class_ail var2) {
		this.a("mob.silverfish.step", 0.15F, 1.0F);
	}

	@Override
	protected class_acm D() {
		return null;
	}

	@Override
	public void r_() {
		aM = y;
		super.r_();
	}

	@Override
	public float a(class_cj var1) {
		return o.p(var1.b()).c() == class_aim.b ? 10.0F : super.a(var1);
	}

	@Override
	protected boolean m_() {
		return true;
	}

	@Override
	public boolean cj() {
		if (super.cj()) {
			class_yu var1 = o.a(this, 5.0D);
			return var1 == null;
		} else {
			return false;
		}
	}

	@Override
	public class_rl bF() {
		return class_rl.c;
	}

	static class class_a_in_class_yg extends class_tn {
		private final class_yg a;
		private class_cq b;
		private boolean c;

		public class_a_in_class_yg(class_yg var1) {
			super(var1, 1.0D, 10);
			a = var1;
			this.a(1);
		}

		@Override
		public boolean a() {
			if (a.w() != null) {
				return false;
			} else if (!a.u().m()) {
				return false;
			} else {
				Random var1 = a.bj();
				if (var1.nextInt(10) == 0) {
					b = class_cq.a(var1);
					class_cj var2 = (new class_cj(a.s, a.t + 0.5D, a.u)).a(b);
					class_apn var3 = a.o.p(var2);
					if (class_alj.d(var3)) {
						c = true;
						return true;
					}
				}

				c = false;
				return super.a();
			}
		}

		@Override
		public boolean b() {
			return c ? false : super.b();
		}

		@Override
		public void c() {
			if (!c) {
				super.c();
			} else {
				class_ago var1 = a.o;
				class_cj var2 = (new class_cj(a.s, a.t + 0.5D, a.u)).a(b);
				class_apn var3 = var1.p(var2);
				if (class_alj.d(var3)) {
					var1.a(var2, class_aim.be.S().a(class_alj.a, class_alj.class_a_in_class_alj.a(var3)), 3);
					a.A();
					a.L();
				}

			}
		}
	}

	static class class_b_in_class_yg extends class_sr {
		private class_yg a;
		private int b;

		public class_b_in_class_yg(class_yg var1) {
			a = var1;
		}

		public void f() {
			if (b == 0) {
				b = 20;
			}

		}

		@Override
		public boolean a() {
			return b > 0;
		}

		@Override
		public void e() {
			--b;
			if (b <= 0) {
				class_ago var1 = a.o;
				Random var2 = a.bj();
				class_cj var3 = new class_cj(a);

				for (int var4 = 0; (var4 <= 5) && (var4 >= -5); var4 = var4 <= 0 ? 1 - var4 : 0 - var4) {
					for (int var5 = 0; (var5 <= 10) && (var5 >= -10); var5 = var5 <= 0 ? 1 - var5 : 0 - var5) {
						for (int var6 = 0; (var6 <= 10) && (var6 >= -10); var6 = var6 <= 0 ? 1 - var6 : 0 - var6) {
							class_cj var7 = var3.a(var5, var4, var6);
							class_apn var8 = var1.p(var7);
							if (var8.c() == class_aim.be) {
								if (var1.S().b("mobGriefing")) {
									var1.b(var7, true);
								} else {
									var1.a(var7, ((class_alj.class_a_in_class_alj) var8.b(class_alj.a)).d(), 3);
								}

								if (var2.nextBoolean()) {
									return;
								}
							}
						}
					}
				}
			}

		}
	}
}
