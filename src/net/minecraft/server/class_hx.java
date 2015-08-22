package net.minecraft.server;

import java.io.IOException;

public class class_hx implements class_ff {
	private class_ago a;
	private class_cj b;
	private class_eu[] c;

	public class_hx() {
	}

	public class_hx(class_ago var1, class_cj var2, class_eu[] var3) {
		a = var1;
		b = var2;
		c = new class_eu[] { var3[0], var3[1], var3[2], var3[3] };
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		b = var1.e();
		c = new class_eu[4];

		for (int var2 = 0; var2 < 4; ++var2) {
			c[var2] = var1.f();
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(b);

		for (int var2 = 0; var2 < 4; ++var2) {
			var1.a(c[var2]);
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
