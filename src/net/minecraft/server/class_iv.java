package net.minecraft.server;

import java.io.IOException;

public class class_iv implements Packet {
	private String a;
	private class_iv.class_a_in_class_iv b;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.c(40);
		b = (class_iv.class_a_in_class_iv) var1.a(class_iv.class_a_in_class_iv.class);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.a(b);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}

	public static enum class_a_in_class_iv {
		a,
		b,
		c,
		d;
	}
}
