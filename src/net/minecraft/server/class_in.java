package net.minecraft.server;

import java.io.IOException;

public class class_in implements class_ff {
	private String a;
	private PacketDataSerializer b;

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.c(20);
		int var2 = var1.readableBytes();
		if ((var2 >= 0) && (var2 <= 32767)) {
			b = new PacketDataSerializer(var1.readBytes(var2));
		} else {
			throw new IOException("Payload may not be larger than 32767 bytes");
		}
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeBytes(b);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public String a() {
		return a;
	}

	public PacketDataSerializer b() {
		return b;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
