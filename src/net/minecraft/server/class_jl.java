package net.minecraft.server;

import java.io.IOException;

public class class_jl implements Packet {
	private IChatBaseComponent a;

	public class_jl() {
	}

	public class_jl(IChatBaseComponent var1) {
		a = var1;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.f();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
	}

	public void a(class_jh var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_jh) var1);
	}
}
