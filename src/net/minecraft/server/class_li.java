package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;

public class class_li {
	private static final Logger a = LogManager.getLogger();
	private final class_ll b;
	private final List c = Lists.newArrayList();
	private final class_ny d = new class_ny();
	private final List e = Lists.newArrayList();
	private final List f = Lists.newArrayList();
	private int g;
	private long h;
	private final int[][] i = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public class_li(class_ll var1) {
		b = var1;
		this.a(var1.t().ar().s());
	}

	public class_ll a() {
		return b;
	}

	public Iterator b() {
		final Iterator var1 = f.iterator();
		return new AbstractIterator() {
			protected class_aqn a() {
				label23: while (true) {
					if (var1.hasNext()) {
						class_li.class_a_in_class_li var1x = (class_li.class_a_in_class_li) var1.next();
						class_aqn var2 = b.a(var1x.c.a, var1x.c.b);
						if (!var2.j()) {
							return var2;
						}

						Iterator var3 = var1x.b.iterator();

						class_lm var4;
						do {
							if (!var3.hasNext()) {
								continue label23;
							}

							var4 = (class_lm) var3.next();
						} while (var1x.c.a(var4) >= 16384.0D);

						return var2;
					}

					return (class_aqn) endOfData();
				}
			}

			// $FF: synthetic method
			@Override
			protected Object computeNext() {
				return this.a();
			}
		};
	}

	public void c() {
		long var1 = b.M();
		int var3;
		class_li.class_a_in_class_li var4;
		if ((var1 - h) > 8000L) {
			h = var1;

			for (var3 = 0; var3 < f.size(); ++var3) {
				var4 = (class_li.class_a_in_class_li) f.get(var3);
				var4.b();
				var4.a();
			}
		} else {
			for (var3 = 0; var3 < e.size(); ++var3) {
				var4 = (class_li.class_a_in_class_li) e.get(var3);
				var4.b();
			}
		}

		e.clear();
		if (c.isEmpty()) {
			class_arc var5 = b.t;
			if (!var5.e()) {
				b.b.b();
			}
		}

	}

	public boolean a(int var1, int var2) {
		long var3 = (var1 + 2147483647L) | ((var2 + 2147483647L) << 32);
		return d.a(var3) != null;
	}

	private class_li.class_a_in_class_li a(int var1, int var2, boolean var3) {
		long var4 = (var1 + 2147483647L) | ((var2 + 2147483647L) << 32);
		class_li.class_a_in_class_li var6 = (class_li.class_a_in_class_li) d.a(var4);
		if ((var6 == null) && var3) {
			var6 = new class_li.class_a_in_class_li(var1, var2);
			d.a(var4, var6);
			f.add(var6);
		}

		return var6;
	}

	public void a(class_cj var1) {
		int var2 = var1.n() >> 4;
		int var3 = var1.p() >> 4;
		class_li.class_a_in_class_li var4 = this.a(var2, var3, false);
		if (var4 != null) {
			var4.a(var1.n() & 15, var1.o(), var1.p() & 15);
		}

	}

	public void a(class_lm var1) {
		int var2 = (int) var1.s >> 4;
			int var3 = (int) var1.u >> 4;
			var1.d = var1.s;
			var1.e = var1.u;

			for (int var4 = var2 - g; var4 <= (var2 + g); ++var4) {
				for (int var5 = var3 - g; var5 <= (var3 + g); ++var5) {
					this.a(var4, var5, true).a(var1);
				}
			}

			c.add(var1);
			this.b(var1);
	}

	public void b(class_lm var1) {
		ArrayList var2 = Lists.newArrayList((Iterable) var1.f);
		int var3 = 0;
		int var4 = g;
		int var5 = (int) var1.s >> 4;
				int var6 = (int) var1.u >> 4;
				int var7 = 0;
				int var8 = 0;
				class_agi var9 = this.a(var5, var6, true).c;
				var1.f.clear();
				if (var2.contains(var9)) {
					var1.f.add(var9);
				}

				int var10;
				for (var10 = 1; var10 <= (var4 * 2); ++var10) {
					for (int var11 = 0; var11 < 2; ++var11) {
						int[] var12 = i[var3++ % 4];

						for (int var13 = 0; var13 < var10; ++var13) {
							var7 += var12[0];
							var8 += var12[1];
							var9 = this.a(var5 + var7, var6 + var8, true).c;
							if (var2.contains(var9)) {
								var1.f.add(var9);
							}
						}
					}
				}

				var3 %= 4;

				for (var10 = 0; var10 < (var4 * 2); ++var10) {
					var7 += i[var3][0];
					var8 += i[var3][1];
					var9 = this.a(var5 + var7, var6 + var8, true).c;
					if (var2.contains(var9)) {
						var1.f.add(var9);
					}
				}

	}

	public void c(class_lm var1) {
		int var2 = (int) var1.d >> 4;
				int var3 = (int) var1.e >> 4;

					for (int var4 = var2 - g; var4 <= (var2 + g); ++var4) {
						for (int var5 = var3 - g; var5 <= (var3 + g); ++var5) {
							class_li.class_a_in_class_li var6 = this.a(var4, var5, false);
							if (var6 != null) {
								var6.b(var1);
							}
						}
					}

					c.remove(var1);
	}

	private boolean a(int var1, int var2, int var3, int var4, int var5) {
		int var6 = var1 - var3;
		int var7 = var2 - var4;
		return (var6 >= -var5) && (var6 <= var5) ? (var7 >= -var5) && (var7 <= var5) : false;
	}

	public void d(class_lm var1) {
		int var2 = (int) var1.s >> 4;
		int var3 = (int) var1.u >> 4;
		double var4 = var1.d - var1.s;
		double var6 = var1.e - var1.u;
		double var8 = (var4 * var4) + (var6 * var6);
		if (var8 >= 64.0D) {
			int var10 = (int) var1.d >> 4;
			int var11 = (int) var1.e >> 4;
			int var12 = g;
			int var13 = var2 - var10;
			int var14 = var3 - var11;
			if ((var13 != 0) || (var14 != 0)) {
				for (int var15 = var2 - var12; var15 <= (var2 + var12); ++var15) {
					for (int var16 = var3 - var12; var16 <= (var3 + var12); ++var16) {
						if (!this.a(var15, var16, var10, var11, var12)) {
							this.a(var15, var16, true).a(var1);
						}

						if (!this.a(var15 - var13, var16 - var14, var2, var3, var12)) {
							class_li.class_a_in_class_li var17 = this.a(var15 - var13, var16 - var14, false);
							if (var17 != null) {
								var17.b(var1);
							}
						}
					}
				}

				this.b(var1);
				var1.d = var1.s;
				var1.e = var1.u;
			}
		}
	}

	public boolean a(class_lm var1, int var2, int var3) {
		class_li.class_a_in_class_li var4 = this.a(var2, var3, false);
		return (var4 != null) && var4.b.contains(var1) && !var1.f.contains(var4.c);
	}

	public void a(int var1) {
		var1 = class_oa.a(var1, 3, 32);
		if (var1 != g) {
			int var2 = var1 - g;
			ArrayList var3 = Lists.newArrayList((Iterable) c);
			Iterator var4 = var3.iterator();

			while (true) {
				while (var4.hasNext()) {
					class_lm var5 = (class_lm) var4.next();
					int var6 = (int) var5.s >> 4;
					int var7 = (int) var5.u >> 4;
					int var8;
					int var9;
					if (var2 > 0) {
						for (var8 = var6 - var1; var8 <= (var6 + var1); ++var8) {
							for (var9 = var7 - var1; var9 <= (var7 + var1); ++var9) {
								class_li.class_a_in_class_li var10 = this.a(var8, var9, true);
								if (!var10.b.contains(var5)) {
									var10.a(var5);
								}
							}
						}
					} else {
						for (var8 = var6 - g; var8 <= (var6 + g); ++var8) {
							for (var9 = var7 - g; var9 <= (var7 + g); ++var9) {
								if (!this.a(var8, var9, var6, var7, var1)) {
									this.a(var8, var9, true).b(var5);
								}
							}
						}
					}
				}

				g = var1;
				return;
			}
		}
	}

	public static int b(int var0) {
		return (var0 * 16) - 16;
	}

	class class_a_in_class_li {
		private final List b = Lists.newArrayList();
		private final class_agi c;
		private final short[] d = new short[64];
		private int e;
		private int f;
		private long g;

		public class_a_in_class_li(int var2, int var3) {
			c = new class_agi(var2, var3);
			class_li.this.a().b.c(var2, var3);
		}

		public void a(class_lm var1) {
			if (b.contains(var1)) {
				class_li.a.debug("Failed to add player. {} already is in chunk {}, {}", new Object[] { var1, Integer.valueOf(c.a), Integer.valueOf(c.b) });
			} else {
				if (b.isEmpty()) {
					g = class_li.this.b.M();
				}

				b.add(var1);
				var1.f.add(c);
			}
		}

		public void b(class_lm var1) {
			if (b.contains(var1)) {
				class_aqn var2 = class_li.this.b.a(c.a, c.b);
				if (var2.i()) {
					var1.a.a((new class_gp(var2, true, 0)));
				}

				b.remove(var1);
				var1.f.remove(c);
				if (b.isEmpty()) {
					long var3 = (c.a + 2147483647L) | ((c.b + 2147483647L) << 32);
					this.a(var2);
					class_li.this.d.d(var3);
					class_li.this.f.remove(this);
					if (e > 0) {
						class_li.this.e.remove(this);
					}

					class_li.this.a().b.b(c.a, c.b);
				}

			}
		}

		public void a() {
			this.a(class_li.this.b.a(c.a, c.b));
		}

		private void a(class_aqn var1) {
			var1.c((var1.x() + class_li.this.b.M()) - g);
			g = class_li.this.b.M();
		}

		public void a(int var1, int var2, int var3) {
			if (e == 0) {
				class_li.this.e.add(this);
			}

			f |= 1 << (var2 >> 4);
			if (e < 64) {
				short var4 = (short) ((var1 << 12) | (var3 << 8) | var2);

				for (int var5 = 0; var5 < e; ++var5) {
					if (d[var5] == var4) {
						return;
					}
				}

				d[e++] = var4;
			}

		}

		public void a(class_ff var1) {
			for (int var2 = 0; var2 < b.size(); ++var2) {
				class_lm var3 = (class_lm) b.get(var2);
				if (!var3.f.contains(c)) {
					var3.a.a(var1);
				}
			}

		}

		public void b() {
			if (e != 0) {
				int var1;
				int var2;
				int var3;
				if (e == 1) {
					var1 = ((d[0] >> 12) & 15) + (c.a * 16);
					var2 = d[0] & 255;
					var3 = ((d[0] >> 8) & 15) + (c.b * 16);
					class_cj var4 = new class_cj(var1, var2, var3);
					this.a((new class_fv(class_li.this.b, var4)));
					if (class_li.this.b.p(var4).c().B()) {
						this.a(class_li.this.b.s(var4));
					}
				} else {
					int var7;
					if (e == 64) {
						var1 = c.a * 16;
						var2 = c.b * 16;
						this.a((new class_gp(class_li.this.b.a(c.a, c.b), false, f)));

						for (var3 = 0; var3 < 16; ++var3) {
							if ((f & (1 << var3)) != 0) {
								var7 = var3 << 4;
								List var5 = class_li.this.b.a(var1, var7, var2, var1 + 16, var7 + 16, var2 + 16);

								for (int var6 = 0; var6 < var5.size(); ++var6) {
									this.a((TileEntity) var5.get(var6));
								}
							}
						}
					} else {
						this.a((new class_ga(e, d, class_li.this.b.a(c.a, c.b))));

						for (var1 = 0; var1 < e; ++var1) {
							var2 = ((d[var1] >> 12) & 15) + (c.a * 16);
							var3 = d[var1] & 255;
							var7 = ((d[var1] >> 8) & 15) + (c.b * 16);
							class_cj var8 = new class_cj(var2, var3, var7);
							if (class_li.this.b.p(var8).c().B()) {
								this.a(class_li.this.b.s(var8));
							}
						}
					}
				}

				e = 0;
				f = 0;
			}
		}

		private void a(TileEntity var1) {
			if (var1 != null) {
				class_ff var2 = var1.x_();
				if (var2 != null) {
					this.a(var2);
				}
			}

		}
	}
}
