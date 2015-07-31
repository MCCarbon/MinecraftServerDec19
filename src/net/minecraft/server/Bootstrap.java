package net.minecraft.server;

import java.io.PrintStream;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.authlib.GameProfile;

public class Bootstrap {

	private static final PrintStream a = System.out;
	private static boolean init = false;
	private static final Logger logger = LogManager.getLogger();

	public static boolean isInitDone() {
		return init;
	}

	static void b() {
		class_ahk.N.register(Items.g, new class_kb() {
			@Override
			protected class_xi a(World var1, class_cz var2, ItemStack var3) {
				class_xd var4 = new class_xd(var1, var2.a(), var2.b(), var2.c());
				var4.c = 1;
				return var4;
			}
		});
		class_ahk.N.register(Items.i, new class_kb() {
			@Override
			protected class_xi a(World var1, class_cz var2, ItemStack var3) {
				class_xt var4 = new class_xt(var1, var2.a(), var2.b(), var2.c(), var3);
				var4.c = 1;
				return var4;
			}
		});
		class_ahk.N.register(Items.h, new class_kb() {
			@Override
			protected class_xi a(World var1, class_cz var2, ItemStack var3) {
				class_xn var4 = new class_xn(var1, var2.a(), var2.b(), var2.c());
				var4.c = 1;
				return var4;
			}
		});
		class_ahk.N.register(Items.aR, new class_kb() {
			@Override
			protected class_xi a(World var1, class_cz var2, ItemStack var3) {
				return new class_xp(var1, var2.a(), var2.b(), var2.c());
			}
		});
		class_ahk.N.register(Items.aF, new class_kb() {
			@Override
			protected class_xi a(World var1, class_cz var2, ItemStack var3) {
				return new class_xm(var1, var2.a(), var2.b(), var2.c());
			}
		});
		class_ahk.N.register(Items.bN, new class_kb() {
			@Override
			protected class_xi a(World var1, class_cz var2, ItemStack var3) {
				return new class_xr(var1, var2.a(), var2.b(), var2.c());
			}

			@Override
			protected float a() {
				return super.a() * 0.5F;
			}

			@Override
			protected float b() {
				return super.b() * 1.25F;
			}
		});
		class_ahk.N.register(Items.bC, new class_cr() {
			private final class_cn b = new class_cn();

			@Override
			public ItemStack a(class_ck var1, final ItemStack var2) {
				return (new class_kb() {
					@Override
					protected class_xi a(World var1, class_cz var2x, ItemStack var3) {
						return new class_xs(var1, var2x.a(), var2x.b(), var2x.c(), var2.clone());
					}

					@Override
					protected float a() {
						return super.a() * 0.5F;
					}

					@Override
					protected float b() {
						return super.b() * 1.25F;
					}
				}).a(var1, var2);
			}
		});
		class_ahk.N.register(Items.bM, new class_cn() {
			@Override
			public ItemStack b(class_ck var1, ItemStack var2) {
				EnumDirection var3 = class_ahk.b(var1.f());
				double var4 = var1.a() + var3.getAdjacentX();
				double var6 = var1.d().getY() + 0.2F;
				double var8 = var1.c() + var3.getAdjacentZ();
				class_pr var10 = class_abt.a(var1.i(), var2.i(), var4, var6, var8);
				if((var10 instanceof class_qa) && var2.hasDisplayName()) {
					((class_qb)var10).a(var2.getDisplayName());
				}

				var2.a(1);
				return var2;
			}
		});
		class_ahk.N.register(Items.ce, new class_cn() {
			@Override
			public ItemStack b(class_ck var1, ItemStack var2) {
				EnumDirection var3 = class_ahk.b(var1.f());
				double var4 = var1.a() + var3.getAdjacentX();
				double var6 = var1.d().getY() + 0.2F;
				double var8 = var1.c() + var3.getAdjacentZ();
				class_xg var10 = new class_xg(var1.i(), var4, var6, var8, var2);
				var1.i().a(var10);
				var2.a(1);
				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				var1.i().b(1002, var1.d(), 0);
			}
		});
		class_ahk.N.register(Items.bO, new class_cn() {
			@Override
			public ItemStack b(class_ck var1, ItemStack var2) {
				EnumDirection var3 = class_ahk.b(var1.f());
				class_cz var4 = class_ahk.a(var1);
				double var5 = var4.a() + var3.getAdjacentX() * 0.3F;
				double var7 = var4.b() + var3.getAdjacentY() * 0.3F;
				double var9 = var4.c() + var3.getAdjacentZ() * 0.3F;
				World var11 = var1.i();
				Random var12 = var11.s;
				double var13 = (var12.nextGaussian() * 0.05D) + var3.getAdjacentX();
				double var15 = (var12.nextGaussian() * 0.05D) + var3.getAdjacentY();
				double var17 = (var12.nextGaussian() * 0.05D) + var3.getAdjacentZ();
				var11.a((new class_xl(var11, var5, var7, var9, var13, var15, var17)));
				var2.a(1);
				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				var1.i().b(1009, var1.d(), 0);
			}
		});
		class_ahk.N.register(Items.aG, new class_cn() {
			private final class_cn b = new class_cn();

			@Override
			public ItemStack b(class_ck var1, ItemStack var2) {
				EnumDirection var3 = class_ahk.b(var1.f());
				World var4 = var1.i();
				double var5 = var1.a() + var3.getAdjacentX() * 1.125F;
				double var7 = var1.b() + var3.getAdjacentY() * 1.125F;
				double var9 = var1.c() + var3.getAdjacentZ() * 1.125F;
				BlockPosition var11 = var1.d().shift(var3);
				Material var12 = var4.p(var11).getBlock().getMaterial();
				double var13;
				if(Material.WATER.equals(var12)) {
					var13 = 1.0D;
				} else {
					if(!Material.AIR.equals(var12) || !Material.WATER.equals(var4.p(var11.shiftDown()).getBlock().getMaterial())) {
						return b.a(var1, var2);
					}

					var13 = 0.0D;
				}

				class_vk var15 = new class_vk(var4, var5, var7 + var13, var9);
				var4.a(var15);
				var2.a(1);
				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				var1.i().b(1000, var1.d(), 0);
			}
		});
		class_cn var0 = new class_cn() {
			private final class_cn b = new class_cn();

			@Override
			public ItemStack b(class_ck var1, ItemStack var2) {
				class_zn var3 = (class_zn)var2.getItem();
				BlockPosition var4 = var1.d().shift(class_ahk.b(var1.f()));
				if(var3.a(var1.i(), var4)) {
					var2.a(Items.ay);
					var2.count = 1;
					return var2;
				} else {
					return b.a(var1, var2);
				}
			}
		};
		class_ahk.N.register(Items.aA, var0);
		class_ahk.N.register(Items.az, var0);
		class_ahk.N.register(Items.ay, new class_cn() {
			private final class_cn b = new class_cn();

			@Override
			public ItemStack b(class_ck var1, ItemStack var2) {
				World var3 = var1.i();
				BlockPosition var4 = var1.d().shift(class_ahk.b(var1.f()));
				IBlockData var5 = var3.p(var4);
				Block var6 = var5.getBlock();
				Material var7 = var6.getMaterial();
				Item var8;
				if(Material.WATER.equals(var7) && (var6 instanceof class_ajd) && (((Integer)var5.get(class_ajd.b)).intValue() == 0)) {
					var8 = Items.az;
				} else {
					if(!Material.LAVA.equals(var7) || !(var6 instanceof class_ajd) || (((Integer)var5.get(class_ajd.b)).intValue() != 0)) {
						return super.b(var1, var2);
					}

					var8 = Items.aA;
				}

				var3.g(var4);
				if(--var2.count == 0) {
					var2.a(var8);
					var2.count = 1;
				} else if(((class_amm)var1.h()).a(new ItemStack(var8)) < 0) {
					b.a(var1, new ItemStack(var8));
				}

				return var2;
			}
		});
		class_ahk.N.register(Items.d, new class_cn() {
			private boolean b = true;

			@Override
			protected ItemStack b(class_ck var1, ItemStack var2) {
				World var3 = var1.i();
				BlockPosition var4 = var1.d().shift(class_ahk.b(var1.f()));
				if(var3.d(var4)) {
					var3.a(var4, Blocks.FIRE.getBlockData());
					if(var2.a(1, var3.s)) {
						var2.count = 0;
					}
				} else if(var3.p(var4).getBlock() == Blocks.TNT) {
					Blocks.TNT.d(var3, var4, Blocks.TNT.getBlockData().set(class_alo.a, Boolean.valueOf(true)));
					var3.g(var4);
				} else {
					b = false;
				}

				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				if(b) {
					var1.i().b(1000, var1.d(), 0);
				} else {
					var1.i().b(1001, var1.d(), 0);
				}

			}
		});
		class_ahk.N.register(Items.aY, new class_cn() {
			private boolean b = true;

			@Override
			protected ItemStack b(class_ck var1, ItemStack var2) {
				if(class_zy.a == class_zy.a(var2.i())) {
					World var3 = var1.i();
					BlockPosition var4 = var1.d().shift(class_ahk.b(var1.f()));
					if(class_zz.a(var2, var3, var4)) {
						if(!var3.D) {
							var3.b(2005, var4, 0);
						}
					} else {
						b = false;
					}

					return var2;
				} else {
					return super.b(var1, var2);
				}
			}

			@Override
			protected void a(class_ck var1) {
				if(b) {
					var1.i().b(1000, var1.d(), 0);
				} else {
					var1.i().b(1001, var1.d(), 0);
				}

			}
		});
		class_ahk.N.register(Item.getByBlock(Blocks.TNT), new class_cn() {
			@Override
			protected ItemStack b(class_ck var1, ItemStack var2) {
				World var3 = var1.i();
				BlockPosition var4 = var1.d().shift(class_ahk.b(var1.f()));
				class_vw var5 = new class_vw(var3, var4.getX() + 0.5D, var4.getY(), var4.getZ() + 0.5D, (class_qa)null);
				var3.a(var5);
				var3.a(var5, "game.tnt.primed", 1.0F, 1.0F);
				--var2.count;
				return var2;
			}
		});
		class_ahk.N.register(Items.ca, new class_cn() {
			private boolean b = true;

			@Override
			protected ItemStack b(class_ck var1, ItemStack var2) {
				World var3 = var1.i();
				EnumDirection var4 = class_ahk.b(var1.f());
				BlockPosition var5 = var1.d().shift(var4);
				class_akv var6 = Blocks.SKULL;
				if(var3.d(var5) && var6.b(var3, var5, var2)) {
					if(!var3.D) {
						var3.a(var5, var6.getBlockData().set(class_akv.a, EnumDirection.UP), 3);
						class_amg var7 = var3.s(var5);
						if(var7 instanceof class_amy) {
							if(var2.i() == 3) {
								GameProfile var8 = null;
								if(var2.hasTag()) {
									NBTTagCompound var9 = var2.getTag();
									if(var9.hasOfType("SkullOwner", 10)) {
										var8 = class_dy.a(var9.getCompound("SkullOwner"));
									} else if(var9.hasOfType("SkullOwner", 8)) {
										String var10 = var9.getString("SkullOwner");
										if(!class_nz.b(var10)) {
											var8 = new GameProfile((UUID)null, var10);
										}
									}
								}

								((class_amy)var7).a(var8);
							} else {
								((class_amy)var7).a(var2.i());
							}

							((class_amy)var7).b(var4.getOpposite().getHorizontalId() * 4);
							Blocks.SKULL.a(var3, var5, (class_amy)var7);
						}

						--var2.count;
					}
				} else {
					b = false;
				}

				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				if(b) {
					var1.i().b(1000, var1.d(), 0);
				} else {
					var1.i().b(1001, var1.d(), 0);
				}

			}
		});
		class_ahk.N.register(Item.getByBlock(Blocks.PUMPKIN), new class_cn() {
			private boolean b = true;

			@Override
			protected ItemStack b(class_ck var1, ItemStack var2) {
				World var3 = var1.i();
				BlockPosition var4 = var1.d().shift(class_ahk.b(var1.f()));
				class_akd var5 = (class_akd)Blocks.PUMPKIN;
				if(var3.d(var4) && var5.e(var3, var4)) {
					if(!var3.D) {
						var3.a(var4, var5.getBlockData(), 3);
					}

					--var2.count;
				} else {
					b = false;
				}

				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				if(b) {
					var1.i().b(1000, var1.d(), 0);
				} else {
					var1.i().b(1001, var1.d(), 0);
				}

			}
		});
	}

	public static void init() {
		if(!init) {
			init = true;
			if(logger.isDebugEnabled()) {
				rerouteStreams();
			}

			Block.init();
			class_aib.l();
			class_pk.k();
			class_adi.e();
			Item.init();
			class_acd.c();
			class_ace.a();
			class_nc.a();
			b();
		}
	}

	private static void rerouteStreams() {
		System.setErr(new class_kh("STDERR", System.err));
		System.setOut(new class_kh("STDOUT", a));
	}

}
