package net.minecraft.server;

import java.io.IOException;

public class class_gn implements Packet {
	public static final String[] a = new String[] { "tile.bed.notValid" };
	private int b;
	private float c;

	public class_gn() {
	}

	public class_gn(int var1, float var2) {
		b = var1;
		c = var2;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		b = var1.readUnsignedByte();
		c = var1.readFloat();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(b);
		var1.writeFloat(c);
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
