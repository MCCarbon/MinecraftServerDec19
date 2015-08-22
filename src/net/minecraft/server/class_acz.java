package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_acz extends class_abq {
	private static final Set c;

	protected class_acz(class_acm.class_a_in_class_acm var1) {
		super(1.0F, -2.5F, var1, c);
	}

	@Override
	public boolean b(class_ail var1) {
		return var1 == class_aim.Z ? b.d() == 3 : ((var1 != class_aim.ah) && (var1 != class_aim.ag) ? ((var1 != class_aim.bP) && (var1 != class_aim.bT) ? ((var1 != class_aim.R) && (var1 != class_aim.o) ? ((var1 != class_aim.S) && (var1 != class_aim.p) ? ((var1 != class_aim.y) && (var1 != class_aim.x) ? ((var1 != class_aim.aC) && (var1 != class_aim.aD) ? (var1.v() == class_avq.e ? true : (var1.v() == class_avq.f ? true : var1.v() == class_avq.g)) : b.d() >= 2) : b.d() >= 1) : b.d() >= 1) : b
				.d() >= 2) : b.d() >= 2) : b.d() >= 2);
	}

	@Override
	public float a(class_aco var1, class_ail var2) {
		return (var2.v() != class_avq.f) && (var2.v() != class_avq.g) && (var2.v() != class_avq.e) ? super.a(var1, var2) : a;
	}

	static {
		c = Sets.newHashSet((Object[]) (new class_ail[] { class_aim.cs, class_aim.q, class_aim.e, class_aim.E, class_aim.ah, class_aim.ag, class_aim.T, class_aim.D, class_aim.R, class_aim.o, class_aim.aI, class_aim.S, class_aim.p, class_aim.y, class_aim.x, class_aim.aD, class_aim.Y, class_aim.aV, class_aim.cB, class_aim.av, class_aim.aC, class_aim.A, class_aim.cM, class_aim.b, class_aim.U }));
	}
}
