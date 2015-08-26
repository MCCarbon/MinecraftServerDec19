package net.minecraft.server;

import java.io.IOException;

public class class_fz implements Packet {
	private IChatBaseComponent a;
	private byte b;

	public class_fz() {
	}

	public class_fz(IChatBaseComponent var1) {
		this(var1, (byte) 1);
	}

	public class_fz(IChatBaseComponent var1, byte var2) {
		a = var1;
		b = var2;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.f();
		b = var1.readByte();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte(b);
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	public boolean b() {
		return (b == 1) || (b == 2);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
