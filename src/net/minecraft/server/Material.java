package net.minecraft.server;

import net.minecraft.server.MaterialDecoration;
import net.minecraft.server.MaterialGas;
import net.minecraft.server.MaterialLiquid;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_atm;

public class Material {

	public static final Material AIR = new MaterialGas(MaterialMapColor.COLOR1);
	public static final Material GRASS = new Material(MaterialMapColor.COLOR2);
	public static final Material EARTH = new Material(MaterialMapColor.COLOR11);
	public static final Material WOOD = (new Material(MaterialMapColor.COLOR14)).setCanBurn();
	public static final Material STONE = (new Material(MaterialMapColor.COLOR12)).setAlwaysDestoyable();
	public static final Material ORE = (new Material(MaterialMapColor.COLOR7)).setAlwaysDestoyable();
	public static final Material HEAVY = (new Material(MaterialMapColor.COLOR7)).setAlwaysDestoyable().setPushReactionNone();
	public static final Material WATER = (new MaterialLiquid(MaterialMapColor.COLOR13)).setPushReactionBreak();
	public static final Material LAVA = (new MaterialLiquid(MaterialMapColor.COLOR5)).setPushReactionBreak();
	public static final Material LEAVES = (new Material(MaterialMapColor.COLOR8)).setCanBurn().setTransparent().setPushReactionBreak();
	public static final Material PLANT = (new MaterialDecoration(MaterialMapColor.COLOR8)).setPushReactionBreak();
	public static final Material REPLACEABLE_PLANT = (new MaterialDecoration(MaterialMapColor.COLOR8)).setCanBurn().setPushReactionBreak().setReplaceable();
	public static final Material SPONGE = new Material(MaterialMapColor.COLOR19);
	public static final Material CLOTH = (new Material(MaterialMapColor.COLOR4)).setCanBurn();
	public static final Material FIRE = (new MaterialGas(MaterialMapColor.COLOR1)).setPushReactionBreak();
	public static final Material SAND = new Material(MaterialMapColor.COLOR3);
	public static final Material ORIENTABLE = (new MaterialDecoration(MaterialMapColor.COLOR1)).setPushReactionBreak();
	public static final Material WOOL = (new MaterialDecoration(MaterialMapColor.COLOR4)).setCanBurn();
	public static final Material SHATTERABLE = (new Material(MaterialMapColor.COLOR1)).setTransparent().setUnusedValue();
	public static final Material BUILDABLE_GLASS = (new Material(MaterialMapColor.COLOR1)).setUnusedValue();
	public static final Material TNT = (new Material(MaterialMapColor.COLOR5)).setCanBurn().setTransparent();
	public static final Material CORAL = (new Material(MaterialMapColor.COLOR8)).setPushReactionBreak();
	public static final Material ICE = (new Material(MaterialMapColor.COLOR6)).setTransparent().setUnusedValue();
	public static final Material SNOW_LAYER = (new Material(MaterialMapColor.COLOR6)).setUnusedValue();
	public static final Material PACKED_ICE = (new MaterialDecoration(MaterialMapColor.COLOR9)).setReplaceable().setTransparent().setAlwaysDestoyable().setPushReactionBreak();
	public static final Material SNOW_BLOCK = (new Material(MaterialMapColor.COLOR9)).setAlwaysDestoyable();
	public static final Material CACTUS = (new Material(MaterialMapColor.COLOR8)).setTransparent().setPushReactionBreak();
	public static final Material CLAY = new Material(MaterialMapColor.COLOR10);
	public static final Material PUMPKIN = (new Material(MaterialMapColor.COLOR8)).setPushReactionBreak();
	public static final Material DRAGON_EGG = (new Material(MaterialMapColor.COLOR8)).setPushReactionBreak();
	public static final Material PORTAL = (new class_atm(MaterialMapColor.COLOR1)).setPushReactionNone();
	public static final Material CAKE = (new Material(MaterialMapColor.COLOR1)).setPushReactionBreak();
	public static final Material WEB = (new Material(MaterialMapColor.COLOR4) {
		public boolean isSolid() {
			return false;
		}
	}).setAlwaysDestoyable().setPushReactionBreak();
	public static final Material PISTON = (new Material(MaterialMapColor.COLOR12)).setPushReactionNone();
	public static final Material BANNER = (new Material(MaterialMapColor.COLOR1)).setAlwaysDestoyable().setPushReactionNone();

	private boolean canBurn;
	private boolean isReplacable;
	private boolean isTransparent;
	private final MaterialMapColor mapcolor;
	private boolean alwaysDestroyable = true;
	private int pushReaction;

	public Material(MaterialMapColor mapcolor) {
		this.mapcolor = mapcolor;
	}

	public boolean isLiquid() {
		return false;
	}

	public boolean isBuildable() {
		return true;
	}

	public boolean blocksLight() {
		return true;
	}

	public boolean isSolid() {
		return true;
	}

	private Material setTransparent() {
		this.isTransparent = true;
		return this;
	}

	protected Material setAlwaysDestoyable() {
		this.alwaysDestroyable = false;
		return this;
	}

	protected Material setCanBurn() {
		this.canBurn = true;
		return this;
	}

	public boolean canBurn() {
		return this.canBurn;
	}

	public Material setReplaceable() {
		this.isReplacable = true;
		return this;
	}

	public boolean isReplaceable() {
		return this.isReplacable;
	}

	public boolean isOpaque() {
		return this.isTransparent ? false : this.isSolid();
	}

	public boolean isAlwaysDestroyable() {
		return this.alwaysDestroyable;
	}

	public int getPushReaction() {
		return this.pushReaction;
	}

	protected Material setPushReactionBreak() {
		this.pushReaction = 1;
		return this;
	}

	protected Material setPushReactionNone() {
		this.pushReaction = 2;
		return this;
	}

	protected Material setUnusedValue() {
		return this;
	}

	public MaterialMapColor getMapColor() {
		return this.mapcolor;
	}

}
