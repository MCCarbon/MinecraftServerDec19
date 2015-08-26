package net.minecraft.server;


public class class_adm extends Item {
	public class_adm() {
		i = 16;
		this.a(class_abp.c);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if ((var6 != class_cq.a) && var3.p(var4).c().v().a()) {
			var4 = var4.a(var6);
			if (var2.a(var4, var6, var1) && Blocks.STANDING_SIGN.c(var3, var4)) {
				if (var3.D) {
					return class_pw.a;
				} else {
					if (var6 == class_cq.b) {
						int var10 = MathHelper.c(((var2.y + 180.0F) * 16.0F) / 360.0F + 0.5D) & 15;
						var3.a(var4, Blocks.STANDING_SIGN.S().a(class_ang.a, Integer.valueOf(var10)), 3);
					} else {
						var3.a(var4, Blocks.WALL_SIGN.S().a(class_any.a, var6), 3);
					}

					--var1.b;
					TileEntity var11 = var3.s(var4);
					if ((var11 instanceof class_aoz) && !class_abb.a(var3, var2, var4, var1)) {
						var2.a((class_aoz) var11);
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
}
