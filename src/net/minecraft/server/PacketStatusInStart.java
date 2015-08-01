package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketStatusInListener;

public class PacketStatusInStart implements Packet<PacketStatusInListener> {

	public void decode(PacketDataSerializer serializer) throws IOException {
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
	}

	public void handle(PacketStatusInListener listener) {
		listener.handle(this);
	}

}
