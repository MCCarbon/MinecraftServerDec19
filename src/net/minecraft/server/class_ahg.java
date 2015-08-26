package net.minecraft.server;

import java.util.Random;

public class class_ahg extends class_ahb {
	public class_ahg(int var1) {
		super(var1);
		au.clear();
		ak = Blocks.SAND.S();
		al = Blocks.SAND.S();
		as.A = -999;
		as.D = 2;
		as.F = 50;
		as.G = 10;
		au.clear();
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		super.a(var1, var2, var3);
		if (var2.nextInt(1000) == 0) {
			int var4 = var2.nextInt(16) + 8;
			int var5 = var2.nextInt(16) + 8;
			class_cj var6 = var1.m(var3.a(var4, 0, var5)).a();
			(new class_ask()).b(var1, var2, var6);
		}

	}
}
