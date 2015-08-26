package net.minecraft.server;


public class class_aol extends TileEntity {
	private boolean a;
	private boolean f;
	private final class_age g = new class_age() {
		@Override
		public class_cj c() {
			return class_aol.this.c;
		}

		@Override
		public class_aym d() {
			return new class_aym(class_aol.this.c.n() + 0.5D, class_aol.this.c.o() + 0.5D, class_aol.this.c.p() + 0.5D);
		}

		@Override
		public class_ago e() {
			return class_aol.this.z();
		}

		@Override
		public void a(String var1) {
			super.a(var1);
			class_aol.this.o_();
		}

		@Override
		public void h() {
			class_aol.this.z().h(class_aol.this.c);
		}

		@Override
		public Entity f() {
			return null;
		}
	};

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		g.a(var1);
		var1.a("powered", a);
		var1.a("conditional", f);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		g.b(var1);
		a = var1.p("powered");
		f = var1.p("conditional");
	}

	@Override
	public Packet x_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		return new class_ft(c, 2, var1);
	}

	@Override
	public boolean F() {
		return true;
	}

	public class_age b() {
		return g;
	}

	public class_n c() {
		return g.n();
	}

	public void a(boolean var1) {
		a = var1;
	}

	public boolean d() {
		return a;
	}

	public boolean e() {
		return f;
	}

	public void b(boolean var1) {
		f = var1;
	}

	public class_aol.class_a_in_class_aol g() {
		Block var1 = w();
		return var1 == Blocks.COMMAND_BLOCK ? class_aol.class_a_in_class_aol.c : (var1 == Blocks.REPEATING_COMMAND_BLOCK ? class_aol.class_a_in_class_aol.b : (var1 == Blocks.CHAIN_COMMAND_BLOCK ? class_aol.class_a_in_class_aol.a : class_aol.class_a_in_class_aol.c));
	}

	@Override
	public void D() {
		e = null;
		super.D();
	}

	public static enum class_a_in_class_aol {
		a,
		b,
		c;
	}
}
