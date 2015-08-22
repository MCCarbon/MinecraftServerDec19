package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_aae extends class_zu {
	public class_pp a = new class_qc("Enchant", true, 2) {
		@Override
		public int p_() {
			return 64;
		}

		@Override
		public void o_() {
			super.o_();
			class_aae.this.a(this);
		}
	};
	private class_ago j;
	private class_cj k;
	private Random l = new Random();
	public int f;
	public int[] g = new int[3];
	public int[] h = new int[] { -1, -1, -1 };
	public int[] i = new int[] { -1, -1, -1 };

	public class_aae(class_yt var1, class_ago var2, class_cj var3) {
		j = var2;
		k = var3;
		f = var1.e.cr();
		this.a((new class_aas(a, 0, 15, 47) {
			@Override
			public boolean a(class_aco var1) {
				return true;
			}

			@Override
			public int a() {
				return 1;
			}
		}));
		this.a((new class_aas(a, 1, 35, 47) {
			@Override
			public boolean a(class_aco var1) {
				return (var1.b() == Items.aY) && (class_abt.a(var1.i()) == class_abt.l);
			}
		}));

		int var4;
		for (var4 = 0; var4 < 3; ++var4) {
			for (int var5 = 0; var5 < 9; ++var5) {
				this.a((new class_aas(var1, var5 + (var4 * 9) + 9, 8 + (var5 * 18), 84 + (var4 * 18))));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.a((new class_aas(var1, var4, 8 + (var4 * 18), 142)));
		}

	}

	protected void c(class_zz var1) {
		var1.a(this, 0, g[0]);
		var1.a(this, 1, g[1]);
		var1.a(this, 2, g[2]);
		var1.a(this, 3, f & -16);
		var1.a(this, 4, h[0]);
		var1.a(this, 5, h[1]);
		var1.a(this, 6, h[2]);
		var1.a(this, 7, i[0]);
		var1.a(this, 8, i[1]);
		var1.a(this, 9, i[2]);
	}

	@Override
	public void a(class_zz var1) {
		super.a(var1);
		this.c(var1);
	}

	@Override
	public void b() {
		super.b();

		for (int var1 = 0; var1 < e.size(); ++var1) {
			class_zz var2 = (class_zz) e.get(var1);
			this.c(var2);
		}

	}

	@Override
	public void a(class_pp var1) {
		if (var1 == a) {
			class_aco var2 = var1.a(0);
			int var3;
			if ((var2 != null) && var2.v()) {
				if (!j.D) {
					var3 = 0;

					int var4;
					for (var4 = -1; var4 <= 1; ++var4) {
						for (int var5 = -1; var5 <= 1; ++var5) {
							if (((var4 != 0) || (var5 != 0)) && j.d(k.a(var5, 0, var4)) && j.d(k.a(var5, 1, var4))) {
								if (j.p(k.a(var5 * 2, 0, var4 * 2)).c() == Blocks.X) {
									++var3;
								}

								if (j.p(k.a(var5 * 2, 1, var4 * 2)).c() == Blocks.X) {
									++var3;
								}

								if ((var5 != 0) && (var4 != 0)) {
									if (j.p(k.a(var5 * 2, 0, var4)).c() == Blocks.X) {
										++var3;
									}

									if (j.p(k.a(var5 * 2, 1, var4)).c() == Blocks.X) {
										++var3;
									}

									if (j.p(k.a(var5, 0, var4 * 2)).c() == Blocks.X) {
										++var3;
									}

									if (j.p(k.a(var5, 1, var4 * 2)).c() == Blocks.X) {
										++var3;
									}
								}
							}
						}
					}

					l.setSeed(f);

					for (var4 = 0; var4 < 3; ++var4) {
						g[var4] = class_afl.a(l, var4, var3, var2);
						h[var4] = -1;
						i[var4] = -1;
						if (g[var4] < (var4 + 1)) {
							g[var4] = 0;
						}
					}

					for (var4 = 0; var4 < 3; ++var4) {
						if (g[var4] > 0) {
							List var7 = this.a(var2, var4, g[var4]);
							if ((var7 != null) && !var7.isEmpty()) {
								class_afm var6 = (class_afm) var7.get(l.nextInt(var7.size()));
								h[var4] = class_afj.b(var6.b);
								i[var4] = var6.c;
							}
						}
					}

					this.b();
				}
			} else {
				for (var3 = 0; var3 < 3; ++var3) {
					g[var3] = 0;
					h[var3] = -1;
					i[var3] = -1;
				}
			}
		}

	}

	@Override
	public boolean a(class_yu var1, int var2) {
		class_aco var3 = a.a(0);
		class_aco var4 = a.a(1);
		int var5 = var2 + 1;
		if (((var4 == null) || (var4.b < var5)) && !var1.bI.d) {
			return false;
		} else if ((g[var2] <= 0) || (var3 == null) || (((var1.bJ < var5) || (var1.bJ < g[var2])) && !var1.bI.d)) {
			return false;
		} else {
			if (!j.D) {
				List var6 = this.a(var3, var2, g[var2]);
				boolean var7 = var3.b() == Items.aN;
				if (var6 != null) {
					var1.b(var5);
					if (var7) {
						var3.a(Items.ci);
					}

					for (int var8 = 0; var8 < var6.size(); ++var8) {
						class_afm var9 = (class_afm) var6.get(var8);
						if (var7) {
							Items.ci.a(var3, var9);
						} else {
							var3.a(var9.b, var9.c);
						}
					}

					if (!var1.bI.d) {
						var4.b -= var5;
						if (var4.b <= 0) {
							a.a(1, (class_aco) null);
						}
					}

					var1.b(class_nh.X);
					a.o_();
					f = var1.cr();
					this.a(a);
				}
			}

			return true;
		}
	}

	private List a(class_aco var1, int var2, int var3) {
		l.setSeed(f + var2);
		List var4 = class_afl.b(l, var1, var3);
		if ((var1.b() == Items.aN) && (var4.size() > 1)) {
			var4.remove(l.nextInt(var4.size()));
		}

		return var4;
	}

	@Override
	public void b(class_yu var1) {
		super.b(var1);
		if (!j.D) {
			for (int var2 = 0; var2 < a.n_(); ++var2) {
				class_aco var3 = a.b(var2);
				if (var3 != null) {
					var1.a(var3, false);
				}
			}

		}
	}

	@Override
	public boolean a(class_yu var1) {
		return j.p(k).c() != Blocks.bC ? false : var1.e(k.n() + 0.5D, k.o() + 0.5D, k.p() + 0.5D) <= 64.0D;
	}

	@Override
	public class_aco b(class_yu var1, int var2) {
		class_aco var3 = null;
		class_aas var4 = (class_aas) c.get(var2);
		if ((var4 != null) && var4.e()) {
			class_aco var5 = var4.d();
			var3 = var5.k();
			if (var2 == 0) {
				if (!this.a(var5, 2, 38, true)) {
					return null;
				}
			} else if (var2 == 1) {
				if (!this.a(var5, 2, 38, true)) {
					return null;
				}
			} else if ((var5.b() == Items.aY) && (class_abt.a(var5.i()) == class_abt.l)) {
				if (!this.a(var5, 1, 2, true)) {
					return null;
				}
			} else {
				if (((class_aas) c.get(0)).e() || !((class_aas) c.get(0)).a(var5)) {
					return null;
				}

				if (var5.n() && (var5.b == 1)) {
					((class_aas) c.get(0)).d(var5.k());
					var5.b = 0;
				} else if (var5.b >= 1) {
					((class_aas) c.get(0)).d(new class_aco(var5.b(), 1, var5.i()));
					--var5.b;
				}
			}

			if (var5.b == 0) {
				var4.d((class_aco) null);
			} else {
				var4.f();
			}

			if (var5.b == var3.b) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}
}
