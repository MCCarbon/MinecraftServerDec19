package net.minecraft.server;

import java.io.IOException;

public class class_jw implements class_ff {
	private long a;

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readLong();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
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
	public void a(class_ep var1) {
		this.a((class_jv) var1);
	}
}
