package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketLoginOutListener;

public class PacketLoginOutSetCompression implements Packet<PacketLoginOutListener> {

	private int threshold;

	public PacketLoginOutSetCompression() {
	}

	public PacketLoginOutSetCompression(int threshold) {
		this.threshold = threshold;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.threshold = serializer.readVarInt();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeVarInt(this.threshold);
	}

	public void handle(PacketLoginOutListener listener) {
		listener.handle(this);
	}

}
