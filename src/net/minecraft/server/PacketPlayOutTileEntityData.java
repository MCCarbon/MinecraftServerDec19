package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutTileEntityData implements Packet {
	private class_cj a;
	private int b;
	private class_dn c;

	public PacketPlayOutTileEntityData() {
	}

	public PacketPlayOutTileEntityData(class_cj var1, int var2, class_dn var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = var1.readUnsignedByte();
		c = var1.j();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeByte((byte) b);
		var1.a(c);
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
