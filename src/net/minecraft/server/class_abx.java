package net.minecraft.server;


public class class_abx extends class_abo {
	protected class_abx() {
		this.a(class_abp.f);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		class_aco var5 = new class_aco(Items.bf, 1, var2.b("map"));
		String var6 = "map_" + var5.i();
		class_axl var7 = new class_axl(var6);
		var2.a(var6, var7);
		var7.f = 2;
		var7.a(var3.s, var3.u, var7.f);
		var7.d = (byte) var2.t.p().a();
		var7.e = true;
		var7.c();
		--var1.b;
		if (var1.b <= 0) {
			return new class_px(class_pw.a, var5);
		} else {
			if (!var3.bq.a(var5.k())) {
				var3.a(var5, false);
			}

			var3.b(StatisticList.c(Item.b(this)));
			return new class_px(class_pw.a, var1);
		}
	}
}
