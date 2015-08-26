package net.minecraft.server;

import java.io.IOException;

public class class_hx implements Packet {
	private class_ago a;
	private class_cj b;
	private IChatBaseComponent[] c;

	public class_hx() {
	}

	public class_hx(class_ago var1, class_cj var2, IChatBaseComponent[] var3) {
		a = var1;
		b = var2;
		c = new IChatBaseComponent[] { var3[0], var3[1], var3[2], var3[3] };
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		b = var1.e();
		c = new IChatBaseComponent[4];

		for (int var2 = 0; var2 < 4; ++var2) {
			c[var2] = var1.f();
		}

	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(b);

		for (int var2 = 0; var2 < 4; ++var2) {
			var1.a(c[var2]);
		}

	}

	public void a(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((PacketListenerPlayOut) var1);
	}
}
