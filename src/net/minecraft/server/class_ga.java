package net.minecraft.server;

import java.io.IOException;

public class class_ga implements class_ff {
	private class_agi a;
	private class_ga.class_a_in_class_ga[] b;

	public class_ga() {
	}

	public class_ga(int var1, short[] var2, class_aqn var3) {
		a = new class_agi(var3.b, var3.c);
		b = new class_ga.class_a_in_class_ga[var1];

		for (int var4 = 0; var4 < b.length; ++var4) {
			b[var4] = new class_ga.class_a_in_class_ga(var2[var4], var3);
		}

	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = new class_agi(var1.readInt(), var1.readInt());
		b = new class_ga.class_a_in_class_ga[var1.g()];

		for (int var2 = 0; var2 < b.length; ++var2) {
			b[var2] = new class_ga.class_a_in_class_ga(var1.readShort(), (class_apn) Block.d.a(var1.g()));
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeInt(a.a);
		var1.writeInt(a.b);
		var1.b(b.length);
		class_ga.class_a_in_class_ga[] var2 = b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_ga.class_a_in_class_ga var5 = var2[var4];
			var1.writeShort(var5.b());
			var1.b(Block.d.a(var5.c()));
		}

	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}

	public class class_a_in_class_ga {
		private final short b;
		private final class_apn c;

		public class_a_in_class_ga(short var2, class_apn var3) {
			b = var2;
			c = var3;
		}

		public class_a_in_class_ga(short var2, class_aqn var3) {
			b = var2;
			c = var3.g(this.a());
		}

		public class_cj a() {
			return new class_cj(a.a((b >> 12) & 15, b & 255, (b >> 8) & 15));
		}

		public short b() {
			return b;
		}

		public class_apn c() {
			return c;
		}
	}
}
