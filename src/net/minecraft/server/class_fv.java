package net.minecraft.server;

import java.io.IOException;

public class class_fv implements class_ff {
	private class_cj a;
	private class_apn b;

	public class_fv() {
	}

	public class_fv(class_ago var1, class_cj var2) {
		a = var2;
		b = var1.p(var2);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = (class_apn) class_ail.d.a(var1.g());
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.b(class_ail.d.a(b));
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
