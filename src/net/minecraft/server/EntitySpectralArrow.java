package net.minecraft.server;


public class EntitySpectralArrow extends EntityArrow {
	private int f = 200;

	public EntitySpectralArrow(class_ago var1) {
		super(var1);
	}

	public EntitySpectralArrow(class_ago var1, EntityLiving var2) {
		super(var1, var2);
	}

	public EntitySpectralArrow(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public void r_() {
		super.r_();
		if (o.D && !a) {
			o.a(class_cy.o, s, t, u, 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	@Override
	protected class_aco i() {
		return new class_aco(Items.h);
	}

	@Override
	protected void a(EntityLiving var1) {
		super.a(var1);
		class_qr var2 = new class_qr(class_qs.x, f, 0);
		var1.c(var2);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		if (var1.e("Duration")) {
			f = var1.h("Duration");
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Duration", f);
	}
}
