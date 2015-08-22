package net.minecraft.server;

import java.util.Random;

public class class_ahh extends class_ahb {
	private class_asp aD;
	private class_ato aE;
	private int aF;
	private int aG;
	private int aH;
	private int aI;

	protected class_ahh(int var1, boolean var2) {
		super(var1);
		aD = new class_atf(Blocks.be.S().a(class_alj.a, class_alj.class_a_in_class_alj.a), 9);
		aE = new class_ato(false);
		aF = 0;
		aG = 1;
		aH = 2;
		aI = aF;
		if (var2) {
			as.A = 3;
			aI = aG;
		}

	}

	@Override
	public class_asa a(Random var1) {
		return var1.nextInt(3) > 0 ? aE : super.a(var1);
	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		super.a(var1, var2, var3);
		int var4 = 3 + var2.nextInt(6);

		int var5;
		int var6;
		int var7;
		for (var5 = 0; var5 < var4; ++var5) {
			var6 = var2.nextInt(16);
			var7 = var2.nextInt(28) + 4;
			int var8 = var2.nextInt(16);
			class_cj var9 = var3.a(var6, var7, var8);
			if (var1.p(var9).c() == Blocks.b) {
				var1.a(var9, Blocks.bP.S(), 2);
			}
		}

		for (var4 = 0; var4 < 7; ++var4) {
			var5 = var2.nextInt(16);
			var6 = var2.nextInt(64);
			var7 = var2.nextInt(16);
			aD.b(var1, var2, var3.a(var5, var6, var7));
		}

	}

	@Override
	public void a(class_ago var1, Random var2, class_arl var3, int var4, int var5, double var6) {
		ak = Blocks.c.S();
		al = Blocks.d.S();
		if (((var6 < -1.0D) || (var6 > 2.0D)) && (aI == aH)) {
			ak = Blocks.n.S();
			al = Blocks.n.S();
		} else if ((var6 > 1.0D) && (aI != aG)) {
			ak = Blocks.b.S();
			al = Blocks.b.S();
		}

		this.b(var1, var2, var3, var4, var5, var6);
	}

	private class_ahh b(class_ahb var1) {
		aI = aH;
		this.a(var1.ai, true);
		this.a(var1.ah + " M");
		this.a(new class_ahb.class_a_in_class_ahb(var1.an, var1.ao));
		this.a(var1.ap, var1.aq);
		return this;
	}

	@Override
	protected class_ahb d(int var1) {
		return (new class_ahh(var1, false)).b(this);
	}
}
