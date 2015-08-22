package net.minecraft.server;

import com.google.common.base.Objects;

public abstract class class_apx implements class_aqc {
	private final Class a;
	private final String b;

	protected class_apx(String var1, Class var2) {
		a = var2;
		b = var1;
	}

	@Override
	public String a() {
		return b;
	}

	@Override
	public Class b() {
		return a;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("name", b).add("clazz", a).add("values", c()).toString();
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_apx)) {
			return false;
		} else {
			class_apx var2 = (class_apx) var1;
			return a.equals(var2.a) && b.equals(var2.b);
		}
	}

	@Override
	public int hashCode() {
		return (31 * a.hashCode()) + b.hashCode();
	}
}
