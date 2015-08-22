package net.minecraft.server;

import java.util.List;

public class class_ad extends class_i {
	@Override
	public String c() {
		return "execute";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(class_m var1) {
		return "commands.execute.usage";
	}

	@Override
	public void a(final class_m var1, String[] var2) throws class_bz {
		if (var2.length < 5) {
			throw new class_cf("commands.execute.usage", new Object[0]);
		} else {
			final class_qx var3 = a(var1, var2[0], class_qx.class);
			final double var4 = b(var3.s, var2[1], false);
			final double var6 = b(var3.t, var2[2], false);
			final double var8 = b(var3.u, var2[3], false);
			final class_cj var10 = new class_cj(var4, var6, var8);
			byte var11 = 4;
			if ("detect".equals(var2[4]) && (var2.length > 10)) {
				class_ago var12 = var3.e();
				double var13 = b(var4, var2[5], false);
				double var15 = b(var6, var2[6], false);
				double var17 = b(var8, var2[7], false);
				class_ail var19 = g(var1, var2[8]);
				int var20 = a(var2[9], -1, 15);
				class_cj var21 = new class_cj(var13, var15, var17);
				class_apn var22 = var12.p(var21);
				if ((var22.c() != var19) || ((var20 >= 0) && (var22.c().c(var22) != var20))) {
					throw new class_bz("commands.execute.failed", new Object[] { "detect", var3.e_() });
				}

				var11 = 10;
			}

			String var24 = a(var2, var11);
			class_m var14 = new class_m() {
				@Override
				public String e_() {
					return var3.e_();
				}

				@Override
				public class_eu f_() {
					return var3.f_();
				}

				@Override
				public void a(class_eu var1x) {
					var1.a(var1x);
				}

				@Override
				public boolean a(int var1x, String var2) {
					return var1.a(var1x, var2);
				}

				@Override
				public class_cj c() {
					return var10;
				}

				@Override
				public class_aym d() {
					return new class_aym(var4, var6, var8);
				}

				@Override
				public class_ago e() {
					return var3.o;
				}

				@Override
				public class_qx f() {
					return var3;
				}

				@Override
				public boolean s_() {
					MinecraftServer var1x = MinecraftServer.P();
					return (var1x == null) || var1x.d[0].S().b("commandBlockOutput");
				}

				@Override
				public void a(class_n.class_a_in_class_n var1x, int var2) {
					var3.a(var1x, var2);
				}
			};
			class_l var25 = MinecraftServer.P().R();

			try {
				int var16 = var25.a(var14, var24);
				if (var16 < 1) {
					throw new class_bz("commands.execute.allInvocationsFailed", new Object[] { var24 });
				}
			} catch (Throwable var23) {
				throw new class_bz("commands.execute.failed", new Object[] { var24, var3.e_() });
			}
		}
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, MinecraftServer.P().M()) : ((var2.length > 1) && (var2.length <= 4) ? a(var2, 1, var3) : ((var2.length > 5) && (var2.length <= 8) && "detect".equals(var2[4]) ? a(var2, 5, var3) : ((var2.length == 9) && "detect".equals(var2[4]) ? a(var2, class_ail.c.c()) : null)));
	}

	@Override
	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
