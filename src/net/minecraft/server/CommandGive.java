package net.minecraft.server;

import java.util.List;

public class CommandGive extends CommandAbstract {
	@Override
	public String getCommand() {
		return "give";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.give.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 2) {
			throw new class_cf("commands.give.usage", new Object[0]);
		} else {
			class_lm var3 = a(var1, var2[0]);
			Item var4 = f(var1, var2[1]);
			int var5 = var2.length >= 3 ? a(var2[2], 1, 64) : 1;
			int var6 = var2.length >= 4 ? a(var2[3]) : 0;
			class_aco var7 = new class_aco(var4, var5, var6);
			if (var2.length >= 5) {
				String var8 = a(var1, var2, 4).c();

				try {
					var7.d(class_ed.a(var8));
				} catch (class_ec var10) {
					throw new class_bz("commands.give.tagError", new Object[] { var10.getMessage() });
				}
			}

			boolean var11 = var3.bq.a(var7);
			if (var11) {
				var3.o.a((Entity) var3, "random.pop", 0.2F, (((var3.bj().nextFloat() - var3.bj().nextFloat()) * 0.7F) + 1.0F) * 2.0F);
				var3.br.b();
			}

			class_xg var9;
			if (var11 && (var7.b <= 0)) {
				var7.b = 1;
				var1.a(class_n.class_a_in_class_n.d, var5);
				var9 = var3.a(var7, false);
				if (var9 != null) {
					var9.u();
				}
			} else {
				var1.a(class_n.class_a_in_class_n.d, var5 - var7.b);
				var9 = var3.a(var7, false);
				if (var9 != null) {
					var9.p();
					var9.d(var3.e_());
				}
			}

			a(var1, this, "commands.give.success", new Object[] { var7.B(), Integer.valueOf(var5), var3.e_() });
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, this.d()) : (var2.length == 2 ? a(var2, Item.e.c()) : null);
	}

	protected String[] d() {
		return MinecraftServer.P().M();
	}

	@Override
	public boolean isListStart(String[] var1, int var2) {
		return var2 == 0;
	}
}
