package net.minecraft.server;


public class class_wj extends class_wa {
	private int b;

	public class_wj(class_vx var1) {
		super(var1);
	}

	@Override
	public void c() {
		++b;
		class_yu var1 = a.o.a(a, 20.0D, 10.0D);
		if (var1 != null) {
			if (b > 25) {
				a.cy().a(class_wm.h);
			} else {
				class_aym var2 = (new class_aym(var1.s - a.s, 0.0D, var1.u - a.u)).a();
				class_aym var3 = (new class_aym(class_oa.a((a.y * 3.1415927F) / 180.0F), 0.0D, (-class_oa.b((a.y * 3.1415927F) / 180.0F)))).a();
				float var4 = (float) var3.b(var2);
				float var5 = (float) ((Math.acos(var4) * 180.0D) / 3.1415927410125732D) + 0.5F;
				if ((var5 < 0.0F) || (var5 > 10.0F)) {
					double var6 = var1.s - a.bs.s;
					double var8 = var1.u - a.bs.u;
					double var10 = class_oa.a(class_oa.g(180.0D - ((class_oa.b(var6, var8) * 180.0D) / 3.1415927410125732D) - a.y), -50.0D, 50.0D);
					a.bf *= 0.8F;
					float var12 = (class_oa.a((var6 * var6) + (var8 * var8)) * 1.0F) + 1.0F;
					float var13 = var12;
					if (var12 > 40.0F) {
						var12 = 40.0F;
					}

					a.bf = (float) (a.bf + (var10 * (0.7F / var12 / var13)));
					a.y += a.bf;
				}
			}
		} else if (b >= 100) {
			var1 = a.o.a(a, 150.0D, 150.0D);
			a.cy().a(class_wm.e);
			if (var1 != null) {
				a.cy().a(class_wm.i);
				((class_wb) a.cy().b(class_wm.i)).a(new class_aym(var1.s, var1.t, var1.u));
			}
		}

	}

	@Override
	public void d() {
		b = 0;
	}

	@Override
	public class_wm i() {
		return class_wm.g;
	}
}
