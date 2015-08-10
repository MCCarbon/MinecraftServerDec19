package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

public class MobEffectType {

	public static final RegistryMaterials<MinecraftKey, MobEffectType> REGISTRY = new RegistryMaterials<MinecraftKey, MobEffectType>();
	private final Map<class_qk, class_qm> attributemodifiers = Maps.newHashMap();
	private final int d;
	private String name = "";

	public static MobEffectType getById(int id) {
		return REGISTRY.get(id);
	}

	public static int getId(MobEffectType effect) {
		return REGISTRY.getId(effect);
	}

	public static MobEffectType getByName(String name) {
		return REGISTRY.get(new MinecraftKey(name));
	}

	protected MobEffectType(boolean var1, int var2) {
		this.d = var2;
	}

	public void tick(EntityLiving entity, int amplifier) {
		if (this == MobEffectList.REGENERATION) {
			if (entity.getHealth() < entity.getMaxHealth()) {
				entity.heal(1.0F);
			}
		} else if (this == MobEffectList.POISON) {
			if (entity.getHealth() > 1.0F) {
				entity.damageEntity(DamageSource.MAGIC, 1.0F);
			}
		} else if (this == MobEffectList.WITHER) {
			entity.damageEntity(DamageSource.WITHER, 1.0F);
		} else if (this == MobEffectList.HUNGER && entity instanceof EntityHuman) {
			((EntityHuman) entity).applyExhaustion(0.025F * (float) (amplifier + 1));
		} else if (this == MobEffectList.SATURATION && entity instanceof EntityHuman) {
			if (!entity.world.isClientSide) {
				((EntityHuman) entity).getFoodData().a(amplifier + 1, 1.0F);
			}
		} else if ((this != MobEffectList.HEAL || entity.bn()) && (this != MobEffectList.HARM || !entity.bn())) {
			if (this == MobEffectList.HARM && !entity.bn() || this == MobEffectList.HEAL && entity.bn()) {
				entity.damageEntity(DamageSource.MAGIC, (float) (6 << amplifier));
			}
		} else {
			entity.heal((float) Math.max(4 << amplifier, 0));
		}
	}

	public void a(Entity var1, Entity var2, EntityLiving var3, int var4, double var5) {
		int var7;
		if ((this != MobEffectList.HEAL || var3.bn()) && (this != MobEffectList.HARM || !var3.bn())) {
			if (this == MobEffectList.HARM && !var3.bn() || this == MobEffectList.HEAL && var3.bn()) {
				var7 = (int) (var5 * (double) (6 << var4) + 0.5D);
				if (var1 == null) {
					var3.damageEntity(DamageSource.MAGIC, (float) var7);
				} else {
					var3.damageEntity(DamageSource.b(var1, var2), (float) var7);
				}
			}
		} else {
			var7 = (int) (var5 * (double) (4 << var4) + 0.5D);
			var3.heal((float) var7);
		}

	}

	public boolean a(int var1, int var2) {
		int var3;
		if (this == MobEffectList.REGENERATION) {
			var3 = 50 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else if (this == MobEffectList.POISON) {
			var3 = 25 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else if (this == MobEffectList.WITHER) {
			var3 = 40 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else {
			return this == MobEffectList.HUNGER;
		}
	}

	public boolean b() {
		return false;
	}

	public MobEffectType setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public int g() {
		return this.d;
	}

	public MobEffectType a(class_qk var1, String var2, double var3, int var5) {
		class_qm var6 = new class_qm(UUID.fromString(var2), this.getName(), var3, var5);
		this.attributemodifiers.put(var1, var6);
		return this;
	}

	public void a(EntityLiving var1, class_qo var2, int var3) {
		Iterator<?> var4 = this.attributemodifiers.entrySet().iterator();

		while (var4.hasNext()) {
			Entry<?, ?> var5 = (Entry<?, ?>) var4.next();
			class_ql var6 = var2.a((class_qk) var5.getKey());
			if (var6 != null) {
				var6.c((class_qm) var5.getValue());
			}
		}

	}

	public void b(EntityLiving var1, class_qo var2, int var3) {
		Iterator<?> var4 = this.attributemodifiers.entrySet().iterator();

		while (var4.hasNext()) {
			Entry<?, ?> var5 = (Entry<?, ?>) var4.next();
			class_ql var6 = var2.a((class_qk) var5.getKey());
			if (var6 != null) {
				class_qm var7 = (class_qm) var5.getValue();
				var6.c(var7);
				var6.b(new class_qm(var7.a(), this.getName() + " " + var3, this.a(var3, var7), var7.c()));
			}
		}

	}

	public double a(int var1, class_qm var2) {
		return var2.d() * (double) (var1 + 1);
	}

	public static void init() {
		REGISTRY.register(1, new MinecraftKey("speed"), (new MobEffectType(false, 8171462)).setName("effect.moveSpeed").a(class_wl.d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2));
		REGISTRY.register(2, new MinecraftKey("slowness"), (new MobEffectType(true, 5926017)).setName("effect.moveSlowdown").a(class_wl.d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2));
		REGISTRY.register(3, new MinecraftKey("haste"), (new MobEffectType(false, 14270531)).setName("effect.digSpeed"));
		REGISTRY.register(4, new MinecraftKey("mining_fatigue"), (new MobEffectType(true, 4866583)).setName("effect.digSlowDown"));
		REGISTRY.register(5, new MinecraftKey("strength"), (new class_ph(false, 9643043, 1.3D)).setName("effect.damageBoost").a(class_wl.e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.5D, 2));
		REGISTRY.register(6, new MinecraftKey("instant_health"), (new class_pj(false, 16262179)).setName("effect.heal"));
		REGISTRY.register(7, new MinecraftKey("instant_damage"), (new class_pj(true, 4393481)).setName("effect.harm"));
		REGISTRY.register(8, new MinecraftKey("jump_boost"), (new MobEffectType(false, 2293580)).setName("effect.jump"));
		REGISTRY.register(9, new MinecraftKey("nausea"), (new MobEffectType(true, 5578058)).setName("effect.confusion"));
		REGISTRY.register(10, new MinecraftKey("regeneration"), (new MobEffectType(false, 13458603)).setName("effect.regeneration"));
		REGISTRY.register(11, new MinecraftKey("resistance"), (new MobEffectType(false, 10044730)).setName("effect.resistance"));
		REGISTRY.register(12, new MinecraftKey("fire_resistance"), (new MobEffectType(false, 14981690)).setName("effect.fireResistance"));
		REGISTRY.register(13, new MinecraftKey("water_breathing"), (new MobEffectType(false, 3035801)).setName("effect.waterBreathing"));
		REGISTRY.register(14, new MinecraftKey("invisibility"), (new MobEffectType(false, 8356754)).setName("effect.invisibility"));
		REGISTRY.register(15, new MinecraftKey("blindness"), (new MobEffectType(true, 2039587)).setName("effect.blindness"));
		REGISTRY.register(16, new MinecraftKey("night_vision"), (new MobEffectType(false, 2039713)).setName("effect.nightVision"));
		REGISTRY.register(17, new MinecraftKey("hunger"), (new MobEffectType(true, 5797459)).setName("effect.hunger"));
		REGISTRY.register(18, new MinecraftKey("weakness"), (new class_ph(true, 4738376, -0.5D)).setName("effect.weakness").a(class_wl.e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0D, 0));
		REGISTRY.register(19, new MinecraftKey("poison"), (new MobEffectType(true, 5149489)).setName("effect.poison"));
		REGISTRY.register(20, new MinecraftKey("wither"), (new MobEffectType(true, 3484199)).setName("effect.wither"));
		REGISTRY.register(21, new MinecraftKey("health_boost"), (new class_pi(false, 16284963)).setName("effect.healthBoost").a(class_wl.a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, 0));
		REGISTRY.register(22, new MinecraftKey("absorption"), (new class_pg(false, 2445989)).setName("effect.absorption"));
		REGISTRY.register(23, new MinecraftKey("saturation"), (new class_pj(false, 16262179)).setName("effect.saturation"));
		REGISTRY.register(24, new MinecraftKey("glowing"), (new MobEffectType(false, 9740385)).setName("effect.glowing"));
		REGISTRY.register(25, new MinecraftKey("levitation"), (new MobEffectType(true, 13565951)).setName("potion.levitation"));
	}

}
