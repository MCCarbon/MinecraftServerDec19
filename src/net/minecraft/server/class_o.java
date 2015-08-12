package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class class_o {
	private static final Pattern a = Pattern.compile("^@([pare])(?:\\[([\\w=,!-]*)\\])?$");
	private static final Pattern b = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
	private static final Pattern c = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");
	private static final Set d = Sets.newHashSet((Object[]) (new String[] { "x", "y", "z", "dx", "dy", "dz", "rm", "r" }));

	public static EntityPlayer a(ICommandListener var0, String var1) {
		return (EntityPlayer) a(var0, var1, EntityPlayer.class);
	}

	public static Entity a(ICommandListener var0, String var1, Class var2) {
		List var3 = b(var0, var1, var2);
		return var3.size() == 1 ? (Entity) var3.get(0) : null;
	}

	public static IChatBaseComponent b(ICommandListener var0, String var1) {
		List var2 = b(var0, var1, Entity.class);
		if (var2.isEmpty()) {
			return null;
		} else {
			ArrayList var3 = Lists.newArrayList();
			Iterator var4 = var2.iterator();

			while (var4.hasNext()) {
				Entity var5 = (Entity) var4.next();
				var3.add(var5.getScoreboardDisplayName());
			}

			return CommandAbstract.a((List) var3);
		}
	}

	public static List b(ICommandListener var0, String var1, Class var2) {
		Matcher var3 = a.matcher(var1);
		if (var3.matches() && var0.a(1, "@")) {
			Map var4 = c(var3.group(2));
			if (!b(var0, var4)) {
				return Collections.emptyList();
			} else {
				String var5 = var3.group(1);
				BlockPosition var6 = b(var4, var0.c());
				List var7 = a(var0, var4);
				ArrayList var8 = Lists.newArrayList();
				Iterator var9 = var7.iterator();

				while (var9.hasNext()) {
					World var10 = (World) var9.next();
					if (var10 != null) {
						ArrayList var11 = Lists.newArrayList();
						var11.addAll(a(var4, var5));
						var11.addAll(b(var4));
						var11.addAll(c(var4));
						var11.addAll(d(var4));
						var11.addAll(e(var4));
						var11.addAll(f(var4));
						var11.addAll(a(var4, var6));
						var11.addAll(g(var4));
						var8.addAll(a((Map) var4, (Class) var2, (List) var11, (String) var5, (World) var10, var6));
					}
				}

				return a((List) var8, (Map) var4, (ICommandListener) var0, (Class) var2, (String) var5, var6);
			}
		} else {
			return Collections.emptyList();
		}
	}

	private static List a(ICommandListener var0, Map var1) {
		ArrayList var2 = Lists.newArrayList();
		if (h(var1)) {
			var2.add(var0.e());
		} else {
			Collections.addAll(var2, MinecraftServer.getServer().d);
		}

		return var2;
	}

	private static boolean b(ICommandListener var0, Map var1) {
		String var2 = b(var1, "type");
		var2 = var2 != null && var2.startsWith("!") ? var2.substring(1) : var2;
		if (var2 != null && !EntityTypes.b(var2)) {
			ChatMessage var3 = new ChatMessage("commands.generic.entity.invalidType", new Object[] { var2 });
			var3.getChatModifier().a(EnumChatFormat.RED);
			var0.sendMessage(var3);
			return false;
		} else {
			return true;
		}
	}

	private static List a(Map var0, String var1) {
		ArrayList var2 = Lists.newArrayList();
		String var3 = b(var0, "type");
		final boolean var4 = var3 != null && var3.startsWith("!");
		if (var4) {
			var3 = var3.substring(1);
		}
		final String cvar3 = var3;
		boolean var6 = !var1.equals("e");
		boolean var7 = var1.equals("r") && var3 != null;
		if ((var3 == null || !var1.equals("e")) && !var7) {
			if (var6) {
				var2.add(new Predicate() {
					public boolean a(Entity var1) {
						return var1 instanceof EntityHuman;
					}

					// $FF: synthetic method
					public boolean apply(Object var1) {
						return this.a((Entity) var1);
					}
				});
			}
		} else {
			var2.add(new Predicate() {
				public boolean a(Entity var1) {
					return EntityTypes.a(var1, cvar3) != var4;
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var2;
	}

	private static List b(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		final int var2 = a(var0, "lm", -1);
		final int var3 = a(var0, "l", -1);
		if (var2 > -1 || var3 > -1) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					if (!(var1 instanceof EntityPlayer)) {
						return false;
					} else {
						EntityPlayer var2x = (EntityPlayer) var1;
						return (var2 <= -1 || var2x.expLevel >= var2) && (var3 <= -1 || var2x.expLevel <= var3);
					}
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List c(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		final int var2 = a(var0, "m", WorldSettings.EnumGameMode.NOT_SET.getId());
		if (var2 != WorldSettings.EnumGameMode.NOT_SET.getId()) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					if (!(var1 instanceof EntityPlayer)) {
						return false;
					} else {
						EntityPlayer var2x = (EntityPlayer) var1;
						return var2x.playerInteractManager.getGameMode().getId() == var2;
					}
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List d(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		String var2 = b(var0, "team");
		final boolean var3 = var2 != null && var2.startsWith("!");
		if (var3) {
			var2 = var2.substring(1);
		}
		final String cvar2 = var2;
		if (var2 != null) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					if (!(var1 instanceof EntityLiving)) {
						return false;
					} else {
						EntityLiving var2x = (EntityLiving) var1;
						class_awp var3x = var2x.bP();
						String var4 = var3x == null ? "" : var3x.b();
						return var4.equals(cvar2) != var3;
					}
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List e(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		final Map var2 = a(var0);
		if (var2 != null && !var2.isEmpty()) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					Scoreboard var2x = MinecraftServer.getServer().getWorldServer(0).aa();
					Iterator var3 = var2.entrySet().iterator();

					Entry var4;
					boolean var6;
					int var10;
					do {
						if (!var3.hasNext()) {
							return true;
						}

						var4 = (Entry) var3.next();
						String var5 = (String) var4.getKey();
						var6 = false;
						if (var5.endsWith("_min") && var5.length() > 4) {
							var6 = true;
							var5 = var5.substring(0, var5.length() - 4);
						}

						class_awj var7 = var2x.b(var5);
						if (var7 == null) {
							return false;
						}

						String var8 = var1 instanceof EntityPlayer ? var1.getName() : var1.getUniqueId().toString();
						if (!var2x.b(var8, var7)) {
							return false;
						}

						class_awl var9 = var2x.c(var8, var7);
						var10 = var9.c();
						if (var10 < ((Integer) var4.getValue()).intValue() && var6) {
							return false;
						}
					} while (var10 <= ((Integer) var4.getValue()).intValue() || var6);

					return false;
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List f(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		String var2 = b(var0, "name");
		final boolean var3 = var2 != null && var2.startsWith("!");
		if (var3) {
			var2 = var2.substring(1);
		}
		final String cvar2 = var2;
		if (var2 != null) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					return var1.getName().equals(cvar2) != var3;
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List a(Map var0, final BlockPosition var1) {
		ArrayList var2 = Lists.newArrayList();
		final int var3 = a(var0, "rm", -1);
		final int var4 = a(var0, "r", -1);
		if (var1 != null && (var3 >= 0 || var4 >= 0)) {
			final int var5 = var3 * var3;
			final int var6 = var4 * var4;
			var2.add(new Predicate() {
				public boolean a(Entity var1x) {
					int var2 = (int) var1x.c(var1);
					return (var3 < 0 || var2 >= var5) && (var4 < 0 || var2 <= var6);
				}

				// $FF: synthetic method
				public boolean apply(Object var1x) {
					return this.a((Entity) var1x);
				}
			});
		}

		return var2;
	}

	private static List g(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		int var2;
		int var3;
		if (var0.containsKey("rym") || var0.containsKey("ry")) {
			var2 = a(a(var0, "rym", 0));
			var3 = a(a(var0, "ry", 359));
			final int cvar2 = var2;
			final int cvar3 = var3;
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					int var2x = class_o.a((int) Math.floor((double) var1.yaw));
					return cvar2 > cvar3 ? var2x >= cvar2 || var2x <= cvar3 : var2x >= cvar2 && var2x <= cvar3;
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		if (var0.containsKey("rxm") || var0.containsKey("rx")) {
			var2 = a(a(var0, "rxm", 0));
			var3 = a(a(var0, "rx", 359));
			final int cvar2 = var2;
			final int cvar3 = var3;
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					int var2x = class_o.a((int) Math.floor((double) var1.pitch));
					return cvar2 > cvar3 ? var2x >= cvar2 || var2x <= cvar3 : var2x >= cvar2 && var2x <= cvar3;
				}

				// $FF: synthetic method
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List a(Map var0, Class var1, List var2, String var3, World var4, BlockPosition var5) {
		ArrayList var6 = Lists.newArrayList();
		String var7 = b(var0, "type");
		var7 = var7 != null && var7.startsWith("!") ? var7.substring(1) : var7;
		boolean var8 = !var3.equals("e");
		boolean var9 = var3.equals("r") && var7 != null;
		int var10 = a(var0, "dx", 0);
		int var11 = a(var0, "dy", 0);
		int var12 = a(var0, "dz", 0);
		int var13 = a(var0, "r", -1);
		Predicate var14 = Predicates.and((Iterable) var2);
		Predicate var15 = Predicates.and(IEntitySelector.IS_ALIVE, var14);
		if (var5 != null) {
			int var16 = var4.players.size();
			int var17 = var4.entityList.size();
			boolean var18 = var16 < var17 / 16;
			final AxisAlignedBB var19;
			if (!var0.containsKey("dx") && !var0.containsKey("dy") && !var0.containsKey("dz")) {
				if (var13 >= 0) {
					var19 = new AxisAlignedBB((double) (var5.getX() - var13), (double) (var5.getY() - var13), (double) (var5.getZ() - var13), (double) (var5.getX() + var13 + 1), (double) (var5.getY() + var13 + 1), (double) (var5.getZ() + var13 + 1));
					if (var8 && var18 && !var9) {
						var6.addAll(var4.getPlayers(var1, var15));
					} else {
						var6.addAll(var4.getEntities(var1, var19, var15));
					}
				} else if (var3.equals("a")) {
					var6.addAll(var4.getPlayers(var1, var14));
				} else if (!var3.equals("p") && (!var3.equals("r") || var9)) {
					var6.addAll(var4.getEntities(var1, var15));
				} else {
					var6.addAll(var4.getPlayers(var1, var15));
				}
			} else {
				var19 = a(var5, var10, var11, var12);
				if (var8 && var18 && !var9) {
					Predicate var20 = new Predicate() {
						public boolean a(Entity var1) {
							return var1.locX >= var19.xMin && var1.locY >= var19.yMin && var1.locZ >= var19.zMin ? var1.locX < var19.xMax && var1.locY < var19.yMax && var1.locZ < var19.zMax : false;
						}

						// $FF: synthetic method
						public boolean apply(Object var1) {
							return this.a((Entity) var1);
						}
					};
					var6.addAll(var4.getPlayers(var1, Predicates.and(var15, var20)));
				} else {
					var6.addAll(var4.getEntities(var1, var19, var15));
				}
			}
		} else if (var3.equals("a")) {
			var6.addAll(var4.getPlayers(var1, var14));
		} else if (!var3.equals("p") && (!var3.equals("r") || var9)) {
			var6.addAll(var4.getEntities(var1, var15));
		} else {
			var6.addAll(var4.getPlayers(var1, var15));
		}

		return var6;
	}

	private static List a(List var0, Map var1, ICommandListener var2, Class var3, String var4, final BlockPosition var5) {
		int var6 = a(var1, "c", !var4.equals("a") && !var4.equals("e") ? 1 : 0);
		if (!var4.equals("p") && !var4.equals("a") && !var4.equals("e")) {
			if (var4.equals("r")) {
				Collections.shuffle((List) var0);
			}
		} else if (var5 != null) {
			Collections.sort((List) var0, new Comparator() {
				public int a(Entity var1, Entity var2) {
					return ComparisonChain.start().compare(var1.b(var5), var2.b(var5)).result();
				}

				// $FF: synthetic method
				public int compare(Object var1, Object var2) {
					return this.a((Entity) var1, (Entity) var2);
				}
			});
		}

		Entity var7 = var2.f();
		if (var7 != null && var3.isAssignableFrom(var7.getClass()) && var6 == 1 && ((List) var0).contains(var7) && !"r".equals(var4)) {
			var0 = Lists.newArrayList((Object[]) (new Entity[] { var7 }));
		}

		if (var6 != 0) {
			if (var6 < 0) {
				Collections.reverse((List) var0);
			}

			var0 = ((List) var0).subList(0, Math.min(Math.abs(var6), ((List) var0).size()));
		}

		return (List) var0;
	}

	private static AxisAlignedBB a(BlockPosition var0, int var1, int var2, int var3) {
		boolean var4 = var1 < 0;
		boolean var5 = var2 < 0;
		boolean var6 = var3 < 0;
		int var7 = var0.getX() + (var4 ? var1 : 0);
		int var8 = var0.getY() + (var5 ? var2 : 0);
		int var9 = var0.getZ() + (var6 ? var3 : 0);
		int var10 = var0.getX() + (var4 ? 0 : var1) + 1;
		int var11 = var0.getY() + (var5 ? 0 : var2) + 1;
		int var12 = var0.getZ() + (var6 ? 0 : var3) + 1;
		return new AxisAlignedBB((double) var7, (double) var8, (double) var9, (double) var10, (double) var11, (double) var12);
	}

	public static int a(int var0) {
		var0 %= 360;
		if (var0 >= 160) {
			var0 -= 360;
		}

		if (var0 < 0) {
			var0 += 360;
		}

		return var0;
	}

	private static BlockPosition b(Map var0, BlockPosition var1) {
		return new BlockPosition(a(var0, "x", var1.getX()), a(var0, "y", var1.getY()), a(var0, "z", var1.getZ()));
	}

	private static boolean h(Map var0) {
		Iterator var1 = d.iterator();

		String var2;
		do {
			if (!var1.hasNext()) {
				return false;
			}

			var2 = (String) var1.next();
		} while (!var0.containsKey(var2));

		return true;
	}

	private static int a(Map var0, String var1, int var2) {
		return var0.containsKey(var1) ? MathHelper.parseIntWithDef((String) var0.get(var1), var2) : var2;
	}

	private static String b(Map var0, String var1) {
		return (String) var0.get(var1);
	}

	public static Map a(Map var0) {
		HashMap var1 = Maps.newHashMap();
		Iterator var2 = var0.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			if (var3.startsWith("score_") && var3.length() > "score_".length()) {
				var1.put(var3.substring("score_".length()), Integer.valueOf(MathHelper.parseIntWithDef((String) var0.get(var3), 1)));
			}
		}

		return var1;
	}

	public static boolean a(String var0) {
		Matcher var1 = a.matcher(var0);
		if (!var1.matches()) {
			return false;
		} else {
			Map var2 = c(var1.group(2));
			String var3 = var1.group(1);
			int var4 = !"a".equals(var3) && !"e".equals(var3) ? 1 : 0;
			return a(var2, "c", var4) != 1;
		}
	}

	public static boolean b(String var0) {
		return a.matcher(var0).matches();
	}

	private static Map c(String var0) {
		HashMap var1 = Maps.newHashMap();
		if (var0 == null) {
			return var1;
		} else {
			int var2 = 0;
			int var3 = -1;

			for (Matcher var4 = b.matcher(var0); var4.find(); var3 = var4.end()) {
				String var5 = null;
				switch (var2++) {
					case 0:
						var5 = "x";
						break;
					case 1:
						var5 = "y";
						break;
					case 2:
						var5 = "z";
						break;
					case 3:
						var5 = "r";
				}

				if (var5 != null && !var4.group(1).isEmpty()) {
					var1.put(var5, var4.group(1));
				}
			}

			if (var3 < var0.length()) {
				Matcher var6 = c.matcher(var3 == -1 ? var0 : var0.substring(var3));

				while (var6.find()) {
					var1.put(var6.group(1), var6.group(2));
				}
			}

			return var1;
		}
	}
}
