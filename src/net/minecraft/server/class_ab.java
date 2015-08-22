package net.minecraft.server;

import java.util.List;

public class class_ab extends class_i {
	@Override
	public String c() {
		return "enchant";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.enchant.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 2) {
			throw new class_cf("commands.enchant.usage", new Object[0]);
		} else {
			class_lm var3 = a(var1, var2[0]);
			var1.a(class_n.class_a_in_class_n.d, 0);

			class_afj var4;
			try {
				var4 = class_afj.c(a(var2[1], 0));
			} catch (class_cb var11) {
				var4 = class_afj.b(var2[1]);
			}

			if (var4 == null) {
				throw new class_cb("commands.enchant.notFound", new Object[] { Integer.valueOf(class_afj.b(var4)) });
			} else {
				int var5 = 1;
				class_aco var6 = var3.bG();
				if (var6 == null) {
					throw new class_bz("commands.enchant.noItem", new Object[0]);
				} else if (!var4.a(var6)) {
					throw new class_bz("commands.enchant.cantEnchant", new Object[0]);
				} else {
					if (var2.length >= 3) {
						var5 = a(var2[2], var4.d(), var4.b());
					}

					if (var6.n()) {
						class_du var7 = var6.p();
						if (var7 != null) {
							for (int var8 = 0; var8 < var7.c(); ++var8) {
								short var9 = var7.b(var8).g("id");
								if (class_afj.c(var9) != null) {
									class_afj var10 = class_afj.c(var9);
									if (!var4.a(var10)) {
										throw new class_bz("commands.enchant.cantCombine", new Object[] { var4.d(var5), var10.d(var7.b(var8).g("lvl")) });
									}
								}
							}
						}
					}

					var6.a(var4, var5);
					a(var1, this, "commands.enchant.success", new Object[0]);
					var1.a(class_n.class_a_in_class_n.d, 1);
				}
			}
		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, class_afj.b.c()) : null);
	}

	protected String[] d() {
		return MinecraftServer.P().M();
	}

	@Override
	public boolean b(String[] var1, int var2) {
		return var2 == 0;
	}
}
