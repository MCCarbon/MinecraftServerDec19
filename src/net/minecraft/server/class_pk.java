package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import net.minecraft.server.RegistryMaterials;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pg;
import net.minecraft.server.class_ph;
import net.minecraft.server.class_pi;
import net.minecraft.server.class_pj;
import net.minecraft.server.class_pm;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_qo;
import net.minecraft.server.class_wl;
import net.minecraft.server.EntityHuman;

public class class_pk {

	public static final RegistryMaterials<MinecraftKey, class_pk> b = new RegistryMaterials<MinecraftKey, class_pk>();
	private final Map<class_qk, class_qm> a = Maps.newHashMap();
	private final boolean c;
	private final int d;
	private String e = "";
	private int f = -1;
	private double g;
	private boolean h;

	public static class_pk a(int var0) {
		return (class_pk) b.get(var0);
	}

	public static int a(class_pk var0) {
		return b.getId(var0);
	}

	public static class_pk b(String var0) {
		return (class_pk) b.get(new MinecraftKey(var0));
	}

	protected class_pk(boolean var1, int var2) {
		this.c = var1;
		if (var1) {
			this.g = 0.5D;
		} else {
			this.g = 1.0D;
		}

		this.d = var2;
	}

	protected class_pk b(int var1, int var2) {
		this.f = var1 + var2 * 8;
		return this;
	}

	public void a(EntityLiving var1, int var2) {
		if (this == class_pm.j) {
			if (var1.getHealth() < var1.bv()) {
				var1.h(1.0F);
			}
		} else if (this == class_pm.s) {
			if (var1.getHealth() > 1.0F) {
				var1.damageEntity(class_pc.l, 1.0F);
			}
		} else if (this == class_pm.t) {
			var1.damageEntity(class_pc.m, 1.0F);
		} else if (this == class_pm.q && var1 instanceof EntityHuman) {
			((EntityHuman) var1).a(0.025F * (float) (var2 + 1));
		} else if (this == class_pm.w && var1 instanceof EntityHuman) {
			if (!var1.o.isClientSide) {
				((EntityHuman) var1).cn().a(var2 + 1, 1.0F);
			}
		} else if ((this != class_pm.f || var1.bn()) && (this != class_pm.g || !var1.bn())) {
			if (this == class_pm.g && !var1.bn() || this == class_pm.f && var1.bn()) {
				var1.damageEntity(class_pc.l, (float) (6 << var2));
			}
		} else {
			var1.h((float) Math.max(4 << var2, 0));
		}

	}

	public void a(Entity var1, Entity var2, EntityLiving var3, int var4, double var5) {
		int var7;
		if ((this != class_pm.f || var3.bn()) && (this != class_pm.g || !var3.bn())) {
			if (this == class_pm.g && !var3.bn() || this == class_pm.f && var3.bn()) {
				var7 = (int) (var5 * (double) (6 << var4) + 0.5D);
				if (var1 == null) {
					var3.damageEntity(class_pc.l, (float) var7);
				} else {
					var3.damageEntity(class_pc.b(var1, var2), (float) var7);
				}
			}
		} else {
			var7 = (int) (var5 * (double) (4 << var4) + 0.5D);
			var3.h((float) var7);
		}

	}

	public boolean a(int var1, int var2) {
		int var3;
		if (this == class_pm.j) {
			var3 = 50 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else if (this == class_pm.s) {
			var3 = 25 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else if (this == class_pm.t) {
			var3 = 40 >> var2;
			return var3 > 0 ? var1 % var3 == 0 : true;
		} else {
			return this == class_pm.q;
		}
	}

	public boolean b() {
		return false;
	}

	public class_pk c(String var1) {
		this.e = var1;
		return this;
	}

	public String a() {
		return this.e;
	}

	protected class_pk a(double var1) {
		this.g = var1;
		return this;
	}

	public int g() {
		return this.d;
	}

	public class_pk a(class_qk var1, String var2, double var3, int var5) {
		class_qm var6 = new class_qm(UUID.fromString(var2), this.a(), var3, var5);
		this.a.put(var1, var6);
		return this;
	}

	public void a(EntityLiving var1, class_qo var2, int var3) {
		Iterator<?> var4 = this.a.entrySet().iterator();

		while (var4.hasNext()) {
			Entry<?, ?> var5 = (Entry<?, ?>) var4.next();
			class_ql var6 = var2.a((class_qk) var5.getKey());
			if (var6 != null) {
				var6.c((class_qm) var5.getValue());
			}
		}

	}

	public void b(EntityLiving var1, class_qo var2, int var3) {
		Iterator<?> var4 = this.a.entrySet().iterator();

		while (var4.hasNext()) {
			Entry<?, ?> var5 = (Entry<?, ?>) var4.next();
			class_ql var6 = var2.a((class_qk) var5.getKey());
			if (var6 != null) {
				class_qm var7 = (class_qm) var5.getValue();
				var6.c(var7);
				var6.b(new class_qm(var7.a(), this.a() + " " + var3, this.a(var3, var7), var7.c()));
			}
		}

	}

	public double a(int var1, class_qm var2) {
		return var2.d() * (double) (var1 + 1);
	}

	public class_pk j() {
		this.h = true;
		return this;
	}

	public static void k() {
		b.register(1, new MinecraftKey("speed"), (new class_pk(false, 8171462)).c("effect.moveSpeed").b(0, 0).a(class_wl.d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2).j());
		b.register(2, new MinecraftKey("slowness"), (new class_pk(true, 5926017)).c("effect.moveSlowdown").b(1, 0).a(class_wl.d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2));
		b.register(3, new MinecraftKey("haste"), (new class_pk(false, 14270531)).c("effect.digSpeed").b(2, 0).a(1.5D).j());
		b.register(4, new MinecraftKey("mining_fatigue"), (new class_pk(true, 4866583)).c("effect.digSlowDown").b(3, 0));
		b.register(5, new MinecraftKey("strength"), (new class_ph(false, 9643043, 1.3D)).c("effect.damageBoost").b(4, 0).a(class_wl.e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.5D, 2).j());
		b.register(6, new MinecraftKey("instant_health"), (new class_pj(false, 16262179)).c("effect.heal").j());
		b.register(7, new MinecraftKey("instant_damage"), (new class_pj(true, 4393481)).c("effect.harm").j());
		b.register(8, new MinecraftKey("jump_boost"), (new class_pk(false, 2293580)).c("effect.jump").b(2, 1).j());
		b.register(9, new MinecraftKey("nausea"), (new class_pk(true, 5578058)).c("effect.confusion").b(3, 1).a(0.25D));
		b.register(10, new MinecraftKey("regeneration"), (new class_pk(false, 13458603)).c("effect.regeneration").b(7, 0).a(0.25D).j());
		b.register(11, new MinecraftKey("resistance"), (new class_pk(false, 10044730)).c("effect.resistance").b(6, 1).j());
		b.register(12, new MinecraftKey("fire_resistance"), (new class_pk(false, 14981690)).c("effect.fireResistance").b(7, 1).j());
		b.register(13, new MinecraftKey("water_breathing"), (new class_pk(false, 3035801)).c("effect.waterBreathing").b(0, 2).j());
		b.register(14, new MinecraftKey("invisibility"), (new class_pk(false, 8356754)).c("effect.invisibility").b(0, 1).j());
		b.register(15, new MinecraftKey("blindness"), (new class_pk(true, 2039587)).c("effect.blindness").b(5, 1).a(0.25D));
		b.register(16, new MinecraftKey("night_vision"), (new class_pk(false, 2039713)).c("effect.nightVision").b(4, 1).j());
		b.register(17, new MinecraftKey("hunger"), (new class_pk(true, 5797459)).c("effect.hunger").b(1, 1));
		b.register(18, new MinecraftKey("weakness"), (new class_ph(true, 4738376, -0.5D)).c("effect.weakness").b(5, 0).a(class_wl.e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0D, 0));
		b.register(19, new MinecraftKey("poison"), (new class_pk(true, 5149489)).c("effect.poison").b(6, 0).a(0.25D));
		b.register(20, new MinecraftKey("wither"), (new class_pk(true, 3484199)).c("effect.wither").b(1, 2).a(0.25D));
		b.register(21, new MinecraftKey("health_boost"), (new class_pi(false, 16284963)).c("effect.healthBoost").b(2, 2).a(class_wl.a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, 0).j());
		b.register(22, new MinecraftKey("absorption"), (new class_pg(false, 2445989)).c("effect.absorption").b(2, 2).j());
		b.register(23, new MinecraftKey("saturation"), (new class_pj(false, 16262179)).c("effect.saturation").j());
		b.register(24, new MinecraftKey("glowing"), (new class_pk(false, 9740385)).c("effect.glowing").b(4, 2));
		b.register(25, new MinecraftKey("levitation"), (new class_pk(true, 13565951)).c("potion.levitation").b(3, 2));
	}

}
