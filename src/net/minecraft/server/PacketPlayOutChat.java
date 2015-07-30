package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutChat implements Packet<PacketListenerPlayOut> {

	private IChatBaseComponent message;
	private byte type;

	public PacketPlayOutChat() {
	}

	public PacketPlayOutChat(IChatBaseComponent message) {
		this(message, (byte) 1);
	}

	public PacketPlayOutChat(IChatBaseComponent message, byte type) {
		this.message = message;
		this.type = type;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.message = serializer.readChat();
		this.type = serializer.readByte();
	}

	public void encode(PacketDataSerializer message) throws IOException {
		message.writeChat(this.message);
		message.writeByte(this.type);
	}

	public void handle(PacketListenerPlayOut var1) {
		var1.a(this);
	}

	public boolean b() {
		return this.type == 1 || this.type == 2;
	}

}
