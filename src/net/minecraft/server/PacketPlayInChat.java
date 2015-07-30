package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInChat implements Packet<PacketListenerPlayIn> {

	private String message;

	public PacketPlayInChat() {
	}

	public PacketPlayInChat(String message) {
		if (message.length() > 100) {
			message = message.substring(0, 100);
		}
		this.message = message;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.message = serializer.readString(100);
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeString(this.message);
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public String getMessage() {
		return this.message;
	}

}
