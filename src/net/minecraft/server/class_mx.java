package net.minecraft.server;


public class class_mx extends class_nd {
	public int a;
	public int b;
	public final class_mx c;
	private final String k;
	public final class_aco d;
	private boolean m;

	public class_mx(String var1, String var2, int var3, int var4, Item var5, class_mx var6) {
		this(var1, var2, var3, var4, new class_aco(var5), var6);
	}

	public class_mx(String var1, String var2, int var3, int var4, Block var5, class_mx var6) {
		this(var1, var2, var3, var4, new class_aco(var5), var6);
	}

	public class_mx(String var1, String var2, int var3, int var4, class_aco var5, class_mx var6) {
		super(var1, new class_fb("achievement." + var2, new Object[0]));
		d = var5;
		k = "achievement." + var2 + ".desc";
		a = var3;
		b = var4;
		if (var3 < class_my.a) {
			a = var3;
		}

		if (var4 < class_my.b) {
			b = var4;
		}

		if (var3 > class_my.c) {
			class_my.c = var3;
		}

		if (var4 > class_my.d) {
			class_my.d = var4;
		}

		c = var6;
	}

	public class_mx a() {
		f = true;
		return this;
	}

	public class_mx b() {
		m = true;
		return this;
	}

	public class_mx c() {
		super.h();
		class_my.e.add(this);
		return this;
	}

	@Override
	public boolean d() {
		return true;
	}

	@Override
	public class_eu e() {
		class_eu var1 = super.e();
		var1.b().a(g() ? EnumChatFormat.DARK_PURPLE : EnumChatFormat.GREEN);
		return var1;
	}

	public class_mx a(Class var1) {
		return (class_mx) super.b(var1);
	}

	public boolean g() {
		return m;
	}

	// $FF: synthetic method
	@Override
	public class_nd b(Class var1) {
		return this.a(var1);
	}

	// $FF: synthetic method
	@Override
	public class_nd h() {
		return c();
	}

	// $FF: synthetic method
	@Override
	public class_nd i() {
		return this.a();
	}
}
