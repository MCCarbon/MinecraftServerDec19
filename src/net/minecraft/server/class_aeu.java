package net.minecraft.server;

import java.util.ArrayList;

import com.google.common.collect.Lists;

public class class_aeu implements class_aes {
	@Override
	public boolean a(class_aab var1, class_ago var2) {
		ArrayList var3 = Lists.newArrayList();

		for (int var4 = 0; var4 < var1.n_(); ++var4) {
			class_aco var5 = var1.a(var4);
			if (var5 != null) {
				var3.add(var5);
				if (var3.size() > 1) {
					class_aco var6 = (class_aco) var3.get(0);
					if ((var5.b() != var6.b()) || (var6.b != 1) || (var5.b != 1) || !var6.b().m()) {
						return false;
					}
				}
			}
		}

		return var3.size() == 2;
	}

	@Override
	public class_aco a(class_aab var1) {
		ArrayList var2 = Lists.newArrayList();

		class_aco var4;
		for (int var3 = 0; var3 < var1.n_(); ++var3) {
			var4 = var1.a(var3);
			if (var4 != null) {
				var2.add(var4);
				if (var2.size() > 1) {
					class_aco var5 = (class_aco) var2.get(0);
					if ((var4.b() != var5.b()) || (var5.b != 1) || (var4.b != 1) || !var5.b().m()) {
						return null;
					}
				}
			}
		}

		if (var2.size() == 2) {
			class_aco var10 = (class_aco) var2.get(0);
			var4 = (class_aco) var2.get(1);
			if ((var10.b() == var4.b()) && (var10.b == 1) && (var4.b == 1) && var10.b().m()) {
				Item var11 = var10.b();
				int var6 = var11.l() - var10.h();
				int var7 = var11.l() - var4.h();
				int var8 = var6 + var7 + ((var11.l() * 5) / 100);
				int var9 = var11.l() - var8;
				if (var9 < 0) {
					var9 = 0;
				}

				return new class_aco(var10.b(), 1, var9);
			}
		}

		return null;
	}

	@Override
	public int a() {
		return 4;
	}

	@Override
	public class_aco b() {
		return null;
	}

	@Override
	public class_aco[] b(class_aab var1) {
		class_aco[] var2 = new class_aco[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class_aco var4 = var1.a(var3);
			if ((var4 != null) && var4.b().r()) {
				var2[var3] = new class_aco(var4.b().q());
			}
		}

		return var2;
	}
}
