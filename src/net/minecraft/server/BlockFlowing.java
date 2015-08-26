package net.minecraft.server;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BlockFlowing extends class_alf {
	int a;

	protected BlockFlowing(class_avq var1) {
		super(var1);
	}

	private void g(class_ago var1, class_cj var2, class_apn var3) {
		var1.a(var2, b(J).S().a(b, var3.b(b)), 2);
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		int var5 = ((Integer) var3.b(b)).intValue();
		byte var6 = 1;
		if ((J == class_avq.i) && !var1.t.l()) {
			var6 = 2;
		}

		int var7 = this.a(var1);
		int var15;
		if (var5 > 0) {
			int var8 = -100;
			a = 0;

			class_cq var10;
			for (Iterator var9 = class_cq.class_c_in_class_cq.a.iterator(); var9.hasNext(); var8 = this.a(var1, var2.a(var10), var8)) {
				var10 = (class_cq) var9.next();
			}

			int var14 = var8 + var6;
			if ((var14 >= 8) || (var8 < 0)) {
				var14 = -1;
			}

			if (this.e((class_ags) var1, var2.a()) >= 0) {
				var15 = this.e((class_ags) var1, var2.a());
				if (var15 >= 8) {
					var14 = var15;
				} else {
					var14 = var15 + 8;
				}
			}

			if ((a >= 2) && (J == class_avq.h)) {
				class_apn var16 = var1.p(var2.b());
				if (var16.c().v().a()) {
					var14 = 0;
				} else if ((var16.c().v() == J) && (((Integer) var16.b(b)).intValue() == 0)) {
					var14 = 0;
				}
			}

			if ((J == class_avq.i) && (var5 < 8) && (var14 < 8) && (var14 > var5) && (var4.nextInt(4) != 0)) {
				var7 *= 4;
			}

			if (var14 == var5) {
				this.g(var1, var2, var3);
			} else {
				var5 = var14;
				if (var14 < 0) {
					var1.g(var2);
				} else {
					var3 = var3.a(b, Integer.valueOf(var14));
					var1.a(var2, var3, 2);
					var1.a(var2, this, var7);
					var1.d(var2, this);
				}
			}
		} else {
			this.g(var1, var2, var3);
		}

		class_apn var13 = var1.p(var2.b());
		if (this.i(var1, var2.b(), var13)) {
			if ((J == class_avq.i) && (var1.p(var2.b()).c().v() == class_avq.h)) {
				var1.a(var2.b(), Blocks.STONE.S());
				this.d(var1, var2.b());
				return;
			}

			if (var5 >= 8) {
				this.a(var1, var2.b(), var13, var5);
			} else {
				this.a(var1, var2.b(), var13, var5 + 8);
			}
		} else if ((var5 >= 0) && ((var5 == 0) || this.h(var1, var2.b(), var13))) {
			Set var17 = this.e(var1, var2);
			var15 = var5 + var6;
			if (var5 >= 8) {
				var15 = 1;
			}

			if (var15 >= 8) {
				return;
			}

			Iterator var11 = var17.iterator();

			while (var11.hasNext()) {
				class_cq var12 = (class_cq) var11.next();
				this.a(var1, var2.a(var12), var1.p(var2.a(var12)), var15);
			}
		}

	}

	private void a(class_ago var1, class_cj var2, class_apn var3, int var4) {
		if (this.i(var1, var2, var3)) {
			if (var3.c() != Blocks.AIR) {
				if (J == class_avq.i) {
					this.d(var1, var2);
				} else {
					var3.c().b(var1, var2, var3, 0);
				}
			}

			var1.a(var2, S().a(b, Integer.valueOf(var4)), 3);
		}

	}

	private int a(class_ago var1, class_cj var2, int var3, class_cq var4) {
		int var5 = 1000;
		Iterator var6 = class_cq.class_c_in_class_cq.a.iterator();

		while (true) {
			class_cq var7;
			class_cj var8;
			class_apn var9;
			do {
				do {
					do {
						if (!var6.hasNext()) {
							return var5;
						}

						var7 = (class_cq) var6.next();
					} while (var7 == var4);

					var8 = var2.a(var7);
					var9 = var1.p(var8);
				} while (this.h(var1, var8, var9));
			} while ((var9.c().v() == J) && (((Integer) var9.b(b)).intValue() <= 0));

			if (!this.h(var1, var8.b(), var9)) {
				return var3;
			}

			if (var3 < 4) {
				int var10 = this.a(var1, var8, var3 + 1, var7.d());
				if (var10 < var5) {
					var5 = var10;
				}
			}
		}
	}

	private Set e(class_ago var1, class_cj var2) {
		int var3 = 1000;
		EnumSet var4 = EnumSet.noneOf(class_cq.class);
		Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

		while (true) {
			class_cq var6;
			class_cj var7;
			class_apn var8;
			do {
				do {
					if (!var5.hasNext()) {
						return var4;
					}

					var6 = (class_cq) var5.next();
					var7 = var2.a(var6);
					var8 = var1.p(var7);
				} while (this.h(var1, var7, var8));
			} while ((var8.c().v() == J) && (((Integer) var8.b(b)).intValue() <= 0));

			int var9;
			if (this.h(var1, var7.b(), var1.p(var7.b()))) {
				var9 = this.a(var1, var7, 1, var6.d());
			} else {
				var9 = 0;
			}

			if (var9 < var3) {
				var4.clear();
			}

			if (var9 <= var3) {
				var4.add(var6);
				var3 = var9;
			}
		}
	}

	private boolean h(class_ago var1, class_cj var2, class_apn var3) {
		Block var4 = var1.p(var2).c();
		return !(var4 instanceof class_ajn) && (var4 != Blocks.an) && (var4 != Blocks.au) && (var4 != Blocks.aM) ? (var4.J == class_avq.E ? true : var4.J.c()) : true;
	}

	protected int a(class_ago var1, class_cj var2, int var3) {
		int var4 = this.e((class_ags) var1, var2);
		if (var4 < 0) {
			return var3;
		} else {
			if (var4 == 0) {
				++a;
			}

			if (var4 >= 8) {
				var4 = 0;
			}

			return (var3 >= 0) && (var4 >= var3) ? var3 : var4;
		}
	}

	private boolean i(class_ago var1, class_cj var2, class_apn var3) {
		class_avq var4 = var3.c().v();
		return (var4 != J) && (var4 != class_avq.i) && !this.h(var1, var2, var3);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if (!this.f(var1, var2, var3)) {
			var1.a(var2, this, this.a(var1));
		}

	}
}
