package net.minecraft.server;

import java.io.IOException;

public class class_is implements Packet {
	private class_cj a;
	private class_cq b;
	private class_is.class_a_in_class_is c;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		c = (class_is.class_a_in_class_is) var1.a(class_is.class_a_in_class_is.class);
		a = var1.e();
		b = class_cq.a(var1.readUnsignedByte());
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(c);
		var1.a(a);
		var1.writeByte(b.a());
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public class_cj a() {
		return a;
	}

	public class_cq b() {
		return b;
	}

	public class_is.class_a_in_class_is c() {
		return c;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}

	public static enum class_a_in_class_is {
		a,
		b,
		c,
		d,
		e,
		f,
		g;
	}
}
