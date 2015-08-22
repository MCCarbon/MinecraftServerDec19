package net.minecraft.server;


public class class_aez {
	private String[][] a = new String[][] { { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
	private Object[][] b;

	public class_aez() {
		b = new Object[][] { { Blocks.f, Blocks.e, Items.l, Items.k, Items.m }, { Items.q, Items.u, Items.b, Items.y, Items.F }, { Items.p, Items.t, Items.a, Items.x, Items.E }, { Items.r, Items.v, Items.c, Items.z, Items.G }, { Items.K, Items.L, Items.M, Items.N, Items.O } };
	}

	public void a(class_aet var1) {
		for (int var2 = 0; var2 < b[0].length; ++var2) {
			Object var3 = b[0][var2];

			for (int var4 = 0; var4 < (b.length - 1); ++var4) {
				Item var5 = (Item) b[var4 + 1][var2];
				var1.a(new class_aco(var5), new Object[] { a[var4], Character.valueOf('#'), Items.A, Character.valueOf('X'), var3 });
			}
		}

		var1.a(new class_aco(Items.bg), new Object[] { " #", "# ", Character.valueOf('#'), Items.l });
	}
}
