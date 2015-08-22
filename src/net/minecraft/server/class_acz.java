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
		return var1 == Blocks.Z ? b.d() == 3 : ((var1 != Blocks.ah) && (var1 != Blocks.ag) ? ((var1 != Blocks.bP) && (var1 != Blocks.bT) ? ((var1 != Blocks.R) && (var1 != Blocks.o) ? ((var1 != Blocks.S) && (var1 != Blocks.p) ? ((var1 != Blocks.y) && (var1 != Blocks.x) ? ((var1 != Blocks.aC) && (var1 != Blocks.aD) ? (var1.v() == class_avq.e ? true : (var1.v() == class_avq.f ? true : var1.v() == class_avq.g)) : b.d() >= 2) : b.d() >= 1) : b.d() >= 1) : b
				.d() >= 2) : b.d() >= 2) : b.d() >= 2);
	}

	@Override
	public float a(class_aco var1, Block var2) {
		return (var2.v() != class_avq.f) && (var2.v() != class_avq.g) && (var2.v() != class_avq.e) ? super.a(var1, var2) : a;
	}

	static {
		c = Sets.newHashSet((Object[]) (new Block[] { Blocks.cs, Blocks.q, Blocks.e, Blocks.E, Blocks.ah, Blocks.ag, Blocks.T, Blocks.D, Blocks.R, Blocks.o, Blocks.aI, Blocks.S, Blocks.p, Blocks.y, Blocks.x, Blocks.aD, Blocks.Y, Blocks.aV, Blocks.cB, Blocks.av, Blocks.aC, Blocks.A, Blocks.cM, Blocks.b, Blocks.U }));
	}
}
