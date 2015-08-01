package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInClientCommand implements Packet<PacketListenerPlayIn> {

	private EnumClientCommand command;

	public PacketPlayInClientCommand() {
	}

	public PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand command) {
		this.command = command;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.command = serializer.readEnum(PacketPlayInClientCommand.EnumClientCommand.class);
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeEnum(this.command);
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public PacketPlayInClientCommand.EnumClientCommand a() {
		return this.command;
	}

	public static enum EnumClientCommand {
		PERFORM_RESPAWN, REQUEST_STATS, OPEN_INVENTORY_ACHIEVEMENT;
	}

}
