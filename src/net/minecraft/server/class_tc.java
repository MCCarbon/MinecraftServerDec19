package net.minecraft.server;


public abstract class class_tc extends class_sr {
	private final class_rn c;
	private final double d;
	protected int a;
	private int e;
	private int f;
	protected class_cj b;
	private boolean g;
	private int h;

	public class_tc(class_rn var1, double var2, int var4) {
		b = class_cj.a;
		c = var1;
		d = var2;
		h = var4;
		this.a(5);
	}

	@Override
	public boolean a() {
		if (a > 0) {
			--a;
			return false;
		} else {
			a = 200 + c.bj().nextInt(200);
			return g();
		}
	}

	@Override
	public boolean b() {
		return (e >= -f) && (e <= 1200) && this.a(c.o, b);
	}

	@Override
	public void c() {
		c.u().a((b.n()) + 0.5D, b.o() + 1, (b.p()) + 0.5D, d);
		e = 0;
		f = c.bj().nextInt(c.bj().nextInt(1200) + 1200) + 1200;
	}

	@Override
	public void d() {
	}

	@Override
	public void e() {
		if (c.c(b.a()) > 1.0D) {
			g = false;
			++e;
			if ((e % 40) == 0) {
				c.u().a((b.n()) + 0.5D, b.o() + 1, (b.p()) + 0.5D, d);
			}
		} else {
			g = true;
			--e;
		}

	}

	protected boolean f() {
		return g;
	}

	private boolean g() {
		int var1 = h;
		boolean var2 = true;
		class_cj var3 = new class_cj(c);

		for (int var4 = 0; var4 <= 1; var4 = var4 > 0 ? -var4 : 1 - var4) {
			for (int var5 = 0; var5 < var1; ++var5) {
				for (int var6 = 0; var6 <= var5; var6 = var6 > 0 ? -var6 : 1 - var6) {
					for (int var7 = (var6 < var5) && (var6 > -var5) ? var5 : 0; var7 <= var5; var7 = var7 > 0 ? -var7 : 1 - var7) {
						class_cj var8 = var3.a(var6, var4 - 1, var7);
						if (c.e(var8) && this.a(c.o, var8)) {
							b = var8;
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	protected abstract boolean a(class_ago var1, class_cj var2);
}
