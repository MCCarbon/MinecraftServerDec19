package net.minecraft.server;

import java.util.Iterator;

public class class_ajw extends class_ajk {
	protected class_ajw() {
		super(class_avq.q);
		this.j(M.b().a(b, class_cq.b));
		this.a(class_abp.c);
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(b, var2.a((class_cq) var1.b(b)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(b, var2.b((class_cq) var1.b(b)));
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		class_cq var4 = (class_cq) var3.b(b);
		float var5 = 0.4375F;
		float var6 = 0.5625F;
		return (var4 != class_cq.f) && (var4 != class_cq.e) ? ((var4 != class_cq.d) && (var4 != class_cq.c) ? new class_ayk(var2.n() + var5, var2.o() + 0, var2.p() + var5, var2.n() + var6, var2.o() + 1, var2.p() + var6) : new class_ayk(var2.n() + var5, var2.o() + var5, var2.p() + 0, var2.n() + var6, var2.o() + var6,
				var2.p() + 1)) : new class_ayk(var2.n() + 0, var2.o() + var5, var2.p() + var5, var2.n() + 1, var2.o() + var6, var2.p() + var6);
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
	public boolean c(class_ago var1, class_cj var2) {
		Iterator var3 = b.c().iterator();

		class_cq var4;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			var4 = (class_cq) var3.next();
		} while (!this.a(var1, var2, var4));

		return true;
	}

	private boolean a(class_ago var1, class_cj var2, class_cq var3) {
		return true;
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		class_apn var9 = var1.p(var2.a(var3.d()));
		if (var9.c() == Blocks.END_ROD) {
			class_cq var10 = (class_cq) var9.b(b);
			if (var10 == var3) {
				return getBlockData().a(b, var3.d());
			}
		}

		return getBlockData().a(b, var3);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
	}

	@Override
	public class_ayl a(class_ago var1, class_cj var2, class_aym var3, class_aym var4) {
		class_cq var5 = (class_cq) var1.p(var2).b(b);
		float var6 = 0.375F;
		float var7 = 0.625F;
		if ((var5 != class_cq.f) && (var5 != class_cq.e)) {
			if ((var5 != class_cq.d) && (var5 != class_cq.c)) {
				this.a(var6, 0.0F, var6, var7, 1.0F, var7);
			} else {
				this.a(var6, var6, 0.0F, var7, var7, 1.0F);
			}
		} else {
			this.a(0.0F, var6, var6, 1.0F, var7, var7);
		}

		return super.a(var1, var2, var3, var4);
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = getBlockData();
		var2 = var2.a(b, class_cq.a(var1));
		return var2;
	}

	@Override
	public int c(class_apn var1) {
		return ((class_cq) var1.b(b)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b });
	}

	@Override
	public int k() {
		return 0;
	}
}
