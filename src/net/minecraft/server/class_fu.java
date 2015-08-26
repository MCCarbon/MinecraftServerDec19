package net.minecraft.server;

import java.io.IOException;

public class class_fu implements Packet {
	private class_cj a;
	private int b;
	private int c;
	private Block d;

	public class_fu() {
	}

	public class_fu(class_cj var1, Block var2, int var3, int var4) {
		a = var1;
		b = var3;
		c = var4;
		d = var2;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = var1.readUnsignedByte();
		c = var1.readUnsignedByte();
		d = Block.c(var1.g() & 4095);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte(b);
		var1.writeByte(c);
		var1.b(Block.a(d) & 4095);
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
