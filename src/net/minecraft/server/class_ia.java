package net.minecraft.server;

import java.io.IOException;

public class class_ia implements Packet {
	private int a;
	private int b;
	private int c;
	private int d;
	private byte e;
	private byte f;
	private boolean g;

	public class_ia() {
	}

	public class_ia(Entity var1) {
		a = var1.G();
		b = MathHelper.c(var1.s * 32.0D);
		c = MathHelper.c(var1.t * 32.0D);
		d = MathHelper.c(var1.u * 32.0D);
		e = (byte) ((int) ((var1.y * 256.0F) / 360.0F));
		f = (byte) ((int) ((var1.z * 256.0F) / 360.0F));
		g = var1.C;
	}

	public class_ia(int var1, int var2, int var3, int var4, byte var5, byte var6, boolean var7) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
		e = var5;
		f = var6;
		g = var7;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.readInt();
		c = var1.readInt();
		d = var1.readInt();
		e = var1.readByte();
		f = var1.readByte();
		g = var1.readBoolean();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.writeInt(b);
		var1.writeInt(c);
		var1.writeInt(d);
		var1.writeByte(e);
		var1.writeByte(f);
		var1.writeBoolean(g);
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
