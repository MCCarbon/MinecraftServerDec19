package net.minecraft.server;

import java.util.Random;

public class class_ajz extends Block {
	public static boolean N;

	public class_ajz() {
		super(class_avq.p);
		this.a(class_abp.b);
	}

	public class_ajz(class_avq var1) {
		super(var1);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		var1.a(var2, this, this.a(var1));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		var1.a(var2, this, this.a(var1));
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			this.e(var1, var2);
		}

	}

	private void e(class_ago var1, class_cj var2) {
		if (d(var1, var2.b()) && (var2.o() >= 0)) {
			byte var3 = 32;
			if (!N && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
				if (!var1.D) {
					EntityFallingBlock var5 = new EntityFallingBlock(var1, var2.n() + 0.5D, var2.o(), var2.p() + 0.5D, var1.p(var2));
					this.a(var5);
					var1.a(var5);
				}
			} else {
				var1.g(var2);

				class_cj var4;
				for (var4 = var2.b(); d(var1, var4) && (var4.o() > 0); var4 = var4.b()) {
					;
				}

				if (var4.o() > 0) {
					var1.a(var4.a(), getBlockData());
				}
			}

		}
	}

	protected void a(EntityFallingBlock var1) {
	}

	@Override
	public int a(class_ago var1) {
		return 2;
	}

	public static boolean d(class_ago var0, class_cj var1) {
		Block var2 = var0.p(var1).c();
		class_avq var3 = var2.J;
		return (var2 == Blocks.FIRE) || (var3 == class_avq.a) || (var3 == class_avq.h) || (var3 == class_avq.i);
	}

	public void a_(class_ago var1, class_cj var2) {
	}
}
