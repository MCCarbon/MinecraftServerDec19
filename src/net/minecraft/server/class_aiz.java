package net.minecraft.server;

import java.util.Random;

public class class_aiz extends Block {
	private class_apr a;

	public class_aiz() {
		super(class_avq.B);
		this.a(class_abp.b);
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.aK;
	}

	@Override
	public int a(Random var1) {
		return 4;
	}

	protected class_apr l() {
		if (a == null) {
			a = class_aps.a().a(new String[] { "##  ##", "##  ##", "  ##  ", " #### ", " #### ", " #  # " }).a('#', class_apq.a(class_apv.a(Blocks.CLAY))).b();
		}

		return a;
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		super.d(var1, var2, var3);
		this.d(var1, var2);
	}

	private void d(class_ago var1, class_cj var2) {
		class_apr.class_b_in_class_apr var3 = l().a(var1, var2);
		if (var3 != null) {
			int var4;
			int var5;
			for (var4 = 0; var4 < l().c(); ++var4) {
				for (var5 = 0; var5 < l().b(); ++var5) {
					var1.a(var3.a(var4, var5, 0).d(), Blocks.AIR.getBlockData(), 2);
				}
			}

			if (!var1.D && (var1.t instanceof class_arh)) {
				class_arg var7 = ((class_arh) var1.t).s();
				if (var7 != null) {
					var7.e();
				}
			}

			for (var4 = 0; var4 < l().c(); ++var4) {
				for (var5 = 0; var5 < l().b(); ++var5) {
					class_apq var6 = var3.a(var4, var5, 0);
					var1.c(var6.d(), Blocks.AIR);
				}
			}
		}

	}
}
