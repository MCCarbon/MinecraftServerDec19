package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.World;
import net.minecraft.server.Vec3D;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;

public class PacketPlayInUseEntity implements Packet<PacketListenerPlayIn> {

	private int entityId;
	private PacketPlayInUseEntity.EnumEntityUseAction action;
	private Vec3D interactAt;
	private EnumUsedHand hand;

	public PacketPlayInUseEntity() {
	}

	public PacketPlayInUseEntity(class_pr entity) {
		this.entityId = entity.getId();
		this.action = PacketPlayInUseEntity.EnumEntityUseAction.ATTACK;
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.entityId = serializer.readVarInt();
		this.action = (PacketPlayInUseEntity.EnumEntityUseAction) serializer.readEnum(PacketPlayInUseEntity.EnumEntityUseAction.class);
		if (this.action == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT_AT) {
			this.interactAt = new Vec3D((double) serializer.readFloat(), (double) serializer.readFloat(), (double) serializer.readFloat());
		}

		if (this.action == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT || this.action == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT_AT) {
			this.hand = serializer.readEnum(EnumUsedHand.class);
		}
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeVarInt(this.entityId);
		serializer.writeEnum(this.action);
		if (this.action == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT_AT) {
			serializer.writeFloat((float) this.interactAt.x);
			serializer.writeFloat((float) this.interactAt.y);
			serializer.writeFloat((float) this.interactAt.z);
		}
		if (this.action == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT || this.action == PacketPlayInUseEntity.EnumEntityUseAction.INTERACT_AT) {
			serializer.writeEnum(this.hand);
		}
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public class_pr getEntity(World world) {
		return world.getEntityById(this.entityId);
	}

	public EnumEntityUseAction getUseAction() {
		return this.action;
	}

	public EnumUsedHand getUsedHand() {
		return this.hand;
	}

	public Vec3D getInteractAt() {
		return this.interactAt;
	}

	public static enum EnumEntityUseAction {
		INTERACT, ATTACK, INTERACT_AT;
	}

}
