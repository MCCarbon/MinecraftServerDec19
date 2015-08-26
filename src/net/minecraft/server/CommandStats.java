package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class CommandStats extends CommandAbstract {
	@Override
	public String getCommand() {
		return "stats";
	}

	@Override
	public int a() {
		return 2;
	}

	@Override
	public String c(ICommandListener var1) {
		return "commands.stats.usage";
	}

	@Override
	public void execute(ICommandListener var1, String[] var2) throws class_bz {
		if (var2.length < 1) {
			throw new class_cf("commands.stats.usage", new Object[0]);
		} else {
			boolean var3;
			if (var2[0].equals("entity")) {
				var3 = false;
			} else {
				if (!var2[0].equals("block")) {
					throw new class_cf("commands.stats.usage", new Object[0]);
				}

				var3 = true;
			}

			byte var4;
			if (var3) {
				if (var2.length < 5) {
					throw new class_cf("commands.stats.block.usage", new Object[0]);
				}

				var4 = 4;
			} else {
				if (var2.length < 3) {
					throw new class_cf("commands.stats.entity.usage", new Object[0]);
				}

				var4 = 2;
			}

			int var11 = var4 + 1;
			String var5 = var2[var4];
			if ("set".equals(var5)) {
				if (var2.length < (var11 + 3)) {
					if (var11 == 5) {
						throw new class_cf("commands.stats.block.set.usage", new Object[0]);
					}

					throw new class_cf("commands.stats.entity.set.usage", new Object[0]);
				}
			} else {
				if (!"clear".equals(var5)) {
					throw new class_cf("commands.stats.usage", new Object[0]);
				}

				if (var2.length < (var11 + 1)) {
					if (var11 == 5) {
						throw new class_cf("commands.stats.block.clear.usage", new Object[0]);
					}

					throw new class_cf("commands.stats.entity.clear.usage", new Object[0]);
				}
			}

			class_n.class_a_in_class_n var6 = class_n.class_a_in_class_n.a(var2[var11++]);
			if (var6 == null) {
				throw new class_bz("commands.stats.failed", new Object[0]);
			} else {
				class_ago var7 = var1.e();
				class_n var8;
				class_cj var9;
				TileEntity var10;
				if (var3) {
					var9 = a(var1, var2, 1, false);
					var10 = var7.s(var9);
					if (var10 == null) {
						throw new class_bz("commands.stats.noCompatibleBlock", new Object[] { Integer.valueOf(var9.n()), Integer.valueOf(var9.o()), Integer.valueOf(var9.p()) });
					}

					if (var10 instanceof class_aol) {
						var8 = ((class_aol) var10).c();
					} else {
						if (!(var10 instanceof class_aoz)) {
							throw new class_bz("commands.stats.noCompatibleBlock", new Object[] { Integer.valueOf(var9.n()), Integer.valueOf(var9.o()), Integer.valueOf(var9.p()) });
						}

						var8 = ((class_aoz) var10).d();
					}
				} else {
					Entity var12 = b(var1, var2[1]);
					var8 = var12.ba();
				}

				if ("set".equals(var5)) {
					String var13 = var2[var11++];
					String var14 = var2[var11];
					if (var13.isEmpty() || var14.isEmpty()) {
						throw new class_bz("commands.stats.failed", new Object[0]);
					}

					class_n.a(var8, var6, var13, var14);
					a(var1, this, "commands.stats.success", new Object[] { var6.b(), var14, var13 });
				} else if ("clear".equals(var5)) {
					class_n.a(var8, var6, (String) null, (String) null);
					a(var1, this, "commands.stats.cleared", new Object[] { var6.b() });
				}

				if (var3) {
					var9 = a(var1, var2, 1, false);
					var10 = var7.s(var9);
					var10.o_();
				}

			}
		}
	}

	@Override
	public List tabComplete(ICommandListener var1, String[] var2, class_cj var3) {
		return var2.length == 1 ? a(var2, new String[] { "entity", "block" }) : ((var2.length == 2) && var2[0].equals("entity") ? a(var2, this.d()) : ((var2.length >= 2) && (var2.length <= 4) && var2[0].equals("block") ? a(var2, 1, var3) : (((var2.length == 3) && var2[0].equals("entity")) || ((var2.length == 5) && var2[0].equals("block")) ? a(var2, new String[] { "set", "clear" })
				: (((var2.length != 4) || !var2[0].equals("entity")) && ((var2.length != 6) || !var2[0].equals("block")) ? (((var2.length != 6) || !var2[0].equals("entity")) && ((var2.length != 8) || !var2[0].equals("block")) ? null : a(var2, this.e())) : a(var2, class_n.class_a_in_class_n.c())))));
	}

	protected String[] d() {
		return MinecraftServer.P().M();
	}

	protected List e() {
		Collection var1 = MinecraftServer.P().a(0).ab().c();
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			class_ayo var4 = (class_ayo) var3.next();
			if (!var4.c().b()) {
				var2.add(var4.b());
			}
		}

		return var2;
	}

	@Override
	public boolean isListStart(String[] var1, int var2) {
		return (var1.length > 0) && var1[0].equals("entity") && (var2 == 1);
	}
}
