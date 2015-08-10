package net.minecraft.server;

public class MobEffectList {

	public static final MobEffectType FASTER_MOVEMENT;
	public static final MobEffectType SLOWER_MOVEMENT;
	public static final MobEffectType FASTER_DIG;
	public static final MobEffectType SLOWER_DIG;
	public static final MobEffectType INCREASE_DAMAGE;
	public static final MobEffectType HEAL;
	public static final MobEffectType HARM;
	public static final MobEffectType JUMP;
	public static final MobEffectType CONFUSION;
	public static final MobEffectType REGENERATION;
	public static final MobEffectType RESISTANCE;
	public static final MobEffectType FIRE_RESISTANCE;
	public static final MobEffectType WATER_BREATHING;
	public static final MobEffectType INVISIBILITY;
	public static final MobEffectType BLINDNESS;
	public static final MobEffectType NIGHT_VISION;
	public static final MobEffectType HUNGER;
	public static final MobEffectType WEAKNESS;
	public static final MobEffectType POISON;
	public static final MobEffectType WITHER;
	public static final MobEffectType HEALTH_BOOST;
	public static final MobEffectType ABSORBTION;
	public static final MobEffectType SATURATION;
	public static final MobEffectType GLOWING;
	public static final MobEffectType LEVITATION;

	private static MobEffectType getByName(String name) {
		MobEffectType type = MobEffectType.REGISTRY.get(new MinecraftKey(name));
		if (type == null) {
			throw new IllegalStateException("Invalid MobEffect requested: " + name);
		} else {
			return type;
		}
	}

	static {
		if (!Bootstrap.isInitDone()) {
			throw new RuntimeException("Accessed MobEffects before Bootstrap!");
		} else {
			FASTER_MOVEMENT = getByName("speed");
			SLOWER_MOVEMENT = getByName("slowness");
			FASTER_DIG = getByName("haste");
			SLOWER_DIG = getByName("mining_fatigue");
			INCREASE_DAMAGE = getByName("strength");
			HEAL = getByName("instant_health");
			HARM = getByName("instant_damage");
			JUMP = getByName("jump_boost");
			CONFUSION = getByName("nausea");
			REGENERATION = getByName("regeneration");
			RESISTANCE = getByName("resistance");
			FIRE_RESISTANCE = getByName("fire_resistance");
			WATER_BREATHING = getByName("water_breathing");
			INVISIBILITY = getByName("invisibility");
			BLINDNESS = getByName("blindness");
			NIGHT_VISION = getByName("night_vision");
			HUNGER = getByName("hunger");
			WEAKNESS = getByName("weakness");
			POISON = getByName("poison");
			WITHER = getByName("wither");
			HEALTH_BOOST = getByName("health_boost");
			ABSORBTION = getByName("absorption");
			SATURATION = getByName("saturation");
			GLOWING = getByName("glowing");
			LEVITATION = getByName("levitation");
		}
	}

}
