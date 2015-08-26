package net.minecraft.server;

import java.io.IOException;

public class class_gh implements Packet {
	private Item a;
	private int b;

	public class_gh() {
	}

	public class_gh(Item var1, int var2) {
		a = var1;
		b = var2;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = Item.c(var1.g());
		b = var1.g();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(Item.a(a));
		var1.b(b);
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
