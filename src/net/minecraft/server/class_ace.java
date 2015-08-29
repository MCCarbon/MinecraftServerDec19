package net.minecraft.server;


public class class_ace extends Item {
	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (!var3.D) {
			EntityFireworks var10 = new EntityFireworks(var3, var4.n() + var7, var4.o() + var8, var4.p() + var9, var1);
			var3.a(var10);
			if (!var2.bI.d) {
				--var1.b;
			}
		}

		return class_pw.a;
	}
}
