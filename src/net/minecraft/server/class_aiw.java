package net.minecraft.server;

import java.util.Iterator;

public class class_aiw extends class_aif {
	public static final class_apz a;
	public final int b;

	protected class_aiw(int var1) {
		super(class_avq.d);
		this.j(M.b().a(a, class_cq.c));
		b = var1;
		this.a(class_abp.c);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public int b() {
		return 2;
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		if (var1.p(var2.c()).c() == this) {
			this.a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
		} else if (var1.p(var2.d()).c() == this) {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
		} else if (var1.p(var2.e()).c() == this) {
			this.a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		} else if (var1.p(var2.f()).c() == this) {
			this.a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
		} else {
			this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
		}

	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		this.f(var1, var2, var3);
		Iterator var4 = class_cq.class_c_in_class_cq.a.iterator();

		while (var4.hasNext()) {
			class_cq var5 = (class_cq) var4.next();
			class_cj var6 = var2.a(var5);
			class_apn var7 = var1.p(var6);
			if (var7.c() == this) {
				this.f(var1, var6, var7);
			}
		}

	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(a, var8.aV());
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		class_cq var6 = class_cq.b(class_oa.c((var4.y * 4.0F) / 360.0F + 0.5D) & 3).d();
		var3 = var3.a(a, var6);
		class_cj var7 = var2.c();
		class_cj var8 = var2.d();
		class_cj var9 = var2.e();
		class_cj var10 = var2.f();
		boolean var11 = this == var1.p(var7).c();
		boolean var12 = this == var1.p(var8).c();
		boolean var13 = this == var1.p(var9).c();
		boolean var14 = this == var1.p(var10).c();
		if (!var11 && !var12 && !var13 && !var14) {
			var1.a(var2, var3, 3);
		} else if ((var6.k() == class_cq.class_a_in_class_cq.a) && (var11 || var12)) {
			if (var11) {
				var1.a(var7, var3, 3);
			} else {
				var1.a(var8, var3, 3);
			}

			var1.a(var2, var3, 3);
		} else if ((var6.k() == class_cq.class_a_in_class_cq.c) && (var13 || var14)) {
			if (var13) {
				var1.a(var9, var3, 3);
			} else {
				var1.a(var10, var3, 3);
			}

			var1.a(var2, var3, 3);
		}

		if (var5.s()) {
			TileEntity var15 = var1.s(var2);
			if (var15 instanceof class_aok) {
				((class_aok) var15).a(var5.q());
			}
		}

	}

	public class_apn f(class_ago var1, class_cj var2, class_apn var3) {
		if (var1.D) {
			return var3;
		} else {
			class_apn var4 = var1.p(var2.c());
			class_apn var5 = var1.p(var2.d());
			class_apn var6 = var1.p(var2.e());
			class_apn var7 = var1.p(var2.f());
			class_cq var8 = (class_cq) var3.b(a);
			Block var9 = var4.c();
			Block var10 = var5.c();
			Block var11 = var6.c();
			Block var12 = var7.c();
			if ((var9 != this) && (var10 != this)) {
				boolean var21 = var9.q();
				boolean var22 = var10.q();
				if ((var11 == this) || (var12 == this)) {
					class_cj var23 = var11 == this ? var2.e() : var2.f();
					class_apn var24 = var1.p(var23.c());
					class_apn var25 = var1.p(var23.d());
					var8 = class_cq.d;
					class_cq var26;
					if (var11 == this) {
						var26 = (class_cq) var6.b(a);
					} else {
						var26 = (class_cq) var7.b(a);
					}

					if (var26 == class_cq.c) {
						var8 = class_cq.c;
					}

					Block var19 = var24.c();
					Block var20 = var25.c();
					if ((var21 || var19.q()) && !var22 && !var20.q()) {
						var8 = class_cq.d;
					}

					if ((var22 || var20.q()) && !var21 && !var19.q()) {
						var8 = class_cq.c;
					}
				}
			} else {
				class_cj var13 = var9 == this ? var2.c() : var2.d();
				class_apn var14 = var1.p(var13.e());
				class_apn var15 = var1.p(var13.f());
				var8 = class_cq.f;
				class_cq var16;
				if (var9 == this) {
					var16 = (class_cq) var4.b(a);
				} else {
					var16 = (class_cq) var5.b(a);
				}

				if (var16 == class_cq.e) {
					var8 = class_cq.e;
				}

				Block var17 = var14.c();
				Block var18 = var15.c();
				if ((var11.q() || var17.q()) && !var12.q() && !var18.q()) {
					var8 = class_cq.f;
				}

				if ((var12.q() || var18.q()) && !var11.q() && !var17.q()) {
					var8 = class_cq.e;
				}
			}

			var3 = var3.a(a, var8);
			var1.a(var2, var3, 3);
			return var3;
		}
	}

	public class_apn g(class_ago var1, class_cj var2, class_apn var3) {
		class_cq var4 = null;
		Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

		while (var5.hasNext()) {
			class_cq var6 = (class_cq) var5.next();
			class_apn var7 = var1.p(var2.a(var6));
			if (var7.c() == this) {
				return var3;
			}

			if (var7.c().q()) {
				if (var4 != null) {
					var4 = null;
					break;
				}

				var4 = var6;
			}
		}

		if (var4 != null) {
			return var3.a(a, var4.d());
		} else {
			class_cq var8 = (class_cq) var3.b(a);
			if (var1.p(var2.a(var8)).c().q()) {
				var8 = var8.d();
			}

			if (var1.p(var2.a(var8)).c().q()) {
				var8 = var8.e();
			}

			if (var1.p(var2.a(var8)).c().q()) {
				var8 = var8.d();
			}

			return var3.a(a, var8);
		}
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		int var3 = 0;
		class_cj var4 = var2.e();
		class_cj var5 = var2.f();
		class_cj var6 = var2.c();
		class_cj var7 = var2.d();
		if (var1.p(var4).c() == this) {
			if (this.k(var1, var4)) {
				return false;
			}

			++var3;
		}

		if (var1.p(var5).c() == this) {
			if (this.k(var1, var5)) {
				return false;
			}

			++var3;
		}

		if (var1.p(var6).c() == this) {
			if (this.k(var1, var6)) {
				return false;
			}

			++var3;
		}

		if (var1.p(var7).c() == this) {
			if (this.k(var1, var7)) {
				return false;
			}

			++var3;
		}

		return var3 <= 1;
	}

	private boolean k(class_ago var1, class_cj var2) {
		if (var1.p(var2).c() != this) {
			return false;
		} else {
			Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

			class_cq var4;
			do {
				if (!var3.hasNext()) {
					return false;
				}

				var4 = (class_cq) var3.next();
			} while (var1.p(var2.a(var4)).c() != this);

			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		super.a(var1, var2, var3, var4);
		TileEntity var5 = var1.s(var2);
		if (var5 instanceof class_aok) {
			var5.E();
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		TileEntity var4 = var1.s(var2);
		if (var4 instanceof class_pp) {
			class_pr.a(var1, var2, (class_pp) var4);
			var1.f(var2, this);
		}

		super.c(var1, var2, var3);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			class_qa var11 = this.e(var1, var2);
			if (var11 != null) {
				var4.a((class_pp) var11);
				if (b == 0) {
					var4.b(class_nh.ab);
				} else if (b == 1) {
					var4.b(class_nh.V);
				}
			}

			return true;
		}
	}

	public class_qa e(class_ago var1, class_cj var2) {
		TileEntity var3 = var1.s(var2);
		if (!(var3 instanceof class_aok)) {
			return null;
		} else {
			Object var4 = var3;
			if (l(var1, var2)) {
				return null;
			} else {
				Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

				while (true) {
					while (true) {
						class_cq var6;
						TileEntity var9;
						do {
							class_cj var7;
							Block var8;
							do {
								if (!var5.hasNext()) {
									return (class_qa) var4;
								}

								var6 = (class_cq) var5.next();
								var7 = var2.a(var6);
								var8 = var1.p(var7).c();
							} while (var8 != this);

							if (l(var1, var7)) {
								return null;
							}

							var9 = var1.s(var7);
						} while (!(var9 instanceof class_aok));

						if ((var6 != class_cq.e) && (var6 != class_cq.c)) {
							var4 = new class_po("container.chestDouble", (class_qa) var4, (class_aok) var9);
						} else {
							var4 = new class_po("container.chestDouble", (class_aok) var9, (class_qa) var4);
						}
					}
				}
			}
		}
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aok();
	}

	@Override
	public boolean i() {
		return b == 1;
	}

	@Override
	public int a(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		if (!this.i()) {
			return 0;
		} else {
			int var5 = 0;
			TileEntity var6 = var1.s(var2);
			if (var6 instanceof class_aok) {
				var5 = ((class_aok) var6).l;
			}

			return class_oa.a(var5, 0, 15);
		}
	}

	@Override
	public int b(class_ags var1, class_cj var2, class_apn var3, class_cq var4) {
		return var4 == class_cq.b ? this.a(var1, var2, var3, var4) : 0;
	}

	private boolean l(class_ago var1, class_cj var2) {
		return m(var1, var2) || n(var1, var2);
	}

	private boolean m(class_ago var1, class_cj var2) {
		return var1.p(var2.a()).c().x();
	}

	private boolean n(class_ago var1, class_cj var2) {
		Iterator var3 = var1.a(class_vi.class, new class_ayk(var2.n(), var2.o() + 1, var2.p(), var2.n() + 1, var2.o() + 2, var2.p() + 1)).iterator();

		class_vi var5;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			Entity var4 = (Entity) var3.next();
			var5 = (class_vi) var4;
		} while (!var5.cG());

		return true;
	}

	@Override
	public boolean Q() {
		return true;
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		return class_zu.b(this.e(var1, var2));
	}

	@Override
	public class_apn a(int var1) {
		class_cq var2 = class_cq.a(var1);
		if (var2.k() == class_cq.class_a_in_class_cq.b) {
			var2 = class_cq.c;
		}

		return S().a(a, var2);
	}

	@Override
	public int c(class_apn var1) {
		return ((class_cq) var1.b(a)).a();
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	static {
		a = class_akx.O;
	}
}
