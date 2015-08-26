package net.minecraft.server;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public abstract class BlockFlowers extends BlockPlant {
	protected class_aqa a;

	protected BlockFlowers() {
		this.j(M.b().a(n(), l() == BlockFlowers.class_b_in_class_ake.b ? BlockFlowers.class_a_in_class_ake.b : BlockFlowers.class_a_in_class_ake.a));
	}

	@Override
	public int a(class_apn var1) {
		return ((BlockFlowers.class_a_in_class_ake) var1.b(n())).b();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(n(), BlockFlowers.class_a_in_class_ake.a(l(), var1));
	}

	public abstract BlockFlowers.class_b_in_class_ake l();

	public class_aqc n() {
		if (a == null) {
			a = class_aqa.a("type", BlockFlowers.class_a_in_class_ake.class, new Predicate() {
				public boolean a(BlockFlowers.class_a_in_class_ake var1) {
					return var1.a() == BlockFlowers.this.l();
				}

				// $FF: synthetic method
				@Override
				public boolean apply(Object var1) {
					return this.a((BlockFlowers.class_a_in_class_ake) var1);
				}
			});
		}

		return a;
	}

	@Override
	public int c(class_apn var1) {
		return ((BlockFlowers.class_a_in_class_ake) var1.b(n())).b();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { n() });
	}

	public static enum class_a_in_class_ake implements class_oe {
		a(BlockFlowers.class_b_in_class_ake.a, 0, "dandelion"),
		b(BlockFlowers.class_b_in_class_ake.b, 0, "poppy"),
		c(BlockFlowers.class_b_in_class_ake.b, 1, "blue_orchid", "blueOrchid"),
		d(BlockFlowers.class_b_in_class_ake.b, 2, "allium"),
		e(BlockFlowers.class_b_in_class_ake.b, 3, "houstonia"),
		f(BlockFlowers.class_b_in_class_ake.b, 4, "red_tulip", "tulipRed"),
		g(BlockFlowers.class_b_in_class_ake.b, 5, "orange_tulip", "tulipOrange"),
		h(BlockFlowers.class_b_in_class_ake.b, 6, "white_tulip", "tulipWhite"),
		i(BlockFlowers.class_b_in_class_ake.b, 7, "pink_tulip", "tulipPink"),
		j(BlockFlowers.class_b_in_class_ake.b, 8, "oxeye_daisy", "oxeyeDaisy");

		private static final BlockFlowers.class_a_in_class_ake[][] k;
		private final BlockFlowers.class_b_in_class_ake l;
		private final int m;
		private final String n;
		private final String o;

		private class_a_in_class_ake(BlockFlowers.class_b_in_class_ake var3, int var4, String var5) {
			this(var3, var4, var5, var5);
		}

		private class_a_in_class_ake(BlockFlowers.class_b_in_class_ake var3, int var4, String var5, String var6) {
			l = var3;
			m = var4;
			n = var5;
			o = var6;
		}

		public BlockFlowers.class_b_in_class_ake a() {
			return l;
		}

		public int b() {
			return m;
		}

		public static BlockFlowers.class_a_in_class_ake a(BlockFlowers.class_b_in_class_ake var0, int var1) {
			BlockFlowers.class_a_in_class_ake[] var2 = k[var0.ordinal()];
			if ((var1 < 0) || (var1 >= var2.length)) {
				var1 = 0;
			}

			return var2[var1];
		}

		@Override
		public String toString() {
			return n;
		}

		@Override
		public String l() {
			return n;
		}

		public String d() {
			return o;
		}

		static {
			k = new BlockFlowers.class_a_in_class_ake[BlockFlowers.class_b_in_class_ake.values().length][];
			BlockFlowers.class_b_in_class_ake[] var0 = BlockFlowers.class_b_in_class_ake.values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				final BlockFlowers.class_b_in_class_ake var3 = var0[var2];
				Collection var4 = Collections2.filter(Lists.newArrayList((Object[]) values()), new Predicate() {
					public boolean a(BlockFlowers.class_a_in_class_ake var1) {
						return var1.a() == var3;
					}

					// $FF: synthetic method
					@Override
					public boolean apply(Object var1) {
						return this.a((BlockFlowers.class_a_in_class_ake) var1);
					}
				});
				k[var3.ordinal()] = (BlockFlowers.class_a_in_class_ake[]) var4.toArray(new BlockFlowers.class_a_in_class_ake[var4.size()]);
			}

		}
	}

	public static enum class_b_in_class_ake {
		a,
		b;

		public BlockFlowers a() {
			return this == a ? Blocks.YELLOW_FLOWER : Blocks.RED_FLOWER;
		}
	}
}
