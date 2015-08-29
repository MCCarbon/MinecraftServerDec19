package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutAnimation implements Packet {
	private int a;
	private int b;

	public PacketPlayOutAnimation() {
	}

	public PacketPlayOutAnimation(Entity var1, int var2) {
		a = var1.G();
		b = var2;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.readUnsignedByte();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.writeByte(b);
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
