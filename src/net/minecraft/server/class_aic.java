package net.minecraft.server;


public class class_aic extends class_ajz {
	public static final class_apz a;
	public static final class_aqb b;

	protected class_aic() {
		super(class_avq.g);
		this.j(M.b().a(a, class_cq.c).a(b, Integer.valueOf(0)));
		this.e(0);
		this.a(class_abp.c);
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		class_cq var9 = var8.aV().e();
		return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, var9).a(b, Integer.valueOf(var7 >> 2));
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (!var1.D) {
			var4.a((new class_aic.class_a_in_class_aic(var1, var2)));
		}

		return true;
	}

	@Override
	public int a(class_apn var1) {
		return ((Integer) var1.b(b)).intValue();
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_cq var3 = (class_cq) var1.p(var2).b(a);
		if (var3.k() == class_cq.class_a_in_class_cq.a) {
			this.a(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
		} else {
			this.a(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
		}

	}

	@Override
	protected void a(class_xf var1) {
		var1.a(true);
	}

	@Override
	public void a_(class_ago var1, class_cj var2) {
		var1.b(1022, var2, 0);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_cq.b(var1 & 3)).a(b, Integer.valueOf((var1 & 15) >> 2));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(a)).b();
		var3 |= ((Integer) var1.b(b)).intValue() << 2;
		return var3;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b });
	}

	static {
		a = class_akx.O;
		b = class_aqb.a("damage", 0, 2);
	}

	public static class class_a_in_class_aic implements class_pv {
		private final class_ago a;
		private final class_cj b;

		public class_a_in_class_aic(class_ago var1, class_cj var2) {
			a = var1;
			b = var2;
		}

		@Override
		public String e_() {
			return "anvil";
		}

		@Override
		public boolean k_() {
			return false;
		}

		@Override
		public class_eu f_() {
			return new class_fb(Blocks.cf.a() + ".name", new Object[0]);
		}

		@Override
		public class_zu a(class_yt var1, class_yu var2) {
			return new class_zw(var1, a, b, var2);
		}

		@Override
		public String k() {
			return "minecraft:anvil";
		}
	}
}
