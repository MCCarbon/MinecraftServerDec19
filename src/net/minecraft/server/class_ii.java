package net.minecraft.server;

import java.io.IOException;

public class class_ii implements Packet {
	private String a;
	private int b;
	private class_yu.class_b_in_class_yu c;
	private boolean d;
	private int e;
	private class_rf f;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.c(7);
		b = var1.readByte();
		c = (class_yu.class_b_in_class_yu) var1.a(class_yu.class_b_in_class_yu.class);
		d = var1.readBoolean();
		e = var1.readUnsignedByte();
		f = (class_rf) var1.a(class_rf.class);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte(b);
		var1.a(c);
		var1.writeBoolean(d);
		var1.writeByte(e);
		var1.a(f);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public String a() {
		return a;
	}

	public class_yu.class_b_in_class_yu c() {
		return c;
	}

	public boolean d() {
		return d;
	}

	public int e() {
		return e;
	}

	public class_rf f() {
		return f;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
