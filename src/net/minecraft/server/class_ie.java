package net.minecraft.server;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class class_ie implements Packet {
	private String a;
	private boolean b;
	private class_cj c;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.c(32767);
		b = var1.readBoolean();
		boolean var2 = var1.readBoolean();
		if (var2) {
			c = var1.e();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(StringUtils.substring(a, 0, 32767));
		var1.writeBoolean(b);
		boolean var2 = c != null;
		var1.writeBoolean(var2);
		if (var2) {
			var1.a(c);
		}

	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public String a() {
		return a;
	}

	public class_cj b() {
		return c;
	}

	public boolean c() {
		return b;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
