package net.minecraft.server;

import java.util.Random;

public class class_arr {
	protected int a = 8;
	protected Random b = new Random();
	protected class_ago c;

	public void a(class_aqk var1, class_ago var2, int var3, int var4, class_arl var5) {
		int var6 = a;
		c = var2;
		b.setSeed(var2.L());
		long var7 = b.nextLong();
		long var9 = b.nextLong();

		for (int var11 = var3 - var6; var11 <= (var3 + var6); ++var11) {
			for (int var12 = var4 - var6; var12 <= (var4 + var6); ++var12) {
				long var13 = var11 * var7;
				long var15 = var12 * var9;
				b.setSeed(var13 ^ var15 ^ var2.L());
				this.a(var2, var11, var12, var3, var4, var5);
			}
		}

	}

	protected void a(class_ago var1, int var2, int var3, int var4, int var5, class_arl var6) {
	}
}
