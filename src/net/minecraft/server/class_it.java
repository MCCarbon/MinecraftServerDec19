package net.minecraft.server;

import java.io.IOException;

public class class_it implements Packet {
	private int a;
	private class_it.class_a_in_class_it b;
	private int c;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = (class_it.class_a_in_class_it) var1.a(class_it.class_a_in_class_it.class);
		c = var1.g();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
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
	public void handle(PacketListener var1) {
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
