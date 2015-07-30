package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.EnumProtocol;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketHandshakingInListener;

public class PacketHandshakingInSetProtocol implements Packet<PacketHandshakingInListener> {

	private int protocolVersion;
	private String host;
	private int port;
	private EnumProtocol nextProtocol;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.protocolVersion = serializer.readVarInt();
		this.host = serializer.readString(255);
		this.port = serializer.readUnsignedShort();
		this.nextProtocol = EnumProtocol.getById(serializer.readVarInt());
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeVarInt(this.protocolVersion);
		serializer.writeString(this.host);
		serializer.writeShort(this.port);
		serializer.writeVarInt(this.nextProtocol.getId());
	}

	public void handle(PacketHandshakingInListener listener) {
		listener.handle(this);
	}

	public EnumProtocol getNextProtocol() {
		return this.nextProtocol;
	}

	public int getProtocolVersion() {
		return this.protocolVersion;
	}

}
