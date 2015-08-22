package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class class_anu extends Block {
	public static final class_apy a = class_apy.a("powered");
	public static final class_apy b = class_apy.a("suspended");
	public static final class_apy N = class_apy.a("attached");
	public static final class_apy O = class_apy.a("disarmed");
	public static final class_apy P = class_apy.a("north");
	public static final class_apy Q = class_apy.a("east");
	public static final class_apy R = class_apy.a("south");
	public static final class_apy S = class_apy.a("west");

	public class_anu() {
		super(class_avq.q);
		this.j(M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, Boolean.valueOf(false)).a(R, Boolean.valueOf(false)).a(S, Boolean.valueOf(false)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
		this.a(true);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		return var1.a(P, Boolean.valueOf(c(var2, var3, var1, class_cq.c))).a(Q, Boolean.valueOf(c(var2, var3, var1, class_cq.f))).a(R, Boolean.valueOf(c(var2, var3, var1, class_cq.d))).a(S, Boolean.valueOf(c(var2, var3, var1, class_cq.e)));
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
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.H;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.H);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		boolean var5 = ((Boolean) var3.b(b)).booleanValue();
		boolean var6 = !class_ago.a(var1, var2.b());
		if (var5 != var6) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		boolean var4 = ((Boolean) var3.b(N)).booleanValue();
		boolean var5 = ((Boolean) var3.b(b)).booleanValue();
		if (!var5) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
		} else if (!var4) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		} else {
			this.a(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
		}

	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		var3 = var3.a(b, Boolean.valueOf(!class_ago.a(var1, var2.b())));
		var1.a(var2, var3, 3);
		this.f(var1, var2, var3);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		this.f(var1, var2, var3.a(a, Boolean.valueOf(true)));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		if (!var1.D) {
			if ((var4.bG() != null) && (var4.bG().b() == Items.bg)) {
				var1.a(var2, var3.a(O, Boolean.valueOf(true)), 4);
			}

		}
	}

	private void f(class_ago var1, class_cj var2, class_apn var3) {
		class_cq[] var4 = new class_cq[] { class_cq.d, class_cq.e };
		int var5 = var4.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			class_cq var7 = var4[var6];

			for (int var8 = 1; var8 < 42; ++var8) {
				class_cj var9 = var2.a(var7, var8);
				class_apn var10 = var1.p(var9);
				if (var10.c() == Blocks.bR) {
					if (var10.b(class_anv.a) == var7.d()) {
						Blocks.bR.a(var1, var9, var10, false, true, var8, var3);
					}
					break;
				}

				if (var10.c() != Blocks.bS) {
					break;
				}
			}
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Entity var4) {
		if (!var1.D) {
			if (!((Boolean) var3.b(a)).booleanValue()) {
				this.d(var1, var2);
			}
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Random var4) {
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			if (((Boolean) var1.p(var2).b(a)).booleanValue()) {
				this.d(var1, var2);
			}
		}
	}

	private void d(class_ago var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		boolean var4 = ((Boolean) var3.b(a)).booleanValue();
		boolean var5 = false;
		List var6 = var1.b((Entity) null, (new class_ayk(var2.n() + B, var2.o() + C, var2.p() + D, var2.n() + E, var2.o() + F, var2.p() + G)));
		if (!var6.isEmpty()) {
			Iterator var7 = var6.iterator();

			while (var7.hasNext()) {
				Entity var8 = (Entity) var7.next();
				if (!var8.aO()) {
					var5 = true;
					break;
				}
			}
		}

		if (var5 != var4) {
			var3 = var3.a(a, Boolean.valueOf(var5));
			var1.a(var2, var3, 3);
			this.f(var1, var2, var3);
		}

		if (var5) {
			var1.a(var2, this, this.a(var1));
		}

	}

	public static boolean c(class_ags var0, class_cj var1, class_apn var2, class_cq var3) {
		class_cj var4 = var1.a(var3);
		class_apn var5 = var0.p(var4);
		Block var6 = var5.c();
		if (var6 == Blocks.bR) {
			class_cq var9 = var3.d();
			return var5.b(class_anv.a) == var9;
		} else if (var6 == Blocks.bS) {
			boolean var7 = ((Boolean) var2.b(b)).booleanValue();
			boolean var8 = ((Boolean) var5.b(b)).booleanValue();
			return var7 == var8;
		} else {
			return false;
		}
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Boolean.valueOf((var1 & 1) > 0)).a(b, Boolean.valueOf((var1 & 2) > 0)).a(N, Boolean.valueOf((var1 & 4) > 0)).a(O, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		int var2 = 0;
		if (((Boolean) var1.b(a)).booleanValue()) {
			var2 |= 1;
		}

		if (((Boolean) var1.b(b)).booleanValue()) {
			var2 |= 2;
		}

		if (((Boolean) var1.b(N)).booleanValue()) {
			var2 |= 4;
		}

		if (((Boolean) var1.b(O)).booleanValue()) {
			var2 |= 8;
		}

		return var2;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_anu.SyntheticClass_1.a[var2.ordinal()]) {
				case 1:
					return var1.a(P, var1.b(R)).a(Q, var1.b(S)).a(R, var1.b(P)).a(S, var1.b(Q));
				case 2:
					return var1.a(P, var1.b(Q)).a(Q, var1.b(R)).a(R, var1.b(S)).a(S, var1.b(P));
				case 3:
					return var1.a(P, var1.b(S)).a(Q, var1.b(P)).a(R, var1.b(Q)).a(S, var1.b(R));
				default:
					return var1;
			}
		}
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_anu.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					return var1.a(P, var1.b(R)).a(R, var1.b(P));
				case 2:
					return var1.a(Q, var1.b(S)).a(S, var1.b(Q));
				default:
					return super.a(var1, var2);
			}
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, N, O, P, Q, S, R });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_a_in_class_ail.values().length];

		static {
			try {
				b[Block.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[Block.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[Block.class_c_in_class_ail.values().length];

			try {
				a[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
