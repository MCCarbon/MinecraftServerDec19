package net.minecraft.server;

import java.util.Random;

public class class_aja extends class_akx implements class_ain {
	public static final class_aqb a = class_aqb.a("age", 0, 2);

	public class_aja() {
		super(class_avq.k);
		this.j(M.b().a(O, class_cq.c).a(a, Integer.valueOf(0)));
		this.a(true);
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!this.f(var1, var2, var3)) {
			this.g(var1, var2, var3);
		} else if (var1.s.nextInt(5) == 0) {
			int var5 = ((Integer) var3.b(a)).intValue();
			if (var5 < 2) {
				var1.a(var2, var3.a(a, Integer.valueOf(var5 + 1)), 2);
			}
		}

	}

	public boolean f(class_ago var1, class_cj var2, class_apn var3) {
		var2 = var2.a((class_cq) var3.b(O));
		class_apn var4 = var1.p(var2);
		return (var4.c() == Blocks.LOG) && (var4.b(class_alv.b) == class_aly.class_a_in_class_aly.d);
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
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		this.d(var3);
		return super.a(var1, var2, var3);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.d(var1.p(var2));
	}

	private void d(class_apn var1) {
		class_cq var2 = (class_cq) var1.b(O);
		int var3 = ((Integer) var1.b(a)).intValue();
		int var4 = 4 + (var3 * 2);
		int var5 = 5 + (var3 * 2);
		float var6 = var4 / 2.0F;
		switch (class_aja.SyntheticClass_1.a[var2.ordinal()]) {
			case 1:
				this.a((8.0F - var6) / 16.0F, (12.0F - var5) / 16.0F, (15.0F - var4) / 16.0F, (8.0F + var6) / 16.0F, 0.75F, 0.9375F);
				break;
			case 2:
				this.a((8.0F - var6) / 16.0F, (12.0F - var5) / 16.0F, 0.0625F, (8.0F + var6) / 16.0F, 0.75F, (1.0F + var4) / 16.0F);
				break;
			case 3:
				this.a(0.0625F, (12.0F - var5) / 16.0F, (8.0F - var6) / 16.0F, (1.0F + var4) / 16.0F, 0.75F, (8.0F + var6) / 16.0F);
				break;
			case 4:
				this.a((15.0F - var4) / 16.0F, (12.0F - var5) / 16.0F, (8.0F - var6) / 16.0F, 0.9375F, 0.75F, (8.0F + var6) / 16.0F);
		}

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
	public void a(class_ago var1, class_cj var2, class_apn var3, EntityLiving var4, class_aco var5) {
		class_cq var6 = class_cq.a(var4.y);
		var1.a(var2, var3.a(O, var6), 2);
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		if (!var3.k().c()) {
			var3 = class_cq.c;
		}

		return getBlockData().a(O, var3.d()).a(a, Integer.valueOf(0));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!this.f(var1, var2, var3)) {
			this.g(var1, var2, var3);
		}

	}

	private void g(class_ago var1, class_cj var2, class_apn var3) {
		var1.a(var2, Blocks.AIR.getBlockData(), 3);
		this.b(var1, var2, var3, 0);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		int var6 = ((Integer) var3.b(a)).intValue();
		byte var7 = 1;
		if (var6 >= 2) {
			var7 = 3;
		}

		for (int var8 = 0; var8 < var7; ++var8) {
			a(var1, var2, new class_aco(Items.aY, 1, class_abt.m.b()));
		}

	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.aY, 1, class_abt.m.b());
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, boolean var4) {
		return ((Integer) var3.b(a)).intValue() < 2;
	}

	@Override
	public boolean a(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		return true;
	}

	@Override
	public void b(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		var1.a(var3, var4.a(a, Integer.valueOf(((Integer) var4.b(a)).intValue() + 1)), 2);
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(O, class_cq.b(var1)).a(a, Integer.valueOf((var1 & 15) >> 2));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(O)).b();
		var3 |= ((Integer) var1.b(a)).intValue() << 2;
		return var3;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { O, a });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.d.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 2;
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
}
