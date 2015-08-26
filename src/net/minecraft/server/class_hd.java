package net.minecraft.server;

import java.io.IOException;

public class class_hd implements Packet {
	private int a;
	private class_qq b;

	public class_hd() {
	}

	public class_hd(int var1, class_qq var2) {
		a = var1;
		b = var2;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = class_qq.a(var1.readUnsignedByte());
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.writeByte(class_qq.a(b));
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
