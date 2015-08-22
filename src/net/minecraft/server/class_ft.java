package net.minecraft.server;

import java.io.IOException;

public class class_ft implements class_ff {
	private class_cj a;
	private int b;
	private class_dn c;

	public class_ft() {
	}

	public class_ft(class_cj var1, int var2, class_dn var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = var1.readUnsignedByte();
		c = var1.j();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte((byte) b);
		var1.a(c);
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
