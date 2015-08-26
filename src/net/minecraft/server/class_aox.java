package net.minecraft.server;


public class class_aox extends TileEntity implements class_ks {
	private final class_agf a = new class_agf() {
		@Override
		public void a(int var1) {
			class_aox.this.b.c(class_aox.this.c, Blocks.MOB_SPAWNER, var1, 0);
		}

		@Override
		public class_ago a() {
			return class_aox.this.b;
		}

		@Override
		public class_cj b() {
			return class_aox.this.c;
		}

		@Override
		public void a(class_agy var1) {
			super.a(var1);
			if (this.a() != null) {
				this.a().h(class_aox.this.c);
			}

		}
	};

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a.a(var1);
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		a.b(var1);
	}

	@Override
	public void c() {
		a.c();
	}

	@Override
	public class_ff x_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		var1.q("SpawnPotentials");
		return new class_ft(c, 1, var1);
	}

	@Override
	public boolean c(int var1, int var2) {
		return a.b(var1) ? true : super.c(var1, var2);
	}

	@Override
	public boolean F() {
		return true;
	}

	public class_agf b() {
		return a;
	}
}
