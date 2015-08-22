package net.minecraft.server;


public class class_aer {
	private Object[][] a;

	public class_aer() {
		a = new Object[][] { { class_aim.R, new class_aco(class_acq.m, 9) }, { class_aim.S, new class_aco(class_acq.l, 9) }, { class_aim.ah, new class_aco(class_acq.k, 9) }, { class_aim.bT, new class_aco(class_acq.bT, 9) }, { class_aim.y, new class_aco(class_acq.aY, 9, class_abt.l.b()) }, { class_aim.cn, new class_aco(class_acq.aE, 9) }, { class_aim.cA, new class_aco(class_acq.j, 9, 0) }, { class_aim.cx, new class_aco(class_acq.Q, 9) }, { class_aim.cE, new class_aco(class_acq.aO, 9) } };
	}

	public void a(class_aet var1) {
		for (int var2 = 0; var2 < a.length; ++var2) {
			class_ail var3 = (class_ail) a[var2][0];
			class_aco var4 = (class_aco) a[var2][1];
			var1.a(new class_aco(var3), new Object[] { "###", "###", "###", Character.valueOf('#'), var4 });
			var1.a(var4, new Object[] { "#", Character.valueOf('#'), var3 });
		}

		var1.a(new class_aco(class_acq.m), new Object[] { "###", "###", "###", Character.valueOf('#'), class_acq.bz });
		var1.a(new class_aco(class_acq.bz, 9), new Object[] { "#", Character.valueOf('#'), class_acq.m });
	}
}
