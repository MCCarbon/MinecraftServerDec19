package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_uw {
	private class_ago a;
	private boolean b;
	private int c = -1;
	private int d;
	private int e;
	private class_uv f;
	private int g;
	private int h;
	private int i;

	public class_uw(class_ago var1) {
		a = var1;
	}

	public void a() {
		if (a.z()) {
			c = 0;
		} else if (c != 2) {
			if (c == 0) {
				float var1 = a.c(0.0F);
				if ((var1 < 0.5D) || (var1 > 0.501D)) {
					return;
				}

				c = a.s.nextInt(10) == 0 ? 1 : 2;
				b = false;
				if (c == 2) {
					return;
				}
			}

			if (c != -1) {
				if (!b) {
					if (!b()) {
						return;
					}

					b = true;
				}

				if (e > 0) {
					--e;
				} else {
					e = 2;
					if (d > 0) {
						c();
						--d;
					} else {
						c = 2;
					}

				}
			}
		}
	}

	private boolean b() {
		List var1 = a.j;
		Iterator var2 = var1.iterator();

		class_aym var11;
		do {
			do {
				do {
					do {
						do {
							class_yu var3;
							do {
								if (!var2.hasNext()) {
									return false;
								}

								var3 = (class_yu) var2.next();
							} while (var3.w());

							f = a.ag().a(new class_cj(var3), 1);
						} while (f == null);
					} while (f.c() < 10);
				} while (f.d() < 20);
			} while (f.e() < 20);

			class_cj var4 = f.a();
			float var5 = f.b();
			boolean var6 = false;

			for (int var7 = 0; var7 < 10; ++var7) {
				float var8 = a.s.nextFloat() * 3.1415927F * 2.0F;
				g = var4.n() + (int) (MathHelper.b(var8) * var5 * 0.9D);
				h = var4.o();
				i = var4.p() + (int) (MathHelper.a(var8) * var5 * 0.9D);
				var6 = false;
				Iterator var9 = a.ag().b().iterator();

				while (var9.hasNext()) {
					class_uv var10 = (class_uv) var9.next();
					if ((var10 != f) && var10.a(new class_cj(g, h, i))) {
						var6 = true;
						break;
					}
				}

				if (!var6) {
					break;
				}
			}

			if (var6) {
				return false;
			}

			var11 = this.a(new class_cj(g, h, i));
		} while (var11 == null);

		e = 0;
		d = 20;
		return true;
	}

	private boolean c() {
		class_aym var1 = this.a(new class_cj(g, h, i));
		if (var1 == null) {
			return false;
		} else {
			class_yl var2;
			try {
				var2 = new class_yl(a);
				var2.a(a.E(new class_cj(var2)), (class_rj) null);
				var2.o(false);
			} catch (Exception var4) {
				var4.printStackTrace();
				return false;
			}

			var2.b(var1.a, var1.b, var1.c, a.s.nextFloat() * 360.0F, 0.0F);
			a.a(var2);
			class_cj var3 = f.a();
			var2.a(var3, f.b());
			return true;
		}
	}

	private class_aym a(class_cj var1) {
		for (int var2 = 0; var2 < 10; ++var2) {
			class_cj var3 = var1.a(a.s.nextInt(16) - 8, a.s.nextInt(6) - 3, a.s.nextInt(16) - 8);
			if (f.a(var3) && class_agv.a(class_rh.class_a_in_class_rh.a, a, var3)) {
				return new class_aym(var3.n(), var3.o(), var3.p());
			}
		}

		return null;
	}
}
