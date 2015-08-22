package net.minecraft.server;


public class class_aeh {
	private String[][] a = new String[][] { { "XXX", "X X" }, { "X X", "XXX", "XXX" }, { "XXX", "X X", "X X" }, { "X X", "X X" } };
	private Item[][] b;

	public class_aeh() {
		b = new Item[][] { { Items.aH, Items.l, Items.k, Items.m }, { Items.S, Items.aa, Items.ae, Items.ai }, { Items.T, Items.ab, Items.af, Items.aj }, { Items.U, Items.ac, Items.ag, Items.ak }, { Items.V, Items.ad, Items.ah, Items.al } };
	}

	public void a(class_aet var1) {
		for (int var2 = 0; var2 < b[0].length; ++var2) {
			Item var3 = b[0][var2];

			for (int var4 = 0; var4 < (b.length - 1); ++var4) {
				Item var5 = b[var4 + 1][var2];
				var1.a(new class_aco(var5), new Object[] { a[var4], Character.valueOf('X'), var3 });
			}
		}

	}
}
