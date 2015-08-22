package net.minecraft.server;

import java.io.IOException;

public class class_hb implements class_ff {
	private int a;
	private class_cj b;

	public class_hb() {
	}

	public class_hb(class_yu var1, class_cj var2) {
		a = var1.G();
		b = var2;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.e();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a);
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
