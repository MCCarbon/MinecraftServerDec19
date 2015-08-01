package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInResourcePackStatus implements Packet<PacketListenerPlayIn> {

	private String hash;
	private EnumResourcePackStatus status;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.hash = serializer.readString(40);
		this.status = serializer.readEnum(EnumResourcePackStatus.class);
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeString(this.hash);
		serializer.writeEnum(this.status);
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public static enum EnumResourcePackStatus {
		SUCCESSFULLY_LOADED, DECLINED, FAILED_DOWNLOAD, ACCEPTED;
	}

}
