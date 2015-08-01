package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInEnchantItem implements Packet<PacketListenerPlayIn> {

	private int windowId;
	private int enchantment;

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.windowId = serializer.readByte();
		this.enchantment = serializer.readByte();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeByte(this.windowId);
		serializer.writeByte(this.enchantment);
	}

	public int getWindowId() {
		return this.windowId;
	}

	public int getEnchantment() {
		return this.enchantment;
	}

}
