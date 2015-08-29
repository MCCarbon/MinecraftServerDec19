package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutEntityEquipment implements Packet {
	private int a;
	private class_rc b;
	private class_aco c;

	public PacketPlayOutEntityEquipment() {
	}

	public PacketPlayOutEntityEquipment(int var1, class_rc var2, class_aco var3) {
		a = var1;
		b = var2;
		c = var3 == null ? null : var3.k();
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = var1.g();
		b = (class_rc) var1.a(class_rc.class);
		c = var1.k();
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.b(a);
		var1.a(b);
		var1.a(c);
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
