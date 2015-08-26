package net.minecraft.server;

import java.io.IOException;

public class class_gb implements Packet {
	private int a;
	private short b;
	private boolean c;

	public class_gb() {
	}

	public class_gb(int var1, short var2, boolean var3) {
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
		c = var1.readBoolean();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.writeShort(b);
		var1.writeBoolean(c);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
