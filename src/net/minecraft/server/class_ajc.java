package net.minecraft.server;

import java.util.Random;

public class class_ajc extends class_aif {
	public static final class_apz a;

	public class_ajc() {
		super(class_avq.f, class_avr.z);
		this.j(M.b().a(a, class_cq.c));
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		class_aol var3 = new class_aol();
		return var3;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.D) {
			TileEntity var5 = var1.s(var2);
			if (var5 instanceof class_aol) {
				class_aol var6 = (class_aol) var5;
				boolean var7 = var1.z(var2);
				boolean var8 = var6.d();
				if (var7 && !var8) {
					var6.a(true);
					if (var6.g() != class_aol.class_a_in_class_aol.a) {
						var1.a(var2, this, this.a(var1));
						this.e(var1, var2);
					}
				} else if (!var7 && var8) {
					var6.a(false);
				}

			}
		}
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			TileEntity var5 = var1.s(var2);
			if (var5 instanceof class_aol) {
				class_aol var6 = (class_aol) var5;
				class_age var7 = var6.b();
				class_aol.class_a_in_class_aol var8 = var6.g();
				boolean var9;
				if (!var6.e()) {
					var9 = true;
				} else {
					class_cq var10 = (class_cq) var3.b(a);
					TileEntity var11 = var1.s(var2.a(var10.d()));
					var9 = (var11 instanceof class_aol) && (((class_aol) var11).b().j() > 0);
				}

				if (!var9) {
					var7.a(0);
				}

				if ((var8 != class_aol.class_a_in_class_aol.a) && var9) {
					var7.a(var1);
				}

				if (var6.d()) {
					if ((var8 == class_aol.class_a_in_class_aol.a) && var9) {
						var7.a(var1);
					}

					if (var8 == class_aol.class_a_in_class_aol.b) {
						var1.a(var2, this, this.a(var1));
						if (var9) {
							this.e(var1, var2);
						}
					}
				}

				var1.f(var2, this);
			}

		}
	}

	@Override
	public int a(class_ago var1) {
		return 1;
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		TileEntity var11 = var1.s(var2);
		if (var11 instanceof class_aol) {
			if (!var4.bI.d) {
				return false;
			} else {
				if (var4.e().D) {
					class_aol var12 = (class_aol) var11;
					var4.a(var12);
				}

				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean Q() {
		return true;
	}

	@Override
	public int j(class_ago var1, class_cj var2) {
		TileEntity var3 = var1.s(var2);
		return var3 instanceof class_aol ? ((class_aol) var3).b().j() : 0;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		TileEntity var6 = var1.s(var2);
		if (var6 instanceof class_aol) {
			class_aol var7 = (class_aol) var6;
			class_age var8 = var7.b();
			if (var5.s()) {
				var8.b(var5.q());
			}

			if (!var1.D) {
				var8.a(var1.S().b("sendCommandFeedback"));
				if (var7.g() == class_aol.class_a_in_class_aol.a) {
					boolean var9 = var1.z(var2);
					var7.a(var9);
				}
			}

		}
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_cq.a(var1 & 7));
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

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(a, class_apg.a(var1, var2, var8));
	}

	private void e(class_ago var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		if ((var3.c() == Blocks.bX) || (var3.c() == Blocks.dc)) {
			class_cj.class_a_in_class_cj var4 = new class_cj.class_a_in_class_cj(var2);
			var4.c((class_cq) var3.b(a));

			for (TileEntity var5 = var1.s(var4); var5 instanceof class_aol; var5 = var1.s(var4)) {
				class_aol var6 = (class_aol) var5;
				if (var6.g() != class_aol.class_a_in_class_aol.a) {
					break;
				}

				class_apn var7 = var1.p(var4);
				Block var8 = var7.c();
				if ((var8 != Blocks.dd) || var1.b(var4, var8)) {
					break;
				}

				var1.a(new class_cj(var4), var8, this.a(var1));
				var4.c((class_cq) var7.b(a));
			}

		}
	}

	static {
		a = class_ajk.b;
	}
}
