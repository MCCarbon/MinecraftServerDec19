package net.minecraft.server;

import java.io.IOException;

public class class_jc implements class_ff {
	private class_pu a;

	public class_jc() {
	}

	public class_jc(class_pu var1) {
		a = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = (class_pu) var1.a(class_pu.class);
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public class_pu a() {
		return a;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
