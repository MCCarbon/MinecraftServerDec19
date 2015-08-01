package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import org.apache.commons.lang3.StringUtils;

public class PacketPlayInTabComplete implements Packet<PacketListenerPlayIn> {

	private String text;
	private BlockPosition position;

	public PacketPlayInTabComplete() {
	}

	public PacketPlayInTabComplete(String text) {
		this(text, null);
	}

	public PacketPlayInTabComplete(String text, BlockPosition position) {
		this.text = text;
		this.position = position;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.text = serializer.readString(32767);
		boolean var2 = serializer.readBoolean();
		if (var2) {
			this.position = serializer.readBlockPosition();
		}
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeString(StringUtils.substring(this.text, 0, 32767));
		boolean hasPos = this.position != null;
		serializer.writeBoolean(hasPos);
		if (hasPos) {
			serializer.writeBlockPosition(this.position);
		}
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public String getText() {
		return this.text;
	}

	public BlockPosition getPosition() {
		return this.position;
	}

}
