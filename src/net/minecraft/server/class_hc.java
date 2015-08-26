package net.minecraft.server;

import java.io.IOException;

public class class_hc implements Packet {
	private int[] a;

	public class_hc() {
	}

	public class_hc(int... var1) {
		a = var1;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = new int[var1.g()];

		for (int var2 = 0; var2 < a.length; ++var2) {
			a[var2] = var1.g();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a.length);

		for (int var2 = 0; var2 < a.length; ++var2) {
			var1.b(a[var2]);
		}

	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
