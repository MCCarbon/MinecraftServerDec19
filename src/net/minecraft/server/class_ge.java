package net.minecraft.server;

import java.io.IOException;
import java.util.List;

public class class_ge implements Packet {
	private int a;
	private class_aco[] b;

	public class_ge() {
	}

	public class_ge(int var1, List var2) {
		a = var1;
		b = new class_aco[var2.size()];

		for (int var3 = 0; var3 < b.length; ++var3) {
			class_aco var4 = (class_aco) var2.get(var3);
			b[var3] = var4 == null ? null : var4.k();
		}

	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readUnsignedByte();
		short var2 = var1.readShort();
		b = new class_aco[var2];

		for (int var3 = 0; var3 < var2; ++var3) {
			b[var3] = var1.k();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.writeShort(b.length);
		class_aco[] var2 = b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_aco var5 = var2[var4];
			var1.a(var5);
		}

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
