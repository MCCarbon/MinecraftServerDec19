package net.minecraft.server;


public class class_qs {
	public static final class_qq a;
	public static final class_qq b;
	public static final class_qq c;
	public static final class_qq d;
	public static final class_qq e;
	public static final class_qq f;
	public static final class_qq g;
	public static final class_qq h;
	public static final class_qq i;
	public static final class_qq j;
	public static final class_qq k;
	public static final class_qq l;
	public static final class_qq m;
	public static final class_qq n;
	public static final class_qq o;
	public static final class_qq p;
	public static final class_qq q;
	public static final class_qq r;
	public static final class_qq s;
	public static final class_qq t;
	public static final class_qq u;
	public static final class_qq v;
	public static final class_qq w;
	public static final class_qq x;
	public static final class_qq y;

	private static class_qq a(String var0) {
		class_qq var1 = (class_qq) class_qq.b.c(new class_ke(var0));
		if (var1 == null) {
			throw new IllegalStateException("Invalid MobEffect requested: " + var0);
		} else {
			return var1;
		}
	}

	static {
		if (!class_kh.a()) {
			throw new RuntimeException("Accessed MobEffects before Bootstrap!");
		} else {
			a = a("speed");
			b = a("slowness");
			c = a("haste");
			d = a("mining_fatigue");
			e = a("strength");
			f = a("instant_health");
			g = a("instant_damage");
			h = a("jump_boost");
			i = a("nausea");
			j = a("regeneration");
			k = a("resistance");
			l = a("fire_resistance");
			m = a("water_breathing");
			n = a("invisibility");
			o = a("blindness");
			p = a("night_vision");
			q = a("hunger");
			r = a("weakness");
			s = a("poison");
			t = a("wither");
			u = a("health_boost");
			v = a("absorption");
			w = a("saturation");
			x = a("glowing");
			y = a("levitation");
		}
	}
}
