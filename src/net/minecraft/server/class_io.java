package net.minecraft.server;

import java.io.IOException;

public class class_io implements class_ff {
	private int a;
	private class_io.class_a_in_class_io b;
	private class_aym c;
	private class_pu d;

	public class_io() {
	}

	public class_io(Entity var1) {
		a = var1.G();
		b = class_io.class_a_in_class_io.b;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = (class_io.class_a_in_class_io) var1.a(class_io.class_a_in_class_io.class);
		if (b == class_io.class_a_in_class_io.c) {
			c = new class_aym(var1.readFloat(), var1.readFloat(), var1.readFloat());
		}

		if ((b == class_io.class_a_in_class_io.a) || (b == class_io.class_a_in_class_io.c)) {
			d = (class_pu) var1.a(class_pu.class);
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		if (b == class_io.class_a_in_class_io.c) {
			var1.writeFloat((float) c.a);
			var1.writeFloat((float) c.b);
			var1.writeFloat((float) c.c);
		}

		if ((b == class_io.class_a_in_class_io.a) || (b == class_io.class_a_in_class_io.c)) {
			var1.a(d);
		}

	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public Entity a(class_ago var1) {
		return var1.a(a);
	}

	public class_io.class_a_in_class_io a() {
		return b;
	}

	public class_pu b() {
		return d;
	}

	public class_aym c() {
		return c;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}

	public static enum class_a_in_class_io {
		a,
		b,
		c;
	}
}
