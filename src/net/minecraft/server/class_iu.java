package net.minecraft.server;

import java.io.IOException;

public class class_iu implements Packet {
	private float a;
	private float b;
	private boolean c;
	private boolean d;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readFloat();
		b = var1.readFloat();
		byte var2 = var1.readByte();
		c = (var2 & 1) > 0;
		d = (var2 & 2) > 0;
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeFloat(a);
		var1.writeFloat(b);
		byte var2 = 0;
		if (c) {
			var2 = (byte) (var2 | 1);
		}

		if (d) {
			var2 = (byte) (var2 | 2);
		}

		var1.writeByte(var2);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public float a() {
		return a;
	}

	public float b() {
		return b;
	}

	public boolean c() {
		return c;
	}

	public boolean d() {
		return d;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
