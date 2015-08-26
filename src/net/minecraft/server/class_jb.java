package net.minecraft.server;

import java.io.IOException;

public class class_jb implements Packet {
	private class_cj a;
	private class_cq b;
	private class_pu c;
	private float d;
	private float e;
	private float f;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = (class_cq) var1.a(class_cq.class);
		c = (class_pu) var1.a(class_pu.class);
		d = var1.readUnsignedByte() / 16.0F;
		e = var1.readUnsignedByte() / 16.0F;
		f = var1.readUnsignedByte() / 16.0F;
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.a(b);
		var1.a(c);
		var1.writeByte((int) (d * 16.0F));
		var1.writeByte((int) (e * 16.0F));
		var1.writeByte((int) (f * 16.0F));
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public class_cj a() {
		return a;
	}

	public class_cq b() {
		return b;
	}

	public class_pu c() {
		return c;
	}

	public float d() {
		return d;
	}

	public float e() {
		return e;
	}

	public float f() {
		return f;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
