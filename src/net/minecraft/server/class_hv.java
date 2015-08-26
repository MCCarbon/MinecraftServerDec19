package net.minecraft.server;

import java.io.IOException;

public class class_hv implements Packet {
	private long a;
	private long b;

	public class_hv() {
	}

	public class_hv(long var1, long var3, boolean var5) {
		a = var1;
		b = var3;
		if (!var5) {
			b = -b;
			if (b == 0L) {
				b = -1L;
			}
		}

	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readLong();
		b = var1.readLong();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeLong(a);
		var1.writeLong(b);
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
