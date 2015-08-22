package net.minecraft.server;

import java.io.IOException;

public class class_hm implements class_ff {
	private int a;
	private int b;
	private int c;

	public class_hm() {
	}

	public class_hm(int var1, Entity var2, Entity var3) {
		a = var1;
		b = var2.G();
		c = var3 != null ? var3.G() : -1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		b = var1.readInt();
		c = var1.readInt();
		a = var1.readUnsignedByte();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeInt(b);
		var1.writeInt(c);
		var1.writeByte(a);
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
