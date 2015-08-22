package net.minecraft.server;


public class class_ant extends Block {
	public static final class_apz a;
	public static final class_apy b;
	public static final class_aqa N;

	protected class_ant(class_avq var1) {
		super(var1);
		this.j(M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)).a(N, class_ant.class_a_in_class_ant.b));
		float var2 = 0.5F;
		float var3 = 1.0F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.a(class_abp.d);
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean b(class_ags var1, class_cj var2) {
		return !((Boolean) var1.p(var2).b(b)).booleanValue();
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		this.d(var3);
		return super.a(var1, var2, var3);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.d(var1.p(var2));
	}

	private void d(class_apn var1) {
		boolean var2 = var1.b(N) == class_ant.class_a_in_class_ant.a;
		Boolean var3 = (Boolean) var1.b(b);
		class_cq var4 = (class_cq) var1.b(a);
		float var5 = 0.1875F;
		if (var2) {
			this.a(0.0F, 0.8125F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
		}

		if (var3.booleanValue()) {
			if (var4 == class_cq.c) {
				this.a(0.0F, 0.0F, 0.8125F, 1.0F, 1.0F, 1.0F);
			}

			if (var4 == class_cq.d) {
				this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
			}

			if (var4 == class_cq.e) {
				this.a(0.8125F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}

			if (var4 == class_cq.f) {
				this.a(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
			}
		}

	}

	@Override
	public void j() {
		float var1 = 0.1875F;
		this.a(0.0F, 0.40625F, 0.0F, 1.0F, 0.59375F, 1.0F);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (J == class_avq.f) {
			return true;
		} else {
			var3 = var3.a(b);
			var1.a(var2, var3, 2);
			var1.a(var4, ((Boolean) var3.b(b)).booleanValue() ? 1003 : 1006, var2, 0);
			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.D) {
			boolean var5 = var1.z(var2);
			if (var5 || var4.i()) {
				boolean var6 = ((Boolean) var3.b(b)).booleanValue();
				if (var6 != var5) {
					var1.a(var2, var3.a(b, Boolean.valueOf(var5)), 2);
					var1.a((class_yu) null, var5 ? 1003 : 1006, var2, 0);
				}
			}

		}
	}

	@Override
	public class_ayl a(class_ago var1, class_cj var2, class_aym var3, class_aym var4) {
		this.a((class_ags) var1, var2);
		return super.a(var1, var2, var3, var4);
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		class_apn var9 = S();
		if (var3.k().c()) {
			var9 = var9.a(a, var3).a(b, Boolean.valueOf(false));
			var9 = var9.a(N, var5 > 0.5F ? class_ant.class_a_in_class_ant.a : class_ant.class_a_in_class_ant.b);
		}

		return var9;
	}

	@Override
	public boolean b(class_ago var1, class_cj var2, class_cq var3) {
		return true;
	}

	protected static class_cq b(int var0) {
		switch (var0 & 3) {
			case 0:
				return class_cq.c;
			case 1:
				return class_cq.d;
			case 2:
				return class_cq.e;
			case 3:
			default:
				return class_cq.f;
		}
	}

	protected static int a(class_cq var0) {
		switch (class_ant.SyntheticClass_1.a[var0.ordinal()]) {
			case 1:
				return 0;
			case 2:
				return 1;
			case 3:
				return 2;
			case 4:
			default:
				return 3;
		}
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, b(var1)).a(b, Boolean.valueOf((var1 & 4) != 0)).a(N, (var1 & 8) == 0 ? class_ant.class_a_in_class_ant.b : class_ant.class_a_in_class_ant.a);
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | a((class_cq) var1.b(a));
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 4;
		}

		if (var1.b(N) == class_ant.class_a_in_class_ant.a) {
			var3 |= 8;
		}

		return var3;
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
		return new class_apo(this, new class_aqc[] { a, b, N });
	}

	static {
		a = class_akx.O;
		b = class_apy.a("open");
		N = class_aqa.a("half", class_ant.class_a_in_class_ant.class);
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

	public static enum class_a_in_class_ant implements class_oe {
		a("top"),
		b("bottom");

		private final String c;

		private class_a_in_class_ant(String var3) {
			c = var3;
		}

		@Override
		public String toString() {
			return c;
		}

		@Override
		public String l() {
			return c;
		}
	}
}
