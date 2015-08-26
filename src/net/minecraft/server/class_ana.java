package net.minecraft.server;

import java.util.Random;

public class class_ana extends Block {
	public static final class_aqb a = class_aqb.a("layers", 1, 8);

	protected class_ana() {
		super(class_avq.y);
		this.j(M.b().a(a, Integer.valueOf(1)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.a(true);
		this.a(class_abp.c);
		this.j();
	}

	@Override
	public boolean b(class_ags var1, class_cj var2) {
		return ((Integer) var1.p(var2).b(a)).intValue() < 5;
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		int var4 = ((Integer) var3.b(a)).intValue() - 1;
		float var5 = 0.125F;
		return new class_ayk(var2.n() + B, var2.o() + C, var2.p() + D, var2.n() + E, var2.o() + (var4 * var5), var2.p() + G);
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
	public void j() {
		this.b(0);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		this.b(((Integer) var3.b(a)).intValue());
	}

	protected void b(int var1) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, var1 / 8.0F, 1.0F);
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		class_apn var3 = var1.p(var2.b());
		Block var4 = var3.c();
		return (var4 != Blocks.ICE) && (var4 != Blocks.PACKED_ICE) ? (var4.v() == class_avq.j ? true : ((var4 == this) && (((Integer) var3.b(a)).intValue() >= 7) ? true : var4.c() && var4.J.c())) : false;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		this.f(var1, var2, var3);
	}

	private boolean f(class_ago var1, class_cj var2, class_apn var3) {
		if (!this.c(var1, var2)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, TileEntity var5, class_aco var6) {
		a(var1, var3, new class_aco(Items.aF, ((Integer) var4.b(a)).intValue() + 1, 0));
		var1.g(var3);
		var2.b(class_nh.a(Block.a(this)));
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.aF;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (var1.b(class_agu.b, var2) > 11) {
			this.b(var1, var2, var1.p(var2), 0);
			var1.g(var2);
		}

	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Integer.valueOf((var1 & 7) + 1));
	}

	@Override
	public boolean a(class_ago var1, class_cj var2) {
		return ((Integer) var1.p(var2).b(a)).intValue() == 1;
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue() - 1;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
