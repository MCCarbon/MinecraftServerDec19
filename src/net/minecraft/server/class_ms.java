package net.minecraft.server;

import net.minecraft.server.class_a;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;

public class class_ms extends class_my {
	public final int a;
	public final int b;
	public final class_ms c;
	private final String k;
	public final class_aas d;
	private boolean m;

	public class_ms(String var1, String var2, int var3, int var4, class_aar var5, class_ms var6) {
		this(var1, var2, var3, var4, new class_aas(var5), var6);
	}

	public class_ms(String var1, String var2, int var3, int var4, class_agj var5, class_ms var6) {
		this(var1, var2, var3, var4, new class_aas(var5), var6);
	}

	public class_ms(String var1, String var2, int var3, int var4, class_aas var5, class_ms var6) {
		super(var1, new class_fb("achievement." + var2, new Object[0]));
		this.d = var5;
		this.k = "achievement." + var2 + ".desc";
		this.a = var3;
		this.b = var4;
		if (var3 < class_mt.a) {
			class_mt.a = var3;
		}

		if (var4 < class_mt.b) {
			class_mt.b = var4;
		}

		if (var3 > class_mt.c) {
			class_mt.c = var3;
		}

		if (var4 > class_mt.d) {
			class_mt.d = var4;
		}

		this.c = var6;
	}

	public class_ms a() {
		this.f = true;
		return this;
	}

	public class_ms b() {
		this.m = true;
		return this;
	}

	public class_ms c() {
		super.h();
		class_mt.e.add(this);
		return this;
	}

	public boolean d() {
		return true;
	}

	public class_eu e() {
		class_eu var1 = super.e();
		var1.b().a(this.g() ? class_a.f : class_a.k);
		return var1;
	}

	public class_ms a(Class var1) {
		return (class_ms) super.b(var1);
	}

	public boolean g() {
		return this.m;
	}

	// $FF: synthetic method
	public class_my b(Class var1) {
		return this.a(var1);
	}

	// $FF: synthetic method
	public class_my h() {
		return this.c();
	}

	// $FF: synthetic method
	public class_my i() {
		return this.a();
	}
}
