package net.minecraft.server;


public class class_xt extends class_yj {
	public class_xt(class_ago var1) {
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
			if (var1 instanceof class_rg) {
				byte var2 = 0;
				if (o.ac() == class_ps.c) {
					var2 = 7;
				} else if (o.ac() == class_ps.d) {
					var2 = 15;
				}

				if (var2 > 0) {
					((class_rg) var1).c(new class_qr(class_qs.s, var2 * 20, 0));
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
