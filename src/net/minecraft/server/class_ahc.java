package net.minecraft.server;

import java.util.List;

import com.google.common.collect.Lists;

public class class_ahc {
	private final class_ahf a;
	private long b;
	private class_ny c = new class_ny();
	private List d = Lists.newArrayList();

	public class_ahc(class_ahf var1) {
		a = var1;
	}

	public class_ahc.class_a_in_class_ahc a(int var1, int var2) {
		var1 >>= 4;
		var2 >>= 4;
		long var3 = (var1 & 4294967295L) | ((var2 & 4294967295L) << 32);
		class_ahc.class_a_in_class_ahc var5 = (class_ahc.class_a_in_class_ahc) c.a(var3);
		if (var5 == null) {
			var5 = new class_ahc.class_a_in_class_ahc(var1, var2);
			c.a(var3, var5);
			d.add(var5);
		}

		var5.e = MinecraftServer.aB();
		return var5;
	}

	public class_ahb a(int var1, int var2, class_ahb var3) {
		class_ahb var4 = this.a(var1, var2).a(var1, var2);
		return var4 == null ? var3 : var4;
	}

	public void a() {
		long var1 = MinecraftServer.aB();
		long var3 = var1 - b;
		if ((var3 > 7500L) || (var3 < 0L)) {
			b = var1;

			for (int var5 = 0; var5 < d.size(); ++var5) {
				class_ahc.class_a_in_class_ahc var6 = (class_ahc.class_a_in_class_ahc) d.get(var5);
				long var7 = var1 - var6.e;
				if ((var7 > 30000L) || (var7 < 0L)) {
					d.remove(var5--);
					long var9 = (var6.c & 4294967295L) | ((var6.d & 4294967295L) << 32);
					c.d(var9);
				}
			}
		}

	}

	public class_ahb[] c(int var1, int var2) {
		return this.a(var1, var2).b;
	}

	public class class_a_in_class_ahc {
		public float[] a = new float[256];
		public class_ahb[] b = new class_ahb[256];
		public int c;
		public int d;
		public long e;

		public class_a_in_class_ahc(int var2, int var3) {
			c = var2;
			d = var3;
			class_ahc.this.a.a(a, var2 << 4, var3 << 4, 16, 16);
			class_ahc.this.a.a(b, var2 << 4, var3 << 4, 16, 16, false);
		}

		public class_ahb a(int var1, int var2) {
			return b[(var1 & 15) | ((var2 & 15) << 4)];
		}
	}
}
