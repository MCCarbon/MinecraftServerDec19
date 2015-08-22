package net.minecraft.server;

import java.io.IOException;

public class class_ho implements class_ff {
	private int a;
	private class_rc b;
	private class_aco c;

	public class_ho() {
	}

	public class_ho(int var1, class_rc var2, class_aco var3) {
		a = var1;
		b = var2;
		c = var3 == null ? null : var3.k();
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = (class_rc) var1.a(class_rc.class);
		c = var1.k();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		var1.a(c);
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
