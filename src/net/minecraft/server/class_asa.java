package net.minecraft.server;

import java.util.Random;

public abstract class class_asa extends class_asp {
	public class_asa(boolean var1) {
		super(var1);
	}

	protected boolean a(Block var1) {
		class_avq var2 = var1.v();
		return (var2 == class_avq.a) || (var2 == class_avq.j) || (var1 == Blocks.c) || (var1 == Blocks.d) || (var1 == Blocks.r) || (var1 == Blocks.s) || (var1 == Blocks.g) || (var1 == Blocks.bn);
	}

	public void a(class_ago var1, Random var2, class_cj var3) {
	}

	protected void a(class_ago var1, class_cj var2) {
		if (var1.p(var2).c() != Blocks.d) {
			this.a(var1, var2, Blocks.d.S());
		}

	}
}
