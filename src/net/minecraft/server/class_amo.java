package net.minecraft.server;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_amo extends class_anr {
	private static Map b = Maps.newHashMap();
	private final boolean N;

	private boolean a(class_ago var1, class_cj var2, boolean var3) {
		if (!b.containsKey(var1)) {
			b.put(var1, Lists.newArrayList());
		}

		List var4 = (List) b.get(var1);
		if (var3) {
			var4.add(new class_amo.class_a_in_class_amo(var2, var1.M()));
		}

		int var5 = 0;

		for (int var6 = 0; var6 < var4.size(); ++var6) {
			class_amo.class_a_in_class_amo var7 = (class_amo.class_a_in_class_amo) var4.get(var6);
			if (var7.a.equals(var2)) {
				++var5;
				if (var5 >= 8) {
					return true;
				}
			}
		}

		return false;
	}

	protected class_amo(boolean var1) {
		N = var1;
		this.a(true);
		this.a((class_abp) null);
	}

	@Override
	public int a(class_ago var1) {
		return 2;
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if (N) {
			class_cq[] var4 = class_cq.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				class_cq var7 = var4[var6];
				var1.d(var2.a(var7), this);
			}
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		if (N) {
			class_cq[] var4 = class_cq.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				class_cq var7 = var4[var6];
				var1.d(var2.a(var7), this);
			}
		}

	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return N && (var3.b(a) != var4) ? 15 : 0;
	}

	private boolean h(class_ago var1, class_cj var2, class_apn var3) {
		class_cq var4 = ((class_cq) var3.b(a)).d();
		return var1.b(var2.a(var4), var4);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Random var4) {
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		boolean var5 = h(var1, var2, var3);
		List var6 = (List) b.get(var1);

		while ((var6 != null) && !var6.isEmpty() && ((var1.M() - ((class_amo.class_a_in_class_amo) var6.get(0)).b) > 60L)) {
			var6.remove(0);
		}

		if (N) {
			if (var5) {
				var1.a(var2, Blocks.aE.S().a(a, var3.b(a)), 3);
				if (this.a(var1, var2, true)) {
					var1.a(var2.n() + 0.5F, var2.o() + 0.5F, var2.p() + 0.5F, "random.fizz", 0.5F, 2.6F + ((var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F));

					for (int var7 = 0; var7 < 5; ++var7) {
						double var8 = var2.n() + (var4.nextDouble() * 0.6D) + 0.2D;
						double var10 = var2.o() + (var4.nextDouble() * 0.6D) + 0.2D;
						double var12 = var2.p() + (var4.nextDouble() * 0.6D) + 0.2D;
						var1.a(class_cy.l, var8, var10, var12, 0.0D, 0.0D, 0.0D, new int[0]);
					}

					var1.a(var2, var1.p(var2).c(), 160);
				}
			}
		} else if (!var5 && !this.a(var1, var2, false)) {
			var1.a(var2, Blocks.aF.S().a(a, var3.b(a)), 3);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!this.f(var1, var2, var3)) {
			if (N == h(var1, var2, var3)) {
				var1.a(var2, this, this.a(var1));
			}

		}
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return var4 == class_cq.a ? this.a(var1, var2, var3, var4) : 0;
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Item.a(Blocks.aF);
	}

	@Override
	public boolean i() {
		return true;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Blocks.aF);
	}

	@Override
	public boolean b(Block var1) {
		return (var1 == Blocks.aE) || (var1 == Blocks.aF);
	}

	static class class_a_in_class_amo {
		class_cj a;
		long b;

		public class_a_in_class_amo(class_cj var1, long var2) {
			a = var1;
			b = var2;
		}
	}
}
