package net.minecraft.server;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class class_agk {
	private final boolean a;
	private final boolean b;
	private final Random c = new Random();
	private final class_ago d;
	private final double e;
	private final double f;
	private final double g;
	private final Entity h;
	private final float i;
	private final List j = Lists.newArrayList();
	private final Map k = Maps.newHashMap();

	public class_agk(class_ago var1, Entity var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11) {
		d = var1;
		h = var2;
		i = var9;
		e = var3;
		f = var5;
		g = var7;
		a = var10;
		b = var11;
	}

	public void a() {
		HashSet var1 = Sets.newHashSet();
		boolean var2 = true;

		int var4;
		int var5;
		for (int var3 = 0; var3 < 16; ++var3) {
			for (var4 = 0; var4 < 16; ++var4) {
				for (var5 = 0; var5 < 16; ++var5) {
					if ((var3 == 0) || (var3 == 15) || (var4 == 0) || (var4 == 15) || (var5 == 0) || (var5 == 15)) {
						double var6 = ((var3 / 15.0F) * 2.0F) - 1.0F;
						double var8 = ((var4 / 15.0F) * 2.0F) - 1.0F;
						double var10 = ((var5 / 15.0F) * 2.0F) - 1.0F;
						double var12 = Math.sqrt((var6 * var6) + (var8 * var8) + (var10 * var10));
						var6 /= var12;
						var8 /= var12;
						var10 /= var12;
						float var14 = i * (0.7F + (d.s.nextFloat() * 0.6F));
						double var15 = e;
						double var17 = f;
						double var19 = g;

						for (float var21 = 0.3F; var14 > 0.0F; var14 -= 0.22500001F) {
							class_cj var22 = new class_cj(var15, var17, var19);
							class_apn var23 = d.p(var22);
							if (var23.c().v() != class_avq.a) {
								float var24 = h != null ? h.a(this, d, var22, var23) : var23.c().a((Entity) null);
								var14 -= (var24 + 0.3F) * 0.3F;
							}

							if ((var14 > 0.0F) && ((h == null) || h.a(this, d, var22, var23, var14))) {
								var1.add(var22);
							}

							var15 += var6 * 0.30000001192092896D;
							var17 += var8 * 0.30000001192092896D;
							var19 += var10 * 0.30000001192092896D;
						}
					}
				}
			}
		}

		j.addAll(var1);
		float var30 = i * 2.0F;
		var4 = class_oa.c(e - var30 - 1.0D);
		var5 = class_oa.c(e + var30 + 1.0D);
		int var31 = class_oa.c(f - var30 - 1.0D);
		int var7 = class_oa.c(f + var30 + 1.0D);
		int var32 = class_oa.c(g - var30 - 1.0D);
		int var9 = class_oa.c(g + var30 + 1.0D);
		List var33 = d.b(h, new class_ayk(var4, var31, var32, var5, var7, var9));
		class_aym var11 = new class_aym(e, f, g);

		for (int var34 = 0; var34 < var33.size(); ++var34) {
			Entity var13 = (Entity) var33.get(var34);
			if (!var13.bb()) {
				double var35 = var13.f(e, f, g) / var30;
				if (var35 <= 1.0D) {
					double var16 = var13.s - e;
					double var18 = (var13.t + var13.aY()) - f;
					double var20 = var13.u - g;
					double var36 = class_oa.a((var16 * var16) + (var18 * var18) + (var20 * var20));
					if (var36 != 0.0D) {
						var16 /= var36;
						var18 /= var36;
						var20 /= var36;
						double var37 = d.a(var11, var13.aX());
						double var26 = (1.0D - var35) * var37;
						var13.a(class_qi.a(this), ((int) (((((var26 * var26) + var26) / 2.0D) * 8.0D * var30) + 1.0D)));
						double var28 = 1.0D;
						if (var13 instanceof class_rg) {
							var28 = class_aft.a((class_rg) var13, var26);
						}

						var13.v += var16 * var28;
						var13.w += var18 * var28;
						var13.x += var20 * var28;
						if ((var13 instanceof class_yu) && !((class_yu) var13).bI.a) {
							k.put(var13, new class_aym(var16 * var26, var18 * var26, var20 * var26));
						}
					}
				}
			}
		}

	}

	public void a(boolean var1) {
		d.a(e, f, g, "random.explode", 4.0F, (1.0F + ((d.s.nextFloat() - d.s.nextFloat()) * 0.2F)) * 0.7F);
		if ((i >= 2.0F) && b) {
			d.a(class_cy.c, e, f, g, 1.0D, 0.0D, 0.0D, new int[0]);
		} else {
			d.a(class_cy.b, e, f, g, 1.0D, 0.0D, 0.0D, new int[0]);
		}

		Iterator var2;
		class_cj var3;
		if (b) {
			var2 = j.iterator();

			while (var2.hasNext()) {
				var3 = (class_cj) var2.next();
				Block var4 = d.p(var3).c();
				if (var1) {
					double var5 = var3.n() + d.s.nextFloat();
					double var7 = var3.o() + d.s.nextFloat();
					double var9 = var3.p() + d.s.nextFloat();
					double var11 = var5 - e;
					double var13 = var7 - f;
					double var15 = var9 - g;
					double var17 = class_oa.a((var11 * var11) + (var13 * var13) + (var15 * var15));
					var11 /= var17;
					var13 /= var17;
					var15 /= var17;
					double var19 = 0.5D / ((var17 / i) + 0.1D);
					var19 *= (d.s.nextFloat() * d.s.nextFloat()) + 0.3F;
					var11 *= var19;
					var13 *= var19;
					var15 *= var19;
					d.a(class_cy.a, (var5 + (e * 1.0D)) / 2.0D, (var7 + (f * 1.0D)) / 2.0D, (var9 + (g * 1.0D)) / 2.0D, var11, var13, var15, new int[0]);
					d.a(class_cy.l, var5, var7, var9, var11, var13, var15, new int[0]);
				}

				if (var4.v() != class_avq.a) {
					if (var4.a(this)) {
						var4.a(d, var3, d.p(var3), 1.0F / i, 0);
					}

					d.a(var3, Blocks.a.S(), 3);
					var4.a(d, var3, this);
				}
			}
		}

		if (a) {
			var2 = j.iterator();

			while (var2.hasNext()) {
				var3 = (class_cj) var2.next();
				if ((d.p(var3).c().v() == class_avq.a) && d.p(var3.b()).c().q() && (c.nextInt(3) == 0)) {
					d.a(var3, Blocks.ab.S());
				}
			}
		}

	}

	public Map b() {
		return k;
	}

	public class_rg c() {
		return h == null ? null : (h instanceof class_xq ? ((class_xq) h).i() : (h instanceof class_rg ? (class_rg) h : null));
	}

	public void d() {
		j.clear();
	}

	public List e() {
		return j;
	}
}
