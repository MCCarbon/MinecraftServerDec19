package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutKeepAlive implements Packet<PacketListenerPlayOut> {

	private int keepAliveId;

	public PacketPlayOutKeepAlive() {
	}

	public PacketPlayOutKeepAlive(int keepAliveId) {
		this.keepAliveId = keepAliveId;
	}

	public void handle(PacketListenerPlayOut listener) {
		listener.a(this);
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.keepAliveId = serializer.readVarInt();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeVarInt(this.keepAliveId);
	}

}
