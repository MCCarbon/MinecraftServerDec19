package net.minecraft.server;

import java.util.Random;

public class class_aub extends class_auo {
	private int d = 20;
	private int f = 11;
	private final class_aru g;

	public class_aub(class_aru var1) {
		g = var1;
	}

	@Override
	public String a() {
		return "EndCity";
	}

	@Override
	protected boolean a(int var1, int var2) {
		int var3 = var1;
		int var4 = var2;
		if (var1 < 0) {
			var1 -= d - 1;
		}

		if (var2 < 0) {
			var2 -= d - 1;
		}

		int var5 = var1 / d;
		int var6 = var2 / d;
		Random var7 = c.a(var5, var6, 10387313);
		var5 *= d;
		var6 *= d;
		var5 += (var7.nextInt(d - f) + var7.nextInt(d - f)) / 2;
		var6 += (var7.nextInt(d - f) + var7.nextInt(d - f)) / 2;
		return (var3 == var5) && (var4 == var6) && g.b(var3, var4);
	}

	@Override
	protected class_aus b(int var1, int var2) {
		return new class_aub.class_a_in_class_aub(c, g, b, var1, var2);
	}

	public static class class_a_in_class_aub extends class_aus {
		private boolean c;

		public class_a_in_class_aub() {
		}

		public class_a_in_class_aub(class_ago var1, class_aru var2, Random var3, int var4, int var5) {
			super(var4, var5);
			this.a(var1, var2, var3, var4, var5);
		}

		private void a(class_ago var1, class_aru var2, Random var3, int var4, int var5) {
			Block.class_c_in_class_ail var6 = Block.class_c_in_class_ail.values()[var3.nextInt(Block.class_c_in_class_ail.values().length)];
			class_arl var7 = new class_arl();
			var2.a(var4, var5, var7);
			byte var8 = 5;
			byte var9 = 5;
			if (var6 == Block.class_c_in_class_ail.b) {
				var8 = -5;
			} else if (var6 == Block.class_c_in_class_ail.c) {
				var8 = -5;
				var9 = -5;
			} else if (var6 == Block.class_c_in_class_ail.d) {
				var9 = -5;
			}

			int var10 = var7.a(7, 7);
			int var11 = var7.a(7, 7 + var9);
			int var12 = var7.a(7 + var8, 7);
			int var13 = var7.a(7 + var8, 7 + var9);
			int var14 = Math.min(Math.min(var10, var11), Math.min(var12, var13));
			if (var14 < 60) {
				c = false;
			} else {
				class_cj var15 = new class_cj((var4 * 16) + 8, var14, (var5 * 16) + 8);
				class_auc.a(var15, var6, a, var3);
				d();
				c = true;
			}
		}

		@Override
		public boolean a() {
			return c;
		}

		@Override
		public void a(class_dn var1) {
			super.a(var1);
		}

		@Override
		public void b(class_dn var1) {
			super.b(var1);
		}
	}
}
