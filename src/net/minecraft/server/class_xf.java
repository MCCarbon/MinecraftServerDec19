package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.common.collect.Lists;

public class class_xf extends Entity {
	private class_apn d;
	public int a;
	public boolean b = true;
	private boolean e;
	private boolean f;
	private int g = 40;
	private float h = 2.0F;
	public class_dn c;

	public class_xf(class_ago var1) {
		super(var1);
	}

	public class_xf(class_ago var1, double var2, double var4, double var6, class_apn var8) {
		super(var1);
		d = var8;
		k = true;
		this.a(0.98F, 0.98F);
		this.b(var2, var4, var6);
		v = 0.0D;
		w = 0.0D;
		x = 0.0D;
		p = var2;
		q = var4;
		r = var6;
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	protected void h() {
	}

	@Override
	public boolean ag() {
		return !I;
	}

	@Override
	public void r_() {
		Block var1 = d.c();
		if (var1.v() == class_avq.a) {
			L();
		} else {
			p = s;
			q = t;
			r = u;
			class_cj var2;
			if (a++ == 0) {
				var2 = new class_cj(this);
				if (o.p(var2).c() == var1) {
					o.g(var2);
				} else if (!o.D) {
					L();
					return;
				}
			}

			w -= 0.03999999910593033D;
			this.d(v, w, x);
			v *= 0.9800000190734863D;
			w *= 0.9800000190734863D;
			x *= 0.9800000190734863D;
			if (!o.D) {
				var2 = new class_cj(this);
				if (C) {
					v *= 0.699999988079071D;
					x *= 0.699999988079071D;
					w *= -0.5D;
					if (o.p(var2).c() != Blocks.PISTON_EXTENSION) {
						L();
						if (!e) {
							if (o.a(var1, var2, true, class_cq.b, (Entity) null, (class_aco) null) && !class_ajz.d(o, var2.b()) && o.a(var2, d, 3)) {
								if (var1 instanceof class_ajz) {
									((class_ajz) var1).a_(o, var2);
								}

								if ((c != null) && (var1 instanceof class_ajy)) {
									TileEntity var3 = o.s(var2);
									if (var3 != null) {
										class_dn var4 = new class_dn();
										var3.b(var4);
										Iterator var5 = c.c().iterator();

										while (var5.hasNext()) {
											String var6 = (String) var5.next();
											class_eb var7 = c.c(var6);
											if (!var6.equals("x") && !var6.equals("y") && !var6.equals("z")) {
												var4.a(var6, var7.b());
											}
										}

										var3.a(var4);
										var3.o_();
									}
								}
							} else if (b && o.S().b("doEntityDrops")) {
								this.a(new class_aco(var1, 1, var1.a(d)), 0.0F);
							}
						}
					}
				} else if (((a > 100) && !o.D && ((var2.o() < 1) || (var2.o() > 256))) || (a > 600)) {
					if (b && o.S().b("doEntityDrops")) {
						this.a(new class_aco(var1, 1, var1.a(d)), 0.0F);
					}

					L();
				}
			}

		}
	}

	@Override
	public void e(float var1, float var2) {
		Block var3 = d.c();
		if (f) {
			int var4 = class_oa.f(var1 - 1.0F);
			if (var4 > 0) {
				ArrayList var5 = Lists.newArrayList((Iterable) o.b(this, aX()));
				boolean var6 = var3 == Blocks.ANVIL;
				class_qi var7 = var6 ? class_qi.n : class_qi.o;
				Iterator var8 = var5.iterator();

				while (var8.hasNext()) {
					Entity var9 = (Entity) var8.next();
					var9.a(var7, Math.min(class_oa.d(var4 * h), g));
				}

				if (var6 && (V.nextFloat() < (0.05000000074505806D + (var4 * 0.05D)))) {
					int var10 = ((Integer) d.b(class_aic.b)).intValue();
					++var10;
					if (var10 > 2) {
						e = true;
					} else {
						d = d.a(class_aic.b, Integer.valueOf(var10));
					}
				}
			}
		}

	}

	@Override
	protected void b(class_dn var1) {
		Block var2 = d != null ? d.c() : Blocks.AIR;
		class_ke var3 = (class_ke) Block.c.b(var2);
		var1.a("Block", var3 == null ? "" : var3.toString());
		var1.a("Data", (byte) var2.c(d));
		var1.a("Time", (byte) a);
		var1.a("DropItem", b);
		var1.a("HurtEntities", f);
		var1.a("FallHurtAmount", h);
		var1.a("FallHurtMax", g);
		if (c != null) {
			var1.a("TileEntityData", c);
		}

	}

	@Override
	protected void a(class_dn var1) {
		int var2 = var1.f("Data") & 255;
		if (var1.b("Block", 8)) {
			d = Block.b(var1.l("Block")).a(var2);
		} else if (var1.b("TileID", 99)) {
			d = Block.c(var1.h("TileID")).a(var2);
		} else {
			d = Block.c(var1.f("Tile") & 255).a(var2);
		}

		a = var1.f("Time") & 255;
		Block var3 = d.c();
		if (var1.b("HurtEntities", 99)) {
			f = var1.p("HurtEntities");
			h = var1.j("FallHurtAmount");
			g = var1.h("FallHurtMax");
		} else if (var3 == Blocks.ANVIL) {
			f = true;
		}

		if (var1.b("DropItem", 99)) {
			b = var1.p("DropItem");
		}

		if (var1.b("TileEntityData", 10)) {
			c = var1.o("TileEntityData");
		}

		if ((var3 == null) || (var3.v() == class_avq.a)) {
			d = Blocks.SAND.S();
		}

	}

	public void a(boolean var1) {
		f = var1;
	}

	@Override
	public void a(class_c var1) {
		super.a(var1);
		if (d != null) {
			Block var2 = d.c();
			var1.a("Immitating block ID", Integer.valueOf(Block.a(var2)));
			var1.a("Immitating block data", Integer.valueOf(var2.c(d)));
		}

	}

	public class_apn j() {
		return d;
	}

	@Override
	public boolean bc() {
		return true;
	}
}
