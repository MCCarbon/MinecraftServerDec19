package net.minecraft.server;

import java.io.IOException;

public class class_iw implements Packet {
	private int a;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readShort();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeShort(a);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public int a() {
		return a;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
