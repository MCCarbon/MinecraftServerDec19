package net.minecraft.server;


public class class_any extends class_amw {
	public static final class_apz a;

	public class_any() {
		this.j(M.b().a(a, class_cq.c));
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_cq var3 = (class_cq) var1.p(var2).b(a);
		float var4 = 0.28125F;
		float var5 = 0.78125F;
		float var6 = 0.0F;
		float var7 = 1.0F;
		float var8 = 0.125F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		switch (class_any.SyntheticClass_1.a[var3.ordinal()]) {
			case 1:
				this.a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
				break;
			case 2:
				this.a(var6, var4, 0.0F, var7, var5, var8);
				break;
			case 3:
				this.a(1.0F - var8, var4, var6, 1.0F, var5, var7);
				break;
			case 4:
				this.a(0.0F, var4, var6, var8, var5, var7);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		class_cq var5 = (class_cq) var3.b(a);
		if (!var1.p(var2.a(var5.d())).c().v().a()) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
	}

	@Override
	public class_apn a(int var1) {
		class_cq var2 = class_cq.a(var1);
		if (var2.k() == class_cq.class_a_in_class_cq.b) {
			var2 = class_cq.c;
		}

		return S().a(a, var2);
	}

	@Override
	public int c(class_apn var1) {
		return ((class_cq) var1.b(a)).a();
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	static {
		a = class_akx.O;
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.c.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
