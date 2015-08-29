package net.minecraft.server;


public class EntityCaveSpider extends EntitySpider {
	public EntityCaveSpider(class_ago var1) {
		super(var1);
		this.a(0.7F, 0.5F);
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(12.0D);
	}

	@Override
	public boolean r(Entity var1) {
		if (super.r(var1)) {
			if (var1 instanceof EntityLiving) {
				byte var2 = 0;
				if (o.ac() == class_ps.c) {
					var2 = 7;
				} else if (o.ac() == class_ps.d) {
					var2 = 15;
				}

				if (var2 > 0) {
					((EntityLiving) var1).c(new class_qr(class_qs.s, var2 * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		return var2;
	}

	@Override
	public float aY() {
		return 0.45F;
	}
}
