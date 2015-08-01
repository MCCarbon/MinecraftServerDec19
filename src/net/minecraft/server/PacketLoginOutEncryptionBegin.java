package net.minecraft.server;

import java.io.IOException;
import java.security.PublicKey;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketLoginOutListener;
import net.minecraft.server.MinecraftEncryption;

public class PacketLoginOutEncryptionBegin implements Packet<PacketLoginOutListener> {

	private String serverId;
	private PublicKey key;
	private byte[] verifyToken;

	public PacketLoginOutEncryptionBegin() {
	}

	public PacketLoginOutEncryptionBegin(String serverId, PublicKey key, byte[] verifyToken) {
		this.serverId = serverId;
		this.key = key;
		this.verifyToken = verifyToken;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.serverId = serializer.readString(20);
		this.key = MinecraftEncryption.generatePublicKey(serializer.readArray());
		this.verifyToken = serializer.readArray();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeString(this.serverId);
		serializer.writeArray(this.key.getEncoded());
		serializer.writeArray(this.verifyToken);
	}

	public void handle(PacketLoginOutListener listener) {
		listener.handle(this);
	}

}
