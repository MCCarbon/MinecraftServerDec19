package net.minecraft.server;


public class class_akc extends class_akx {
	public static final class_apy a = class_apy.a("open");
	public static final class_apy b = class_apy.a("powered");
	public static final class_apy N = class_apy.a("in_wall");

	public class_akc(class_aly.class_a_in_class_aly var1) {
		super(class_avq.d, var1.c());
		this.j(M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)));
		this.a(class_abp.d);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		class_cq.class_a_in_class_cq var4 = ((class_cq) var1.b(O)).k();
		if (((var4 == class_cq.class_a_in_class_cq.c) && ((var2.p(var3.e()).c() == Blocks.COBBLESTONE_WALL) || (var2.p(var3.f()).c() == Blocks.COBBLESTONE_WALL))) || ((var4 == class_cq.class_a_in_class_cq.a) && ((var2.p(var3.c()).c() == Blocks.COBBLESTONE_WALL) || (var2.p(var3.d()).c() == Blocks.COBBLESTONE_WALL)))) {
			var1 = var1.a(N, Boolean.valueOf(true));
		}

		return var1;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(O, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return var1.p(var2.b()).c().v().a() ? super.c(var1, var2) : false;
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			return null;
		} else {
			class_cq.class_a_in_class_cq var4 = ((class_cq) var3.b(O)).k();
			return var4 == class_cq.class_a_in_class_cq.c ? new class_ayk(var2.n(), var2.o(), var2.p() + 0.375F, var2.n() + 1, var2.o() + 1.5F, var2.p() + 0.625F) : new class_ayk(var2.n() + 0.375F, var2.o(), var2.p(), var2.n() + 0.625F, var2.o() + 1.5F, var2.p() + 1);
		}
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_cq.class_a_in_class_cq var3 = ((class_cq) var1.p(var2).b(O)).k();
		if (var3 == class_cq.class_a_in_class_cq.c) {
			this.a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
		} else {
			this.a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
		}

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
		return ((Boolean) var1.p(var2).b(a)).booleanValue();
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(O, var8.aV()).a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false));
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			var3 = var3.a(a, Boolean.valueOf(false));
			var1.a(var2, var3, 2);
		} else {
			class_cq var11 = class_cq.a(var4.y);
			if (var3.b(O) == var11.d()) {
				var3 = var3.a(O, var11);
			}

			var3 = var3.a(a, Boolean.valueOf(true));
			var1.a(var2, var3, 2);
		}

		var1.a(var4, ((Boolean) var3.b(a)).booleanValue() ? 1003 : 1006, var2, 0);
		return true;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.D) {
			boolean var5 = var1.z(var2);
			if (var5 || var4.i()) {
				if (var5 && !((Boolean) var3.b(a)).booleanValue() && !((Boolean) var3.b(b)).booleanValue()) {
					var1.a(var2, var3.a(a, Boolean.valueOf(true)).a(b, Boolean.valueOf(true)), 2);
					var1.a((class_yu) null, 1003, var2, 0);
				} else if (!var5 && ((Boolean) var3.b(a)).booleanValue() && ((Boolean) var3.b(b)).booleanValue()) {
					var1.a(var2, var3.a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)), 2);
					var1.a((class_yu) null, 1006, var2, 0);
				} else if (var5 != ((Boolean) var3.b(b)).booleanValue()) {
					var1.a(var2, var3.a(b, Boolean.valueOf(var5)), 2);
				}
			}

		}
	}

	@Override
	public class_apn a(int var1) {
		return S().a(O, class_cq.b(var1)).a(a, Boolean.valueOf((var1 & 4) != 0)).a(b, Boolean.valueOf((var1 & 8) != 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(O)).b();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		if (((Boolean) var1.b(a)).booleanValue()) {
			var3 |= 4;
		}

		return var3;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { O, a, b, N });
	}
}
