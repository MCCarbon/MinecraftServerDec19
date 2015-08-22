package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_wv extends class_wt {
	public class_wv(class_ago var1) {
		super(var1);
	}

	public class_wv(class_ago var1, class_cj var2) {
		super(var1, var2);
		this.b(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D);
		float var3 = 0.125F;
		float var4 = 0.1875F;
		float var5 = 0.25F;
		this.a((new class_ayk(s - 0.1875D, (t - 0.25D) + 0.125D, u - 0.1875D, s + 0.1875D, t + 0.25D + 0.125D, u + 0.1875D)));
	}

	@Override
	public void a(class_cq var1) {
	}

	@Override
	public int j() {
		return 9;
	}

	@Override
	public int k() {
		return 9;
	}

	@Override
	public float aY() {
		return -0.0625F;
	}

	@Override
	public void b(class_qx var1) {
	}

	@Override
	public boolean d(class_dn var1) {
		return false;
	}

	@Override
	public void b(class_dn var1) {
	}

	@Override
	public void a(class_dn var1) {
	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		if (o.D) {
			return true;
		} else {
			boolean var4 = false;
			double var5;
			List var7;
			Iterator var8;
			class_rh var9;
			if ((var2 != null) && (var2.b() == class_acq.cs)) {
				var5 = 7.0D;
				var7 = o.a(class_rh.class, new class_ayk(s - var5, t - var5, u - var5, s + var5, t + var5, u + var5));
				var8 = var7.iterator();

				while (var8.hasNext()) {
					var9 = (class_rh) var8.next();
					if (var9.cu() && (var9.cv() == var1)) {
						var9.a(this, true);
						var4 = true;
					}
				}
			}

			if (!var4) {
				L();
				if (var1.bI.d) {
					var5 = 7.0D;
					var7 = o.a(class_rh.class, new class_ayk(s - var5, t - var5, u - var5, s + var5, t + var5, u + var5));
					var8 = var7.iterator();

					while (var8.hasNext()) {
						var9 = (class_rh) var8.next();
						if (var9.cu() && (var9.cv() == this)) {
							var9.a(true, false);
						}
					}
				}
			}

			return true;
		}
	}

	@Override
	public boolean i() {
		return o.p(a).c() instanceof class_akb;
	}

	public static class_wv a(class_ago var0, class_cj var1) {
		class_wv var2 = new class_wv(var0, var1);
		var2.n = true;
		var0.a(var2);
		return var2;
	}

	public static class_wv b(class_ago var0, class_cj var1) {
		int var2 = var1.n();
		int var3 = var1.o();
		int var4 = var1.p();
		List var5 = var0.a(class_wv.class, new class_ayk(var2 - 1.0D, var3 - 1.0D, var4 - 1.0D, var2 + 1.0D, var3 + 1.0D, var4 + 1.0D));
		Iterator var6 = var5.iterator();

		class_wv var7;
		do {
			if (!var6.hasNext()) {
				return null;
			}

			var7 = (class_wv) var6.next();
		} while (!var7.m().equals(var1));

		return var7;
	}
}
