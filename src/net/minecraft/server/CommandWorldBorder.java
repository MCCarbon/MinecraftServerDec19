package net.minecraft.server;

import java.util.List;

public class CommandWorldBorder extends CommandAbstract {
	@Override
	public String getCommand() {
		return "worldborder";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.worldborder.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 1) {
			throw new class_cf("commands.worldborder.usage", new Object[0]);
		} else {
			class_aqg var3 = this.d();
			double var4;
			double var6;
			long var8;
			if (var2[0].equals("set")) {
				if ((var2.length != 2) && (var2.length != 3)) {
					throw new class_cf("commands.worldborder.set.usage", new Object[0]);
				}

				var4 = var3.j();
				var6 = a(var2[1], 1.0D, 6.0E7D);
				var8 = var2.length > 2 ? a(var2[2], 0L, 9223372036854775L) * 1000L : 0L;
				if (var8 > 0L) {
					var3.a(var4, var6, var8);
					if (var4 > var6) {
						a(var1, this, "commands.worldborder.setSlowly.shrink.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }), Long.toString(var8 / 1000L) });
					} else {
						a(var1, this, "commands.worldborder.setSlowly.grow.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }), Long.toString(var8 / 1000L) });
					}
				} else {
					var3.a(var6);
					a(var1, this, "commands.worldborder.set.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }) });
				}
			} else if (var2[0].equals("add")) {
				if ((var2.length != 2) && (var2.length != 3)) {
					throw new class_cf("commands.worldborder.add.usage", new Object[0]);
				}

				var4 = var3.h();
				var6 = var4 + a(var2[1], -var4, 6.0E7D - var4);
				var8 = var3.i() + (var2.length > 2 ? a(var2[2], 0L, 9223372036854775L) * 1000L : 0L);
				if (var8 > 0L) {
					var3.a(var4, var6, var8);
					if (var4 > var6) {
						a(var1, this, "commands.worldborder.setSlowly.shrink.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }), Long.toString(var8 / 1000L) });
					} else {
						a(var1, this, "commands.worldborder.setSlowly.grow.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }), Long.toString(var8 / 1000L) });
					}
				} else {
					var3.a(var6);
					a(var1, this, "commands.worldborder.set.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var6) }), String.format("%.1f", new Object[] { Double.valueOf(var4) }) });
				}
			} else if (var2[0].equals("center")) {
				if (var2.length != 3) {
					throw new class_cf("commands.worldborder.center.usage", new Object[0]);
				}

				class_cj var10 = var1.c();
				double var5 = b(var10.n() + 0.5D, var2[1], true);
				double var7 = b(var10.p() + 0.5D, var2[2], true);
				var3.c(var5, var7);
				a(var1, this, "commands.worldborder.center.success", new Object[] { Double.valueOf(var5), Double.valueOf(var7) });
			} else if (var2[0].equals("damage")) {
				if (var2.length < 2) {
					throw new class_cf("commands.worldborder.damage.usage", new Object[0]);
				}

				if (var2[1].equals("buffer")) {
					if (var2.length != 3) {
						throw new class_cf("commands.worldborder.damage.buffer.usage", new Object[0]);
					}

					var4 = a(var2[2], 0.0D);
					var6 = var3.m();
					var3.b(var4);
					a(var1, this, "commands.worldborder.damage.buffer.success", new Object[] { String.format("%.1f", new Object[] { Double.valueOf(var4) }), String.format("%.1f", new Object[] { Double.valueOf(var6) }) });
				} else if (var2[1].equals("amount")) {
					if (var2.length != 3) {
						throw new class_cf("commands.worldborder.damage.amount.usage", new Object[0]);
					}

					var4 = a(var2[2], 0.0D);
					var6 = var3.n();
					var3.c(var4);
					a(var1, this, "commands.worldborder.damage.amount.success", new Object[] { String.format("%.2f", new Object[] { Double.valueOf(var4) }), String.format("%.2f", new Object[] { Double.valueOf(var6) }) });
				}
			} else if (var2[0].equals("warning")) {
				if (var2.length < 2) {
					throw new class_cf("commands.worldborder.warning.usage", new Object[0]);
				}

				int var12 = a(var2[2], 0);
				int var11;
				if (var2[1].equals("time")) {
					if (var2.length != 3) {
						throw new class_cf("commands.worldborder.warning.time.usage", new Object[0]);
					}

					var11 = var3.p();
					var3.b(var12);
					a(var1, this, "commands.worldborder.warning.time.success", new Object[] { Integer.valueOf(var12), Integer.valueOf(var11) });
				} else if (var2[1].equals("distance")) {
					if (var2.length != 3) {
						throw new class_cf("commands.worldborder.warning.distance.usage", new Object[0]);
					}

					var11 = var3.q();
					var3.c(var12);
					a(var1, this, "commands.worldborder.warning.distance.success", new Object[] { Integer.valueOf(var12), Integer.valueOf(var11) });
				}
			} else {
				if (!var2[0].equals("get")) {
					throw new class_cf("commands.worldborder.usage", new Object[0]);
				}

				var4 = var3.h();
				var1.a(class_n.class_a_in_class_n.e, MathHelper.c(var4 + 0.5D));
				var1.a(new class_fb("commands.worldborder.get.success", new Object[] { String.format("%.0f", new Object[] { Double.valueOf(var4) }) }));
			}

		}
	}

	protected class_aqg d() {
		return MinecraftServer.P().d[0].ah();
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, new String[] { "set", "center", "damage", "warning", "add", "get" }) : ((var2.length == 2) && var2[0].equals("damage") ? a(var2, new String[] { "buffer", "amount" }) : ((var2.length >= 2) && (var2.length <= 3) && var2[0].equals("center") ? b(var2, 1, var3) : ((var2.length == 2) && var2[0].equals("warning") ? a(var2, new String[] { "time", "distance" }) : null)));
	}
}
