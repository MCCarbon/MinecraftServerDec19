package net.minecraft.server;


public class class_agx implements class_ags {
	protected int a;
	protected int b;
	protected class_aqn[][] c;
	protected boolean d;
	protected class_ago e;

	public class_agx(class_ago var1, class_cj var2, class_cj var3, int var4) {
		e = var1;
		a = (var2.n() - var4) >> 4;
		b = (var2.p() - var4) >> 4;
		int var5 = (var3.n() + var4) >> 4;
		int var6 = (var3.p() + var4) >> 4;
		c = new class_aqn[(var5 - a) + 1][(var6 - b) + 1];
		d = true;

		int var7;
		int var8;
		for (var7 = a; var7 <= var5; ++var7) {
			for (var8 = b; var8 <= var6; ++var8) {
				c[var7 - a][var8 - b] = var1.a(var7, var8);
			}
		}

		for (var7 = var2.n() >> 4; var7 <= (var3.n() >> 4); ++var7) {
			for (var8 = var2.p() >> 4; var8 <= (var3.p() >> 4); ++var8) {
				class_aqn var9 = c[var7 - a][var8 - b];
				if ((var9 != null) && !var9.c(var2.o(), var3.o())) {
					d = false;
				}
			}
		}

	}

	@Override
	public TileEntity s(class_cj var1) {
		int var2 = (var1.n() >> 4) - a;
		int var3 = (var1.p() >> 4) - b;
		return c[var2][var3].a(var1, class_aqn.class_a_in_class_aqn.a);
	}

	@Override
	public class_apn p(class_cj var1) {
		if ((var1.o() >= 0) && (var1.o() < 256)) {
			int var2 = (var1.n() >> 4) - a;
			int var3 = (var1.p() >> 4) - b;
			if ((var2 >= 0) && (var2 < c.length) && (var3 >= 0) && (var3 < c[var2].length)) {
				class_aqn var4 = c[var2][var3];
				if (var4 != null) {
					return var4.g(var1);
				}
			}
		}

		return Blocks.AIR.getBlockData();
	}

	@Override
	public boolean d(class_cj var1) {
		return p(var1).c().v() == class_avq.a;
	}

	@Override
	public int a(class_cj var1, class_cq var2) {
		class_apn var3 = p(var1);
		return var3.c().b(this, var1, var3, var2);
	}
}
