package net.minecraft.server;


public class class_aaz extends class_abb {
	public class_aaz() {
		super(Blocks.STANDING_BANNER);
		i = 16;
		this.a(class_abp.c);
		this.a(true);
		this.e(0);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if ((var6 != class_cq.a) && var3.p(var4).c().v().a()) {
			var4 = var4.a(var6);
			if (var2.a(var4, var6, var1) && Blocks.STANDING_BANNER.c(var3, var4)) {
				if (var3.D) {
					return class_pw.a;
				} else {
					if (var6 == class_cq.b) {
						int var10 = class_oa.c(((var2.y + 180.0F) * 16.0F) / 360.0F + 0.5D) & 15;
						var3.a(var4, Blocks.STANDING_BANNER.S().a(class_ang.a, Integer.valueOf(var10)), 3);
					} else {
						var3.a(var4, Blocks.WALL_BANNER.S().a(class_any.a, var6), 3);
					}

					--var1.b;
					TileEntity var11 = var3.s(var4);
					if (var11 instanceof class_aog) {
						((class_aog) var11).a(var1);
					}

					return class_pw.a;
				}
			} else {
				return class_pw.c;
			}
		} else {
			return class_pw.c;
		}
	}

	@Override
	public String a(class_aco var1) {
		String var2 = "item.banner.";
		class_abt var3 = b(var1);
		var2 = var2 + var3.d() + ".name";
		return class_di.a(var2);
	}

	public static class_abt b(class_aco var0) {
		class_dn var1 = var0.a("BlockEntityTag", false);
		class_abt var2 = null;
		if ((var1 != null) && var1.e("Base")) {
			var2 = class_abt.a(var1.h("Base"));
		} else {
			var2 = class_abt.a(var0.i());
		}

		return var2;
	}
}
