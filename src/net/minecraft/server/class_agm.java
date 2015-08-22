package net.minecraft.server;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class class_agm {
	private TreeMap a = new TreeMap();

	public class_agm() {
		this.a("doFireTick", "true", class_agm.class_b_in_class_agm.b);
		this.a("mobGriefing", "true", class_agm.class_b_in_class_agm.b);
		this.a("keepInventory", "false", class_agm.class_b_in_class_agm.b);
		this.a("doMobSpawning", "true", class_agm.class_b_in_class_agm.b);
		this.a("doMobLoot", "true", class_agm.class_b_in_class_agm.b);
		this.a("doTileDrops", "true", class_agm.class_b_in_class_agm.b);
		this.a("doEntityDrops", "true", class_agm.class_b_in_class_agm.b);
		this.a("commandBlockOutput", "true", class_agm.class_b_in_class_agm.b);
		this.a("naturalRegeneration", "true", class_agm.class_b_in_class_agm.b);
		this.a("doDaylightCycle", "true", class_agm.class_b_in_class_agm.b);
		this.a("logAdminCommands", "true", class_agm.class_b_in_class_agm.b);
		this.a("showDeathMessages", "true", class_agm.class_b_in_class_agm.b);
		this.a("randomTickSpeed", "3", class_agm.class_b_in_class_agm.c);
		this.a("sendCommandFeedback", "true", class_agm.class_b_in_class_agm.b);
		this.a("reducedDebugInfo", "false", class_agm.class_b_in_class_agm.b);
	}

	public void a(String var1, String var2, class_agm.class_b_in_class_agm var3) {
		a.put(var1, new class_agm.class_a_in_class_agm(var2, var3));
	}

	public void a(String var1, String var2) {
		class_agm.class_a_in_class_agm var3 = (class_agm.class_a_in_class_agm) a.get(var1);
		if (var3 != null) {
			var3.a(var2);
		} else {
			this.a(var1, var2, class_agm.class_b_in_class_agm.a);
		}

	}

	public String a(String var1) {
		class_agm.class_a_in_class_agm var2 = (class_agm.class_a_in_class_agm) a.get(var1);
		return var2 != null ? var2.a() : "";
	}

	public boolean b(String var1) {
		class_agm.class_a_in_class_agm var2 = (class_agm.class_a_in_class_agm) a.get(var1);
		return var2 != null ? var2.b() : false;
	}

	public int c(String var1) {
		class_agm.class_a_in_class_agm var2 = (class_agm.class_a_in_class_agm) a.get(var1);
		return var2 != null ? var2.c() : 0;
	}

	public class_dn a() {
		class_dn var1 = new class_dn();
		Iterator var2 = a.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			class_agm.class_a_in_class_agm var4 = (class_agm.class_a_in_class_agm) a.get(var3);
			var1.a(var3, var4.a());
		}

		return var1;
	}

	public void a(class_dn var1) {
		Set var2 = var1.c();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			String var6 = var1.l(var4);
			this.a(var4, var6);
		}

	}

	public String[] b() {
		Set var1 = a.keySet();
		return (String[]) var1.toArray(new String[var1.size()]);
	}

	public boolean e(String var1) {
		return a.containsKey(var1);
	}

	public boolean a(String var1, class_agm.class_b_in_class_agm var2) {
		class_agm.class_a_in_class_agm var3 = (class_agm.class_a_in_class_agm) a.get(var1);
		return (var3 != null) && ((var3.e() == var2) || (var2 == class_agm.class_b_in_class_agm.a));
	}

	public static enum class_b_in_class_agm {
		a,
		b,
		c;
	}

	static class class_a_in_class_agm {
		private String a;
		private boolean b;
		private int c;
		private double d;
		private final class_agm.class_b_in_class_agm e;

		public class_a_in_class_agm(String var1, class_agm.class_b_in_class_agm var2) {
			e = var2;
			this.a(var1);
		}

		public void a(String var1) {
			a = var1;
			b = Boolean.parseBoolean(var1);
			c = b ? 1 : 0;

			try {
				c = Integer.parseInt(var1);
			} catch (NumberFormatException var4) {
				;
			}

			try {
				d = Double.parseDouble(var1);
			} catch (NumberFormatException var3) {
				;
			}

		}

		public String a() {
			return a;
		}

		public boolean b() {
			return b;
		}

		public int c() {
			return c;
		}

		public class_agm.class_b_in_class_agm e() {
			return e;
		}
	}
}
