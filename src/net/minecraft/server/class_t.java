package net.minecraft.server;

import java.util.List;

public class class_t extends class_i {
	@Override
	public String c() {
		return "clear";
	}

	@Override
	public String c(class_m var1) {
		return "commands.clear.usage";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		class_lm var3 = var2.length == 0 ? b(var1) : a(var1, var2[0]);
		class_acm var4 = var2.length >= 2 ? f(var1, var2[1]) : null;
		int var5 = var2.length >= 3 ? a(var2[2], -1) : -1;
		int var6 = var2.length >= 4 ? a(var2[3], -1) : -1;
		class_dn var7 = null;
		if (var2.length >= 5) {
			try {
				var7 = class_ed.a(a(var2, 4));
			} catch (class_ec var9) {
				throw new class_bz("commands.clear.tagError", new Object[] { var9.getMessage() });
			}
		}

		if ((var2.length >= 2) && (var4 == null)) {
			throw new class_bz("commands.clear.failure", new Object[] { var3.e_() });
		} else {
			int var8 = var3.bq.a(var4, var5, var6, var7);
			var3.br.b();
			if (!var3.bI.d) {
				var3.p();
			}

			var1.a(class_n.class_a_in_class_n.d, var8);
			if (var8 == 0) {
				throw new class_bz("commands.clear.failure", new Object[] { var3.e_() });
			} else {
				if (var6 == 0) {
					var1.a(new class_fb("commands.clear.testing", new Object[] { var3.e_(), Integer.valueOf(var8) }));
				} else {
					a(var1, this, "commands.clear.success", new Object[] { var3.e_(), Integer.valueOf(var8) });
				}

			}
		}
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, class_acm.e.c()) : null);
	}

	protected String[] d() {
		return MinecraftServer.P().M();
	}

	@Override
	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
