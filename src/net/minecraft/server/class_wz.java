package net.minecraft.server;

import java.util.Random;

public class class_wz extends class_oi.class_a_in_class_oi {
	private final class_aco b;
	private float c;
	private boolean d;

	public class_wz(class_aco var1, int var2) {
		super(var2);
		b = var1;
	}

	public class_aco a(Random var1) {
		class_aco var2 = b.k();
		if (c > 0.0F) {
			int var3 = (int) (c * b.j());
			int var4 = var2.j() - var1.nextInt(var1.nextInt(var3) + 1);
			if (var4 > var3) {
				var4 = var3;
			}

			if (var4 < 1) {
				var4 = 1;
			}

			var2.b(var4);
		}

		if (d) {
			class_afl.a(var1, var2, 30);
		}

		return var2;
	}

	public class_wz a(float var1) {
		c = var1;
		return this;
	}

	public class_wz a() {
		d = true;
		return this;
	}
}
