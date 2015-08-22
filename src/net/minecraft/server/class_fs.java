package net.minecraft.server;

import java.io.IOException;

public class class_fs implements class_ff {
	private int a;
	private class_cj b;
	private int c;

	public class_fs() {
	}

	public class_fs(int var1, class_cj var2, int var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.e();
		c = var1.readUnsignedByte();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		var1.writeByte(c);
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
