package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PacketPlayOutNamedEntitySpawn implements Packet {
	private int a;
	private UUID b;
	private int c;
	private int d;
	private int e;
	private byte f;
	private byte g;
	private DataWatcher h;
	private List i;

	public PacketPlayOutNamedEntitySpawn() {
	}

	public PacketPlayOutNamedEntitySpawn(class_yu var1) {
		a = var1.G();
		b = var1.cl().getId();
		c = MathHelper.c(var1.s * 32.0D);
		d = MathHelper.c(var1.t * 32.0D);
		e = MathHelper.c(var1.u * 32.0D);
		f = (byte) ((int) ((var1.y * 256.0F) / 360.0F));
		g = (byte) ((int) ((var1.z * 256.0F) / 360.0F));
		h = var1.J();
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.i();
		c = var1.readInt();
		d = var1.readInt();
		e = var1.readInt();
		f = var1.readByte();
		g = var1.readByte();
		i = DataWatcher.b(var1);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		var1.writeInt(c);
		var1.writeInt(d);
		var1.writeInt(e);
		var1.writeByte(f);
		var1.writeByte(g);
		h.a(var1);
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
