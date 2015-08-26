package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_acz extends class_abq {
	private static final Set c;

	protected class_acz(Item.class_a_in_class_acm var1) {
		super(1.0F, -2.5F, var1, c);
	}

	@Override
	public boolean b(Block var1) {
		return var1 == Blocks.OBSIDIAN ? b.d() == 3 : ((var1 != Blocks.DIAMOND_BLOCK) && (var1 != Blocks.DIAMOND_ORE) ? ((var1 != Blocks.EMERALD_ORE) && (var1 != Blocks.EMERALD_BLOCK) ? ((var1 != Blocks.GOLD_BLOCK) && (var1 != Blocks.GOLD_ORE) ? ((var1 != Blocks.IRON_BLOCK) && (var1 != Blocks.IRON_ORE) ? ((var1 != Blocks.LAPIS_BLOCK) && (var1 != Blocks.LAPIS_ORE) ? ((var1 != Blocks.REDSTONE_ORE) && (var1 != Blocks.LIT_REDSTONE_TORCH) ? (var1.v() == class_avq.e ? true : (var1.v() == class_avq.f ? true : var1.v() == class_avq.g)) : b.d() >= 2) : b.d() >= 1) : b.d() >= 1) : b
				.d() >= 2) : b.d() >= 2) : b.d() >= 2);
	}

	@Override
	public float a(class_aco var1, Block var2) {
		return (var2.v() != class_avq.f) && (var2.v() != class_avq.g) && (var2.v() != class_avq.e) ? super.a(var1, var2) : a;
	}

	static {
		c = Sets.newHashSet((Object[]) (new Block[] { Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_SANDSTONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_TORCH, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB }));
	}
}
