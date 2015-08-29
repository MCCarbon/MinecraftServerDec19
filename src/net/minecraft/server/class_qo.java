package net.minecraft.server;


public class class_qo extends class_qq {
	public class_qo(boolean var1, int var2) {
		super(var1, var2);
	}

	@Override
	public void a(EntityLiving var1, class_rt var2, int var3) {
		super.a(var1, var2, var3);
		if (var1.bu() > var1.bB()) {
			var1.c(var1.bB());
		}

	}
}
