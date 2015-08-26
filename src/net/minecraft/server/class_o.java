package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class class_o {
	private static final Pattern a = Pattern.compile("^@([pare])(?:\\[([\\w=,!-]*)\\])?$");
	private static final Pattern b = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
	private static final Pattern c = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");
	private static final Set d = Sets.newHashSet((Object[]) (new String[] { "x", "y", "z", "dx", "dy", "dz", "rm", "r" }));

	public static class_lm a(ICommandListener var0, String var1) {
		return (class_lm) a(var0, var1, class_lm.class);
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
				var3.add(var5.f_());
			}

			return CommandAbstract.a(var3);
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
				class_cj var6 = b(var4, var0.c());
				List var7 = a(var0, var4);
				ArrayList var8 = Lists.newArrayList();
				Iterator var9 = var7.iterator();

				while (var9.hasNext()) {
					class_ago var10 = (class_ago) var9.next();
					if (var10 != null) {
						ArrayList var11 = Lists.newArrayList();
						var11.addAll(a(var4, var5));
						var11.addAll(b(var4));
						var11.addAll(c(var4));
						var11.addAll(d(var4));
						var11.addAll(e(var4));
						var11.addAll(f(var4));
						var11.addAll(g(var4));
						var11.addAll(a(var4, var6));
						var11.addAll(h(var4));
						var8.addAll(a(var4, var2, var11, var5, var10, var6));
					}
				}

				return a(var8, var4, var0, var2, var5, var6);
			}
		} else {
			return Collections.emptyList();
		}
	}

	private static List a(ICommandListener var0, Map var1) {
		ArrayList var2 = Lists.newArrayList();
		if (i(var1)) {
			var2.add(var0.e());
		} else {
			Collections.addAll(var2, MinecraftServer.P().d);
		}

		return var2;
	}

	private static boolean b(ICommandListener var0, Map var1) {
		String var2 = b(var1, "type");
		var2 = (var2 != null) && var2.startsWith("!") ? var2.substring(1) : var2;
		if ((var2 != null) && !EntityTypes.b(var2)) {
			class_fb var3 = new class_fb("commands.generic.entity.invalidType", new Object[] { var2 });
			var3.b().a(EnumChatFormat.RED);
			var0.a(var3);
			return false;
		} else {
			return true;
		}
	}

	private static List a(Map var0, String var1) {
		ArrayList var2 = Lists.newArrayList();
		String var3 = b(var0, "type");
		final boolean var4 = (var3 != null) && var3.startsWith("!");
		if (var4) {
			var3 = var3.substring(1);
		}
		final String vvar3 = var3;

		boolean var6 = !var1.equals("e");
		boolean var7 = var1.equals("r") && (var3 != null);
		if (((var3 == null) || !var1.equals("e")) && !var7) {
			if (var6) {
				var2.add(new Predicate() {
					public boolean a(Entity var1) {
						return var1 instanceof class_yu;
					}

					// $FF: synthetic method
					@Override
					public boolean apply(Object var1) {
						return this.a((Entity) var1);
					}
				});
			}
		} else {
			var2.add(new Predicate() {
				public boolean a(Entity var1) {
					return EntityTypes.a(var1, vvar3) != var4;
				}

				// $FF: synthetic method
				@Override
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
		if ((var2 > -1) || (var3 > -1)) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					if (!(var1 instanceof class_lm)) {
						return false;
					} else {
						class_lm var2x = (class_lm) var1;
						return ((var2 <= -1) || (var2x.bJ >= var2)) && ((var3 <= -1) || (var2x.bJ <= var3));
					}
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List c(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		final int var2 = a(var0, "m", class_agr.class_a_in_class_agr.a.a());
		if (var2 != class_agr.class_a_in_class_agr.a.a()) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					if (!(var1 instanceof class_lm)) {
						return false;
					} else {
						class_lm var2x = (class_lm) var1;
						return var2x.c.b().a() == var2;
					}
				}

				// $FF: synthetic method
				@Override
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
		final boolean var3 = (var2 != null) && var2.startsWith("!");
		if (var3) {
			var2 = var2.substring(1);
		}
		final String vvar2 = var2;

		if (var2 != null) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					if (!(var1 instanceof class_rg)) {
						return false;
					} else {
						class_rg var2x = (class_rg) var1;
						class_ayu var3x = var2x.aE();
						String var4 = var3x == null ? "" : var3x.b();
						return var4.equals(vvar2) != var3;
					}
				}

				// $FF: synthetic method
				@Override
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
		if ((var2 != null) && !var2.isEmpty()) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					class_ays var2x = MinecraftServer.P().a(0).ab();
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
						if (var5.endsWith("_min") && (var5.length() > 4)) {
							var6 = true;
							var5 = var5.substring(0, var5.length() - 4);
						}

						class_ayo var7 = var2x.b(var5);
						if (var7 == null) {
							return false;
						}

						String var8 = var1 instanceof class_lm ? var1.e_() : var1.aQ().toString();
						if (!var2x.b(var8, var7)) {
							return false;
						}

						class_ayq var9 = var2x.c(var8, var7);
						var10 = var9.c();
						if ((var10 < ((Integer) var4.getValue()).intValue()) && var6) {
							return false;
						}
					} while ((var10 <= ((Integer) var4.getValue()).intValue()) || var6);

					return false;
				}

				// $FF: synthetic method
				@Override
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
		final boolean var3 = (var2 != null) && var2.startsWith("!");
		if (var3) {
			var2 = var2.substring(1);
		}
		final String vvar2 = var2;

		if (var2 != null) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					return var1.e_().equals(vvar2) != var3;
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List g(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		String var2 = b(var0, "tag");
		final boolean var3 = (var2 != null) && var2.startsWith("!");
		if (var3) {
			var2 = var2.substring(1);
		}
		final String vvar2 = var2;

		if (var2 != null) {
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					return "".equals(vvar2) ? var1.H().isEmpty() != var3 : var1.H().contains(vvar2) != var3;
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List a(Map var0, final class_cj var1) {
		ArrayList var2 = Lists.newArrayList();
		final int var3 = a(var0, "rm", -1);
		final int var4 = a(var0, "r", -1);
		if ((var1 != null) && ((var3 >= 0) || (var4 >= 0))) {
			final int var5 = var3 * var3;
			final int var6 = var4 * var4;
			var2.add(new Predicate() {
				public boolean a(Entity var1x) {
					int var2 = (int) var1x.c(var1);
					return ((var3 < 0) || (var2 >= var5)) && ((var4 < 0) || (var2 <= var6));
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1x) {
					return this.a((Entity) var1x);
				}
			});
		}

		return var2;
	}

	private static List h(Map var0) {
		ArrayList var1 = Lists.newArrayList();
		int var2;
		int var3;
		if (var0.containsKey("rym") || var0.containsKey("ry")) {
			var2 = a(a(var0, "rym", 0));
			var3 = a(a(var0, "ry", 359));
			final int vvar2 = var2;
			final int vvar3 = var3;
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					int var2x = class_o.a((int) Math.floor(var1.y));
					return vvar2 > vvar3 ? (var2x >= vvar2) || (var2x <= vvar3) : (var2x >= vvar2) && (var2x <= vvar3);
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		if (var0.containsKey("rxm") || var0.containsKey("rx")) {
			var2 = a(a(var0, "rxm", 0));
			var3 = a(a(var0, "rx", 359));
			final int vvar2 = var2;
			final int vvar3 = var3;
			var1.add(new Predicate() {
				public boolean a(Entity var1) {
					int var2x = class_o.a((int) Math.floor(var1.z));
					return vvar2 > vvar3 ? (var2x >= vvar2) || (var2x <= vvar3) : (var2x >= vvar2) && (var2x <= vvar3);
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1) {
					return this.a((Entity) var1);
				}
			});
		}

		return var1;
	}

	private static List a(Map var0, Class var1, List var2, String var3, class_ago var4, class_cj var5) {
		ArrayList var6 = Lists.newArrayList();
		String var7 = b(var0, "type");
		var7 = (var7 != null) && var7.startsWith("!") ? var7.substring(1) : var7;
		boolean var8 = !var3.equals("e");
		boolean var9 = var3.equals("r") && (var7 != null);
		int var10 = a(var0, "dx", 0);
		int var11 = a(var0, "dy", 0);
		int var12 = a(var0, "dz", 0);
		int var13 = a(var0, "r", -1);
		Predicate var14 = Predicates.and((Iterable) var2);
		Predicate var15 = Predicates.and(class_rb.a, var14);
		if (var5 != null) {
			int var16 = var4.j.size();
			int var17 = var4.f.size();
			boolean var18 = var16 < (var17 / 16);
			final class_ayk var19;
			if (!var0.containsKey("dx") && !var0.containsKey("dy") && !var0.containsKey("dz")) {
				if (var13 >= 0) {
					var19 = new class_ayk(var5.n() - var13, var5.o() - var13, var5.p() - var13, var5.n() + var13 + 1, var5.o() + var13 + 1, var5.p() + var13 + 1);
					if (var8 && var18 && !var9) {
						var6.addAll(var4.b(var1, var15));
					} else {
						var6.addAll(var4.a(var1, var19, var15));
					}
				} else if (var3.equals("a")) {
					var6.addAll(var4.b(var1, var14));
				} else if (!var3.equals("p") && (!var3.equals("r") || var9)) {
					var6.addAll(var4.a(var1, var15));
				} else {
					var6.addAll(var4.b(var1, var15));
				}
			} else {
				var19 = a(var5, var10, var11, var12);
				if (var8 && var18 && !var9) {
					Predicate var20 = new Predicate() {
						public boolean a(Entity var1) {
							return (var1.s >= var19.a) && (var1.t >= var19.b) && (var1.u >= var19.c) ? (var1.s < var19.d) && (var1.t < var19.e) && (var1.u < var19.f) : false;
						}

						// $FF: synthetic method
						@Override
						public boolean apply(Object var1) {
							return this.a((Entity) var1);
						}
					};
					var6.addAll(var4.b(var1, Predicates.and(var15, var20)));
				} else {
					var6.addAll(var4.a(var1, var19, var15));
				}
			}
		} else if (var3.equals("a")) {
			var6.addAll(var4.b(var1, var14));
		} else if (!var3.equals("p") && (!var3.equals("r") || var9)) {
			var6.addAll(var4.a(var1, var15));
		} else {
			var6.addAll(var4.b(var1, var15));
		}

		return var6;
	}

	private static List a(List var0, Map var1, ICommandListener var2, Class var3, String var4, final class_cj var5) {
		int var6 = a(var1, "c", !var4.equals("a") && !var4.equals("e") ? 1 : 0);
		if (!var4.equals("p") && !var4.equals("a") && !var4.equals("e")) {
			if (var4.equals("r")) {
				Collections.shuffle(var0);
			}
		} else if (var5 != null) {
			Collections.sort(var0, new Comparator() {
				public int a(Entity var1, Entity var2) {
					return ComparisonChain.start().compare(var1.b(var5), var2.b(var5)).result();
				}

				// $FF: synthetic method
				@Override
				public int compare(Object var1, Object var2) {
					return this.a((Entity) var1, (Entity) var2);
				}
			});
		}

		Entity var7 = var2.f();
		if ((var7 != null) && var3.isAssignableFrom(var7.getClass()) && (var6 == 1) && var0.contains(var7) && !"r".equals(var4)) {
			var0 = Lists.newArrayList((Object[]) (new Entity[] { var7 }));
		}

		if (var6 != 0) {
			if (var6 < 0) {
				Collections.reverse(var0);
			}

			var0 = var0.subList(0, Math.min(Math.abs(var6), var0.size()));
		}

		return var0;
	}

	private static class_ayk a(class_cj var0, int var1, int var2, int var3) {
		boolean var4 = var1 < 0;
		boolean var5 = var2 < 0;
		boolean var6 = var3 < 0;
		int var7 = var0.n() + (var4 ? var1 : 0);
		int var8 = var0.o() + (var5 ? var2 : 0);
		int var9 = var0.p() + (var6 ? var3 : 0);
		int var10 = var0.n() + (var4 ? 0 : var1) + 1;
		int var11 = var0.o() + (var5 ? 0 : var2) + 1;
		int var12 = var0.p() + (var6 ? 0 : var3) + 1;
		return new class_ayk(var7, var8, var9, var10, var11, var12);
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

	private static class_cj b(Map var0, class_cj var1) {
		return new class_cj(a(var0, "x", var1.n()), a(var0, "y", var1.o()), a(var0, "z", var1.p()));
	}

	private static boolean i(Map var0) {
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
		return var0.containsKey(var1) ? MathHelper.a((String) var0.get(var1), var2) : var2;
	}

	private static String b(Map var0, String var1) {
		return (String) var0.get(var1);
	}

	public static Map a(Map var0) {
		HashMap var1 = Maps.newHashMap();
		Iterator var2 = var0.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			if (var3.startsWith("score_") && (var3.length() > "score_".length())) {
				var1.put(var3.substring("score_".length()), Integer.valueOf(MathHelper.a((String) var0.get(var3), 1)));
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

				if ((var5 != null) && !var4.group(1).isEmpty()) {
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
