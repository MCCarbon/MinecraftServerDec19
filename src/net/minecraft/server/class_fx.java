package net.minecraft.server;

import java.io.IOException;

public class class_fx implements class_ff {
	private class_ps a;
	private boolean b;

	public class_fx() {
	}

	public class_fx(class_ps var1, boolean var2) {
		a = var1;
		b = var2;
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = class_ps.a(var1.readUnsignedByte());
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a.a());
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
