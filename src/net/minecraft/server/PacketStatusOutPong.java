package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketStatusOutListener;

public class PacketStatusOutPong implements Packet<PacketStatusOutListener> {

	private long timestamp;

	public PacketStatusOutPong() {
	}

	public PacketStatusOutPong(long timestamp) {
		this.timestamp = timestamp;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.timestamp = serializer.readLong();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeLong(this.timestamp);
	}

	public void handle(PacketStatusOutListener listener) {
		listener.handle(this);
	}

}
