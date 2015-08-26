package net.minecraft.server;

import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

public class BlockRedstoneComparator extends class_ajj implements class_ajy {
	public static final class_apy a = class_apy.a("powered");
	public static final class_aqa b = class_aqa.a("mode", BlockRedstoneComparator.class_a_in_class_ajd.class);

	public BlockRedstoneComparator(boolean var1) {
		super(var1);
		this.j(M.b().a(O, class_cq.c).a(a, Boolean.valueOf(false)).a(b, BlockRedstoneComparator.class_a_in_class_ajd.a));
		A = true;
	}

	@Override
	public String f() {
		return class_di.a("item.comparator.name");
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Items.cj;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.cj);
	}

	@Override
	protected int d(class_apn var1) {
		return 2;
	}

	@Override
	protected class_apn e(class_apn var1) {
		Boolean var2 = (Boolean) var1.b(a);
		BlockRedstoneComparator.class_a_in_class_ajd var3 = (BlockRedstoneComparator.class_a_in_class_ajd) var1.b(b);
		class_cq var4 = (class_cq) var1.b(O);
		return Blocks.POWERED_COMPARATOR.S().a(O, var4).a(a, var2).a(b, var3);
	}

	@Override
	protected class_apn k(class_apn var1) {
		Boolean var2 = (Boolean) var1.b(a);
		BlockRedstoneComparator.class_a_in_class_ajd var3 = (BlockRedstoneComparator.class_a_in_class_ajd) var1.b(b);
		class_cq var4 = (class_cq) var1.b(O);
		return Blocks.UNPOWERED_COMPARATOR.S().a(O, var4).a(a, var2).a(b, var3);
	}

	@Override
	protected boolean l(class_apn var1) {
		return N || ((Boolean) var1.b(a)).booleanValue();
	}

	@Override
	protected int a(class_ags var1, class_cj var2, class_apn var3) {
		TileEntity var4 = var1.s(var2);
		return var4 instanceof class_aom ? ((class_aom) var4).b() : 0;
	}

	private int k(class_ago var1, class_cj var2, class_apn var3) {
		return var3.b(b) == BlockRedstoneComparator.class_a_in_class_ajd.b ? Math.max(this.g(var1, var2, var3) - this.c((class_ags) var1, var2, var3), 0) : this.g(var1, var2, var3);
	}

	@Override
	protected boolean f(class_ago var1, class_cj var2, class_apn var3) {
		int var4 = this.g(var1, var2, var3);
		if (var4 >= 15) {
			return true;
		} else if (var4 == 0) {
			return false;
		} else {
			int var5 = this.c((class_ags) var1, var2, var3);
			return var5 == 0 ? true : var4 >= var5;
		}
	}

	@Override
	protected int g(class_ago var1, class_cj var2, class_apn var3) {
		int var4 = super.g(var1, var2, var3);
		class_cq var5 = (class_cq) var3.b(O);
		class_cj var6 = var2.a(var5);
		Block var7 = var1.p(var6).c();
		if (var7.Q()) {
			var4 = var7.j(var1, var6);
		} else if ((var4 < 15) && var7.x()) {
			var6 = var6.a(var5);
			var7 = var1.p(var6).c();
			if (var7.Q()) {
				var4 = var7.j(var1, var6);
			} else if (var7.v() == class_avq.a) {
				class_wu var8 = this.a(var1, var5, var6);
				if (var8 != null) {
					var4 = var8.p();
				}
			}
		}

		return var4;
	}

	private class_wu a(class_ago var1, final class_cq var2, class_cj var3) {
		List var4 = var1.a(class_wu.class, new class_ayk(var3.n(), var3.o(), var3.p(), var3.n() + 1, var3.o() + 1, var3.p() + 1), new Predicate() {
			public boolean a(Entity var1) {
				return (var1 != null) && (var1.aV() == var2);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		});
		return var4.size() == 1 ? (class_wu) var4.get(0) : null;
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (!var4.bI.e) {
			return false;
		} else {
			var3 = var3.a(b);
			var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D, "random.click", 0.3F, var3.b(b) == BlockRedstoneComparator.class_a_in_class_ajd.b ? 0.55F : 0.5F);
			var1.a(var2, var3, 2);
			this.l(var1, var2, var3);
			return true;
		}
	}

	@Override
	protected void h(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.a(var2, this)) {
			int var4 = this.k(var1, var2, var3);
			TileEntity var5 = var1.s(var2);
			int var6 = var5 instanceof class_aom ? ((class_aom) var5).b() : 0;
			if ((var4 != var6) || (this.l(var3) != this.f(var1, var2, var3))) {
				if (this.j(var1, var2, var3)) {
					var1.a(var2, this, 2, -1);
				} else {
					var1.a(var2, this, 2, 0);
				}
			}

		}
	}

	private void l(class_ago var1, class_cj var2, class_apn var3) {
		int var4 = this.k(var1, var2, var3);
		TileEntity var5 = var1.s(var2);
		int var6 = 0;
		if (var5 instanceof class_aom) {
			class_aom var7 = (class_aom) var5;
			var6 = var7.b();
			var7.a(var4);
		}

		if ((var6 != var4) || (var3.b(b) == BlockRedstoneComparator.class_a_in_class_ajd.a)) {
			boolean var9 = this.f(var1, var2, var3);
			boolean var8 = this.l(var3);
			if (var8 && !var9) {
				var1.a(var2, var3.a(a, Boolean.valueOf(false)), 2);
			} else if (!var8 && var9) {
				var1.a(var2, var3.a(a, Boolean.valueOf(true)), 2);
			}

			this.i(var1, var2, var3);
		}

	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (N) {
			var1.a(var2, this.k(var3).a(a, Boolean.valueOf(true)), 4);
		}

		this.l(var1, var2, var3);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		super.d(var1, var2, var3);
		var1.a(var2, this.a(var1, 0));
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		super.c(var1, var2, var3);
		var1.t(var2);
		this.i(var1, var2, var3);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, int var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		TileEntity var6 = var1.s(var2);
		return var6 == null ? false : var6.c(var4, var5);
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return new class_aom();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(O, class_cq.b(var1)).a(a, Boolean.valueOf((var1 & 8) > 0)).a(b, (var1 & 4) > 0 ? BlockRedstoneComparator.class_a_in_class_ajd.b : BlockRedstoneComparator.class_a_in_class_ajd.a);
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(O)).b();
		if (((Boolean) var1.b(a)).booleanValue()) {
			var3 |= 8;
		}

		if (var1.b(b) == BlockRedstoneComparator.class_a_in_class_ajd.b) {
			var3 |= 4;
		}

		return var3;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(O, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(O)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { O, b, a });
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(O, var8.aV().d()).a(a, Boolean.valueOf(false)).a(b, BlockRedstoneComparator.class_a_in_class_ajd.a);
	}

	public static enum class_a_in_class_ajd implements class_oe {
		a("compare"),
		b("subtract");

		private final String c;

		private class_a_in_class_ajd(String var3) {
			c = var3;
		}

		@Override
		public String toString() {
			return c;
		}

		@Override
		public String l() {
			return c;
		}
	}
}
