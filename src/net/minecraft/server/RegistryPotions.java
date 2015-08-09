package net.minecraft.server;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class RegistryPotions {

	private static final MinecraftKey WATER_KEY = new MinecraftKey("water");
	public static final RegistryBlocks<MinecraftKey, RegistryPotions> REGISTRY = new RegistryBlocks<MinecraftKey, RegistryPotions>(WATER_KEY);

	private static int c;
	private final String d;
	private final ImmutableList<Object> e;

	public static int a(RegistryPotions var0) {
		return REGISTRY.getId(var0);
	}

	public static RegistryPotions a(String var0) {
		return REGISTRY.get(new MinecraftKey(var0));
	}

	public RegistryPotions(MobEffect... var1) {
		this((String) null, var1);
	}

	public RegistryPotions(String var1, MobEffect... var2) {
		this.d = var1 == null ? null : "potion.effect." + var1;
		this.e = ImmutableList.copyOf((Object[]) var2);
	}

	public String a() {
		return this.d == null ? "potion.effect." + ((MinecraftKey) REGISTRY.getKey(this)).getName() : this.d;
	}

	public List<Object> b() {
		return this.e;
	}

	public static void c() {
		a("water", new RegistryPotions(new MobEffect[0]));
		a("mundane", new RegistryPotions(new MobEffect[0]));
		a("thick", new RegistryPotions(new MobEffect[0]));
		a("awkward", new RegistryPotions(new MobEffect[0]));
		a("night_vision", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.p, 3600) }));
		a("long_night_vision", new RegistryPotions("night_vision", new MobEffect[] { new MobEffect(MobEffectList.p, 9600) }));
		a("invisibility", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.n, 3600) }));
		a("long_invisibility", new RegistryPotions("invisibility", new MobEffect[] { new MobEffect(MobEffectList.n, 9600) }));
		a("leaping", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.h, 3600) }));
		a("long_leaping", new RegistryPotions("leaping", new MobEffect[] { new MobEffect(MobEffectList.h, 9600) }));
		a("strong_leaping", new RegistryPotions("leaping", new MobEffect[] { new MobEffect(MobEffectList.h, 1800, 1) }));
		a("fire_resistance", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.l, 3600) }));
		a("long_fire_refistance", new RegistryPotions("fire_resistance", new MobEffect[] { new MobEffect(MobEffectList.l, 9600) }));
		a("swiftness", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.a, 3600) }));
		a("long_swiftness", new RegistryPotions("swiftness", new MobEffect[] { new MobEffect(MobEffectList.a, 9600) }));
		a("strong_swiftness", new RegistryPotions("swiftness", new MobEffect[] { new MobEffect(MobEffectList.a, 1800, 1) }));
		a("slowness", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.b, 1800) }));
		a("long_slowness", new RegistryPotions("slowness", new MobEffect[] { new MobEffect(MobEffectList.b, 4800) }));
		a("water_breathing", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.m, 3600) }));
		a("long_water_breathing", new RegistryPotions("water_breathing", new MobEffect[] { new MobEffect(MobEffectList.m, 9600) }));
		a("healing", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.f, 1) }));
		a("strong_healing", new RegistryPotions("healing", new MobEffect[] { new MobEffect(MobEffectList.f, 1, 1) }));
		a("harming", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.g, 1) }));
		a("strong_harming", new RegistryPotions("harming", new MobEffect[] { new MobEffect(MobEffectList.g, 1, 1) }));
		a("poison", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.s, 900) }));
		a("long_poison", new RegistryPotions("poison", new MobEffect[] { new MobEffect(MobEffectList.s, 2400) }));
		a("strong_poison", new RegistryPotions("poison", new MobEffect[] { new MobEffect(MobEffectList.s, 450, 1) }));
		a("regeneration", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.j, 900) }));
		a("long_regeneration", new RegistryPotions("regeneration", new MobEffect[] { new MobEffect(MobEffectList.j, 2400) }));
		a("strong_regeneration", new RegistryPotions("regeneration", new MobEffect[] { new MobEffect(MobEffectList.j, 450, 1) }));
		a("strength", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.e, 3600) }));
		a("long_strength", new RegistryPotions("strength", new MobEffect[] { new MobEffect(MobEffectList.e, 9600) }));
		a("strong_strength", new RegistryPotions("strength", new MobEffect[] { new MobEffect(MobEffectList.e, 1800, 1) }));
		a("weakness", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.r, 1800) }));
		a("long_weakness", new RegistryPotions("weakness", new MobEffect[] { new MobEffect(MobEffectList.r, 4800) }));
	}

	protected static void a(String var0, RegistryPotions var1) {
		REGISTRY.register(c++, new MinecraftKey(var0), var1);
	}

}
