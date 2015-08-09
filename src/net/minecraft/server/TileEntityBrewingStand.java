package net.minecraft.server;

import java.util.Arrays;

public class TileEntityBrewingStand extends TileEntityContainer implements ITickAble, IWorldInventory {

	private static final int[] a = new int[] { 3 };
	private static final int[] f = new int[] { 0, 1, 2 };
	private ItemStack[] g = new ItemStack[4];
	private int h;
	private boolean[] i;
	private Item j;
	private String k;

	@Override
	public String getName() {
		return hasCustomName() ? k : "container.brewing";
	}

	@Override
	public boolean hasCustomName() {
		return (k != null) && !k.isEmpty();
	}

	public void a(String var1) {
		k = var1;
	}

	@Override
	public int getSize() {
		return g.length;
	}

	@Override
	public void tick() {
		boolean var1 = n();
		boolean var2 = h > 0;
		if (var2) {
			--h;
			boolean var3 = h == 0;
			if (var3 && var1) {
				o();
				update();
			} else if (!var1) {
				h = 0;
				update();
			} else if (j != g[3].getItem()) {
				h = 0;
				update();
			}
		} else if (var1) {
			h = 400;
			j = g[3].getItem();
		}

		if (!world.isClientSide) {
			boolean[] var6 = m();
			if (!Arrays.equals(var6, i)) {
				i = var6;
				IBlockData var4 = world.getType(getPosition());
				if (!(var4.getBlock() instanceof BlockBrewingStand)) {
					return;
				}

				for (int var5 = 0; var5 < BlockBrewingStand.a.length; ++var5) {
					var4 = var4.set(BlockBrewingStand.a[var5], Boolean.valueOf(var6[var5]));
				}

				world.setTypeAndData(position, var4, 2);
			}
		}

	}

	public boolean[] m() {
		boolean[] var1 = new boolean[3];

		for (int var2 = 0; var2 < 3; ++var2) {
			if (g[var2] != null) {
				var1[var2] = true;
			}
		}

		return var1;
	}

	private boolean n() {
		if ((g[3] != null) && (g[3].count > 0)) {
			ItemStack var1 = g[3];
			if (!PotionBrewer.a(var1)) {
				return false;
			} else {
				for (int var2 = 0; var2 < 3; ++var2) {
					ItemStack var3 = g[var2];
					if ((var3 != null) && PotionBrewer.a(var3, var1)) {
						return true;
					}
				}

				return false;
			}
		} else {
			return false;
		}
	}

	private void o() {
		ItemStack var1 = g[3];

		for (int var2 = 0; var2 < 3; ++var2) {
			g[var2] = PotionBrewer.d(var1, g[var2]);
		}

		if (var1.getItem().hasCraftingResult()) {
			g[3] = new ItemStack(var1.getItem().getCraftingResult());
		} else {
			--g[3].count;
			if (g[3].count <= 0) {
				g[3] = null;
			}
		}

	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		NBTTagList var2 = var1.getList("Items", 10);
		g = new ItemStack[getSize()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTTagCompound var4 = var2.getCompound(var3);
			byte var5 = var4.getByte("Slot");
			if ((var5 >= 0) && (var5 < g.length)) {
				g[var5] = ItemStack.a(var4);
			}
		}

		h = var1.getShort("BrewTime");
		if (var1.hasOfType("CustomName", 8)) {
			k = var1.getString("CustomName");
		}

	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("BrewTime", (short) h);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < g.length; ++var3) {
			if (g[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.put("Slot", (byte) var3);
				g[var3].write(var4);
				var2.add(var4);
			}
		}

		var1.put("Items", var2);
		if (hasCustomName()) {
			var1.put("CustomName", k);
		}

	}

	@Override
	public ItemStack getItem(int var1) {
		return (var1 >= 0) && (var1 < g.length) ? g[var1] : null;
	}

	@Override
	public ItemStack splitStack(int var1, int var2) {
		if ((var1 >= 0) && (var1 < g.length)) {
			ItemStack var3 = g[var1];
			g[var1] = null;
			return var3;
		} else {
			return null;
		}
	}

	@Override
	public ItemStack splitWithoutUpdate(int var1) {
		if ((var1 >= 0) && (var1 < g.length)) {
			ItemStack var2 = g[var1];
			g[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void setItem(int var1, ItemStack var2) {
		if ((var1 >= 0) && (var1 < g.length)) {
			g[var1] = var2;
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
		if (var1 == 3) {
			return PotionBrewer.a(var2);
		} else {
			Item var3 = var2.getItem();
			return (var3 == Items.POTION) || (var3 == Items.GLASS_BOTTLE);
		}
	}

	@Override
	public int[] getSlotsForFace(EnumDirection var1) {
		return var1 == EnumDirection.UP ? a : f;
	}

	@Override
	public boolean canPlaceItemThroughFace(int var1, ItemStack var2, EnumDirection var3) {
		return canPlaceItem(var1, var2);
	}

	@Override
	public boolean canTakeItemThroughFace(int var1, ItemStack var2, EnumDirection var3) {
		return true;
	}

	@Override
	public String getContainerName() {
		return "minecraft:brewing_stand";
	}

	@Override
	public Container createContainer(PlayerInventory var1, EntityHuman var2) {
		return new class_yd(var1, this);
	}

	@Override
	public int getProperty(int var1) {
		switch (var1) {
			case 0:
				return h;
			default:
				return 0;
		}
	}

	@Override
	public void setProperty(int var1, int var2) {
		switch (var1) {
			case 0:
				h = var2;
			default:
		}
	}

	@Override
	public int getPropertyCount() {
		return 1;
	}

	@Override
	public void remove() {
		Arrays.fill(g, (Object) null);
	}
}
