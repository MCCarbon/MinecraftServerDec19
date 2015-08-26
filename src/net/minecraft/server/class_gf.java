package net.minecraft.server;

import java.io.IOException;

public class class_gf implements Packet {
	private int a;
	private int b;
	private int c;

	public class_gf() {
	}

	public class_gf(int var1, int var2, int var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readUnsignedByte();
		b = var1.readShort();
		c = var1.readShort();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.writeShort(b);
		var1.writeShort(c);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
