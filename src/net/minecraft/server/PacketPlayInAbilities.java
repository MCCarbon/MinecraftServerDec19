package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.PlayerAbilities;

public class PacketPlayInAbilities implements Packet<PacketListenerPlayIn> {

	private boolean invulnerable;
	private boolean flying;
	private boolean mayfly;
	private boolean instabuild;
	private float flyspeed;
	private float walkspeed;

	public PacketPlayInAbilities() {
	}

	public PacketPlayInAbilities(PlayerAbilities abilities) {
		this.setInvulnerable(abilities.invulnerable);
		this.setFlying(abilities.flying);
		this.setMayFly(abilities.mayfly);
		this.setInstantBuild(abilities.instabuild);
		this.setFlySpeed(abilities.getFlySpeed());
		this.setWalkSpeed(abilities.getWalkSpeed());
	}

	public void decode(PacketDataSerializer serializer) throws IOException {
		byte flag = serializer.readByte();
		this.setInvulnerable((flag & 1) > 0);
		this.setFlying((flag & 2) > 0);
		this.setMayFly((flag & 4) > 0);
		this.setInstantBuild((flag & 8) > 0);
		this.setFlySpeed(serializer.readFloat());
		this.setWalkSpeed(serializer.readFloat());
	}

	public void encode(PacketDataSerializer serializer) throws IOException {
		byte flag = 0;
		if (this.isInvulnerable()) {
			flag = (byte) (flag | 1);
		}

		if (this.isFlying()) {
			flag = (byte) (flag | 2);
		}

		if (this.mayFly()) {
			flag = (byte) (flag | 4);
		}

		if (this.canInstantBuild()) {
			flag = (byte) (flag | 8);
		}

		serializer.writeByte(flag);
		serializer.writeFloat(this.flyspeed);
		serializer.writeFloat(this.walkspeed);
	}

	public void handle(PacketListenerPlayIn var1) {
		var1.handle(this);
	}

	public boolean isInvulnerable() {
		return this.invulnerable;
	}

	public void setInvulnerable(boolean invulnerable) {
		this.invulnerable = invulnerable;
	}

	public boolean isFlying() {
		return this.flying;
	}

	public void setFlying(boolean isFlying) {
		this.flying = isFlying;
	}

	public boolean mayFly() {
		return this.mayfly;
	}

	public void setMayFly(boolean mayfly) {
		this.mayfly = mayfly;
	}

	public boolean canInstantBuild() {
		return this.instabuild;
	}

	public void setInstantBuild(boolean instabuild) {
		this.instabuild = instabuild;
	}

	public void setFlySpeed(float speed) {
		this.flyspeed = speed;
	}

	public void setWalkSpeed(float speed) {
		this.walkspeed = speed;
	}

}
