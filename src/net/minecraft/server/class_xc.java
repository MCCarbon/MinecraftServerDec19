package net.minecraft.server;

import java.util.List;

public class class_xc extends class_xb {
	private int b;
	public long a;
	private int c;

	public class_xc(class_ago var1, double var2, double var4, double var6) {
		super(var1);
		this.b(var2, var4, var6, 0.0F, 0.0F);
		b = 2;
		a = V.nextLong();
		c = V.nextInt(3) + 1;
		class_cj var8 = new class_cj(this);
		if (!var1.D && var1.S().b("doFireTick") && ((var1.ac() == class_ps.c) || (var1.ac() == class_ps.d)) && var1.a(var8, 10)) {
			if ((var1.p(var8).c().v() == class_avq.a) && class_aim.ab.c(var1, var8)) {
				var1.a(var8, class_aim.ab.S());
			}

			for (int var9 = 0; var9 < 4; ++var9) {
				class_cj var10 = var8.a(V.nextInt(3) - 1, V.nextInt(3) - 1, V.nextInt(3) - 1);
				if ((var1.p(var10).c().v() == class_avq.a) && class_aim.ab.c(var1, var10)) {
					var1.a(var10, class_aim.ab.S());
				}
			}
		}

	}

	@Override
	public void r_() {
		super.r_();
		if (b == 2) {
			o.a(s, t, u, "ambient.weather.thunder", 10000.0F, 0.8F + (V.nextFloat() * 0.2F));
			o.a(s, t, u, "random.explode", 2.0F, 0.5F + (V.nextFloat() * 0.2F));
		}

		--b;
		if (b < 0) {
			if (c == 0) {
				L();
			} else if (b < -V.nextInt(10)) {
				--c;
				b = 1;
				a = V.nextLong();
				class_cj var1 = new class_cj(this);
				if (!o.D && o.S().b("doFireTick") && o.a(var1, 10) && (o.p(var1).c().v() == class_avq.a) && class_aim.ab.c(o, var1)) {
					o.a(var1, class_aim.ab.S());
				}
			}
		}

		if (b >= 0) {
			if (o.D) {
				o.d(2);
			} else {
				double var6 = 3.0D;
				List var3 = o.b(this, (new class_ayk(s - var6, t - var6, u - var6, s + var6, t + 6.0D + var6, u + var6)));

				for (int var4 = 0; var4 < var3.size(); ++var4) {
					class_qx var5 = (class_qx) var3.get(var4);
					var5.a(this);
				}
			}
		}

	}

	@Override
	protected void h() {
	}

	@Override
	protected void a(class_dn var1) {
	}

	@Override
	protected void b(class_dn var1) {
	}
}
