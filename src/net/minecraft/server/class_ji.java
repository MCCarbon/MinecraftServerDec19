package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

import com.mojang.authlib.GameProfile;

public class class_ji implements Packet {
	private GameProfile a;

	public class_ji() {
	}

	public class_ji(GameProfile var1) {
		a = var1;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		String var2 = var1.c(36);
		String var3 = var1.c(16);
		UUID var4 = UUID.fromString(var2);
		a = new GameProfile(var4, var3);
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		UUID var2 = a.getId();
		var1.a(var2 == null ? "" : var2.toString());
		var1.a(a.getName());
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
