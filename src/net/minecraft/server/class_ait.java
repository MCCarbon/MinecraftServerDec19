package net.minecraft.server;

import java.util.Random;

public class class_ait extends Block {
	public static final class_aqb a = class_aqb.a("bites", 0, 6);

	protected class_ait() {
		super(class_avq.F);
		this.j(M.b().a(a, Integer.valueOf(0)));
		this.a(true);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		float var3 = 0.0625F;
		float var4 = (1 + (((Integer) var1.p(var2).b(a)).intValue() * 2)) / 16.0F;
		float var5 = 0.5F;
		this.a(var4, 0.0F, var3, 1.0F - var3, var5, 1.0F - var3);
	}

	@Override
	public void j() {
		float var1 = 0.0625F;
		float var2 = 0.5F;
		this.a(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		float var4 = 0.0625F;
		float var5 = (1 + (((Integer) var3.b(a)).intValue() * 2)) / 16.0F;
		float var6 = 0.5F;
		return new class_ayk(var2.n() + var5, var2.o(), var2.p() + var4, var2.n() + 1 - var4, var2.o() + var6, var2.p() + 1 - var4);
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
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		this.b(var1, var2, var3, var4);
		return true;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_yu var3) {
		this.b(var1, var2, var1.p(var2), var3);
	}

	private void b(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		if (var4.j(false)) {
			var4.b(StatisticList.I);
			var4.ct().a(2, 0.1F);
			int var5 = ((Integer) var3.b(a)).intValue();
			if (var5 < 6) {
				var1.a(var2, var3.a(a, Integer.valueOf(var5 + 1)), 3);
			} else {
				var1.g(var2);
			}

		}
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return super.c(var1, var2) ? this.d(var1, var2) : false;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!this.d(var1, var2)) {
			var1.g(var2);
		}

	}

	private boolean d(class_ago var1, class_cj var2) {
		return var1.p(var2.b()).c().v().a();
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.bb);
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		return (7 - ((Integer) var1.p(var2).b(a)).intValue()) * 2;
	}

	@Override
	public boolean Q() {
		return true;
	}
}
