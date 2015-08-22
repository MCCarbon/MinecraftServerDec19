package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_adl extends class_abq {
	private static final Set c;

	public class_adl(Item.class_a_in_class_acm var1) {
		super(3.5F, -3.0F, var1, c);
	}

	@Override
	public boolean b(Block var1) {
		return var1 == Blocks.aH ? true : var1 == Blocks.aJ;
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (!var2.a(var4.a(var6), var6, var1)) {
			return class_pw.c;
		} else {
			class_apn var10 = var3.p(var4);
			Block var11 = var10.c();
			if ((var6 != class_cq.a) && (var3.p(var4.a()).c().v() == class_avq.a) && (var11 == Blocks.c)) {
				class_apn var12 = Blocks.da.S();
				Block var13 = var12.c();
				var3.a(var4.n() + 0.5F, var4.o() + 0.5F, var4.p() + 0.5F, var13.H.c(), (var13.H.d() + 1.0F) / 2.0F, var13.H.e() * 0.8F);
				if (!var3.D) {
					var3.a(var4, var12);
					var1.a(1, var2);
				}

				return class_pw.a;
			} else {
				return class_pw.b;
			}
		}
	}

	static {
		c = Sets.newHashSet((Object[]) (new Block[] { Blocks.aL, Blocks.d, Blocks.ak, Blocks.c, Blocks.n, Blocks.bw, Blocks.m, Blocks.aJ, Blocks.aH, Blocks.aW, Blocks.da }));
	}
}
