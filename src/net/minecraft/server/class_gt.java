package net.minecraft.server;

import java.io.IOException;

import org.apache.commons.lang3.Validate;

public class class_gt implements Packet {
	private String a;
	private int b;
	private int c = Integer.MAX_VALUE;
	private int d;
	private float e;
	private int f;

	public class_gt() {
	}

	public class_gt(String var1, double var2, double var4, double var6, float var8, float var9) {
		Validate.notNull(var1, "name", new Object[0]);
		a = var1;
		b = (int) (var2 * 8.0D);
		c = (int) (var4 * 8.0D);
		d = (int) (var6 * 8.0D);
		e = var8;
		f = (int) (var9 * 63.0F);
		var9 = MathHelper.a(var9, 0.0F, 255.0F);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.c(256);
		b = var1.readInt();
		c = var1.readInt();
		d = var1.readInt();
		e = var1.readFloat();
		f = var1.readUnsignedByte();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.writeInt(b);
		var1.writeInt(c);
		var1.writeInt(d);
		var1.writeFloat(e);
		var1.writeByte(f);
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
