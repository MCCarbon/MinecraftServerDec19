package net.minecraft.server;


public class class_vn extends class_vg implements class_ye {
	public class_vn(class_ago var1) {
		super(var1);
		this.a(0.7F, 1.9F);
		((class_ul) u()).a(true);
		i.a(1, new class_to(this, 1.25D, 20, 10.0F));
		i.a(2, new class_tn(this, 1.0D));
		i.a(3, new class_sw(this, class_yu.class, 6.0F));
		i.a(4, new class_tm(this));
		bo.a(1, new class_uf(this, class_rh.class, 10, true, false, class_xx.d));
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(4.0D);
		this.a(class_yf.d).a(0.20000000298023224D);
	}

	@Override
	public void m() {
		super.m();
		if (!o.D) {
			int var1 = class_oa.c(s);
			int var2 = class_oa.c(t);
			int var3 = class_oa.c(u);
			if (X()) {
				this.a(class_qi.f, 1.0F);
			}

			if (o.b(new class_cj(var1, 0, var3)).a(new class_cj(var1, var2, var3)) > 1.0F) {
				this.a(class_qi.c, 1.0F);
			}

			for (int var4 = 0; var4 < 4; ++var4) {
				var1 = class_oa.c(s + (((var4 % 2) * 2) - 1) * 0.25F);
				var2 = class_oa.c(t);
				var3 = class_oa.c(u + ((((var4 / 2) % 2) * 2) - 1) * 0.25F);
				class_cj var5 = new class_cj(var1, var2, var3);
				if ((o.p(var5).c().v() == class_avq.a) && (o.b(new class_cj(var1, 0, var3)).a(var5) < 0.8F) && class_aim.aH.c(o, var5)) {
					o.a(var5, class_aim.aH.S());
				}
			}
		}

	}

	@Override
	protected class_acm D() {
		return class_acq.aF;
	}

	@Override
	protected void b(boolean var1, int var2) {
		int var3 = V.nextInt(16);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.a(class_acq.aF, 1);
		}

	}

	@Override
	public void a(class_rg var1, float var2) {
		class_zh var3 = new class_zh(o, this);
		double var4 = (var1.t + var1.aY()) - 1.100000023841858D;
		double var6 = var1.s - s;
		double var8 = var4 - var3.t;
		double var10 = var1.u - u;
		float var12 = class_oa.a((var6 * var6) + (var10 * var10)) * 0.2F;
		var3.c(var6, var8 + var12, var10, 1.6F, 12.0F);
		this.a("random.bow", 1.0F, 1.0F / ((bj().nextFloat() * 0.4F) + 0.8F));
		o.a(var3);
	}

	@Override
	public float aY() {
		return 1.7F;
	}
}
