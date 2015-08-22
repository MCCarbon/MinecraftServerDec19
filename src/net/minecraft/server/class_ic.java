package net.minecraft.server;

import java.io.IOException;

public class class_ic implements class_ff {
	private int a;
	private byte b;
	private byte c;
	private int d;
	private byte e;

	public class_ic() {
	}

	public class_ic(int var1, class_qr var2) {
		a = var1;
		b = (byte) (class_qq.a(var2.a()) & 255);
		c = (byte) (var2.c() & 255);
		if (var2.b() > 32767) {
			d = 32767;
		} else {
			d = var2.b();
		}

		e = (byte) (var2.e() ? 1 : 0);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.readByte();
		c = var1.readByte();
		d = var1.g();
		e = var1.readByte();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.writeByte(b);
		var1.writeByte(c);
		var1.b(d);
		var1.writeByte(e);
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
