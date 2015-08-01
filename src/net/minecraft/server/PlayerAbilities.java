package net.minecraft.server;

import net.minecraft.server.NBTTagCompound;

public class PlayerAbilities {

	public boolean invulnerable;
	public boolean flying;
	public boolean mayfly;
	public boolean instabuild;
	public boolean mayBuild = true;
	private float flySpeed = 0.05F;
	private float walkSpeed = 0.1F;

	public void write(NBTTagCompound compound) {
		NBTTagCompound abilities = new NBTTagCompound();
		abilities.put("invulnerable", this.invulnerable);
		abilities.put("flying", this.flying);
		abilities.put("mayfly", this.mayfly);
		abilities.put("instabuild", this.instabuild);
		abilities.put("mayBuild", this.mayBuild);
		abilities.put("flySpeed", this.flySpeed);
		abilities.put("walkSpeed", this.walkSpeed);
		compound.put("abilities", abilities);
	}

	public void read(NBTTagCompound compound) {
		if (compound.hasOfType("abilities", 10)) {
			NBTTagCompound abilities = compound.getCompound("abilities");
			this.invulnerable = abilities.getBoolean("invulnerable");
			this.flying = abilities.getBoolean("flying");
			this.mayfly = abilities.getBoolean("mayfly");
			this.instabuild = abilities.getBoolean("instabuild");
			if (abilities.hasOfType("flySpeed", 99)) {
				this.flySpeed = abilities.getFloat("flySpeed");
				this.walkSpeed = abilities.getFloat("walkSpeed");
			}

			if (abilities.hasOfType("mayBuild", 1)) {
				this.mayBuild = abilities.getBoolean("mayBuild");
			}
		}

	}

	public float getFlySpeed() {
		return this.flySpeed;
	}

	public float getWalkSpeed() {
		return this.walkSpeed;
	}

}
