package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class class_ds extends class_eb {
	private int[] b;

	class_ds() {
	}

	public class_ds(int[] var1) {
		b = var1;
	}

	@Override
	void a(DataOutput var1) throws IOException {
		var1.writeInt(b.length);

		for (int var2 = 0; var2 < b.length; ++var2) {
			var1.writeInt(b[var2]);
		}

	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(192L);
		int var4 = var1.readInt();
		var3.a(32 * var4);
		b = new int[var4];

		for (int var5 = 0; var5 < var4; ++var5) {
			b[var5] = var1.readInt();
		}

	}

	@Override
	public byte a() {
		return (byte) 11;
	}

	@Override
	public String toString() {
		String var1 = "[";
		int[] var2 = b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var2[var4];
			var1 = var1 + var5 + ",";
		}

		return var1 + "]";
	}

	@Override
	public class_eb b() {
		int[] var1 = new int[b.length];
		System.arraycopy(b, 0, var1, 0, b.length);
		return new class_ds(var1);
	}

	@Override
	public boolean equals(Object var1) {
		return super.equals(var1) ? Arrays.equals(b, ((class_ds) var1).b) : false;
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ Arrays.hashCode(b);
	}

	public int[] c() {
		return b;
	}
}
