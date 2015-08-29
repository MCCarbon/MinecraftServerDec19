package net.minecraft.server;

import java.util.Random;

public abstract class class_asa extends class_asp {
	public class_asa(boolean var1) {
		super(var1);
	}

	protected boolean a(Block var1) {
		class_avq var2 = var1.v();
		return (var2 == class_avq.a) || (var2 == class_avq.j) || (var1 == Blocks.GRASS) || (var1 == Blocks.DIRT) || (var1 == Blocks.LOG) || (var1 == Blocks.LOG2) || (var1 == Blocks.SAPLING) || (var1 == Blocks.VINE);
	}

	public void a(class_ago var1, Random var2, class_cj var3) {
	}

	protected void a(class_ago var1, class_cj var2) {
		if (var1.p(var2).c() != Blocks.DIRT) {
			this.a(var1, var2, Blocks.DIRT.getBlockData());
		}

	}
}
