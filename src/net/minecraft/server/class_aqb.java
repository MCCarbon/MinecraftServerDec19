package net.minecraft.server;

import java.util.Collection;
import java.util.HashSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class class_aqb extends class_apx {
	private final ImmutableSet a;

	protected class_aqb(String var1, int var2, int var3) {
		super(var1, Integer.class);
		if (var2 < 0) {
			throw new IllegalArgumentException("Min value of " + var1 + " must be 0 or greater");
		} else if (var3 <= var2) {
			throw new IllegalArgumentException("Max value of " + var1 + " must be greater than min (" + var2 + ")");
		} else {
			HashSet var4 = Sets.newHashSet();

			for (int var5 = var2; var5 <= var3; ++var5) {
				var4.add(Integer.valueOf(var5));
			}

			a = ImmutableSet.copyOf((Collection) var4);
		}
	}

	@Override
	public Collection c() {
		return a;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if ((var1 instanceof class_aqb) && super.equals(var1)) {
			class_aqb var2 = (class_aqb) var1;
			return a.equals(var2.a);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (31 * super.hashCode()) + a.hashCode();
	}

	public static class_aqb a(String var0, int var1, int var2) {
		return new class_aqb(var0, var1, var2);
	}

	public String a(Integer var1) {
		return var1.toString();
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public String a(Comparable var1) {
		return this.a((Integer) var1);
	}
}
