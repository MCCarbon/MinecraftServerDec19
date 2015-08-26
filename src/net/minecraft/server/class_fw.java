package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

public class class_fw implements Packet {
	private UUID a;
	private class_fw.class_a_in_class_fw b;
	private IChatBaseComponent c;
	private float d;
	private class_pn.class_a_in_class_pn e;
	private class_pn.class_b_in_class_pn f;
	private boolean g;
	private boolean h;

	public class_fw() {
	}

	public class_fw(class_fw.class_a_in_class_fw var1, class_pn var2) {
		b = var1;
		a = var2.d();
		c = var2.e();
		d = var2.f();
		e = var2.g();
		f = var2.h();
		g = var2.i();
		h = var2.j();
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.i();
		b = (class_fw.class_a_in_class_fw) var1.a(class_fw.class_a_in_class_fw.class);
		switch (class_fw.SyntheticClass_1.a[b.ordinal()]) {
			case 1:
				c = var1.f();
				d = var1.readFloat();
				e = (class_pn.class_a_in_class_pn) var1.a(class_pn.class_a_in_class_pn.class);
				f = (class_pn.class_b_in_class_pn) var1.a(class_pn.class_b_in_class_pn.class);
				this.a(var1.readUnsignedByte());
			case 2:
			default:
				break;
			case 3:
				d = var1.readFloat();
				break;
			case 4:
				c = var1.f();
				break;
			case 5:
				e = (class_pn.class_a_in_class_pn) var1.a(class_pn.class_a_in_class_pn.class);
				f = (class_pn.class_b_in_class_pn) var1.a(class_pn.class_b_in_class_pn.class);
				break;
			case 6:
				this.a(var1.readUnsignedByte());
		}

	}

	private void a(int var1) {
		g = (var1 & 1) > 0;
		h = (var1 & 2) > 0;
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.a(b);
		switch (class_fw.SyntheticClass_1.a[b.ordinal()]) {
			case 1:
				var1.a(c);
				var1.writeFloat(d);
				var1.a(e);
				var1.a(f);
				var1.writeByte(i());
			case 2:
			default:
				break;
			case 3:
				var1.writeFloat(d);
				break;
			case 4:
				var1.a(c);
				break;
			case 5:
				var1.a(e);
				var1.a(f);
				break;
			case 6:
				var1.writeByte(i());
		}

	}

	private int i() {
		int var1 = 0;
		if (g) {
			var1 |= 1;
		}

		if (h) {
			var1 |= 2;
		}

		return var1;
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
		static final int[] a = new int[class_fw.class_a_in_class_fw.values().length];

		static {
			try {
				a[class_fw.class_a_in_class_fw.a.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_fw.class_a_in_class_fw.b.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_fw.class_a_in_class_fw.c.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_fw.class_a_in_class_fw.d.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_fw.class_a_in_class_fw.e.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_fw.class_a_in_class_fw.f.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_fw {
		a,
		b,
		c,
		d,
		e,
		f;
	}
}
