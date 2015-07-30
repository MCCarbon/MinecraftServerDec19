package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;

public class BlockAir extends Block {

	protected BlockAir() {
		super(Material.AIR);
	}

	public int getRenderType() {
		return -1;
	}

	public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean a(IBlockData blockdata, boolean var2) {
		return false;
	}

	public void dropNaturally(World world, BlockPosition var2, IBlockData var3, float var4, int var5) {
	}

	public boolean isReplaceable(World world, BlockPosition var2) {
		return true;
	}

}
