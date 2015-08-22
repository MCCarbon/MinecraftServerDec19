package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_aro implements class_aqk {
	private class_ago a;
	private Random b;
	private final class_apn[] c = new class_apn[256];
	private final class_atv d;
	private final List e = Lists.newArrayList();
	private final boolean f;
	private final boolean g;
	private class_asy h;
	private class_asy i;

	public class_aro(class_ago var1, long var2, boolean var4, String var5) {
		a = var1;
		b = new Random(var2);
		d = class_atv.a(var5);
		if (var4) {
			Map var6 = d.b();
			if (var6.containsKey("village")) {
				Map var7 = (Map) var6.get("village");
				if (!var7.containsKey("size")) {
					var7.put("size", "1");
				}

				e.add(new class_auu(var7));
			}

			if (var6.containsKey("biome_1")) {
				e.add(new class_auk((Map) var6.get("biome_1")));
			}

			if (var6.containsKey("mineshaft")) {
				e.add(new class_aud((Map) var6.get("mineshaft")));
			}

			if (var6.containsKey("stronghold")) {
				e.add(new class_aum((Map) var6.get("stronghold")));
			}

			if (var6.containsKey("oceanmonument")) {
				e.add(new class_aui((Map) var6.get("oceanmonument")));
			}
		}

		if (d.b().containsKey("lake")) {
			h = new class_asy(Blocks.j);
		}

		if (d.b().containsKey("lava_lake")) {
			i = new class_asy(Blocks.l);
		}

		g = d.b().containsKey("dungeon");
		int var13 = 0;
		int var14 = 0;
		boolean var8 = true;
		Iterator var9 = d.c().iterator();

		while (var9.hasNext()) {
			class_atw var10 = (class_atw) var9.next();

			for (int var11 = var10.d(); var11 < (var10.d() + var10.b()); ++var11) {
				class_apn var12 = var10.c();
				if (var12.c() != Blocks.a) {
					var8 = false;
					c[var11] = var12;
				}
			}

			if (var10.c().c() == Blocks.a) {
				var14 += var10.b();
			} else {
				var13 += var10.b() + var14;
				var14 = 0;
			}
		}

		var1.b(var13);
		f = var8 ? false : d.b().containsKey("decoration");
	}

	@Override
	public class_aqn d(int var1, int var2) {
		class_arl var3 = new class_arl();

		int var7;
		for (int var4 = 0; var4 < c.length; ++var4) {
			class_apn var5 = c[var4];
			if (var5 != null) {
				for (int var6 = 0; var6 < 16; ++var6) {
					for (var7 = 0; var7 < 16; ++var7) {
						var3.a(var6, var4, var7, var5);
					}
				}
			}
		}

		Iterator var8 = e.iterator();

		while (var8.hasNext()) {
			class_arr var10 = (class_arr) var8.next();
			var10.a(this, a, var1, var2, var3);
		}

		class_aqn var9 = new class_aqn(a, var3, var1, var2);
		class_ahb[] var11 = a.y().b((class_ahb[]) null, var1 * 16, var2 * 16, 16, 16);
		byte[] var12 = var9.l();

		for (var7 = 0; var7 < var12.length; ++var7) {
			var12[var7] = (byte) var11[var7].az;
		}

		var9.b();
		return var9;
	}

	@Override
	public boolean a(int var1, int var2) {
		return true;
	}

	@Override
	public void a(class_aqk var1, int var2, int var3) {
		int var4 = var2 * 16;
		int var5 = var3 * 16;
		class_cj var6 = new class_cj(var4, 0, var5);
		class_ahb var7 = a.b(new class_cj(var4 + 16, 0, var5 + 16));
		boolean var8 = false;
		b.setSeed(a.L());
		long var9 = ((b.nextLong() / 2L) * 2L) + 1L;
		long var11 = ((b.nextLong() / 2L) * 2L) + 1L;
		b.setSeed(((var2 * var9) + (var3 * var11)) ^ a.L());
		class_agi var13 = new class_agi(var2, var3);
		Iterator var14 = e.iterator();

		while (var14.hasNext()) {
			class_auo var15 = (class_auo) var14.next();
			boolean var16 = var15.a(a, b, var13);
			if (var15 instanceof class_auu) {
				var8 |= var16;
			}
		}

		if ((h != null) && !var8 && (b.nextInt(4) == 0)) {
			h.b(a, b, var6.a(b.nextInt(16) + 8, b.nextInt(256), b.nextInt(16) + 8));
		}

		if ((i != null) && !var8 && (b.nextInt(8) == 0)) {
			class_cj var17 = var6.a(b.nextInt(16) + 8, b.nextInt(b.nextInt(248) + 8), b.nextInt(16) + 8);
			if ((var17.o() < a.H()) || (b.nextInt(10) == 0)) {
				i.b(a, b, var17);
			}
		}

		if (g) {
			for (int var18 = 0; var18 < 8; ++var18) {
				(new class_ate()).b(a, b, var6.a(b.nextInt(16) + 8, b.nextInt(256), b.nextInt(16) + 8));
			}
		}

		if (f) {
			var7.a(a, b, var6);
		}

	}

	@Override
	public boolean a(class_aqk var1, class_aqn var2, int var3, int var4) {
		return false;
	}

	@Override
	public boolean a(boolean var1, class_oc var2) {
		return true;
	}

	@Override
	public void c() {
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean e() {
		return true;
	}

	@Override
	public String f() {
		return "FlatLevelSource";
	}

	@Override
	public List a(class_ri var1, class_cj var2) {
		class_ahb var3 = a.b(var2);
		return var3.a(var1);
	}

	@Override
	public class_cj a(class_ago var1, String var2, class_cj var3) {
		if ("Stronghold".equals(var2)) {
			Iterator var4 = e.iterator();

			while (var4.hasNext()) {
				class_auo var5 = (class_auo) var4.next();
				if (var5 instanceof class_aum) {
					return var5.b(var1, var3);
				}
			}
		}

		return null;
	}

	@Override
	public int g() {
		return 0;
	}

	@Override
	public void a(class_aqn var1, int var2, int var3) {
		Iterator var4 = e.iterator();

		while (var4.hasNext()) {
			class_auo var5 = (class_auo) var4.next();
			var5.a(this, a, var2, var3, (class_arl) null);
		}

	}

	@Override
	public class_aqn a(class_cj var1) {
		return this.d(var1.n() >> 4, var1.p() >> 4);
	}
}
