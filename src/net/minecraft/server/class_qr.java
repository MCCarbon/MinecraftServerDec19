package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ComparisonChain;

public class class_qr implements Comparable {
	private static final Logger a = LogManager.getLogger();
	private final class_qq b;
	private int c;
	private int d;
	private boolean e;
	private boolean f;
	private boolean h;

	public class_qr(class_qq var1) {
		this(var1, 0, 0);
	}

	public class_qr(class_qq var1, int var2) {
		this(var1, var2, 0);
	}

	public class_qr(class_qq var1, int var2, int var3) {
		this(var1, var2, var3, false, true);
	}

	public class_qr(class_qq var1, int var2, int var3, boolean var4, boolean var5) {
		b = var1;
		c = var2;
		d = var3;
		f = var4;
		h = var5;
	}

	public class_qr(class_qr var1) {
		b = var1.b;
		c = var1.c;
		d = var1.d;
		f = var1.f;
		h = var1.h;
	}

	public void a(class_qr var1) {
		if (b != var1.b) {
			a.warn("This method should only be called for matching effects!");
		}

		if (var1.d > d) {
			d = var1.d;
			c = var1.c;
		} else if ((var1.d == d) && (c < var1.c)) {
			c = var1.c;
		} else if (!var1.f && f) {
			f = var1.f;
		}

		h = var1.h;
	}

	public class_qq a() {
		return b;
	}

	public int b() {
		return c;
	}

	public int c() {
		return d;
	}

	public boolean d() {
		return f;
	}

	public boolean e() {
		return h;
	}

	public boolean a(class_rg var1) {
		if (c > 0) {
			if (b.a(c, d)) {
				this.b(var1);
			}

			h();
		}

		return c > 0;
	}

	private int h() {
		return --c;
	}

	public void b(class_rg var1) {
		if (c > 0) {
			b.a(var1, d);
		}

	}

	public String f() {
		return b.a();
	}

	@Override
	public String toString() {
		String var1 = "";
		if (d > 0) {
			var1 = f() + " x " + (d + 1) + ", Duration: " + c;
		} else {
			var1 = f() + ", Duration: " + c;
		}

		if (e) {
			var1 = var1 + ", Splash: true";
		}

		if (!h) {
			var1 = var1 + ", Particles: false";
		}

		return var1;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_qr)) {
			return false;
		} else {
			class_qr var2 = (class_qr) var1;
			return c != var2.c ? false : (d != var2.d ? false : (e != var2.e ? false : (f != var2.f ? false : b.equals(var2.b))));
		}
	}

	@Override
	public int hashCode() {
		int var1 = b.hashCode();
		var1 = (31 * var1) + c;
		var1 = (31 * var1) + d;
		var1 = (31 * var1) + (e ? 1 : 0);
		var1 = (31 * var1) + (f ? 1 : 0);
		return var1;
	}

	public class_dn a(class_dn var1) {
		var1.a("Id", (byte) class_qq.a(this.a()));
		var1.a("Amplifier", (byte) c());
		var1.a("Duration", this.b());
		var1.a("Ambient", d());
		var1.a("ShowParticles", e());
		return var1;
	}

	public static class_qr b(class_dn var0) {
		byte var1 = var0.f("Id");
		class_qq var2 = class_qq.a(var1);
		if (var2 == null) {
			return null;
		} else {
			byte var3 = var0.f("Amplifier");
			int var4 = var0.h("Duration");
			boolean var5 = var0.p("Ambient");
			boolean var6 = true;
			if (var0.b("ShowParticles", 1)) {
				var6 = var0.p("ShowParticles");
			}

			return new class_qr(var2, var4, var3, var5, var6);
		}
	}

	public int b(class_qr var1) {
		return ComparisonChain.start().compare(this.b(), var1.b()).compare(this.a().g(), var1.a().g()).result();
	}

	// $FF: synthetic method
	@Override
	public int compareTo(Object var1) {
		return this.b((class_qr) var1);
	}
}
