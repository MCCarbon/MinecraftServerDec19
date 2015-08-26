package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_aay extends class_abq {
	private static final Set c;

	protected class_aay(Item.class_a_in_class_acm var1) {
		super(7.0F, -3.15F, var1, c);
	}

	@Override
	public float a(class_aco var1, Block var2) {
		return (var2.v() != class_avq.d) && (var2.v() != class_avq.k) && (var2.v() != class_avq.l) ? super.a(var1, var2) : a;
	}

	static {
		c = Sets.newHashSet((Object[]) (new Block[] { Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER }));
	}
}
