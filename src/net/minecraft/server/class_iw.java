package net.minecraft.server;

import java.io.IOException;

public class class_iw implements class_ff {
	private int a;

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readShort();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
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
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
