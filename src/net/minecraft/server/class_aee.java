package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_aee {
	private static final Set J;
	public static final PotionRegistry a;
	public static final PotionRegistry b;
	public static final PotionRegistry c;
	public static final PotionRegistry d;
	public static final PotionRegistry e;
	public static final PotionRegistry f;
	public static final PotionRegistry g;
	public static final PotionRegistry h;
	public static final PotionRegistry i;
	public static final PotionRegistry j;
	public static final PotionRegistry k;
	public static final PotionRegistry l;
	public static final PotionRegistry m;
	public static final PotionRegistry n;
	public static final PotionRegistry o;
	public static final PotionRegistry p;
	public static final PotionRegistry q;
	public static final PotionRegistry r;
	public static final PotionRegistry s;
	public static final PotionRegistry t;
	public static final PotionRegistry u;
	public static final PotionRegistry v;
	public static final PotionRegistry w;
	public static final PotionRegistry x;
	public static final PotionRegistry y;
	public static final PotionRegistry z;
	public static final PotionRegistry A;
	public static final PotionRegistry B;
	public static final PotionRegistry C;
	public static final PotionRegistry D;
	public static final PotionRegistry E;
	public static final PotionRegistry F;
	public static final PotionRegistry G;
	public static final PotionRegistry H;
	public static final PotionRegistry I;

	private static PotionRegistry a(String var0) {
		PotionRegistry var1 = (PotionRegistry) PotionRegistry.a.c(new class_ke(var0));
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
