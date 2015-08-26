package net.minecraft.server;


public class class_ade extends Item {
	public class_ade() {
		this.a(class_abp.d);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		boolean var10 = var3.p(var4).c().a(var3, var4);
		class_cj var11 = var10 ? var4 : var4.a(var6);
		if (var2.a(var11, var6, var1) && var3.a(var3.p(var11).c(), var11, false, var6, (Entity) null, var1) && Blocks.REDSTONE_WIRE.c(var3, var11)) {
			--var1.b;
			var3.a(var11, Blocks.REDSTONE_WIRE.S());
			return class_pw.a;
		} else {
			return class_pw.c;
		}
	}
}
