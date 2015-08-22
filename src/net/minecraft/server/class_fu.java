package net.minecraft.server;

import java.io.IOException;

public class class_fu implements class_ff {
	private class_cj a;
	private int b;
	private int c;
	private class_ail d;

	public class_fu() {
	}

	public class_fu(class_cj var1, class_ail var2, int var3, int var4) {
		a = var1;
		b = var3;
		c = var4;
		d = var2;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = var1.readUnsignedByte();
		c = var1.readUnsignedByte();
		d = class_ail.c(var1.g() & 4095);
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte(b);
		var1.writeByte(c);
		var1.b(class_ail.a(d) & 4095);
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
