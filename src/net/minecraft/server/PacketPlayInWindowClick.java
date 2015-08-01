package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.ItemStack;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInWindowClick implements Packet<PacketListenerPlayIn> {

	private int windowId;
	private int slot;
	private int button;
	private short actionCounter;
	private ItemStack itemStack;
	private int mode;

	public void handle(PacketListenerPlayIn var1) {
		var1.handle(this);
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.windowId = serializer.readByte();
		this.slot = serializer.readShort();
		this.button = serializer.readByte();
		this.actionCounter = serializer.readShort();
		this.mode = serializer.readByte();
		this.itemStack = serializer.readItemStack();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeByte(this.windowId);
		serializer.writeShort(this.slot);
		serializer.writeByte(this.button);
		serializer.writeShort(this.actionCounter);
		serializer.writeByte(this.mode);
		serializer.writeItemStack(this.itemStack);
	}

	public int getWindowId() {
		return this.windowId;
	}

	public int getSlot() {
		return this.slot;
	}

	public int getButton() {
		return this.button;
	}

	public short getActionCounter() {
		return this.actionCounter;
	}

	public ItemStack getItemStack() {
		return this.itemStack;
	}

	public int getMode() {
		return this.mode;
	}

}
