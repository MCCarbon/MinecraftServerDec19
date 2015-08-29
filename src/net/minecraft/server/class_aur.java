package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class class_aur {
	protected class_aua l;
	private class_cq a;
	private Block.class_a_in_class_ail b;
	private Block.class_c_in_class_ail c;
	protected int m;

	public class_aur() {
	}

	protected class_aur(int var1) {
		m = var1;
	}

	public final class_dn b() {
		class_dn var1 = new class_dn();
		var1.a("id", class_aup.a(this));
		var1.a("BB", l.g());
		class_cq var2 = e();
		var1.a("O", var2 == null ? -1 : var2.b());
		var1.a("GD", m);
		this.a(var1);
		return var1;
	}

	protected abstract void a(class_dn var1);

	public void a(class_ago var1, class_dn var2) {
		if (var2.e("BB")) {
			l = new class_aua(var2.n("BB"));
		}

		int var3 = var2.h("O");
		this.a(var3 == -1 ? null : class_cq.b(var3));
		m = var2.h("GD");
		this.b(var2);
	}

	protected abstract void b(class_dn var1);

	public void a(class_aur var1, List var2, Random var3) {
	}

	public abstract boolean a(class_ago var1, Random var2, class_aua var3);

	public class_aua c() {
		return l;
	}

	public int d() {
		return m;
	}

	public static class_aur a(List var0, class_aua var1) {
		Iterator var2 = var0.iterator();

		class_aur var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (class_aur) var2.next();
		} while ((var3.c() == null) || !var3.c().a(var1));

		return var3;
	}

	public class_cj a() {
		return new class_cj(l.f());
	}

	protected boolean a(class_ago var1, class_aua var2) {
		int var3 = Math.max(l.a - 1, var2.a);
		int var4 = Math.max(l.b - 1, var2.b);
		int var5 = Math.max(l.c - 1, var2.c);
		int var6 = Math.min(l.d + 1, var2.d);
		int var7 = Math.min(l.e + 1, var2.e);
		int var8 = Math.min(l.f + 1, var2.f);
		class_cj.class_a_in_class_cj var9 = new class_cj.class_a_in_class_cj();

		int var10;
		int var11;
		for (var10 = var3; var10 <= var6; ++var10) {
			for (var11 = var5; var11 <= var8; ++var11) {
				if (var1.p(var9.c(var10, var4, var11)).c().v().d()) {
					return true;
				}

				if (var1.p(var9.c(var10, var7, var11)).c().v().d()) {
					return true;
				}
			}
		}

		for (var10 = var3; var10 <= var6; ++var10) {
			for (var11 = var4; var11 <= var7; ++var11) {
				if (var1.p(var9.c(var10, var11, var5)).c().v().d()) {
					return true;
				}

				if (var1.p(var9.c(var10, var11, var8)).c().v().d()) {
					return true;
				}
			}
		}

		for (var10 = var5; var10 <= var8; ++var10) {
			for (var11 = var4; var11 <= var7; ++var11) {
				if (var1.p(var9.c(var3, var11, var10)).c().v().d()) {
					return true;
				}

				if (var1.p(var9.c(var6, var11, var10)).c().v().d()) {
					return true;
				}
			}
		}

		return false;
	}

	protected int a(int var1, int var2) {
		class_cq var3 = e();
		if (var3 == null) {
			return var1;
		} else {
			switch (class_aur.SyntheticClass_1.a[var3.ordinal()]) {
				case 1:
				case 2:
					return l.a + var1;
				case 3:
					return l.d - var2;
				case 4:
					return l.a + var2;
				default:
					return var1;
			}
		}
	}

	protected int d(int var1) {
		return e() == null ? var1 : var1 + l.b;
	}

	protected int b(int var1, int var2) {
		class_cq var3 = e();
		if (var3 == null) {
			return var2;
		} else {
			switch (class_aur.SyntheticClass_1.a[var3.ordinal()]) {
				case 1:
					return l.f - var2;
				case 2:
					return l.c + var2;
				case 3:
				case 4:
					return l.c + var1;
				default:
					return var2;
			}
		}
	}

	protected void a(class_ago var1, class_apn var2, int var3, int var4, int var5, class_aua var6) {
		class_cj var7 = new class_cj(this.a(var3, var5), this.d(var4), this.b(var3, var5));
		if (var6.b(var7)) {
			if (b != Block.class_a_in_class_ail.a) {
				var2 = var2.c().a(var2, b);
			}

			if (c != Block.class_c_in_class_ail.a) {
				var2 = var2.c().a(var2, c);
			}

			var1.a(var7, var2, 2);
		}
	}

	protected class_apn a(class_ago var1, int var2, int var3, int var4, class_aua var5) {
		int var6 = this.a(var2, var4);
		int var7 = this.d(var3);
		int var8 = this.b(var2, var4);
		class_cj var9 = new class_cj(var6, var7, var8);
		return !var5.b(var9) ? Blocks.AIR.getBlockData() : var1.p(var9);
	}

	protected void a(class_ago var1, class_aua var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		for (int var9 = var4; var9 <= var7; ++var9) {
			for (int var10 = var3; var10 <= var6; ++var10) {
				for (int var11 = var5; var11 <= var8; ++var11) {
					this.a(var1, Blocks.AIR.getBlockData(), var10, var9, var11, var2);
				}
			}
		}

	}

	protected void a(class_ago var1, class_aua var2, int var3, int var4, int var5, int var6, int var7, int var8, class_apn var9, class_apn var10, boolean var11) {
		for (int var12 = var4; var12 <= var7; ++var12) {
			for (int var13 = var3; var13 <= var6; ++var13) {
				for (int var14 = var5; var14 <= var8; ++var14) {
					if (!var11 || (this.a(var1, var13, var12, var14, var2).c().v() != class_avq.a)) {
						if ((var12 != var4) && (var12 != var7) && (var13 != var3) && (var13 != var6) && (var14 != var5) && (var14 != var8)) {
							this.a(var1, var10, var13, var12, var14, var2);
						} else {
							this.a(var1, var9, var13, var12, var14, var2);
						}
					}
				}
			}
		}

	}

	protected void a(class_ago var1, class_aua var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, Random var10, class_aur.class_a_in_class_aur var11) {
		for (int var12 = var4; var12 <= var7; ++var12) {
			for (int var13 = var3; var13 <= var6; ++var13) {
				for (int var14 = var5; var14 <= var8; ++var14) {
					if (!var9 || (this.a(var1, var13, var12, var14, var2).c().v() != class_avq.a)) {
						var11.a(var10, var13, var12, var14, (var12 == var4) || (var12 == var7) || (var13 == var3) || (var13 == var6) || (var14 == var5) || (var14 == var8));
						this.a(var1, var11.a(), var13, var12, var14, var2);
					}
				}
			}
		}

	}

	protected void a(class_ago var1, class_aua var2, Random var3, float var4, int var5, int var6, int var7, int var8, int var9, int var10, class_apn var11, class_apn var12, boolean var13) {
		for (int var14 = var6; var14 <= var9; ++var14) {
			for (int var15 = var5; var15 <= var8; ++var15) {
				for (int var16 = var7; var16 <= var10; ++var16) {
					if ((var3.nextFloat() <= var4) && (!var13 || (this.a(var1, var15, var14, var16, var2).c().v() != class_avq.a))) {
						if ((var14 != var6) && (var14 != var9) && (var15 != var5) && (var15 != var8) && (var16 != var7) && (var16 != var10)) {
							this.a(var1, var12, var15, var14, var16, var2);
						} else {
							this.a(var1, var11, var15, var14, var16, var2);
						}
					}
				}
			}
		}

	}

	protected void a(class_ago var1, class_aua var2, Random var3, float var4, int var5, int var6, int var7, class_apn var8) {
		if (var3.nextFloat() < var4) {
			this.a(var1, var8, var5, var6, var7, var2);
		}

	}

	protected void a(class_ago var1, class_aua var2, int var3, int var4, int var5, int var6, int var7, int var8, class_apn var9, boolean var10) {
		float var11 = (var6 - var3) + 1;
		float var12 = (var7 - var4) + 1;
		float var13 = (var8 - var5) + 1;
		float var14 = var3 + (var11 / 2.0F);
		float var15 = var5 + (var13 / 2.0F);

		for (int var16 = var4; var16 <= var7; ++var16) {
			float var17 = (var16 - var4) / var12;

			for (int var18 = var3; var18 <= var6; ++var18) {
				float var19 = (var18 - var14) / (var11 * 0.5F);

				for (int var20 = var5; var20 <= var8; ++var20) {
					float var21 = (var20 - var15) / (var13 * 0.5F);
					if (!var10 || (this.a(var1, var18, var16, var20, var2).c().v() != class_avq.a)) {
						float var22 = (var19 * var19) + (var17 * var17) + (var21 * var21);
						if (var22 <= 1.05F) {
							this.a(var1, var9, var18, var16, var20, var2);
						}
					}
				}
			}
		}

	}

	protected void b(class_ago var1, int var2, int var3, int var4, class_aua var5) {
		class_cj var6 = new class_cj(this.a(var2, var4), this.d(var3), this.b(var2, var4));
		if (var5.b(var6)) {
			while (!var1.d(var6) && (var6.o() < 255)) {
				var1.a(var6, Blocks.AIR.getBlockData(), 2);
				var6 = var6.a();
			}

		}
	}

	protected void b(class_ago var1, class_apn var2, int var3, int var4, int var5, class_aua var6) {
		int var7 = this.a(var3, var5);
		int var8 = this.d(var4);
		int var9 = this.b(var3, var5);
		if (var6.b((new class_cj(var7, var8, var9)))) {
			while ((var1.d(new class_cj(var7, var8, var9)) || var1.p(new class_cj(var7, var8, var9)).c().v().d()) && (var8 > 1)) {
				var1.a((new class_cj(var7, var8, var9)), var2, 2);
				--var8;
			}

		}
	}

	protected boolean a(class_ago var1, class_aua var2, Random var3, int var4, int var5, int var6, List var7, int var8) {
		class_cj var9 = new class_cj(this.a(var4, var6), this.d(var5), this.b(var4, var6));
		if (var2.b(var9) && (var1.p(var9).c() != Blocks.CHEST)) {
			class_apn var10 = Blocks.CHEST.getBlockData();
			var1.a(var9, Blocks.CHEST.g(var1, var9, var10), 2);
			TileEntity var11 = var1.s(var9);
			if (var11 instanceof class_aok) {
				class_oj.a(var3, var7, ((class_aok) var11), var8);
			}

			return true;
		} else {
			return false;
		}
	}

	protected boolean a(class_ago var1, class_aua var2, Random var3, int var4, int var5, int var6, class_cq var7, List var8, int var9) {
		class_cj var10 = new class_cj(this.a(var4, var6), this.d(var5), this.b(var4, var6));
		if (var2.b(var10) && (var1.p(var10).c() != Blocks.DISPENSER)) {
			this.a(var1, Blocks.DISPENSER.getBlockData().a(class_ajm.a, var7), var4, var5, var6, var2);
			TileEntity var11 = var1.s(var10);
			if (var11 instanceof class_aoo) {
				class_oj.a(var3, var8, (class_aoo) var11, var9);
			}

			return true;
		} else {
			return false;
		}
	}

	protected void a(class_ago var1, class_aua var2, Random var3, int var4, int var5, int var6, class_cq var7) {
		this.a(var1, Blocks.WOODEN_DOOR.getBlockData().a(class_ajn.a, var7), var4, var5, var6, var2);
		this.a(var1, Blocks.WOODEN_DOOR.getBlockData().a(class_ajn.a, var7).a(class_ajn.P, class_ajn.class_a_in_class_ajn.a), var4, var5 + 1, var6, var2);
	}

	public void a(int var1, int var2, int var3) {
		l.a(var1, var2, var3);
	}

	public class_cq e() {
		return a;
	}

	public void a(class_cq var1) {
		a = var1;
		if (var1 == null) {
			c = Block.class_c_in_class_ail.a;
			b = Block.class_a_in_class_ail.a;
		} else {
			switch (class_aur.SyntheticClass_1.a[var1.ordinal()]) {
				case 2:
					b = Block.class_a_in_class_ail.b;
					c = Block.class_c_in_class_ail.a;
					break;
				case 3:
					b = Block.class_a_in_class_ail.b;
					c = Block.class_c_in_class_ail.b;
					break;
				case 4:
					b = Block.class_a_in_class_ail.a;
					c = Block.class_c_in_class_ail.b;
					break;
				default:
					b = Block.class_a_in_class_ail.a;
					c = Block.class_c_in_class_ail.a;
			}
		}

	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.c.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public abstract static class class_a_in_class_aur {
		protected class_apn a;

		protected class_a_in_class_aur() {
			a = Blocks.AIR.getBlockData();
		}

		public abstract void a(Random var1, int var2, int var3, int var4, boolean var5);

		public class_apn a() {
			return a;
		}
	}
}
