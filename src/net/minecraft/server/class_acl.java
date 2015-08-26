package net.minecraft.server;

import com.google.common.collect.Multimap;

public class class_acl extends Item {
	private final float b;
	protected Item.class_a_in_class_acm a;

	public class_acl(Item.class_a_in_class_acm var1) {
		a = var1;
		i = 1;
		this.e(var1.a());
		this.a(class_abp.i);
		b = MathHelper.a(var1.c() / 3.0F, 0.0F, 1.0F) * 1.0F;
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (!var2.a(var4.a(var6), var6, var1)) {
			return class_pw.c;
		} else {
			class_apn var10 = var3.p(var4);
			Block var11 = var10.c();
			if ((var6 != class_cq.a) && (var3.p(var4.a()).c().v() == class_avq.a)) {
				if ((var11 == Blocks.GRASS) || (var11 == Blocks.GRASS_PATH)) {
					this.a(var1, var2, var3, var4, Blocks.FARMLAND.S());
					return class_pw.a;
				}

				if (var11 == Blocks.DIRT) {
					switch (class_acl.SyntheticClass_1.a[((class_ajl.class_a_in_class_ajl) var10.b(class_ajl.a)).ordinal()]) {
						case 1:
							this.a(var1, var2, var3, var4, Blocks.FARMLAND.S());
							return class_pw.a;
						case 2:
							this.a(var1, var2, var3, var4, Blocks.DIRT.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.a));
							return class_pw.a;
					}
				}
			}

			return class_pw.b;
		}
	}

	@Override
	public boolean a(class_aco var1, class_rg var2, class_rg var3) {
		var1.a(1, var3);
		return true;
	}

	protected void a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_apn var5) {
		var3.a(var4.n() + 0.5F, var4.o() + 0.5F, var4.p() + 0.5F, var5.c().H.c(), (var5.c().H.d() + 1.0F) / 2.0F, var5.c().H.e() * 0.8F);
		if (!var3.D) {
			var3.a(var4, var5);
			var1.a(1, var2);
		}

	}

	public String g() {
		return a.toString();
	}

	@Override
	public Multimap a(class_rc var1) {
		Multimap var2 = super.a(var1);
		if (var1 == class_rc.a) {
			var2.put(class_yf.e.a(), new class_rr(f, "Weapon modifier", b, 0));
			var2.put(class_yf.f.a(), new class_rr(g, "Weapon modifier", 0.0D, 0));
		}

		return var2;
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_ajl.class_a_in_class_ajl.values().length];

		static {
			try {
				a[class_ajl.class_a_in_class_ajl.a.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_ajl.class_a_in_class_ajl.b.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
