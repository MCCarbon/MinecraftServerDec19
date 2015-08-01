package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.WorldServer;
import net.minecraft.server.class_pr;

public class PacketPlayInSpectate implements Packet<PacketListenerPlayIn> {

	private UUID uuid;

	public PacketPlayInSpectate() {
	}

	public PacketPlayInSpectate(UUID uuid) {
		this.uuid = uuid;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.uuid = serializer.readUUID();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeUUID(this.uuid);
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public class_pr getEntity(WorldServer world) {
		return world.getEntityByUUID(this.uuid);
	}

}
