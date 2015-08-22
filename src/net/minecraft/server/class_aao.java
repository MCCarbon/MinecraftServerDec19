package net.minecraft.server;


public class class_aao extends class_aas {
	private final class_aam a;
	private class_yu b;
	private int c;
	private final class_aga h;

	public class_aao(class_yu var1, class_aga var2, class_aam var3, int var4, int var5, int var6) {
		super(var3, var4, var5, var6);
		b = var1;
		h = var2;
		a = var3;
	}

	@Override
	public boolean a(class_aco var1) {
		return false;
	}

	@Override
	public class_aco a(int var1) {
		if (e()) {
			c += Math.min(var1, this.d().b);
		}

		return super.a(var1);
	}

	@Override
	protected void a(class_aco var1, int var2) {
		c += var2;
		c(var1);
	}

	@Override
	protected void c(class_aco var1) {
		var1.a(b.o, b, c);
		c = 0;
	}

	@Override
	public void a(class_yu var1, class_aco var2) {
		c(var2);
		class_agb var3 = a.i();
		if (var3 != null) {
			class_aco var4 = a.a(0);
			class_aco var5 = a.a(1);
			if (this.a(var3, var4, var5) || this.a(var3, var5, var4)) {
				h.a(var3);
				var1.b(class_nh.H);
				if ((var4 != null) && (var4.b <= 0)) {
					var4 = null;
				}

				if ((var5 != null) && (var5.b <= 0)) {
					var5 = null;
				}

				a.a(0, var4);
				a.a(1, var5);
			}
		}

	}

	private boolean a(class_agb var1, class_aco var2, class_aco var3) {
		class_aco var4 = var1.a();
		class_aco var5 = var1.b();
		if ((var2 != null) && (var2.b() == var4.b())) {
			if ((var5 != null) && (var3 != null) && (var5.b() == var3.b())) {
				var2.b -= var4.b;
				var3.b -= var5.b;
				return true;
			}

			if ((var5 == null) && (var3 == null)) {
				var2.b -= var4.b;
				return true;
			}
		}

		return false;
	}
}
