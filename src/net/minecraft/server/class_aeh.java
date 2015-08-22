package net.minecraft.server;


public class class_aeh {
	private String[][] a = new String[][] { { "XXX", "X X" }, { "X X", "XXX", "XXX" }, { "XXX", "X X", "X X" }, { "X X", "X X" } };
	private class_acm[][] b;

	public class_aeh() {
		b = new class_acm[][] { { class_acq.aH, class_acq.l, class_acq.k, class_acq.m }, { class_acq.S, class_acq.aa, class_acq.ae, class_acq.ai }, { class_acq.T, class_acq.ab, class_acq.af, class_acq.aj }, { class_acq.U, class_acq.ac, class_acq.ag, class_acq.ak }, { class_acq.V, class_acq.ad, class_acq.ah, class_acq.al } };
	}

	public void a(class_aet var1) {
		for (int var2 = 0; var2 < b[0].length; ++var2) {
			class_acm var3 = b[0][var2];

			for (int var4 = 0; var4 < (b.length - 1); ++var4) {
				class_acm var5 = b[var4 + 1][var2];
				var1.a(new class_aco(var5), new Object[] { a[var4], Character.valueOf('X'), var3 });
			}
		}

	}
}
