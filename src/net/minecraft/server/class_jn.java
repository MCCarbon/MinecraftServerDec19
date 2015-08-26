package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

import com.mojang.authlib.GameProfile;

public class class_jn implements Packet {
	private GameProfile a;

	public class_jn() {
	}

	public class_jn(GameProfile var1) {
		a = var1;
	}

	@Override
	public void decode(PacketDataSerializer var1) throws IOException {
		a = new GameProfile((UUID) null, var1.c(16));
	}

	@Override
	public void encode(PacketDataSerializer var1) throws IOException {
		var1.a(a.getName());
	}

	public void a(class_jm var1) {
		var1.a(this);
	}

	public GameProfile a() {
		return a;
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public void handle(PacketListener var1) {
		this.a((class_jm) var1);
	}
}
