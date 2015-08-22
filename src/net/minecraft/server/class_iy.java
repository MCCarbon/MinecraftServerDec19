package net.minecraft.server;

import java.io.IOException;

public class class_iy implements class_ff {
	private class_cj a;
	private class_eu[] b;

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = new class_eu[4];

		for (int var2 = 0; var2 < 4; ++var2) {
			String var3 = var1.c(384);
			class_eu var4 = class_eu.class_a_in_class_eu.a(var3);
			b[var2] = var4;
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);

		for (int var2 = 0; var2 < 4; ++var2) {
			class_eu var3 = b[var2];
			String var4 = class_eu.class_a_in_class_eu.a(var3);
			var1.a(var4);
		}

	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public class_cj a() {
		return a;
	}

	public class_eu[] b() {
		return b;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_id) var1);
	}
}
