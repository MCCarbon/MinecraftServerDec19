package net.minecraft.server;

import java.util.Random;

public class class_akz extends class_aks {
	public class_akz() {
		super(class_avq.w, false);
		L = 0.98F;
		this.a(true);
		this.a(class_abp.b);
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, TileEntity var5, class_aco var6) {
		var2.b(class_nh.a(Block.a(this)));
		var2.a(0.025F);
		if (K() && (class_afl.a(class_afn.q, var6) > 0)) {
			class_aco var9 = this.i(var4);
			if (var9 != null) {
				a(var1, var3, var9);
			}
		} else {
			if (var1.t.l()) {
				var1.g(var3);
				return;
			}

			int var7 = class_afl.a(class_afn.s, var6);
			this.b(var1, var3, var4, var7);
			class_avq var8 = var1.p(var3.b()).c().v();
			if (var8.c() || var8.d()) {
				var1.a(var3, Blocks.i.S());
			}
		}

	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (var1.b(class_agu.b, var2) > (11 - r())) {
			if (var1.t.l()) {
				var1.g(var2);
			} else {
				this.b(var1, var2, var1.p(var2), 0);
				var1.a(var2, Blocks.j.S());
			}
		}
	}

	@Override
	public int k() {
		return 0;
	}
}
