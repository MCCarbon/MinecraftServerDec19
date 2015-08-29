package net.minecraft.server;

import java.util.Random;

public class class_ahe {
	protected class_ago a;
	protected Random b;
	protected class_cj c;
	protected class_arm d;
	protected class_asp e = new class_asi(4);
	protected class_asp f;
	protected class_asp g;
	protected class_asp h;
	protected class_asp i;
	protected class_asp j;
	protected class_asp k;
	protected class_asp l;
	protected class_asp m;
	protected class_asp n;
	protected class_asp o;
	protected class_asp p;
	protected class_asp q;
	protected class_asp r;
	protected class_asq s;
	protected class_asp t;
	protected class_asp u;
	protected class_asp v;
	protected class_asp w;
	protected class_asp x;
	protected class_asp y;
	protected int z;
	protected int A;
	protected int B;
	protected int C;
	protected int D;
	protected int E;
	protected int F;
	protected int G;
	protected int H;
	protected int I;
	protected int J;
	protected int K;
	public boolean L;

	public class_ahe() {
		f = new class_atk(Blocks.SAND, 7);
		g = new class_atk(Blocks.GRAVEL, 6);
		s = new class_asq(Blocks.YELLOW_FLOWER, BlockFlowers.class_a_in_class_ake.a);
		t = new class_asf(Blocks.BROWN_MUSHROOM);
		u = new class_asf(Blocks.RED_MUSHROOM);
		v = new class_asv();
		w = new class_ati();
		x = new class_asg();
		y = new class_att();
		B = 2;
		C = 1;
		H = 1;
		I = 3;
		J = 1;
		L = true;
	}

	public void a(class_ago var1, Random var2, class_ahb var3, class_cj var4) {
		if (a != null) {
			throw new RuntimeException("Already decorating");
		} else {
			a = var1;
			String var5 = var1.R().A();
			if (var5 != null) {
				d = class_arm.class_a_in_class_arm.a(var5).b();
			} else {
				d = class_arm.class_a_in_class_arm.a("").b();
			}

			b = var2;
			c = var4;
			h = new class_atf(Blocks.DIRT.getBlockData(), d.I);
			i = new class_atf(Blocks.GRAVEL.getBlockData(), d.M);
			j = new class_atf(Blocks.STONE.getBlockData().a(class_anj.a, class_anj.class_a_in_class_anj.b), d.Q);
			k = new class_atf(Blocks.STONE.getBlockData().a(class_anj.a, class_anj.class_a_in_class_anj.d), d.U);
			l = new class_atf(Blocks.STONE.getBlockData().a(class_anj.a, class_anj.class_a_in_class_anj.f), d.Y);
			m = new class_atf(Blocks.COAL_ORE.getBlockData(), d.ac);
			n = new class_atf(Blocks.IRON_ORE.getBlockData(), d.ag);
			o = new class_atf(Blocks.GOLD_ORE.getBlockData(), d.ak);
			p = new class_atf(Blocks.REDSTONE_ORE.getBlockData(), d.ao);
			q = new class_atf(Blocks.DIAMOND_ORE.getBlockData(), d.as);
			r = new class_atf(Blocks.LAPIS_ORE.getBlockData(), d.aw);
			this.a(var3);
			a = null;
			b = null;
		}
	}

	protected void a(class_ahb var1) {
		this.a();

		int var2;
		int var3;
		int var4;
		for (var2 = 0; var2 < I; ++var2) {
			var3 = b.nextInt(16) + 8;
			var4 = b.nextInt(16) + 8;
			f.b(a, b, a.r(c.a(var3, 0, var4)));
		}

		for (var2 = 0; var2 < J; ++var2) {
			var3 = b.nextInt(16) + 8;
			var4 = b.nextInt(16) + 8;
			e.b(a, b, a.r(c.a(var3, 0, var4)));
		}

		for (var2 = 0; var2 < H; ++var2) {
			var3 = b.nextInt(16) + 8;
			var4 = b.nextInt(16) + 8;
			g.b(a, b, a.r(c.a(var3, 0, var4)));
		}

		var2 = A;
		if (b.nextInt(10) == 0) {
			++var2;
		}

		int var5;
		class_cj var7;
		for (var3 = 0; var3 < var2; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			class_asa var6 = var1.a(b);
			var6.e();
			var7 = a.m(c.a(var4, 0, var5));
			if (var6.b(a, b, var7)) {
				var6.a(a, b, var7);
			}
		}

		for (var3 = 0; var3 < K; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			v.b(a, b, a.m(c.a(var4, 0, var5)));
		}

		class_cj var8;
		int var11;
		int var12;
		for (var3 = 0; var3 < B; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			var11 = a.m(c.a(var4, 0, var5)).o() + 32;
			if (var11 > 0) {
				var12 = b.nextInt(var11);
				var8 = c.a(var4, var12, var5);
				BlockFlowers.class_a_in_class_ake var9 = var1.a(b, var8);
				BlockFlowers var10 = var9.a().a();
				if (var10.v() != class_avq.a) {
					s.a(var10, var9);
					s.b(a, b, var8);
				}
			}
		}

		for (var3 = 0; var3 < C; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			var11 = a.m(c.a(var4, 0, var5)).o() * 2;
			if (var11 > 0) {
				var12 = b.nextInt(var11);
				var1.b(b).b(a, b, c.a(var4, var12, var5));
			}
		}

		for (var3 = 0; var3 < D; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			var11 = a.m(c.a(var4, 0, var5)).o() * 2;
			if (var11 > 0) {
				var12 = b.nextInt(var11);
				(new class_asj()).b(a, b, c.a(var4, var12, var5));
			}
		}

		for (var3 = 0; var3 < z; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			var11 = a.m(c.a(var4, 0, var5)).o() * 2;
			if (var11 > 0) {
				var12 = b.nextInt(var11);

				class_cj var14;
				for (var8 = c.a(var4, var12, var5); var8.o() > 0; var8 = var14) {
					var14 = var8.b();
					if (!a.d(var14)) {
						break;
					}
				}

				y.b(a, b, var8);
			}
		}

		for (var3 = 0; var3 < E; ++var3) {
			if (b.nextInt(4) == 0) {
				var4 = b.nextInt(16) + 8;
				var5 = b.nextInt(16) + 8;
				class_cj var13 = a.m(c.a(var4, 0, var5));
				t.b(a, b, var13);
			}

			if (b.nextInt(8) == 0) {
				var4 = b.nextInt(16) + 8;
				var5 = b.nextInt(16) + 8;
				var11 = a.m(c.a(var4, 0, var5)).o() * 2;
				if (var11 > 0) {
					var12 = b.nextInt(var11);
					var8 = c.a(var4, var12, var5);
					u.b(a, b, var8);
				}
			}
		}

		if (b.nextInt(4) == 0) {
			var3 = b.nextInt(16) + 8;
			var4 = b.nextInt(16) + 8;
			var5 = a.m(c.a(var3, 0, var4)).o() * 2;
			if (var5 > 0) {
				var11 = b.nextInt(var5);
				t.b(a, b, c.a(var3, var11, var4));
			}
		}

		if (b.nextInt(8) == 0) {
			var3 = b.nextInt(16) + 8;
			var4 = b.nextInt(16) + 8;
			var5 = a.m(c.a(var3, 0, var4)).o() * 2;
			if (var5 > 0) {
				var11 = b.nextInt(var5);
				u.b(a, b, c.a(var3, var11, var4));
			}
		}

		for (var3 = 0; var3 < F; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			var11 = a.m(c.a(var4, 0, var5)).o() * 2;
			if (var11 > 0) {
				var12 = b.nextInt(var11);
				w.b(a, b, c.a(var4, var12, var5));
			}
		}

		for (var3 = 0; var3 < 10; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			var11 = a.m(c.a(var4, 0, var5)).o() * 2;
			if (var11 > 0) {
				var12 = b.nextInt(var11);
				w.b(a, b, c.a(var4, var12, var5));
			}
		}

		if (b.nextInt(32) == 0) {
			var3 = b.nextInt(16) + 8;
			var4 = b.nextInt(16) + 8;
			var5 = a.m(c.a(var3, 0, var4)).o() * 2;
			if (var5 > 0) {
				var11 = b.nextInt(var5);
				(new class_ath()).b(a, b, c.a(var3, var11, var4));
			}
		}

		for (var3 = 0; var3 < G; ++var3) {
			var4 = b.nextInt(16) + 8;
			var5 = b.nextInt(16) + 8;
			var11 = a.m(c.a(var4, 0, var5)).o() * 2;
			if (var11 > 0) {
				var12 = b.nextInt(var11);
				x.b(a, b, c.a(var4, var12, var5));
			}
		}

		if (L) {
			for (var3 = 0; var3 < 50; ++var3) {
				var4 = b.nextInt(16) + 8;
				var5 = b.nextInt(16) + 8;
				var11 = b.nextInt(248) + 8;
				if (var11 > 0) {
					var12 = b.nextInt(var11);
					var8 = c.a(var4, var12, var5);
					(new class_atn(Blocks.FLOWING_WATER)).b(a, b, var8);
				}
			}

			for (var3 = 0; var3 < 20; ++var3) {
				var4 = b.nextInt(16) + 8;
				var5 = b.nextInt(16) + 8;
				var11 = b.nextInt(b.nextInt(b.nextInt(240) + 8) + 8);
				var7 = c.a(var4, var11, var5);
				(new class_atn(Blocks.FLOWING_LAVA)).b(a, b, var7);
			}
		}

	}

	protected void a(int var1, class_asp var2, int var3, int var4) {
		int var5;
		if (var4 < var3) {
			var5 = var3;
			var3 = var4;
			var4 = var5;
		} else if (var4 == var3) {
			if (var3 < 255) {
				++var4;
			} else {
				--var3;
			}
		}

		for (var5 = 0; var5 < var1; ++var5) {
			class_cj var6 = c.a(b.nextInt(16), b.nextInt(var4 - var3) + var3, b.nextInt(16));
			var2.b(a, b, var6);
		}

	}

	protected void b(int var1, class_asp var2, int var3, int var4) {
		for (int var5 = 0; var5 < var1; ++var5) {
			class_cj var6 = c.a(b.nextInt(16), (b.nextInt(var4) + b.nextInt(var4) + var3) - var4, b.nextInt(16));
			var2.b(a, b, var6);
		}

	}

	protected void a() {
		this.a(d.J, h, d.K, d.L);
		this.a(d.N, i, d.O, d.P);
		this.a(d.V, k, d.W, d.X);
		this.a(d.R, j, d.S, d.T);
		this.a(d.Z, l, d.aa, d.ab);
		this.a(d.ad, m, d.ae, d.af);
		this.a(d.ah, n, d.ai, d.aj);
		this.a(d.al, o, d.am, d.an);
		this.a(d.ap, p, d.aq, d.ar);
		this.a(d.at, q, d.au, d.av);
		b(d.ax, r, d.ay, d.az);
	}
}
