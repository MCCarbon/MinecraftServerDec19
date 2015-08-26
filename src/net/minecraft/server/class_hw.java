package net.minecraft.server;

import java.io.IOException;

public class class_hw implements Packet {
	private class_hw.class_a_in_class_hw a;
	private IChatBaseComponent b;
	private int c;
	private int d;
	private int e;

	public class_hw() {
	}

	public class_hw(class_hw.class_a_in_class_hw var1, IChatBaseComponent var2) {
		this(var1, var2, -1, -1, -1);
	}

	public class_hw(int var1, int var2, int var3) {
		this(class_hw.class_a_in_class_hw.c, (IChatBaseComponent) null, var1, var2, var3);
	}

	public class_hw(class_hw.class_a_in_class_hw var1, IChatBaseComponent var2, int var3, int var4, int var5) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
		e = var5;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = (class_hw.class_a_in_class_hw) var1.a(class_hw.class_a_in_class_hw.class);
		if ((a == class_hw.class_a_in_class_hw.a) || (a == class_hw.class_a_in_class_hw.b)) {
			b = var1.f();
		}

		if (a == class_hw.class_a_in_class_hw.c) {
			c = var1.readInt();
			d = var1.readInt();
			e = var1.readInt();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		if ((a == class_hw.class_a_in_class_hw.a) || (a == class_hw.class_a_in_class_hw.b)) {
			var1.a(b);
		}

		if (a == class_hw.class_a_in_class_hw.c) {
			var1.writeInt(c);
			var1.writeInt(d);
			var1.writeInt(e);
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

	public static enum class_a_in_class_hw {
		a,
		b,
		c,
		d,
		e;

		public static class_hw.class_a_in_class_hw a(String var0) {
			class_hw.class_a_in_class_hw[] var1 = values();
			int var2 = var1.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				class_hw.class_a_in_class_hw var4 = var1[var3];
				if (var4.name().equalsIgnoreCase(var0)) {
					return var4;
				}
			}

			return a;
		}

		public static String[] a() {
			String[] var0 = new String[values().length];
			int var1 = 0;
			class_hw.class_a_in_class_hw[] var2 = values();
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				class_hw.class_a_in_class_hw var5 = var2[var4];
				var0[var1++] = var5.name().toLowerCase();
			}

			return var0;
		}
	}
}
