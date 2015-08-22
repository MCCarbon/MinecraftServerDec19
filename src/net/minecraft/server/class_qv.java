package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_qv extends class_qx {
	private static final class_jz a;
	private static final class_jz b;
	private static final class_jz c;
	private static final class_jz d;
	private final List e = Lists.newArrayList();
	private final Map f = Maps.newHashMap();
	private int g = 600;
	private int h = 20;
	private int i = 20;
	private boolean as;
	private float at;
	private float au;
	private float av;
	private class_rg aw;
	private UUID ax;

	public class_qv(class_ago var1) {
		super(var1);
		T = true;
		this.a(3.0F);
	}

	public class_qv(class_ago var1, double var2, double var4, double var6) {
		super(var1);
		T = true;
		this.a(3.0F);
		this.b(var2, var4, var6);
	}

	@Override
	protected void h() {
		J().a(b, Integer.valueOf(0));
		J().a(a, Float.valueOf(0.5F));
		J().a(c, Boolean.valueOf(false));
		J().a(d, Integer.valueOf(class_cy.p.c()));
	}

	public void a(float var1) {
		double var2 = s;
		double var4 = t;
		double var6 = u;
		this.a(var1 * 2.0F, 0.5F);
		this.b(var2, var4, var6);
		if (!o.D) {
			J().b(a, Float.valueOf(var1));
		}

	}

	public float i() {
		return ((Float) J().a(a)).floatValue();
	}

	public void a(class_qr var1) {
		e.add(var1);
		if (!as) {
			J().b(b, Integer.valueOf(class_adb.a(e)));
		}

	}

	public int j() {
		return ((Integer) J().a(b)).intValue();
	}

	public void a(int var1) {
		as = true;
		J().b(b, Integer.valueOf(var1));
	}

	public class_cy k() {
		return class_cy.a(((Integer) J().a(d)).intValue());
	}

	public void a(class_cy var1) {
		J().b(d, Integer.valueOf(var1.c()));
	}

	protected void a(boolean var1) {
		J().b(c, Boolean.valueOf(var1));
	}

	public boolean m() {
		return ((Boolean) J().a(c)).booleanValue();
	}

	public int n() {
		return g;
	}

	public void b(int var1) {
		g = var1;
	}

	@Override
	public void r_() {
		super.r_();
		boolean var1 = this.m();
		float var2 = this.i();
		if (o.D) {
			class_cy var3 = this.k();
			float var6;
			float var7;
			float var8;
			int var10;
			int var11;
			int var12;
			if (var1) {
				if (V.nextBoolean()) {
					for (int var4 = 0; var4 < 2; ++var4) {
						float var5 = V.nextFloat() * 6.2831855F;
						var6 = class_oa.c(V.nextFloat()) * 0.2F;
						var7 = class_oa.b(var5) * var6;
						var8 = class_oa.a(var5) * var6;
						if (var3 == class_cy.p) {
							int var9 = V.nextBoolean() ? 16777215 : this.j();
							var10 = (var9 >> 16) & 255;
							var11 = (var9 >> 8) & 255;
							var12 = var9 & 255;
							o.a(class_cy.p, s + var7, t, u + var8, var10 / 255.0F, var11 / 255.0F, var12 / 255.0F, new int[0]);
						} else {
							o.a(var3, s + var7, t, u + var8, 0.0D, 0.0D, 0.0D, new int[0]);
						}
					}
				}
			} else {
				float var16 = 3.1415927F * var2 * var2;

				for (int var18 = 0; var18 < var16; ++var18) {
					var6 = V.nextFloat() * 6.2831855F;
					var7 = class_oa.c(V.nextFloat()) * var2;
					var8 = class_oa.b(var6) * var7;
					float var24 = class_oa.a(var6) * var7;
					if (var3 == class_cy.p) {
						var10 = this.j();
						var11 = (var10 >> 16) & 255;
						var12 = (var10 >> 8) & 255;
						int var13 = var10 & 255;
						o.a(class_cy.p, s + var8, t, u + var24, var11 / 255.0F, var12 / 255.0F, var13 / 255.0F, new int[0]);
					} else {
						o.a(var3, s + var8, t, u + var24, (0.5D - V.nextDouble()) * 0.15D, 0.009999999776482582D, (0.5D - V.nextDouble()) * 0.15D, new int[0]);
					}
				}
			}
		} else {
			if (W >= (h + g)) {
				L();
				return;
			}

			boolean var15 = W < h;
			if (var1 != var15) {
				this.a(var15);
			}

			if (var15) {
				return;
			}

			if (av != 0.0F) {
				var2 += av;
				if (var2 < 0.5F) {
					L();
					return;
				}

				this.a(var2);
			}

			if ((W % 5) == 0) {
				Iterator var17 = f.entrySet().iterator();

				while (var17.hasNext()) {
					Entry var20 = (Entry) var17.next();
					if (W >= ((Integer) var20.getValue()).intValue()) {
						var17.remove();
					}
				}

				if (e.isEmpty()) {
					f.clear();
				} else {
					List var19 = o.a(class_rg.class, aX());
					if (!var19.isEmpty()) {
						Iterator var21 = var19.iterator();

						while (true) {
							class_rg var22;
							double var26;
							do {
								do {
									if (!var21.hasNext()) {
										return;
									}

									var22 = (class_rg) var21.next();
								} while (f.containsKey(var22));

								double var23 = var22.s - s;
								double var25 = var22.u - u;
								var26 = (var23 * var23) + (var25 * var25);
							} while (var26 > var2 * var2);

							f.put(var22, Integer.valueOf(W + i));
							Iterator var27 = e.iterator();

							while (var27.hasNext()) {
								class_qr var14 = (class_qr) var27.next();
								if (var14.a().b()) {
									var14.a().a(this, s(), var22, var14.c(), 0.5D);
								} else {
									var22.c(new class_qr(var14));
								}
							}

							if (au != 0.0F) {
								var2 += au;
								if (var2 < 0.5F) {
									L();
									return;
								}

								this.a(var2);
							}
						}
					}
				}
			}
		}

	}

	public void b(float var1) {
		au = var1;
	}

	public void c(float var1) {
		av = var1;
	}

	public void c(int var1) {
		h = var1;
	}

	public void a(class_rg var1) {
		aw = var1;
		ax = var1 == null ? null : var1.aQ();
	}

	public class_rg s() {
		if ((aw == null) && (ax != null) && (o instanceof class_ll)) {
			class_qx var1 = ((class_ll) o).a(ax);
			if (var1 instanceof class_rg) {
				aw = (class_rg) var1;
			}
		}

		return aw;
	}

	@Override
	protected void a(class_dn var1) {
		W = var1.h("Age");
		g = var1.h("Duration");
		h = var1.h("WaitTime");
		i = var1.h("ReapplicationDelay");
		at = var1.j("DurationOnUse");
		au = var1.j("RadiusOnUse");
		av = var1.j("RadiusPerTick");
		this.a(var1.j("Radius"));
		ax = var1.a("OwnerUUID");
		if (var1.b("Particle", 8)) {
			String var2 = var1.l("Particle");
			class_cy[] var3 = class_cy.values();
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				class_cy var6 = var3[var5];
				if (var6.b().equals(var2)) {
					this.a(var6);
					break;
				}
			}
		}

		if (var1.b("Color", 99)) {
			this.a(var1.h("Color"));
		}

		if (var1.b("Effects", 9)) {
			class_du var7 = var1.c("Effects", 10);
			e.clear();

			for (int var8 = 0; var8 < var7.c(); ++var8) {
				class_qr var9 = class_qr.b(var7.b(var8));
				if (var9 != null) {
					this.a(var9);
				}
			}
		}

	}

	@Override
	protected void b(class_dn var1) {
		var1.a("Age", W);
		var1.a("Duration", g);
		var1.a("WaitTime", h);
		var1.a("ReapplicationDelay", i);
		var1.a("DurationOnUse", at);
		var1.a("RadiusOnUse", au);
		var1.a("RadiusPerTick", av);
		var1.a("Radius", this.i());
		var1.a("Particle", this.k().b());
		if (ax != null) {
			var1.a("OwnerUUID", ax);
		}

		if (as) {
			var1.a("Color", this.j());
		}

		if (!e.isEmpty()) {
			class_du var2 = new class_du();
			Iterator var3 = e.iterator();

			while (var3.hasNext()) {
				class_qr var4 = (class_qr) var3.next();
				var2.a(var4.a(new class_dn()));
			}

			var1.a("Effects", var2);
		}

	}

	@Override
	public void a(class_jz var1) {
		if (var1 == a) {
			this.a(this.i());
		}

		super.a(var1);
	}

	static {
		a = class_kc.a(class_qv.class, class_kb.c);
		b = class_kc.a(class_qv.class, class_kb.b);
		c = class_kc.a(class_qv.class, class_kb.g);
		d = class_kc.a(class_qv.class, class_kb.b);
	}
}
