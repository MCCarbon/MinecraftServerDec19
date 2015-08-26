package net.minecraft.server;

import java.io.IOException;

public class class_hi implements Packet {
	public int a;

	public class_hi() {
	}

	public class_hi(Entity var1) {
		a = var1.G();
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
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
