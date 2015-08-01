package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.ItemStack;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInSetCreativeSlot implements Packet<PacketListenerPlayIn> {

	private int slot;
	private ItemStack itemStack;

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.slot = serializer.readShort();
		this.itemStack = serializer.readItemStack();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeShort(this.slot);
		serializer.writeItemStack(this.itemStack);
	}

	public int getSlot() {
		return this.slot;
	}

	public ItemStack getItemStack() {
		return this.itemStack;
	}

}
