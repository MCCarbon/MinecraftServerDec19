package net.minecraft.server;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class BlockRedstoneWire extends Block {
	public static final class_aqa a = class_aqa.a("north", BlockRedstoneWire.class_a_in_class_amm.class);
	public static final class_aqa b = class_aqa.a("east", BlockRedstoneWire.class_a_in_class_amm.class);
	public static final class_aqa N = class_aqa.a("south", BlockRedstoneWire.class_a_in_class_amm.class);
	public static final class_aqa O = class_aqa.a("west", BlockRedstoneWire.class_a_in_class_amm.class);
	public static final class_aqb P = class_aqb.a("power", 0, 15);
	private boolean Q = true;
	private final Set R = Sets.newHashSet();

	public BlockRedstoneWire() {
		super(class_avq.q);
		this.j(M.b().a(a, BlockRedstoneWire.class_a_in_class_amm.c).a(b, BlockRedstoneWire.class_a_in_class_amm.c).a(N, BlockRedstoneWire.class_a_in_class_amm.c).a(O, BlockRedstoneWire.class_a_in_class_amm.c).a(P, Integer.valueOf(0)));
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		var1 = var1.a(O, this.c(var2, var3, class_cq.e));
		var1 = var1.a(b, this.c(var2, var3, class_cq.f));
		var1 = var1.a(a, this.c(var2, var3, class_cq.c));
		var1 = var1.a(N, this.c(var2, var3, class_cq.d));
		return var1;
	}

	private BlockRedstoneWire.class_a_in_class_amm c(class_ags var1, class_cj var2, class_cq var3) {
		class_cj var4 = var2.a(var3);
		Block var5 = var1.p(var2.a(var3)).c();
		if (a(var1.p(var4), var3) || (!var5.w() && d(var1.p(var4.b())))) {
			return BlockRedstoneWire.class_a_in_class_amm.b;
		} else {
			Block var6 = var1.p(var2.a()).c();
			return !var6.w() && var5.w() && d(var1.p(var4.a())) ? BlockRedstoneWire.class_a_in_class_amm.a : BlockRedstoneWire.class_a_in_class_amm.c;
		}
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
	public boolean c(class_ago var1, class_cj var2) {
		return class_ago.a(var1, var2.b()) || (var1.p(var2.b()).c() == Blocks.GLOWSTONE);
	}

	private class_apn f(class_ago var1, class_cj var2, class_apn var3) {
		var3 = this.a(var1, var2, var2, var3);
		ArrayList var4 = Lists.newArrayList((Iterable) R);
		R.clear();
		Iterator var5 = var4.iterator();

		while (var5.hasNext()) {
			class_cj var6 = (class_cj) var5.next();
			var1.d(var6, this);
		}

		return var3;
	}

	private class_apn a(class_ago var1, class_cj var2, class_cj var3, class_apn var4) {
		class_apn var5 = var4;
		int var6 = ((Integer) var4.b(P)).intValue();
		byte var7 = 0;
		int var14 = this.a(var1, var3, var7);
		Q = false;
		int var8 = var1.A(var2);
		Q = true;
		if ((var8 > 0) && (var8 > (var14 - 1))) {
			var14 = var8;
		}

		int var9 = 0;
		Iterator var10 = class_cq.class_c_in_class_cq.a.iterator();

		while (true) {
			while (var10.hasNext()) {
				class_cq var11 = (class_cq) var10.next();
				class_cj var12 = var2.a(var11);
				boolean var13 = (var12.n() != var3.n()) || (var12.p() != var3.p());
				if (var13) {
					var9 = this.a(var1, var12, var9);
				}

				if (var1.p(var12).c().x() && !var1.p(var2.a()).c().x()) {
					if (var13 && (var2.o() >= var3.o())) {
						var9 = this.a(var1, var12.a(), var9);
					}
				} else if (!var1.p(var12).c().x() && var13 && (var2.o() <= var3.o())) {
					var9 = this.a(var1, var12.b(), var9);
				}
			}

			if (var9 > var14) {
				var14 = var9 - 1;
			} else if (var14 > 0) {
				--var14;
			} else {
				var14 = 0;
			}

			if (var8 > (var14 - 1)) {
				var14 = var8;
			}

			if (var6 != var14) {
				var4 = var4.a(P, Integer.valueOf(var14));
				if (var1.p(var2) == var5) {
					var1.a(var2, var4, 2);
				}

				R.add(var2);
				class_cq[] var15 = class_cq.values();
				int var16 = var15.length;

				for (int var17 = 0; var17 < var16; ++var17) {
					class_cq var18 = var15[var17];
					R.add(var2.a(var18));
				}
			}

			return var4;
		}
	}

	private void d(class_ago var1, class_cj var2) {
		if (var1.p(var2).c() == this) {
			var1.d(var2, this);
			class_cq[] var3 = class_cq.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				class_cq var6 = var3[var5];
				var1.d(var2.a(var6), this);
			}

		}
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			this.f(var1, var2, var3);
			Iterator var4 = class_cq.class_c_in_class_cq.b.iterator();

			class_cq var5;
			while (var4.hasNext()) {
				var5 = (class_cq) var4.next();
				var1.d(var2.a(var5), this);
			}

			var4 = class_cq.class_c_in_class_cq.a.iterator();

			while (var4.hasNext()) {
				var5 = (class_cq) var4.next();
				this.d(var1, var2.a(var5));
			}

			var4 = class_cq.class_c_in_class_cq.a.iterator();

			while (var4.hasNext()) {
				var5 = (class_cq) var4.next();
				class_cj var6 = var2.a(var5);
				if (var1.p(var6).c().x()) {
					this.d(var1, var6.a());
				} else {
					this.d(var1, var6.b());
				}
			}

		}
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		super.c(var1, var2, var3);
		if (!var1.D) {
			class_cq[] var4 = class_cq.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				class_cq var7 = var4[var6];
				var1.d(var2.a(var7), this);
			}

			this.f(var1, var2, var3);
			Iterator var8 = class_cq.class_c_in_class_cq.a.iterator();

			class_cq var9;
			while (var8.hasNext()) {
				var9 = (class_cq) var8.next();
				this.d(var1, var2.a(var9));
			}

			var8 = class_cq.class_c_in_class_cq.a.iterator();

			while (var8.hasNext()) {
				var9 = (class_cq) var8.next();
				class_cj var10 = var2.a(var9);
				if (var1.p(var10).c().x()) {
					this.d(var1, var10.a());
				} else {
					this.d(var1, var10.b());
				}
			}

		}
	}

	private int a(class_ago var1, class_cj var2, int var3) {
		if (var1.p(var2).c() != this) {
			return var3;
		} else {
			int var4 = ((Integer) var1.p(var2).b(P)).intValue();
			return var4 > var3 ? var4 : var3;
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.D) {
			if (this.c(var1, var2)) {
				this.f(var1, var2, var3);
			} else {
				this.b(var1, var2, var3, 0);
				var1.g(var2);
			}

		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.aE;
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return !Q ? 0 : this.a(var1, var2, var3, var4);
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		if (!Q) {
			return 0;
		} else {
			int var5 = ((Integer) var3.b(P)).intValue();
			if (var5 == 0) {
				return 0;
			} else if (var4 == class_cq.b) {
				return var5;
			} else {
				EnumSet var6 = EnumSet.noneOf(class_cq.class);
				Iterator var7 = class_cq.class_c_in_class_cq.a.iterator();

				while (var7.hasNext()) {
					class_cq var8 = (class_cq) var7.next();
					if (this.d(var1, var2, var8)) {
						var6.add(var8);
					}
				}

				if (var4.k().c() && var6.isEmpty()) {
					return var5;
				} else if (var6.contains(var4) && !var6.contains(var4.f()) && !var6.contains(var4.e())) {
					return var5;
				} else {
					return 0;
				}
			}
		}
	}

	private boolean d(class_ags var1, class_cj var2, class_cq var3) {
		class_cj var4 = var2.a(var3);
		class_apn var5 = var1.p(var4);
		Block var6 = var5.c();
		boolean var7 = var6.x();
		boolean var8 = var1.p(var2.a()).c().x();
		return !var8 && var7 && e(var1, var4.a()) ? true : (a(var5, var3) ? true : ((var6 == Blocks.POWERED_REPEATER) && (var5.b(class_akx.O) == var3) ? true : !var7 && e(var1, var4.b())));
	}

	protected static boolean e(class_ags var0, class_cj var1) {
		return d(var0.p(var1));
	}

	protected static boolean d(class_apn var0) {
		return a(var0, (class_cq) null);
	}

	protected static boolean a(class_apn var0, class_cq var1) {
		Block var2 = var0.c();
		if (var2 == Blocks.REDSTONE_WIRE) {
			return true;
		} else if (Blocks.UNPOWERED_REPEATER.e(var2)) {
			class_cq var3 = (class_cq) var0.b(class_akx.O);
			return (var3 == var1) || (var3.d() == var1);
		} else {
			return var2.i() && (var1 != null);
		}
	}

	@Override
	public boolean i() {
		return Q;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.aE);
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(P, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(P)).intValue();
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (BlockRedstoneWire.SyntheticClass_1.a[var2.ordinal()]) {
				case 1:
					return var1.a(a, var1.b(N)).a(b, var1.b(O)).a(N, var1.b(a)).a(O, var1.b(b));
				case 2:
					return var1.a(a, var1.b(b)).a(b, var1.b(N)).a(N, var1.b(O)).a(O, var1.b(a));
				case 3:
					return var1.a(a, var1.b(O)).a(b, var1.b(a)).a(N, var1.b(b)).a(O, var1.b(N));
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
			switch (BlockRedstoneWire.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					return var1.a(a, var1.b(N)).a(N, var1.b(a));
				case 2:
					return var1.a(b, var1.b(O)).a(O, var1.b(b));
				default:
					return super.a(var1, var2);
			}
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, N, O, P });
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

	static enum class_a_in_class_amm implements class_oe {
		a("up"),
		b("side"),
		c("none");

		private final String d;

		private class_a_in_class_amm(String var3) {
			d = var3;
		}

		@Override
		public String toString() {
			return l();
		}

		@Override
		public String l() {
			return d;
		}
	}
}
