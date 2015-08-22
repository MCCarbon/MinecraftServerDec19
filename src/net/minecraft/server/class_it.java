package net.minecraft.server;

import java.io.IOException;

public class class_it implements class_ff {
	private int a;
	private class_it.class_a_in_class_it b;
	private int c;

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = (class_it.class_a_in_class_it) var1.a(class_it.class_a_in_class_it.class);
		c = var1.g();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		var1.b(c);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public class_it.class_a_in_class_it b() {
		return b;
	}

	public int c() {
		return c;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}

	public static enum class_a_in_class_it {
		a,
		b,
		c,
		d,
		e,
		f,
		g;
	}
}
