package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInBlockDig implements Packet<PacketListenerPlayIn> {

	private BlockPosition position;
	private EnumDirection face;
	private PacketPlayInBlockDig.EnumPlayerDigType digType;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.digType = serializer.readEnum(EnumPlayerDigType.class);
		this.position = serializer.readBlockPosition();
		this.face = EnumDirection.getById(serializer.readUnsignedByte());
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeEnum(this.digType);
		serializer.writeBlockPosition(this.position);
		serializer.writeByte(this.face.getId());
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public BlockPosition getPosition() {
		return this.position;
	}

	public EnumDirection getFace() {
		return this.face;
	}

	public PacketPlayInBlockDig.EnumPlayerDigType getDigType() {
		return this.digType;
	}

	public static enum EnumPlayerDigType {
		START_DESTROY_BLOCK,
		ABORT_DESTROY_BLOCK,
		STOP_DESTROY_BLOCK,
		DROP_ALL_ITEMS,
		DROP_ITEM,
		RELEASE_USE_ITEM,
		SWAP_HELD_ITEMS;
	}

}
