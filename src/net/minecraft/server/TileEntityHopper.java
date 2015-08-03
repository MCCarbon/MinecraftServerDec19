package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class TileEntityHopper extends TileEntityContainer implements class_ams, ITickAble {

	private ItemStack[] a = new ItemStack[5];
	private String f;
	private int g = -1;

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		NBTTagList var2 = var1.getList("Items", 10);
		a = new ItemStack[getSize()];
		if (var1.hasOfType("CustomName", 8)) {
			f = var1.getString("CustomName");
		}

		g = var1.getInt("TransferCooldown");

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTTagCompound var4 = var2.getCompound(var3);
			byte var5 = var4.getByte("Slot");
			if ((var5 >= 0) && (var5 < a.length)) {
				a[var5] = ItemStack.a(var4);
			}
		}

	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < a.length; ++var3) {
			if (a[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.put("Slot", (byte) var3);
				a[var3].write(var4);
				var2.add(var4);
			}
		}

		var1.put("Items", var2);
		var1.put("TransferCooldown", g);
		if (hasCustomName()) {
			var1.put("CustomName", f);
		}

	}

	@Override
	public int getSize() {
		return a.length;
	}

	@Override
	public ItemStack getItem(int var1) {
		return a[var1];
	}

	@Override
	public ItemStack splitStack(int var1, int var2) {
		if (a[var1] != null) {
			ItemStack var3;
			if (a[var1].count <= var2) {
				var3 = a[var1];
				a[var1] = null;
				return var3;
			} else {
				var3 = a[var1].a(var2);
				if (a[var1].count == 0) {
					a[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack splitWithoutUpdate(int var1) {
		if (a[var1] != null) {
			ItemStack var2 = a[var1];
			a[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void setItem(int var1, ItemStack var2) {
		a[var1] = var2;
		if ((var2 != null) && (var2.count > getMaxStackSize())) {
			var2.count = getMaxStackSize();
		}

	}

	@Override
	public String getName() {
		return hasCustomName() ? f : "container.hopper";
	}

	@Override
	public boolean hasCustomName() {
		return (f != null) && !f.isEmpty();
	}

	public void a(String var1) {
		f = var1;
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
	public void tick() {
		if ((world != null) && !world.isClientSide) {
			--g;
			if (!n()) {
				d(0);
				m();
			}

		}
	}

	public boolean m() {
		if ((world != null) && !world.isClientSide) {
			if (!n() && BlockHopper.f(getMetadata())) {
				boolean var1 = false;
				if (!p()) {
					var1 = r();
				}

				if (!q()) {
					var1 = a(this) || var1;
				}

				if (var1) {
					d(8);
					update();
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}

	private boolean p() {
		ItemStack[] var1 = a;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			ItemStack var4 = var1[var3];
			if (var4 != null) {
				return false;
			}
		}

		return true;
	}

	private boolean q() {
		ItemStack[] var1 = a;
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			ItemStack var4 = var1[var3];
			if ((var4 == null) || (var4.count != var4.c())) {
				return false;
			}
		}

		return true;
	}

	private boolean r() {
		IInventory var1 = H();
		if (var1 == null) {
			return false;
		} else {
			EnumDirection var2 = BlockHopper.b(getMetadata()).opposite();
			if (this.a(var1, var2)) {
				return false;
			} else {
				for (int var3 = 0; var3 < getSize(); ++var3) {
					if (getItem(var3) != null) {
						ItemStack var4 = getItem(var3).clone();
						ItemStack var5 = a(var1, splitStack(var3, 1), var2);
						if ((var5 == null) || (var5.count == 0)) {
							var1.update();
							return true;
						}

						setItem(var3, var4);
					}
				}

				return false;
			}
		}
	}

	private boolean a(IInventory var1, EnumDirection var2) {
		if (var1 instanceof IWorldInventory) {
			IWorldInventory var7 = (IWorldInventory) var1;
			int[] var8 = var7.getSlotsForFace(var2);

			for (int var9 = 0; var9 < var8.length; ++var9) {
				ItemStack var6 = var7.getItem(var8[var9]);
				if ((var6 == null) || (var6.count != var6.c())) {
					return false;
				}
			}
		} else {
			int var3 = var1.getSize();

			for (int var4 = 0; var4 < var3; ++var4) {
				ItemStack var5 = var1.getItem(var4);
				if ((var5 == null) || (var5.count != var5.c())) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean b(IInventory var0, EnumDirection var1) {
		if (var0 instanceof IWorldInventory) {
			IWorldInventory var2 = (IWorldInventory) var0;
			int[] var3 = var2.getSlotsForFace(var1);

			for (int var4 = 0; var4 < var3.length; ++var4) {
				if (var2.getItem(var3[var4]) != null) {
					return false;
				}
			}
		} else {
			int var5 = var0.getSize();

			for (int var6 = 0; var6 < var5; ++var6) {
				if (var0.getItem(var6) != null) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean a(class_ams var0) {
		IInventory var1 = b(var0);
		if (var1 != null) {
			EnumDirection var2 = EnumDirection.DOWN;
			if (b(var1, var2)) {
				return false;
			}

			if (var1 instanceof IWorldInventory) {
				IWorldInventory var3 = (IWorldInventory) var1;
				int[] var4 = var3.getSlotsForFace(var2);

				for (int var5 = 0; var5 < var4.length; ++var5) {
					if (a(var0, var1, var4[var5], var2)) {
						return true;
					}
				}
			} else {
				int var7 = var1.getSize();

				for (int var9 = 0; var9 < var7; ++var9) {
					if (a(var0, var1, var9, var2)) {
						return true;
					}
				}
			}
		} else {
			Iterator var6 = a(var0.getWorld(), var0.A(), var0.B() + 1.0D, var0.C()).iterator();

			while (var6.hasNext()) {
				EntityItem var8 = (EntityItem) var6.next();
				if (a(var0, var8)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean a(class_ams var0, IInventory var1, int var2, EnumDirection var3) {
		ItemStack var4 = var1.getItem(var2);
		if ((var4 != null) && b(var1, var4, var2, var3)) {
			ItemStack var5 = var4.clone();
			ItemStack var6 = a(var0, var1.splitStack(var2, 1), (EnumDirection) null);
			if ((var6 == null) || (var6.count == 0)) {
				var1.update();
				return true;
			}

			var1.setItem(var2, var5);
		}

		return false;
	}

	public static boolean a(IInventory var0, EntityItem var1) {
		boolean var2 = false;
		if (var1 == null) {
			return false;
		} else {
			ItemStack var3 = var1.l().clone();
			ItemStack var4 = a(var0, var3, (EnumDirection) null);
			if ((var4 != null) && (var4.count != 0)) {
				var1.a(var4);
			} else {
				var2 = true;
				var1.J();
			}

			return var2;
		}
	}

	public static ItemStack a(IInventory var0, ItemStack var1, EnumDirection var2) {
		if ((var0 instanceof IWorldInventory) && (var2 != null)) {
			IWorldInventory var6 = (IWorldInventory) var0;
			int[] var7 = var6.getSlotsForFace(var2);

			for (int var5 = 0; (var5 < var7.length) && (var1 != null) && (var1.count > 0); ++var5) {
				var1 = c(var0, var1, var7[var5], var2);
			}
		} else {
			int var3 = var0.getSize();

			for (int var4 = 0; (var4 < var3) && (var1 != null) && (var1.count > 0); ++var4) {
				var1 = c(var0, var1, var4, var2);
			}
		}

		if ((var1 != null) && (var1.count == 0)) {
			var1 = null;
		}

		return var1;
	}

	private static boolean a(IInventory var0, ItemStack var1, int var2, EnumDirection var3) {
		return !var0.canPlaceItem(var2, var1) ? false : !(var0 instanceof IWorldInventory) || ((IWorldInventory) var0).canPlaceItemThroughFace(var2, var1, var3);
	}

	private static boolean b(IInventory var0, ItemStack var1, int var2, EnumDirection var3) {
		return !(var0 instanceof IWorldInventory) || ((IWorldInventory) var0).canTakeItemThroughFace(var2, var1, var3);
	}

	private static ItemStack c(IInventory var0, ItemStack var1, int var2, EnumDirection var3) {
		ItemStack var4 = var0.getItem(var2);
		if (a(var0, var1, var2, var3)) {
			boolean var5 = false;
			if (var4 == null) {
				var0.setItem(var2, var1);
				var1 = null;
				var5 = true;
			} else if (a(var4, var1)) {
				int var6 = var1.c() - var4.count;
				int var7 = Math.min(var1.count, var6);
				var1.count -= var7;
				var4.count += var7;
				var5 = var7 > 0;
			}

			if (var5) {
				if (var0 instanceof TileEntityHopper) {
					TileEntityHopper var8 = (TileEntityHopper) var0;
					if (var8.o()) {
						var8.d(8);
					}

					var0.update();
				}

				var0.update();
			}
		}

		return var1;
	}

	private IInventory H() {
		EnumDirection var1 = BlockHopper.b(getMetadata());
		return b(getWorld(), position.getX() + var1.getAdjacentX(), position.getY() + var1.getAdjacentY(), position.getZ() + var1.getAdjacentZ());
	}

	public static IInventory b(class_ams var0) {
		return b(var0.getWorld(), var0.A(), var0.B() + 1.0D, var0.C());
	}

	public static List a(World var0, double var1, double var3, double var5) {
		return var0.a(EntityItem.class, new AxisAlignedBB(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D), IEntitySelector.IS_ALIVE);
	}

	public static IInventory b(World var0, double var1, double var3, double var5) {
		Object var7 = null;
		int var8 = MathHelper.floor(var1);
		int var9 = MathHelper.floor(var3);
		int var10 = MathHelper.floor(var5);
		BlockPosition var11 = new BlockPosition(var8, var9, var10);
		Block var12 = var0.getType(var11).getBlock();
		if (var12.isTileEntity()) {
			TileEntity var13 = var0.getTileEntity(var11);
			if (var13 instanceof IInventory) {
				var7 = var13;
				if ((var7 instanceof TileEntityChest) && (var12 instanceof BlockChest)) {
					var7 = ((BlockChest) var12).f(var0, var11);
				}
			}
		}

		if (var7 == null) {
			List var14 = var0.a((Entity) null, (new AxisAlignedBB(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D)), IEntitySelector.IS_ALIVE_AND_HAS_INVENTORY);
			if (!var14.isEmpty()) {
				var7 = var14.get(var0.random.nextInt(var14.size()));
			}
		}

		return (IInventory) var7;
	}

	private static boolean a(ItemStack var0, ItemStack var1) {
		return var0.getItem() != var1.getItem() ? false : (var0.i() != var1.i() ? false : (var0.count > var0.c() ? false : ItemStack.a(var0, var1)));
	}

	@Override
	public double A() {
		return position.getX() + 0.5D;
	}

	@Override
	public double B() {
		return position.getY() + 0.5D;
	}

	@Override
	public double C() {
		return position.getZ() + 0.5D;
	}

	public void d(int var1) {
		g = var1;
	}

	public boolean n() {
		return g > 0;
	}

	public boolean o() {
		return g <= 1;
	}

	@Override
	public String getContainerName() {
		return "minecraft:hopper";
	}

	@Override
	public Container createContainer(PlayerInventory var1, EntityHuman var2) {
		return new class_yn(var1, this, var2);
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
		for (int var1 = 0; var1 < a.length; ++var1) {
			a[var1] = null;
		}

	}
}
