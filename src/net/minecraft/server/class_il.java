package net.minecraft.server;

import java.io.IOException;

public class class_il implements Packet {
	private int a;
	private int b;
	private int c;
	private short d;
	private class_aco e;
	private int f;

	public void a(class_id var1) {
		var1.a(this);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readByte();
		b = var1.readShort();
		c = var1.readByte();
		d = var1.readShort();
		f = var1.readByte();
		e = var1.k();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.writeShort(b);
		var1.writeByte(c);
		var1.writeShort(d);
		var1.writeByte(f);
		var1.a(e);
	}

	public int a() {
		return a;
	}

	public int b() {
		return b;
	}

	public int c() {
		return c;
	}

	public short d() {
		return d;
	}

	public class_aco e() {
		return e;
	}

	public int f() {
		return f;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
