package net.minecraft.server;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;

public class class_ayp extends class_ayu {
	private final class_ays a;
	private final String b;
	private final Set c = Sets.newHashSet();
	private String d;
	private String e = "";
	private String f = "";
	private boolean g = true;
	private boolean h = true;
	private class_ayu.class_a_in_class_ayu i;
	private class_ayu.class_a_in_class_ayu j;
	private EnumChatFormat k;

	public class_ayp(class_ays var1, String var2) {
		i = class_ayu.class_a_in_class_ayu.a;
		j = class_ayu.class_a_in_class_ayu.a;
		k = EnumChatFormat.RESET;
		a = var1;
		b = var2;
		d = var2;
	}

	@Override
	public String b() {
		return b;
	}

	public String c() {
		return d;
	}

	public void a(String var1) {
		if (var1 == null) {
			throw new IllegalArgumentException("Name cannot be null");
		} else {
			d = var1;
			a.b(this);
		}
	}

	@Override
	public Collection d() {
		return c;
	}

	public String e() {
		return e;
	}

	public void b(String var1) {
		if (var1 == null) {
			throw new IllegalArgumentException("Prefix cannot be null");
		} else {
			e = var1;
			a.b(this);
		}
	}

	public String f() {
		return f;
	}

	public void c(String var1) {
		f = var1;
		a.b(this);
	}

	@Override
	public String d(String var1) {
		return e() + var1 + f();
	}

	public static String a(class_ayu var0, String var1) {
		return var0 == null ? var1 : var0.d(var1);
	}

	@Override
	public boolean g() {
		return g;
	}

	public void a(boolean var1) {
		g = var1;
		a.b(this);
	}

	public boolean h() {
		return h;
	}

	public void b(boolean var1) {
		h = var1;
		a.b(this);
	}

	public class_ayu.class_a_in_class_ayu i() {
		return i;
	}

	@Override
	public class_ayu.class_a_in_class_ayu j() {
		return j;
	}

	public void a(class_ayu.class_a_in_class_ayu var1) {
		i = var1;
		a.b(this);
	}

	public void b(class_ayu.class_a_in_class_ayu var1) {
		j = var1;
		a.b(this);
	}

	public int k() {
		int var1 = 0;
		if (g()) {
			var1 |= 1;
		}

		if (h()) {
			var1 |= 2;
		}

		return var1;
	}

	public void a(EnumChatFormat var1) {
		k = var1;
	}

	@Override
	public EnumChatFormat l() {
		return k;
	}
}
