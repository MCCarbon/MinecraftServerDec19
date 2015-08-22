package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_ev {
	public static class_eu a(ICommandListener var0, class_eu var1, Entity var2) throws class_bz {
		Object var3 = null;
		if (var1 instanceof class_ex) {
			class_ex var4 = (class_ex) var1;
			String var5 = var4.g();
			if (class_o.b(var5)) {
				List var6 = class_o.b(var0, var5, Entity.class);
				if (var6.size() != 1) {
					throw new class_ca();
				}

				var5 = ((Entity) var6.get(0)).e_();
			}

			var3 = (var2 != null) && var5.equals("*") ? new class_ex(var2.e_(), var4.h()) : new class_ex(var5, var4.h());
			((class_ex) var3).b(var4.e());
		} else if (var1 instanceof class_ey) {
			String var7 = ((class_ey) var1).g();
			var3 = class_o.b(var0, var7);
			if (var3 == null) {
				var3 = new class_fa("");
			}
		} else if (var1 instanceof class_fa) {
			var3 = new class_fa(((class_fa) var1).g());
		} else {
			if (!(var1 instanceof class_fb)) {
				return var1;
			}

			Object[] var8 = ((class_fb) var1).j();

			for (int var10 = 0; var10 < var8.length; ++var10) {
				Object var11 = var8[var10];
				if (var11 instanceof class_eu) {
					var8[var10] = a(var0, (class_eu) var11, var2);
				}
			}

			var3 = new class_fb(((class_fb) var1).i(), var8);
		}

		class_ez var9 = var1.b();
		if (var9 != null) {
			((class_eu) var3).a(var9.m());
		}

		Iterator var13 = var1.a().iterator();

		while (var13.hasNext()) {
			class_eu var12 = (class_eu) var13.next();
			((class_eu) var3).a(a(var0, var12, var2));
		}

		return (class_eu) var3;
	}
}
