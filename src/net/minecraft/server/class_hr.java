package net.minecraft.server;

import java.io.IOException;

public class class_hr implements class_ff {
	private String a;
	private String b;
	private class_ayy.class_a_in_class_ayy c;
	private int d;

	public class_hr() {
	}

	public class_hr(class_ayo var1, int var2) {
		a = var1.b();
		b = var1.d();
		c = var1.c().c();
		d = var2;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.c(16);
		d = var1.readByte();
		if ((d == 0) || (d == 2)) {
			b = var1.c(32);
			c = class_ayy.class_a_in_class_ayy.a(var1.c(16));
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte(d);
		if ((d == 0) || (d == 2)) {
			var1.a(b);
			var1.a(c.a());
		}

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
