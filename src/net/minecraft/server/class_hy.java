package net.minecraft.server;

import java.io.IOException;

public class class_hy implements class_ff {
	private class_eu a;
	private class_eu b;

	public class_hy() {
	}

	public class_hy(class_eu var1) {
		a = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.f();
		b = var1.f();
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
