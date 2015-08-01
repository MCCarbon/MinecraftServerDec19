package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketStatusInListener;

public class PacketStatusInPing implements Packet<PacketStatusInListener> {

	private long timestamp;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.timestamp = serializer.readLong();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeLong(this.timestamp);
	}

	public void handle(PacketStatusInListener listener) {
		listener.handle(this);
	}

	public long getTimeStamp() {
		return this.timestamp;
	}

}
