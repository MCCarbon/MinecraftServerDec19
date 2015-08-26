package net.minecraft.server;

import java.io.IOException;
import java.security.PublicKey;

public class class_jj implements Packet {
	private String a;
	private PublicKey b;
	private byte[] c;

	public class_jj() {
	}

	public class_jj(String var1, PublicKey var2, byte[] var3) {
		a = var1;
		b = var2;
		c = var3;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.c(20);
		b = class_no.a(var1.a());
		c = var1.a();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);
		var1.a(b.getEncoded());
		var1.a(c);
	}

	public void a(class_jh var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_jh) var1);
	}
}
