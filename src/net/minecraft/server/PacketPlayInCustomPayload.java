package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInCustomPayload implements Packet<PacketListenerPlayIn> {

	private String tag;
	private PacketDataSerializer data;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.tag = serializer.readString(20);
		int length = serializer.readableBytes();
		if (length >= 0 && length <= 32767) {
			this.data = new PacketDataSerializer(serializer.readBytes(length));
		} else {
			throw new IOException("Payload may not be larger than 32767 bytes");
		}
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeString(this.tag);
		serializer.writeBytes(this.data);
	}

	public void handle(PacketListenerPlayIn var1) {
		var1.handle(this);
	}

	public String getTag() {
		return this.tag;
	}

	public PacketDataSerializer getData() {
		return this.data;
	}

}
