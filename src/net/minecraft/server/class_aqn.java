package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;

public class class_aqn {
	private static final Logger d = LogManager.getLogger();
	public static final class_aqo a = null;
	private final class_aqo[] e;
	private final byte[] f;
	private final int[] g;
	private final boolean[] h;
	private boolean i;
	private final class_ago j;
	private final int[] k;
	public final int b;
	public final int c;
	private boolean l;
	private final Map m;
	private final class_nm[] n;
	private boolean o;
	private boolean p;
	private boolean q;
	private boolean r;
	private boolean s;
	private long t;
	private int u;
	private long v;
	private int w;
	private ConcurrentLinkedQueue x;

	public class_aqn(class_ago var1, int var2, int var3) {
		e = new class_aqo[16];
		f = new byte[256];
		g = new int[256];
		h = new boolean[256];
		m = Maps.newHashMap();
		w = 4096;
		x = Queues.newConcurrentLinkedQueue();
		n = (new class_nm[16]);
		j = var1;
		b = var2;
		c = var3;
		k = new int[256];

		for (int var4 = 0; var4 < n.length; ++var4) {
			n[var4] = new class_nm(Entity.class);
		}

		Arrays.fill(g, -999);
		Arrays.fill(f, (byte) -1);
	}

	public class_aqn(class_ago var1, class_arl var2, int var3, int var4) {
		this(var1, var3, var4);
		short var5 = 256;
		boolean var6 = !var1.t.m();

		for (int var7 = 0; var7 < 16; ++var7) {
			for (int var8 = 0; var8 < 16; ++var8) {
				for (int var9 = 0; var9 < var5; ++var9) {
					int var10 = (var7 * var5 * 16) | (var8 * var5) | var9;
					class_apn var11 = var2.a(var10);
					if (var11.c().v() != class_avq.a) {
						int var12 = var9 >> 4;
				if (e[var12] == a) {
					e[var12] = new class_aqo(var12 << 4, var6);
				}

				e[var12].a(var7, var9 & 15, var8, var11);
					}
				}
			}
		}

	}

	public boolean a(int var1, int var2) {
		return (var1 == b) && (var2 == c);
	}

	public int f(class_cj var1) {
		return this.b(var1.n() & 15, var1.p() & 15);
	}

	public int b(int var1, int var2) {
		return k[(var2 << 4) | var1];
	}

	public int g() {
		for (int var1 = e.length - 1; var1 >= 0; --var1) {
			if (e[var1] != a) {
				return e[var1].d();
			}
		}

		return 0;
	}

	public class_aqo[] h() {
		return e;
	}

	public void b() {
		int var1 = this.g();
		u = Integer.MAX_VALUE;

		for (int var2 = 0; var2 < 16; ++var2) {
			for (int var3 = 0; var3 < 16; ++var3) {
				g[var2 + (var3 << 4)] = -999;

				int var4;
				for (var4 = var1 + 16; var4 > 0; --var4) {
					if (this.e(var2, var4 - 1, var3) != 0) {
						k[(var3 << 4) | var2] = var4;
						if (var4 < u) {
							u = var4;
						}
						break;
					}
				}

				if (!j.t.m()) {
					var4 = 15;
					int var5 = (var1 + 16) - 1;

					do {
						int var6 = this.e(var2, var5, var3);
						if ((var6 == 0) && (var4 != 15)) {
							var6 = 1;
						}

						var4 -= var6;
						if (var4 > 0) {
							class_aqo var7 = e[var5 >> 4];
							if (var7 != a) {
								var7.a(var2, var5 & 15, var3, var4);
								j.n(new class_cj((b << 4) + var2, var5, (c << 4) + var3));
							}
						}

						--var5;
					} while ((var5 > 0) && (var4 > 0));
				}
			}
		}

		r = true;
	}

	private void d(int var1, int var2) {
		h[var1 + (var2 * 16)] = true;
		l = true;
	}

	private void h(boolean var1) {
		j.B.a("recheckGaps");
		if (j.a((new class_cj((b * 16) + 8, 0, (c * 16) + 8)), 16)) {
			for (int var2 = 0; var2 < 16; ++var2) {
				for (int var3 = 0; var3 < 16; ++var3) {
					if (h[var2 + (var3 * 16)]) {
						h[var2 + (var3 * 16)] = false;
						int var4 = this.b(var2, var3);
						int var5 = (b * 16) + var2;
						int var6 = (c * 16) + var3;
						int var7 = Integer.MAX_VALUE;

						Iterator var8;
						class_cq var9;
						for (var8 = class_cq.class_c_in_class_cq.a.iterator(); var8.hasNext(); var7 = Math.min(var7, j.b(var5 + var9.g(), var6 + var9.i()))) {
							var9 = (class_cq) var8.next();
						}

						this.c(var5, var6, var7);
						var8 = class_cq.class_c_in_class_cq.a.iterator();

						while (var8.hasNext()) {
							var9 = (class_cq) var8.next();
							this.c(var5 + var9.g(), var6 + var9.i(), var4);
						}

						if (var1) {
							j.B.b();
							return;
						}
					}
				}
			}

			l = false;
		}

		j.B.b();
	}

	private void c(int var1, int var2, int var3) {
		int var4 = j.m(new class_cj(var1, 0, var2)).o();
		if (var4 > var3) {
			this.a(var1, var2, var3, var4 + 1);
		} else if (var4 < var3) {
			this.a(var1, var2, var4, var3 + 1);
		}

	}

	private void a(int var1, int var2, int var3, int var4) {
		if ((var4 > var3) && j.a((new class_cj(var1, 0, var2)), 16)) {
			for (int var5 = var3; var5 < var4; ++var5) {
				j.c(class_agu.a, new class_cj(var1, var5, var2));
			}

			r = true;
		}

	}

	private void d(int var1, int var2, int var3) {
		int var4 = k[(var3 << 4) | var1] & 255;
		int var5 = var4;
		if (var2 > var4) {
			var5 = var2;
		}

		while ((var5 > 0) && (this.e(var1, var5 - 1, var3) == 0)) {
			--var5;
		}

		if (var5 != var4) {
			j.a(var1 + (b * 16), var3 + (c * 16), var5, var4);
			k[(var3 << 4) | var1] = var5;
			int var6 = (b * 16) + var1;
			int var7 = (c * 16) + var3;
			int var8;
			int var13;
			if (!j.t.m()) {
				class_aqo var9;
				if (var5 < var4) {
					for (var8 = var5; var8 < var4; ++var8) {
						var9 = e[var8 >> 4];
						if (var9 != a) {
							var9.a(var1, var8 & 15, var3, 15);
							j.n(new class_cj((b << 4) + var1, var8, (c << 4) + var3));
						}
					}
				} else {
					for (var8 = var4; var8 < var5; ++var8) {
						var9 = e[var8 >> 4];
						if (var9 != a) {
							var9.a(var1, var8 & 15, var3, 0);
							j.n(new class_cj((b << 4) + var1, var8, (c << 4) + var3));
						}
					}
				}

				var8 = 15;

				while ((var5 > 0) && (var8 > 0)) {
					--var5;
					var13 = this.e(var1, var5, var3);
					if (var13 == 0) {
						var13 = 1;
					}

					var8 -= var13;
					if (var8 < 0) {
						var8 = 0;
					}

					class_aqo var10 = e[var5 >> 4];
					if (var10 != a) {
						var10.a(var1, var5 & 15, var3, var8);
					}
				}
			}

			var8 = k[(var3 << 4) | var1];
			var13 = var4;
			int var14 = var8;
			if (var8 < var4) {
				var13 = var8;
				var14 = var4;
			}

			if (var8 < u) {
				u = var8;
			}

			if (!j.t.m()) {
				Iterator var11 = class_cq.class_c_in_class_cq.a.iterator();

				while (var11.hasNext()) {
					class_cq var12 = (class_cq) var11.next();
					this.a(var6 + var12.g(), var7 + var12.i(), var13, var14);
				}

				this.a(var6, var7, var13, var14);
			}

			r = true;
		}
	}

	public int b(class_cj var1) {
		return this.a(var1).r();
	}

	private int e(int var1, int var2, int var3) {
		return this.f(var1, var2, var3).r();
	}

	private Block f(int var1, int var2, int var3) {
		Block var4 = Blocks.a;
		if ((var2 >= 0) && ((var2 >> 4) < e.length)) {
			class_aqo var5 = e[var2 >> 4];
			if (var5 != a) {
				try {
					var4 = var5.b(var1, var2 & 15, var3);
				} catch (Throwable var8) {
					class_b var7 = class_b.a(var8, "Getting block");
					throw new class_e(var7);
				}
			}
		}

		return var4;
	}

	public Block a(final int var1, final int var2, final int var3) {
		try {
			return this.f(var1 & 15, var2, var3 & 15);
		} catch (class_e var6) {
			class_c var5 = var6.a().a("Block being got");
			var5.a("Location", new Callable() {
				public String a() throws Exception {
					return class_c.a(new class_cj((b * 16) + var1, var2, (c * 16) + var3));
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
			throw var6;
		}
	}

	public Block a(final class_cj var1) {
		try {
			return this.f(var1.n() & 15, var1.o(), var1.p() & 15);
		} catch (class_e var4) {
			class_c var3 = var4.a().a("Block being got");
			var3.a("Location", new Callable() {
				public String a() throws Exception {
					return class_c.a(var1);
				}

				// $FF: synthetic method
				@Override
				public Object call() throws Exception {
					return this.a();
				}
			});
			throw var4;
		}
	}

	public class_apn g(final class_cj var1) {
		if (j.I() == class_agt.g) {
			class_apn var7 = null;
			if (var1.o() == 60) {
				var7 = Blocks.cv.S();
			}

			if (var1.o() == 70) {
				var7 = class_arn.b(var1.n(), var1.p());
			}

			return var7 == null ? Blocks.a.S() : var7;
		} else {
			try {
				if ((var1.o() >= 0) && ((var1.o() >> 4) < e.length)) {
					class_aqo var2 = e[var1.o() >> 4];
					if (var2 != a) {
						int var8 = var1.n() & 15;
						int var9 = var1.o() & 15;
						int var5 = var1.p() & 15;
						return var2.a(var8, var9, var5);
					}
				}

				return Blocks.a.S();
			} catch (Throwable var6) {
				class_b var3 = class_b.a(var6, "Getting block state");
				class_c var4 = var3.a("Block being got");
				var4.a("Location", new Callable() {
					public String a() throws Exception {
						return class_c.a(var1);
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				throw new class_e(var3);
			}
		}
	}

	private int g(int var1, int var2, int var3) {
		if ((var2 >> 4) >= e.length) {
			return 0;
		} else {
			class_aqo var4 = e[var2 >> 4];
			return var4 != a ? var4.c(var1, var2 & 15, var3) : 0;
		}
	}

	public int c(class_cj var1) {
		return this.g(var1.n() & 15, var1.o(), var1.p() & 15);
	}

	public class_apn a(class_cj var1, class_apn var2) {
		int var3 = var1.n() & 15;
		int var4 = var1.o();
		int var5 = var1.p() & 15;
		int var6 = (var5 << 4) | var3;
		if (var4 >= (g[var6] - 1)) {
			g[var6] = -999;
		}

		int var7 = k[var6];
		class_apn var8 = this.g(var1);
		if (var8 == var2) {
			return null;
		} else {
			Block var9 = var2.c();
			Block var10 = var8.c();
			class_aqo var11 = e[var4 >> 4];
			boolean var12 = false;
			if (var11 == a) {
				if (var9 == Blocks.a) {
					return null;
				}

				var11 = e[var4 >> 4] = new class_aqo((var4 >> 4) << 4, !j.t.m());
				var12 = var4 >= var7;
			}

			var11.a(var3, var4 & 15, var5, var2);
			if (var10 != var9) {
				if (!j.D) {
					var10.c(j, var1, var8);
				} else if (var10 instanceof class_ajy) {
					j.t(var1);
				}
			}

			if (var11.b(var3, var4 & 15, var5) != var9) {
				return null;
			} else {
				if (var12) {
					this.b();
				} else {
					int var13 = var9.r();
					int var14 = var10.r();
					if (var13 > 0) {
						if (var4 >= var7) {
							this.d(var3, var4 + 1, var5);
						}
					} else if (var4 == (var7 - 1)) {
						this.d(var3, var4, var5);
					}

					if ((var13 != var14) && ((var13 < var14) || (this.a(class_agu.a, var1) > 0) || (this.a(class_agu.b, var1) > 0))) {
						this.d(var3, var5);
					}
				}

				TileEntity var15;
				if (var10 instanceof class_ajy) {
					var15 = this.a(var1, class_aqn.class_a_in_class_aqn.c);
					if (var15 != null) {
						var15.E();
					}
				}

				if (!j.D && (var10 != var9)) {
					var9.d(j, var1, var2);
				}

				if (var9 instanceof class_ajy) {
					var15 = this.a(var1, class_aqn.class_a_in_class_aqn.c);
					if (var15 == null) {
						var15 = ((class_ajy) var9).a(j, var9.c(var2));
						j.a(var1, var15);
					}

					if (var15 != null) {
						var15.E();
					}
				}

				r = true;
				return var8;
			}
		}
	}

	public int a(class_agu var1, class_cj var2) {
		int var3 = var2.n() & 15;
		int var4 = var2.o();
		int var5 = var2.p() & 15;
		class_aqo var6 = e[var4 >> 4];
		return var6 == a ? (this.d(var2) ? var1.c : 0) : (var1 == class_agu.a ? (j.t.m() ? 0 : var6.d(var3, var4 & 15, var5)) : (var1 == class_agu.b ? var6.e(var3, var4 & 15, var5) : var1.c));
	}

	public void a(class_agu var1, class_cj var2, int var3) {
		int var4 = var2.n() & 15;
		int var5 = var2.o();
		int var6 = var2.p() & 15;
		class_aqo var7 = e[var5 >> 4];
		if (var7 == a) {
			var7 = e[var5 >> 4] = new class_aqo((var5 >> 4) << 4, !j.t.m());
			this.b();
		}

		r = true;
		if (var1 == class_agu.a) {
			if (!j.t.m()) {
				var7.a(var4, var5 & 15, var6, var3);
			}
		} else if (var1 == class_agu.b) {
			var7.b(var4, var5 & 15, var6, var3);
		}

	}

	public int a(class_cj var1, int var2) {
		int var3 = var1.n() & 15;
		int var4 = var1.o();
		int var5 = var1.p() & 15;
		class_aqo var6 = e[var4 >> 4];
		if (var6 == a) {
			return !j.t.m() && (var2 < class_agu.a.c) ? class_agu.a.c - var2 : 0;
		} else {
			int var7 = j.t.m() ? 0 : var6.d(var3, var4 & 15, var5);
			var7 -= var2;
			int var8 = var6.e(var3, var4 & 15, var5);
			if (var8 > var7) {
				var7 = var8;
			}

			return var7;
		}
	}

	public void a(Entity var1) {
		s = true;
		int var2 = class_oa.c(var1.s / 16.0D);
		int var3 = class_oa.c(var1.u / 16.0D);
		if ((var2 != b) || (var3 != c)) {
			d.warn("Wrong location! (" + var2 + ", " + var3 + ") should be (" + b + ", " + c + "), " + var1, new Object[] { var1 });
			var1.L();
		}

		int var4 = class_oa.c(var1.t / 16.0D);
		if (var4 < 0) {
			var4 = 0;
		}

		if (var4 >= n.length) {
			var4 = n.length - 1;
		}

		var1.ad = true;
		var1.ae = b;
		var1.af = var4;
		var1.ag = c;
		n[var4].add(var1);
	}

	public void b(Entity var1) {
		this.a(var1, var1.af);
	}

	public void a(Entity var1, int var2) {
		if (var2 < 0) {
			var2 = 0;
		}

		if (var2 >= n.length) {
			var2 = n.length - 1;
		}

		n[var2].remove(var1);
	}

	public boolean d(class_cj var1) {
		int var2 = var1.n() & 15;
		int var3 = var1.o();
		int var4 = var1.p() & 15;
		return var3 >= k[(var4 << 4) | var2];
	}

	private TileEntity i(class_cj var1) {
		Block var2 = this.a(var1);
		return !var2.B() ? null : ((class_ajy) var2).a(j, this.c(var1));
	}

	public TileEntity a(class_cj var1, class_aqn.class_a_in_class_aqn var2) {
		TileEntity var3 = (TileEntity) m.get(var1);
		if (var3 == null) {
			if (var2 == class_aqn.class_a_in_class_aqn.a) {
				var3 = this.i(var1);
				j.a(var1, var3);
			} else if (var2 == class_aqn.class_a_in_class_aqn.b) {
				x.add(var1);
			}
		} else if (var3.x()) {
			m.remove(var1);
			return null;
		}

		return var3;
	}

	public void a(TileEntity var1) {
		this.a(var1.v(), var1);
		if (i) {
			j.a(var1);
		}

	}

	public void a(class_cj var1, TileEntity var2) {
		var2.a(j);
		var2.a(var1);
		if (this.a(var1) instanceof class_ajy) {
			if (m.containsKey(var1)) {
				((TileEntity) m.get(var1)).y();
			}

			var2.D();
			m.put(var1, var2);
		}
	}

	public void e(class_cj var1) {
		if (i) {
			TileEntity var2 = (TileEntity) m.remove(var1);
			if (var2 != null) {
				var2.y();
			}
		}

	}

	public void c() {
		i = true;
		j.b(m.values());

		for (int var1 = 0; var1 < n.length; ++var1) {
			Iterator var2 = n[var1].iterator();

			while (var2.hasNext()) {
				Entity var3 = (Entity) var2.next();
				var3.ak();
			}

			j.a(n[var1]);
		}

	}

	public void d() {
		i = false;
		Iterator var1 = m.values().iterator();

		while (var1.hasNext()) {
			TileEntity var2 = (TileEntity) var1.next();
			j.b(var2);
		}

		for (int var3 = 0; var3 < n.length; ++var3) {
			j.c(n[var3]);
		}

	}

	public void e() {
		r = true;
	}

	public void a(Entity var1, class_ayk var2, List var3, Predicate var4) {
		int var5 = class_oa.c((var2.b - 2.0D) / 16.0D);
		int var6 = class_oa.c((var2.e + 2.0D) / 16.0D);
		var5 = class_oa.a(var5, 0, n.length - 1);
		var6 = class_oa.a(var6, 0, n.length - 1);

		label68: for (int var7 = var5; var7 <= var6; ++var7) {
			if (!n[var7].isEmpty()) {
				Iterator var8 = n[var7].iterator();

				while (true) {
					Entity var9;
					Entity[] var10;
					do {
						do {
							do {
								if (!var8.hasNext()) {
									continue label68;
								}

								var9 = (Entity) var8.next();
							} while (!var9.aX().b(var2));
						} while (var9 == var1);

						if ((var4 == null) || var4.apply(var9)) {
							var3.add(var9);
						}

						var10 = var9.aH();
					} while (var10 == null);

					for (int var11 = 0; var11 < var10.length; ++var11) {
						var9 = var10[var11];
						if ((var9 != var1) && var9.aX().b(var2) && ((var4 == null) || var4.apply(var9))) {
							var3.add(var9);
						}
					}
				}
			}
		}

	}

	public void a(Class var1, class_ayk var2, List var3, Predicate var4) {
		int var5 = class_oa.c((var2.b - 2.0D) / 16.0D);
		int var6 = class_oa.c((var2.e + 2.0D) / 16.0D);
		var5 = class_oa.a(var5, 0, n.length - 1);
		var6 = class_oa.a(var6, 0, n.length - 1);

		label33: for (int var7 = var5; var7 <= var6; ++var7) {
			Iterator var8 = n[var7].c(var1).iterator();

			while (true) {
				Entity var9;
				do {
					do {
						if (!var8.hasNext()) {
							continue label33;
						}

						var9 = (Entity) var8.next();
					} while (!var9.aX().b(var2));
				} while ((var4 != null) && !var4.apply(var9));

				var3.add(var9);
			}
		}

	}

	public boolean a(boolean var1) {
		if (var1) {
			if ((s && (j.M() != t)) || r) {
				return true;
			}
		} else if (s && (j.M() >= (t + 600L))) {
			return true;
		}

		return r;
	}

	public Random a(long var1) {
		return new Random((j.L() + b * b * 4987142 + b * 5947611 + (c * c * 4392871L) + c * 389711) ^ var1);
	}

	public boolean f() {
		return false;
	}

	public void a(class_aqk var1, class_aqk var2, int var3, int var4) {
		boolean var5 = var1.a(var3, var4 - 1);
		boolean var6 = var1.a(var3 + 1, var4);
		boolean var7 = var1.a(var3, var4 + 1);
		boolean var8 = var1.a(var3 - 1, var4);
		boolean var9 = var1.a(var3 - 1, var4 - 1);
		boolean var10 = var1.a(var3 + 1, var4 + 1);
		boolean var11 = var1.a(var3 - 1, var4 + 1);
		boolean var12 = var1.a(var3 + 1, var4 - 1);
		if (var6 && var7 && var10) {
			if (!o) {
				var1.a(var2, var3, var4);
			} else {
				var1.a(var2, this, var3, var4);
			}
		}

		class_aqn var13;
		if (var8 && var7 && var11) {
			var13 = var1.d(var3 - 1, var4);
			if (!var13.o) {
				var1.a(var2, var3 - 1, var4);
			} else {
				var1.a(var2, var13, var3 - 1, var4);
			}
		}

		if (var5 && var6 && var12) {
			var13 = var1.d(var3, var4 - 1);
			if (!var13.o) {
				var1.a(var2, var3, var4 - 1);
			} else {
				var1.a(var2, var13, var3, var4 - 1);
			}
		}

		if (var9 && var5 && var8) {
			var13 = var1.d(var3 - 1, var4 - 1);
			if (!var13.o) {
				var1.a(var2, var3 - 1, var4 - 1);
			} else {
				var1.a(var2, var13, var3 - 1, var4 - 1);
			}
		}

	}

	public class_cj h(class_cj var1) {
		int var2 = var1.n() & 15;
		int var3 = var1.p() & 15;
		int var4 = var2 | (var3 << 4);
		class_cj var5 = new class_cj(var1.n(), g[var4], var1.p());
		if (var5.o() == -999) {
			int var6 = this.g() + 15;
			var5 = new class_cj(var1.n(), var6, var1.p());
			int var7 = -1;

			while (true) {
				while ((var5.o() > 0) && (var7 == -1)) {
					Block var8 = this.a(var5);
					class_avq var9 = var8.v();
					if (!var9.c() && !var9.d()) {
						var5 = var5.b();
					} else {
						var7 = var5.o() + 1;
					}
				}

				g[var4] = var7;
				break;
			}
		}

		return new class_cj(var1.n(), g[var4], var1.p());
	}

	public void b(boolean var1) {
		if (l && !j.t.m() && !var1) {
			this.h(j.D);
		}

		q = true;
		if (!p && o) {
			o();
		}

		while (!x.isEmpty()) {
			class_cj var2 = (class_cj) x.poll();
			if ((this.a(var2, class_aqn.class_a_in_class_aqn.c) == null) && this.a(var2).B()) {
				TileEntity var3 = this.i(var2);
				j.a(var2, var3);
				j.b(var2, var2);
			}
		}

	}

	public boolean i() {
		return q && o && p;
	}

	public boolean j() {
		return q;
	}

	public class_agi k() {
		return new class_agi(b, c);
	}

	public boolean c(int var1, int var2) {
		if (var1 < 0) {
			var1 = 0;
		}

		if (var2 >= 256) {
			var2 = 255;
		}

		for (int var3 = var1; var3 <= var2; var3 += 16) {
			class_aqo var4 = e[var3 >> 4];
			if ((var4 != a) && !var4.a()) {
				return false;
			}
		}

		return true;
	}

	public void a(class_aqo[] var1) {
		if (e.length != var1.length) {
			d.warn("Could not set level chunk sections, array length is " + var1.length + " instead of " + e.length);
		} else {
			System.arraycopy(var1, 0, e, 0, e.length);
		}
	}

	public class_ahb a(class_cj var1, class_ahf var2) {
		int var3 = var1.n() & 15;
		int var4 = var1.p() & 15;
		int var5 = f[(var4 << 4) | var3] & 255;
		class_ahb var6;
		if (var5 == 255) {
			var6 = var2.a(var1, class_ahb.q);
			var5 = var6.az;
			f[(var4 << 4) | var3] = (byte) (var5 & 255);
		}

		var6 = class_ahb.e(var5);
		return var6 == null ? class_ahb.q : var6;
	}

	public byte[] l() {
		return f;
	}

	public void a(byte[] var1) {
		if (f.length != var1.length) {
			d.warn("Could not set level chunk biomes, array length is " + var1.length + " instead of " + f.length);
		} else {
			for (int var2 = 0; var2 < f.length; ++var2) {
				f[var2] = var1[var2];
			}

		}
	}

	public void m() {
		w = 0;
	}

	public void n() {
		if (w < 4096) {
			class_cj var1 = new class_cj(b << 4, 0, c << 4);

			for (int var2 = 0; var2 < 8; ++var2) {
				if (w >= 4096) {
					return;
				}

				int var3 = w % 16;
				int var4 = (w / 16) % 16;
				int var5 = w / 256;
				++w;

				for (int var6 = 0; var6 < 16; ++var6) {
					class_cj var7 = var1.a(var4, (var3 << 4) + var6, var5);
					boolean var8 = (var6 == 0) || (var6 == 15) || (var4 == 0) || (var4 == 15) || (var5 == 0) || (var5 == 15);
					if (((e[var3] == a) && var8) || ((e[var3] != a) && (e[var3].b(var4, var6, var5).v() == class_avq.a))) {
						class_cq[] var9 = class_cq.values();
						int var10 = var9.length;

						for (int var11 = 0; var11 < var10; ++var11) {
							class_cq var12 = var9[var11];
							class_cj var13 = var7.a(var12);
							if (j.p(var13).c().t() > 0) {
								j.x(var13);
							}
						}

						j.x(var7);
					}
				}
			}

		}
	}

	public void o() {
		o = true;
		p = true;
		class_cj var1 = new class_cj(b << 4, 0, c << 4);
		if (!j.t.m()) {
			if (j.a(var1.a(-1, 0, -1), var1.a(16, j.H(), 16))) {
				label44: for (int var2 = 0; var2 < 16; ++var2) {
					for (int var3 = 0; var3 < 16; ++var3) {
						if (!this.e(var2, var3)) {
							p = false;
							break label44;
						}
					}
				}

			if (p) {
				Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

				while (var5.hasNext()) {
					class_cq var6 = (class_cq) var5.next();
					int var4 = var6.c() == class_cq.class_b_in_class_cq.a ? 16 : 1;
					j.f(var1.a(var6, var4)).a(var6.d());
				}

				z();
			}
			} else {
				p = false;
			}
		}

	}

	private void z() {
		for (int var1 = 0; var1 < h.length; ++var1) {
			h[var1] = true;
		}

		this.h(false);
	}

	private void a(class_cq var1) {
		if (o) {
			int var2;
			if (var1 == class_cq.f) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(15, var2);
				}
			} else if (var1 == class_cq.e) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(0, var2);
				}
			} else if (var1 == class_cq.d) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 15);
				}
			} else if (var1 == class_cq.c) {
				for (var2 = 0; var2 < 16; ++var2) {
					this.e(var2, 0);
				}
			}

		}
	}

	private boolean e(int var1, int var2) {
		int var3 = this.g();
		boolean var4 = false;
		boolean var5 = false;
		class_cj.class_a_in_class_cj var6 = new class_cj.class_a_in_class_cj((b << 4) + var1, 0, (c << 4) + var2);

		int var7;
		for (var7 = (var3 + 16) - 1; (var7 > j.H()) || ((var7 > 0) && !var5); --var7) {
			var6.c(var6.n(), var7, var6.p());
			int var8 = this.b(var6);
			if ((var8 == 255) && (var6.o() < j.H())) {
				var5 = true;
			}

			if (!var4 && (var8 > 0)) {
				var4 = true;
			} else if (var4 && (var8 == 0) && !j.x(var6)) {
				return false;
			}
		}

		for (var7 = var6.o(); var7 > 0; --var7) {
			var6.c(var6.n(), var7, var6.p());
			if (this.a(var6).t() > 0) {
				j.x(var6);
			}
		}

		return true;
	}

	public boolean p() {
		return i;
	}

	public class_ago q() {
		return j;
	}

	public int[] r() {
		return k;
	}

	public void a(int[] var1) {
		if (k.length != var1.length) {
			d.warn("Could not set level chunk heightmap, array length is " + var1.length + " instead of " + k.length);
		} else {
			for (int var2 = 0; var2 < k.length; ++var2) {
				k[var2] = var1[var2];
			}

		}
	}

	public Map s() {
		return m;
	}

	public class_nm[] t() {
		return n;
	}

	public boolean u() {
		return o;
	}

	public void d(boolean var1) {
		o = var1;
	}

	public boolean v() {
		return p;
	}

	public void e(boolean var1) {
		p = var1;
	}

	public void f(boolean var1) {
		r = var1;
	}

	public void g(boolean var1) {
		s = var1;
	}

	public void b(long var1) {
		t = var1;
	}

	public int w() {
		return u;
	}

	public long x() {
		return v;
	}

	public void c(long var1) {
		v = var1;
	}

	public static enum class_a_in_class_aqn {
		a,
		b,
		c;
	}
}
