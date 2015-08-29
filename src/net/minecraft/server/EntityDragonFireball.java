package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class EntityDragonFireball extends class_za {
	public static float a = 4.0F;

	public EntityDragonFireball(class_ago var1) {
		super(var1);
		this.a(0.3125F, 0.3125F);
	}

	public EntityDragonFireball(class_ago var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1, var2, var4, var6, var8, var10, var12);
		this.a(0.3125F, 0.3125F);
	}

	public EntityDragonFireball(class_ago var1, EntityLiving var2, double var3, double var5, double var7) {
		super(var1, var2, var3, var5, var7);
		this.a(0.3125F, 0.3125F);
	}

	@Override
	protected void a(class_ayl var1) {
		if (!o.D) {
			List var2 = o.a(EntityLiving.class, aX().b(a, a / 2.0F, a));
			EntityAreaEffectCloud var3 = new EntityAreaEffectCloud(o, s, t, u);
			var3.a(b);
			var3.a(class_cy.Q);
			var3.a(3.0F);
			var3.b(2400);
			var3.c((7.0F - var3.i()) / var3.n());
			var3.a(new class_qr(class_qs.g, 1, 1));
			if (!var2.isEmpty()) {
				Iterator var4 = var2.iterator();

				while (var4.hasNext()) {
					EntityLiving var5 = (EntityLiving) var4.next();
					double var6 = this.h(var5);
					if (var6 < a * a) {
						var3.b(var5.s, var5.t, var5.u);
						break;
					}
				}
			}

			o.b(2006, new class_cj(s, t, u), 0);
			o.a(var3);
			L();
		}

	}

	@Override
	public boolean ag() {
		return false;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		return false;
	}

	@Override
	protected class_cy i() {
		return class_cy.Q;
	}

	@Override
	protected boolean j() {
		return false;
	}
}
