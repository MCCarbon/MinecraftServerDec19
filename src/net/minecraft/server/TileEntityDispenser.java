package net.minecraft.server;

import java.util.Random;

public class TileEntityDispenser extends TileEntityContainer implements IInventory {

	private static final Random random = new Random();

	private ItemStack[] items = new ItemStack[9];
	protected String a;

	@Override
	public int getSize() {
		return 9;
	}

	@Override
	public ItemStack getItem(int var1) {
		return items[var1];
	}

	@Override
	public ItemStack splitStack(int var1, int var2) {
		if (items[var1] != null) {
			ItemStack var3;
			if (items[var1].count <= var2) {
				var3 = items[var1];
				items[var1] = null;
				update();
				return var3;
			} else {
				var3 = items[var1].a(var2);
				if (items[var1].count == 0) {
					items[var1] = null;
				}

				update();
				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack splitWithoutUpdate(int var1) {
		if (items[var1] != null) {
			ItemStack var2 = items[var1];
			items[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public int m() {
		int var1 = -1;
		int var2 = 1;

		for (int var3 = 0; var3 < items.length; ++var3) {
			if ((items[var3] != null) && (random.nextInt(var2++) == 0)) {
				var1 = var3;
			}
		}

		return var1;
	}

	@Override
	public void setItem(int var1, ItemStack var2) {
		items[var1] = var2;
		if ((var2 != null) && (var2.count > getMaxStackSize())) {
			var2.count = getMaxStackSize();
		}

		update();
	}

	public int a(ItemStack var1) {
		for (int var2 = 0; var2 < items.length; ++var2) {
			if ((items[var2] == null) || (items[var2].getItem() == null)) {
				setItem(var2, var1);
				return var2;
			}
		}

		return -1;
	}

	@Override
	public String getName() {
		return hasCustomName() ? a : "container.dispenser";
	}

	public void a(String var1) {
		a = var1;
	}

	@Override
	public boolean hasCustomName() {
		return a != null;
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		NBTTagList var2 = var1.getList("Items", 10);
		items = new ItemStack[getSize()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTTagCompound var4 = var2.getCompound(var3);
			int var5 = var4.getByte("Slot") & 255;
			if ((var5 >= 0) && (var5 < items.length)) {
				items[var5] = ItemStack.a(var4);
			}
		}

		if (var1.hasOfType("CustomName", 8)) {
			a = var1.getString("CustomName");
		}

	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < items.length; ++var3) {
			if (items[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.put("Slot", (byte) var3);
				items[var3].write(var4);
				var2.add(var4);
			}
		}

		var1.put("Items", var2);
		if (hasCustomName()) {
			var1.put("CustomName", a);
		}

	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public boolean isReachable(EntityHuman var1) {
		return world.getTileEntity(position) != this ? false : var1.e(position.getX() + 0.5D, position.getY() + 0.5D, position.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void startOpen(EntityHuman var1) {
	}

	@Override
	public void closeContainer(EntityHuman var1) {
	}

	@Override
	public boolean canPlaceItem(int var1, ItemStack var2) {
		return true;
	}

	@Override
	public String getContainerName() {
		return "minecraft:dispenser";
	}

	@Override
	public Container createContainer(PlayerInventory var1, EntityHuman var2) {
		return new class_yi(var1, this);
	}

	@Override
	public int getProperty(int var1) {
		return 0;
	}

	@Override
	public void setProperty(int var1, int var2) {
	}

	@Override
	public int getPropertyCount() {
		return 0;
	}

	@Override
	public void remove() {
		for (int var1 = 0; var1 < items.length; ++var1) {
			items[var1] = null;
		}

	}
}
