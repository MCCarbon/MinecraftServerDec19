package net.minecraft.server;

import java.io.IOException;

public class class_hc implements class_ff {
	private int[] a;

	public class_hc() {
	}

	public class_hc(int... var1) {
		a = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = new int[var1.g()];

		for (int var2 = 0; var2 < a.length; ++var2) {
			a[var2] = var1.g();
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a.length);

		for (int var2 = 0; var2 < a.length; ++var2) {
			var1.b(a[var2]);
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
