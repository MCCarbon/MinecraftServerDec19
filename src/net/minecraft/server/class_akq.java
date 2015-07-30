package net.minecraft.server;

import net.minecraft.server.class_ahx;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.INamable;

public class class_akq extends class_ahx {
	public static final BlockStateEnum a = BlockStateEnum.of("variant", class_akq.class_a_in_class_akq.class);

	public class_akq() {
		this.setBlockData(this.blockStateList.getFirst().set(a, class_akq.class_a_in_class_akq.a));
	}

	public int getDropData(IBlockData var1) {
		return ((class_akq.class_a_in_class_akq) var1.get(a)).a();
	}

	public MaterialMapColor getMapColor(IBlockData var1) {
		return ((class_akq.class_a_in_class_akq) var1.get(a)).c();
	}

	public IBlockData fromLegacyData(int var1) {
		return this.getBlockData().set(a, class_akq.class_a_in_class_akq.a(var1));
	}

	public int toLegacyData(IBlockData var1) {
		return ((class_akq.class_a_in_class_akq) var1.get(a)).a();
	}

	protected BlockStateList createBlockStateList() {
		return new BlockStateList(this, new IBlockState[] { a });
	}

	public static enum class_a_in_class_akq implements INamable {
		a(0, "sand", "default", MaterialMapColor.COLOR3), b(1, "red_sand", "red", MaterialMapColor.COLOR16);

		private static final class_akq.class_a_in_class_akq[] c;
		private final int d;
		private final String e;
		private final MaterialMapColor f;
		private final String g;

		private class_a_in_class_akq(int var3, String var4, String var5, MaterialMapColor var6) {
			this.d = var3;
			this.e = var4;
			this.f = var6;
			this.g = var5;
		}

		public int a() {
			return this.d;
		}

		public String toString() {
			return this.e;
		}

		public MaterialMapColor c() {
			return this.f;
		}

		public static class_akq.class_a_in_class_akq a(int var0) {
			if (var0 < 0 || var0 >= c.length) {
				var0 = 0;
			}

			return c[var0];
		}

		public String getName() {
			return this.e;
		}

		public String d() {
			return this.g;
		}

		static {
			c = new class_akq.class_a_in_class_akq[values().length];
			class_akq.class_a_in_class_akq[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_akq.class_a_in_class_akq var3 = var0[var2];
				c[var3.a()] = var3;
			}

		}
	}
}
