package net.minecraft.server;

import java.util.Random;

public class BlockStationary extends class_alf {
	protected BlockStationary(class_avq var1) {
		super(var1);
		this.a(false);
		if (var1 == class_avq.i) {
			this.a(true);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!this.f(var1, var2, var3)) {
			this.g(var1, var2, var3);
		}

	}

	private void g(class_ago var1, class_cj var2, class_apn var3) {
		BlockFlowing var4 = a(J);
		var1.a(var2, var4.S().a(b, var3.b(b)), 2);
		var1.a(var2, var4, this.a(var1));
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (J == class_avq.i) {
			if (var1.S().b("doFireTick")) {
				int var5 = var4.nextInt(3);
				if (var5 > 0) {
					class_cj var6 = var2;

					for (int var7 = 0; var7 < var5; ++var7) {
						var6 = var6.a(var4.nextInt(3) - 1, 1, var4.nextInt(3) - 1);
						Block var8 = var1.p(var6).c();
						if (var8.J == class_avq.a) {
							if (this.e(var1, var6)) {
								var1.a(var6, Blocks.ab.S());
								return;
							}
						} else if (var8.J.c()) {
							return;
						}
					}
				} else {
					for (int var9 = 0; var9 < 3; ++var9) {
						class_cj var10 = var2.a(var4.nextInt(3) - 1, 0, var4.nextInt(3) - 1);
						if (var1.d(var10.a()) && this.k(var1, var10)) {
							var1.a(var10.a(), Blocks.ab.S());
						}
					}
				}

			}
		}
	}

	protected boolean e(class_ago var1, class_cj var2) {
		class_cq[] var3 = class_cq.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_cq var6 = var3[var5];
			if (this.k(var1, var2.a(var6))) {
				return true;
			}
		}

		return false;
	}

	private boolean k(class_ago var1, class_cj var2) {
		return var1.p(var2).c().v().h();
	}
}
