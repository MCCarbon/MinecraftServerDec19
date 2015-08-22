package net.minecraft.server;


public class class_anq extends Block {
	public static final class_apy a = class_apy.a("explode");

	public class_anq() {
		super(class_avq.u);
		this.j(M.b().a(a, Boolean.valueOf(false)));
		this.a(class_abp.d);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		super.d(var1, var2, var3);
		if (var1.z(var2)) {
			this.e(var1, var2, var3.a(a, Boolean.valueOf(true)));
			var1.g(var2);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (var1.z(var2)) {
			this.e(var1, var2, var3.a(a, Boolean.valueOf(true)));
			var1.g(var2);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_agk var3) {
		if (!var1.D) {
			class_xq var4 = new class_xq(var1, var2.n() + 0.5F, var2.o(), var2.p() + 0.5F, var3.c());
			var4.a((short) (var1.s.nextInt(var4.k() / 4) + (var4.k() / 8)));
			var1.a(var4);
		}
	}

	@Override
	public void e(class_ago var1, class_cj var2, class_apn var3) {
		this.a(var1, var2, var3, (class_rg) null);
	}

	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4) {
		if (!var1.D) {
			if (((Boolean) var3.b(a)).booleanValue()) {
				class_xq var5 = new class_xq(var1, var2.n() + 0.5F, var2.o(), var2.p() + 0.5F, var4);
				var1.a(var5);
				var1.a(var5, "game.tnt.primed", 1.0F, 1.0F);
			}

		}
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if ((var6 != null) && ((var6.b() == Items.d) || (var6.b() == Items.bQ))) {
			this.a(var1, var2, var3.a(a, Boolean.valueOf(true)), (class_rg) var4);
			var1.g(var2);
			if (var6.b() == Items.d) {
				var6.a(1, var4);
			} else if (!var4.bI.d) {
				--var6.b;
			}

			return true;
		} else {
			return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Entity var4) {
		if (!var1.D && (var4 instanceof class_yx)) {
			class_yx var5 = (class_yx) var4;
			if (var5.ay()) {
				this.a(var1, var2, var1.p(var2).a(a, Boolean.valueOf(true)), var5.e instanceof class_rg ? (class_rg) var5.e : null);
				var1.g(var2);
			}
		}

	}

	@Override
	public boolean a(class_agk var1) {
		return false;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Boolean.valueOf((var1 & 1) > 0));
	}

	@Override
	public int c(class_apn var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
