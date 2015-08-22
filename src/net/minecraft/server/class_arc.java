package net.minecraft.server;


public abstract class class_arc {
	public static final float[] a = new float[] { 1.0F, 0.75F, 0.5F, 0.25F, 0.0F, 0.25F, 0.5F, 0.75F };
	protected class_ago b;
	private class_agt g;
	private String h;
	protected class_ahf c;
	protected boolean d;
	protected boolean e;
	protected final float[] f = new float[16];
	private final float[] i = new float[4];

	public final void a(class_ago var1) {
		b = var1;
		g = var1.R().t();
		h = var1.R().A();
		this.b();
		this.a();
	}

	protected void a() {
		float var1 = 0.0F;

		for (int var2 = 0; var2 <= 15; ++var2) {
			float var3 = 1.0F - (var2 / 15.0F);
			f[var2] = (((1.0F - var3) / ((var3 * 3.0F) + 1.0F)) * (1.0F - var1)) + var1;
		}

	}

	protected void b() {
		class_agt var1 = b.R().t();
		if (var1 == class_agt.c) {
			class_atv var2 = class_atv.a(b.R().A());
			c = new class_ahi(class_ahb.a(var2.a(), class_ahb.ad), 0.5F);
		} else if (var1 == class_agt.g) {
			c = new class_ahi(class_ahb.q, 0.0F);
		} else {
			c = new class_ahf(b);
		}

	}

	public class_aqk c() {
		return g == class_agt.c ? new class_aro(b, b.L(), b.R().r(), h) : (g == class_agt.g ? new class_arn(b) : (g == class_agt.f ? new class_art(b, b.L(), b.R().r(), h) : new class_art(b, b.L(), b.R().r(), h)));
	}

	public boolean a(int var1, int var2) {
		return b.c(new class_cj(var1, 0, var2)) == class_aim.c;
	}

	public float a(long var1, float var3) {
		int var4 = (int) (var1 % 24000L);
		float var5 = ((var4 + var3) / 24000.0F) - 0.25F;
		if (var5 < 0.0F) {
			++var5;
		}

		if (var5 > 1.0F) {
			--var5;
		}

		float var6 = var5;
		var5 = 1.0F - (float) ((Math.cos(var5 * 3.141592653589793D) + 1.0D) / 2.0D);
		var5 = var6 + ((var5 - var6) / 3.0F);
		return var5;
	}

	public int a(long var1) {
		return (int) (((var1 / 24000L) % 8L) + 8L) % 8;
	}

	public boolean d() {
		return true;
	}

	public boolean e() {
		return true;
	}

	public class_cj h() {
		return null;
	}

	public int i() {
		return g == class_agt.c ? 4 : b.H() + 1;
	}

	public class_ahf k() {
		return c;
	}

	public boolean l() {
		return d;
	}

	public boolean m() {
		return e;
	}

	public float[] n() {
		return f;
	}

	public class_aqg o() {
		return new class_aqg();
	}

	public void a(class_lm var1) {
	}

	public void b(class_lm var1) {
	}

	public abstract class_ard p();

	public void q() {
	}

	public void r() {
	}

	public boolean c(int var1, int var2) {
		return true;
	}
}
