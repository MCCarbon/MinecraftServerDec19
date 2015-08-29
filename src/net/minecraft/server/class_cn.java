package net.minecraft.server;


public class class_cn implements class_cr {
	@Override
	public final class_aco a(class_ck var1, class_aco var2) {
		class_aco var3 = b(var1, var2);
		this.a(var1);
		this.a(var1, class_ajm.b(var1.f()));
		return var3;
	}

	protected class_aco b(class_ck var1, class_aco var2) {
		class_cq var3 = class_ajm.b(var1.f());
		class_cz var4 = class_ajm.a(var1);
		class_aco var5 = var2.a(1);
		a(var1.i(), var5, 6, var3, var4);
		return var2;
	}

	public static void a(class_ago var0, class_aco var1, int var2, class_cq var3, class_cz var4) {
		double var5 = var4.a();
		double var7 = var4.b();
		double var9 = var4.c();
		if (var3.k() == class_cq.class_a_in_class_cq.b) {
			var7 -= 0.125D;
		} else {
			var7 -= 0.15625D;
		}

		EntityItem var11 = new EntityItem(var0, var5, var7, var9, var1);
		double var12 = (var0.s.nextDouble() * 0.1D) + 0.2D;
		var11.v = var3.g() * var12;
		var11.w = 0.20000000298023224D;
		var11.x = var3.i() * var12;
		var11.v += var0.s.nextGaussian() * 0.007499999832361937D * var2;
		var11.w += var0.s.nextGaussian() * 0.007499999832361937D * var2;
		var11.x += var0.s.nextGaussian() * 0.007499999832361937D * var2;
		var0.a(var11);
	}

	protected void a(class_ck var1) {
		var1.i().b(1000, var1.d(), 0);
	}

	protected void a(class_ck var1, class_cq var2) {
		var1.i().b(2000, var1.d(), this.a(var2));
	}

	private int a(class_cq var1) {
		return var1.g() + 1 + ((var1.i() + 1) * 3);
	}
}
