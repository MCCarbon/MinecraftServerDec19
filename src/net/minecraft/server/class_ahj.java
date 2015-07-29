package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cj;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public class class_ahj extends Block {
	public static final BlockStateEnum a = BlockStateEnum.of("variant", class_ahj.class_a_in_class_ahj.class);
	public static final class_anw b = class_anw.a("snowy");

	protected class_ahj() {
		super(Material.c);
		this.setBlockData(this.blockStateList.getFirst().set(a, class_ahj.class_a_in_class_ahj.a).set(b, Boolean.valueOf(false)));
		this.a(CreativeTab.b);
	}

	public MaterialMapColor getMapColor(IBlockData var1) {
		return ((class_ahj.class_a_in_class_ahj) var1.get(a)).d();
	}

	public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
		if (var1.get(a) == class_ahj.class_a_in_class_ahj.c) {
			Block var4 = var2.p(var3.a()).getBlock();
			var1 = var1.set(b, Boolean.valueOf(var4 == Blocks.SNOW || var4 == Blocks.SNOW_LAYER));
		}

		return var1;
	}

	public int j(World var1, class_cj var2) {
		IBlockData var3 = var1.p(var2);
		return var3.getBlock() != this ? 0 : ((class_ahj.class_a_in_class_ahj) var3.get(a)).a();
	}

	public IBlockData fromLegacyData(int var1) {
		return this.getBlockData().set(a, class_ahj.class_a_in_class_ahj.a(var1));
	}

	public int toLegacyData(IBlockData var1) {
		return ((class_ahj.class_a_in_class_ahj) var1.get(a)).a();
	}

	protected BlockStateList createBlockStateList() {
		return new BlockStateList(this, new IBlockState[] { a, b });
	}

	public int getDropData(IBlockData var1) {
		class_ahj.class_a_in_class_ahj var2 = (class_ahj.class_a_in_class_ahj) var1.get(a);
		if (var2 == class_ahj.class_a_in_class_ahj.c) {
			var2 = class_ahj.class_a_in_class_ahj.a;
		}

		return var2.a();
	}

	public static enum class_a_in_class_ahj implements INamable {
		a(0, "dirt", "default", MaterialMapColor.l), b(1, "coarse_dirt", "coarse", MaterialMapColor.l), c(2, "podzol", MaterialMapColor.J);

	    private static final class_a_in_class_ahj[] d;
	    
	    static {
	        d = new class_a_in_class_ahj[values().length];
	        for (final class_a_in_class_ahj a2 : values()) {
	        	d[a2.a()] = a2;
	        }
	    }
	
	    public static class_a_in_class_ahj a(int id) {
	        if (id < 0 || id >= d.length) {
	        	id = 0;
	        }
	        return d[id];
	    }
	    
		private final int e;
		private final String f;
		private final String g;
		private final MaterialMapColor h;

		private class_a_in_class_ahj(int var3, String var4, MaterialMapColor var5) {
			this(var3, var4, var4, var5);
		}

		private class_a_in_class_ahj(int var3, String var4, String var5, MaterialMapColor var6) {
			this.e = var3;
			this.f = var4;
			this.g = var5;
			this.h = var6;
		}

		public int a() {
			return this.e;
		}

		public String c() {
			return this.g;
		}

		public MaterialMapColor d() {
			return this.h;
		}

		public String toString() {
			return this.f;
		}

		public String getName() {
			return this.f;
		}

	}
}
