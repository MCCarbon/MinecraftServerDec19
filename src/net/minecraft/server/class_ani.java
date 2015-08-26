package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_ani extends BlockPlant implements class_ain {
	public static final class_aqb a = class_aqb.a("age", 0, 7);
	public static final class_apz b;
	private final Block N;

	protected class_ani(Block var1) {
		this.j(M.b().a(a, Integer.valueOf(0)).a(b, class_cq.b));
		N = var1;
		this.a(true);
		float var2 = 0.125F;
		this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
		this.a((class_abp) null);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		var1 = var1.a(b, class_cq.b);
		Iterator var4 = class_cq.class_c_in_class_cq.a.iterator();

		while (var4.hasNext()) {
			class_cq var5 = (class_cq) var4.next();
			if (var2.p(var3.a(var5)).c() == N) {
				var1 = var1.a(b, var5);
				break;
			}
		}

		return var1;
	}

	@Override
	protected boolean c(Block var1) {
		return var1 == Blocks.FARMLAND;
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		super.b(var1, var2, var3, var4);
		if (var1.l(var2.a()) >= 9) {
			float var5 = class_ajf.a(this, var1, var2);
			if (var4.nextInt((int) (25.0F / var5) + 1) == 0) {
				int var6 = ((Integer) var3.b(a)).intValue();
				if (var6 < 7) {
					var3 = var3.a(a, Integer.valueOf(var6 + 1));
					var1.a(var2, var3, 2);
				} else {
					Iterator var7 = class_cq.class_c_in_class_cq.a.iterator();

					while (var7.hasNext()) {
						class_cq var8 = (class_cq) var7.next();
						if (var1.p(var2.a(var8)).c() == N) {
							return;
						}
					}

					var2 = var2.a(class_cq.class_c_in_class_cq.a.a(var4));
					Block var9 = var1.p(var2.b()).c();
					if ((var1.p(var2).c().J == class_avq.a) && ((var9 == Blocks.FARMLAND) || (var9 == Blocks.DIRT) || (var9 == Blocks.GRASS))) {
						var1.a(var2, N.S());
					}
				}
			}

		}
	}

	public void h(class_ago var1, class_cj var2, class_apn var3) {
		int var4 = ((Integer) var3.b(a)).intValue() + MathHelper.a(var1.s, 2, 5);
		var1.a(var2, var3.a(a, Integer.valueOf(Math.min(7, var4))), 2);
	}

	@Override
	public void j() {
		float var1 = 0.125F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		F = ((((Integer) var1.p(var2).b(a)).intValue() * 2) + 2) / 16.0F;
		float var3 = 0.125F;
		this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, (float) F, 0.5F + var3);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (!var1.D) {
			Item var6 = l();
			if (var6 != null) {
				int var7 = ((Integer) var3.b(a)).intValue();

				for (int var8 = 0; var8 < 3; ++var8) {
					if (var1.s.nextInt(15) <= var7) {
						a(var1, var2, new class_aco(var6));
					}
				}

			}
		}
	}

	protected Item l() {
		return N == Blocks.PUMPKIN ? Items.bi : (N == Blocks.MELON_BLOCK ? Items.bj : null);
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		Item var4 = l();
		return var4 == null ? null : new class_aco(var4);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, boolean var4) {
		return ((Integer) var3.b(a)).intValue() != 7;
	}

	@Override
	public boolean a(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		return true;
	}

	@Override
	public void b(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		h(var1, var3, var4);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b });
	}

	static {
		b = class_anr.a;
	}
}
