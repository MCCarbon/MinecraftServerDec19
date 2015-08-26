package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_aee {
	private static final Set J;
	public static final class_aec a;
	public static final class_aec b;
	public static final class_aec c;
	public static final class_aec d;
	public static final class_aec e;
	public static final class_aec f;
	public static final class_aec g;
	public static final class_aec h;
	public static final class_aec i;
	public static final class_aec j;
	public static final class_aec k;
	public static final class_aec l;
	public static final class_aec m;
	public static final class_aec n;
	public static final class_aec o;
	public static final class_aec p;
	public static final class_aec q;
	public static final class_aec r;
	public static final class_aec s;
	public static final class_aec t;
	public static final class_aec u;
	public static final class_aec v;
	public static final class_aec w;
	public static final class_aec x;
	public static final class_aec y;
	public static final class_aec z;
	public static final class_aec A;
	public static final class_aec B;
	public static final class_aec C;
	public static final class_aec D;
	public static final class_aec E;
	public static final class_aec F;
	public static final class_aec G;
	public static final class_aec H;
	public static final class_aec I;

	private static class_aec a(String var0) {
		class_aec var1 = (class_aec) class_aec.a.c(new class_ke(var0));
		if (!J.add(var1)) {
			throw new IllegalStateException("Invalid Potion requested: " + var0);
		} else {
			return var1;
		}
	}

	static {
		if (!Bootstrap.isInitDone()) {
			throw new RuntimeException("Accessed Potions before Bootstrap!");
		} else {
			J = Sets.newHashSet();
			a = a("water");
			b = a("mundane");
			c = a("thick");
			d = a("awkward");
			e = a("night_vision");
			f = a("long_night_vision");
			g = a("invisibility");
			h = a("long_invisibility");
			i = a("leaping");
			j = a("long_leaping");
			k = a("strong_leaping");
			l = a("fire_resistance");
			m = a("long_fire_resistance");
			n = a("swiftness");
			o = a("long_swiftness");
			p = a("strong_swiftness");
			q = a("slowness");
			r = a("long_slowness");
			s = a("water_breathing");
			t = a("long_water_breathing");
			u = a("healing");
			v = a("strong_healing");
			w = a("harming");
			x = a("strong_harming");
			y = a("poison");
			z = a("long_poison");
			A = a("strong_poison");
			B = a("regeneration");
			C = a("long_regeneration");
			D = a("strong_regeneration");
			E = a("strength");
			F = a("long_strength");
			G = a("strong_strength");
			H = a("weakness");
			I = a("long_weakness");
			J.clear();
		}
	}
}
