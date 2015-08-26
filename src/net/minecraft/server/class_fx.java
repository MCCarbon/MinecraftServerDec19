package net.minecraft.server;

import java.io.IOException;

public class class_fx implements Packet {
	private class_ps a;
	private boolean b;

	public class_fx() {
	}

	public class_fx(class_ps var1, boolean var2) {
		a = var1;
		b = var2;
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = class_ps.a(var1.readUnsignedByte());
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a.a());
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
