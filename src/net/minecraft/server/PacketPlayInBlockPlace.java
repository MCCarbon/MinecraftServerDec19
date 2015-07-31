package net.minecraft.server;

import java.io.IOException;

public class PacketPlayInBlockPlace implements Packet<PacketListenerPlayIn> {

	private BlockPosition position;
	private EnumDirection face;
	private EnumUsedHand hand;
	private float cursorX;
	private float cursorY;
	private float cursorZ;

	@Override
	public void decode(PacketDataSerializer serializer) throws IOException {
		position = serializer.readBlockPosition();
		face = serializer.readEnum(EnumDirection.class);
		hand = serializer.readEnum(EnumUsedHand.class);
		cursorX = serializer.readUnsignedByte() / 16.0F;
		cursorY = serializer.readUnsignedByte() / 16.0F;
		cursorZ = serializer.readUnsignedByte() / 16.0F;
	}

	@Override
	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeBlockPosition(position);
		serializer.writeEnum(face);
		serializer.writeEnum(hand);
		serializer.writeByte((int) (cursorX * 16.0F));
		serializer.writeByte((int) (cursorY * 16.0F));
		serializer.writeByte((int) (cursorZ * 16.0F));
	}

	@Override
	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public BlockPosition getPosition() {
		return position;
	}

	public EnumDirection getDirection() {
		return face;
	}

	public EnumUsedHand getHand() {
		return hand;
	}

	public float getCursorX() {
		return cursorX;
	}

	public float getCursorY() {
		return cursorY;
	}

	public float getCursorZ() {
		return cursorZ;
	}

}
