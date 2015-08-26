package net.minecraft.server;

import java.util.Random;

public abstract class class_alr extends BlockStepAbstract {
	public static final class_apy b = class_apy.a("seamless");
	public static final class_aqa N = class_aqa.a("variant", class_alr.class_a_in_class_alr.class);

	public class_alr() {
		super(class_avq.e);
		class_apn var1 = M.b();
		if (l()) {
			var1 = var1.a(b, Boolean.valueOf(false));
		} else {
			var1 = var1.a(a, BlockStepAbstract.class_a_in_class_akq.b);
		}

		this.j(var1.a(N, class_alr.class_a_in_class_alr.a));
		this.a(class_abp.b);
	}

	@Override
	public String f() {
		return class_di.a(this.a() + ".red_sandstone.name");
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(Blocks.STONE_SLAB2);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Blocks.STONE_SLAB2, 1, ((class_alr.class_a_in_class_alr) var3.b(N)).a());
	}

	@Override
	public String b(int var1) {
		return super.a() + "." + class_alr.class_a_in_class_alr.a(var1).d();
	}

	@Override
	public class_aqc n() {
		return N;
	}

	@Override
	public Object a(class_aco var1) {
		return class_alr.class_a_in_class_alr.a(var1.i() & 7);
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = S().a(N, class_alr.class_a_in_class_alr.a(var1 & 7));
		if (l()) {
			var2 = var2.a(b, Boolean.valueOf((var1 & 8) != 0));
		} else {
			var2 = var2.a(a, (var1 & 8) == 0 ? BlockStepAbstract.class_a_in_class_akq.b : BlockStepAbstract.class_a_in_class_akq.a);
		}

		return var2;
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_alr.class_a_in_class_alr) var1.b(N)).a();
		if (l()) {
			if (((Boolean) var1.b(b)).booleanValue()) {
				var3 |= 8;
			}
		} else if (var1.b(a) == BlockStepAbstract.class_a_in_class_akq.a) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	protected class_apo e() {
		return l() ? new class_apo(this, new class_aqc[] { b, N }) : new class_apo(this, new class_aqc[] { a, N });
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_alr.class_a_in_class_alr) var1.b(N)).c();
	}

	@Override
	public int a(class_apn var1) {
		return ((class_alr.class_a_in_class_alr) var1.b(N)).a();
	}

	public static enum class_a_in_class_alr implements class_oe {
		a(0, "red_sandstone", BlockSand.class_a_in_class_ams.b.c());

		private static final class_alr.class_a_in_class_alr[] b;
		private final int c;
		private final String d;
		private final class_avr e;

		private class_a_in_class_alr(int var3, String var4, class_avr var5) {
			c = var3;
			d = var4;
			e = var5;
		}

		public int a() {
			return c;
		}

		public class_avr c() {
			return e;
		}

		@Override
		public String toString() {
			return d;
		}

		public static class_alr.class_a_in_class_alr a(int var0) {
			if ((var0 < 0) || (var0 >= b.length)) {
				var0 = 0;
			}

			return b[var0];
		}

		@Override
		public String l() {
			return d;
		}

		public String d() {
			return d;
		}

		static {
			b = new class_alr.class_a_in_class_alr[values().length];
			class_alr.class_a_in_class_alr[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_alr.class_a_in_class_alr var3 = var0[var2];
				b[var3.a()] = var3;
			}

		}
	}
}
