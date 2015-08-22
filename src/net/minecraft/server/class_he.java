package net.minecraft.server;

import java.io.IOException;

public class class_he implements class_ff {
	private String a;
	private String b;

	public class_he() {
	}

	public class_he(String var1, String var2) {
		a = var1;
		b = var2;
		if (var2.length() > 40) {
			throw new IllegalArgumentException("Hash is too long (max 40, was " + var2.length() + ")");
		}
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.c(32767);
		b = var1.c(40);
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
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
