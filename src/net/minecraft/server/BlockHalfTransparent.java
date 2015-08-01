package net.minecraft.server;


public class BlockHalfTransparent extends Block {

	protected BlockHalfTransparent(Material var1, boolean var2) {
		this(var1, var2, var1.getMapColor());
	}

	protected BlockHalfTransparent(Material var1, boolean var2, MaterialMapColor var3) {
		super(var1, var3);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

}
