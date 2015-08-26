package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_axl extends class_axj {
	public int b;
	public int c;
	public byte d;
	public boolean e;
	public byte f;
	public byte[] g = new byte[16384];
	public List h = Lists.newArrayList();
	private Map j = Maps.newHashMap();
	public Map i = Maps.newLinkedHashMap();

	public class_axl(String var1) {
		super(var1);
	}

	public void a(double var1, double var3, int var5) {
		int var6 = 128 * (1 << var5);
		int var7 = MathHelper.c((var1 + 64.0D) / var6);
		int var8 = MathHelper.c((var3 + 64.0D) / var6);
		b = ((var7 * var6) + (var6 / 2)) - 64;
		c = ((var8 * var6) + (var6 / 2)) - 64;
	}

	@Override
	public void a(class_dn var1) {
		d = var1.f("dimension");
		b = var1.h("xCenter");
		c = var1.h("zCenter");
		f = var1.f("scale");
		f = (byte) MathHelper.a(f, 0, 4);
		if (var1.b("trackingPosition", 1)) {
			e = var1.p("trackingPosition");
		} else {
			e = true;
		}

		short var2 = var1.g("width");
		short var3 = var1.g("height");
		if ((var2 == 128) && (var3 == 128)) {
			g = var1.m("colors");
		} else {
			byte[] var4 = var1.m("colors");
			g = new byte[16384];
			int var5 = (128 - var2) / 2;
			int var6 = (128 - var3) / 2;

			for (int var7 = 0; var7 < var3; ++var7) {
				int var8 = var7 + var6;
				if ((var8 >= 0) || (var8 < 128)) {
					for (int var9 = 0; var9 < var2; ++var9) {
						int var10 = var9 + var5;
						if ((var10 >= 0) || (var10 < 128)) {
							g[var10 + (var8 * 128)] = var4[var9 + (var7 * var2)];
						}
					}
				}
			}
		}

	}

	@Override
	public void b(class_dn var1) {
		var1.a("dimension", d);
		var1.a("xCenter", b);
		var1.a("zCenter", c);
		var1.a("scale", f);
		var1.a("width", (short) 128);
		var1.a("height", (short) 128);
		var1.a("colors", g);
		var1.a("trackingPosition", e);
	}

	public void a(class_yu var1, class_aco var2) {
		if (!j.containsKey(var1)) {
			class_axl.class_a_in_class_axl var3 = new class_axl.class_a_in_class_axl(var1);
			j.put(var1, var3);
			h.add(var3);
		}

		if (!var1.bq.c(var2)) {
			i.remove(var1.e_());
		}

		for (int var6 = 0; var6 < h.size(); ++var6) {
			class_axl.class_a_in_class_axl var4 = (class_axl.class_a_in_class_axl) h.get(var6);
			if (var4.a.I || (!var4.a.bq.c(var2) && !var2.y())) {
				j.remove(var4.a);
				h.remove(var4);
			} else if (!var2.y() && (var4.a.am == d) && e) {
				this.a(0, var4.a.o, var4.a.e_(), var4.a.s, var4.a.u, var4.a.y);
			}
		}

		if (var2.y() && e) {
			class_wu var7 = var2.z();
			class_cj var8 = var7.m();
			this.a(1, var1.o, "frame-" + var7.G(), var8.n(), var8.p(), var7.b.b() * 90);
		}

		if (var2.n() && var2.o().b("Decorations", 9)) {
			class_du var9 = var2.o().c("Decorations", 10);

			for (int var10 = 0; var10 < var9.c(); ++var10) {
				class_dn var5 = var9.b(var10);
				if (!i.containsKey(var5.l("id"))) {
					this.a(var5.f("type"), var1.o, var5.l("id"), var5.k("x"), var5.k("z"), var5.k("rot"));
				}
			}
		}

	}

	private void a(int var1, class_ago var2, String var3, double var4, double var6, double var8) {
		int var10 = 1 << f;
		float var11 = (float) (var4 - b) / var10;
		float var12 = (float) (var6 - c) / var10;
		byte var13 = (byte) ((int) (var11 * 2.0F + 0.5D));
		byte var14 = (byte) ((int) (var12 * 2.0F + 0.5D));
		byte var16 = 63;
		byte var15;
		if ((var11 >= (-var16)) && (var12 >= (-var16)) && (var11 <= var16) && (var12 <= var16)) {
			var8 += var8 < 0.0D ? -8.0D : 8.0D;
			var15 = (byte) ((int) ((var8 * 16.0D) / 360.0D));
			if (d < 0) {
				int var17 = (int) (var2.R().f() / 10L);
				var15 = (byte) ((((var17 * var17 * 34187121) + (var17 * 121)) >> 15) & 15);
			}
		} else {
			if ((Math.abs(var11) >= 320.0F) || (Math.abs(var12) >= 320.0F)) {
				i.remove(var3);
				return;
			}

			var1 = 6;
			var15 = 0;
			if (var11 <= (-var16)) {
				var13 = (byte) ((int) (var16 * 2 + 2.5D));
			}

			if (var12 <= (-var16)) {
				var14 = (byte) ((int) (var16 * 2 + 2.5D));
			}

			if (var11 >= var16) {
				var13 = (byte) ((var16 * 2) + 1);
			}

			if (var12 >= var16) {
				var14 = (byte) ((var16 * 2) + 1);
			}
		}

		i.put(var3, new class_axk((byte) var1, var13, var14, var15));
	}

	public Packet a(class_aco var1, class_ago var2, class_yu var3) {
		class_axl.class_a_in_class_axl var4 = (class_axl.class_a_in_class_axl) j.get(var3);
		return var4 == null ? null : var4.a(var1);
	}

	public void a(int var1, int var2) {
		super.c();
		Iterator var3 = h.iterator();

		while (var3.hasNext()) {
			class_axl.class_a_in_class_axl var4 = (class_axl.class_a_in_class_axl) var3.next();
			var4.a(var1, var2);
		}

	}

	public class_axl.class_a_in_class_axl a(class_yu var1) {
		class_axl.class_a_in_class_axl var2 = (class_axl.class_a_in_class_axl) j.get(var1);
		if (var2 == null) {
			var2 = new class_axl.class_a_in_class_axl(var1);
			j.put(var1, var2);
			h.add(var2);
		}

		return var2;
	}

	public class class_a_in_class_axl {
		public final class_yu a;
		private boolean d = true;
		private int e = 0;
		private int f = 0;
		private int g = 127;
		private int h = 127;
		private int i;
		public int b;

		public class_a_in_class_axl(class_yu var2) {
			a = var2;
		}

		public Packet a(class_aco var1) {
			if (d) {
				d = false;
				return new class_gv(var1.i(), class_axl.this.f, class_axl.this.e, class_axl.this.i.values(), class_axl.this.g, e, f, (g + 1) - e, (h + 1) - f);
			} else {
				return (i++ % 5) == 0 ? new class_gv(var1.i(), class_axl.this.f, class_axl.this.e, class_axl.this.i.values(), class_axl.this.g, 0, 0, 0, 0) : null;
			}
		}

		public void a(int var1, int var2) {
			if (d) {
				e = Math.min(e, var1);
				f = Math.min(f, var2);
				g = Math.max(g, var1);
				h = Math.max(h, var2);
			} else {
				d = true;
				e = var1;
				f = var2;
				g = var1;
				h = var2;
			}

		}
	}
}
