package net.minecraft.server;

import java.util.Random;

public abstract class class_asa extends class_asp {
	public class_asa(boolean var1) {
		super(var1);
	}

	protected boolean a(class_ail var1) {
		class_avq var2 = var1.v();
		return (var2 == class_avq.a) || (var2 == class_avq.j) || (var1 == class_aim.c) || (var1 == class_aim.d) || (var1 == class_aim.r) || (var1 == class_aim.s) || (var1 == class_aim.g) || (var1 == class_aim.bn);
	}

	public void a(class_ago var1, Random var2, class_cj var3) {
	}

	protected void a(class_ago var1, class_cj var2) {
		if (var1.p(var2).c() != class_aim.d) {
			this.a(var1, var2, class_aim.d.S());
		}

	}
}
