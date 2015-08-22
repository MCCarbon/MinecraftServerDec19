package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

public class class_fk implements class_ff {
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

	public class_fk() {
	}

	public class_fk(Entity var1, int var2) {
		this(var1, var2, 0);
	}

	public class_fk(Entity var1, int var2, int var3) {
		a = var1.G();
		b = var1.aQ();
		c = class_oa.c(var1.s * 32.0D);
		d = class_oa.c(var1.t * 32.0D);
		e = class_oa.c(var1.u * 32.0D);
		i = class_oa.d((var1.z * 256.0F) / 360.0F);
		j = class_oa.d((var1.y * 256.0F) / 360.0F);
		k = var2;
		l = var3;
		double var4 = 3.9D;
		f = (int) (class_oa.a(var1.v, -3.9D, 3.9D) * 8000.0D);
		g = (int) (class_oa.a(var1.w, -3.9D, 3.9D) * 8000.0D);
		h = (int) (class_oa.a(var1.x, -3.9D, 3.9D) * 8000.0D);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
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
	public void b(PacketDataSerializer var1) throws IOException {
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

	public void a(class_fj var1) {
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
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
