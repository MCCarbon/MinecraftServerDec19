package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public abstract class class_um {
	protected class_rh b;
	protected class_ago c;
	protected class_axc d;
	protected double e;
	private final class_rq a;
	private int f;
	private int g;
	private class_aym h = new class_aym(0.0D, 0.0D, 0.0D);
	private float i = 1.0F;
	private final class_axd j;

	public class_um(class_rh var1, class_ago var2) {
		b = var1;
		c = var2;
		a = var1.a(class_yf.b);
		j = this.a();
	}

	protected abstract class_axd a();

	public void a(double var1) {
		e = var1;
	}

	public float i() {
		return (float) a.e();
	}

	public final class_axc a(double var1, double var3, double var5) {
		return this.a(new class_cj(class_oa.c(var1), (int) var3, class_oa.c(var5)));
	}

	public class_axc a(class_cj var1) {
		if (!b()) {
			return null;
		} else {
			float var2 = i();
			c.B.a("pathfind");
			class_cj var3 = new class_cj(b);
			int var4 = (int) (var2 + 8.0F);
			class_agx var5 = new class_agx(c, var3.a(-var4, -var4, -var4), var3.a(var4, var4, var4), 0);
			class_axc var6 = j.a(var5, b, var1, var2);
			c.B.b();
			return var6;
		}
	}

	public boolean a(double var1, double var3, double var5, double var7) {
		class_axc var9 = this.a(class_oa.c(var1), ((int) var3), class_oa.c(var5));
		return this.a(var9, var7);
	}

	public void a(float var1) {
		i = var1;
	}

	public class_axc a(Entity var1) {
		if (!b()) {
			return null;
		} else {
			float var2 = i();
			c.B.a("pathfind");
			class_cj var3 = (new class_cj(b)).a();
			int var4 = (int) (var2 + 16.0F);
			class_agx var5 = new class_agx(c, var3.a(-var4, -var4, -var4), var3.a(var4, var4, var4), 0);
			class_axc var6 = j.a(var5, b, var1, var2);
			c.B.b();
			return var6;
		}
	}

	public boolean a(Entity var1, double var2) {
		class_axc var4 = this.a(var1);
		return var4 != null ? this.a(var4, var2) : false;
	}

	public boolean a(class_axc var1, double var2) {
		if (var1 == null) {
			d = null;
			return false;
		} else {
			if (!var1.a(d)) {
				d = var1;
			}

			d();
			if (d.d() == 0) {
				return false;
			} else {
				e = var2;
				class_aym var4 = c();
				g = f;
				h = var4;
				return true;
			}
		}
	}

	public class_axc j() {
		return d;
	}

	public void k() {
		++f;
		if (!m()) {
			class_aym var1;
			if (b()) {
				l();
			} else if ((d != null) && (d.e() < d.d())) {
				var1 = c();
				class_aym var2 = d.a(b, d.e());
				if ((var1.b > var2.b) && !b.C && (class_oa.c(var1.a) == class_oa.c(var2.a)) && (class_oa.c(var1.c) == class_oa.c(var2.c))) {
					d.c(d.e() + 1);
				}
			}

			if (!m()) {
				var1 = d.a(b);
				if (var1 != null) {
					class_ayk var8 = (new class_ayk(var1.a, var1.b, var1.c, var1.a, var1.b, var1.c)).b(0.5D, 0.5D, 0.5D);
					List var3 = c.a(b, var8.a(0.0D, -1.0D, 0.0D));
					double var4 = -1.0D;
					var8 = var8.c(0.0D, 1.0D, 0.0D);

					class_ayk var7;
					for (Iterator var6 = var3.iterator(); var6.hasNext(); var4 = var7.b(var8, var4)) {
						var7 = (class_ayk) var6.next();
					}

					b.r().a(var1.a, var1.b + var4, var1.c, e);
				}
			}
		}
	}

	protected void l() {
		class_aym var1 = c();
		int var2 = d.d();

		for (int var3 = d.e(); var3 < d.d(); ++var3) {
			if (d.a(var3).b != (int) var1.b) {
				var2 = var3;
				break;
			}
		}

		float var8 = b.J * b.J * i;

		int var4;
		for (var4 = d.e(); var4 < var2; ++var4) {
			class_aym var5 = d.a(b, var4);
			if (var1.g(var5) < var8) {
				d.c(var4 + 1);
			}
		}

		var4 = class_oa.f(b.J);
		int var9 = (int) b.K + 1;
		int var6 = var4;

		for (int var7 = var2 - 1; var7 >= d.e(); --var7) {
			if (this.a(var1, d.a(b, var7), var4, var9, var6)) {
				d.c(var7);
				break;
			}
		}

		this.a(var1);
	}

	protected void a(class_aym var1) {
		if ((f - g) > 100) {
			if (var1.g(h) < 2.25D) {
				n();
			}

			g = f;
			h = var1;
		}

	}

	public boolean m() {
		return (d == null) || d.b();
	}

	public void n() {
		d = null;
	}

	protected abstract class_aym c();

	protected abstract boolean b();

	protected boolean o() {
		return b.Y() || b.ae();
	}

	protected void d() {
	}

	protected abstract boolean a(class_aym var1, class_aym var2, int var3, int var4, int var5);
}
