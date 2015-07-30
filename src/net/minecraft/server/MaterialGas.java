package net.minecraft.server;

import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;

public class MaterialGas extends Material {

	public MaterialGas(MaterialMapColor material) {
		super(material);
		this.setReplaceable();
	}

	public boolean isBuildable() {
		return false;
	}

	public boolean blocksLight() {
		return false;
	}

	public boolean isSolid() {
		return false;
	}

}
