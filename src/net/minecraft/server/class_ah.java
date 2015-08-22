package net.minecraft.server;

import java.util.List;

public class class_ah extends class_i {
	@Override
	public String c() {
		return "gamemode";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.gamemode.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length <= 0) {
			throw new class_cf("commands.gamemode.usage", new Object[0]);
		} else {
			class_agr.class_a_in_class_agr var3 = h(var1, var2[0]);
			class_lm var4 = var2.length >= 2 ? a(var1, var2[1]) : b(var1);
			var4.a(var3);
			var4.O = 0.0F;
			if (var1.e().S().b("sendCommandFeedback")) {
				var4.a((new class_fb("gameMode.changed", new Object[0])));
			}

			class_fb var5 = new class_fb("gameMode." + var3.b(), new Object[0]);
			if (var4 != var1) {
				a(var1, this, 1, "commands.gamemode.success.other", new Object[] { var4.e_(), var5 });
			} else {
				a(var1, this, 1, "commands.gamemode.success.self", new Object[] { var5 });
			}

		}
	}

	protected class_agr.class_a_in_class_agr h(ICommandListener var1, String var2) throws class_cb {
		return !var2.equalsIgnoreCase(class_agr.class_a_in_class_agr.b.b()) && !var2.equalsIgnoreCase("s") ? (!var2.equalsIgnoreCase(class_agr.class_a_in_class_agr.c.b()) && !var2.equalsIgnoreCase("c") ? (!var2.equalsIgnoreCase(class_agr.class_a_in_class_agr.d.b()) && !var2.equalsIgnoreCase("a") ? (!var2.equalsIgnoreCase(class_agr.class_a_in_class_agr.e.b()) && !var2.equalsIgnoreCase("sp") ? class_agr.a(a(var2, 0, class_agr.class_a_in_class_agr.values().length - 2))
				: class_agr.class_a_in_class_agr.e) : class_agr.class_a_in_class_agr.d) : class_agr.class_a_in_class_agr.c) : class_agr.class_a_in_class_agr.b;
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, new String[] { "survival", "creative", "adventure", "spectator" }) : (var2.length == 2 ? a(var2, this.d()) : null);
	}

	protected String[] d() {
		return MinecraftServer.P().M();
	}

	@Override
	public boolean b(String[] var1, int var2) {
		return var2 == 1;
	}
}
