package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_bu extends class_i {
	@Override
	public String c() {
		return "trigger";
	}

	@Override
	public int a() {
		return 0;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.trigger.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 3) {
			throw new class_cf("commands.trigger.usage", new Object[0]);
		} else {
			class_lm var3;
			if (var1 instanceof class_lm) {
				var3 = (class_lm) var1;
			} else {
				Entity var4 = var1.f();
				if (!(var4 instanceof class_lm)) {
					throw new class_bz("commands.trigger.invalidPlayer", new Object[0]);
				}

				var3 = (class_lm) var4;
			}

			class_ays var8 = MinecraftServer.P().a(0).ab();
			class_ayo var5 = var8.b(var2[0]);
			if ((var5 != null) && (var5.c() == class_ayy.c)) {
				int var6 = a(var2[2]);
				if (!var8.b(var3.e_(), var5)) {
					throw new class_bz("commands.trigger.invalidObjective", new Object[] { var2[0] });
				} else {
					class_ayq var7 = var8.c(var3.e_(), var5);
					if (var7.g()) {
						throw new class_bz("commands.trigger.disabled", new Object[] { var2[0] });
					} else {
						if ("set".equals(var2[1])) {
							var7.c(var6);
						} else {
							if (!"add".equals(var2[1])) {
								throw new class_bz("commands.trigger.invalidMode", new Object[] { var2[1] });
							}

							var7.a(var6);
						}

						var7.a(true);
						if (var3.c.d()) {
							a(var1, this, "commands.trigger.success", new Object[] { var2[0], var2[1], var2[2] });
						}

					}
				}
			} else {
				throw new class_bz("commands.trigger.invalidObjective", new Object[] { var2[0] });
			}
		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		if (var2.length == 1) {
			class_ays var4 = MinecraftServer.P().a(0).ab();
			ArrayList var5 = Lists.newArrayList();
			Iterator var6 = var4.c().iterator();

			while (var6.hasNext()) {
				class_ayo var7 = (class_ayo) var6.next();
				if (var7.c() == class_ayy.c) {
					var5.add(var7.b());
				}
			}

			return a(var2, (String[]) var5.toArray(new String[var5.size()]));
		} else {
			return var2.length == 2 ? a(var2, new String[] { "add", "set" }) : null;
		}
	}
}
