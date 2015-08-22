package net.minecraft.server;


public enum class_afk {
	a,
	b,
	c,
	d,
	e,
	f,
	g,
	h,
	i,
	j,
	k;

	public boolean a(Item var1) {
		if (this == a) {
			return true;
		} else if ((this == j) && var1.m()) {
			return true;
		} else if (var1 instanceof class_aav) {
			if (this == b) {
				return true;
			} else {
				class_aav var2 = (class_aav) var1;
				return var2.b == class_rc.f ? this == f : (var2.b == class_rc.d ? this == d : (var2.b == class_rc.e ? this == e : (var2.b == class_rc.c ? this == c : false)));
			}
		} else {
			return var1 instanceof class_adv ? this == g : (var1 instanceof class_abq ? this == h : (var1 instanceof class_abg ? this == k : (var1 instanceof class_acg ? this == i : false)));
		}
	}
}
