package net.minecraft.server;


public class class_xj extends class_xh {
	private static final class_jz a;
	private static final class_jz b;
	private final class_age c = new class_age() {
		@Override
		public void h() {
			class_xj.this.J().b(class_xj.a, this.l());
			class_xj.this.J().b(class_xj.b, this.k());
		}

		@Override
		public class_cj c() {
			return new class_cj(class_xj.this.s, class_xj.this.t + 0.5D, class_xj.this.u);
		}

		@Override
		public class_aym d() {
			return new class_aym(class_xj.this.s, class_xj.this.t, class_xj.this.u);
		}

		@Override
		public class_ago e() {
			return class_xj.this.o;
		}

		@Override
		public class_qx f() {
			return class_xj.this;
		}
	};
	private int d = 0;

	public class_xj(class_ago var1) {
		super(var1);
	}

	public class_xj(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	protected void h() {
		super.h();
		J().a(a, "");
		J().a(b, (new class_fa("")));
	}

	@Override
	protected void a(class_dn var1) {
		super.a(var1);
		c.b(var1);
		J().b(a, this.i().l());
		J().b(b, this.i().k());
	}

	@Override
	protected void b(class_dn var1) {
		super.b(var1);
		c.a(var1);
	}

	@Override
	public class_xh.class_a_in_class_xh s() {
		return class_xh.class_a_in_class_xh.g;
	}

	@Override
	public class_apn u() {
		return class_aim.bX.S();
	}

	public class_age i() {
		return c;
	}

	@Override
	public void a(int var1, int var2, int var3, boolean var4) {
		if (var4 && ((W - d) >= 4)) {
			this.i().a(o);
			d = W;
		}

	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		c.a(var1);
		return false;
	}

	@Override
	public void a(class_jz var1) {
		super.a(var1);
		if (var1 == b) {
			try {
				c.b((class_eu) J().a(b));
			} catch (Throwable var3) {
				;
			}
		} else if (var1 == a) {
			c.a((String) J().a(a));
		}

	}

	@Override
	public boolean bc() {
		return true;
	}

	static {
		a = class_kc.a(class_xj.class, class_kb.d);
		b = class_kc.a(class_xj.class, class_kb.e);
	}
}
