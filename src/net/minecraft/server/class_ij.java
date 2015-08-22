package net.minecraft.server;

import java.io.IOException;

public class class_ij implements class_ff {
	private int a;
	private short b;
	private boolean c;

	public void a(class_id var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readByte();
		b = var1.readShort();
		c = var1.readByte() != 0;
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.writeShort(b);
		var1.writeByte(c ? 1 : 0);
	}

	public int a() {
		return a;
	}

	public short b() {
		return b;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
