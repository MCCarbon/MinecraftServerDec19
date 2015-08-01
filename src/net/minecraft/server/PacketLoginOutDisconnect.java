package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketLoginOutListener;

public class PacketLoginOutDisconnect implements Packet<PacketLoginOutListener> {

	private IChatBaseComponent message;

	public PacketLoginOutDisconnect() {
	}

	public PacketLoginOutDisconnect(IChatBaseComponent message) {
		this.message = message;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.message = serializer.readChat();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeChat(this.message);
	}

	public void handle(PacketLoginOutListener listener) {
		listener.handle(this);
	}

}
