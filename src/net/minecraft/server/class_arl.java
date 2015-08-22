package net.minecraft.server;


public class class_arl {
	private final short[] a = new short[65536];
	private final class_apn b;

	public class_arl() {
		b = Blocks.a.S();
	}

	public class_apn a(int var1, int var2, int var3) {
		int var4 = (var1 << 12) | (var3 << 8) | var2;
		return this.a(var4);
	}

	public class_apn a(int var1) {
		if ((var1 >= 0) && (var1 < a.length)) {
			class_apn var2 = (class_apn) Block.d.a(a[var1]);
			return var2 != null ? var2 : b;
		} else {
			throw new IndexOutOfBoundsException("The coordinate is out of range");
		}
	}

	public void a(int var1, int var2, int var3, class_apn var4) {
		int var5 = (var1 << 12) | (var3 << 8) | var2;
		this.a(var5, var4);
	}

	public void a(int var1, class_apn var2) {
		if ((var1 >= 0) && (var1 < a.length)) {
			a[var1] = (short) Block.d.a(var2);
		} else {
			throw new IndexOutOfBoundsException("The coordinate is out of range");
		}
	}

	public int a(int var1, int var2) {
		int var3 = (((var1 << 12) | (var2 << 8)) + 256) - 1;

		for (int var4 = 255; var4 >= 0; --var4) {
			class_apn var5 = (class_apn) Block.d.a(a[var3 + var4]);
			if ((var5 != null) && (var5 != b)) {
				return var4;
			}
		}

		return 0;
	}
}
