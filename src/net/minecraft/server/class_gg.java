package net.minecraft.server;

import java.io.IOException;

public class class_gg implements class_ff {
	private int a;
	private int b;
	private class_aco c;

	public class_gg() {
	}

	public class_gg(int var1, int var2, class_aco var3) {
		a = var1;
		b = var2;
		c = var3 == null ? null : var3.k();
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readByte();
		b = var1.readShort();
		c = var1.k();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.writeShort(b);
		var1.a(c);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
