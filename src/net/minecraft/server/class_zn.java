package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class class_zn extends class_zj {
	private class_aco d;
	private boolean e;

	public class_zn(class_ago var1) {
		super(var1);
		d = class_adb.a(new class_aco(Items.bB), class_aee.a);
	}

	public class_zn(class_ago var1, class_rg var2, class_aco var3, boolean var4) {
		super(var1, var2);
		d = class_adb.a(new class_aco(Items.bB), class_aee.a);
		d = var3;
		e = var4;
	}

	public class_zn(class_ago var1, double var2, double var4, double var6, class_aco var8, boolean var9) {
		super(var1, var2, var4, var6);
		d = class_adb.a(new class_aco(Items.bB), class_aee.a);
		d = var8;
		e = var9;
	}

	@Override
	protected float i() {
		return 0.05F;
	}

	@Override
	protected void a(class_ayl var1) {
		if (!o.D) {
			PotionRegistry var2 = class_adb.i(d);
			List var3 = class_adb.h(d);
			if ((var1.a == class_ayl.class_a_in_class_ayl.b) && (var2 == class_aee.a) && var3.isEmpty()) {
				class_cj var17 = var1.a().a(var1.b);
				this.a(var17);
				Iterator var19 = class_cq.class_c_in_class_cq.a.iterator();

				while (var19.hasNext()) {
					class_cq var20 = (class_cq) var19.next();
					this.a(var17.a(var20));
				}

				o.b(2002, new class_cj(this), PotionRegistry.a(var2));
				L();
			} else {
				if (!var3.isEmpty()) {
					Iterator var6;
					class_rg var21;
					double var22;
					if (e) {
						List var4 = o.a(class_rg.class, aX().b(4.0D, 2.0D, 4.0D));
						class_qv var5 = new class_qv(o, s, t, u);
						var5.a(this.j());
						var5.a(3.0F);
						var5.b(-0.5F);
						var5.c(10);
						var5.c(-var5.i() / var5.n());
						var6 = var3.iterator();

						while (var6.hasNext()) {
							class_qr var7 = (class_qr) var6.next();
							class_qr var8 = new class_qr(var7.a(), var7.b() / 4, var7.c());
							var5.a(var8);
						}

						if (!var4.isEmpty()) {
							var6 = var4.iterator();

							while (var6.hasNext()) {
								var21 = (class_rg) var6.next();
								var22 = this.h(var21);
								if (var22 < 16.0D) {
									var5.b(var21.s, var21.t, var21.u);
									break;
								}
							}
						}

						o.a(var5);
					} else {
						class_ayk var16 = aX().b(4.0D, 2.0D, 4.0D);
						List var18 = o.a(class_rg.class, var16);
						if (!var18.isEmpty()) {
							var6 = var18.iterator();

							label67: while (true) {
								do {
									if (!var6.hasNext()) {
										break label67;
									}

									var21 = (class_rg) var6.next();
									var22 = this.h(var21);
								} while (var22 >= 16.0D);

								double var10 = 1.0D - (Math.sqrt(var22) / 4.0D);
								if (var21 == var1.d) {
									var10 = 1.0D;
								}

								Iterator var12 = var3.iterator();

								while (var12.hasNext()) {
									class_qr var13 = (class_qr) var12.next();
									class_qq var14 = var13.a();
									if (var14.b()) {
										var14.a(this, this.j(), var21, var13.c(), var10);
									} else {
										int var15 = (int) ((var10 * var13.b()) + 0.5D);
										if (var15 > 20) {
											var21.c(new class_qr(var14, var15, var13.c()));
										}
									}
								}
							}
						}
					}
				}

				o.b(2002, new class_cj(this), PotionRegistry.a(var2));
				L();
			}
		}
	}

	private void a(class_cj var1) {
		if (o.p(var1).c() == Blocks.FIRE) {
			o.a(var1, Blocks.AIR.S(), 2);
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		d = class_aco.a(var1.o("Potion"));
		e = var1.p("Linger");
		if (d == null) {
			L();
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		if (d != null) {
			var1.a("Potion", d.b(new class_dn()));
		}

		var1.a("Linger", e);
	}

	public class_aco k() {
		return d;
	}
}
