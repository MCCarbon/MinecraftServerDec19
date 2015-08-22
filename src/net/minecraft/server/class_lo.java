package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Sets;

public class class_lo {
	private static final Logger p = LogManager.getLogger();
	public class_qx a;
	public int b;
	public int c;
	public int d;
	public int e;
	public int f;
	public int g;
	public int h;
	public int i;
	public double j;
	public double k;
	public double l;
	public int m;
	private double q;
	private double r;
	private double s;
	private boolean t;
	private boolean u;
	private int v;
	private class_qx w;
	private boolean x;
	private boolean y;
	public boolean n;
	public Set o = Sets.newHashSet();

	public class_lo(class_qx var1, int var2, int var3, boolean var4) {
		a = var1;
		b = var2;
		c = var3;
		u = var4;
		d = class_oa.c(var1.s * 32.0D);
		e = class_oa.c(var1.t * 32.0D);
		f = class_oa.c(var1.u * 32.0D);
		g = class_oa.d((var1.y * 256.0F) / 360.0F);
		h = class_oa.d((var1.z * 256.0F) / 360.0F);
		i = class_oa.d((var1.aI() * 256.0F) / 360.0F);
		y = var1.C;
	}

	@Override
	public boolean equals(Object var1) {
		return var1 instanceof class_lo ? ((class_lo) var1).a.G() == a.G() : false;
	}

	@Override
	public int hashCode() {
		return a.G();
	}

	public void a(List var1) {
		n = false;
		if (!t || (a.e(q, r, s) > 16.0D)) {
			q = a.s;
			r = a.t;
			s = a.u;
			t = true;
			n = true;
			this.b(var1);
		}

		if ((w != a.m) || ((a.m != null) && ((m % 60) == 0))) {
			w = a.m;
			this.a((new class_hm(0, a, a.m)));
		}

		if ((a instanceof class_wu) && ((m % 10) == 0)) {
			class_wu var2 = (class_wu) a;
			class_aco var3 = var2.n();
			if ((var3 != null) && (var3.b() instanceof class_acu)) {
				class_axl var4 = class_acq.bf.a(var3, a.o);
				Iterator var5 = var1.iterator();

				while (var5.hasNext()) {
					class_yu var6 = (class_yu) var5.next();
					class_lm var7 = (class_lm) var6;
					var4.a(var7, var3);
					class_ff var8 = class_acq.bf.a(var3, a.o, var7);
					if (var8 != null) {
						var7.a.a(var8);
					}
				}
			}

			this.b();
		}

		if (((m % c) == 0) || a.ai || a.J().a()) {
			int var23;
			int var24;
			if (a.m == null) {
				++v;
				var23 = class_oa.c(a.s * 32.0D);
				var24 = class_oa.c(a.t * 32.0D);
				int var26 = class_oa.c(a.u * 32.0D);
				int var27 = class_oa.d((a.y * 256.0F) / 360.0F);
				int var28 = class_oa.d((a.z * 256.0F) / 360.0F);
				int var29 = var23 - d;
				int var30 = var24 - e;
				int var9 = var26 - f;
				Object var10 = null;
				boolean var11 = (Math.abs(var29) >= 4) || (Math.abs(var30) >= 4) || (Math.abs(var9) >= 4) || ((m % 60) == 0);
				boolean var12 = (Math.abs(var27 - g) >= 4) || (Math.abs(var28 - h) >= 4);
				if ((m > 0) || (a instanceof class_yx)) {
					if ((var29 >= -128) && (var29 < 128) && (var30 >= -128) && (var30 < 128) && (var9 >= -128) && (var9 < 128) && (v <= 400) && !x && (y == a.C)) {
						if ((!var11 || !var12) && !(a instanceof class_yx)) {
							if (var11) {
								var10 = new class_gw.class_a_in_class_gw(a.G(), (byte) var29, (byte) var30, (byte) var9, a.C);
							} else if (var12) {
								var10 = new class_gw.class_c_in_class_gw(a.G(), (byte) var27, (byte) var28, a.C);
							}
						} else {
							var10 = new class_gw.class_b_in_class_gw(a.G(), (byte) var29, (byte) var30, (byte) var9, (byte) var27, (byte) var28, a.C);
						}
					} else {
						y = a.C;
						v = 0;
						var10 = new class_ia(a.G(), var23, var24, var26, (byte) var27, (byte) var28, a.C);
					}
				}

				if (u) {
					double var13 = a.v - j;
					double var15 = a.w - k;
					double var17 = a.x - l;
					double var19 = 0.02D;
					double var21 = (var13 * var13) + (var15 * var15) + (var17 * var17);
					if ((var21 > (var19 * var19)) || ((var21 > 0.0D) && (a.v == 0.0D) && (a.w == 0.0D) && (a.x == 0.0D))) {
						j = a.v;
						k = a.w;
						l = a.x;
						this.a((new class_hn(a.G(), j, k, l)));
					}
				}

				if (var10 != null) {
					this.a((class_ff) var10);
				}

				this.b();
				if (var11) {
					d = var23;
					e = var24;
					f = var26;
				}

				if (var12) {
					g = var27;
					h = var28;
				}

				x = false;
			} else {
				var23 = class_oa.d((a.y * 256.0F) / 360.0F);
				var24 = class_oa.d((a.z * 256.0F) / 360.0F);
				boolean var25 = (Math.abs(var23 - g) >= 4) || (Math.abs(var24 - h) >= 4);
				if (var25) {
					this.a((new class_gw.class_c_in_class_gw(a.G(), (byte) var23, (byte) var24, a.C)));
					g = var23;
					h = var24;
				}

				d = class_oa.c(a.s * 32.0D);
				e = class_oa.c(a.t * 32.0D);
				f = class_oa.c(a.u * 32.0D);
				this.b();
				x = true;
			}

			var23 = class_oa.d((a.aI() * 256.0F) / 360.0F);
			if (Math.abs(var23 - i) >= 4) {
				this.a((new class_hg(a, (byte) var23)));
				i = var23;
			}

			a.ai = false;
		}

		++m;
		if (a.G) {
			this.b((new class_hn(a)));
			a.G = false;
		}

	}

	private void b() {
		class_kc var1 = a.J();
		if (var1.a()) {
			this.b((new class_hl(a.G(), var1, false)));
		}

		if (a instanceof class_rg) {
			class_rw var2 = (class_rw) ((class_rg) a).bE();
			Set var3 = var2.b();
			if (!var3.isEmpty()) {
				this.b((new class_ib(a.G(), var3)));
			}

			var3.clear();
		}

	}

	public void a(class_ff var1) {
		Iterator var2 = o.iterator();

		while (var2.hasNext()) {
			class_lm var3 = (class_lm) var2.next();
			var3.a.a(var1);
		}

	}

	public void b(class_ff var1) {
		this.a(var1);
		if (a instanceof class_lm) {
			((class_lm) a).a.a(var1);
		}

	}

	public void a() {
		Iterator var1 = o.iterator();

		while (var1.hasNext()) {
			class_lm var2 = (class_lm) var1.next();
			a.c(var2);
			var2.d(a);
		}

	}

	public void a(class_lm var1) {
		if (o.contains(var1)) {
			a.c(var1);
			var1.d(a);
			o.remove(var1);
		}

	}

	public void b(class_lm var1) {
		if (var1 != a) {
			if (this.c(var1)) {
				if (!o.contains(var1) && (e(var1) || a.n)) {
					o.add(var1);
					class_ff var2 = this.c();
					var1.a.a(var2);
					if (!a.J().d()) {
						var1.a.a((new class_hl(a.G(), a.J(), true)));
					}

					if (a instanceof class_rg) {
						class_rw var3 = (class_rw) ((class_rg) a).bE();
						Collection var4 = var3.c();
						if (!var4.isEmpty()) {
							var1.a.a((new class_ib(a.G(), var4)));
						}
					}

					j = a.v;
					k = a.w;
					l = a.x;
					if (u && !(var2 instanceof class_fn)) {
						var1.a.a((new class_hn(a.G(), a.v, a.w, a.x)));
					}

					if (a.m != null) {
						var1.a.a((new class_hm(0, a, a.m)));
					}

					if ((a instanceof class_rh) && (((class_rh) a).cv() != null)) {
						var1.a.a((new class_hm(1, a, ((class_rh) a).cv())));
					}

					if (a instanceof class_rg) {
						class_rc[] var8 = class_rc.values();
						int var11 = var8.length;

						for (int var5 = 0; var5 < var11; ++var5) {
							class_rc var6 = var8[var5];
							class_aco var7 = ((class_rg) a).a(var6);
							if (var7 != null) {
								var1.a.a((new class_ho(a.G(), var6, var7)));
							}
						}
					}

					if (a instanceof class_yu) {
						class_yu var9 = (class_yu) a;
						if (var9.bQ()) {
							var1.a.a((new class_hb(var9, new class_cj(a))));
						}
					}

					if (a instanceof class_rg) {
						class_rg var10 = (class_rg) a;
						Iterator var12 = var10.bs().iterator();

						while (var12.hasNext()) {
							class_qr var13 = (class_qr) var12.next();
							var1.a.a((new class_ic(a.G(), var13)));
						}
					}

					a.b(var1);
				}
			} else if (o.contains(var1)) {
				o.remove(var1);
				a.c(var1);
				var1.d(a);
			}

		}
	}

	public boolean c(class_lm var1) {
		double var2 = var1.s - d / 32;
		double var4 = var1.u - f / 32;
		return (var2 >= (-b)) && (var2 <= b) && (var4 >= (-b)) && (var4 <= b) && a.a(var1);
	}

	private boolean e(class_lm var1) {
		return var1.v().v().a(var1, a.ae, a.ag);
	}

	public void b(List var1) {
		for (int var2 = 0; var2 < var1.size(); ++var2) {
			this.b((class_lm) var1.get(var2));
		}

	}

	private class_ff c() {
		if (a.I) {
			p.warn("Fetching addPacket for removed entity");
		}

		if (a instanceof class_xg) {
			return new class_fk(a, 2, 1);
		} else if (a instanceof class_lm) {
			return new class_fp((class_yu) a);
		} else if (a instanceof class_xh) {
			class_xh var11 = (class_xh) a;
			return new class_fk(a, 10, var11.s().a());
		} else if (a instanceof class_xe) {
			return new class_fk(a, 1);
		} else if (a instanceof class_qw) {
			i = class_oa.d((a.aI() * 256.0F) / 360.0F);
			return new class_fn((class_rg) a);
		} else if (a instanceof class_wy) {
			class_yu var9 = ((class_wy) a).b;
			return new class_fk(a, 90, var9 != null ? var9.G() : a.G());
		} else {
			class_qx var8;
			if (a instanceof class_zi) {
				var8 = ((class_zi) a).e;
				return new class_fk(a, 91, var8 != null ? var8.G() : a.G());
			} else if (a instanceof class_zo) {
				var8 = ((class_zo) a).e;
				return new class_fk(a, 92, var8 != null ? var8.G() : a.G());
			} else if (a instanceof class_yx) {
				var8 = ((class_yx) a).e;
				return new class_fk(a, 60, var8 != null ? var8.G() : a.G());
			} else if (a instanceof class_zh) {
				return new class_fk(a, 61);
			} else if (a instanceof class_zn) {
				return new class_fk(a, 73, class_aec.a(class_adb.i(((class_zn) a).k())));
			} else if (a instanceof class_zm) {
				return new class_fk(a, 75);
			} else if (a instanceof class_zl) {
				return new class_fk(a, 65);
			} else if (a instanceof class_yz) {
				return new class_fk(a, 72);
			} else if (a instanceof class_zb) {
				return new class_fk(a, 76);
			} else {
				class_fk var2;
				if (a instanceof class_za) {
					class_za var7 = (class_za) a;
					var2 = null;
					byte var10 = 63;
					if (a instanceof class_zg) {
						var10 = 64;
					} else if (a instanceof class_yy) {
						var10 = 93;
					} else if (a instanceof class_zp) {
						var10 = 66;
					}

					if (var7.b != null) {
						var2 = new class_fk(a, var10, ((class_za) a).b.G());
					} else {
						var2 = new class_fk(a, var10, 0);
					}

					var2.d((int) (var7.c * 8000.0D));
					var2.e((int) (var7.d * 8000.0D));
					var2.f((int) (var7.e * 8000.0D));
					return var2;
				} else if (a instanceof class_zf) {
					class_fk var6 = new class_fk(a, 67, 0);
					var6.d((int) (a.v * 8000.0D));
					var6.e((int) (a.w * 8000.0D));
					var6.f((int) (a.x * 8000.0D));
					return var6;
				} else if (a instanceof class_zk) {
					return new class_fk(a, 62);
				} else if (a instanceof class_xq) {
					return new class_fk(a, 50);
				} else if (a instanceof class_vw) {
					return new class_fk(a, 51);
				} else if (a instanceof class_xf) {
					class_xf var5 = (class_xf) a;
					return new class_fk(a, 70, class_ail.f(var5.j()));
				} else if (a instanceof class_ws) {
					return new class_fk(a, 78);
				} else if (a instanceof class_ww) {
					return new class_fo((class_ww) a);
				} else {
					class_cj var3;
					if (a instanceof class_wu) {
						class_wu var4 = (class_wu) a;
						var2 = new class_fk(a, 71, var4.b.b());
						var3 = var4.m();
						var2.a(class_oa.d((float) (var3.n() * 32)));
						var2.b(class_oa.d((float) (var3.o() * 32)));
						var2.c(class_oa.d((float) (var3.p() * 32)));
						return var2;
					} else if (a instanceof class_wv) {
						class_wv var1 = (class_wv) a;
						var2 = new class_fk(a, 77);
						var3 = var1.m();
						var2.a(class_oa.d((float) (var3.n() * 32)));
						var2.b(class_oa.d((float) (var3.o() * 32)));
						var2.c(class_oa.d((float) (var3.p() * 32)));
						return var2;
					} else if (a instanceof class_rd) {
						return new class_fl((class_rd) a);
					} else if (a instanceof class_qv) {
						return new class_fk(a, 3);
					} else {
						throw new IllegalArgumentException("Don\'t know how to add " + a.getClass() + "!");
					}
				}
			}
		}
	}

	public void d(class_lm var1) {
		if (o.contains(var1)) {
			o.remove(var1);
			a.c(var1);
			var1.d(a);
		}

	}
}
