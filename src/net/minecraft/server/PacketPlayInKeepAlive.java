package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInKeepAlive implements Packet<PacketListenerPlayIn> {

	private int keepAliveId;

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.keepAliveId = serializer.readVarInt();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeVarInt(this.keepAliveId);
	}

	public int getKeepAliveId() {
		return this.keepAliveId;
	}

}
