package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInTransaction implements Packet<PacketListenerPlayIn> {

	private int windowId;
	private short actionNumber;
	private boolean isAccepted;

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.windowId = serializer.readByte();
		this.actionNumber = serializer.readShort();
		this.isAccepted = serializer.readByte() != 0;
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeByte(this.windowId);
		serializer.writeShort(this.actionNumber);
		serializer.writeByte(this.isAccepted ? 1 : 0);
	}

	public int getWindowId() {
		return this.windowId;
	}

	public short getActionNumber() {
		return this.actionNumber;
	}

}
