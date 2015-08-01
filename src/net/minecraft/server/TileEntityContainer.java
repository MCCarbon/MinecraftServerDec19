package net.minecraft.server;


public abstract class TileEntityContainer extends TileEntity implements ITileEntityContainer, ITileInventory {

	private ChestLock chestlock;

	public TileEntityContainer() {
		chestlock = ChestLock.NO_LOCK;
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		chestlock = ChestLock.fromNBT(var1);
	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		if (chestlock != null) {
			chestlock.write(var1);
		}

	}

	@Override
	public boolean isLocked() {
		return (chestlock != null) && !chestlock.isNotLocked();
	}

	@Override
	public ChestLock getChestLock() {
		return chestlock;
	}

	@Override
	public void setChestLock(ChestLock chestlock) {
		this.chestlock = chestlock;
	}

	@Override
	public IChatBaseComponent getScoreboardDisplayName() {
		return hasCustomName() ? new ChatComponentText(getName()) : new ChatMessage(getName(), new Object[0]);
	}

}
