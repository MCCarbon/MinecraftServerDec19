package net.minecraft.server;

import java.io.IOException;

public class class_fq implements class_ff {
	private int a;
	private int b;

	public class_fq() {
	}

	public class_fq(class_qx var1, int var2) {
		a = var1.G();
		b = var2;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.readUnsignedByte();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.writeByte(b);
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
