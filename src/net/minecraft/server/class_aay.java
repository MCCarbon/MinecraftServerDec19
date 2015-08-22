package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_aay extends class_abq {
	private static final Set c;

	protected class_aay(class_acm.class_a_in_class_acm var1) {
		super(7.0F, -3.15F, var1, c);
	}

	@Override
	public float a(class_aco var1, class_ail var2) {
		return (var2.v() != class_avq.d) && (var2.v() != class_avq.k) && (var2.v() != class_avq.l) ? super.a(var1, var2) : a;
	}

	static {
		c = Sets.newHashSet((Object[]) (new class_ail[] { class_aim.f, class_aim.X, class_aim.r, class_aim.s, class_aim.ae, class_aim.aU, class_aim.aZ, class_aim.bk, class_aim.au }));
	}
}
