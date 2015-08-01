package net.minecraft.server;

import net.minecraft.server.NBTTagCompound;

public class ChestLock {

	public static final ChestLock NO_LOCK = new ChestLock("");
	private final String name;

	public ChestLock(String name) {
		this.name = name;
	}

	public boolean isNotLocked() {
		return this.name == null || this.name.isEmpty();
	}

	public String getName() {
		return this.name;
	}

	public void write(NBTTagCompound compound) {
		compound.put("Lock", this.name);
	}

	public static ChestLock fromNBT(NBTTagCompound compound) {
		if (compound.hasOfType("Lock", 8)) {
			String name = compound.getString("Lock");
			return new ChestLock(name);
		} else {
			return NO_LOCK;
		}
	}

}
