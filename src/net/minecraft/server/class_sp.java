package net.minecraft.server;


public class class_sp extends class_sr {
	private class_ro d;
	private class_rg e;
	class_ago a;
	private double f;
	private class_um g;
	private int h;
	float b;
	float c;
	private boolean i;

	public class_sp(class_ro var1, double var2, float var4, float var5) {
		d = var1;
		a = var1.o;
		f = var2;
		g = var1.u();
		c = var4;
		b = var5;
		this.a(3);
		if (!(var1.u() instanceof class_ul)) {
			throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
		}
	}

	@Override
	public boolean a() {
		class_rg var1 = d.cH();
		if (var1 == null) {
			return false;
		} else if ((var1 instanceof class_yu) && ((class_yu) var1).w()) {
			return false;
		} else if (d.cG()) {
			return false;
		} else if (d.h(var1) < c * c) {
			return false;
		} else {
			e = var1;
			return true;
		}
	}

	@Override
	public boolean b() {
		return !g.m() && (d.h(e) > b * b) && !d.cG();
	}

	@Override
	public void c() {
		h = 0;
		i = ((class_ul) d.u()).e();
		((class_ul) d.u()).a(false);
	}

	@Override
	public void d() {
		e = null;
		g.n();
		((class_ul) d.u()).a(true);
	}

	private boolean a(class_cj var1) {
		class_apn var2 = a.p(var1);
		Block var3 = var2.c();
		return var3 == Blocks.a ? true : !var3.d();
	}

	@Override
	public void e() {
		d.q().a(e, 10.0F, d.ch());
		if (!d.cG()) {
			if (--h <= 0) {
				h = 10;
				if (!g.a(e, f)) {
					if (!d.cu()) {
						if (d.h(e) >= 144.0D) {
							int var1 = class_oa.c(e.s) - 2;
							int var2 = class_oa.c(e.u) - 2;
							int var3 = class_oa.c(e.aX().b);

							for (int var4 = 0; var4 <= 4; ++var4) {
								for (int var5 = 0; var5 <= 4; ++var5) {
									if (((var4 < 1) || (var5 < 1) || (var4 > 3) || (var5 > 3)) && class_ago.a(a, (new class_cj(var1 + var4, var3 - 1, var2 + var5))) && this.a(new class_cj(var1 + var4, var3, var2 + var5)) && this.a(new class_cj(var1 + var4, var3 + 1, var2 + var5))) {
										d.b(var1 + var4 + 0.5F, var3, var2 + var5 + 0.5F, d.y, d.z);
										g.n();
										return;
									}
								}
							}

						}
					}
				}
			}
		}
	}
}
