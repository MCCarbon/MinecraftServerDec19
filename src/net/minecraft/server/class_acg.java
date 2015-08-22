package net.minecraft.server;


public class class_acg extends class_acm {
	public class_acg() {
		this.e(64);
		this.d(1);
		this.a(class_abp.i);
		this.a(new class_ke("cast"), new class_acp() {
		});
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		if (var3.bO != null) {
			int var5 = var3.bO.j();
			var1.a(var5, var3);
			var3.a(var4);
		} else {
			var2.a((class_qx) var3, "random.bow", 0.5F, 0.4F / ((h.nextFloat() * 0.4F) + 0.8F));
			if (!var2.D) {
				var2.a((new class_wy(var2, var3)));
			}

			var3.a(var4);
			var3.b(class_nh.c(class_acm.b(this)));
		}

		return new class_px(class_pw.a, var1);
	}

	@Override
	public boolean f_(class_aco var1) {
		return super.f_(var1);
	}

	@Override
	public int c() {
		return 1;
	}
}
