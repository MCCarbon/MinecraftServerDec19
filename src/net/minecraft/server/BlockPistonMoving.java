package net.minecraft.server;

import java.util.Random;

public class BlockPistonMoving extends class_aif {
	public static final class_apz a;
	public static final class_aqa b;

	public BlockPistonMoving() {
		super(class_avq.H);
		this.j(M.b().a(a, class_cq.c).a(b, BlockPistonExtension.class_a_in_class_aph.a));
		this.c(-1.0F);
	}

	@Override
	public TileEntity a(class_ago var1, int var2) {
		return null;
	}

	public static TileEntity a(class_apn var0, class_cq var1, boolean var2, boolean var3) {
		return new class_api(var0, var1, var2, var3);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		TileEntity var4 = var1.s(var2);
		if (var4 instanceof class_api) {
			((class_api) var4).h();
		} else {
			super.c(var1, var2, var3);
		}

	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return false;
	}

	@Override
	public boolean b(class_ago var1, class_cj var2, class_cq var3) {
		return false;
	}

	@Override
	public void e(class_ago var1, class_cj var2, class_apn var3) {
		class_cj var4 = var2.a(((class_cq) var3.b(a)).d());
		class_apn var5 = var1.p(var4);
		if ((var5.c() instanceof BlockPiston) && ((Boolean) var5.b(BlockPiston.a)).booleanValue()) {
			var1.g(var4);
		}

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
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (!var1.D && (var1.s(var2) == null)) {
			var1.g(var2);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		if (!var1.D) {
			class_api var6 = this.e(var1, var2);
			if (var6 != null) {
				class_apn var7 = var6.b();
				var7.c().b(var1, var2, var7, 0);
			}
		}
	}

	@Override
	public class_ayl a(class_ago var1, class_cj var2, class_aym var3, class_aym var4) {
		return null;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		if (!var1.D) {
			var1.s(var2);
		}

	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		class_api var4 = this.e(var1, var2);
		if (var4 == null) {
			return null;
		} else {
			float var5 = var4.a(0.0F);
			if (var4.d()) {
				var5 = 1.0F - var5;
			}

			return this.a(var1, var2, var4.b(), var5, var4.e());
		}
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		class_api var3 = this.e(var1, var2);
		if (var3 != null) {
			class_apn var4 = var3.b();
			Block var5 = var4.c();
			if ((var5 == this) || (var5.v() == class_avq.a)) {
				return;
			}

			float var6 = var3.a(0.0F);
			if (var3.d()) {
				var6 = 1.0F - var6;
			}

			if ((var5 == Blocks.PISTON) || (var5 == Blocks.STICKY_PISTON)) {
				var6 = 0.0F;
			}

			class_cq var7 = var3.e();

			double var8;
			double var10;
			double var12;
			double var14;
			double var16;
			double var18;
			try {
				var5.a(var1, var2);
				var8 = var5.D();
				var10 = var5.F();
				var12 = var5.H();
				var14 = var5.E();
				var16 = var5.G();
				var18 = var5.I();
			} catch (RuntimeException var21) {
				var8 = 0.0D;
				var10 = 0.0D;
				var12 = 0.0D;
				var14 = 1.0D;
				var16 = 1.0D;
				var18 = 1.0D;
			}

			B = var8 - var7.g() * var6;
			C = var10 - var7.h() * var6;
			D = var12 - var7.i() * var6;
			E = var14 - var7.g() * var6;
			F = var16 - var7.h() * var6;
			G = var18 - var7.i() * var6;
		}

	}

	public class_ayk a(class_ago var1, class_cj var2, class_apn var3, float var4, class_cq var5) {
		if ((var3.c() != this) && (var3.c().v() != class_avq.a)) {
			class_ayk var6 = var3.c().a(var1, var2, var3);
			if (var6 == null) {
				return null;
			} else {
				double var7 = var6.a;
				double var9 = var6.b;
				double var11 = var6.c;
				double var13 = var6.d;
				double var15 = var6.e;
				double var17 = var6.f;
				if (var5.g() < 0) {
					var7 -= var5.g() * var4;
				} else {
					var13 -= var5.g() * var4;
				}

				if (var5.h() < 0) {
					var9 -= var5.h() * var4;
				} else {
					var15 -= var5.h() * var4;
				}

				if (var5.i() < 0) {
					var11 -= var5.i() * var4;
				} else {
					var17 -= var5.i() * var4;
				}

				return new class_ayk(var7, var9, var11, var13, var15, var17);
			}
		} else {
			return null;
		}
	}

	private class_api e(class_ags var1, class_cj var2) {
		TileEntity var3 = var1.s(var2);
		return var3 instanceof class_api ? (class_api) var3 : null;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, BlockPistonExtension.b(var1)).a(b, (var1 & 8) > 0 ? BlockPistonExtension.class_a_in_class_aph.b : BlockPistonExtension.class_a_in_class_aph.a);
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
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(a)).a();
		if (var1.b(b) == BlockPistonExtension.class_a_in_class_aph.b) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b });
	}

	static {
		a = class_ajk.b;
		b = BlockPistonExtension.a;
	}
}
