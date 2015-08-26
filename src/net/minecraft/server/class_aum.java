package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_aum extends class_auo {
	private List d;
	private boolean f;
	private class_agi[] g;
	private double h;
	private int i;

	public class_aum() {
		g = new class_agi[3];
		h = 32.0D;
		i = 3;
		d = Lists.newArrayList();
		class_ahb[] var1 = class_ahb.n();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			class_ahb var4 = var1[var3];
			if ((var4 != null) && (var4.an > 0.0F)) {
				d.add(var4);
			}
		}

	}

	public class_aum(Map var1) {
		this();
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("distance")) {
				h = MathHelper.a((String) var3.getValue(), h, 1.0D);
			} else if (((String) var3.getKey()).equals("count")) {
				g = new class_agi[MathHelper.a(((String) var3.getValue()), g.length, 1)];
			} else if (((String) var3.getKey()).equals("spread")) {
				i = MathHelper.a(((String) var3.getValue()), i, 1);
			}
		}

	}

	@Override
	public String a() {
		return "Stronghold";
	}

	@Override
	protected boolean a(int var1, int var2) {
		if (!f) {
			Random var3 = new Random();
			var3.setSeed(c.L());
			double var4 = var3.nextDouble() * 3.141592653589793D * 2.0D;
			int var6 = 1;

			for (int var7 = 0; var7 < g.length; ++var7) {
				double var8 = ((1.25D * var6) + var3.nextDouble()) * h * var6;
				int var10 = (int) Math.round(Math.cos(var4) * var8);
				int var11 = (int) Math.round(Math.sin(var4) * var8);
				class_cj var12 = c.y().a((var10 << 4) + 8, (var11 << 4) + 8, 112, d, var3);
				if (var12 != null) {
					var10 = var12.n() >> 4;
				var11 = var12.p() >> 4;
				}

				g[var7] = new class_agi(var10, var11);
				var4 += (6.283185307179586D * var6) / i;
				if (var7 == i) {
					var6 += 2 + var3.nextInt(5);
					i += 1 + var3.nextInt(2);
				}
			}

			f = true;
		}

		class_agi[] var13 = g;
		int var14 = var13.length;

		for (int var5 = 0; var5 < var14; ++var5) {
			class_agi var15 = var13[var5];
			if ((var1 == var15.a) && (var2 == var15.b)) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected List y_() {
		ArrayList var1 = Lists.newArrayList();
		class_agi[] var2 = g;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_agi var5 = var2[var4];
			if (var5 != null) {
				var1.add(var5.a(64));
			}
		}

		return var1;
	}

	@Override
	protected class_aus b(int var1, int var2) {
		class_aum.class_a_in_class_aum var3;
		for (var3 = new class_aum.class_a_in_class_aum(c, b, var1, var2); var3.c().isEmpty() || (((class_aun.class_m_in_class_aun) var3.c().get(0)).b == null); var3 = new class_aum.class_a_in_class_aum(c, b, var1, var2)) {
			;
		}

		return var3;
	}

	public static class class_a_in_class_aum extends class_aus {
		public class_a_in_class_aum() {
		}

		public class_a_in_class_aum(class_ago var1, Random var2, int var3, int var4) {
			super(var3, var4);
			class_aun.b();
			class_aun.class_m_in_class_aun var5 = new class_aun.class_m_in_class_aun(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
			a.add(var5);
			var5.a(var5, a, var2);
			List var6 = var5.c;

			while (!var6.isEmpty()) {
				int var7 = var2.nextInt(var6.size());
				class_aur var8 = (class_aur) var6.remove(var7);
				var8.a(var5, a, var2);
			}

			d();
			this.a(var1, var2, 10);
		}
	}
}
