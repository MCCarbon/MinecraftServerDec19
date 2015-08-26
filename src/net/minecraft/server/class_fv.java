package net.minecraft.server;

import java.io.IOException;

public class class_fv implements Packet {
	private class_cj a;
	private class_apn b;

	public class_fv() {
	}

	public class_fv(class_ago var1, class_cj var2) {
		a = var2;
		b = var1.p(var2);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = (class_apn) Block.d.a(var1.g());
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.b(Block.d.a(b));
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
