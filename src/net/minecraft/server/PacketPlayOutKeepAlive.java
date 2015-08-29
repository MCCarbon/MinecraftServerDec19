package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutKeepAlive implements Packet {
	private int a;

	public PacketPlayOutKeepAlive() {
	}

	public PacketPlayOutKeepAlive(int var1) {
		a = var1;
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
