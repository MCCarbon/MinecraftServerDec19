package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;

import com.mojang.authlib.GameProfile;

public class class_jn implements class_ff {
	private GameProfile a;

	public class_jn() {
	}

	public class_jn(GameProfile var1) {
		a = var1;
	}

	@Override
	public void a(PacketDataSerializer var1) throws IOException {
		a = new GameProfile((UUID) null, var1.c(16));
	}

	@Override
	public void b(PacketDataSerializer var1) throws IOException {
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
	public void a(class_ep var1) {
		this.a((class_jm) var1);
	}
}
