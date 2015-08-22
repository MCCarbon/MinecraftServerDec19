package net.minecraft.server;


public class class_xo extends class_xh {
	private final class_agf a = new class_agf() {
		@Override
		public void a(int var1) {
			class_xo.this.o.a(class_xo.this, ((byte) var1));
		}

		@Override
		public class_ago a() {
			return class_xo.this.o;
		}

		@Override
		public class_cj b() {
			return new class_cj(class_xo.this);
		}
	};

	public class_xo(class_ago var1) {
		super(var1);
	}

	public class_xo(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public class_xh.class_a_in_class_xh s() {
		return class_xh.class_a_in_class_xh.e;
	}

	@Override
	public class_apn u() {
		return class_aim.ac.S();
	}

	@Override
	protected void a(class_dn var1) {
		super.a(var1);
		a.a(var1);
	}

	@Override
	protected void b(class_dn var1) {
		super.b(var1);
		a.b(var1);
	}

	@Override
	public void r_() {
		super.r_();
		a.c();
	}
}
