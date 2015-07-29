package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_di;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_zu;

public class class_alh extends class_agj {
	public static final class_any a = class_any.a("variant", class_alh.class_a_in_class_alh.class);

	public class_alh() {
		super(class_atk.e);
		this.j(this.M.b().a(a, class_alh.class_a_in_class_alh.a));
		this.a(class_zu.b);
	}

	public String f() {
		return class_di.a(this.a() + "." + class_alh.class_a_in_class_alh.a.d() + ".name");
	}

	public class_atl g(class_anl var1) {
		return ((class_alh.class_a_in_class_alh) var1.b(a)).c();
	}

	public class_aar a(class_anl var1, Random var2, int var3) {
		return var1.b(a) == class_alh.class_a_in_class_alh.a ? class_aar.a(class_agk.e) : class_aar.a(class_agk.b);
	}

	public int a(class_anl var1) {
		return ((class_alh.class_a_in_class_alh) var1.b(a)).a();
	}

	public class_anl a(int var1) {
		return this.S().a(a, class_alh.class_a_in_class_alh.a(var1));
	}

	public int c(class_anl var1) {
		return ((class_alh.class_a_in_class_alh) var1.b(a)).a();
	}

	protected class_anm e() {
		return new class_anm(this, new class_aoa[] { a });
	}

	public static enum class_a_in_class_alh implements class_ny {
		a(0, class_atl.m, "stone"), b(1, class_atl.l, "granite"), c(2, class_atl.l, "smooth_granite", "graniteSmooth"), d(3, class_atl.p, "diorite"), e(4, class_atl.p, "smooth_diorite", "dioriteSmooth"), f(5, class_atl.m, "andesite"), g(6, class_atl.m, "smooth_andesite", "andesiteSmooth");

		private static final class_alh.class_a_in_class_alh[] h;
		private final int i;
		private final String j;
		private final String k;
		private final class_atl l;

		private class_a_in_class_alh(int var3, class_atl var4, String var5) {
			this(var3, var4, var5, var5);
		}

		private class_a_in_class_alh(int var3, class_atl var4, String var5, String var6) {
			this.i = var3;
			this.j = var5;
			this.k = var6;
			this.l = var4;
		}

		public int a() {
			return this.i;
		}

		public class_atl c() {
			return this.l;
		}

		public String toString() {
			return this.j;
		}

		public static class_alh.class_a_in_class_alh a(int var0) {
			if (var0 < 0 || var0 >= h.length) {
				var0 = 0;
			}

			return h[var0];
		}

		public String l() {
			return this.j;
		}

		public String d() {
			return this.k;
		}

		static {
			h = new class_alh.class_a_in_class_alh[values().length];
			class_alh.class_a_in_class_alh[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_alh.class_a_in_class_alh var3 = var0[var2];
				h[var3.a()] = var3;
			}

		}
	}
}
