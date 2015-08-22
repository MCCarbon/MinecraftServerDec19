package net.minecraft.server;

import java.io.IOException;

public class class_ht implements class_ff {
	private String a = "";
	private String b = "";
	private int c;
	private class_ht.class_a_in_class_ht d;

	public class_ht() {
	}

	public class_ht(class_ayq var1) {
		a = var1.e();
		b = var1.d().b();
		c = var1.c();
		d = class_ht.class_a_in_class_ht.a;
	}

	public class_ht(String var1) {
		a = var1;
		b = "";
		c = 0;
		d = class_ht.class_a_in_class_ht.b;
	}

	public class_ht(String var1, class_ayo var2) {
		a = var1;
		b = var2.b();
		c = 0;
		d = class_ht.class_a_in_class_ht.b;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.c(40);
		d = (class_ht.class_a_in_class_ht) var1.a(class_ht.class_a_in_class_ht.class);
		b = var1.c(16);
		if (d != class_ht.class_a_in_class_ht.b) {
			c = var1.g();
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.a(d);
		var1.a(b);
		if (d != class_ht.class_a_in_class_ht.b) {
			var1.b(c);
		}

	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}

	public static enum class_a_in_class_ht {
		a,
		b;
	}
}
