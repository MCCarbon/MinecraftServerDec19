package net.minecraft.server;


public class class_xn extends class_xh {
	public class_xn(class_ago var1) {
		super(var1);
	}

	public class_xn(class_ago var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		if ((l != null) && (l instanceof class_yu) && (l != var1)) {
			return true;
		} else if ((l != null) && (l != var1)) {
			return false;
		} else {
			if (!o.D) {
				var1.a(this);
			}

			return true;
		}
	}

	@Override
	public void a(int var1, int var2, int var3, boolean var4) {
		if (var4) {
			if (l != null) {
				l.a((class_qx) null);
			}

			if (q() == 0) {
				this.j(-r());
				this.i(10);
				this.a(50.0F);
				af();
			}
		}

	}

	@Override
	public class_xh.class_a_in_class_xh s() {
		return class_xh.class_a_in_class_xh.a;
	}
}
