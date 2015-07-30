package net.minecraft.server;

import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;

public class MaterialLiquid extends Material {

	public MaterialLiquid(MaterialMapColor mapcolor) {
		super(mapcolor);
		this.setReplaceable();
		this.setPushReactionBreak();
	}

	public boolean isLiquid() {
		return true;
	}

	public boolean isSolid() {
		return false;
	}

	public boolean isBuildable() {
		return false;
	}

}
