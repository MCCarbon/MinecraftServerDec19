package net.minecraft.server;

import java.util.Random;

public class class_asn extends class_asp {
	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		int var4 = var2.nextInt(3) + 4;
		float var5 = var4;

		for (int var6 = 0; var5 > 0.5F; --var6) {
			for (int var7 = MathHelper.d(-var5); var7 <= MathHelper.f(var5); ++var7) {
				for (int var8 = MathHelper.d(-var5); var8 <= MathHelper.f(var5); ++var8) {
					if ((var7 * var7) + (var8 * var8) <= ((var5 + 1.0F) * (var5 + 1.0F))) {
						a(var1, var3.a(var7, var6, var8), Blocks.END_STONE.S());
					}
				}
			}

			var5 = (float) (var5 - (var2.nextInt(2) + 0.5D));
		}

		return true;
	}
}
