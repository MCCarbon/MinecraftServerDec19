package net.minecraft.server;


public class class_ay extends class_i {
	@Override
	public String c() {
		return "save-all";
	}

	@Override
	public String c(class_m var1) {
		return "commands.save.usage";
	}

	@Override
	public void a(class_m var1, String[] var2) throws class_bz {
		MinecraftServer var3 = MinecraftServer.P();
		var1.a(new class_fb("commands.save.start", new Object[0]));
		if (var3.ar() != null) {
			var3.ar().j();
		}

		try {
			int var4;
			class_ll var5;
			boolean var6;
			for (var4 = 0; var4 < var3.d.length; ++var4) {
				if (var3.d[var4] != null) {
					var5 = var3.d[var4];
					var6 = var5.c;
					var5.c = false;
					var5.a(true, (class_oc) null);
					var5.c = var6;
				}
			}

			if ((var2.length > 0) && "flush".equals(var2[0])) {
				var1.a(new class_fb("commands.save.flushStart", new Object[0]));

				for (var4 = 0; var4 < var3.d.length; ++var4) {
					if (var3.d[var4] != null) {
						var5 = var3.d[var4];
						var6 = var5.c;
						var5.c = false;
						var5.p();
						var5.c = var6;
					}
				}

				var1.a(new class_fb("commands.save.flushEnd", new Object[0]));
			}
		} catch (class_agp var7) {
			a(var1, this, "commands.save.failed", new Object[] { var7.getMessage() });
			return;
		}

		a(var1, this, "commands.save.success", new Object[0]);
	}
}
