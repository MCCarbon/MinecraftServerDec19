package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketLoginOutListener;

public class PacketLoginOutSuccess implements Packet<PacketLoginOutListener> {

	private GameProfile gameProfile;

	public PacketLoginOutSuccess() {
	}

	public PacketLoginOutSuccess(GameProfile gameProfile) {
		this.gameProfile = gameProfile;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		String uuid = serializer.readString(36);
		String name = serializer.readString(16);
		this.gameProfile = new GameProfile(UUID.fromString(uuid), name);
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		UUID uuid = this.gameProfile.getId();
		serializer.writeString(uuid == null ? "" : uuid.toString());
		serializer.writeString(this.gameProfile.getName());
	}

	public void handle(PacketLoginOutListener listener) {
		listener.handle(this);
	}

}
