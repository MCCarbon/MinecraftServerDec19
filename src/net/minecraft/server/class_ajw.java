package net.minecraft.server;

import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_zu;

public class class_ajw extends class_agj {
	public static final class_any a = class_any.a("variant", class_ajw.class_a_in_class_ajw.class);

	public class_ajw() {
		super(class_atk.d);
		this.j(this.M.b().a(a, class_ajw.class_a_in_class_ajw.a));
		this.a(class_zu.b);
	}

	public int a(class_anl var1) {
		return ((class_ajw.class_a_in_class_ajw) var1.b(a)).a();
	}

	public class_anl a(int var1) {
		return this.S().a(a, class_ajw.class_a_in_class_ajw.a(var1));
	}

	public class_atl g(class_anl var1) {
		return ((class_ajw.class_a_in_class_ajw) var1.b(a)).c();
	}

	public int c(class_anl var1) {
		return ((class_ajw.class_a_in_class_ajw) var1.b(a)).a();
	}

	protected class_anm e() {
		return new class_anm(this, new class_aoa[] { a });
	}

	public static enum class_a_in_class_ajw implements class_ny {
		a(0, "oak", class_atl.o), b(1, "spruce", class_atl.J), c(2, "birch", class_atl.d), d(3, "jungle", class_atl.l), e(4, "acacia", class_atl.q), f(5, "dark_oak", "big_oak", class_atl.B);

		private static final class_ajw.class_a_in_class_ajw[] g;
		private final int h;
		private final String i;
		private final String j;
		private final class_atl k;

		private class_a_in_class_ajw(int var3, String var4, class_atl var5) {
			this(var3, var4, var4, var5);
		}

		private class_a_in_class_ajw(int var3, String var4, String var5, class_atl var6) {
			this.h = var3;
			this.i = var4;
			this.j = var5;
			this.k = var6;
		}

		public int a() {
			return this.h;
		}

		public class_atl c() {
			return this.k;
		}

		public String toString() {
			return this.i;
		}

		public static class_ajw.class_a_in_class_ajw a(int var0) {
			if (var0 < 0 || var0 >= g.length) {
				var0 = 0;
			}

			return g[var0];
		}

		public String l() {
			return this.i;
		}

		public String d() {
			return this.j;
		}

		static {
			g = new class_ajw.class_a_in_class_ajw[values().length];
			class_ajw.class_a_in_class_ajw[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_ajw.class_a_in_class_ajw var3 = var0[var2];
				g[var3.a()] = var3;
			}

		}
	}
}
