package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutEntityStatus implements Packet {
	private int a;
	private byte b;

	public PacketPlayOutEntityStatus() {
	}

	public PacketPlayOutEntityStatus(Entity var1, byte var2) {
		a = var1.G();
		b = var2;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readInt();
		b = var1.readByte();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeInt(a);
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
