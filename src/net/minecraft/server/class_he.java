package net.minecraft.server;

import java.io.IOException;

public class class_he implements Packet {
	private String a;
	private String b;

	public class_he() {
	}

	public class_he(String var1, String var2) {
		a = var1;
		b = var2;
		if (var2.length() > 40) {
			throw new IllegalArgumentException("Hash is too long (max 40, was " + var2.length() + ")");
		}
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.c(32767);
		b = var1.c(40);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
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
