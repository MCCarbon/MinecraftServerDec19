package net.minecraft.server;

import java.util.Random;

public class class_aid extends class_aif {
	public static final class_apz a;
	public static final class_aqb b;

	protected class_aid() {
		super(class_avq.d);
		float var1 = 0.25F;
		float var2 = 1.0F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
	}

	@Override
	public String f() {
		return class_di.a("item.banner.white.name");
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean b(class_ags var1, class_cj var2) {
		return true;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean g() {
		return true;
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aog();
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.cJ;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.cJ);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		TileEntity var6 = var1.s(var2);
		if (var6 instanceof class_aog) {
			class_aco var7 = new class_aco(Items.cJ, 1, ((class_aog) var6).b());
			class_dn var8 = new class_dn();
			var6.b(var8);
			var8.q("x");
			var8.q("y");
			var8.q("z");
			var8.q("id");
			var7.a("BlockEntityTag", var8);
			a(var1, var2, var7);
		} else {
			super.a(var1, var2, var3, var4, var5);
		}

	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return !this.d(var1, var2) && super.c(var1, var2);
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, TileEntity var5, class_aco var6) {
		if (var5 instanceof class_aog) {
			class_aog var7 = (class_aog) var5;
			class_aco var8 = new class_aco(Items.cJ, 1, ((class_aog) var5).b());
			class_dn var9 = new class_dn();
			class_aog.a(var9, var7.b(), var7.d());
			var8.a("BlockEntityTag", var9);
			a(var1, var3, var8);
		} else {
			super.a(var1, var2, var3, var4, (TileEntity) null, var6);
		}

	}

	static {
		a = class_akx.O;
		b = class_aqb.a("rotation", 0, 15);
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

	public static class class_a_in_class_aid extends class_aid {
		public class_a_in_class_aid() {
			this.j(M.b().a(b, Integer.valueOf(0)));
		}

		@Override
		public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
			return var1.c() != this ? var1 : var1.a(b, Integer.valueOf(var2.a(((Integer) var1.b(b)).intValue(), 16)));
		}

		@Override
		public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
			return var1.c() != this ? var1 : var1.a(b, Integer.valueOf(var2.a(((Integer) var1.b(b)).intValue(), 16)));
		}

		@Override
		public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
			if (!var1.p(var2.b()).c().v().a()) {
				this.b(var1, var2, var3, 0);
				var1.g(var2);
			}

			super.a(var1, var2, var3, var4);
		}

		@Override
		public class_apn a(int var1) {
			return getBlockData().a(b, Integer.valueOf(var1));
		}

		@Override
		public int c(class_apn var1) {
			return ((Integer) var1.b(b)).intValue();
		}

		@Override
		protected class_apo e() {
			return new class_apo(this, new class_aqc[] { b });
		}
	}

	public static class class_b_in_class_aid extends class_aid {
		public class_b_in_class_aid() {
			this.j(M.b().a(a, class_cq.c));
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
		public void a(class_ags var1, class_cj var2) {
			class_cq var3 = (class_cq) var1.p(var2).b(a);
			float var4 = 0.0F;
			float var5 = 0.78125F;
			float var6 = 0.0F;
			float var7 = 1.0F;
			float var8 = 0.125F;
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			switch (class_aid.SyntheticClass_1.a[var3.ordinal()]) {
				case 1:
				default:
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

			return getBlockData().a(a, var2);
		}

		@Override
		public int c(class_apn var1) {
			return ((class_cq) var1.b(a)).a();
		}

		@Override
		protected class_apo e() {
			return new class_apo(this, new class_aqc[] { a });
		}
	}
}
