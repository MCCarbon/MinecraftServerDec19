package net.minecraft.server;


public abstract class class_re extends class_rh {
	public class_re(class_ago var1) {
		super(var1);
	}

	@Override
	public void e(float var1, float var2) {
	}

	@Override
	protected void a(double var1, boolean var3, class_ail var4, class_cj var5) {
	}

	@Override
	public void g(float var1, float var2) {
		if (Y()) {
			this.a(var1, var2, 0.02F);
			this.d(v, w, x);
			v *= 0.800000011920929D;
			w *= 0.800000011920929D;
			x *= 0.800000011920929D;
		} else if (ae()) {
			this.a(var1, var2, 0.02F);
			this.d(v, w, x);
			v *= 0.5D;
			w *= 0.5D;
			x *= 0.5D;
		} else {
			float var3 = 0.91F;
			if (C) {
				var3 = o.p(new class_cj(class_oa.c(s), class_oa.c(aX().b) - 1, class_oa.c(u))).c().L * 0.91F;
			}

			float var4 = 0.16277136F / (var3 * var3 * var3);
			this.a(var1, var2, C ? 0.1F * var4 : 0.02F);
			var3 = 0.91F;
			if (C) {
				var3 = o.p(new class_cj(class_oa.c(s), class_oa.c(aX().b) - 1, class_oa.c(u))).c().L * 0.91F;
			}

			this.d(v, w, x);
			v *= var3;
			w *= var3;
			x *= var3;
		}

		aE = aF;
		double var8 = s - p;
		double var5 = u - r;
		float var7 = class_oa.a((var8 * var8) + (var5 * var5)) * 4.0F;
		if (var7 > 1.0F) {
			var7 = 1.0F;
		}

		aF += (var7 - aF) * 0.4F;
		aG += aF;
	}

	@Override
	public boolean j_() {
		return false;
	}
}
