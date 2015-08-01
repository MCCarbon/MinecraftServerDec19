package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.BlockStateDirection;
import net.minecraft.server.Material;

public abstract class class_ahi extends Block {

	public static final BlockStateDirection FACING = BlockStateDirection.of("facing");

	protected class_ahi(Material material) {
		super(material);
	}

}
