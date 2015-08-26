package net.minecraft.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_gl implements Packet {
	private double a;
	private double b;
	private double c;
	private float d;
	private List e;
	private float f;
	private float g;
	private float h;

	public class_gl() {
	}

	public class_gl(double var1, double var3, double var5, float var7, List var8, class_aym var9) {
		a = var1;
		b = var3;
		c = var5;
		d = var7;
		e = Lists.newArrayList((Iterable) var8);
		if (var9 != null) {
			f = (float) var9.a;
			g = (float) var9.b;
			h = (float) var9.c;
		}

	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.readFloat();
		b = var1.readFloat();
		c = var1.readFloat();
		d = var1.readFloat();
		int var2 = var1.readInt();
		e = Lists.newArrayListWithCapacity(var2);
		int var3 = (int) a;
		int var4 = (int) b;
		int var5 = (int) c;

		for (int var6 = 0; var6 < var2; ++var6) {
			int var7 = var1.readByte() + var3;
			int var8 = var1.readByte() + var4;
			int var9 = var1.readByte() + var5;
			e.add(new class_cj(var7, var8, var9));
		}

		f = var1.readFloat();
		g = var1.readFloat();
		h = var1.readFloat();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeFloat((float) a);
		var1.writeFloat((float) b);
		var1.writeFloat((float) c);
		var1.writeFloat(d);
		var1.writeInt(e.size());
		int var2 = (int) a;
		int var3 = (int) b;
		int var4 = (int) c;
		Iterator var5 = e.iterator();

		while (var5.hasNext()) {
			class_cj var6 = (class_cj) var5.next();
			int var7 = var6.n() - var2;
			int var8 = var6.o() - var3;
			int var9 = var6.p() - var4;
			var1.writeByte(var7);
			var1.writeByte(var8);
			var1.writeByte(var9);
		}

		var1.writeFloat(f);
		var1.writeFloat(g);
		var1.writeFloat(h);
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
