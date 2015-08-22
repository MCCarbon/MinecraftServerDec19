package net.minecraft.server;

import java.io.IOException;
import java.security.PrivateKey;

import javax.crypto.SecretKey;

public class class_jo implements class_ff {
	private byte[] a = new byte[0];
	private byte[] b = new byte[0];

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.a();
		b = var1.a();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.a(b);
	}

	public void a(class_jm var1) {
		var1.a(this);
	}

	public SecretKey a(PrivateKey var1) {
		return class_no.a(var1, a);
	}

	public byte[] b(PrivateKey var1) {
		return var1 == null ? b : class_no.b(var1, b);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_jm) var1);
	}
}
