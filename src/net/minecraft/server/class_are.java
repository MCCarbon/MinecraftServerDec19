package net.minecraft.server;


public class class_are extends class_arc {
	@Override
	public void b() {
		c = new class_ahi(class_ahb.x, 0.0F);
		d = true;
		e = true;
	}

	@Override
	protected void a() {
		float var1 = 0.1F;

		for (int var2 = 0; var2 <= 15; ++var2) {
			float var3 = 1.0F - (var2 / 15.0F);
			f[var2] = (((1.0F - var3) / ((var3 * 3.0F) + 1.0F)) * (1.0F - var1)) + var1;
		}

	}

	@Override
	public class_aqk c() {
		return new class_arp(b, b.R().r(), b.L());
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean a(int var1, int var2) {
		return false;
	}

	@Override
	public float a(long var1, float var3) {
		return 0.5F;
	}

	@Override
	public boolean e() {
		return false;
	}

	@Override
	public class_aqg o() {
		return new class_aqg() {
			@Override
			public double f() {
				return super.f() / 8.0D;
			}

			@Override
			public double g() {
				return super.g() / 8.0D;
			}
		};
	}

	@Override
	public class_ard p() {
		return class_ard.b;
	}
}
