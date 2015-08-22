package net.minecraft.server;

import java.util.ArrayList;

import com.google.common.collect.Lists;

public abstract class class_afj {
	public static final class_cx b = new class_cx();
	private final class_rc[] a;
	private final class_afj.class_a_in_class_afj e;
	public class_afk c;
	protected String d;

	public static class_afj c(int var0) {
		return (class_afj) b.a(var0);
	}

	public static int b(class_afj var0) {
		return b.a(var0);
	}

	public static class_afj b(String var0) {
		return (class_afj) b.c(new class_ke(var0));
	}

	protected class_afj(class_afj.class_a_in_class_afj var1, class_afk var2, class_rc[] var3) {
		e = var1;
		c = var2;
		a = var3;
	}

	public Iterable a(class_rg var1) {
		ArrayList var2 = Lists.newArrayList();
		class_rc[] var3 = a;
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_rc var6 = var3[var5];
			class_aco var7 = var1.a(var6);
			if (var7 != null) {
				var2.add(var7);
			}
		}

		return var2.size() > 0 ? var2 : null;
	}

	public class_afj.class_a_in_class_afj c() {
		return e;
	}

	public int d() {
		return 1;
	}

	public int b() {
		return 1;
	}

	public int a(int var1) {
		return 1 + (var1 * 10);
	}

	public int b(int var1) {
		return this.a(var1) + 5;
	}

	public int a(int var1, class_qi var2) {
		return 0;
	}

	public float a(int var1, class_rl var2) {
		return 0.0F;
	}

	public boolean a(class_afj var1) {
		return this != var1;
	}

	public class_afj c(String var1) {
		d = var1;
		return this;
	}

	public String a() {
		return "enchantment." + d;
	}

	public String d(int var1) {
		String var2 = class_di.a(this.a());
		return var2 + " " + class_di.a("enchantment.level." + var1);
	}

	public boolean a(class_aco var1) {
		return c.a(var1.b());
	}

	public void a(class_rg var1, class_qx var2, int var3) {
	}

	public void b(class_rg var1, class_qx var2, int var3) {
	}

	public static void e() {
		class_rc[] var0 = new class_rc[] { class_rc.f, class_rc.e, class_rc.d, class_rc.c };
		b.a(0, new class_ke("protection"), new class_aft(class_afj.class_a_in_class_afj.a, class_aft.class_a_in_class_aft.a, var0));
		b.a(1, new class_ke("fire_protection"), new class_aft(class_afj.class_a_in_class_afj.b, class_aft.class_a_in_class_aft.b, var0));
		b.a(2, new class_ke("feather_falling"), new class_aft(class_afj.class_a_in_class_afj.b, class_aft.class_a_in_class_aft.c, var0));
		b.a(3, new class_ke("blast_protection"), new class_aft(class_afj.class_a_in_class_afj.c, class_aft.class_a_in_class_aft.d, var0));
		b.a(4, new class_ke("projectile_protection"), new class_aft(class_afj.class_a_in_class_afj.b, class_aft.class_a_in_class_aft.e, var0));
		b.a(5, new class_ke("respiration"), new class_afs(class_afj.class_a_in_class_afj.c, var0));
		b.a(6, new class_ke("aqua_affinity"), new class_afx(class_afj.class_a_in_class_afj.c, var0));
		b.a(7, new class_ke("thorns"), new class_afu(class_afj.class_a_in_class_afj.d, var0));
		b.a(8, new class_ke("depth_strider"), new class_afw(class_afj.class_a_in_class_afj.c, var0));
		b.a(16, new class_ke("sharpness"), new class_afg(class_afj.class_a_in_class_afj.a, 0, new class_rc[] { class_rc.a }));
		b.a(17, new class_ke("smite"), new class_afg(class_afj.class_a_in_class_afj.b, 1, new class_rc[] { class_rc.a }));
		b.a(18, new class_ke("bane_of_arthropods"), new class_afg(class_afj.class_a_in_class_afj.b, 2, new class_rc[] { class_rc.a }));
		b.a(19, new class_ke("knockback"), new class_afq(class_afj.class_a_in_class_afj.b, new class_rc[] { class_rc.a }));
		b.a(20, new class_ke("fire_aspect"), new class_afo(class_afj.class_a_in_class_afj.c, new class_rc[] { class_rc.a }));
		b.a(21, new class_ke("looting"), new class_afr(class_afj.class_a_in_class_afj.c, class_afk.g, new class_rc[] { class_rc.a }));
		b.a(32, new class_ke("efficiency"), new class_afi(class_afj.class_a_in_class_afj.a, new class_rc[] { class_rc.a }));
		b.a(33, new class_ke("silk_touch"), new class_afv(class_afj.class_a_in_class_afj.d, new class_rc[] { class_rc.a }));
		b.a(34, new class_ke("unbreaking"), new class_afh(class_afj.class_a_in_class_afj.b, new class_rc[] { class_rc.a }));
		b.a(35, new class_ke("fortune"), new class_afr(class_afj.class_a_in_class_afj.c, class_afk.h, new class_rc[] { class_rc.a }));
		b.a(48, new class_ke("power"), new class_afc(class_afj.class_a_in_class_afj.a, new class_rc[] { class_rc.a }));
		b.a(49, new class_ke("punch"), new class_aff(class_afj.class_a_in_class_afj.c, new class_rc[] { class_rc.a }));
		b.a(50, new class_ke("flame"), new class_afd(class_afj.class_a_in_class_afj.c, new class_rc[] { class_rc.a }));
		b.a(51, new class_ke("infinity"), new class_afe(class_afj.class_a_in_class_afj.d, new class_rc[] { class_rc.a }));
		b.a(61, new class_ke("luck_of_the_sea"), new class_afr(class_afj.class_a_in_class_afj.c, class_afk.i, new class_rc[] { class_rc.a }));
		b.a(62, new class_ke("lure"), new class_afp(class_afj.class_a_in_class_afj.c, class_afk.i, new class_rc[] { class_rc.a }));
	}

	public static enum class_a_in_class_afj {
		a(10),
		b(5),
		c(2),
		d(1);

		private final int e;

		private class_a_in_class_afj(int var3) {
			e = var3;
		}

		public int a() {
			return e;
		}
	}
}
