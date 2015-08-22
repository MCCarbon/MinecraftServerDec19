package net.minecraft.server;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;

public abstract class class_ayu {
	public boolean a(class_ayu var1) {
		return var1 == null ? false : this == var1;
	}

	public abstract String b();

	public abstract String d(String var1);

	public abstract boolean g();

	public abstract EnumChatFormat l();

	public abstract Collection d();

	public abstract class_ayu.class_a_in_class_ayu j();

	public static enum class_a_in_class_ayu {
		a("always", 0),
		b("never", 1),
		c("hideForOtherTeams", 2),
		d("hideForOwnTeam", 3);

		private static Map g;
		public final String e;
		public final int f;

		public static String[] a() {
			return (String[]) g.keySet().toArray(new String[g.size()]);
		}

		public static class_ayu.class_a_in_class_ayu a(String var0) {
			return (class_ayu.class_a_in_class_ayu) g.get(var0);
		}

		private class_a_in_class_ayu(String var3, int var4) {
			e = var3;
			f = var4;
		}

		static {
			g = Maps.newHashMap();
			class_ayu.class_a_in_class_ayu[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ayu.class_a_in_class_ayu var3 = var0[var2];
				g.put(var3.e, var3);
			}

		}
	}
}
