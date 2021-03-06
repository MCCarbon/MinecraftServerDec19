package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutBlockBreakAnimation implements Packet {
	private int a;
	private class_cj b;
	private int c;

	public PacketPlayOutBlockBreakAnimation() {
	}

	public PacketPlayOutBlockBreakAnimation(int var1, class_cj var2, int var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.e();
		c = var1.readUnsignedByte();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		var1.writeByte(c);
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
