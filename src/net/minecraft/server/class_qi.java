package net.minecraft.server;


public class class_qi {
	public static class_qi a = (new class_qi("inFire")).n();
	public static class_qi b = new class_qi("lightningBolt");
	public static class_qi c = (new class_qi("onFire")).k().n();
	public static class_qi d = (new class_qi("lava")).n();
	public static class_qi e = (new class_qi("inWall")).k();
	public static class_qi f = (new class_qi("drown")).k();
	public static class_qi g = (new class_qi("starve")).k().m();
	public static class_qi h = new class_qi("cactus");
	public static class_qi i = (new class_qi("fall")).k();
	public static class_qi j = (new class_qi("outOfWorld")).k().l();
	public static class_qi k = (new class_qi("generic")).k();
	public static class_qi l = (new class_qi("magic")).k().t();
	public static class_qi m = (new class_qi("wither")).k();
	public static class_qi n = new class_qi("anvil");
	public static class_qi o = new class_qi("fallingBlock");
	public static class_qi p = (new class_qi("dragonBreath")).k();
	private boolean r;
	private boolean s;
	private boolean t;
	private float u = 0.3F;
	private boolean v;
	private boolean w;
	private boolean x;
	private boolean y;
	private boolean z;
	public String q;

	public static class_qi a(class_rg var0) {
		return new class_qj("mob", var0);
	}

	public static class_qi a(class_qx var0, class_rg var1) {
		return new class_qk("mob", var0, var1);
	}

	public static class_qi a(class_yu var0) {
		return new class_qj("player", var0);
	}

	public static class_qi a(class_yx var0, class_qx var1) {
		return (new class_qk("arrow", var0, var1)).b();
	}

	public static class_qi a(class_za var0, class_qx var1) {
		return var1 == null ? (new class_qk("onFire", var0, var0)).n().b() : (new class_qk("fireball", var0, var1)).n().b();
	}

	public static class_qi a(class_qx var0, class_qx var1) {
		return (new class_qk("thrown", var0, var1)).b();
	}

	public static class_qi b(class_qx var0, class_qx var1) {
		return (new class_qk("indirectMagic", var0, var1)).k().t();
	}

	public static class_qi a(class_qx var0) {
		return (new class_qj("thorns", var0)).w().t();
	}

	public static class_qi a(class_agk var0) {
		return (var0 != null) && (var0.c() != null) ? (new class_qj("explosion.player", var0.c())).q().d() : (new class_qi("explosion")).q().d();
	}

	public static class_qi b(class_rg var0) {
		return var0 != null ? (new class_qj("explosion.player", var0)).q().d() : (new class_qi("explosion")).q().d();
	}

	public boolean a() {
		return w;
	}

	public class_qi b() {
		w = true;
		return this;
	}

	public boolean c() {
		return z;
	}

	public class_qi d() {
		z = true;
		return this;
	}

	public boolean e() {
		return r;
	}

	public float f() {
		return u;
	}

	public boolean g() {
		return s;
	}

	public boolean h() {
		return t;
	}

	protected class_qi(String var1) {
		q = var1;
	}

	public class_qx i() {
		return j();
	}

	public class_qx j() {
		return null;
	}

	protected class_qi k() {
		r = true;
		u = 0.0F;
		return this;
	}

	protected class_qi l() {
		s = true;
		return this;
	}

	protected class_qi m() {
		t = true;
		u = 0.0F;
		return this;
	}

	protected class_qi n() {
		v = true;
		return this;
	}

	public class_eu c(class_rg var1) {
		class_rg var2 = var1.bA();
		String var3 = "death.attack." + q;
		String var4 = var3 + ".player";
		return (var2 != null) && class_di.c(var4) ? new class_fb(var4, new Object[] { var1.f_(), var2.f_() }) : new class_fb(var3, new Object[] { var1.f_() });
	}

	public boolean o() {
		return v;
	}

	public String p() {
		return q;
	}

	public class_qi q() {
		x = true;
		return this;
	}

	public boolean r() {
		return x;
	}

	public boolean s() {
		return y;
	}

	public class_qi t() {
		y = true;
		return this;
	}

	public boolean u() {
		class_qx var1 = j();
		return (var1 instanceof class_yu) && ((class_yu) var1).bI.d;
	}

	public class_aym v() {
		return null;
	}
}
