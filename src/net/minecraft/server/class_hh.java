package net.minecraft.server;

import java.io.IOException;

public class class_hh implements Packet {
	private class_hh.class_a_in_class_hh a;
	private int b;
	private double c;
	private double d;
	private double e;
	private double f;
	private long g;
	private int h;
	private int i;

	public class_hh() {
	}

	public class_hh(class_aqg var1, class_hh.class_a_in_class_hh var2) {
		a = var2;
		c = var1.f();
		d = var1.g();
		f = var1.h();
		e = var1.j();
		g = var1.i();
		b = var1.l();
		i = var1.q();
		h = var1.p();
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = (class_hh.class_a_in_class_hh) var1.a(class_hh.class_a_in_class_hh.class);
		switch (class_hh.SyntheticClass_1.a[a.ordinal()]) {
			case 1:
				e = var1.readDouble();
				break;
			case 2:
				f = var1.readDouble();
				e = var1.readDouble();
				g = var1.h();
				break;
			case 3:
				c = var1.readDouble();
				d = var1.readDouble();
				break;
			case 4:
				i = var1.g();
				break;
			case 5:
				h = var1.g();
				break;
			case 6:
				c = var1.readDouble();
				d = var1.readDouble();
				f = var1.readDouble();
				e = var1.readDouble();
				g = var1.h();
				b = var1.g();
				i = var1.g();
				h = var1.g();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		switch (class_hh.SyntheticClass_1.a[a.ordinal()]) {
			case 1:
				var1.writeDouble(e);
				break;
			case 2:
				var1.writeDouble(f);
				var1.writeDouble(e);
				var1.b(g);
				break;
			case 3:
				var1.writeDouble(c);
				var1.writeDouble(d);
				break;
			case 4:
				var1.b(i);
				break;
			case 5:
				var1.b(h);
				break;
			case 6:
				var1.writeDouble(c);
				var1.writeDouble(d);
				var1.writeDouble(f);
				var1.writeDouble(e);
				var1.b(g);
				var1.b(b);
				var1.b(i);
				var1.b(h);
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
		static final int[] a = new int[class_hh.class_a_in_class_hh.values().length];

		static {
			try {
				a[class_hh.class_a_in_class_hh.a.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_hh.class_a_in_class_hh.b.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_hh.class_a_in_class_hh.c.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_hh.class_a_in_class_hh.f.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_hh.class_a_in_class_hh.e.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_hh.class_a_in_class_hh.d.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_hh {
		a,
		b,
		c,
		d,
		e,
		f;
	}
}
