package net.minecraft.server;

import java.io.IOException;

public class class_hi implements class_ff {
	public int a;

	public class_hi() {
	}

	public class_hi(Entity var1) {
		a = var1.G();
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.g();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a);
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
