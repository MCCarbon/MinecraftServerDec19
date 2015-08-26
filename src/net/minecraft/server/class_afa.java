package net.minecraft.server;


public class class_afa {
	private String[][] a = new String[][] { { "X", "X", "#" } };
	private Object[][] b;

	public class_afa() {
		b = new Object[][] { { Blocks.PLANKS, Blocks.COBBLESTONE, Items.l, Items.k, Items.m }, { Items.o, Items.s, Items.n, Items.w, Items.D } };
	}

	public void a(class_aet var1) {
		for (int var2 = 0; var2 < b[0].length; ++var2) {
			Object var3 = b[0][var2];

			for (int var4 = 0; var4 < (b.length - 1); ++var4) {
				Item var5 = (Item) b[var4 + 1][var2];
				var1.a(new class_aco(var5), new Object[] { a[var4], Character.valueOf('#'), Items.A, Character.valueOf('X'), var3 });
			}
		}

		var1.a(new class_aco(Items.f, 1), new Object[] { " #X", "# X", " #X", Character.valueOf('X'), Items.H, Character.valueOf('#'), Items.A });
		var1.a(new class_aco(Items.g, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), Items.I, Character.valueOf('X'), Items.am, Character.valueOf('#'), Items.A });
		var1.a(new class_aco(Items.h, 2), new Object[] { " # ", "#X#", " # ", Character.valueOf('X'), Items.g, Character.valueOf('#'), Items.aV });
	}
}
