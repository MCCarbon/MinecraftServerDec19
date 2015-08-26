package net.minecraft.server;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class PotionRegistry {
	private static final class_ke b = new class_ke("water");
	public static final class_co a;
	private static int c;
	private final String d;
	private final ImmutableList e;

	public static int a(PotionRegistry var0) {
		return a.a(var0);
	}

	public static PotionRegistry a(String var0) {
		return (PotionRegistry) a.c(new class_ke(var0));
	}

	public PotionRegistry(class_qr... var1) {
		this((String) null, var1);
	}

	public PotionRegistry(String var1, class_qr... var2) {
		d = var1 == null ? null : "potion.effect." + var1;
		e = ImmutableList.copyOf((Object[]) var2);
	}

	public String a() {
		return d == null ? "potion.effect." + ((class_ke) a.b(this)).a() : d;
	}

	public List b() {
		return e;
	}

	public static void c() {
		a("water", new PotionRegistry(new class_qr[0]));
		a("mundane", new PotionRegistry(new class_qr[0]));
		a("thick", new PotionRegistry(new class_qr[0]));
		a("awkward", new PotionRegistry(new class_qr[0]));
		a("night_vision", new PotionRegistry(new class_qr[] { new class_qr(class_qs.p, 3600) }));
		a("long_night_vision", new PotionRegistry("night_vision", new class_qr[] { new class_qr(class_qs.p, 9600) }));
		a("invisibility", new PotionRegistry(new class_qr[] { new class_qr(class_qs.n, 3600) }));
		a("long_invisibility", new PotionRegistry("invisibility", new class_qr[] { new class_qr(class_qs.n, 9600) }));
		a("leaping", new PotionRegistry(new class_qr[] { new class_qr(class_qs.h, 3600) }));
		a("long_leaping", new PotionRegistry("leaping", new class_qr[] { new class_qr(class_qs.h, 9600) }));
		a("strong_leaping", new PotionRegistry("leaping", new class_qr[] { new class_qr(class_qs.h, 1800, 1) }));
		a("fire_resistance", new PotionRegistry(new class_qr[] { new class_qr(class_qs.l, 3600) }));
		a("long_fire_resistance", new PotionRegistry("fire_resistance", new class_qr[] { new class_qr(class_qs.l, 9600) }));
		a("swiftness", new PotionRegistry(new class_qr[] { new class_qr(class_qs.a, 3600) }));
		a("long_swiftness", new PotionRegistry("swiftness", new class_qr[] { new class_qr(class_qs.a, 9600) }));
		a("strong_swiftness", new PotionRegistry("swiftness", new class_qr[] { new class_qr(class_qs.a, 1800, 1) }));
		a("slowness", new PotionRegistry(new class_qr[] { new class_qr(class_qs.b, 1800) }));
		a("long_slowness", new PotionRegistry("slowness", new class_qr[] { new class_qr(class_qs.b, 4800) }));
		a("water_breathing", new PotionRegistry(new class_qr[] { new class_qr(class_qs.m, 3600) }));
		a("long_water_breathing", new PotionRegistry("water_breathing", new class_qr[] { new class_qr(class_qs.m, 9600) }));
		a("healing", new PotionRegistry(new class_qr[] { new class_qr(class_qs.f, 1) }));
		a("strong_healing", new PotionRegistry("healing", new class_qr[] { new class_qr(class_qs.f, 1, 1) }));
		a("harming", new PotionRegistry(new class_qr[] { new class_qr(class_qs.g, 1) }));
		a("strong_harming", new PotionRegistry("harming", new class_qr[] { new class_qr(class_qs.g, 1, 1) }));
		a("poison", new PotionRegistry(new class_qr[] { new class_qr(class_qs.s, 900) }));
		a("long_poison", new PotionRegistry("poison", new class_qr[] { new class_qr(class_qs.s, 1800) }));
		a("strong_poison", new PotionRegistry("poison", new class_qr[] { new class_qr(class_qs.s, 432, 1) }));
		a("regeneration", new PotionRegistry(new class_qr[] { new class_qr(class_qs.j, 900) }));
		a("long_regeneration", new PotionRegistry("regeneration", new class_qr[] { new class_qr(class_qs.j, 1800) }));
		a("strong_regeneration", new PotionRegistry("regeneration", new class_qr[] { new class_qr(class_qs.j, 450, 1) }));
		a("strength", new PotionRegistry(new class_qr[] { new class_qr(class_qs.e, 3600) }));
		a("long_strength", new PotionRegistry("strength", new class_qr[] { new class_qr(class_qs.e, 9600) }));
		a("strong_strength", new PotionRegistry("strength", new class_qr[] { new class_qr(class_qs.e, 1800, 1) }));
		a("weakness", new PotionRegistry(new class_qr[] { new class_qr(class_qs.r, 1800) }));
		a("long_weakness", new PotionRegistry("weakness", new class_qr[] { new class_qr(class_qs.r, 4800) }));
		a.a();
	}

	protected static void a(String var0, PotionRegistry var1) {
		a.a(c++, new class_ke(var0), var1);
	}

	static {
		a = new class_co(b);
	}
}
