package net.minecraft.server;

import java.io.IOException;

public class class_gn implements class_ff {
	public static final String[] a = new String[] { "tile.bed.notValid" };
	private int b;
	private float c;

	public class_gn() {
	}

	public class_gn(int var1, float var2) {
		b = var1;
		c = var2;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		b = var1.readUnsignedByte();
		c = var1.readFloat();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeByte(b);
		var1.writeFloat(c);
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
