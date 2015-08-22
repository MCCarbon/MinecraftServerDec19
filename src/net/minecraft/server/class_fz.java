package net.minecraft.server;

import java.io.IOException;

public class class_fz implements class_ff {
	private class_eu a;
	private byte b;

	public class_fz() {
	}

	public class_fz(class_eu var1) {
		this(var1, (byte) 1);
	}

	public class_fz(class_eu var1, byte var2) {
		a = var1;
		b = var2;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.f();
		b = var1.readByte();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte(b);
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	public boolean b() {
		return (b == 1) || (b == 2);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
