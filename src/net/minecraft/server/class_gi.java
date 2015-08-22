package net.minecraft.server;

import java.io.IOException;

public class class_gi implements class_ff {
	private String a;
	private PacketDataSerializer b;

	public class_gi() {
	}

	public class_gi(String var1, PacketDataSerializer var2) {
		a = var1;
		b = var2;
		if (var2.writerIndex() > 1048576) {
			throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
		}
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.c(20);
		int var2 = var1.readableBytes();
		if ((var2 >= 0) && (var2 <= 1048576)) {
			b = new PacketDataSerializer(var1.readBytes(var2));
		} else {
			throw new IOException("Payload may not be larger than 1048576 bytes");
		}
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeBytes(b);
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
}
