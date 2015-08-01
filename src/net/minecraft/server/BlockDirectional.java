package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.BlockStateDirection;
import net.minecraft.server.EnumDirection.EnumDirectionLimit;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;

public abstract class BlockDirectional extends Block {

	public static final BlockStateDirection FACING = BlockStateDirection.of("facing", EnumDirectionLimit.HORIZONTAL);

	protected BlockDirectional(Material material) {
		super(material);
	}

	protected BlockDirectional(Material material, MaterialMapColor mapcolor) {
		super(material, mapcolor);
	}

}
