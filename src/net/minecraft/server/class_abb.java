package net.minecraft.server;


public class class_abb extends Item {
	protected final Block a;

	public class_abb(Block var1) {
		a = var1;
	}

	public class_abb b(String var1) {
		super.c(var1);
		return this;
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		class_apn var10 = var3.p(var4);
		Block var11 = var10.c();
		if (!var11.a(var3, var4)) {
			var4 = var4.a(var6);
		}

		if ((var1.b != 0) && var2.a(var4, var6, var1) && var3.a(a, var4, false, var6, (Entity) null, var1)) {
			int var12 = this.a(var1.i());
			class_apn var13 = a.a(var3, var4, var6, var7, var8, var9, var12, var2);
			if (var3.a(var4, var13, 3)) {
				var13 = var3.p(var4);
				if (var13.c() == a) {
					a(var3, var2, var4, var1);
					a.a(var3, var4, var13, var2, var1);
				}

				var3.a(var4.n() + 0.5F, var4.o() + 0.5F, var4.p() + 0.5F, a.H.b(), (a.H.d() + 1.0F) / 2.0F, a.H.e() * 0.8F);
				--var1.b;
			}

			return class_pw.a;
		} else {
			return class_pw.c;
		}
	}

	public static boolean a(class_ago var0, class_yu var1, class_cj var2, class_aco var3) {
		MinecraftServer var4 = MinecraftServer.P();
		if (var4 == null) {
			return false;
		} else {
			if (var3.n() && var3.o().b("BlockEntityTag", 10)) {
				TileEntity var5 = var0.s(var2);
				if (var5 != null) {
					if (!var0.D && var5.F() && ((var1 == null) || !var4.ar().h(var1.cl()))) {
						return false;
					}

					class_dn var6 = new class_dn();
					class_dn var7 = (class_dn) var6.b();
					var5.b(var6);
					class_dn var8 = (class_dn) var3.o().c("BlockEntityTag");
					var6.a(var8);
					var6.a("x", var2.n());
					var6.a("y", var2.o());
					var6.a("z", var2.p());
					if (!var6.equals(var7)) {
						var5.a(var6);
						var5.o_();
						return true;
					}
				}
			}

			return false;
		}
	}

	@Override
	public String e_(class_aco var1) {
		return a.a();
	}

	@Override
	public String a() {
		return a.a();
	}

	public Block d() {
		return a;
	}

	// $FF: synthetic method
	@Override
	public Item c(String var1) {
		return this.b(var1);
	}
}
