package net.minecraft.server;

import net.minecraft.server.class_ahx;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_ny;

public class class_akq extends class_ahx {
	public static final class_any a = class_any.a("variant", class_akq.class_a_in_class_akq.class);

	public class_akq() {
		this.j(this.M.b().a(a, class_akq.class_a_in_class_akq.a));
	}

	public int a(class_anl var1) {
		return ((class_akq.class_a_in_class_akq) var1.b(a)).a();
	}

	public class_atl g(class_anl var1) {
		return ((class_akq.class_a_in_class_akq) var1.b(a)).c();
	}

	public class_anl a(int var1) {
		return this.S().a(a, class_akq.class_a_in_class_akq.a(var1));
	}

	public int c(class_anl var1) {
		return ((class_akq.class_a_in_class_akq) var1.b(a)).a();
	}

	protected class_anm e() {
		return new class_anm(this, new class_aoa[] { a });
	}

	public static enum class_a_in_class_akq implements class_ny {
		a(0, "sand", "default", class_atl.d), b(1, "red_sand", "red", class_atl.q);

		private static final class_akq.class_a_in_class_akq[] c;
		private final int d;
		private final String e;
		private final class_atl f;
		private final String g;

		private class_a_in_class_akq(int var3, String var4, String var5, class_atl var6) {
			this.d = var3;
			this.e = var4;
			this.f = var6;
			this.g = var5;
		}

		public int a() {
			return this.d;
		}

		public String toString() {
			return this.e;
		}

		public class_atl c() {
			return this.f;
		}

		public static class_akq.class_a_in_class_akq a(int var0) {
			if (var0 < 0 || var0 >= c.length) {
				var0 = 0;
			}

			return c[var0];
		}

		public String l() {
			return this.e;
		}

		public String d() {
			return this.g;
		}

		static {
			c = new class_akq.class_a_in_class_akq[values().length];
			class_akq.class_a_in_class_akq[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_akq.class_a_in_class_akq var3 = var0[var2];
				c[var3.a()] = var3;
			}

		}
	}
}
