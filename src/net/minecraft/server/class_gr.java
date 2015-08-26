package net.minecraft.server;

import java.io.IOException;

public class class_gr implements Packet {
	private int a;
	private class_cj b;
	private int c;
	private boolean d;

	public class_gr() {
	}

	public class_gr(int var1, class_cj var2, int var3, boolean var4) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readInt();
		b = var1.e();
		c = var1.readInt();
		d = var1.readBoolean();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeInt(a);
		var1.a(b);
		var1.writeInt(c);
		var1.writeBoolean(d);
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
