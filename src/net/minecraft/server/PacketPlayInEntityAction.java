package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInEntityAction implements Packet<PacketListenerPlayIn> {

	private int entityId;
	private PacketPlayInEntityAction.EnumPlayerAction action;
	private int jumpBoost;

	public void decode(PacketDataSerializer var1) throws IOException {
		this.entityId = var1.readVarInt();
		this.action = (PacketPlayInEntityAction.EnumPlayerAction) var1.readEnum(PacketPlayInEntityAction.EnumPlayerAction.class);
		this.jumpBoost = var1.readVarInt();
	}

	public void encode(PacketDataSerializer var1) throws IOException {
		var1.writeVarInt(this.entityId);
		var1.writeEnum(this.action);
		var1.writeVarInt(this.jumpBoost);
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public EnumPlayerAction getAction() {
		return this.action;
	}

	public int getJumpBoost() {
		return this.jumpBoost;
	}

	public static enum EnumPlayerAction {
		START_SNEAKING,
		STOP_SNEAKING,
		STOP_SLEEPING,
		START_SPRINTING,
		STOP_SPRINTING,
		RIDING_JUMP,
		OPEN_INVENTORY;
	}

}
