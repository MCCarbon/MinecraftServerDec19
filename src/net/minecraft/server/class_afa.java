package net.minecraft.server;


public class class_afa {
	private String[][] a = new String[][] { { "X", "X", "#" } };
	private Object[][] b;

	public class_afa() {
		b = new Object[][] { { class_aim.f, class_aim.e, class_acq.l, class_acq.k, class_acq.m }, { class_acq.o, class_acq.s, class_acq.n, class_acq.w, class_acq.D } };
	}

	public void a(class_aet var1) {
		for (int var2 = 0; var2 < b[0].length; ++var2) {
			Object var3 = b[0][var2];

			for (int var4 = 0; var4 < (b.length - 1); ++var4) {
				class_acm var5 = (class_acm) b[var4 + 1][var2];
				var1.a(new class_aco(var5), new Object[] { a[var4], Character.valueOf('#'), class_acq.A, Character.valueOf('X'), var3 });
			}
		}

		var1.a(new class_aco(class_acq.f, 1), new Object[] { " #X", "# X", " #X", Character.valueOf('X'), class_acq.H, Character.valueOf('#'), class_acq.A });
		var1.a(new class_aco(class_acq.g, 4), new Object[] { "X", "#", "Y", Character.valueOf('Y'), class_acq.I, Character.valueOf('X'), class_acq.am, Character.valueOf('#'), class_acq.A });
		var1.a(new class_aco(class_acq.h, 2), new Object[] { " # ", "#X#", " # ", Character.valueOf('X'), class_acq.g, Character.valueOf('#'), class_acq.aV });
	}
}
