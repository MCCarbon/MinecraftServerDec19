package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketLoginInListener;

public class PacketLoginInStart implements Packet<PacketLoginInListener> {

	private GameProfile gameProfile;

	public PacketLoginInStart() {
	}

	public PacketLoginInStart(GameProfile gameProfile) {
		this.gameProfile = gameProfile;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.gameProfile = new GameProfile(null, serializer.readString(16));
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeString(this.gameProfile.getName());
	}

	public void handle(PacketLoginInListener listener) {
		listener.handle(this);
	}

	public GameProfile getGameProfile() {
		return this.gameProfile;
	}

}
