package net.minecraft.server;


public class class_aor extends TileEntity implements class_ks {
	public float a;
	public float f;
	public int g;
	private int h;

	@Override
	public void c() {
		if (((++h % 20) * 4) == 0) {
			b.c(c, Blocks.ENDER_CHEST, 1, g);
		}

		f = a;
		int var1 = c.n();
		int var2 = c.o();
		int var3 = c.p();
		float var4 = 0.1F;
		double var7;
		if ((g > 0) && (a == 0.0F)) {
			double var5 = var1 + 0.5D;
			var7 = var3 + 0.5D;
			b.a(var5, var2 + 0.5D, var7, "random.chestopen", 0.5F, (b.s.nextFloat() * 0.1F) + 0.9F);
		}

		if (((g == 0) && (a > 0.0F)) || ((g > 0) && (a < 1.0F))) {
			float var11 = a;
			if (g > 0) {
				a += var4;
			} else {
				a -= var4;
			}

			if (a > 1.0F) {
				a = 1.0F;
			}

			float var6 = 0.5F;
			if ((a < var6) && (var11 >= var6)) {
				var7 = var1 + 0.5D;
				double var9 = var3 + 0.5D;
				b.a(var7, var2 + 0.5D, var9, "random.chestclosed", 0.5F, (b.s.nextFloat() * 0.1F) + 0.9F);
			}

			if (a < 0.0F) {
				a = 0.0F;
			}
		}

	}

	@Override
	public boolean c(int var1, int var2) {
		if (var1 == 1) {
			g = var2;
			return true;
		} else {
			return super.c(var1, var2);
		}
	}

	@Override
	public void y() {
		E();
		super.y();
	}

	public void b() {
		++g;
		b.c(c, Blocks.ENDER_CHEST, 1, g);
	}

	public void d() {
		--g;
		b.c(c, Blocks.ENDER_CHEST, 1, g);
	}

	public boolean a(class_yu var1) {
		return b.s(c) != this ? false : var1.e(c.n() + 0.5D, c.o() + 0.5D, c.p() + 0.5D) <= 64.0D;
	}
}
