package net.minecraft.server;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class class_nd {
	public final String e;
	private final class_eu a;
	public boolean f;
	private final class_ne b;
	private final class_ayy c;
	private Class d;
	private static NumberFormat k;
	public static class_ne g;
	private static DecimalFormat l;
	public static class_ne h;
	public static class_ne i;
	public static class_ne j;

	public class_nd(String var1, class_eu var2, class_ne var3) {
		e = var1;
		a = var2;
		b = var3;
		c = new class_aza(this);
		class_ayy.a.put(c.a(), c);
	}

	public class_nd(String var1, class_eu var2) {
		this(var1, var2, g);
	}

	public class_nd i() {
		f = true;
		return this;
	}

	public class_nd h() {
		if (class_nh.a.containsKey(e)) {
			throw new RuntimeException("Duplicate stat id: \"" + ((class_nd) class_nh.a.get(e)).a + "\" and \"" + a + "\" at id " + e);
		} else {
			class_nh.b.add(this);
			class_nh.a.put(e, this);
			return this;
		}
	}

	public boolean d() {
		return false;
	}

	public class_eu e() {
		class_eu var1 = a.f();
		var1.b().a(EnumChatFormat.GRAY);
		var1.b().a(new class_ew(class_ew.class_a_in_class_ew.b, new class_fa(e)));
		return var1;
	}

	public class_eu j() {
		class_eu var1 = e();
		class_eu var2 = (new class_fa("[")).a(var1).a("]");
		var2.a(var1.b());
		return var2;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if ((var1 != null) && (this.getClass() == var1.getClass())) {
			class_nd var2 = (class_nd) var1;
			return e.equals(var2.e);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return e.hashCode();
	}

	@Override
	public String toString() {
		return "Stat{id=" + e + ", nameId=" + a + ", awardLocallyOnly=" + f + ", formatter=" + b + ", objectiveCriteria=" + c + '}';
	}

	public class_ayy k() {
		return c;
	}

	public Class l() {
		return d;
	}

	public class_nd b(Class var1) {
		d = var1;
		return this;
	}

	static {
		k = NumberFormat.getIntegerInstance(Locale.US);
		g = new class_ne() {
		};
		l = new DecimalFormat("########0.00");
		h = new class_ne() {
		};
		i = new class_ne() {
		};
		j = new class_ne() {
		};
	}
}
