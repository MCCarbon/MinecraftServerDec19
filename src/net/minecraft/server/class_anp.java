package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class class_anp extends Block {
	public static final class_apy b = class_apy.a("north");
	public static final class_apy N = class_apy.a("east");
	public static final class_apy O = class_apy.a("south");
	public static final class_apy P = class_apy.a("west");
	private final boolean a;

	protected class_anp(class_avq var1, boolean var2) {
		super(var1);
		this.j(M.b().a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)));
		a = var2;
		this.a(class_abp.c);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		return var1.a(b, Boolean.valueOf(this.c(var2.p(var3.c()).c()))).a(O, Boolean.valueOf(this.c(var2.p(var3.d()).c()))).a(P, Boolean.valueOf(this.c(var2.p(var3.e()).c()))).a(N, Boolean.valueOf(this.c(var2.p(var3.f()).c())));
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return !a ? null : super.a(var1, var2, var3);
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
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ayk var4, List var5, Entity var6) {
		boolean var7 = this.c(var1.p(var2.c()).c());
		boolean var8 = this.c(var1.p(var2.d()).c());
		boolean var9 = this.c(var1.p(var2.e()).c());
		boolean var10 = this.c(var1.p(var2.f()).c());
		if (var9 && var10) {
			this.a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
			super.a(var1, var2, var3, var4, var5, var6);
		} else if (!var9 && !var10 && !var7 && !var8) {
			this.a(0.4375F, 0.4375F, 0.4375F, 0.5625F, 0.5625F, 0.5625F);
			super.a(var1, var2, var3, var4, var5, var6);
		} else if (var9) {
			this.a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
			super.a(var1, var2, var3, var4, var5, var6);
		} else if (var10) {
			this.a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

		if (var7 && var8) {
			this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
			super.a(var1, var2, var3, var4, var5, var6);
		} else if (!var9 && !var10 && !var7 && !var8) {
			this.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.0F, 0.5625F);
			super.a(var1, var2, var3, var4, var5, var6);
		} else if (var7) {
			this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
			super.a(var1, var2, var3, var4, var5, var6);
		} else if (var8) {
			this.a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
			super.a(var1, var2, var3, var4, var5, var6);
		}

	}

	@Override
	public void j() {
		this.a(0.4375F, 0.4375F, 0.0F, 0.5625F, 1.0F, 0.5625F);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		float var3 = 0.4375F;
		float var4 = 0.5625F;
		float var5 = 0.4375F;
		float var6 = 0.5625F;
		boolean var7 = this.c(var1.p(var2.c()).c());
		boolean var8 = this.c(var1.p(var2.d()).c());
		boolean var9 = this.c(var1.p(var2.e()).c());
		boolean var10 = this.c(var1.p(var2.f()).c());
		if (var9 && var10) {
			var3 = 0.0F;
			var4 = 1.0F;
		} else if (var9) {
			var3 = 0.0F;
		} else if (var10) {
			var4 = 1.0F;
		}

		if (var7 && var8) {
			var5 = 0.0F;
			var6 = 1.0F;
		} else if (var7) {
			var5 = 0.0F;
		} else if (var8) {
			var6 = 1.0F;
		}

		this.a(var3, 0.0F, var5, var4, 1.0F, var6);
	}

	public final boolean c(Block var1) {
		return var1.q() || (var1 == this) || (var1 == Blocks.GLASS) || (var1 == Blocks.STAINED_GLASS) || (var1 == Blocks.STAINED_GLASS_PANE) || (var1 instanceof class_anp);
	}

	@Override
	protected boolean K() {
		return true;
	}

	@Override
	public int c(class_apn var1) {
		return 0;
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_anp.SyntheticClass_1.a[var2.ordinal()]) {
				case 1:
					return var1.a(b, var1.b(O)).a(N, var1.b(P)).a(O, var1.b(b)).a(P, var1.b(N));
				case 2:
					return var1.a(b, var1.b(N)).a(N, var1.b(O)).a(O, var1.b(P)).a(P, var1.b(b));
				case 3:
					return var1.a(b, var1.b(P)).a(N, var1.b(b)).a(O, var1.b(N)).a(P, var1.b(O));
				default:
					return var1;
			}
		}
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		if (var1.c() != this) {
			return var1;
		} else {
			switch (class_anp.SyntheticClass_1.b[var2.ordinal()]) {
				case 1:
					return var1.a(b, var1.b(O)).a(O, var1.b(b));
				case 2:
					return var1.a(N, var1.b(P)).a(P, var1.b(N));
				default:
					return super.a(var1, var2);
			}
		}
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b, N, P, O });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[Block.class_a_in_class_ail.values().length];

		static {
			try {
				b[Block.class_a_in_class_ail.b.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				b[Block.class_a_in_class_ail.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			a = new int[Block.class_c_in_class_ail.values().length];

			try {
				a[Block.class_c_in_class_ail.c.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.d.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[Block.class_c_in_class_ail.b.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
