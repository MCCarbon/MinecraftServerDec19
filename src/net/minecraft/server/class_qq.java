package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.google.common.collect.Maps;

public class class_qq {
	public static final class_cx b = new class_cx();
	private final Map a = Maps.newHashMap();
	private final boolean c;
	private final int d;
	private String e = "";
	private int f = -1;
	private double g;
	private boolean h;

	public static class_qq a(int var0) {
		return (class_qq) b.a(var0);
	}

	public static int a(class_qq var0) {
		return b.a(var0);
	}

	public static class_qq b(String var0) {
		return (class_qq) b.c(new class_ke(var0));
	}

	protected class_qq(boolean var1, int var2) {
		c = var1;
		if (var1) {
			g = 0.5D;
		} else {
			g = 1.0D;
		}

		d = var2;
	}

	protected class_qq b(int var1, int var2) {
		f = var1 + (var2 * 8);
		return this;
	}

	public void a(EntityLiving var1, int var2) {
		if (this == class_qs.j) {
			if (var1.bu() < var1.bB()) {
				var1.b(1.0F);
			}
		} else if (this == class_qs.s) {
			if (var1.bu() > 1.0F) {
				var1.a(class_qi.l, 1.0F);
			}
		} else if (this == class_qs.t) {
			var1.a(class_qi.m, 1.0F);
		} else if ((this == class_qs.q) && (var1 instanceof class_yu)) {
			((class_yu) var1).a(0.025F * (var2 + 1));
		} else if ((this == class_qs.w) && (var1 instanceof class_yu)) {
			if (!var1.o.D) {
				((class_yu) var1).ct().a(var2 + 1, 1.0F);
			}
		} else if (((this != class_qs.f) || var1.bt()) && ((this != class_qs.g) || !var1.bt())) {
			if (((this == class_qs.g) && !var1.bt()) || ((this == class_qs.f) && var1.bt())) {
				var1.a(class_qi.l, 6 << var2);
			}
		} else {
			var1.b(Math.max(4 << var2, 0));
		}

	}

	public void a(Entity var1, Entity var2, EntityLiving var3, int var4, double var5) {
		int var7;
		if (((this != class_qs.f) || var3.bt()) && ((this != class_qs.g) || !var3.bt())) {
			if (((this == class_qs.g) && !var3.bt()) || ((this == class_qs.f) && var3.bt())) {
				var7 = (int) ((var5 * (6 << var4)) + 0.5D);
				if (var1 == null) {
					var3.a(class_qi.l, var7);
				} else {
					var3.a(class_qi.b(var1, var2), var7);
				}
			}
		} else {
			var7 = (int) ((var5 * (4 << var4)) + 0.5D);
			var3.b(var7);
		}

	}

	public boolean a(int var1, int var2) {
		int var3;
		if (this == class_qs.j) {
			var3 = 50 >> var2;
			return var3 > 0 ? (var1 % var3) == 0 : true;
		} else if (this == class_qs.s) {
			var3 = 25 >> var2;
				return var3 > 0 ? (var1 % var3) == 0 : true;
		} else if (this == class_qs.t) {
			var3 = 40 >> var2;
				return var3 > 0 ? (var1 % var3) == 0 : true;
		} else {
			return this == class_qs.q;
		}
	}

	public boolean b() {
		return false;
	}

	public class_qq c(String var1) {
		e = var1;
		return this;
	}

	public String a() {
		return e;
	}

	protected class_qq a(double var1) {
		g = var1;
		return this;
	}

	public int g() {
		return d;
	}

	public class_qq a(class_rp var1, String var2, double var3, int var5) {
		class_rr var6 = new class_rr(UUID.fromString(var2), this.a(), var3, var5);
		a.put(var1, var6);
		return this;
	}

	public void a(EntityLiving var1, class_rt var2, int var3) {
		Iterator var4 = a.entrySet().iterator();

		while (var4.hasNext()) {
			Entry var5 = (Entry) var4.next();
			class_rq var6 = var2.a((class_rp) var5.getKey());
			if (var6 != null) {
				var6.c((class_rr) var5.getValue());
			}
		}

	}

	public void b(EntityLiving var1, class_rt var2, int var3) {
		Iterator var4 = a.entrySet().iterator();

		while (var4.hasNext()) {
			Entry var5 = (Entry) var4.next();
			class_rq var6 = var2.a((class_rp) var5.getKey());
			if (var6 != null) {
				class_rr var7 = (class_rr) var5.getValue();
				var6.c(var7);
				var6.b(new class_rr(var7.a(), this.a() + " " + var3, this.a(var3, var7), var7.c()));
			}
		}

	}

	public double a(int var1, class_rr var2) {
		return var2.d() * (var1 + 1);
	}

	public class_qq j() {
		h = true;
		return this;
	}

	public static void k() {
		b.a(1, new class_ke("speed"), (new class_qq(false, 8171462)).c("effect.moveSpeed").b(0, 0).a(class_yf.d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2).j());
		b.a(2, new class_ke("slowness"), (new class_qq(true, 5926017)).c("effect.moveSlowdown").b(1, 0).a(class_yf.d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2));
		b.a(3, new class_ke("haste"), (new class_qq(false, 14270531)).c("effect.digSpeed").b(2, 0).a(1.5D).j().a(class_yf.f, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 0.10000000149011612D, 2));
		b.a(4, new class_ke("mining_fatigue"), (new class_qq(true, 4866583)).c("effect.digSlowDown").b(3, 0).a(class_yf.f, "55FCED67-E92A-486E-9800-B47F202C4386", -0.10000000149011612D, 2));
		b.a(5, new class_ke("strength"), (new class_qn(false, 9643043, 3.0D)).c("effect.damageBoost").b(4, 0).a(class_yf.e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 0.0D, 0).j());
		b.a(6, new class_ke("instant_health"), (new class_qp(false, 16262179)).c("effect.heal").j());
		b.a(7, new class_ke("instant_damage"), (new class_qp(true, 4393481)).c("effect.harm").j());
		b.a(8, new class_ke("jump_boost"), (new class_qq(false, 2293580)).c("effect.jump").b(2, 1).j());
		b.a(9, new class_ke("nausea"), (new class_qq(true, 5578058)).c("effect.confusion").b(3, 1).a(0.25D));
		b.a(10, new class_ke("regeneration"), (new class_qq(false, 13458603)).c("effect.regeneration").b(7, 0).a(0.25D).j());
		b.a(11, new class_ke("resistance"), (new class_qq(false, 10044730)).c("effect.resistance").b(6, 1).j());
		b.a(12, new class_ke("fire_resistance"), (new class_qq(false, 14981690)).c("effect.fireResistance").b(7, 1).j());
		b.a(13, new class_ke("water_breathing"), (new class_qq(false, 3035801)).c("effect.waterBreathing").b(0, 2).j());
		b.a(14, new class_ke("invisibility"), (new class_qq(false, 8356754)).c("effect.invisibility").b(0, 1).j());
		b.a(15, new class_ke("blindness"), (new class_qq(true, 2039587)).c("effect.blindness").b(5, 1).a(0.25D));
		b.a(16, new class_ke("night_vision"), (new class_qq(false, 2039713)).c("effect.nightVision").b(4, 1).j());
		b.a(17, new class_ke("hunger"), (new class_qq(true, 5797459)).c("effect.hunger").b(1, 1));
		b.a(18, new class_ke("weakness"), (new class_qn(true, 4738376, -4.0D)).c("effect.weakness").b(5, 0).a(class_yf.e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 0.0D, 0));
		b.a(19, new class_ke("poison"), (new class_qq(true, 5149489)).c("effect.poison").b(6, 0).a(0.25D));
		b.a(20, new class_ke("wither"), (new class_qq(true, 3484199)).c("effect.wither").b(1, 2).a(0.25D));
		b.a(21, new class_ke("health_boost"), (new class_qo(false, 16284963)).c("effect.healthBoost").b(2, 2).a(class_yf.a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, 0).j());
		b.a(22, new class_ke("absorption"), (new class_qm(false, 2445989)).c("effect.absorption").b(2, 2).j());
		b.a(23, new class_ke("saturation"), (new class_qp(false, 16262179)).c("effect.saturation").j());
		b.a(24, new class_ke("glowing"), (new class_qq(false, 9740385)).c("effect.glowing").b(4, 2));
		b.a(25, new class_ke("levitation"), (new class_qq(true, 13565951)).c("effect.levitation").b(3, 2));
	}
}
