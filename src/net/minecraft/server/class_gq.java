package net.minecraft.server;

import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.util.List;

public class class_gq implements Packet {
	private int[] a;
	private int[] b;
	private int[] c;
	private boolean d;
	private PacketDataSerializer e;

	public class_gq() {
	}

	public class_gq(List var1) {
		int var2 = var1.size();
		a = new int[var2];
		b = new int[var2];
		c = new int[var2];
		d = !((class_aqn) var1.get(0)).q().t.m();
		e = a(var2);

		for (int var3 = 0; var3 < var2; ++var3) {
			class_aqn var4 = (class_aqn) var1.get(var3);
			a[var3] = var4.b;
			b[var3] = var4.c;
			c[var3] = class_gp.a(e, var4, true, d, '\uffff');
		}

	}

	public static PacketDataSerializer a(int var0) {
		int var1 = class_gp.a(Integer.bitCount('\uffff'), true, true);
		return new PacketDataSerializer(Unpooled.buffer(var0 * var1, var0 * var1));
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		d = var1.readBoolean();
		a = var1.b();
		b = var1.b();
		c = var1.b();
		e = a(c.length);
		int var2 = var1.g();
		var1.readBytes(e, var2);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeBoolean(d);
		var1.a(a);
		var1.a(b);
		var1.a(c);
		var1.b(e.readableBytes());
		var1.writeBytes(e);
		e.release();
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
