package net.minecraft.server;

import java.io.IOException;

public class class_iy implements Packet {
	private class_cj a;
	private IChatBaseComponent[] b;

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.e();
		b = new IChatBaseComponent[4];

		for (int var2 = 0; var2 < 4; ++var2) {
			String var3 = var1.c(384);
			IChatBaseComponent var4 = IChatBaseComponent.class_a_in_class_eu.a(var3);
			b[var2] = var4;
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a);

		for (int var2 = 0; var2 < 4; ++var2) {
			IChatBaseComponent var3 = b[var2];
			String var4 = IChatBaseComponent.class_a_in_class_eu.a(var3);
			var1.a(var4);
		}

	}

	public void a(class_id var1) {
		var1.a(this);
	}

	public class_cj a() {
		return a;
	}

	public IChatBaseComponent[] b() {
		return b;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_id) var1);
	}
}
