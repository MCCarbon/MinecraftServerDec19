package net.minecraft.server;

import java.io.IOException;

public class class_gd implements class_ff {
	private int a;
	private String b;
	private class_eu c;
	private int d;
	private int e;

	public class_gd() {
	}

	public class_gd(int var1, String var2, class_eu var3) {
		this(var1, var2, var3, 0);
	}

	public class_gd(int var1, String var2, class_eu var3, int var4) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
	}

	public class_gd(int var1, String var2, class_eu var3, int var4, int var5) {
		this(var1, var2, var3, var4);
		e = var5;
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readUnsignedByte();
		b = var1.c(32);
		c = var1.f();
		d = var1.readUnsignedByte();
		if (b.equals("EntityHorse")) {
			e = var1.readInt();
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeByte(a);
		var1.a(b);
		var1.a(c);
		var1.writeByte(d);
		if (b.equals("EntityHorse")) {
			var1.writeInt(e);
		}

	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
