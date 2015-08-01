package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInCloseWindow implements Packet<PacketListenerPlayIn> {

	private int windowId;

	public void handle(PacketListenerPlayIn listner) {
		listner.handle(this);
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.windowId = serializer.readByte();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeByte(this.windowId);
	}

}
