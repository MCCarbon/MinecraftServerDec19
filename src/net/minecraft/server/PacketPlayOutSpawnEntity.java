package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

public class PacketPlayOutSpawnEntity implements Packet {
	private int a;
	private UUID b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private int h;
	private int i;
	private int j;
	private int k;
	private int l;

	public PacketPlayOutSpawnEntity() {
	}

	public PacketPlayOutSpawnEntity(Entity var1, int var2) {
		this(var1, var2, 0);
	}

	public PacketPlayOutSpawnEntity(Entity var1, int var2, int var3) {
		a = var1.G();
		b = var1.aQ();
		c = MathHelper.c(var1.s * 32.0D);
		d = MathHelper.c(var1.t * 32.0D);
		e = MathHelper.c(var1.u * 32.0D);
		i = MathHelper.d((var1.z * 256.0F) / 360.0F);
		j = MathHelper.d((var1.y * 256.0F) / 360.0F);
		k = var2;
		l = var3;
		double var4 = 3.9D;
		f = (int) (MathHelper.a(var1.v, -3.9D, 3.9D) * 8000.0D);
		g = (int) (MathHelper.a(var1.w, -3.9D, 3.9D) * 8000.0D);
		h = (int) (MathHelper.a(var1.x, -3.9D, 3.9D) * 8000.0D);
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.i();
		k = var1.readByte();
		c = var1.readInt();
		d = var1.readInt();
		e = var1.readInt();
		i = var1.readByte();
		j = var1.readByte();
		l = var1.readInt();
		f = var1.readShort();
		g = var1.readShort();
		h = var1.readShort();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		var1.writeByte(k);
		var1.writeInt(c);
		var1.writeInt(d);
		var1.writeInt(e);
		var1.writeByte(i);
		var1.writeByte(j);
		var1.writeInt(l);
		var1.writeShort(f);
		var1.writeShort(g);
		var1.writeShort(h);
	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	public void a(int var1) {
		c = var1;
	}

	public void b(int var1) {
		d = var1;
	}

	public void c(int var1) {
		e = var1;
	}

	public void d(int var1) {
		f = var1;
	}

	public void e(int var1) {
		g = var1;
	}

	public void f(int var1) {
		h = var1;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
