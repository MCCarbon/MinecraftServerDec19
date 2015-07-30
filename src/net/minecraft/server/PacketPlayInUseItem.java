package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.EnumUsedHand;

public class PacketPlayInUseItem implements Packet<PacketListenerPlayIn> {

	private EnumUsedHand hand;

	public PacketPlayInUseItem() {
	}

	public PacketPlayInUseItem(EnumUsedHand activehand) {
		this.hand = activehand;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.hand = serializer.readEnum(EnumUsedHand.class);
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeEnum(this.hand);
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public EnumUsedHand getActiveHand() {
		return this.hand;
	}

}
