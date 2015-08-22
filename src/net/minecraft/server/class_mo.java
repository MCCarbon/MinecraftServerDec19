package net.minecraft.server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class class_mo {
	private ByteArrayOutputStream a;
	private DataOutputStream b;

	public class_mo(int var1) {
		a = new ByteArrayOutputStream(var1);
		b = new DataOutputStream(a);
	}

	public void a(byte[] var1) throws IOException {
		b.write(var1, 0, var1.length);
	}

	public void a(String var1) throws IOException {
		b.writeBytes(var1);
		b.write(0);
	}

	public void a(int var1) throws IOException {
		b.write(var1);
	}

	public void a(short var1) throws IOException {
		b.writeShort(Short.reverseBytes(var1));
	}

	public byte[] a() {
		return a.toByteArray();
	}

	public void b() {
		a.reset();
	}
}
