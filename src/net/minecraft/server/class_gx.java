package net.minecraft.server;

import java.io.IOException;

public class class_gx implements class_ff {
	private class_cj a;

	public class_gx() {
	}

	public class_gx(class_cj var1) {
		a = var1;
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.e();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
