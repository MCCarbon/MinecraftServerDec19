package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_auc {
	public static final class_auy a = new class_auy();
	private static final class_auz b = (new class_auz()).a(true);
	private static final class_auz c;
	private static final List d;
	private static final List e;
	private static final class_auc.class_b_in_class_auc f;
	private static final List g;
	private static final class_auc.class_b_in_class_auc h;
	private static final class_auc.class_b_in_class_auc i;
	private static final List j;
	private static final class_auc.class_b_in_class_auc k;

	public static void a() {
		class_aup.a(class_auc.class_a_in_class_auc.class, "ECP");
	}

	private static class_auc.class_a_in_class_auc b(class_auc.class_a_in_class_auc var0, class_cj var1, String var2, Block.class_c_in_class_ail var3, boolean var4) {
		class_auc.class_a_in_class_auc var5 = new class_auc.class_a_in_class_auc(var2, var0.c, var3, var4);
		class_cj var6 = var0.a.a(var0.b, var1, var5.b, class_cj.a);
		var5.a(var6.n(), var6.o(), var6.p());
		return var5;
	}

	public static void a(class_cj var0, Block.class_c_in_class_ail var1, List var2, Random var3) {
		k.a();
		f.a();
		i.a();
		h.a();
		class_auc.class_a_in_class_auc var4 = new class_auc.class_a_in_class_auc("base_floor", var0, var1, true);
		var2.add(var4);
		class_auc.class_a_in_class_auc var5;
		var2.add(var5 = b(var4, new class_cj(-1, 0, -1), "second_floor", var1, false));
		var2.add(var5 = b(var5, new class_cj(-1, 4, -1), "third_floor", var1, false));
		var2.add(var5 = b(var5, new class_cj(-1, 8, -1), "third_roof", var1, true));
		b(h, 1, var5, (class_cj) null, var2, var3);
	}

	private static boolean b(class_auc.class_b_in_class_auc var0, int var1, class_auc.class_a_in_class_auc var2, class_cj var3, List var4, Random var5) {
		if (var1 > 8) {
			return false;
		} else {
			ArrayList var6 = Lists.newArrayList();
			if (var0.a(var1, var2, var3, var6, var5)) {
				boolean var7 = false;
				int var8 = var5.nextInt();
				Iterator var9 = var6.iterator();

				while (var9.hasNext()) {
					class_aur var10 = (class_aur) var9.next();
					var10.m = var8;
					class_aur var11 = class_aur.a(var4, var10.c());
					if ((var11 != null) && (var11.m != var2.m)) {
						var7 = true;
						break;
					}
				}

				if (!var7) {
					var4.addAll(var6);
					return true;
				}
			}

			return false;
		}
	}

	static {
		c = (new class_auz()).a(true).a(Blocks.AIR);
		d = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(Items.k, 0, 2, 7, 5), new class_oj(Items.l, 0, 4, 8, 10), new class_oj(Items.m, 0, 2, 7, 15), new class_oj(Items.bT, 0, 2, 6, 2), new class_oj(Items.cN, 0, 1, 10, 5), new class_oj(Items.aC, 0, 1, 1, 3), new class_oj(Items.cp, 0, 1, 1, 1), new class_oj(Items.cq, 0, 1, 1, 1), new class_oj(Items.cr, 0, 1, 1, 1) }));
		e = Lists.newArrayList((Object[]) (new Item[] { Items.w, Items.ah, Items.af, Items.ag, Items.ae, Items.y, Items.x, Items.n, Items.ad, Items.ab, Items.ac, Items.aa, Items.b, Items.a }));
		f = new class_auc.class_b_in_class_auc() {
			@Override
			public void a() {
			}

			@Override
			public boolean a(int var1, class_auc.class_a_in_class_auc var2, class_cj var3, List var4, Random var5) {
				if (var1 > 8) {
					return false;
				} else {
					Block.class_c_in_class_ail var6 = var2.b.c();
					class_auc.class_a_in_class_auc var7;
					var4.add(var7 = class_auc.b(var2, var3, "base_floor", var6, true));
					int var8 = var5.nextInt(3);
					if (var8 == 0) {
						var4.add(class_auc.b(var7, new class_cj(-1, 4, -1), "base_roof", var6, true));
					} else if (var8 == 1) {
						var4.add(var7 = class_auc.b(var7, new class_cj(-1, 0, -1), "second_floor_2", var6, false));
						var4.add(var7 = class_auc.b(var7, new class_cj(-1, 8, -1), "second_roof", var6, false));
						class_auc.b(class_auc.h, var1 + 1, var7, (class_cj) null, var4, var5);
					} else if (var8 == 2) {
						var4.add(var7 = class_auc.b(var7, new class_cj(-1, 0, -1), "second_floor_2", var6, false));
						var4.add(var7 = class_auc.b(var7, new class_cj(-1, 4, -1), "third_floor_c", var6, false));
						var4.add(var7 = class_auc.b(var7, new class_cj(-1, 8, -1), "third_roof", var6, true));
						class_auc.b(class_auc.h, var1 + 1, var7, (class_cj) null, var4, var5);
					}

					return true;
				}
			}
		};
		g = Lists.newArrayList((Object[]) (new class_oh[] { new class_oh(Block.class_c_in_class_ail.a, new class_cj(1, -1, 0)), new class_oh(Block.class_c_in_class_ail.b, new class_cj(6, -1, 1)), new class_oh(Block.class_c_in_class_ail.d, new class_cj(0, -1, 5)), new class_oh(Block.class_c_in_class_ail.c, new class_cj(5, -1, 6)) }));
		h = new class_auc.class_b_in_class_auc() {
			@Override
			public void a() {
			}

			@Override
			public boolean a(int var1, class_auc.class_a_in_class_auc var2, class_cj var3, List var4, Random var5) {
				Block.class_c_in_class_ail var6 = var2.b.c();
				class_auc.class_a_in_class_auc var7;
				var4.add(var7 = class_auc.b(var2, new class_cj(3 + var5.nextInt(2), -3, 3 + var5.nextInt(2)), "tower_base", var6, true));
				var4.add(var7 = class_auc.b(var7, new class_cj(0, 7, 0), "tower_piece", var6, true));
				class_auc.class_a_in_class_auc var8 = var5.nextInt(3) == 0 ? var7 : null;
				int var9 = 1 + var5.nextInt(3);

				for (int var10 = 0; var10 < var9; ++var10) {
					var4.add(var7 = class_auc.b(var7, new class_cj(0, 4, 0), "tower_piece", var6, true));
					if ((var10 < (var9 - 1)) && var5.nextBoolean()) {
						var8 = var7;
					}
				}

				if (var8 != null) {
					Iterator var13 = class_auc.g.iterator();

					while (var13.hasNext()) {
						class_oh var11 = (class_oh) var13.next();
						if (var5.nextBoolean()) {
							class_auc.class_a_in_class_auc var12;
							var4.add(var12 = class_auc.b(var8, (class_cj) var11.b(), "bridge_end", var6.a((Block.class_c_in_class_ail) var11.a()), true));
							class_auc.b(class_auc.i, var1 + 1, var12, (class_cj) null, var4, var5);
						}
					}

					var4.add(class_auc.b(var7, new class_cj(-1, 4, -1), "tower_top", var6, true));
				} else {
					if (var1 != 7) {
						return class_auc.b(class_auc.k, var1 + 1, var7, (class_cj) null, var4, var5);
					}

					var4.add(class_auc.b(var7, new class_cj(-1, 4, -1), "tower_top", var6, true));
				}

				return true;
			}
		};
		i = new class_auc.class_b_in_class_auc() {
			public boolean a;

			@Override
			public void a() {
				a = false;
			}

			@Override
			public boolean a(int var1, class_auc.class_a_in_class_auc var2, class_cj var3, List var4, Random var5) {
				Block.class_c_in_class_ail var6 = var2.b.c();
				int var7 = var5.nextInt(4) + 1;
				class_auc.class_a_in_class_auc var8;
				var4.add(var8 = class_auc.b(var2, new class_cj(0, 0, -4), "bridge_piece", var6, true));
				var8.m = -1;
				byte var9 = 0;

				for (int var10 = 0; var10 < var7; ++var10) {
					if (var5.nextBoolean()) {
						var4.add(var8 = class_auc.b(var8, new class_cj(0, var9, -4), "bridge_piece", var6, true));
						var9 = 0;
					} else {
						if (var5.nextBoolean()) {
							var4.add(var8 = class_auc.b(var8, new class_cj(0, var9, -4), "bridge_steep_stairs", var6, true));
						} else {
							var4.add(var8 = class_auc.b(var8, new class_cj(0, var9, -8), "bridge_gentle_stairs", var6, true));
						}

						var9 = 4;
					}
				}

				if (!a && (var5.nextInt(10 - var1) == 0)) {
					var4.add(class_auc.b(var8, new class_cj(-8 + var5.nextInt(8), var9, -70 + var5.nextInt(10)), "ship", var6, true));
					a = true;
				} else if (!class_auc.b(class_auc.f, var1 + 1, var8, new class_cj(-3, var9 + 1, -11), var4, var5)) {
					return false;
				}

				var4.add(var8 = class_auc.b(var8, new class_cj(4, var9, 0), "bridge_end", var6.a(Block.class_c_in_class_ail.c), true));
				var8.m = -1;
				return true;
			}
		};
		j = Lists.newArrayList((Object[]) (new class_oh[] { new class_oh(Block.class_c_in_class_ail.a, new class_cj(4, -1, 0)), new class_oh(Block.class_c_in_class_ail.b, new class_cj(12, -1, 4)), new class_oh(Block.class_c_in_class_ail.d, new class_cj(0, -1, 8)), new class_oh(Block.class_c_in_class_ail.c, new class_cj(8, -1, 12)) }));
		k = new class_auc.class_b_in_class_auc() {
			@Override
			public void a() {
			}

			@Override
			public boolean a(int var1, class_auc.class_a_in_class_auc var2, class_cj var3, List var4, Random var5) {
				Block.class_c_in_class_ail var7 = var2.b.c();
				class_auc.class_a_in_class_auc var6;
				var4.add(var6 = class_auc.b(var2, new class_cj(-3, 4, -3), "fat_tower_base", var7, true));
				var4.add(var6 = class_auc.b(var6, new class_cj(0, 4, 0), "fat_tower_middle", var7, true));

				for (int var8 = 0; (var8 < 2) && (var5.nextInt(3) != 0); ++var8) {
					var4.add(var6 = class_auc.b(var6, new class_cj(0, 8, 0), "fat_tower_middle", var7, true));
					Iterator var9 = class_auc.j.iterator();

					while (var9.hasNext()) {
						class_oh var10 = (class_oh) var9.next();
						if (var5.nextBoolean()) {
							class_auc.class_a_in_class_auc var11;
							var4.add(var11 = class_auc.b(var6, (class_cj) var10.b(), "bridge_end", var7.a((Block.class_c_in_class_ail) var10.a()), true));
							class_auc.b(class_auc.i, var1 + 1, var11, (class_cj) null, var4, var5);
						}
					}
				}

				var4.add(class_auc.b(var6, new class_cj(-2, 8, -2), "fat_tower_top", var7, true));
				return true;
			}
		};
	}

	interface class_b_in_class_auc {
		void a();

		boolean a(int var1, class_auc.class_a_in_class_auc var2, class_cj var3, List var4, Random var5);
	}

	public static class class_a_in_class_auc extends class_aut {
		private String d;
		private Block.class_c_in_class_ail e;
		private boolean f;

		public class_a_in_class_auc() {
		}

		public class_a_in_class_auc(String var1, class_cj var2, Block.class_c_in_class_ail var3, boolean var4) {
			super(0);
			d = var1;
			e = var3;
			f = var4;
			this.a(var2);
		}

		private void a(class_cj var1) {
			class_ava var2 = class_auc.a.a(new class_ke("endcity/" + d));
			class_auz var3;
			if (f) {
				var3 = class_auc.b.a().a(e);
			} else {
				var3 = class_auc.c.a().a(e);
			}

			this.a(var2, var1, var3);
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Template", d);
			var1.a("Rot", e.name());
			var1.a("OW", f);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			d = var1.l("Template");
			e = Block.class_c_in_class_ail.valueOf(var1.l("Rot"));
			f = var1.p("OW");
			this.a(c);
		}

		@Override
		protected void a(String var1, class_cj var2, class_ago var3, Random var4, class_aua var5) {
			if (var1.startsWith("Chest")) {
				class_cj var6 = var2.b();
				if (var5.b(var6)) {
					TileEntity var7 = var3.s(var6);
					if (var7 instanceof class_aok) {
						ArrayList var8 = Lists.newArrayList((Iterable) class_auc.d);
						Iterator var9 = class_auc.e.iterator();

						while (var9.hasNext()) {
							Item var10 = (Item) var9.next();
							var8.add(new class_oj(class_afl.a(var4, new class_aco(var10), 20 + var4.nextInt(20)), 1, 1, 3));
						}

						class_oj.a(var4, var8, ((class_aok) var7), 2 + var4.nextInt(5));
					}
				}
			} else if (var1.startsWith("Sentry")) {
				EntityShulker var11 = new EntityShulker(var3);
				var11.b(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D);
				var11.f(var2);
				var3.a(var11);
			}

		}
	}
}
