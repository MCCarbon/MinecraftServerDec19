package net.minecraft.server;

import java.io.IOException;

public class class_js implements class_ff {
	private long a;

	public class_js() {
	}

	public class_js(long var1) {
		a = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readLong();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeLong(a);
	}

	public void a(class_jr var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_jr) var1);
	}
}
