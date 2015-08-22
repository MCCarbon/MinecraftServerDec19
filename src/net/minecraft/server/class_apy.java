package net.minecraft.server;

import java.util.Collection;

import com.google.common.collect.ImmutableSet;

public class class_apy extends class_apx {
	private final ImmutableSet a = ImmutableSet.of(Boolean.valueOf(true), Boolean.valueOf(false));

	protected class_apy(String var1) {
		super(var1, Boolean.class);
	}

	@Override
	public Collection c() {
		return a;
	}

	public static class_apy a(String var0) {
		return new class_apy(var0);
	}

	public String a(Boolean var1) {
		return var1.toString();
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if ((var1 instanceof class_apy) && super.equals(var1)) {
			class_apy var2 = (class_apy) var1;
			return a.equals(var2.a);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (31 * super.hashCode()) + a.hashCode();
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public String a(Comparable var1) {
		return this.a((Boolean) var1);
	}
}
