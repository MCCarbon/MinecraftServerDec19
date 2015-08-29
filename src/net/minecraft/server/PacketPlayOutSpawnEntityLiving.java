package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PacketPlayOutSpawnEntityLiving implements Packet {
	private int a;
	private UUID b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private int h;
	private int i;
	private byte j;
	private byte k;
	private byte l;
	private DataWatcher m;
	private List n;

	public PacketPlayOutSpawnEntityLiving() {
	}

	public PacketPlayOutSpawnEntityLiving(EntityLiving var1) {
		a = var1.G();
		b = var1.aQ();
		c = (byte) EntityTypes.a(var1);
		d = MathHelper.c(var1.s * 32.0D);
		e = MathHelper.c(var1.t * 32.0D);
		f = MathHelper.c(var1.u * 32.0D);
		j = (byte) ((int) ((var1.y * 256.0F) / 360.0F));
		k = (byte) ((int) ((var1.z * 256.0F) / 360.0F));
		l = (byte) ((int) ((var1.aO * 256.0F) / 360.0F));
		double var2 = 3.9D;
		double var4 = var1.v;
		double var6 = var1.w;
		double var8 = var1.x;
		if (var4 < -var2) {
			var4 = -var2;
		}

		if (var6 < -var2) {
			var6 = -var2;
		}

		if (var8 < -var2) {
			var8 = -var2;
		}

		if (var4 > var2) {
			var4 = var2;
		}

		if (var6 > var2) {
			var6 = var2;
		}

		if (var8 > var2) {
			var8 = var2;
		}

		g = (int) (var4 * 8000.0D);
		h = (int) (var6 * 8000.0D);
		i = (int) (var8 * 8000.0D);
		m = var1.J();
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.i();
		c = var1.readByte() & 255;
		d = var1.readInt();
		e = var1.readInt();
		f = var1.readInt();
		j = var1.readByte();
		k = var1.readByte();
		l = var1.readByte();
		g = var1.readShort();
		h = var1.readShort();
		i = var1.readShort();
		n = DataWatcher.b(var1);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		var1.writeByte(c & 255);
		var1.writeInt(d);
		var1.writeInt(e);
		var1.writeInt(f);
		var1.writeByte(j);
		var1.writeByte(k);
		var1.writeByte(l);
		var1.writeShort(g);
		var1.writeShort(h);
		var1.writeShort(i);
		m.a(var1);
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
