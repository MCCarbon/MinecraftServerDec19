package net.minecraft.server;


public class class_lu implements class_jf {
	private final MinecraftServer a;
	private final class_ek b;

	public class_lu(MinecraftServer var1, class_ek var2) {
		a = var1;
		b = var2;
	}

	@Override
	public void a(class_je var1) {
		switch (class_lu.SyntheticClass_1.a[var1.a().ordinal()]) {
			case 1:
				b.a(class_el.d);
				class_fa var2;
				if (var1.b() > 61) {
					var2 = new class_fa("Outdated server! I\'m still on 15w34d");
					b.a((new class_jl(var2)));
					b.a(var2);
				} else if (var1.b() < 61) {
					var2 = new class_fa("Outdated client! Please use 15w34d");
					b.a((new class_jl(var2)));
					b.a(var2);
				} else {
					b.a((new class_lv(a, b)));
				}
				break;
			case 2:
				b.a(class_el.c);
				b.a((new class_lw(a, b)));
				break;
			default:
				throw new UnsupportedOperationException("Invalid intention " + var1.a());
		}

	}

	@Override
	public void a(class_eu var1) {
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_el.values().length];

		static {
			try {
				a[class_el.d.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_el.c.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
