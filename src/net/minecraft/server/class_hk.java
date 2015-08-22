package net.minecraft.server;

import java.io.IOException;

public class class_hk implements class_ff {
	private int a;
	private String b;

	public class_hk() {
	}

	public class_hk(int var1, class_ayo var2) {
		a = var1;
		if (var2 == null) {
			b = "";
		} else {
			b = var2.b();
		}

	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readByte();
		b = var1.c(16);
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.a(b);
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
