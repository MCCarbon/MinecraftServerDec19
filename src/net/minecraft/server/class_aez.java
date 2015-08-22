package net.minecraft.server;


public class class_aez {
	private String[][] a = new String[][] { { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
	private Object[][] b;

	public class_aez() {
		b = new Object[][] { { class_aim.f, class_aim.e, class_acq.l, class_acq.k, class_acq.m }, { class_acq.q, class_acq.u, class_acq.b, class_acq.y, class_acq.F }, { class_acq.p, class_acq.t, class_acq.a, class_acq.x, class_acq.E }, { class_acq.r, class_acq.v, class_acq.c, class_acq.z, class_acq.G }, { class_acq.K, class_acq.L, class_acq.M, class_acq.N, class_acq.O } };
	}

	public void a(class_aet var1) {
		for (int var2 = 0; var2 < b[0].length; ++var2) {
			Object var3 = b[0][var2];

			for (int var4 = 0; var4 < (b.length - 1); ++var4) {
				class_acm var5 = (class_acm) b[var4 + 1][var2];
				var1.a(new class_aco(var5), new Object[] { a[var4], Character.valueOf('#'), class_acq.A, Character.valueOf('X'), var3 });
			}
		}

		var1.a(new class_aco(class_acq.bg), new Object[] { " #", "# ", Character.valueOf('#'), class_acq.l });
	}
}
