package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

import com.google.common.collect.Lists;

public class class_c {
	private final class_b a;
	private final String b;
	private final List c = Lists.newArrayList();
	private StackTraceElement[] d = new StackTraceElement[0];

	public class_c(class_b var1, String var2) {
		a = var1;
		b = var2;
	}

	public static String a(double var0, double var2, double var4) {
		return String.format("%.2f,%.2f,%.2f - %s", new Object[] { Double.valueOf(var0), Double.valueOf(var2), Double.valueOf(var4), a(new class_cj(var0, var2, var4)) });
	}

	public static String a(class_cj var0) {
		int var1 = var0.n();
		int var2 = var0.o();
		int var3 = var0.p();
		StringBuilder var4 = new StringBuilder();

		try {
			var4.append(String.format("World: (%d,%d,%d)", new Object[] { Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3) }));
		} catch (Throwable var17) {
			var4.append("(Error finding world loc)");
		}

		var4.append(", ");

		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		try {
			var5 = var1 >> 4;
			var6 = var3 >> 4;
			var7 = var1 & 15;
			var8 = var2 >> 4;
			var9 = var3 & 15;
			var10 = var5 << 4;
			var11 = var6 << 4;
			var12 = ((var5 + 1) << 4) - 1;
			var13 = ((var6 + 1) << 4) - 1;
			var4.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", new Object[] { Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var9), Integer.valueOf(var5), Integer.valueOf(var6), Integer.valueOf(var10), Integer.valueOf(var11), Integer.valueOf(var12), Integer.valueOf(var13) }));
		} catch (Throwable var16) {
			var4.append("(Error finding chunk loc)");
		}

		var4.append(", ");

		try {
			var5 = var1 >> 9;
			var6 = var3 >> 9;
			var7 = var5 << 5;
			var8 = var6 << 5;
			var9 = ((var5 + 1) << 5) - 1;
			var10 = ((var6 + 1) << 5) - 1;
			var11 = var5 << 9;
			var12 = var6 << 9;
			var13 = ((var5 + 1) << 9) - 1;
			int var14 = ((var6 + 1) << 9) - 1;
			var4.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", new Object[] { Integer.valueOf(var5), Integer.valueOf(var6), Integer.valueOf(var7), Integer.valueOf(var8), Integer.valueOf(var9), Integer.valueOf(var10), Integer.valueOf(var11), Integer.valueOf(var12), Integer.valueOf(var13), Integer.valueOf(var14) }));
		} catch (Throwable var15) {
			var4.append("(Error finding world loc)");
		}

		return var4.toString();
	}

	public void a(String var1, Callable var2) {
		try {
			this.a(var1, var2.call());
		} catch (Throwable var4) {
			this.a(var1, var4);
		}

	}

	public void a(String var1, Object var2) {
		c.add(new class_c.class_a_in_class_c(var1, var2));
	}

	public void a(String var1, Throwable var2) {
		this.a(var1, (Object) var2);
	}

	public int a(int var1) {
		StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
		if (var2.length <= 0) {
			return 0;
		} else {
			d = new StackTraceElement[var2.length - 3 - var1];
			System.arraycopy(var2, 3 + var1, d, 0, d.length);
			return d.length;
		}
	}

	public boolean a(StackTraceElement var1, StackTraceElement var2) {
		if ((d.length != 0) && (var1 != null)) {
			StackTraceElement var3 = d[0];
			if ((var3.isNativeMethod() == var1.isNativeMethod()) && var3.getClassName().equals(var1.getClassName()) && var3.getFileName().equals(var1.getFileName()) && var3.getMethodName().equals(var1.getMethodName())) {
				if (var2 != null != (d.length > 1)) {
					return false;
				} else if ((var2 != null) && !d[1].equals(var2)) {
					return false;
				} else {
					d[0] = var1;
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void b(int var1) {
		StackTraceElement[] var2 = new StackTraceElement[d.length - var1];
		System.arraycopy(d, 0, var2, 0, var2.length);
		d = var2;
	}

	public void a(StringBuilder var1) {
		var1.append("-- ").append(b).append(" --\n");
		var1.append("Details:");
		Iterator var2 = c.iterator();

		while (var2.hasNext()) {
			class_c.class_a_in_class_c var3 = (class_c.class_a_in_class_c) var2.next();
			var1.append("\n\t");
			var1.append(var3.a());
			var1.append(": ");
			var1.append(var3.b());
		}

		if ((d != null) && (d.length > 0)) {
			var1.append("\nStacktrace:");
			StackTraceElement[] var6 = d;
			int var7 = var6.length;

			for (int var4 = 0; var4 < var7; ++var4) {
				StackTraceElement var5 = var6[var4];
				var1.append("\n\tat ");
				var1.append(var5.toString());
			}
		}

	}

	public StackTraceElement[] a() {
		return d;
	}

	public static void a(class_c var0, final class_cj var1, final class_ail var2, final int var3) {
		final int var4 = class_ail.a(var2);
		var0.a("Block type", new Callable() {
			public String a() throws Exception {
				try {
					return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(var4), var2.a(), var2.getClass().getCanonicalName() });
				} catch (Throwable var2x) {
					return "ID #" + var4;
				}
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var0.a("Block data value", new Callable() {
			public String a() throws Exception {
				if (var3 < 0) {
					return "Unknown? (Got " + var3 + ")";
				} else {
					String var1 = String.format("%4s", new Object[] { Integer.toBinaryString(var3) }).replace(" ", "0");
					return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(var3), var1 });
				}
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var0.a("Block location", new Callable() {
			public String a() throws Exception {
				return class_c.a(var1);
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
	}

	public static void a(class_c var0, final class_cj var1, final class_apn var2) {
		var0.a("Block", new Callable() {
			public String a() throws Exception {
				return var2.toString();
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
		var0.a("Block location", new Callable() {
			public String a() throws Exception {
				return class_c.a(var1);
			}

			// $FF: synthetic method
			@Override
			public Object call() throws Exception {
				return this.a();
			}
		});
	}

	static class class_a_in_class_c {
		private final String a;
		private final String b;

		public class_a_in_class_c(String var1, Object var2) {
			a = var1;
			if (var2 == null) {
				b = "~~NULL~~";
			} else if (var2 instanceof Throwable) {
				Throwable var3 = (Throwable) var2;
				b = "~~ERROR~~ " + var3.getClass().getSimpleName() + ": " + var3.getMessage();
			} else {
				b = var2.toString();
			}

		}

		public String a() {
			return a;
		}

		public String b() {
			return b;
		}
	}
}
