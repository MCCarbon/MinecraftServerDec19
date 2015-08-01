package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInHeldItemSlot implements Packet<PacketListenerPlayIn> {

	private int slot;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.slot = serializer.readShort();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeShort(this.slot);
	}

	public void handle(PacketListenerPlayIn serializer) {
		serializer.handle(this);
	}

	public int getSlot() {
		return this.slot;
	}

}
