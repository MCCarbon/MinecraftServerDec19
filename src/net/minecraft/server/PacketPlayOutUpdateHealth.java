package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutUpdateHealth implements Packet {
	private float a;
	private int b;
	private float c;

	public PacketPlayOutUpdateHealth() {
	}

	public PacketPlayOutUpdateHealth(float var1, int var2, float var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readFloat();
		b = var1.g();
		c = var1.readFloat();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeFloat(a);
		var1.b(b);
		var1.writeFloat(c);
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
