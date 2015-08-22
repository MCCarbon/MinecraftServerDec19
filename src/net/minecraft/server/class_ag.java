package net.minecraft.server;

import java.util.List;

public class class_ag extends class_i {
	@Override
	public String c() {
		return "difficulty";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(class_m var1) {
		return "commands.difficulty.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		if (var2.length <= 0) {
			throw new class_cf("commands.difficulty.usage", new Object[0]);
		} else {
			class_ps var3 = this.e(var2[0]);
			MinecraftServer.P().a(var3);
			a(var1, this, "commands.difficulty.success", new Object[] { new class_fb(var3.b(), new Object[0]) });
		}
	}

	protected class_ps e(String var1) throws class_cb {
		return !var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p") ? (!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e") ? (!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n") ? (!var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h") ? class_ps.a(a(var1, 0, 3)) : class_ps.d) : class_ps.c) : class_ps.b) : class_ps.a;
	}

	@Override
	public List a(class_m var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, new String[] { "peaceful", "easy", "normal", "hard" }) : null;
	}
}
