package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class class_ed {
	private static final Logger a = LogManager.getLogger();
	private static final Pattern b = Pattern.compile("\\[[-+\\d|,\\s]+\\]");

	public static class_dn a(String var0) throws class_ec {
		var0 = var0.trim();
		if (!var0.startsWith("{")) {
			throw new class_ec("Invalid tag encountered, expected \'{\' as first char.");
		} else if (b(var0) != 1) {
			throw new class_ec("Encountered multiple top tags, only one expected");
		} else {
			return (class_dn) a("tag", var0).a();
		}
	}

	static int b(String var0) throws class_ec {
		int var1 = 0;
		boolean var2 = false;
		Stack var3 = new Stack();

		for (int var4 = 0; var4 < var0.length(); ++var4) {
			char var5 = var0.charAt(var4);
			if (var5 == 34) {
				if (b(var0, var4)) {
					if (!var2) {
						throw new class_ec("Illegal use of \\\": " + var0);
					}
				} else {
					var2 = !var2;
				}
			} else if (!var2) {
				if ((var5 != 123) && (var5 != 91)) {
					if ((var5 == 125) && (var3.isEmpty() || (((Character) var3.pop()).charValue() != 123))) {
						throw new class_ec("Unbalanced curly brackets {}: " + var0);
					}

					if ((var5 == 93) && (var3.isEmpty() || (((Character) var3.pop()).charValue() != 91))) {
						throw new class_ec("Unbalanced square brackets []: " + var0);
					}
				} else {
					if (var3.isEmpty()) {
						++var1;
					}

					var3.push(Character.valueOf(var5));
				}
			}
		}

		if (var2) {
			throw new class_ec("Unbalanced quotation: " + var0);
		} else if (!var3.isEmpty()) {
			throw new class_ec("Unbalanced brackets: " + var0);
		} else {
			if ((var1 == 0) && !var0.isEmpty()) {
				var1 = 1;
			}

			return var1;
		}
	}

	static class_ed.class_a_in_class_ed a(String... var0) throws class_ec {
		return a(var0[0], var0[1]);
	}

	static class_ed.class_a_in_class_ed a(String var0, String var1) throws class_ec {
		var1 = var1.trim();
		String var3;
		boolean var4;
		char var6;
		if (var1.startsWith("{")) {
			var1 = var1.substring(1, var1.length() - 1);

			class_ed.class_b_in_class_ed var5;
			for (var5 = new class_ed.class_b_in_class_ed(var0); var1.length() > 0; var1 = var1.substring(var3.length() + 1)) {
				var3 = b(var1, true);
				if (var3.length() > 0) {
					var4 = false;
					var5.b.add(a(var3, var4));
				}

				if (var1.length() < (var3.length() + 1)) {
					break;
				}

				var6 = var1.charAt(var3.length());
				if ((var6 != 44) && (var6 != 123) && (var6 != 125) && (var6 != 91) && (var6 != 93)) {
					throw new class_ec("Unexpected token \'" + var6 + "\' at: " + var1.substring(var3.length()));
				}
			}

			return var5;
		} else if (var1.startsWith("[") && !b.matcher(var1).matches()) {
			var1 = var1.substring(1, var1.length() - 1);

			class_ed.class_c_in_class_ed var2;
			for (var2 = new class_ed.class_c_in_class_ed(var0); var1.length() > 0; var1 = var1.substring(var3.length() + 1)) {
				var3 = b(var1, false);
				if (var3.length() > 0) {
					var4 = true;
					var2.b.add(a(var3, var4));
				}

				if (var1.length() < (var3.length() + 1)) {
					break;
				}

				var6 = var1.charAt(var3.length());
				if ((var6 != 44) && (var6 != 123) && (var6 != 125) && (var6 != 91) && (var6 != 93)) {
					throw new class_ec("Unexpected token \'" + var6 + "\' at: " + var1.substring(var3.length()));
				}
			}

			return var2;
		} else {
			return new class_ed.class_d_in_class_ed(var0, var1);
		}
	}

	private static class_ed.class_a_in_class_ed a(String var0, boolean var1) throws class_ec {
		String var2 = c(var0, var1);
		String var3 = d(var0, var1);
		return a(new String[] { var2, var3 });
	}

	private static String b(String var0, boolean var1) throws class_ec {
		int var2 = a(var0, ':');
		int var3 = a(var0, ',');
		if (var1) {
			if (var2 == -1) {
				throw new class_ec("Unable to locate name/value separator for string: " + var0);
			}

			if ((var3 != -1) && (var3 < var2)) {
				throw new class_ec("Name error at: " + var0);
			}
		} else if ((var2 == -1) || (var2 > var3)) {
			var2 = -1;
		}

		return a(var0, var2);
	}

	private static String a(String var0, int var1) throws class_ec {
		Stack var2 = new Stack();
		int var3 = var1 + 1;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;

		for (int var7 = 0; var3 < var0.length(); ++var3) {
			char var8 = var0.charAt(var3);
			if (var8 == 34) {
				if (b(var0, var3)) {
					if (!var4) {
						throw new class_ec("Illegal use of \\\": " + var0);
					}
				} else {
					var4 = !var4;
					if (var4 && !var6) {
						var5 = true;
					}

					if (!var4) {
						var7 = var3;
					}
				}
			} else if (!var4) {
				if ((var8 != 123) && (var8 != 91)) {
					if ((var8 == 125) && (var2.isEmpty() || (((Character) var2.pop()).charValue() != 123))) {
						throw new class_ec("Unbalanced curly brackets {}: " + var0);
					}

					if ((var8 == 93) && (var2.isEmpty() || (((Character) var2.pop()).charValue() != 91))) {
						throw new class_ec("Unbalanced square brackets []: " + var0);
					}

					if ((var8 == 44) && var2.isEmpty()) {
						return var0.substring(0, var3);
					}
				} else {
					var2.push(Character.valueOf(var8));
				}
			}

			if (!Character.isWhitespace(var8)) {
				if (!var4 && var5 && (var7 != var3)) {
					return var0.substring(0, var7 + 1);
				}

				var6 = true;
			}
		}

		return var0.substring(0, var3);
	}

	private static String c(String var0, boolean var1) throws class_ec {
		if (var1) {
			var0 = var0.trim();
			if (var0.startsWith("{") || var0.startsWith("[")) {
				return "";
			}
		}

		int var2 = a(var0, ':');
		if (var2 == -1) {
			if (var1) {
				return "";
			} else {
				throw new class_ec("Unable to locate name/value separator for string: " + var0);
			}
		} else {
			return var0.substring(0, var2).trim();
		}
	}

	private static String d(String var0, boolean var1) throws class_ec {
		if (var1) {
			var0 = var0.trim();
			if (var0.startsWith("{") || var0.startsWith("[")) {
				return var0;
			}
		}

		int var2 = a(var0, ':');
		if (var2 == -1) {
			if (var1) {
				return var0;
			} else {
				throw new class_ec("Unable to locate name/value separator for string: " + var0);
			}
		} else {
			return var0.substring(var2 + 1).trim();
		}
	}

	private static int a(String var0, char var1) {
		int var2 = 0;

		for (boolean var3 = true; var2 < var0.length(); ++var2) {
			char var4 = var0.charAt(var2);
			if (var4 == 34) {
				if (!b(var0, var2)) {
					var3 = !var3;
				}
			} else if (var3) {
				if (var4 == var1) {
					return var2;
				}

				if ((var4 == 123) || (var4 == 91)) {
					return -1;
				}
			}
		}

		return -1;
	}

	private static boolean b(String var0, int var1) {
		return (var1 > 0) && (var0.charAt(var1 - 1) == 92) && !b(var0, var1 - 1);
	}

	static class class_d_in_class_ed extends class_ed.class_a_in_class_ed {
		private static final Pattern c = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[d|D]");
		private static final Pattern d = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[f|F]");
		private static final Pattern e = Pattern.compile("[-+]?[0-9]+[b|B]");
		private static final Pattern f = Pattern.compile("[-+]?[0-9]+[l|L]");
		private static final Pattern g = Pattern.compile("[-+]?[0-9]+[s|S]");
		private static final Pattern h = Pattern.compile("[-+]?[0-9]+");
		private static final Pattern i = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
		private static final Splitter j = Splitter.on(',').omitEmptyStrings();
		protected String b;

		public class_d_in_class_ed(String var1, String var2) {
			a = var1;
			b = var2;
		}

		@Override
		public class_eb a() throws class_ec {
			try {
				if (c.matcher(b).matches()) {
					return new class_dp(Double.parseDouble(b.substring(0, b.length() - 1)));
				}

				if (d.matcher(b).matches()) {
					return new class_dr(Float.parseFloat(b.substring(0, b.length() - 1)));
				}

				if (e.matcher(b).matches()) {
					return new class_dm(Byte.parseByte(b.substring(0, b.length() - 1)));
				}

				if (f.matcher(b).matches()) {
					return new class_dv(Long.parseLong(b.substring(0, b.length() - 1)));
				}

				if (g.matcher(b).matches()) {
					return new class_dz(Short.parseShort(b.substring(0, b.length() - 1)));
				}

				if (h.matcher(b).matches()) {
					return new class_dt(Integer.parseInt(b));
				}

				if (i.matcher(b).matches()) {
					return new class_dp(Double.parseDouble(b));
				}

				if (b.equalsIgnoreCase("true") || b.equalsIgnoreCase("false")) {
					return new class_dm((byte) (Boolean.parseBoolean(b) ? 1 : 0));
				}
			} catch (NumberFormatException var6) {
				b = b.replaceAll("\\\\\"", "\"");
				return new class_ea(b);
			}

			if (b.startsWith("[") && b.endsWith("]")) {
				String var7 = b.substring(1, b.length() - 1);
				String[] var8 = Iterables.toArray(j.split(var7), String.class);

				try {
					int[] var3 = new int[var8.length];

					for (int var4 = 0; var4 < var8.length; ++var4) {
						var3[var4] = Integer.parseInt(var8[var4].trim());
					}

					return new class_ds(var3);
				} catch (NumberFormatException var5) {
					return new class_ea(b);
				}
			} else {
				if (b.startsWith("\"") && b.endsWith("\"")) {
					b = b.substring(1, b.length() - 1);
				}

				b = b.replaceAll("\\\\\"", "\"");
				StringBuilder var1 = new StringBuilder();

				for (int var2 = 0; var2 < b.length(); ++var2) {
					if ((var2 < (b.length() - 1)) && (b.charAt(var2) == 92) && (b.charAt(var2 + 1) == 92)) {
						var1.append('\\');
						++var2;
					} else {
						var1.append(b.charAt(var2));
					}
				}

				return new class_ea(var1.toString());
			}
		}
	}

	static class class_c_in_class_ed extends class_ed.class_a_in_class_ed {
		protected List b = Lists.newArrayList();

		public class_c_in_class_ed(String var1) {
			a = var1;
		}

		@Override
		public class_eb a() throws class_ec {
			class_du var1 = new class_du();
			Iterator var2 = b.iterator();

			while (var2.hasNext()) {
				class_ed.class_a_in_class_ed var3 = (class_ed.class_a_in_class_ed) var2.next();
				var1.a(var3.a());
			}

			return var1;
		}
	}

	static class class_b_in_class_ed extends class_ed.class_a_in_class_ed {
		protected List b = Lists.newArrayList();

		public class_b_in_class_ed(String var1) {
			a = var1;
		}

		@Override
		public class_eb a() throws class_ec {
			class_dn var1 = new class_dn();
			Iterator var2 = b.iterator();

			while (var2.hasNext()) {
				class_ed.class_a_in_class_ed var3 = (class_ed.class_a_in_class_ed) var2.next();
				var1.a(var3.a, var3.a());
			}

			return var1;
		}
	}

	abstract static class class_a_in_class_ed {
		protected String a;

		public abstract class_eb a() throws class_ec;
	}
}
