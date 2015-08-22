package net.minecraft.server;

import java.io.IOException;

public class class_gr implements class_ff {
	private int a;
	private class_cj b;
	private int c;
	private boolean d;

	public class_gr() {
	}

	public class_gr(int var1, class_cj var2, int var3, boolean var4) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readInt();
		b = var1.e();
		c = var1.readInt();
		d = var1.readBoolean();
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeInt(a);
		var1.a(b);
		var1.writeInt(c);
		var1.writeBoolean(d);
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
