package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutSpawnEntityPainting implements Packet {
	private int a;
	private class_cj b;
	private class_cq c;
	private String d;

	public PacketPlayOutSpawnEntityPainting() {
	}

	public PacketPlayOutSpawnEntityPainting(EntityPainting var1) {
		a = var1.G();
		b = var1.m();
		c = var1.b;
		d = var1.c.B;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		d = var1.c(EntityPainting.class_a_in_class_ww.A);
		b = var1.e();
		c = class_cq.b(var1.readUnsignedByte());
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(d);
		var1.a(b);
		var1.writeByte(c.b());
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
