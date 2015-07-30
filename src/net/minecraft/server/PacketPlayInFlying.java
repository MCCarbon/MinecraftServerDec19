package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInFlying implements Packet<PacketListenerPlayIn> {

	protected double x;
	protected double y;
	protected double z;
	protected float yaw;
	protected float pitch;
	protected boolean onGround;
	protected boolean hasPos;
	protected boolean hasLook;

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.onGround = serializer.readBoolean();
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeBoolean(onGround);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public float getYaw() {
		return this.yaw;
	}

	public float getPitch() {
		return this.pitch;
	}

	public boolean isOnGround() {
		return this.onGround;
	}

	public boolean hasPos() {
		return this.hasPos;
	}

	public boolean hasLook() {
		return this.hasLook;
	}

	public void setHasPos(boolean hasPos) {
		this.hasPos = hasPos;
	}

	public static class PacketPlayInLook extends PacketPlayInFlying {
		public PacketPlayInLook() {
			this.hasLook = true;
		}

		public void decode(PacketDataSerializer var1) throws IOException {
			this.yaw = var1.readFloat();
			this.pitch = var1.readFloat();
			super.decode(var1);
		}

		public void encode(PacketDataSerializer var1) throws IOException {
			var1.writeFloat(this.yaw);
			var1.writeFloat(this.pitch);
			super.encode(var1);
		}
	}

	public static class PacketPlayInPosition extends PacketPlayInFlying {
		public PacketPlayInPosition() {
			this.hasPos = true;
		}

		public void decode(PacketDataSerializer serializer) throws IOException {
			this.x = serializer.readDouble();
			this.y = serializer.readDouble();
			this.z = serializer.readDouble();
			super.decode(serializer);
		}

		public void encode(PacketDataSerializer serializer) throws IOException {
			serializer.writeDouble(this.x);
			serializer.writeDouble(this.y);
			serializer.writeDouble(this.z);
			super.encode(serializer);
		}
	}

	public static class PacketPlayInPositionLook extends PacketPlayInFlying {
		public PacketPlayInPositionLook() {
			this.hasPos = true;
			this.hasLook = true;
		}

		public void decode(PacketDataSerializer serializer) throws IOException {
			this.x = serializer.readDouble();
			this.y = serializer.readDouble();
			this.z = serializer.readDouble();
			this.yaw = serializer.readFloat();
			this.pitch = serializer.readFloat();
			super.decode(serializer);
		}

		public void encode(PacketDataSerializer serializer) throws IOException {
			serializer.writeDouble(this.x);
			serializer.writeDouble(this.y);
			serializer.writeDouble(this.z);
			serializer.writeFloat(this.yaw);
			serializer.writeFloat(this.pitch);
			super.encode(serializer);
		}
	}

}
