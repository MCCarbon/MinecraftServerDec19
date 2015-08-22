package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class class_ahi extends class_ahf {
	private class_ahb b;
	private float c;

	public class_ahi(class_ahb var1, float var2) {
		b = var1;
		c = var2;
	}

	@Override
	public class_ahb a(class_cj var1) {
		return b;
	}

	@Override
	public class_ahb[] a(class_ahb[] var1, int var2, int var3, int var4, int var5) {
		if ((var1 == null) || (var1.length < (var4 * var5))) {
			var1 = new class_ahb[var4 * var5];
		}

		Arrays.fill(var1, 0, var4 * var5, b);
		return var1;
	}

	@Override
	public float[] a(float[] var1, int var2, int var3, int var4, int var5) {
		if ((var1 == null) || (var1.length < (var4 * var5))) {
			var1 = new float[var4 * var5];
		}

		Arrays.fill(var1, 0, var4 * var5, c);
		return var1;
	}

	@Override
	public class_ahb[] b(class_ahb[] var1, int var2, int var3, int var4, int var5) {
		if ((var1 == null) || (var1.length < (var4 * var5))) {
			var1 = new class_ahb[var4 * var5];
		}

		Arrays.fill(var1, 0, var4 * var5, b);
		return var1;
	}

	@Override
	public class_ahb[] a(class_ahb[] var1, int var2, int var3, int var4, int var5, boolean var6) {
		return this.b(var1, var2, var3, var4, var5);
	}

	@Override
	public class_cj a(int var1, int var2, int var3, List var4, Random var5) {
		return var4.contains(b) ? new class_cj((var1 - var3) + var5.nextInt((var3 * 2) + 1), 0, (var2 - var3) + var5.nextInt((var3 * 2) + 1)) : null;
	}

	@Override
	public boolean a(int var1, int var2, int var3, List var4) {
		return var4.contains(b);
	}
}
