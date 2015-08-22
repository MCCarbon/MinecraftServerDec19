package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_amd extends class_aig {
	public static final class_apy a = class_apy.a("powered");
	private final class_amd.class_a_in_class_amd b;

	protected class_amd(class_avq var1, class_amd.class_a_in_class_amd var2) {
		super(var1);
		this.j(M.b().a(a, Boolean.valueOf(false)));
		b = var2;
	}

	@Override
	protected int e(class_apn var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 15 : 0;
	}

	@Override
	protected class_apn a(class_apn var1, int var2) {
		return var1.a(a, Boolean.valueOf(var2 > 0));
	}

	@Override
	protected int e(class_ago var1, class_cj var2) {
		class_ayk var3 = this.a(var2);
		List var4;
		switch (class_amd.SyntheticClass_1.a[b.ordinal()]) {
			case 1:
				var4 = var1.b((class_qx) null, var3);
				break;
			case 2:
				var4 = var1.a(class_rg.class, var3);
				break;
			default:
				return 0;
		}

		if (!var4.isEmpty()) {
			Iterator var5 = var4.iterator();

			while (var5.hasNext()) {
				class_qx var6 = (class_qx) var5.next();
				if (!var6.aO()) {
					return 15;
				}
			}
		}

		return 0;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Boolean.valueOf(var1 == 1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_amd.class_a_in_class_amd.values().length];

		static {
			try {
				a[class_amd.class_a_in_class_amd.a.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_amd.class_a_in_class_amd.b.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_amd {
		a,
		b;
	}
}
