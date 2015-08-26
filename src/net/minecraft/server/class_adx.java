package net.minecraft.server;


public class class_adx extends class_aax {
	@Override
	public class_yx a(class_ago var1, class_aco var2, class_rg var3) {
		return new class_zo(var1, var3, var2);
	}

	@Override
	public String a(class_aco var1) {
		return class_di.a("tipped_arrow.effect." + ((class_ke) PotionRegistry.a.b(class_adb.i(var1))).a());
	}
}
