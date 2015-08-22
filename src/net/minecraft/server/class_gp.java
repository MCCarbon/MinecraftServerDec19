package net.minecraft.server;

import java.io.IOException;

public class class_gp implements class_ff {
	private int a;
	private int b;
	private int c;
	private PacketDataSerializer d;
	private boolean e;

	public class_gp() {
	}

	public class_gp(class_aqn var1, boolean var2, int var3) {
		a = var1.b;
		b = var1.c;
		e = var2;
		d = class_gq.a(1);
		c = a(d, var1, var2, !var1.q().t.m(), var3);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readInt();
		b = var1.readInt();
		e = var1.readBoolean();
		c = var1.readInt();
		d = class_gq.a(1);
		int var2 = var1.g();
		var1.readBytes(d, var2);
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeInt(a);
		var1.writeInt(b);
		var1.writeBoolean(e);
		var1.writeInt(c);
		var1.b(d.readableBytes());
		var1.writeBytes(d);
		d.release();
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	protected static int a(int var0, boolean var1, boolean var2) {
		boolean var3 = true;
		boolean var4 = true;
		int var5 = (var0 * 3 * 4096) / 2;
		int var6 = var0 * 2 * 3 * 4096;
		int var7 = (var0 * 4096) / 2;
		int var8 = var1 ? (var0 * 4096) / 2 : 0;
		int var9 = var2 ? 256 : 0;
		return var6 + var5 + var7 + var8 + var9;
	}

	public static int a(PacketDataSerializer var0, class_aqn var1, boolean var2, boolean var3, int var4) {
		int var5 = 0;
		class_aqo[] var6 = var1.h();
		int var7 = 0;

		for (int var8 = var6.length; var7 < var8; ++var7) {
			class_aqo var9 = var6[var7];
			if ((var9 != class_aqn.a) && (!var2 || !var9.a()) && ((var4 & (1 << var7)) != 0)) {
				var5 |= 1 << var7;
				var9.g().a(var0);
				var0.writeBytes(var9.h().a());
				if (var3) {
					var0.writeBytes(var9.i().a());
				}
			}
		}

		if (var2) {
			var0.writeBytes(var1.l());
		}

		return var5;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
