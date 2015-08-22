package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_bv extends class_i {
	@Override
	public String c() {
		return "weather";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.weather.usage";
	}

	@Override
	public void a(ICommandListener var1, String[] var2) throws class_bz {
		if ((var2.length >= 1) && (var2.length <= 2)) {
			int var3 = (300 + (new Random()).nextInt(600)) * 20;
			if (var2.length >= 2) {
				var3 = a(var2[1], 1, 1000000) * 20;
			}

			class_ll var4 = MinecraftServer.P().d[0];
			class_axt var5 = var4.R();
			if ("clear".equalsIgnoreCase(var2[0])) {
				var5.i(var3);
				var5.g(0);
				var5.f(0);
				var5.b(false);
				var5.a(false);
				a(var1, this, "commands.weather.clear", new Object[0]);
			} else if ("rain".equalsIgnoreCase(var2[0])) {
				var5.i(0);
				var5.g(var3);
				var5.f(var3);
				var5.b(true);
				var5.a(false);
				a(var1, this, "commands.weather.rain", new Object[0]);
			} else {
				if (!"thunder".equalsIgnoreCase(var2[0])) {
					throw new class_cf("commands.weather.usage", new Object[0]);
				}

				var5.i(0);
				var5.g(var3);
				var5.f(var3);
				var5.b(true);
				var5.a(true);
				a(var1, this, "commands.weather.thunder", new Object[0]);
			}

		} else {
			throw new class_cf("commands.weather.usage", new Object[0]);
		}
	}

	@Override
	public List a(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, new String[] { "clear", "rain", "thunder" }) : null;
	}
}
