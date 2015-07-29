package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_zu;

public class class_ahj extends class_agj {
	public static final class_any a = class_any.a("variant", class_ahj.class_a_in_class_ahj.class);
	public static final class_anw b = class_anw.a("snowy");

	protected class_ahj() {
		super(class_atk.c);
		this.j(this.M.b().a(a, class_ahj.class_a_in_class_ahj.a).a(b, Boolean.valueOf(false)));
		this.a(class_zu.b);
	}

	public class_atl g(class_anl var1) {
		return ((class_ahj.class_a_in_class_ahj) var1.b(a)).d();
	}

	public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
		if (var1.b(a) == class_ahj.class_a_in_class_ahj.c) {
			class_agj var4 = var2.p(var3.a()).c();
			var1 = var1.a(b, Boolean.valueOf(var4 == class_agk.aJ || var4 == class_agk.aH));
		}

		return var1;
	}

	public int j(class_aen var1, class_cj var2) {
		class_anl var3 = var1.p(var2);
		return var3.c() != this ? 0 : ((class_ahj.class_a_in_class_ahj) var3.b(a)).a();
	}

	public class_anl a(int var1) {
		return this.S().a(a, class_ahj.class_a_in_class_ahj.a(var1));
	}

	public int c(class_anl var1) {
		return ((class_ahj.class_a_in_class_ahj) var1.b(a)).a();
	}

	protected class_anm e() {
		return new class_anm(this, new class_aoa[] { a, b });
	}

	public int a(class_anl var1) {
		class_ahj.class_a_in_class_ahj var2 = (class_ahj.class_a_in_class_ahj) var1.b(a);
		if (var2 == class_ahj.class_a_in_class_ahj.c) {
			var2 = class_ahj.class_a_in_class_ahj.a;
		}

		return var2.a();
	}

	public static enum class_a_in_class_ahj implements class_ny {
		a(0, "dirt", "default", class_atl.l), b(1, "coarse_dirt", "coarse", class_atl.l), c(2, "podzol", class_atl.J);

	    private static final class_a_in_class_ahj[] d;
	    
	    static {
	        d = new class_a_in_class_ahj[values().length];
	        for (final class_a_in_class_ahj a2 : values()) {
	        	d[a2.a()] = a2;
	        }
	    }
	
	    public static class_a_in_class_ahj a(int id) {
	        if (id < 0 || id >= d.length) {
	        	id = 0;
	        }
	        return d[id];
	    }
	    
		private final int e;
		private final String f;
		private final String g;
		private final class_atl h;

		private class_a_in_class_ahj(int var3, String var4, class_atl var5) {
			this(var3, var4, var4, var5);
		}

		private class_a_in_class_ahj(int var3, String var4, String var5, class_atl var6) {
			this.e = var3;
			this.f = var4;
			this.g = var5;
			this.h = var6;
		}

		public int a() {
			return this.e;
		}

		public String c() {
			return this.g;
		}

		public class_atl d() {
			return this.h;
		}

		public String toString() {
			return this.f;
		}

		public String l() {
			return this.f;
		}

	}
}
