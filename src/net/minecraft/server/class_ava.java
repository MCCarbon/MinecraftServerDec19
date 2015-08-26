package net.minecraft.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_ava {
	private final List a = Lists.newArrayList();
	private final List b = Lists.newArrayList();
	private class_cj c = new class_cj(0, 0, 0);
	private String d = "?";

	public class_cj a() {
		return c;
	}

	public void a(String var1) {
		d = var1;
	}

	public String b() {
		return d;
	}

	public void a(class_ago var1, class_cj var2, class_cj var3, boolean var4, Block var5) {
		if ((var3.n() >= 1) && (var3.o() >= 1) && (var3.p() >= 1)) {
			class_cj var6 = var2.a(var3).a(-1, -1, -1);
			ArrayList var7 = Lists.newArrayList();
			ArrayList var8 = Lists.newArrayList();
			ArrayList var9 = Lists.newArrayList();
			class_cj var10 = new class_cj(Math.min(var2.n(), var6.n()), Math.min(var2.o(), var6.o()), Math.min(var2.p(), var6.p()));
			class_cj var11 = new class_cj(Math.max(var2.n(), var6.n()), Math.max(var2.o(), var6.o()), Math.max(var2.p(), var6.p()));
			c = var3;
			Iterator var12 = class_cj.b(var10, var11).iterator();

			while (true) {
				while (true) {
					class_cj.class_a_in_class_cj var13;
					class_cj var14;
					class_apn var15;
					do {
						if (!var12.hasNext()) {
							a.clear();
							a.addAll(var7);
							a.addAll(var8);
							a.addAll(var9);
							if (var4) {
								this.a(var1, var10, var11.a(1, 1, 1));
							} else {
								b.clear();
							}

							return;
						}

						var13 = (class_cj.class_a_in_class_cj) var12.next();
						var14 = var13.b(var10);
						var15 = var1.p(var13);
					} while ((var5 != null) && (var5 == var15.c()));

					TileEntity var16 = var1.s(var13);
					if (var16 != null) {
						class_dn var17 = new class_dn();
						var16.b(var17);
						var17.q("x");
						var17.q("y");
						var17.q("z");
						var8.add(new class_ava.class_a_in_class_ava(var14, var15, var17, null));
					} else if (!var15.c().q() && !var15.c().d()) {
						var9.add(new class_ava.class_a_in_class_ava(var14, var15, (class_dn) null, null));
					} else {
						var7.add(new class_ava.class_a_in_class_ava(var14, var15, (class_dn) null, null));
					}
				}
			}
		}
	}

	private void a(class_ago var1, class_cj var2, class_cj var3) {
		List var4 = var1.a(Entity.class, new class_ayk(var2, var3), new Predicate() {
			public boolean a(Entity var1) {
				return !(var1 instanceof class_yu);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		});
		b.clear();

		class_aym var7;
		class_dn var8;
		class_cj var9;
		for (Iterator var5 = var4.iterator(); var5.hasNext(); b.add(new class_ava.class_b_in_class_ava(var7, var9, var8, null))) {
			Entity var6 = (Entity) var5.next();
			var7 = new class_aym(var6.s - var2.n(), var6.t - var2.o(), var6.u - var2.p());
			var8 = new class_dn();
			var6.d(var8);
			if (var6 instanceof class_ww) {
				var9 = ((class_ww) var6).m().b(var2);
			} else {
				var9 = new class_cj(var7);
			}
		}

	}

	public Map a(class_cj var1, class_auz var2) {
		HashMap var3 = Maps.newHashMap();
		class_aua var4 = var2.g();
		Iterator var5 = a.iterator();

		while (true) {
			class_ava.class_a_in_class_ava var6;
			class_cj var7;
			do {
				if (!var5.hasNext()) {
					return var3;
				}

				var6 = (class_ava.class_a_in_class_ava) var5.next();
				var7 = a(var2, var6.a).a(var1);
			} while ((var4 != null) && !var4.b(var7));

			class_apn var8 = var6.b;
			if ((var8.c() == Blocks.STRUCTURE_BLOCK) && (var6.c != null)) {
				class_apb.class_a_in_class_apb var9 = class_apb.class_a_in_class_apb.valueOf(var6.c.l("mode"));
				if (var9 == class_apb.class_a_in_class_apb.d) {
					var3.put(var7, var6.c.l("metadata"));
				}
			}
		}
	}

	public class_cj a(class_auz var1, class_cj var2, class_auz var3, class_cj var4) {
		class_cj var5 = a(var1, var2);
		class_cj var6 = a(var3, var4);
		return var5.b(var6);
	}

	public static class_cj a(class_auz var0, class_cj var1) {
		return a(var1, var0.b(), var0.c());
	}

	public void a(class_ago var1, class_cj var2, class_auz var3) {
		var3.i();
		this.b(var1, var2, var3);
	}

	public void b(class_ago var1, class_cj var2, class_auz var3) {
		if (!a.isEmpty() && (c.n() >= 1) && (c.o() >= 1) && (c.p() >= 1)) {
			Block var4 = var3.f();
			class_aua var5 = var3.g();
			Iterator var6 = a.iterator();

			while (true) {
				class_ava.class_a_in_class_ava var7;
				Block var8;
				class_cj var9;
				do {
					do {
						do {
							if (!var6.hasNext()) {
								var6 = a.iterator();

								while (true) {
									class_cj var13;
									do {
										do {
											if (!var6.hasNext()) {
												if (!var3.e()) {
													this.a(var1, var2, var3.b(), var3.c(), var5);
												}

												return;
											}

											var7 = (class_ava.class_a_in_class_ava) var6.next();
										} while ((var4 != null) && (var4 == var7.b.c()));

										var13 = a(var3, var7.a).a(var2);
									} while ((var5 != null) && !var5.b(var13));

									var1.c(var13, var7.b.c());
									if (var7.c != null) {
										TileEntity var14 = var1.s(var13);
										if (var14 != null) {
											var14.o_();
										}
									}
								}
							}

							var7 = (class_ava.class_a_in_class_ava) var6.next();
							var8 = var7.b.c();
						} while ((var4 != null) && (var4 == var8));
					} while (var3.h() && (var8 == Blocks.STRUCTURE_BLOCK));

					var9 = a(var3, var7.a).a(var2);
				} while ((var5 != null) && !var5.b(var9));

				class_apn var10 = var8.a(var7.b, var3.b());
				class_apn var11 = var8.a(var10, var3.c());
				TileEntity var12;
				if (var7.c != null) {
					var12 = var1.s(var9);
					if (var12 != null) {
						if (var12 instanceof class_pp) {
							((class_pp) var12).l();
						}

						var1.a(var9, Blocks.BARRIER.S(), 4);
					}
				}

				if (var1.a(var9, var11, 2) && (var7.c != null)) {
					var12 = var1.s(var9);
					if (var12 != null) {
						var7.c.a("x", var9.n());
						var7.c.a("y", var9.o());
						var7.c.a("z", var9.p());
						var12.a(var7.c);
					}
				}
			}
		}
	}

	private void a(class_ago var1, class_cj var2, Block.class_a_in_class_ail var3, Block.class_c_in_class_ail var4, class_aua var5) {
		Iterator var6 = b.iterator();

		while (true) {
			class_ava.class_b_in_class_ava var7;
			class_cj var8;
			do {
				if (!var6.hasNext()) {
					return;
				}

				var7 = (class_ava.class_b_in_class_ava) var6.next();
				var8 = a(var7.b, var3, var4).a(var2);
			} while ((var5 != null) && !var5.b(var8));

			class_dn var9 = var7.c;
			class_aym var10 = a(var7.a, var3, var4);
			class_aym var11 = var10.b(var2.n(), var2.o(), var2.p());
			class_du var12 = new class_du();
			var12.a((new class_dp(var11.a)));
			var12.a((new class_dp(var11.b)));
			var12.a((new class_dp(var11.c)));
			var9.a("Pos", var12);
			var9.a("UUID", UUID.randomUUID());

			Entity var13;
			try {
				var13 = EntityTypes.a(var9, var1);
			} catch (Exception var15) {
				var13 = null;
			}

			if (var13 != null) {
				if (var13 instanceof class_ww) {
					var13.a(var3);
					var13.a(var4);
					var13.b(var8.n(), var8.o(), var8.p());
					var13.b(var11.a, var11.b, var11.c, var13.y, var13.z);
				} else {
					float var14 = var13.a(var3);
					var14 += var13.y - var13.a(var4);
					var13.b(var11.a, var11.b, var11.c, var14, var13.z);
				}

				var1.a(var13);
			}
		}
	}

	public class_cj a(Block.class_c_in_class_ail var1) {
		switch (class_ava.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
			case 2:
				return new class_cj(c.p(), c.o(), c.n());
			default:
				return c;
		}
	}

	private static class_cj a(class_cj var0, Block.class_a_in_class_ail var1, Block.class_c_in_class_ail var2) {
		int var3 = var0.n();
		int var4 = var0.o();
		int var5 = var0.p();
		boolean var6 = true;
		switch (class_ava.SyntheticClass_1.b[var1.ordinal()]) {
			case 1:
				var5 = -var5;
				break;
			case 2:
				var3 = -var3;
				break;
			default:
				var6 = false;
		}

		switch (class_ava.SyntheticClass_1.a[var2.ordinal()]) {
			case 1:
				return new class_cj(var5, var4, -var3);
			case 2:
				return new class_cj(-var5, var4, var3);
			case 3:
				return new class_cj(-var3, var4, -var5);
			default:
				return var6 ? new class_cj(var3, var4, var5) : var0;
		}
	}

	private static class_aym a(class_aym var0, Block.class_a_in_class_ail var1, Block.class_c_in_class_ail var2) {
		double var3 = var0.a;
		double var5 = var0.b;
		double var7 = var0.c;
		boolean var9 = true;
		switch (class_ava.SyntheticClass_1.b[var1.ordinal()]) {
			case 1:
				var7 = 1.0D - var7;
				break;
			case 2:
				var3 = 1.0D - var3;
				break;
			default:
				var9 = false;
		}

		switch (class_ava.SyntheticClass_1.a[var2.ordinal()]) {
			case 1:
				return new class_aym(var7, var5, 1.0D - var3);
			case 2:
				return new class_aym(1.0D - var7, var5, var3);
			case 3:
				return new class_aym(1.0D - var3, var5, 1.0D - var7);
			default:
				return var9 ? new class_aym(var3, var5, var7) : var0;
		}
	}

	public void a(class_dn var1) {
		class_du var2 = new class_du();

		class_dn var5;
		for (Iterator var3 = a.iterator(); var3.hasNext(); var2.a(var5)) {
			class_ava.class_a_in_class_ava var4 = (class_ava.class_a_in_class_ava) var3.next();
			var5 = new class_dn();
			var5.a("pos", this.a(new int[] { var4.a.n(), var4.a.o(), var4.a.p() }));
			var5.a("state", Block.f(var4.b));
			if (var4.c != null) {
				var5.a("nbt", var4.c);
			}
		}

		class_du var7 = new class_du();

		class_dn var6;
		for (Iterator var8 = b.iterator(); var8.hasNext(); var7.a(var6)) {
			class_ava.class_b_in_class_ava var9 = (class_ava.class_b_in_class_ava) var8.next();
			var6 = new class_dn();
			var6.a("pos", this.a(new double[] { var9.a.a, var9.a.b, var9.a.c }));
			var6.a("blockPos", this.a(new int[] { var9.b.n(), var9.b.o(), var9.b.p() }));
			if (var9.c != null) {
				var6.a("nbt", var9.c);
			}
		}

		var1.a("blocks", var2);
		var1.a("entities", var7);
		var1.a("size", this.a(new int[] { c.n(), c.o(), c.p() }));
		var1.a("version", 1);
		var1.a("author", d);
	}

	public void b(class_dn var1) {
		a.clear();
		b.clear();
		class_du var2 = var1.c("size", 3);
		c = new class_cj(var2.c(0), var2.c(1), var2.c(2));
		d = var1.l("author");
		class_du var3 = var1.c("blocks", 10);

		for (int var4 = 0; var4 < var3.c(); ++var4) {
			class_dn var5 = var3.b(var4);
			class_du var6 = var5.c("pos", 3);
			class_cj var7 = new class_cj(var6.c(0), var6.c(1), var6.c(2));
			int var8 = var5.h("state");
			class_apn var9 = Block.d(var8);
			class_dn var10;
			if (var5.e("nbt")) {
				var10 = var5.o("nbt");
			} else {
				var10 = null;
			}

			a.add(new class_ava.class_a_in_class_ava(var7, var9, var10, null));
		}

		class_du var12 = var1.c("entities", 10);

		for (int var13 = 0; var13 < var12.c(); ++var13) {
			class_dn var14 = var12.b(var13);
			class_du var15 = var14.c("pos", 6);
			class_aym var16 = new class_aym(var15.e(0), var15.e(1), var15.e(2));
			class_du var17 = var14.c("blockPos", 3);
			class_cj var18 = new class_cj(var17.c(0), var17.c(1), var17.c(2));
			if (var14.e("nbt")) {
				class_dn var11 = var14.o("nbt");
				b.add(new class_ava.class_b_in_class_ava(var16, var18, var11, null));
			}
		}

	}

	private class_du a(int... var1) {
		class_du var2 = new class_du();
		int[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			int var6 = var3[var5];
			var2.a((new class_dt(var6)));
		}

		return var2;
	}

	private class_du a(double... var1) {
		class_du var2 = new class_du();
		double[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.a((new class_dp(var6)));
		}

		return var2;
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
				a[Block.class_c_in_class_ail.d.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.b.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.c.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	static class class_b_in_class_ava {
		public final class_aym a;
		public final class_cj b;
		public final class_dn c;

		private class_b_in_class_ava(class_aym var1, class_cj var2, class_dn var3) {
			a = var1;
			b = var2;
			c = var3;
		}

		// $FF: synthetic method
		class_b_in_class_ava(class_aym var1, class_cj var2, class_dn var3, Object var4) {
			this(var1, var2, var3);
		}
	}

	static class class_a_in_class_ava {
		public final class_cj a;
		public final class_apn b;
		public final class_dn c;

		private class_a_in_class_ava(class_cj var1, class_apn var2, class_dn var3) {
			a = var1;
			b = var2;
			c = var3;
		}

		// $FF: synthetic method
		class_a_in_class_ava(class_cj var1, class_apn var2, class_dn var3, Object var4) {
			this(var1, var2, var3);
		}
	}
}
