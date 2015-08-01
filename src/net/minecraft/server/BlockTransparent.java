package net.minecraft.server;


public class BlockTransparent extends Block {

	protected boolean R;

	protected BlockTransparent(Material material, boolean var2) {
		super(material);
		R = var2;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

}
