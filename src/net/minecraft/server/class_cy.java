package net.minecraft.server;

import java.util.ArrayList;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public enum class_cy {
	a("explode", 0, true),
	b("largeexplode", 1, true),
	c("hugeexplosion", 2, true),
	d("fireworksSpark", 3, false),
	e("bubble", 4, false),
	f("splash", 5, false),
	g("wake", 6, false),
	h("suspended", 7, false),
	i("depthsuspend", 8, false),
	j("crit", 9, false),
	k("magicCrit", 10, false),
	l("smoke", 11, false),
	m("largesmoke", 12, false),
	n("spell", 13, false),
	o("instantSpell", 14, false),
	p("mobSpell", 15, false),
	q("mobSpellAmbient", 16, false),
	r("witchMagic", 17, false),
	s("dripWater", 18, false),
	t("dripLava", 19, false),
	u("angryVillager", 20, false),
	v("happyVillager", 21, false),
	w("townaura", 22, false),
	x("note", 23, false),
	y("portal", 24, false),
	z("enchantmenttable", 25, false),
	A("flame", 26, false),
	B("lava", 27, false),
	C("footstep", 28, false),
	D("cloud", 29, false),
	E("reddust", 30, false),
	F("snowballpoof", 31, false),
	G("snowshovel", 32, false),
	H("slime", 33, false),
	I("heart", 34, false),
	J("barrier", 35, false),
	K("iconcrack_", 36, false, 2),
	L("blockcrack_", 37, false, 1),
	M("blockdust_", 38, false, 1),
	N("droplet", 39, false),
	O("take", 40, false),
	P("mobappearance", 41, true),
	Q("dragonbreath", 42, false),
	R("endRod", 43, false),
	S("damageIndicator", 44, true),
	T("sweepAttack", 45, true);

	private final String U;
	private final int V;
	private final boolean W;
	private final int X;
	private static final Map Y;
	private static final String[] Z;

	private class_cy(String var3, int var4, boolean var5, int var6) {
		U = var3;
		V = var4;
		W = var5;
		X = var6;
	}

	private class_cy(String var3, int var4, boolean var5) {
		this(var3, var4, var5, 0);
	}

	public static String[] a() {
		return Z;
	}

	public String b() {
		return U;
	}

	public int c() {
		return V;
	}

	public int d() {
		return X;
	}

	public boolean e() {
		return W;
	}

	public boolean f() {
		return X > 0;
	}

	public static class_cy a(int var0) {
		return (class_cy) Y.get(Integer.valueOf(var0));
	}

	static {
		Y = Maps.newHashMap();
		ArrayList var0 = Lists.newArrayList();
		class_cy[] var1 = values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_cy var4 = var1[var3];
			Y.put(Integer.valueOf(var4.c()), var4);
			if (!var4.b().endsWith("_")) {
				var0.add(var4.b());
			}
		}

		Z = (String[]) var0.toArray(new String[var0.size()]);
	}
}
