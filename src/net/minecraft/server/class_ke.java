package net.minecraft.server;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class class_ke {
	protected final String a;
	protected final String b;

	protected class_ke(int var1, String... var2) {
		a = StringUtils.isEmpty(var2[0]) ? "minecraft" : var2[0].toLowerCase();
		b = var2[1];
		Validate.notNull(b);
	}

	public class_ke(String var1) {
		this(0, a(var1));
	}

	protected static String[] a(String var0) {
		String[] var1 = new String[] { "minecraft", var0 };
		int var2 = var0.indexOf(58);
		if (var2 >= 0) {
			var1[1] = var0.substring(var2 + 1, var0.length());
			if (var2 > 1) {
				var1[0] = var0.substring(0, var2);
			}
		}

		return var1;
	}

	public String a() {
		return b;
	}

	public String b() {
		return a;
	}

	@Override
	public String toString() {
		return a + ':' + b;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_ke)) {
			return false;
		} else {
			class_ke var2 = (class_ke) var1;
			return a.equals(var2.a) && b.equals(var2.b);
		}
	}

	@Override
	public int hashCode() {
		return (31 * a.hashCode()) + b.hashCode();
	}
}
