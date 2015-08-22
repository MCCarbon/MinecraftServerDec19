package net.minecraft.server;

import java.io.IOException;

public class class_hq implements class_ff {
	private float a;
	private int b;
	private float c;

	public class_hq() {
	}

	public class_hq(float var1, int var2, float var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readFloat();
		b = var1.g();
		c = var1.readFloat();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeFloat(a);
		var1.b(b);
		var1.writeFloat(c);
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
