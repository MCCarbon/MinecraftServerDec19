package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class class_ea extends class_eb {
	private String b;

	public class_ea() {
		b = "";
	}

	public class_ea(String var1) {
		b = var1;
		if (var1 == null) {
			throw new IllegalArgumentException("Empty string not allowed");
		}
	}

	@Override
	void a(DataOutput var1) throws IOException {
		var1.writeUTF(b);
	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(288L);
		b = var1.readUTF();
		var3.a(16 * b.length());
	}

	@Override
	public byte a() {
		return (byte) 8;
	}

	@Override
	public String toString() {
		return "\"" + b.replace("\"", "\\\"") + "\"";
	}

	@Override
	public class_eb b() {
		return new class_ea(b);
	}

	@Override
	public boolean c_() {
		return b.isEmpty();
	}

	@Override
	public boolean equals(Object var1) {
		if (!super.equals(var1)) {
			return false;
		} else {
			class_ea var2 = (class_ea) var1;
			return ((b == null) && (var2.b == null)) || ((b != null) && b.equals(var2.b));
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ b.hashCode();
	}

	@Override
	public String a_() {
		return b;
	}
}
