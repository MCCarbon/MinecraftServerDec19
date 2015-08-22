package net.minecraft.server;

import java.io.File;

public class class_axo extends class_axr {
	public class_axo(File var1, String var2, boolean var3, class_oo var4) {
		super(var1, var2, var3, var4);
	}

	@Override
	public class_aqt a(class_arc var1) {
		File var2 = this.b();
		File var3;
		if (var1 instanceof class_are) {
			var3 = new File(var2, "DIM-1");
			var3.mkdirs();
			return new class_aqz(var3, a);
		} else if (var1 instanceof class_arh) {
			var3 = new File(var2, "DIM1");
			var3.mkdirs();
			return new class_aqz(var3, a);
		} else {
			return new class_aqz(var2, a);
		}
	}

	@Override
	public void a(class_axt var1, class_dn var2) {
		var1.e(19133);
		super.a(var1, var2);
	}

	@Override
	public void a() {
		try {
			class_ayg.a().b();
		} catch (InterruptedException var2) {
			var2.printStackTrace();
		}

		class_aqy.a();
	}
}
