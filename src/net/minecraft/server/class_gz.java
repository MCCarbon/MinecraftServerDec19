package net.minecraft.server;

import java.io.IOException;

public class class_gz implements Packet {
	public class_gz.class_a_in_class_gz a;
	public int b;
	public int c;
	public int d;
	public IChatBaseComponent e;

	public class_gz() {
	}

	public class_gz(class_qh var1, class_gz.class_a_in_class_gz var2) {
		a = var2;
		class_rg var3 = var1.c();
		switch (class_gz.SyntheticClass_1.a[var2.ordinal()]) {
			case 1:
				d = var1.f();
				c = var3 == null ? -1 : var3.G();
				break;
			case 2:
				b = var1.h().G();
				c = var3 == null ? -1 : var3.G();
				e = var1.b();
		}

	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = (class_gz.class_a_in_class_gz) var1.a(class_gz.class_a_in_class_gz.class);
		if (a == class_gz.class_a_in_class_gz.b) {
			d = var1.g();
			c = var1.readInt();
		} else if (a == class_gz.class_a_in_class_gz.c) {
			b = var1.g();
			c = var1.readInt();
			e = var1.f();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		if (a == class_gz.class_a_in_class_gz.b) {
			var1.b(d);
			var1.writeInt(c);
		} else if (a == class_gz.class_a_in_class_gz.c) {
			var1.b(b);
			var1.writeInt(c);
			var1.a(e);
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

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_gz.class_a_in_class_gz.values().length];

		static {
			try {
				a[class_gz.class_a_in_class_gz.b.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_gz.class_a_in_class_gz.c.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_gz {
		a,
		b,
		c;
	}
}
