package net.minecraft.server;

import java.io.IOException;

public class class_ik implements class_ff {
	private int a;
	private int b;

	public void a(class_id var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readByte();
		b = var1.readByte();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
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
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
