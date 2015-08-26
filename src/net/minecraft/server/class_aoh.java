package net.minecraft.server;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class class_aoh extends class_aow implements class_ks, class_pp {
	public static final class_qq[][] a;
	private static final Set f;
	private final List g = Lists.newArrayList();
	private boolean j;
	private int k = -1;
	private class_qq l;
	private class_qq m;
	private class_aco n;
	private String o;

	@Override
	public void c() {
		if ((b.M() % 80L) == 0L) {
			m();
		}

	}

	public void m() {
		B();
		A();
	}

	private void A() {
		if (j && (k > 0) && !b.D && (l != null)) {
			double var1 = (k * 10) + 10;
			byte var3 = 0;
			if ((k >= 4) && (l == m)) {
				var3 = 1;
			}

			int var4 = c.n();
			int var5 = c.o();
			int var6 = c.p();
			class_ayk var7 = (new class_ayk(var4, var5, var6, var4 + 1, var5 + 1, var6 + 1)).b(var1, var1, var1).a(0.0D, b.W(), 0.0D);
			List var8 = b.a(class_yu.class, var7);
			Iterator var9 = var8.iterator();

			class_yu var10;
			while (var9.hasNext()) {
				var10 = (class_yu) var9.next();
				var10.c(new class_qr(l, 180, var3, true, true));
			}

			if ((k >= 4) && (l != m) && (m != null)) {
				var9 = var8.iterator();

				while (var9.hasNext()) {
					var10 = (class_yu) var9.next();
					var10.c(new class_qr(m, 180, 0, true, true));
				}
			}
		}

	}

	private void B() {
		int var1 = k;
		int var2 = c.n();
		int var3 = c.o();
		int var4 = c.p();
		k = 0;
		g.clear();
		j = true;
		class_aoh.class_a_in_class_aoh var5 = new class_aoh.class_a_in_class_aoh(class_vl.a(class_abt.a));
		g.add(var5);
		boolean var6 = true;
		class_cj.class_a_in_class_cj var7 = new class_cj.class_a_in_class_cj();

		int var8;
		for (var8 = var3 + 1; var8 < 256; ++var8) {
			class_apn var9 = b.p(var7.c(var2, var8, var4));
			float[] var10;
			if (var9.c() == Blocks.STAINED_GLASS) {
				var10 = class_vl.a((class_abt) var9.b(BlockStainedGlass.a));
			} else {
				if (var9.c() != Blocks.STAINED_GLASS_PANE) {
					if ((var9.c().r() >= 15) && (var9.c() != Blocks.BEDROCK)) {
						j = false;
						g.clear();
						break;
					}

					var5.a();
					continue;
				}

				var10 = class_vl.a((class_abt) var9.b(BlockStainedGlassPane.a));
			}

			if (!var6) {
				var10 = new float[] { (var5.b()[0] + var10[0]) / 2.0F, (var5.b()[1] + var10[1]) / 2.0F, (var5.b()[2] + var10[2]) / 2.0F };
			}

			if (Arrays.equals(var10, var5.b())) {
				var5.a();
			} else {
				var5 = new class_aoh.class_a_in_class_aoh(var10);
				g.add(var5);
			}

			var6 = false;
		}

		if (j) {
			for (var8 = 1; var8 <= 4; k = var8++) {
				int var15 = var3 - var8;
				if (var15 < 0) {
					break;
				}

				boolean var17 = true;

				for (int var11 = var2 - var8; (var11 <= (var2 + var8)) && var17; ++var11) {
					for (int var12 = var4 - var8; var12 <= (var4 + var8); ++var12) {
						Block var13 = b.p(new class_cj(var11, var15, var12)).c();
						if ((var13 != Blocks.EMERALD_BLOCK) && (var13 != Blocks.GOLD_BLOCK) && (var13 != Blocks.DIAMOND_BLOCK) && (var13 != Blocks.IRON_BLOCK)) {
							var17 = false;
							break;
						}
					}
				}

				if (!var17) {
					break;
				}
			}

			if (k == 0) {
				j = false;
			}
		}

		if (!b.D && (k == 4) && (var1 < k)) {
			Iterator var14 = b.a(class_yu.class, (new class_ayk(var2, var3, var4, var2, var3 - 4, var4)).b(10.0D, 5.0D, 10.0D)).iterator();

			while (var14.hasNext()) {
				class_yu var16 = (class_yu) var14.next();
				var16.b(class_my.K);
			}
		}

	}

	@Override
	public Packet x_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		return new class_ft(c, 3, var1);
	}

	private static class_qq f(int var0) {
		class_qq var1 = class_qq.a(var0);
		return f.contains(var1) ? var1 : null;
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		l = f(var1.h("Primary"));
		m = f(var1.h("Secondary"));
		k = var1.h("Levels");
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Primary", class_qq.a(l));
		var1.a("Secondary", class_qq.a(m));
		var1.a("Levels", k);
	}

	@Override
	public int n_() {
		return 1;
	}

	@Override
	public class_aco a(int var1) {
		return var1 == 0 ? n : null;
	}

	@Override
	public class_aco a(int var1, int var2) {
		if ((var1 == 0) && (n != null)) {
			if (var2 >= n.b) {
				class_aco var3 = n;
				n = null;
				return var3;
			} else {
				n.b -= var2;
				return new class_aco(n.b(), var2, n.i());
			}
		} else {
			return null;
		}
	}

	@Override
	public class_aco b(int var1) {
		if ((var1 == 0) && (n != null)) {
			class_aco var2 = n;
			n = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		if (var1 == 0) {
			n = var2;
		}

	}

	@Override
	public String e_() {
		return k_() ? o : "container.beacon";
	}

	@Override
	public boolean k_() {
		return (o != null) && !o.isEmpty();
	}

	public void a(String var1) {
		o = var1;
	}

	@Override
	public int p_() {
		return 1;
	}

	@Override
	public boolean a(class_yu var1) {
		return b.s(c) != this ? false : var1.e(c.n() + 0.5D, c.o() + 0.5D, c.p() + 0.5D) <= 64.0D;
	}

	@Override
	public void b(class_yu var1) {
	}

	@Override
	public void c(class_yu var1) {
	}

	@Override
	public boolean b(int var1, class_aco var2) {
		return (var2.b() == Items.bT) || (var2.b() == Items.k) || (var2.b() == Items.m) || (var2.b() == Items.l);
	}

	@Override
	public String k() {
		return "minecraft:beacon";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_zx(var1, this);
	}

	@Override
	public int c(int var1) {
		switch (var1) {
			case 0:
				return k;
			case 1:
				return class_qq.a(l);
			case 2:
				return class_qq.a(m);
			default:
				return 0;
		}
	}

	@Override
	public void b(int var1, int var2) {
		switch (var1) {
			case 0:
				k = var2;
				break;
			case 1:
				l = f(var2);
				break;
			case 2:
				m = f(var2);
		}

	}

	@Override
	public int g() {
		return 3;
	}

	@Override
	public void l() {
		n = null;
	}

	@Override
	public boolean c(int var1, int var2) {
		if (var1 == 1) {
			m();
			return true;
		} else {
			return super.c(var1, var2);
		}
	}

	static {
		a = new class_qq[][] { { class_qs.a, class_qs.c }, { class_qs.k, class_qs.h }, { class_qs.e }, { class_qs.j } };
		f = Sets.newHashSet();
		class_qq[][] var0 = a;
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			class_qq[] var3 = var0[var2];
			Collections.addAll(f, var3);
		}

	}

	public static class class_a_in_class_aoh {
		private final float[] a;
		private int b;

		public class_a_in_class_aoh(float[] var1) {
			a = var1;
			b = 1;
		}

		protected void a() {
			++b;
		}

		public float[] b() {
			return a;
		}
	}
}
