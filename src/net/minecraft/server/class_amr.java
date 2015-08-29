package net.minecraft.server;


public class class_amr extends Block {
	public static final class_aqa N = class_aqa.a("axis", class_cq.class_a_in_class_cq.class);

	protected class_amr(class_avq var1) {
		super(var1, var1.r());
	}

	protected class_amr(class_avq var1, class_avr var2) {
		super(var1, var2);
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_amr.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
				case 2:
					switch (class_amr.SyntheticClass_1.a[((class_cq.class_a_in_class_cq) var1.b(N)).ordinal()]) {
						case 1:
							return var1.a(N, class_cq.class_a_in_class_cq.c);
						case 2:
							return var1.a(N, class_cq.class_a_in_class_cq.a);
						default:
							return var1;
					}
				default:
					return var1;
			}
		}
	}

	@Override
	public class_apn a(int var1) {
		class_cq.class_a_in_class_cq var2 = class_cq.class_a_in_class_cq.b;
		int var3 = var1 & 12;
		if (var3 == 4) {
			var2 = class_cq.class_a_in_class_cq.a;
		} else if (var3 == 8) {
			var2 = class_cq.class_a_in_class_cq.c;
		}

		return getBlockData().a(N, var2);
	}

	@Override
	public int c(class_apn var1) {
		int var2 = 0;
		class_cq.class_a_in_class_cq var3 = (class_cq.class_a_in_class_cq) var1.b(N);
		if (var3 == class_cq.class_a_in_class_cq.a) {
			var2 |= 4;
		} else if (var3 == class_cq.class_a_in_class_cq.c) {
			var2 |= 8;
		}

		return var2;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { N });
	}

	@Override
	protected class_aco i(class_apn var1) {
		return new class_aco(Item.a(this));
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(N, var3.k());
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_c_in_class_ail.values().length];

		static {
			try {
				b[Block.class_c_in_class_ail.d.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				b[Block.class_c_in_class_ail.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			a = new int[class_cq.class_a_in_class_cq.values().length];

			try {
				a[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.class_a_in_class_cq.c.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
