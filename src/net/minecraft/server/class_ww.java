package net.minecraft.server;

import java.util.ArrayList;

import com.google.common.collect.Lists;

public class class_ww extends class_wt {
	public class_ww.class_a_in_class_ww c;

	public class_ww(class_ago var1) {
		super(var1);
	}

	public class_ww(class_ago var1, class_cj var2, class_cq var3) {
		super(var1, var2);
		ArrayList var4 = Lists.newArrayList();
		class_ww.class_a_in_class_ww[] var5 = class_ww.class_a_in_class_ww.values();
		int var6 = var5.length;

		for (int var7 = 0; var7 < var6; ++var7) {
			class_ww.class_a_in_class_ww var8 = var5[var7];
			c = var8;
			this.a(var3);
			if (this.i()) {
				var4.add(var8);
			}
		}

		if (!var4.isEmpty()) {
			c = (class_ww.class_a_in_class_ww) var4.get(V.nextInt(var4.size()));
		}

		this.a(var3);
	}

	@Override
	public void b(class_dn var1) {
		var1.a("Motive", c.B);
		super.b(var1);
	}

	@Override
	public void a(class_dn var1) {
		String var2 = var1.l("Motive");
		class_ww.class_a_in_class_ww[] var3 = class_ww.class_a_in_class_ww.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			class_ww.class_a_in_class_ww var6 = var3[var5];
			if (var6.B.equals(var2)) {
				c = var6;
			}
		}

		if (c == null) {
			c = class_ww.class_a_in_class_ww.a;
		}

		super.a(var1);
	}

	@Override
	public int j() {
		return c.C;
	}

	@Override
	public int k() {
		return c.D;
	}

	@Override
	public void b(Entity var1) {
		if (o.S().b("doEntityDrops")) {
			if (var1 instanceof class_yu) {
				class_yu var2 = (class_yu) var1;
				if (var2.bI.d) {
					return;
				}
			}

			this.a(new class_aco(Items.ap), 0.0F);
		}
	}

	@Override
	public void b(double var1, double var3, double var5, float var7, float var8) {
		class_cj var9 = a.a(var1 - s, var3 - t, var5 - u);
		this.b(var9.n(), var9.o(), var9.p());
	}

	public static enum class_a_in_class_ww {
		a("Kebab", 16, 16, 0, 0),
		b("Aztec", 16, 16, 16, 0),
		c("Alban", 16, 16, 32, 0),
		d("Aztec2", 16, 16, 48, 0),
		e("Bomb", 16, 16, 64, 0),
		f("Plant", 16, 16, 80, 0),
		g("Wasteland", 16, 16, 96, 0),
		h("Pool", 32, 16, 0, 32),
		i("Courbet", 32, 16, 32, 32),
		j("Sea", 32, 16, 64, 32),
		k("Sunset", 32, 16, 96, 32),
		l("Creebet", 32, 16, 128, 32),
		m("Wanderer", 16, 32, 0, 64),
		n("Graham", 16, 32, 16, 64),
		o("Match", 32, 32, 0, 128),
		p("Bust", 32, 32, 32, 128),
		q("Stage", 32, 32, 64, 128),
		r("Void", 32, 32, 96, 128),
		s("SkullAndRoses", 32, 32, 128, 128),
		t("Wither", 32, 32, 160, 128),
		u("Fighters", 64, 32, 0, 96),
		v("Pointer", 64, 64, 0, 192),
		w("Pigscene", 64, 64, 64, 192),
		x("BurningSkull", 64, 64, 128, 192),
		y("Skeleton", 64, 48, 192, 64),
		z("DonkeyKong", 64, 48, 192, 112);

		public static final int A;
		public final String B;
		public final int C;
		public final int D;
		public final int E;
		public final int F;

		private class_a_in_class_ww(String var3, int var4, int var5, int var6, int var7) {
			B = var3;
			C = var4;
			D = var5;
			E = var6;
			F = var7;
		}

		static {
			A = "SkullAndRoses".length();
		}
	}
}
