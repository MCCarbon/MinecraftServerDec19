package net.minecraft.server;

import java.io.IOException;

public class class_im implements class_ff {
	private int a;

	public void a(class_id var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readByte();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
