package net.minecraft.server;

import java.io.IOException;

public class class_hp implements Packet {
	private float a;
	private int b;
	private int c;

	public class_hp() {
	}

	public class_hp(float var1, int var2, int var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readFloat();
		c = var1.g();
		b = var1.g();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeFloat(a);
		var1.b(c);
		var1.b(b);
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
