package net.minecraft.server;

import java.util.Map;

import com.google.common.collect.Maps;

public class class_et {
	private final class_et.class_a_in_class_et a;
	private final String b;

	public class_et(class_et.class_a_in_class_et var1, String var2) {
		a = var1;
		b = var2;
	}

	public class_et.class_a_in_class_et a() {
		return a;
	}

	public String b() {
		return b;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if ((var1 != null) && (this.getClass() == var1.getClass())) {
			class_et var2 = (class_et) var1;
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
		return "ClickEvent{action=" + a + ", value=\'" + b + '\'' + '}';
	}

	@Override
	public int hashCode() {
		int var1 = a.hashCode();
		var1 = (31 * var1) + (b != null ? b.hashCode() : 0);
		return var1;
	}

	public static enum class_a_in_class_et {
		a("open_url", true),
		b("open_file", false),
		c("run_command", true),
		d("suggest_command", true),
		e("change_page", true);

		private static final Map f;
		private final boolean g;
		private final String h;

		private class_a_in_class_et(String var3, boolean var4) {
			h = var3;
			g = var4;
		}

		public boolean a() {
			return g;
		}

		public String b() {
			return h;
		}

		public static class_et.class_a_in_class_et a(String var0) {
			return (class_et.class_a_in_class_et) f.get(var0);
		}

		static {
			f = Maps.newHashMap();
			class_et.class_a_in_class_et[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_et.class_a_in_class_et var3 = var0[var2];
				f.put(var3.b(), var3);
			}

		}
	}
}
