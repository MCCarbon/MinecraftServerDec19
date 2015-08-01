package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.EnumUsedHand;

public class PacketPlayInArmAnimation implements Packet<PacketListenerPlayIn> {

	private EnumUsedHand hand;

	public PacketPlayInArmAnimation() {
	}

	public PacketPlayInArmAnimation(EnumUsedHand hand) {
		this.hand = hand;
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

	public EnumUsedHand getHand() {
		return this.hand;
	}

}
