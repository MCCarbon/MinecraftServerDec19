package net.minecraft.server;

import java.io.IOException;
import java.security.PrivateKey;
import javax.crypto.SecretKey;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketLoginInListener;
import net.minecraft.server.MinecraftEncryption;

public class PacketLoginInEncryptionBegin implements Packet<PacketLoginInListener> {

	private byte[] sharedSecret = new byte[0];
	private byte[] verifyToken = new byte[0];

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.sharedSecret = serializer.readArray();
		this.verifyToken = serializer.readArray();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeArray(this.sharedSecret);
		serializer.writeArray(this.verifyToken);
	}

	public void handle(PacketLoginInListener listener) {
		listener.handle(this);
	}

	public SecretKey getSecreyKey(PrivateKey privateKey) {
		return MinecraftEncryption.getSecretKey(privateKey, this.sharedSecret);
	}

	public byte[] getVerifyToken(PrivateKey privateKey) {
		return privateKey == null ? this.verifyToken : MinecraftEncryption.decrypt(privateKey, this.verifyToken);
	}

}
