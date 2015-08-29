package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutLogin implements Packet {
	private int a;
	private boolean b;
	private class_agr.class_a_in_class_agr c;
	private int d;
	private class_ps e;
	private int f;
	private class_agt g;
	private boolean h;

	public PacketPlayOutLogin() {
	}

	public PacketPlayOutLogin(int var1, class_agr.class_a_in_class_agr var2, boolean var3, int var4, class_ps var5, int var6, class_agt var7, boolean var8) {
		a = var1;
		d = var4;
		e = var5;
		c = var2;
		f = var6;
		b = var3;
		g = var7;
		h = var8;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readInt();
		short var2 = var1.readUnsignedByte();
		b = (var2 & 8) == 8;
		int var3 = var2 & -9;
		c = class_agr.class_a_in_class_agr.a(var3);
		d = var1.readByte();
		e = class_ps.a(var1.readUnsignedByte());
		f = var1.readUnsignedByte();
		g = class_agt.a(var1.c(16));
		if (g == null) {
			g = class_agt.b;
		}

		h = var1.readBoolean();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeInt(a);
		int var2 = c.a();
		if (b) {
			var2 |= 8;
		}

		var1.writeByte(var2);
		var1.writeByte(d);
		var1.writeByte(e.a());
		var1.writeByte(f);
		var1.a(g.a());
		var1.writeBoolean(h);
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
