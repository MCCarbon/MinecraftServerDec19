package net.minecraft.server;


public class class_abk extends class_aci {
	public class_abk(int var1, float var2) {
		super(var1, var2, false);
	}

	@Override
	public class_aco a(class_aco var1, class_ago var2, EntityLiving var3) {
		class_aco var4 = super.a(var1, var2, var3);

		for (int var5 = 0; var5 < 16; ++var5) {
			double var6 = var3.s + ((var3.bj().nextDouble() - 0.5D) * 64.0D);
			double var8 = MathHelper.a(var3.t + (var3.bj().nextInt(64) - 32), 0.0D, var2.X() - 1);
			double var10 = var3.u + ((var3.bj().nextDouble() - 0.5D) * 64.0D);
			if (EntityEnderman.a(var3, var6, var8, var10)) {
				break;
			}
		}

		if (var3 instanceof class_yu) {
			((class_yu) var3).cB().a(this, 20);
		}

		return var4;
	}
}
