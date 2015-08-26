package net.minecraft.server;

import java.io.IOException;

public class class_jw implements Packet {
	private long a;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readLong();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeLong(a);
	}

	public void a(class_jv var1) {
		var1.a(this);
	}

	public long a() {
		return a;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_jv) var1);
	}
}
