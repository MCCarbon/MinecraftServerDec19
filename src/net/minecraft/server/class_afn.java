package net.minecraft.server;


public class class_afn {
	public static final class_afj a = a("protection");
	public static final class_afj b = a("fire_protection");
	public static final class_afj c = a("feather_falling");
	public static final class_afj d = a("blast_protection");
	public static final class_afj e = a("projectile_protection");
	public static final class_afj f = a("respiration");
	public static final class_afj g = a("aqua_affinity");
	public static final class_afj h = a("thorns");
	public static final class_afj i = a("depth_strider");
	public static final class_afj j = a("sharpness");
	public static final class_afj k = a("smite");
	public static final class_afj l = a("bane_of_arthropods");
	public static final class_afj m = a("knockback");
	public static final class_afj n = a("fire_aspect");
	public static final class_afj o = a("looting");
	public static final class_afj p = a("efficiency");
	public static final class_afj q = a("silk_touch");
	public static final class_afj r = a("unbreaking");
	public static final class_afj s = a("fortune");
	public static final class_afj t = a("power");
	public static final class_afj u = a("punch");
	public static final class_afj v = a("flame");
	public static final class_afj w = a("infinity");
	public static final class_afj x = a("luck_of_the_sea");
	public static final class_afj y = a("lure");

	private static class_afj a(String var0) {
		class_afj var1 = (class_afj) class_afj.b.c(new class_ke(var0));
		if (var1 == null) {
			throw new IllegalStateException("Invalid Enchantment requested: " + var0);
		} else {
			return var1;
		}
	}

	static {
		if (!class_kh.a()) {
			throw new RuntimeException("Accessed MobEffects before Bootstrap!");
		}
	}
}
