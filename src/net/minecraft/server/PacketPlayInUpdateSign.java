package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInUpdateSign implements Packet<PacketListenerPlayIn> {

	private BlockPosition position;
	private IChatBaseComponent[] lines;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.position = serializer.readBlockPosition();
		this.lines = new IChatBaseComponent[4];

		for (int line = 0; line < 4; ++line) {
			this.lines[line] = IChatBaseComponent.ChatSerializer.fromJson(serializer.readString(384));
		}
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeBlockPosition(this.position);

		for (int line = 0; line < 4; ++line) {
			serializer.writeString(IChatBaseComponent.ChatSerializer.toJson(this.lines[line]));
		}
	}

	public void handle(PacketListenerPlayIn var1) {
		var1.handle(this);
	}

	public BlockPosition getPosition() {
		return this.position;
	}

	public IChatBaseComponent[] getLines() {
		return this.lines;
	}

}
