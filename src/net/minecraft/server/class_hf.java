package net.minecraft.server;

import java.io.IOException;

public class class_hf implements class_ff {
	private int a;
	private class_ps b;
	private class_agr.class_a_in_class_agr c;
	private class_agt d;

	public class_hf() {
	}

	public class_hf(int var1, class_ps var2, class_agt var3, class_agr.class_a_in_class_agr var4) {
		a = var1;
		b = var2;
		c = var4;
		d = var3;
	}

	public void a(class_fj var1) {
		var1.a(this);
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = var1.readInt();
		b = class_ps.a(var1.readUnsignedByte());
		c = class_agr.class_a_in_class_agr.a(var1.readUnsignedByte());
		d = class_agt.a(var1.c(16));
		if (d == null) {
			d = class_agt.b;
		}

	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
		var1.writeInt(a);
		var1.writeByte(b.a());
		var1.writeByte(c.a());
		var1.a(d.a());
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void a(class_ep var1) {
		this.a((class_fj) var1);
	}
}
