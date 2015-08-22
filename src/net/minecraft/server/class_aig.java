package net.minecraft.server;

import java.util.Random;

public abstract class class_aig extends Block {
	protected class_aig(class_avq var1) {
		this(var1, var1.r());
	}

	protected class_aig(class_avq var1, class_avr var2) {
		super(var1, var2);
		this.a(class_abp.d);
		this.a(true);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.d(var1.p(var2));
	}

	protected void d(class_apn var1) {
		boolean var2 = this.e(var1) > 0;
		float var3 = 0.0625F;
		if (var2) {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.03125F, 0.9375F);
		} else {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.0625F, 0.9375F);
		}

	}

	@Override
	public int a(class_ago var1) {
		return 20;
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
	public boolean b(class_ags var1, class_cj var2) {
		return true;
	}

	@Override
	public boolean g() {
		return true;
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return this.k(var1, var2.b());
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!this.k(var1, var2.b())) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	private boolean k(class_ago var1, class_cj var2) {
		return class_ago.a(var1, var2) || (var1.p(var2).c() instanceof class_akb);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Random var4) {
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			int var5 = this.e(var3);
			if (var5 > 0) {
				this.a(var1, var2, var3, var5);
			}

		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Entity var4) {
		if (!var1.D) {
			int var5 = this.e(var3);
			if (var5 == 0) {
				this.a(var1, var2, var3, var5);
			}

		}
	}

	protected void a(class_ago var1, class_cj var2, class_apn var3, int var4) {
		int var5 = this.e(var1, var2);
		boolean var6 = var4 > 0;
		boolean var7 = var5 > 0;
		if (var4 != var5) {
			var3 = this.a(var3, var5);
			var1.a(var2, var3, 2);
			this.d(var1, var2);
			var1.b(var2, var2);
		}

		if (!var7 && var6) {
			var1.a(var2.n() + 0.5D, var2.o() + 0.1D, var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
		} else if (var7 && !var6) {
			var1.a(var2.n() + 0.5D, var2.o() + 0.1D, var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
		}

		if (var7) {
			var1.a(var2, this, this.a(var1));
		}

	}

	protected class_ayk a(class_cj var1) {
		float var2 = 0.125F;
		return new class_ayk(var1.n() + 0.125F, var1.o(), var1.p() + 0.125F, var1.n() + 1 - 0.125F, var1.o() + 0.25D, var1.p() + 1 - 0.125F);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		if (this.e(var3) > 0) {
			this.d(var1, var2);
		}

		super.c(var1, var2, var3);
	}

	protected void d(class_ago var1, class_cj var2) {
		var1.d(var2, this);
		var1.d(var2.b(), this);
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return this.e(var3);
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return var4 == class_cq.b ? this.e(var3) : 0;
	}

	@Override
	public boolean i() {
		return true;
	}

	@Override
	public void j() {
		float var1 = 0.5F;
		float var2 = 0.125F;
		float var3 = 0.5F;
		this.a(0.0F, 0.375F, 0.0F, 1.0F, 0.625F, 1.0F);
	}

	@Override
	public int k() {
		return 1;
	}

	protected abstract int e(class_ago var1, class_cj var2);

	protected abstract int e(class_apn var1);

	protected abstract class_apn a(class_apn var1, int var2);
}
