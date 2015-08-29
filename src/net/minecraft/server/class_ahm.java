package net.minecraft.server;

import java.util.Random;

public class class_ahm extends class_ahb {
	private boolean aD;
	private static final class_apn aE;
	private static final class_apn aF;
	private static final class_apn aG;

	public class_ahm(int var1, boolean var2) {
		super(var1);
		aD = var2;
		if (var2) {
			as.A = 2;
		} else {
			as.A = 50;
		}

		as.C = 25;
		as.B = 4;
		if (!var2) {
			at.add(new class_ahb.class_c_in_class_ahb(EntityOcelot.class, 2, 1, 1));
		}

		au.add(new class_ahb.class_c_in_class_ahb(EntityChicken.class, 10, 4, 4));
	}

	@Override
	public class_asa a(Random var1) {
		return var1.nextInt(10) == 0 ? aB : (var1.nextInt(2) == 0 ? new class_asr(aE, aG) : (!aD && (var1.nextInt(3) == 0) ? new class_ata(false, 10, 20, aE, aF) : new class_atr(false, 4 + var1.nextInt(7), aE, aF, true)));
	}

	@Override
	public class_asp b(Random var1) {
		return var1.nextInt(4) == 0 ? new class_atq(BlockLongGrass.class_a_in_class_ano.c) : new class_atq(BlockLongGrass.class_a_in_class_ano.b);
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		super.a(var1, var2, var3);
		int var4 = var2.nextInt(16) + 8;
		int var5 = var2.nextInt(16) + 8;
		int var6 = var2.nextInt(var1.m(var3.a(var4, 0, var5)).o() * 2);
		(new class_atd()).b(var1, var2, var3.a(var4, var6, var5));
		class_ats var9 = new class_ats();

		for (var5 = 0; var5 < 50; ++var5) {
			var6 = var2.nextInt(16) + 8;
			boolean var7 = true;
			int var8 = var2.nextInt(16) + 8;
			var9.b(var1, var2, var3.a(var6, 128, var8));
		}

	}

	static {
		aE = Blocks.LOG.getBlockData().a(class_alv.b, class_aly.class_a_in_class_aly.d);
		aF = Blocks.LEAVES.getBlockData().a(class_alu.P, class_aly.class_a_in_class_aly.d).a(class_alc.b, Boolean.valueOf(false));
		aG = Blocks.LEAVES.getBlockData().a(class_alu.P, class_aly.class_a_in_class_aly.a).a(class_alc.b, Boolean.valueOf(false));
	}
}
