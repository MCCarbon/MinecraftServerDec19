package net.minecraft.server;


public class class_aaf extends class_aas {
	public class_aaf(class_pp var1, int var2, int var3, int var4) {
		super(var1, var2, var3, var4);
	}

	@Override
	public boolean a(class_aco var1) {
		return class_aot.c(var1) || c_(var1);
	}

	@Override
	public int b(class_aco var1) {
		return c_(var1) ? 1 : super.b(var1);
	}

	public static boolean c_(class_aco var0) {
		return (var0 != null) && (var0.b() != null) && (var0.b() == Items.ay);
	}
}
