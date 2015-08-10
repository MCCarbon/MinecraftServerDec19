package net.minecraft.server;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class RegistryPotions {

	private static final MinecraftKey WATER_KEY = new MinecraftKey("water");
	public static final RegistryBlocks<MinecraftKey, RegistryPotions> REGISTRY = new RegistryBlocks<MinecraftKey, RegistryPotions>(WATER_KEY);

	private static int c;
	private final String d;
	private final ImmutableList<MobEffect> e;

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
		this.e = ImmutableList.copyOf(var2);
	}

	public String a() {
		return this.d == null ? "potion.effect." + ((MinecraftKey) REGISTRY.getKey(this)).getName() : this.d;
	}

	public List<MobEffect> b() {
		return this.e;
	}

	public static void c() {
		a("water", new RegistryPotions(new MobEffect[0]));
		a("mundane", new RegistryPotions(new MobEffect[0]));
		a("thick", new RegistryPotions(new MobEffect[0]));
		a("awkward", new RegistryPotions(new MobEffect[0]));
		a("night_vision", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.NIGHT_VISION, 3600) }));
		a("long_night_vision", new RegistryPotions("night_vision", new MobEffect[] { new MobEffect(MobEffectList.NIGHT_VISION, 9600) }));
		a("invisibility", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.INVISIBILITY, 3600) }));
		a("long_invisibility", new RegistryPotions("invisibility", new MobEffect[] { new MobEffect(MobEffectList.INVISIBILITY, 9600) }));
		a("leaping", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.JUMP, 3600) }));
		a("long_leaping", new RegistryPotions("leaping", new MobEffect[] { new MobEffect(MobEffectList.JUMP, 9600) }));
		a("strong_leaping", new RegistryPotions("leaping", new MobEffect[] { new MobEffect(MobEffectList.JUMP, 1800, 1) }));
		a("fire_resistance", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.FIRE_RESISTANCE, 3600) }));
		a("long_fire_refistance", new RegistryPotions("fire_resistance", new MobEffect[] { new MobEffect(MobEffectList.FIRE_RESISTANCE, 9600) }));
		a("swiftness", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.FASTER_MOVEMENT, 3600) }));
		a("long_swiftness", new RegistryPotions("swiftness", new MobEffect[] { new MobEffect(MobEffectList.FASTER_MOVEMENT, 9600) }));
		a("strong_swiftness", new RegistryPotions("swiftness", new MobEffect[] { new MobEffect(MobEffectList.FASTER_MOVEMENT, 1800, 1) }));
		a("slowness", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.SLOWER_MOVEMENT, 1800) }));
		a("long_slowness", new RegistryPotions("slowness", new MobEffect[] { new MobEffect(MobEffectList.SLOWER_MOVEMENT, 4800) }));
		a("water_breathing", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.WATER_BREATHING, 3600) }));
		a("long_water_breathing", new RegistryPotions("water_breathing", new MobEffect[] { new MobEffect(MobEffectList.WATER_BREATHING, 9600) }));
		a("healing", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.HEAL, 1) }));
		a("strong_healing", new RegistryPotions("healing", new MobEffect[] { new MobEffect(MobEffectList.HEAL, 1, 1) }));
		a("harming", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.HARM, 1) }));
		a("strong_harming", new RegistryPotions("harming", new MobEffect[] { new MobEffect(MobEffectList.HARM, 1, 1) }));
		a("poison", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.POISON, 900) }));
		a("long_poison", new RegistryPotions("poison", new MobEffect[] { new MobEffect(MobEffectList.POISON, 2400) }));
		a("strong_poison", new RegistryPotions("poison", new MobEffect[] { new MobEffect(MobEffectList.POISON, 450, 1) }));
		a("regeneration", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.REGENERATION, 900) }));
		a("long_regeneration", new RegistryPotions("regeneration", new MobEffect[] { new MobEffect(MobEffectList.REGENERATION, 2400) }));
		a("strong_regeneration", new RegistryPotions("regeneration", new MobEffect[] { new MobEffect(MobEffectList.REGENERATION, 450, 1) }));
		a("strength", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.INCREASE_DAMAGE, 3600) }));
		a("long_strength", new RegistryPotions("strength", new MobEffect[] { new MobEffect(MobEffectList.INCREASE_DAMAGE, 9600) }));
		a("strong_strength", new RegistryPotions("strength", new MobEffect[] { new MobEffect(MobEffectList.INCREASE_DAMAGE, 1800, 1) }));
		a("weakness", new RegistryPotions(new MobEffect[] { new MobEffect(MobEffectList.WEAKNESS, 1800) }));
		a("long_weakness", new RegistryPotions("weakness", new MobEffect[] { new MobEffect(MobEffectList.WEAKNESS, 4800) }));
	}

	protected static void a(String var0, RegistryPotions var1) {
		REGISTRY.register(c++, new MinecraftKey(var0), var1);
	}

}
