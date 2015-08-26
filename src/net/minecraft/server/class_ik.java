package net.minecraft.server;

import java.io.IOException;

public class class_ik implements Packet {
	private int a;
	private int b;

	public void a(class_id var1) {
		var1.a(this);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readByte();
		b = var1.readByte();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.writeByte(b);
	}

	public int a() {
		return a;
	}

	public int b() {
		return b;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
