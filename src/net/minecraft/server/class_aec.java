package net.minecraft.server;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class class_aec {
	private static final class_ke b = new class_ke("water");
	public static final class_co a;
	private static int c;
	private final String d;
	private final ImmutableList e;

	public static int a(class_aec var0) {
		return a.a(var0);
	}

	public static class_aec a(String var0) {
		return (class_aec) a.c(new class_ke(var0));
	}

	public class_aec(class_qr... var1) {
		this((String) null, var1);
	}

	public class_aec(String var1, class_qr... var2) {
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
		a("water", new class_aec(new class_qr[0]));
		a("mundane", new class_aec(new class_qr[0]));
		a("thick", new class_aec(new class_qr[0]));
		a("awkward", new class_aec(new class_qr[0]));
		a("night_vision", new class_aec(new class_qr[] { new class_qr(class_qs.p, 3600) }));
		a("long_night_vision", new class_aec("night_vision", new class_qr[] { new class_qr(class_qs.p, 9600) }));
		a("invisibility", new class_aec(new class_qr[] { new class_qr(class_qs.n, 3600) }));
		a("long_invisibility", new class_aec("invisibility", new class_qr[] { new class_qr(class_qs.n, 9600) }));
		a("leaping", new class_aec(new class_qr[] { new class_qr(class_qs.h, 3600) }));
		a("long_leaping", new class_aec("leaping", new class_qr[] { new class_qr(class_qs.h, 9600) }));
		a("strong_leaping", new class_aec("leaping", new class_qr[] { new class_qr(class_qs.h, 1800, 1) }));
		a("fire_resistance", new class_aec(new class_qr[] { new class_qr(class_qs.l, 3600) }));
		a("long_fire_resistance", new class_aec("fire_resistance", new class_qr[] { new class_qr(class_qs.l, 9600) }));
		a("swiftness", new class_aec(new class_qr[] { new class_qr(class_qs.a, 3600) }));
		a("long_swiftness", new class_aec("swiftness", new class_qr[] { new class_qr(class_qs.a, 9600) }));
		a("strong_swiftness", new class_aec("swiftness", new class_qr[] { new class_qr(class_qs.a, 1800, 1) }));
		a("slowness", new class_aec(new class_qr[] { new class_qr(class_qs.b, 1800) }));
		a("long_slowness", new class_aec("slowness", new class_qr[] { new class_qr(class_qs.b, 4800) }));
		a("water_breathing", new class_aec(new class_qr[] { new class_qr(class_qs.m, 3600) }));
		a("long_water_breathing", new class_aec("water_breathing", new class_qr[] { new class_qr(class_qs.m, 9600) }));
		a("healing", new class_aec(new class_qr[] { new class_qr(class_qs.f, 1) }));
		a("strong_healing", new class_aec("healing", new class_qr[] { new class_qr(class_qs.f, 1, 1) }));
		a("harming", new class_aec(new class_qr[] { new class_qr(class_qs.g, 1) }));
		a("strong_harming", new class_aec("harming", new class_qr[] { new class_qr(class_qs.g, 1, 1) }));
		a("poison", new class_aec(new class_qr[] { new class_qr(class_qs.s, 900) }));
		a("long_poison", new class_aec("poison", new class_qr[] { new class_qr(class_qs.s, 1800) }));
		a("strong_poison", new class_aec("poison", new class_qr[] { new class_qr(class_qs.s, 432, 1) }));
		a("regeneration", new class_aec(new class_qr[] { new class_qr(class_qs.j, 900) }));
		a("long_regeneration", new class_aec("regeneration", new class_qr[] { new class_qr(class_qs.j, 1800) }));
		a("strong_regeneration", new class_aec("regeneration", new class_qr[] { new class_qr(class_qs.j, 450, 1) }));
		a("strength", new class_aec(new class_qr[] { new class_qr(class_qs.e, 3600) }));
		a("long_strength", new class_aec("strength", new class_qr[] { new class_qr(class_qs.e, 9600) }));
		a("strong_strength", new class_aec("strength", new class_qr[] { new class_qr(class_qs.e, 1800, 1) }));
		a("weakness", new class_aec(new class_qr[] { new class_qr(class_qs.r, 1800) }));
		a("long_weakness", new class_aec("weakness", new class_qr[] { new class_qr(class_qs.r, 4800) }));
		a.a();
	}

	protected static void a(String var0, class_aec var1) {
		a.a(c++, new class_ke(var0), var1);
	}

	static {
		a = new class_co(b);
	}
}
