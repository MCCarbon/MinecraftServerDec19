package net.minecraft.server;

import java.io.IOException;
import java.util.Collection;

public class class_gv implements Packet {
	private int a;
	private byte b;
	private boolean c;
	private class_axk[] d;
	private int e;
	private int f;
	private int g;
	private int h;
	private byte[] i;

	public class_gv() {
	}

	public class_gv(int var1, byte var2, boolean var3, Collection var4, byte[] var5, int var6, int var7, int var8, int var9) {
		a = var1;
		b = var2;
		c = var3;
		d = (class_axk[]) var4.toArray(new class_axk[var4.size()]);
		e = var6;
		f = var7;
		g = var8;
		h = var9;
		i = new byte[var8 * var9];

		for (int var10 = 0; var10 < var8; ++var10) {
			for (int var11 = 0; var11 < var9; ++var11) {
				i[var10 + (var11 * var8)] = var5[var6 + var10 + ((var7 + var11) * 128)];
			}
		}

	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = var1.readByte();
		c = var1.readBoolean();
		d = new class_axk[var1.g()];

		for (int var2 = 0; var2 < d.length; ++var2) {
			short var3 = var1.readByte();
			d[var2] = new class_axk((byte) ((var3 >> 4) & 15), var1.readByte(), var1.readByte(), (byte) (var3 & 15));
		}

		g = var1.readUnsignedByte();
		if (g > 0) {
			h = var1.readUnsignedByte();
			e = var1.readUnsignedByte();
			f = var1.readUnsignedByte();
			i = var1.a();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.writeByte(b);
		var1.writeBoolean(c);
		var1.b(d.length);
		class_axk[] var2 = d;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_axk var5 = var2[var4];
			var1.writeByte(((var5.a() & 15) << 4) | (var5.d() & 15));
			var1.writeByte(var5.b());
			var1.writeByte(var5.c());
		}

		var1.writeByte(g);
		if (g > 0) {
			var1.writeByte(h);
			var1.writeByte(e);
			var1.writeByte(f);
			var1.a(i);
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
