package net.minecraft.server;

import java.util.Iterator;

public class class_ale extends Block {
	public static final class_aqa a = class_aqa.a("facing", class_ale.class_a_in_class_ale.class);
	public static final class_apy b = class_apy.a("powered");

	protected class_ale() {
		super(class_avq.q);
		this.j(M.b().a(a, class_ale.class_a_in_class_ale.e).a(b, Boolean.valueOf(false)));
		this.a(class_abp.d);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
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
	public boolean b(class_ago var1, class_cj var2, class_cq var3) {
		return a(var1, var2, var3.d());
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		class_cq[] var3 = class_cq.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_cq var6 = var3[var5];
			if (a(var1, var2, var6)) {
				return true;
			}
		}

		return false;
	}

	protected static boolean a(class_ago var0, class_cj var1, class_cq var2) {
		return class_air.a(var0, var1, var2);
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		class_apn var9 = getBlockData().a(b, Boolean.valueOf(false));
		if (a(var1, var2, var3.d())) {
			return var9.a(a, class_ale.class_a_in_class_ale.a(var3, var8.aV()));
		} else {
			Iterator var10 = class_cq.class_c_in_class_cq.a.iterator();

			class_cq var11;
			do {
				if (!var10.hasNext()) {
					if (class_ago.a(var1, var2.b())) {
						return var9.a(a, class_ale.class_a_in_class_ale.a(class_cq.b, var8.aV()));
					}

					return var9;
				}

				var11 = (class_cq) var10.next();
			} while ((var11 == var3) || !a(var1, var2, var11.d()));

			return var9.a(a, class_ale.class_a_in_class_ale.a(var11, var8.aV()));
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (this.f(var1, var2, var3) && !a(var1, var2, ((class_ale.class_a_in_class_ale) var3.b(a)).c().d())) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	private boolean f(class_ago var1, class_cj var2, class_apn var3) {
		if (this.c(var1, var2)) {
			return true;
		} else {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		}
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		float var3 = 0.1875F;
		switch (class_ale.SyntheticClass_1.b[((class_ale.class_a_in_class_ale) var1.p(var2).b(a)).ordinal()]) {
			case 1:
				this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
				break;
			case 2:
				this.a(1.0F - (var3 * 2.0F), 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
				break;
			case 3:
				this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
				break;
			case 4:
				this.a(0.5F - var3, 0.2F, 1.0F - (var3 * 2.0F), 0.5F + var3, 0.8F, 1.0F);
				break;
			case 5:
			case 6:
				var3 = 0.25F;
				this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.6F, 0.5F + var3);
				break;
			case 7:
			case 8:
				var3 = 0.25F;
				this.a(0.5F - var3, 0.4F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
		}

	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			var3 = var3.a(b);
			var1.a(var2, var3, 3);
			var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "random.click", 0.3F, ((Boolean) var3.b(b)).booleanValue() ? 0.6F : 0.5F);
			var1.d(var2, this);
			class_cq var11 = ((class_ale.class_a_in_class_ale) var3.b(a)).c();
			var1.d(var2.a(var11.d()), this);
			return true;
		}
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		if (((Boolean) var3.b(b)).booleanValue()) {
			var1.d(var2, this);
			class_cq var4 = ((class_ale.class_a_in_class_ale) var3.b(a)).c();
			var1.d(var2.a(var4.d()), this);
		}

		super.c(var1, var2, var3);
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return ((Boolean) var3.b(b)).booleanValue() ? 15 : 0;
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return !((Boolean) var3.b(b)).booleanValue() ? 0 : (((class_ale.class_a_in_class_ale) var3.b(a)).c() == var4 ? 15 : 0);
	}

	@Override
	public boolean i() {
		return true;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, class_ale.class_a_in_class_ale.a(var1 & 7)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_ale.class_a_in_class_ale) var1.b(a)).a();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_ale.SyntheticClass_1.c[var2.ordinal()]) {
				case 1:
					switch (class_ale.SyntheticClass_1.b[((class_ale.class_a_in_class_ale) var1.b(a)).ordinal()]) {
						case 1:
							return var1.a(a, class_ale.class_a_in_class_ale.c);
						case 2:
							return var1.a(a, class_ale.class_a_in_class_ale.b);
						case 3:
							return var1.a(a, class_ale.class_a_in_class_ale.e);
						case 4:
							return var1.a(a, class_ale.class_a_in_class_ale.d);
						default:
							return var1;
					}
				case 2:
					switch (class_ale.SyntheticClass_1.b[((class_ale.class_a_in_class_ale) var1.b(a)).ordinal()]) {
						case 1:
							return var1.a(a, class_ale.class_a_in_class_ale.e);
						case 2:
							return var1.a(a, class_ale.class_a_in_class_ale.d);
						case 3:
							return var1.a(a, class_ale.class_a_in_class_ale.b);
						case 4:
							return var1.a(a, class_ale.class_a_in_class_ale.c);
						case 5:
							return var1.a(a, class_ale.class_a_in_class_ale.g);
						case 6:
							return var1.a(a, class_ale.class_a_in_class_ale.f);
						case 7:
							return var1.a(a, class_ale.class_a_in_class_ale.h);
						case 8:
							return var1.a(a, class_ale.class_a_in_class_ale.a);
					}
				case 3:
					switch (class_ale.SyntheticClass_1.b[((class_ale.class_a_in_class_ale) var1.b(a)).ordinal()]) {
						case 1:
							return var1.a(a, class_ale.class_a_in_class_ale.d);
						case 2:
							return var1.a(a, class_ale.class_a_in_class_ale.e);
						case 3:
							return var1.a(a, class_ale.class_a_in_class_ale.c);
						case 4:
							return var1.a(a, class_ale.class_a_in_class_ale.b);
						case 5:
							return var1.a(a, class_ale.class_a_in_class_ale.g);
						case 6:
							return var1.a(a, class_ale.class_a_in_class_ale.f);
						case 7:
							return var1.a(a, class_ale.class_a_in_class_ale.h);
						case 8:
							return var1.a(a, class_ale.class_a_in_class_ale.a);
					}
				default:
					return var1;
			}
		}
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a(((class_ale.class_a_in_class_ale) var1.b(a)).c()));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b;
		// $FF: synthetic field
		static final int[] c;
		// $FF: synthetic field
		static final int[] d = new int[class_cq.class_a_in_class_cq.values().length];

		static {
			try {
				d[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var19) {
				;
			}

			try {
				d[class_cq.class_a_in_class_cq.c.ordinal()] = 2;
			} catch (NoSuchFieldError var18) {
				;
			}

			c = new int[Block.class_c_in_class_ail.values().length];

			try {
				c[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var17) {
				;
			}

			try {
				c[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var16) {
				;
			}

			try {
				c[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var15) {
				;
			}

			b = new int[class_ale.class_a_in_class_ale.values().length];

			try {
				b[class_ale.class_a_in_class_ale.b.ordinal()] = 1;
			} catch (NoSuchFieldError var14) {
				;
			}

			try {
				b[class_ale.class_a_in_class_ale.c.ordinal()] = 2;
			} catch (NoSuchFieldError var13) {
				;
			}

			try {
				b[class_ale.class_a_in_class_ale.d.ordinal()] = 3;
			} catch (NoSuchFieldError var12) {
				;
			}

			try {
				b[class_ale.class_a_in_class_ale.e.ordinal()] = 4;
			} catch (NoSuchFieldError var11) {
				;
			}

			try {
				b[class_ale.class_a_in_class_ale.f.ordinal()] = 5;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				b[class_ale.class_a_in_class_ale.g.ordinal()] = 6;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				b[class_ale.class_a_in_class_ale.a.ordinal()] = 7;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[class_ale.class_a_in_class_ale.h.ordinal()] = 8;
			} catch (NoSuchFieldError var7) {
				;
			}

			a = new int[class_cq.values().length];

			try {
				a[class_cq.a.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_cq.b.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_ale implements class_oe {
		a("DOWN_X", 0, 0, "down_x", class_cq.a),
		b("EAST", 1, 1, "east", class_cq.f),
		c("WEST", 2, 2, "west", class_cq.e),
		d("SOUTH", 3, 3, "south", class_cq.d),
		e("NORTH", 4, 4, "north", class_cq.c),
		f("UP_Z", 5, 5, "up_z", class_cq.b),
		g("UP_X", 6, 6, "up_x", class_cq.b),
		h("DOWN_Z", 7, 7, "down_z", class_cq.a);

		private static final class_ale.class_a_in_class_ale[] i;
		private final int j;
		private final String k;
		private final class_cq l;

		private class_a_in_class_ale(String name, int ordinal, int var3, String var4, class_cq var5) {
			this(var3, var4, var5);
		}

		private class_a_in_class_ale(int var3, String var4, class_cq var5) {
			j = var3;
			k = var4;
			l = var5;
		}

		public int a() {
			return j;
		}

		public class_cq c() {
			return l;
		}

		@Override
		public String toString() {
			return k;
		}

		public static class_ale.class_a_in_class_ale a(int var0) {
			if ((var0 < 0) || (var0 >= i.length)) {
				var0 = 0;
			}

			return i[var0];
		}

		public static class_ale.class_a_in_class_ale a(class_cq var0, class_cq var1) {
			switch (class_ale.SyntheticClass_1.a[var0.ordinal()]) {
				case 1:
					switch (class_ale.SyntheticClass_1.d[var1.k().ordinal()]) {
						case 1:
							return a;
						case 2:
							return h;
						default:
							throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
					}
				case 2:
					switch (class_ale.SyntheticClass_1.d[var1.k().ordinal()]) {
						case 1:
							return g;
						case 2:
							return f;
						default:
							throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
					}
				case 3:
					return e;
				case 4:
					return d;
				case 5:
					return c;
				case 6:
					return b;
				default:
					throw new IllegalArgumentException("Invalid facing: " + var0);
			}
		}

		@Override
		public String l() {
			return k;
		}

		static {
			i = new class_ale.class_a_in_class_ale[values().length];
			class_ale.class_a_in_class_ale[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ale.class_a_in_class_ale var3 = var0[var2];
				i[var3.a()] = var3;
			}

		}
	}
}
