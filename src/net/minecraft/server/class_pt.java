package net.minecraft.server;


public class class_pt {
	private final class_ps a;
	private final float b;

	public class_pt(class_ps var1, long var2, long var4, float var6) {
		a = var1;
		b = a(var1, var2, var4, var6);
	}

	public float c() {
		return b < 2.0F ? 0.0F : (b > 4.0F ? 1.0F : (b - 2.0F) / 2.0F);
	}

	private float a(class_ps var1, long var2, long var4, float var6) {
		if (var1 == class_ps.a) {
			return 0.0F;
		} else {
			boolean var7 = var1 == class_ps.d;
			float var8 = 0.75F;
			float var9 = MathHelper.a((var2 + -72000.0F) / 1440000.0F, 0.0F, 1.0F) * 0.25F;
			var8 += var9;
			float var10 = 0.0F;
			var10 += MathHelper.a(var4 / 3600000.0F, 0.0F, 1.0F) * (var7 ? 1.0F : 0.75F);
			var10 += MathHelper.a(var6 * 0.25F, 0.0F, var9);
			if (var1 == class_ps.b) {
				var10 *= 0.5F;
			}

			var8 += var10;
			return var1.a() * var8;
		}
	}
}
