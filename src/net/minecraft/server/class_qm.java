package net.minecraft.server;


public class class_qm extends class_qq {
	protected class_qm(boolean var1, int var2) {
		super(var1, var2);
	}

	@Override
	public void a(class_rg var1, class_rt var2, int var3) {
		var1.n(var1.bU() - 4 * (var3 + 1));
		super.a(var1, var2, var3);
	}

	@Override
	public void b(class_rg var1, class_rt var2, int var3) {
		var1.n(var1.bU() + 4 * (var3 + 1));
		super.b(var1, var2, var3);
	}
}
