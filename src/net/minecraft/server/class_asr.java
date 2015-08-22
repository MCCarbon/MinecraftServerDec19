package net.minecraft.server;

import java.util.Random;

public class class_asr extends class_atr {
	private final class_apn a;
	private final class_apn b;

	public class_asr(class_apn var1, class_apn var2) {
		super(false);
		b = var1;
		a = var2;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		class_ail var4;
		while ((((var4 = var1.p(var3).c()).v() == class_avq.a) || (var4.v() == class_avq.j)) && (var3.o() > 0)) {
			var3 = var3.b();
		}

		class_ail var5 = var1.p(var3).c();
		if ((var5 == class_aim.d) || (var5 == class_aim.c)) {
			var3 = var3.a();
			this.a(var1, var3, b);

			for (int var6 = var3.o(); var6 <= (var3.o() + 2); ++var6) {
				int var7 = var6 - var3.o();
				int var8 = 2 - var7;

				for (int var9 = var3.n() - var8; var9 <= (var3.n() + var8); ++var9) {
					int var10 = var9 - var3.n();

					for (int var11 = var3.p() - var8; var11 <= (var3.p() + var8); ++var11) {
						int var12 = var11 - var3.p();
						if ((Math.abs(var10) != var8) || (Math.abs(var12) != var8) || (var2.nextInt(2) != 0)) {
							class_cj var13 = new class_cj(var9, var6, var11);
							if (!var1.p(var13).c().q()) {
								this.a(var1, var13, a);
							}
						}
					}
				}
			}
		}

		return true;
	}
}
