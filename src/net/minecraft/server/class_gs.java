package net.minecraft.server;

import java.io.IOException;

public class class_gs implements Packet {
	private class_cy a;
	private float b;
	private float c;
	private float d;
	private float e;
	private float f;
	private float g;
	private float h;
	private int i;
	private boolean j;
	private int[] k;

	public class_gs() {
	}

	public class_gs(class_cy var1, boolean var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, int... var11) {
		a = var1;
		j = var2;
		b = var3;
		c = var4;
		d = var5;
		e = var6;
		f = var7;
		g = var8;
		h = var9;
		i = var10;
		k = var11;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = class_cy.a(var1.readInt());
		if (a == null) {
			a = class_cy.J;
		}

		j = var1.readBoolean();
		b = var1.readFloat();
		c = var1.readFloat();
		d = var1.readFloat();
		e = var1.readFloat();
		f = var1.readFloat();
		g = var1.readFloat();
		h = var1.readFloat();
		i = var1.readInt();
		int var2 = a.d();
		k = new int[var2];

		for (int var3 = 0; var3 < var2; ++var3) {
			k[var3] = var1.g();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeInt(a.c());
		var1.writeBoolean(j);
		var1.writeFloat(b);
		var1.writeFloat(c);
		var1.writeFloat(d);
		var1.writeFloat(e);
		var1.writeFloat(f);
		var1.writeFloat(g);
		var1.writeFloat(h);
		var1.writeInt(i);
		int var2 = a.d();

		for (int var3 = 0; var3 < var2; ++var3) {
			var1.b(k[var3]);
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
