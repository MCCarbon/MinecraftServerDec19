package net.minecraft.server;

import java.util.Map;

import com.google.common.collect.Maps;

public class class_ew {
	private final class_ew.class_a_in_class_ew a;
	private final IChatBaseComponent b;

	public class_ew(class_ew.class_a_in_class_ew var1, IChatBaseComponent var2) {
		a = var1;
		b = var2;
	}

	public class_ew.class_a_in_class_ew a() {
		return a;
	}

	public IChatBaseComponent b() {
		return b;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if ((var1 != null) && (this.getClass() == var1.getClass())) {
			class_ew var2 = (class_ew) var1;
			if (a != var2.a) {
				return false;
			} else {
				if (b != null) {
					if (!b.equals(var2.b)) {
						return false;
					}
				} else if (var2.b != null) {
					return false;
				}

				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "HoverEvent{action=" + a + ", value=\'" + b + '\'' + '}';
	}

	@Override
	public int hashCode() {
		int var1 = a.hashCode();
		var1 = (31 * var1) + (b != null ? b.hashCode() : 0);
		return var1;
	}

	public static enum class_a_in_class_ew {
		a("show_text", true),
		b("show_achievement", true),
		c("show_item", true),
		d("show_entity", true);

		private static final Map e;
		private final boolean f;
		private final String g;

		private class_a_in_class_ew(String var3, boolean var4) {
			g = var3;
			f = var4;
		}

		public boolean a() {
			return f;
		}

		public String b() {
			return g;
		}

		public static class_ew.class_a_in_class_ew a(String var0) {
			return (class_ew.class_a_in_class_ew) e.get(var0);
		}

		static {
			e = Maps.newHashMap();
			class_ew.class_a_in_class_ew[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ew.class_a_in_class_ew var3 = var0[var2];
				e.put(var3.b(), var3);
			}

		}
	}
}
