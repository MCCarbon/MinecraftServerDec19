package net.minecraft.server;

import java.util.List;

public class CommandEffect extends CommandAbstract {
	@Override
	public String getCommand() {
		return "effect";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.effect.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 2) {
			throw new class_cf("commands.effect.usage", new Object[0]);
		} else {
			EntityLiving var3 = (EntityLiving) a(var1, var2[0], EntityLiving.class);
			if (var2[1].equals("clear")) {
				if (var3.bs().isEmpty()) {
					throw new class_bz("commands.effect.failure.notActive.all", new Object[] { var3.e_() });
				} else {
					var3.br();
					a(var1, this, "commands.effect.success.removed.all", new Object[] { var3.e_() });
				}
			} else {
				class_qq var4;
				try {
					var4 = class_qq.a(a(var2[1], 1));
				} catch (class_cb var10) {
					var4 = class_qq.b(var2[1]);
				}

				if (var4 == null) {
					throw new class_cb("commands.effect.notFound", new Object[] { var2[1] });
				} else {
					int var5 = 600;
					int var6 = 30;
					int var7 = 0;
					if (var2.length >= 3) {
						var6 = a(var2[2], 0, 1000000);
						if (var4.b()) {
							var5 = var6;
						} else {
							var5 = var6 * 20;
						}
					} else if (var4.b()) {
						var5 = 1;
					}

					if (var2.length >= 4) {
						var7 = a(var2[3], 0, 255);
					}

					boolean var8 = true;
					if ((var2.length >= 5) && "true".equalsIgnoreCase(var2[4])) {
						var8 = false;
					}

					if (var6 > 0) {
						class_qr var9 = new class_qr(var4, var5, var7, false, var8);
						var3.c(var9);
						a(var1, this, "commands.effect.success", new Object[] { new class_fb(var9.f(), new Object[0]), Integer.valueOf(class_qq.a(var4)), Integer.valueOf(var7), var3.e_(), Integer.valueOf(var6) });
					} else if (var3.a(var4)) {
						var3.d(var4);
						a(var1, this, "commands.effect.success.removed", new Object[] { new class_fb(var4.a(), new Object[0]), var3.e_() });
					} else {
						throw new class_bz("commands.effect.failure.notActive", new Object[] { new class_fb(var4.a(), new Object[0]), var3.e_() });
					}
				}
			}
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, class_qq.b.c()) : (var2.length == 5 ? a(var2, new String[] { "true", "false" }) : null));
	}

	protected String[] d() {
		return MinecraftServer.P().M();
	}

	@Override
	public boolean isListStart(String[] var1, int var2) {
		return var2 == 0;
	}
}
