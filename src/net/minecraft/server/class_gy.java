package net.minecraft.server;

import java.io.IOException;

public class class_gy implements Packet {
	private boolean a;
	private boolean b;
	private boolean c;
	private boolean d;
	private float e;
	private float f;

	public class_gy() {
	}

	public class_gy(class_ys var1) {
		this.a(var1.a);
		this.b(var1.b);
		this.c(var1.c);
		this.d(var1.d);
		this.a(var1.a());
		this.b(var1.b());
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		byte var2 = var1.readByte();
		this.a((var2 & 1) > 0);
		this.b((var2 & 2) > 0);
		this.c((var2 & 4) > 0);
		this.d((var2 & 8) > 0);
		this.a(var1.readFloat());
		this.b(var1.readFloat());
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		byte var2 = 0;
		if (this.a()) {
			var2 = (byte) (var2 | 1);
		}

		if (this.b()) {
			var2 = (byte) (var2 | 2);
		}

		if (this.c()) {
			var2 = (byte) (var2 | 4);
		}

		if (this.d()) {
			var2 = (byte) (var2 | 8);
		}

		var1.writeByte(var2);
		var1.writeFloat(e);
		var1.writeFloat(f);
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	public boolean a() {
		return a;
	}

	public void a(boolean var1) {
		a = var1;
	}

	public boolean b() {
		return b;
	}

	public void b(boolean var1) {
		b = var1;
	}

	public boolean c() {
		return c;
	}

	public void c(boolean var1) {
		c = var1;
	}

	public boolean d() {
		return d;
	}

	public void d(boolean var1) {
		d = var1;
	}

	public void a(float var1) {
		e = var1;
	}

	public void b(float var1) {
		f = var1;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
