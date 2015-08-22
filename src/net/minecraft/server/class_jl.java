package net.minecraft.server;

import java.io.IOException;

public class class_jl implements class_ff {
	private class_eu a;

	public class_jl() {
	}

	public class_jl(class_eu var1) {
		a = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.f();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
	}

	public void a(class_jh var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_jh) var1);
	}
}
