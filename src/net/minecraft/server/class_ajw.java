package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public class class_ajw extends Block {
	public static final BlockStateEnum a = BlockStateEnum.of("variant", class_ajw.class_a_in_class_ajw.class);

	public class_ajw() {
		super(Material.d);
		this.setBlockData(this.blockStateList.getFirst().set(a, class_ajw.class_a_in_class_ajw.a));
		this.a(CreativeTab.b);
	}

	public int getDropData(IBlockData var1) {
		return ((class_ajw.class_a_in_class_ajw) var1.get(a)).a();
	}

	public IBlockData fromLegacyData(int var1) {
		return this.getBlockData().set(a, class_ajw.class_a_in_class_ajw.a(var1));
	}

	public MaterialMapColor getMapColor(IBlockData var1) {
		return ((class_ajw.class_a_in_class_ajw) var1.get(a)).c();
	}

	public int toLegacyData(IBlockData var1) {
		return ((class_ajw.class_a_in_class_ajw) var1.get(a)).a();
	}

	protected BlockStateList createBlockStateList() {
		return new BlockStateList(this, new IBlockState[] { a });
	}

	public static enum class_a_in_class_ajw implements INamable {
		a(0, "oak", MaterialMapColor.o), b(1, "spruce", MaterialMapColor.J), c(2, "birch", MaterialMapColor.d), d(3, "jungle", MaterialMapColor.l), e(4, "acacia", MaterialMapColor.q), f(5, "dark_oak", "big_oak", MaterialMapColor.B);

		private static final class_ajw.class_a_in_class_ajw[] g;
		private final int h;
		private final String i;
		private final String j;
		private final MaterialMapColor k;

		private class_a_in_class_ajw(int var3, String var4, MaterialMapColor var5) {
			this(var3, var4, var4, var5);
		}

		private class_a_in_class_ajw(int var3, String var4, String var5, MaterialMapColor var6) {
			this.h = var3;
			this.i = var4;
			this.j = var5;
			this.k = var6;
		}

		public int a() {
			return this.h;
		}

		public MaterialMapColor c() {
			return this.k;
		}

		public String toString() {
			return this.i;
		}

		public static class_ajw.class_a_in_class_ajw a(int var0) {
			if (var0 < 0 || var0 >= g.length) {
				var0 = 0;
			}

			return g[var0];
		}

		public String getName() {
			return this.i;
		}

		public String d() {
			return this.j;
		}

		static {
			g = new class_ajw.class_a_in_class_ajw[values().length];
			class_ajw.class_a_in_class_ajw[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ajw.class_a_in_class_ajw var3 = var0[var2];
				g[var3.a()] = var3;
			}

		}
	}
}
