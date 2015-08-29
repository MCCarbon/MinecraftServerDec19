package net.minecraft.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import com.mojang.authlib.yggdrasil.ProfileNotFoundException;

public class class_md {
	private static final Logger e = LogManager.getLogger();
	public static final File a = new File("banned-ips.txt");
	public static final File b = new File("banned-players.txt");
	public static final File c = new File("ops.txt");
	public static final File d = new File("white-list.txt");

	static List a(File var0, Map var1) throws IOException {
		List var2 = Files.readLines(var0, Charsets.UTF_8);
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			var4 = var4.trim();
			if (!var4.startsWith("#") && (var4.length() >= 1)) {
				String[] var5 = var4.split("\\|");
				var1.put(var5[0].toLowerCase(Locale.ROOT), var5);
			}
		}

		return var2;
	}

	private static void a(MinecraftServer var0, Collection var1, ProfileLookupCallback var2) {
	      String[] var3 = (String[])Iterators.toArray(Iterators.filter(var1.iterator(), new Predicate() {
	          public boolean a(String var1) {
	             return !class_of.b(var1);
	          }

	          // $FF: synthetic method
	          public boolean apply(Object var1) {
	             return this.a((String)var1);
	          }
	       }), String.class);
		if (var0.ah()) {
			var0.aG().findProfilesByNames(var3, Agent.MINECRAFT, var2);
		} else {
			String[] var4 = var3;
			int var5 = var3.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				String var7 = var4[var6];
				UUID var8 = class_yu.a(new GameProfile((UUID) null, var7));
				GameProfile var9 = new GameProfile(var8, var7);
				var2.onProfileLookupSucceeded(var9);
			}
		}

	}

	public static boolean a(final MinecraftServer var0) {
		final class_mj var1 = new class_mj(class_me.a);
		if (b.exists() && b.isFile()) {
			if (var1.c().exists()) {
				try {
					var1.g();
				} catch (FileNotFoundException var6) {
					e.warn("Could not load existing file " + var1.c().getName(), var6);
				}
			}

			try {
				final HashMap var2 = Maps.newHashMap();
				a(b, var2);
				ProfileLookupCallback var3 = new ProfileLookupCallback() {
					@Override
					public void onProfileLookupSucceeded(GameProfile var1x) {
						var0.aH().a(var1x);
						String[] var2x = (String[]) var2.get(var1x.getName().toLowerCase(Locale.ROOT));
						if (var2x == null) {
							class_md.e.warn("Could not convert user banlist entry for " + var1x.getName());
							throw new class_md.class_a_in_class_md("Profile not in the conversionlist", null);
						} else {
							Date var3 = var2x.length > 1 ? class_md.b(var2x[1], (Date) null) : null;
							String var4 = var2x.length > 2 ? var2x[2] : null;
							Date var5 = var2x.length > 3 ? class_md.b(var2x[3], (Date) null) : null;
							String var6 = var2x.length > 4 ? var2x[4] : null;
							var1.a((new class_mk(var1x, var3, var4, var5, var6)));
						}
					}

					@Override
					public void onProfileLookupFailed(GameProfile var1x, Exception var2x) {
						class_md.e.warn("Could not lookup user banlist entry for " + var1x.getName(), var2x);
						if (!(var2x instanceof ProfileNotFoundException)) {
							throw new class_md.class_a_in_class_md("Could not request user " + var1x.getName() + " from backend systems", var2x, null);
						}
					}
				};
				a(var0, var2.keySet(), var3);
				var1.f();
				c(b);
				return true;
			} catch (IOException var4) {
				e.warn("Could not read old user banlist to convert it!", var4);
				return false;
			} catch (class_md.class_a_in_class_md var5) {
				e.error("Conversion failed, please try again later", var5);
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean b(MinecraftServer var0) {
		class_mb var1 = new class_mb(class_me.b);
		if (a.exists() && a.isFile()) {
			if (var1.c().exists()) {
				try {
					var1.g();
				} catch (FileNotFoundException var11) {
					e.warn("Could not load existing file " + var1.c().getName(), var11);
				}
			}

			try {
				HashMap var2 = Maps.newHashMap();
				a(a, var2);
				Iterator var3 = var2.keySet().iterator();

				while (var3.hasNext()) {
					String var4 = (String) var3.next();
					String[] var5 = (String[]) var2.get(var4);
					Date var6 = var5.length > 1 ? b(var5[1], (Date) null) : null;
					String var7 = var5.length > 2 ? var5[2] : null;
					Date var8 = var5.length > 3 ? b(var5[3], (Date) null) : null;
					String var9 = var5.length > 4 ? var5[4] : null;
					var1.a((new class_mc(var4, var6, var7, var8, var9)));
				}

				var1.f();
				c(a);
				return true;
			} catch (IOException var10) {
				e.warn("Could not parse old ip banlist to convert it!", var10);
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean c(final MinecraftServer var0) {
		final class_mf var1 = new class_mf(class_me.c);
		if (c.exists() && c.isFile()) {
			if (var1.c().exists()) {
				try {
					var1.g();
				} catch (FileNotFoundException var6) {
					e.warn("Could not load existing file " + var1.c().getName(), var6);
				}
			}

			try {
				List var2 = Files.readLines(c, Charsets.UTF_8);
				ProfileLookupCallback var3 = new ProfileLookupCallback() {
					@Override
					public void onProfileLookupSucceeded(GameProfile var1x) {
						var0.aH().a(var1x);
						var1.a((new class_mg(var1x, var0.p(), false)));
					}

					@Override
					public void onProfileLookupFailed(GameProfile var1x, Exception var2) {
						class_md.e.warn("Could not lookup oplist entry for " + var1x.getName(), var2);
						if (!(var2 instanceof ProfileNotFoundException)) {
							throw new class_md.class_a_in_class_md("Could not request user " + var1x.getName() + " from backend systems", var2, null);
						}
					}
				};
				a(var0, var2, var3);
				var1.f();
				c(c);
				return true;
			} catch (IOException var4) {
				e.warn("Could not read old oplist to convert it!", var4);
				return false;
			} catch (class_md.class_a_in_class_md var5) {
				e.error("Conversion failed, please try again later", var5);
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean d(final MinecraftServer var0) {
		final class_ml var1 = new class_ml(class_me.d);
		if (d.exists() && d.isFile()) {
			if (var1.c().exists()) {
				try {
					var1.g();
				} catch (FileNotFoundException var6) {
					e.warn("Could not load existing file " + var1.c().getName(), var6);
				}
			}

			try {
				List var2 = Files.readLines(d, Charsets.UTF_8);
				ProfileLookupCallback var3 = new ProfileLookupCallback() {
					@Override
					public void onProfileLookupSucceeded(GameProfile var1x) {
						var0.aH().a(var1x);
						var1.a((new class_mm(var1x)));
					}

					@Override
					public void onProfileLookupFailed(GameProfile var1x, Exception var2) {
						class_md.e.warn("Could not lookup user whitelist entry for " + var1x.getName(), var2);
						if (!(var2 instanceof ProfileNotFoundException)) {
							throw new class_md.class_a_in_class_md("Could not request user " + var1x.getName() + " from backend systems", var2, null);
						}
					}
				};
				a(var0, var2, var3);
				var1.f();
				c(d);
				return true;
			} catch (IOException var4) {
				e.warn("Could not read old whitelist to convert it!", var4);
				return false;
			} catch (class_md.class_a_in_class_md var5) {
				e.error("Conversion failed, please try again later", var5);
				return false;
			}
		} else {
			return true;
		}
	}

	public static String a(String var0) {
		if (!class_of.b(var0) && (var0.length() <= 16)) {
			final MinecraftServer var1 = MinecraftServer.P();
			GameProfile var2 = var1.aH().a(var0);
			if ((var2 != null) && (var2.getId() != null)) {
				return var2.getId().toString();
			} else if (!var1.V() && var1.ah()) {
				final ArrayList var3 = Lists.newArrayList();
				ProfileLookupCallback var4 = new ProfileLookupCallback() {
					@Override
					public void onProfileLookupSucceeded(GameProfile var1x) {
						var1.aH().a(var1x);
						var3.add(var1x);
					}

					@Override
					public void onProfileLookupFailed(GameProfile var1x, Exception var2) {
						class_md.e.warn("Could not lookup user whitelist entry for " + var1x.getName(), var2);
					}
				};
				a(var1, Lists.newArrayList((Object[]) (new String[] { var0 })), var4);
				return !var3.isEmpty() && (((GameProfile) var3.get(0)).getId() != null) ? ((GameProfile) var3.get(0)).getId().toString() : "";
			} else {
				return class_yu.a(new GameProfile((UUID) null, var0)).toString();
			}
		} else {
			return var0;
		}
	}

	public static boolean a(final class_ku var0, class_kr var1) {
		final File var2 = d(var1);
		final File var3 = new File(var2.getParentFile(), "playerdata");
		final File var4 = new File(var2.getParentFile(), "unknownplayers");
		if (var2.exists() && var2.isDirectory()) {
			File[] var5 = var2.listFiles();
			ArrayList var6 = Lists.newArrayList();
			File[] var7 = var5;
			int var8 = var5.length;

			for (int var9 = 0; var9 < var8; ++var9) {
				File var10 = var7[var9];
				String var11 = var10.getName();
				if (var11.toLowerCase(Locale.ROOT).endsWith(".dat")) {
					String var12 = var11.substring(0, var11.length() - ".dat".length());
					if (!var12.isEmpty()) {
						var6.add(var12);
					}
				}
			}

			try {
				final String[] var14 = (String[]) var6.toArray(new String[var6.size()]);
				ProfileLookupCallback var15 = new ProfileLookupCallback() {
					@Override
					public void onProfileLookupSucceeded(GameProfile var1) {
						var0.aH().a(var1);
						UUID var2x = var1.getId();
						if (var2x == null) {
							throw new class_md.class_a_in_class_md("Missing UUID for user profile " + var1.getName(), null);
						} else {
							this.a(var3, this.a(var1), var2x.toString());
						}
					}

					@Override
					public void onProfileLookupFailed(GameProfile var1, Exception var2x) {
						class_md.e.warn("Could not lookup user uuid for " + var1.getName(), var2x);
						if (var2x instanceof ProfileNotFoundException) {
							String var3x = this.a(var1);
							this.a(var4, var3x, var3x);
						} else {
							throw new class_md.class_a_in_class_md("Could not request user " + var1.getName() + " from backend systems", var2x, null);
						}
					}

					private void a(File var1, String var2x, String var3x) {
						File var4x = new File(var2, var2x + ".dat");
						File var5 = new File(var1, var3x + ".dat");
						class_md.b(var1);
						if (!var4x.renameTo(var5)) {
							throw new class_md.class_a_in_class_md("Could not convert file for " + var2x, null);
						}
					}

					private String a(GameProfile var1) {
						String var2x = null;

						for (int var3x = 0; var3x < var14.length; ++var3x) {
							if ((var14[var3x] != null) && var14[var3x].equalsIgnoreCase(var1.getName())) {
								var2x = var14[var3x];
								break;
							}
						}

						if (var2x == null) {
							throw new class_md.class_a_in_class_md("Could not find the filename for " + var1.getName() + " anymore", null);
						} else {
							return var2x;
						}
					}
				};
				a(var0, Lists.newArrayList((Object[]) var14), var15);
				return true;
			} catch (class_md.class_a_in_class_md var13) {
				e.error("Conversion failed, please try again later", var13);
				return false;
			}
		} else {
			return true;
		}
	}

	private static void b(File var0) {
		if (var0.exists()) {
			if (!var0.isDirectory()) {
				throw new class_md.class_a_in_class_md("Can\'t create directory " + var0.getName() + " in world save directory.", null);
			}
		} else if (!var0.mkdirs()) {
			throw new class_md.class_a_in_class_md("Can\'t create directory " + var0.getName() + " in world save directory.", null);
		}
	}

	public static boolean a(class_kr var0) {
		boolean var1 = b(var0);
		var1 = var1 && c(var0);
		return var1;
	}

	private static boolean b(class_kr var0) {
		boolean var1 = false;
		if (b.exists() && b.isFile()) {
			var1 = true;
		}

		boolean var2 = false;
		if (a.exists() && a.isFile()) {
			var2 = true;
		}

		boolean var3 = false;
		if (c.exists() && c.isFile()) {
			var3 = true;
		}

		boolean var4 = false;
		if (d.exists() && d.isFile()) {
			var4 = true;
		}

		if (!var1 && !var2 && !var3 && !var4) {
			return true;
		} else {
			e.warn("**** FAILED TO START THE SERVER AFTER ACCOUNT CONVERSION!");
			e.warn("** please remove the following files and restart the server:");
			if (var1) {
				e.warn("* " + b.getName());
			}

			if (var2) {
				e.warn("* " + a.getName());
			}

			if (var3) {
				e.warn("* " + c.getName());
			}

			if (var4) {
				e.warn("* " + d.getName());
			}

			return false;
		}
	}

	private static boolean c(class_kr var0) {
		File var1 = d(var0);
		if (!var1.exists() || !var1.isDirectory() || ((var1.list().length <= 0) && var1.delete())) {
			return true;
		} else {
			e.warn("**** DETECTED OLD PLAYER DIRECTORY IN THE WORLD SAVE");
			e.warn("**** THIS USUALLY HAPPENS WHEN THE AUTOMATIC CONVERSION FAILED IN SOME WAY");
			e.warn("** please restart the server and if the problem persists, remove the directory \'{}\'", new Object[] { var1.getPath() });
			return false;
		}
	}

	private static File d(class_kr var0) {
		String var1 = var0.a("level-name", "world");
		File var2 = new File(var1);
		return new File(var2, "players");
	}

	private static void c(File var0) {
		File var1 = new File(var0.getName() + ".converted");
		var0.renameTo(var1);
	}

	private static Date b(String var0, Date var1) {
		Date var2;
		try {
			var2 = class_lz.a.parse(var0);
		} catch (ParseException var4) {
			var2 = var1;
		}

		return var2;
	}

	static class class_a_in_class_md extends RuntimeException {
		private class_a_in_class_md(String var1, Throwable var2) {
			super(var1, var2);
		}

		private class_a_in_class_md(String var1) {
			super(var1);
		}

		// $FF: synthetic method
		class_a_in_class_md(String var1, Object var2) {
			this(var1);
		}

		// $FF: synthetic method
		class_a_in_class_md(String var1, Throwable var2, Object var3) {
			this(var1, var2);
		}
	}
}
