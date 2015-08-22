package net.minecraft.server;


public class class_aer {
	private Object[][] a;

	public class_aer() {
		a = new Object[][] { { Blocks.R, new class_aco(Items.m, 9) }, { Blocks.S, new class_aco(Items.l, 9) }, { Blocks.ah, new class_aco(Items.k, 9) }, { Blocks.bT, new class_aco(Items.bT, 9) }, { Blocks.y, new class_aco(Items.aY, 9, class_abt.l.b()) }, { Blocks.cn, new class_aco(Items.aE, 9) }, { Blocks.cA, new class_aco(Items.j, 9, 0) }, { Blocks.cx, new class_aco(Items.Q, 9) }, { Blocks.cE, new class_aco(Items.aO, 9) } };
	}

	public void a(class_aet var1) {
		for (int var2 = 0; var2 < a.length; ++var2) {
			Block var3 = (Block) a[var2][0];
			class_aco var4 = (class_aco) a[var2][1];
			var1.a(new class_aco(var3), new Object[] { "###", "###", "###", Character.valueOf('#'), var4 });
			var1.a(var4, new Object[] { "#", Character.valueOf('#'), var3 });
		}

		var1.a(new class_aco(Items.m), new Object[] { "###", "###", "###", Character.valueOf('#'), Items.bz });
		var1.a(new class_aco(Items.bz, 9), new Object[] { "#", Character.valueOf('#'), Items.m });
	}
}
