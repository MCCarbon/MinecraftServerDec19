package net.minecraft.server;

import java.util.UUID;

import com.mojang.authlib.GameProfile;

public class class_ado extends Item {
	private static final String[] a = new String[] { "skeleton", "wither", "zombie", "char", "creeper", "dragon" };

	public class_ado() {
		this.a(class_abp.c);
		this.e(0);
		this.a(true);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if (var6 == class_cq.a) {
			return class_pw.c;
		} else {
			class_apn var10 = var3.p(var4);
			Block var11 = var10.c();
			boolean var12 = var11.a(var3, var4);
			if (!var12) {
				if (!var3.p(var4).c().v().a()) {
					return class_pw.c;
				}

				var4 = var4.a(var6);
			}

			if (var2.a(var4, var6, var1) && Blocks.SKULL.c(var3, var4)) {
				if (var3.D) {
					return class_pw.a;
				} else {
					var3.a(var4, Blocks.SKULL.S().a(BlockSkull.a, var6), 3);
					int var13 = 0;
					if (var6 == class_cq.b) {
						var13 = MathHelper.c((var2.y * 16.0F) / 360.0F + 0.5D) & 15;
					}

					TileEntity var14 = var3.s(var4);
					if (var14 instanceof class_apa) {
						class_apa var15 = (class_apa) var14;
						if (var1.i() == 3) {
							GameProfile var16 = null;
							if (var1.n()) {
								class_dn var17 = var1.o();
								if (var17.b("SkullOwner", 10)) {
									var16 = class_dy.a(var17.o("SkullOwner"));
								} else if (var17.b("SkullOwner", 8) && !var17.l("SkullOwner").isEmpty()) {
									var16 = new GameProfile((UUID) null, var17.l("SkullOwner"));
								}
							}

							var15.a(var16);
						} else {
							var15.a(var1.i());
						}

						var15.b(var13);
						Blocks.SKULL.a(var3, var4, var15);
					}

					--var1.b;
					return class_pw.a;
				}
			} else {
				return class_pw.c;
			}
		}
	}

	@Override
	public int a(int var1) {
		return var1;
	}

	@Override
	public String e_(class_aco var1) {
		int var2 = var1.i();
		if ((var2 < 0) || (var2 >= a.length)) {
			var2 = 0;
		}

		return super.a() + "." + a[var2];
	}

	@Override
	public String a(class_aco var1) {
		if ((var1.i() == 3) && var1.n()) {
			if (var1.o().b("SkullOwner", 8)) {
				return class_di.a("item.skull.player.name", new Object[] { var1.o().l("SkullOwner") });
			}

			if (var1.o().b("SkullOwner", 10)) {
				class_dn var2 = var1.o().o("SkullOwner");
				if (var2.b("Name", 8)) {
					return class_di.a("item.skull.player.name", new Object[] { var2.l("Name") });
				}
			}
		}

		return super.a(var1);
	}

	@Override
	public boolean a(class_dn var1) {
		super.a(var1);
		if (var1.b("SkullOwner", 8) && !var1.l("SkullOwner").isEmpty()) {
			GameProfile var2 = new GameProfile((UUID) null, var1.l("SkullOwner"));
			var2 = class_apa.b(var2);
			var1.a("SkullOwner", class_dy.a(new class_dn(), var2));
			return true;
		} else {
			return false;
		}
	}
}
