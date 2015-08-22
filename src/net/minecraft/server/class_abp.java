package net.minecraft.server;


public abstract class class_abp {
	public static final class_abp[] a = new class_abp[12];
	public static final class_abp b = new class_abp(0, "buildingBlocks") {
	};
	public static final class_abp c = new class_abp(1, "decorations") {
	};
	public static final class_abp d = new class_abp(2, "redstone") {
	};
	public static final class_abp e = new class_abp(3, "transportation") {
	};
	public static final class_abp f;
	public static final class_abp g;
	public static final class_abp h;
	public static final class_abp i;
	public static final class_abp j;
	public static final class_abp k;
	public static final class_abp l;
	public static final class_abp m;
	private final int n;
	private final String o;
	private String p = "items.png";
	private boolean q = true;
	private boolean r = true;
	private class_afk[] s;

	public class_abp(int var1, String var2) {
		n = var1;
		o = var2;
		a[var1] = this;
	}

	public class_abp a(String var1) {
		p = var1;
		return this;
	}

	public class_abp i() {
		r = false;
		return this;
	}

	public class_abp k() {
		q = false;
		return this;
	}

	public class_abp a(class_afk... var1) {
		s = var1;
		return this;
	}

	static {
		f = (new class_abp(4, "misc") {
		}).a(new class_afk[] { class_afk.a });
		g = (new class_abp(5, "search") {
		}).a("item_search.png");
		h = new class_abp(6, "food") {
		};
		i = (new class_abp(7, "tools") {
		}).a(new class_afk[] { class_afk.h, class_afk.i, class_afk.j });
		j = (new class_abp(8, "combat") {
		}).a(new class_afk[] { class_afk.b, class_afk.c, class_afk.f, class_afk.d, class_afk.e, class_afk.k, class_afk.g });
		k = new class_abp(9, "brewing") {
		};
		l = new class_abp(10, "materials") {
		};
		m = (new class_abp(11, "inventory") {
		}).a("inventory.png").k().i();
	}
}
