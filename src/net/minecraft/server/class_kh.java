package net.minecraft.server;

import java.io.PrintStream;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mojang.authlib.GameProfile;

public class class_kh {
	public static final PrintStream a;
	private static boolean b;
	private static final Logger c;

	public static boolean a() {
		return b;
	}

	static void b() {
		class_ajm.N.a(Items.g, new class_kg() {
			@Override
			protected class_zd a(class_ago var1, class_cz var2, class_aco var3) {
				class_yx var4 = new class_yx(var1, var2.a(), var2.b(), var2.c());
				var4.c = 1;
				return var4;
			}
		});
		class_ajm.N.a(Items.i, new class_kg() {
			@Override
			protected class_zd a(class_ago var1, class_cz var2, class_aco var3) {
				class_zo var4 = new class_zo(var1, var2.a(), var2.b(), var2.c(), var3);
				var4.c = 1;
				return var4;
			}
		});
		class_ajm.N.a(Items.h, new class_kg() {
			@Override
			protected class_zd a(class_ago var1, class_cz var2, class_aco var3) {
				class_zi var4 = new class_zi(var1, var2.a(), var2.b(), var2.c());
				var4.c = 1;
				return var4;
			}
		});
		class_ajm.N.a(Items.aR, new class_kg() {
			@Override
			protected class_zd a(class_ago var1, class_cz var2, class_aco var3) {
				return new class_zk(var1, var2.a(), var2.b(), var2.c());
			}
		});
		class_ajm.N.a(Items.aF, new class_kg() {
			@Override
			protected class_zd a(class_ago var1, class_cz var2, class_aco var3) {
				return new class_zh(var1, var2.a(), var2.b(), var2.c());
			}
		});
		class_ajm.N.a(Items.bP, new class_kg() {
			@Override
			protected class_zd a(class_ago var1, class_cz var2, class_aco var3) {
				return new class_zm(var1, var2.a(), var2.b(), var2.c());
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
		class_ajm.N.a(Items.bC, new class_cr() {
			@Override
			public class_aco a(class_ck var1, final class_aco var2) {
				return (new class_kg() {
					@Override
					protected class_zd a(class_ago var1, class_cz var2x, class_aco var3) {
						return new class_zn(var1, var2x.a(), var2x.b(), var2x.c(), var2.k(), false);
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
		class_ajm.N.a(Items.bD, new class_cr() {
			@Override
			public class_aco a(class_ck var1, final class_aco var2) {
				return (new class_kg() {
					@Override
					protected class_zd a(class_ago var1, class_cz var2x, class_aco var3) {
						return new class_zn(var1, var2x.a(), var2x.b(), var2x.c(), var2.k(), true);
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
		class_ajm.N.a(Items.bO, new class_cn() {
			@Override
			public class_aco b(class_ck var1, class_aco var2) {
				class_cq var3 = class_ajm.b(var1.f());
				double var4 = var1.a() + var3.g();
				double var6 = var1.d().o() + 0.2F;
				double var8 = var1.c() + var3.i();
				Entity var10 = class_ads.a(var1.i(), class_ads.h(var2), var4, var6, var8);
				if ((var10 instanceof class_rg) && var2.s()) {
					var10.c(var2.q());
				}

				class_ads.a(var1.i(), (class_yu) null, var2, var10);
				var2.a(1);
				return var2;
			}
		});
		class_ajm.N.a(Items.cg, new class_cn() {
			@Override
			public class_aco b(class_ck var1, class_aco var2) {
				class_cq var3 = class_ajm.b(var1.f());
				double var4 = var1.a() + var3.g();
				double var6 = var1.d().o() + 0.2F;
				double var8 = var1.c() + var3.i();
				class_zb var10 = new class_zb(var1.i(), var4, var6, var8, var2);
				var1.i().a(var10);
				var2.a(1);
				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				var1.i().b(1002, var1.d(), 0);
			}
		});
		class_ajm.N.a(Items.bQ, new class_cn() {
			@Override
			public class_aco b(class_ck var1, class_aco var2) {
				class_cq var3 = class_ajm.b(var1.f());
				class_cz var4 = class_ajm.a(var1);
				double var5 = var4.a() + var3.g() * 0.3F;
				double var7 = var4.b() + var3.h() * 0.3F;
				double var9 = var4.c() + var3.i() * 0.3F;
				class_ago var11 = var1.i();
				Random var12 = var11.s;
				double var13 = (var12.nextGaussian() * 0.05D) + var3.g();
				double var15 = (var12.nextGaussian() * 0.05D) + var3.h();
				double var17 = (var12.nextGaussian() * 0.05D) + var3.i();
				var11.a((new class_yy(var11, var5, var7, var9, var13, var15, var17)));
				var2.a(1);
				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				var1.i().b(1009, var1.d(), 0);
			}
		});
		class_ajm.N.a(Items.aG, new class_cn() {
			private final class_cn b = new class_cn();

			@Override
			public class_aco b(class_ck var1, class_aco var2) {
				class_cq var3 = class_ajm.b(var1.f());
				class_ago var4 = var1.i();
				double var5 = var1.a() + var3.g() * 1.125F;
				double var7 = var1.b() + var3.h() * 1.125F;
				double var9 = var1.c() + var3.i() * 1.125F;
				class_cj var11 = var1.d().a(var3);
				class_avq var12 = var4.p(var11).c().v();
				double var13;
				if (class_avq.h.equals(var12)) {
					var13 = 1.0D;
				} else {
					if (!class_avq.a.equals(var12) || !class_avq.h.equals(var4.p(var11.b()).c().v())) {
						return b.a(var1, var2);
					}

					var13 = 0.0D;
				}

				class_xe var15 = new class_xe(var4, var5, var7 + var13, var9);
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
			public class_aco b(class_ck var1, class_aco var2) {
				class_abi var3 = (class_abi) var2.b();
				class_cj var4 = var1.d().a(class_ajm.b(var1.f()));
				if (var3.a(var1.i(), var4)) {
					var2.a(Items.ay);
					var2.b = 1;
					return var2;
				} else {
					return b.a(var1, var2);
				}
			}
		};
		class_ajm.N.a(Items.aA, var0);
		class_ajm.N.a(Items.az, var0);
		class_ajm.N.a(Items.ay, new class_cn() {
			private final class_cn b = new class_cn();

			@Override
			public class_aco b(class_ck var1, class_aco var2) {
				class_ago var3 = var1.i();
				class_cj var4 = var1.d().a(class_ajm.b(var1.f()));
				class_apn var5 = var3.p(var4);
				Block var6 = var5.c();
				class_avq var7 = var6.v();
				Item var8;
				if (class_avq.h.equals(var7) && (var6 instanceof class_alf) && (((Integer) var5.b(class_alf.b)).intValue() == 0)) {
					var8 = Items.az;
				} else {
					if (!class_avq.i.equals(var7) || !(var6 instanceof class_alf) || (((Integer) var5.b(class_alf.b)).intValue() != 0)) {
						return super.b(var1, var2);
					}

					var8 = Items.aA;
				}

				var3.g(var4);
				if (--var2.b == 0) {
					var2.a(var8);
					var2.b = 1;
				} else if (((class_aoo) var1.h()).a(new class_aco(var8)) < 0) {
					b.a(var1, new class_aco(var8));
				}

				return var2;
			}
		});
		class_ajm.N.a(Items.d, new class_cn() {
			private boolean b = true;

			@Override
			protected class_aco b(class_ck var1, class_aco var2) {
				class_ago var3 = var1.i();
				class_cj var4 = var1.d().a(class_ajm.b(var1.f()));
				if (var3.d(var4)) {
					var3.a(var4, Blocks.ab.S());
					if (var2.a(1, var3.s)) {
						var2.b = 0;
					}
				} else if (var3.p(var4).c() == Blocks.W) {
					Blocks.W.e(var3, var4, Blocks.W.S().a(class_anq.a, Boolean.valueOf(true)));
					var3.g(var4);
				} else {
					b = false;
				}

				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				if (b) {
					var1.i().b(1000, var1.d(), 0);
				} else {
					var1.i().b(1001, var1.d(), 0);
				}

			}
		});
		class_ajm.N.a(Items.aY, new class_cn() {
			private boolean b = true;

			@Override
			protected class_aco b(class_ck var1, class_aco var2) {
				if (class_abt.a == class_abt.a(var2.i())) {
					class_ago var3 = var1.i();
					class_cj var4 = var1.d().a(class_ajm.b(var1.f()));
					if (class_abu.a(var2, var3, var4)) {
						if (!var3.D) {
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
				if (b) {
					var1.i().b(1000, var1.d(), 0);
				} else {
					var1.i().b(1001, var1.d(), 0);
				}

			}
		});
		class_ajm.N.a(Item.a(Blocks.W), new class_cn() {
			@Override
			protected class_aco b(class_ck var1, class_aco var2) {
				class_ago var3 = var1.i();
				class_cj var4 = var1.d().a(class_ajm.b(var1.f()));
				class_xq var5 = new class_xq(var3, var4.n() + 0.5D, var4.o(), var4.p() + 0.5D, (class_rg) null);
				var3.a(var5);
				var3.a(var5, "game.tnt.primed", 1.0F, 1.0F);
				--var2.b;
				return var2;
			}
		});
		class_ajm.N.a(Items.cc, new class_cn() {
			private boolean b = true;

			@Override
			protected class_aco b(class_ck var1, class_aco var2) {
				class_ago var3 = var1.i();
				class_cq var4 = class_ajm.b(var1.f());
				class_cj var5 = var1.d().a(var4);
				class_amx var6 = Blocks.ce;
				if (var3.d(var5) && var6.b(var3, var5, var2)) {
					if (!var3.D) {
						var3.a(var5, var6.S().a(class_amx.a, class_cq.b), 3);
						TileEntity var7 = var3.s(var5);
						if (var7 instanceof class_apa) {
							if (var2.i() == 3) {
								GameProfile var8 = null;
								if (var2.n()) {
									class_dn var9 = var2.o();
									if (var9.b("SkullOwner", 10)) {
										var8 = class_dy.a(var9.o("SkullOwner"));
									} else if (var9.b("SkullOwner", 8)) {
										String var10 = var9.l("SkullOwner");
										if (!class_of.b(var10)) {
											var8 = new GameProfile((UUID) null, var10);
										}
									}
								}

								((class_apa) var7).a(var8);
							} else {
								((class_apa) var7).a(var2.i());
							}

							((class_apa) var7).b(var4.d().b() * 4);
							Blocks.ce.a(var3, var5, (class_apa) var7);
						}

						--var2.b;
					}
				} else {
					b = false;
				}

				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				if (b) {
					var1.i().b(1000, var1.d(), 0);
				} else {
					var1.i().b(1001, var1.d(), 0);
				}

			}
		});
		class_ajm.N.a(Item.a(Blocks.aU), new class_cn() {
			private boolean b = true;

			@Override
			protected class_aco b(class_ck var1, class_aco var2) {
				class_ago var3 = var1.i();
				class_cj var4 = var1.d().a(class_ajm.b(var1.f()));
				class_amf var5 = (class_amf) Blocks.aU;
				if (var3.d(var4) && var5.d(var3, var4)) {
					if (!var3.D) {
						var3.a(var4, var5.S(), 3);
					}

					--var2.b;
				} else {
					b = false;
				}

				return var2;
			}

			@Override
			protected void a(class_ck var1) {
				if (b) {
					var1.i().b(1000, var1.d(), 0);
				} else {
					var1.i().b(1001, var1.d(), 0);
				}

			}
		});
	}

	public static void c() {
		if (!b) {
			b = true;
			if (c.isDebugEnabled()) {
				d();
			}

			Block.U();
			class_akd.l();
			class_qq.k();
			class_afj.e();
			Item.t();
			class_aec.c();
			class_aed.a();
			class_nh.a();
			b();
		}
	}

	private static void d() {
		System.setErr(new class_km("STDERR", System.err));
		System.setOut(new class_km("STDOUT", a));
	}

	static {
		a = System.out;
		b = false;
		c = LogManager.getLogger();
	}
}
