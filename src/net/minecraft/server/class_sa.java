package net.minecraft.server;


public class class_sa {
	private EntityLiving a;
	private int b;
	private float c;

	public class_sa(EntityLiving var1) {
		a = var1;
	}

	public void a() {
		double var1 = a.s - a.p;
		double var3 = a.u - a.r;
		if (((var1 * var1) + (var3 * var3)) > 2.500000277905201E-7D) {
			a.aM = a.y;
			a.aO = this.a(a.aM, a.aO, 75.0F);
			c = a.aO;
			b = 0;
		} else {
			float var5 = 75.0F;
			if (Math.abs(a.aO - c) > 15.0F) {
				b = 0;
				c = a.aO;
			} else {
				++b;
				boolean var6 = true;
				if (b > 10) {
					var5 = Math.max(1.0F - ((b - 10) / 10.0F), 0.0F) * 75.0F;
				}
			}

			a.aM = this.a(a.aO, a.aM, var5);
		}
	}

	private float a(float var1, float var2, float var3) {
		float var4 = MathHelper.g(var1 - var2);
		if (var4 < -var3) {
			var4 = -var3;
		}

		if (var4 >= var3) {
			var4 = var3;
		}

		return var1 - var4;
	}
}
