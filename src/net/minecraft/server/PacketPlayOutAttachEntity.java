package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutAttachEntity implements Packet {
	private int a;
	private int b;
	private int c;

	public PacketPlayOutAttachEntity() {
	}

	public PacketPlayOutAttachEntity(int var1, Entity var2, Entity var3) {
		a = var1;
		b = var2.G();
		c = var3 != null ? var3.G() : -1;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		b = var1.readInt();
		c = var1.readInt();
		a = var1.readUnsignedByte();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeInt(b);
		var1.writeInt(c);
		var1.writeByte(a);
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
