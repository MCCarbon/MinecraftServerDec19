package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_ays {
	private final Map a = Maps.newHashMap();
	private final Map b = Maps.newHashMap();
	private final Map c = Maps.newHashMap();
	private final class_ayo[] d = new class_ayo[19];
	private final Map e = Maps.newHashMap();
	private final Map f = Maps.newHashMap();
	private static String[] g = null;

	public class_ayo b(String var1) {
		return (class_ayo) a.get(var1);
	}

	public class_ayo a(String var1, class_ayy var2) {
		if (var1.length() > 16) {
			throw new IllegalArgumentException("The objective name \'" + var1 + "\' is too long!");
		} else {
			class_ayo var3 = this.b(var1);
			if (var3 != null) {
				throw new IllegalArgumentException("An objective with the name \'" + var1 + "\' already exists!");
			} else {
				var3 = new class_ayo(this, var1, var2);
				Object var4 = b.get(var2);
				if (var4 == null) {
					var4 = Lists.newArrayList();
					b.put(var2, var4);
				}

				((List) var4).add(var3);
				a.put(var1, var3);
				this.a(var3);
				return var3;
			}
		}
	}

	public Collection a(class_ayy var1) {
		Collection var2 = (Collection) b.get(var1);
		return var2 == null ? Lists.newArrayList() : Lists.newArrayList((Iterable) var2);
	}

	public boolean b(String var1, class_ayo var2) {
		Map var3 = (Map) c.get(var1);
		if (var3 == null) {
			return false;
		} else {
			class_ayq var4 = (class_ayq) var3.get(var2);
			return var4 != null;
		}
	}

	public class_ayq c(String var1, class_ayo var2) {
		if (var1.length() > 40) {
			throw new IllegalArgumentException("The player name \'" + var1 + "\' is too long!");
		} else {
			Object var3 = c.get(var1);
			if (var3 == null) {
				var3 = Maps.newHashMap();
				c.put(var1, var3);
			}

			class_ayq var4 = (class_ayq) ((Map) var3).get(var2);
			if (var4 == null) {
				var4 = new class_ayq(this, var2, var1);
				((Map) var3).put(var2, var4);
			}

			return var4;
		}
	}

	public Collection i(class_ayo var1) {
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = c.values().iterator();

		while (var3.hasNext()) {
			Map var4 = (Map) var3.next();
			class_ayq var5 = (class_ayq) var4.get(var1);
			if (var5 != null) {
				var2.add(var5);
			}
		}

		Collections.sort(var2, class_ayq.a);
		return var2;
	}

	public Collection c() {
		return a.values();
	}

	public Collection d() {
		return c.keySet();
	}

	public void d(String var1, class_ayo var2) {
		Map var3;
		if (var2 == null) {
			var3 = (Map) c.remove(var1);
			if (var3 != null) {
				this.a(var1);
			}
		} else {
			var3 = (Map) c.get(var1);
			if (var3 != null) {
				class_ayq var4 = (class_ayq) var3.remove(var2);
				if (var3.size() < 1) {
					Map var5 = (Map) c.remove(var1);
					if (var5 != null) {
						this.a(var1);
					}
				} else if (var4 != null) {
					this.a(var1, var2);
				}
			}
		}

	}

	public Collection e() {
		Collection var1 = c.values();
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			Map var4 = (Map) var3.next();
			var2.addAll(var4.values());
		}

		return var2;
	}

	public Map c(String var1) {
		Object var2 = c.get(var1);
		if (var2 == null) {
			var2 = Maps.newHashMap();
		}

		return (Map) var2;
	}

	public void k(class_ayo var1) {
		a.remove(var1.b());

		for (int var2 = 0; var2 < 19; ++var2) {
			if (this.a(var2) == var1) {
				this.a(var2, (class_ayo) null);
			}
		}

		List var5 = (List) b.get(var1.c());
		if (var5 != null) {
			var5.remove(var1);
		}

		Iterator var3 = c.values().iterator();

		while (var3.hasNext()) {
			Map var4 = (Map) var3.next();
			var4.remove(var1);
		}

		this.c(var1);
	}

	public void a(int var1, class_ayo var2) {
		d[var1] = var2;
	}

	public class_ayo a(int var1) {
		return d[var1];
	}

	public class_ayp d(String var1) {
		return (class_ayp) e.get(var1);
	}

	public class_ayp e(String var1) {
		if (var1.length() > 16) {
			throw new IllegalArgumentException("The team name \'" + var1 + "\' is too long!");
		} else {
			class_ayp var2 = this.d(var1);
			if (var2 != null) {
				throw new IllegalArgumentException("A team with the name \'" + var1 + "\' already exists!");
			} else {
				var2 = new class_ayp(this, var1);
				e.put(var1, var2);
				this.a(var2);
				return var2;
			}
		}
	}

	public void d(class_ayp var1) {
		e.remove(var1.b());
		Iterator var2 = var1.d().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			f.remove(var3);
		}

		this.c(var1);
	}

	public boolean a(String var1, String var2) {
		if (var1.length() > 40) {
			throw new IllegalArgumentException("The player name \'" + var1 + "\' is too long!");
		} else if (!e.containsKey(var2)) {
			return false;
		} else {
			class_ayp var3 = this.d(var2);
			if (this.h(var1) != null) {
				this.f(var1);
			}

			f.put(var1, var3);
			var3.d().add(var1);
			return true;
		}
	}

	public boolean f(String var1) {
		class_ayp var2 = this.h(var1);
		if (var2 != null) {
			this.a(var1, var2);
			return true;
		} else {
			return false;
		}
	}

	public void a(String var1, class_ayp var2) {
		if (this.h(var1) != var2) {
			throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team \'" + var2.b() + "\'.");
		} else {
			f.remove(var1);
			var2.d().remove(var1);
		}
	}

	public Collection f() {
		return e.keySet();
	}

	public Collection g() {
		return e.values();
	}

	public class_ayp h(String var1) {
		return (class_ayp) f.get(var1);
	}

	public void a(class_ayo var1) {
	}

	public void b(class_ayo var1) {
	}

	public void c(class_ayo var1) {
	}

	public void a(class_ayq var1) {
	}

	public void a(String var1) {
	}

	public void a(String var1, class_ayo var2) {
	}

	public void a(class_ayp var1) {
	}

	public void b(class_ayp var1) {
	}

	public void c(class_ayp var1) {
	}

	public static String b(int var0) {
		switch (var0) {
			case 0:
				return "list";
			case 1:
				return "sidebar";
			case 2:
				return "belowName";
			default:
				if ((var0 >= 3) && (var0 <= 18)) {
					EnumChatFormat var1 = EnumChatFormat.getById(var0 - 3);
					if ((var1 != null) && (var1 != EnumChatFormat.RESET)) {
						return "sidebar.team." + var1.e();
					}
				}

				return null;
		}
	}

	public static int i(String var0) {
		if (var0.equalsIgnoreCase("list")) {
			return 0;
		} else if (var0.equalsIgnoreCase("sidebar")) {
			return 1;
		} else if (var0.equalsIgnoreCase("belowName")) {
			return 2;
		} else {
			if (var0.startsWith("sidebar.team.")) {
				String var1 = var0.substring("sidebar.team.".length());
				EnumChatFormat var2 = EnumChatFormat.getByName(var1);
				if ((var2 != null) && (var2.getId() >= 0)) {
					return var2.getId() + 3;
				}
			}

			return -1;
		}
	}

	public static String[] h() {
		if (g == null) {
			g = new String[19];

			for (int var0 = 0; var0 < 19; ++var0) {
				g[var0] = b(var0);
			}
		}

		return g;
	}

	public void a(class_qx var1) {
		if ((var1 != null) && !(var1 instanceof class_yu) && !var1.al()) {
			String var2 = var1.aQ().toString();
			this.d(var2, (class_ayo) null);
			this.f(var2);
		}
	}
}
