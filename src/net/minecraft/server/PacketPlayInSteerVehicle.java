package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class PacketPlayInSteerVehicle implements Packet<PacketListenerPlayIn> {

	private float side;
	private float forward;
	private boolean isJump;
	private boolean isUnmount;

	public void decode(PacketDataSerializer serializer) throws IOException {
		this.side = serializer.readFloat();
		this.forward = serializer.readFloat();
		byte flag = serializer.readByte();
		this.isJump = (flag & 1) > 0;
		this.isUnmount = (flag & 2) > 0;
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		serializer.writeFloat(this.side);
		serializer.writeFloat(this.forward);
		byte flag = 0;
		if (this.isJump) {
			flag = (byte) (flag | 1);
		}
		if (this.isUnmount) {
			flag = (byte) (flag | 2);
		}
		serializer.writeByte(flag);
	}

	public void handle(PacketListenerPlayIn listener) {
		listener.handle(this);
	}

	public float getSideSpeed() {
		return this.side;
	}

	public float getForwardSpeed() {
		return this.forward;
	}

	public boolean isJump() {
		return this.isJump;
	}

	public boolean isUnmount() {
		return this.isUnmount;
	}

}
