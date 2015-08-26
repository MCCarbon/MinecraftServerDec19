package net.minecraft.server;

import java.io.IOException;

public class class_hk implements Packet {
	private int a;
	private String b;

	public class_hk() {
	}

	public class_hk(int var1, class_ayo var2) {
		a = var1;
		if (var2 == null) {
			b = "";
		} else {
			b = var2.b();
		}

	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readByte();
		b = var1.c(16);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.a(b);
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
