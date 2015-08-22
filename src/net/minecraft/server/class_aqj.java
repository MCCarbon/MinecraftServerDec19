package net.minecraft.server;


public class class_aqj implements class_aqq.class_a_in_class_aqq {
	private class_nl a = new class_nl(4, 4096);
	private class_aqq b = new class_aqq(this);

	@Override
	public class_aqj a(int var1) {
		class_nl var2 = a;
		int var3 = class_oa.c(var1);
		a = new class_nl(var3, 4096);

		for (int var4 = 0; var4 < 4096; ++var4) {
			a.a(var4, var2.a(var4));
		}

		return this;
	}

	private static int b(int var0, int var1, int var2) {
		return (var1 << 8) | (var2 << 4) | var0;
	}

	public void a(int var1, int var2, int var3, class_apn var4) {
		this.a(b(var1, var2, var3), var4);
	}

	private void a(int var1, class_apn var2) {
		int var3 = b.a(var2);
		a.a(var1, var3);
	}

	public class_apn a(int var1, int var2, int var3) {
		return this.b(b(var1, var2, var3));
	}

	private class_apn b(int var1) {
		return b.a(a.a(var1));
	}

	public void a(PacketDataSerializer var1) {
		b.a(var1);
		var1.b(a.c());
		var1.a(a.a());
	}

	public class_aql a(byte[] var1, class_aql var2) {
		class_aql var3 = null;

		for (int var4 = 0; var4 < 4096; ++var4) {
			int var5 = class_ail.d.a(this.b(var4));
			int var6 = var4 & 15;
			int var7 = (var4 >> 8) & 15;
			int var8 = (var4 >> 4) & 15;
			if (((var5 >> 12) & 15) != 0) {
				if (var3 == null) {
					var3 = new class_aql();
				}

				var3.a(var6, var7, var8, (var5 >> 12) & 15);
			}

			var1[var4] = (byte) ((var5 >> 4) & 255);
			var2.a(var6, var7, var8, var5 & 15);
		}

		return var3;
	}

	public void a(byte[] var1, class_aql var2, class_aql var3) {
		for (int var4 = 0; var4 < 4096; ++var4) {
			int var5 = var4 & 15;
			int var6 = (var4 >> 8) & 15;
			int var7 = (var4 >> 4) & 15;
			int var8 = var3 == null ? 0 : var3.a(var5, var6, var7);
			int var9 = (var8 << 12) | ((var1[var4] & 255) << 4) | var2.a(var5, var6, var7);
			this.a(var4, (class_apn) class_ail.d.a(var9));
		}

	}
}
