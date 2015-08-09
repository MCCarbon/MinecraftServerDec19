package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class TileEntityChest extends TileEntityContainer implements ITickAble, IInventory {

	private ItemStack[] items = new ItemStack[27];
	public boolean a;
	public TileEntityChest f;
	public TileEntityChest g;
	public TileEntityChest h;
	public TileEntityChest i;
	public float j;
	public float k;
	public int l;
	private int n;
	private int o = -1;
	private String p;

	@Override
	public int getSize() {
		return 27;
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

	@Override
	public void setItem(int var1, ItemStack var2) {
		items[var1] = var2;
		if ((var2 != null) && (var2.count > getMaxStackSize())) {
			var2.count = getMaxStackSize();
		}

		update();
	}

	@Override
	public String getName() {
		return hasCustomName() ? p : "container.chest";
	}

	@Override
	public boolean hasCustomName() {
		return (p != null) && !p.isEmpty();
	}

	public void a(String var1) {
		p = var1;
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		NBTTagList var2 = var1.getList("Items", 10);
		items = new ItemStack[getSize()];
		if (var1.hasOfType("CustomName", 8)) {
			p = var1.getString("CustomName");
		}

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTTagCompound var4 = var2.getCompound(var3);
			int var5 = var4.getByte("Slot") & 255;
			if ((var5 >= 0) && (var5 < items.length)) {
				items[var5] = ItemStack.a(var4);
			}
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
			var1.put("CustomName", p);
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
	public void resetBlockCache() {
		super.resetBlockCache();
		a = false;
	}

	private void a(TileEntityChest var1, EnumDirection var2) {
		if (var1.isInvalid()) {
			a = false;
		} else if (a) {
			switch (TileEntityChest.SyntheticClass_1.a[var2.ordinal()]) {
				case 1:
					if (f != var1) {
						a = false;
					}
					break;
				case 2:
					if (i != var1) {
						a = false;
					}
					break;
				case 3:
					if (g != var1) {
						a = false;
					}
					break;
				case 4:
					if (h != var1) {
						a = false;
					}
			}
		}

	}

	public void m() {
		if (!a) {
			a = true;
			h = this.a(EnumDirection.WEST);
			g = this.a(EnumDirection.EAST);
			f = this.a(EnumDirection.NORTH);
			i = this.a(EnumDirection.SOUTH);
		}
	}

	protected TileEntityChest a(EnumDirection var1) {
		BlockPosition var2 = position.shift(var1);
		if (b(var2)) {
			TileEntity var3 = world.getTileEntity(var2);
			if (var3 instanceof TileEntityChest) {
				TileEntityChest var4 = (TileEntityChest) var3;
				var4.a(this, var1.opposite());
				return var4;
			}
		}

		return null;
	}

	private boolean b(BlockPosition var1) {
		if (world == null) {
			return false;
		} else {
			Block var2 = world.getType(var1).getBlock();
			return (var2 instanceof BlockChest) && (((BlockChest) var2).b == n());
		}
	}

	@Override
	public void tick() {
		m();
		int var1 = position.getX();
		int var2 = position.getY();
		int var3 = position.getZ();
		++n;
		float var4;
		if (!world.isClientSide && (l != 0) && (((n + var1 + var2 + var3) % 200) == 0)) {
			l = 0;
			var4 = 5.0F;
			List var5 = world.getEntities(EntityHuman.class, new AxisAlignedBB(var1 - var4, var2 - var4, var3 - var4, var1 + 1 + var4, var2 + 1 + var4, var3 + 1 + var4));
			Iterator var6 = var5.iterator();

			label93: while (true) {
				IInventory var8;
				do {
					EntityHuman var7;
					do {
						if (!var6.hasNext()) {
							break label93;
						}

						var7 = (EntityHuman) var6.next();
					} while (!(var7.br instanceof ContainerChest));

					var8 = ((ContainerChest) var7.br).e();
				} while ((var8 != this) && (!(var8 instanceof class_oi) || !((class_oi) var8).a(this)));

				++l;
			}
		}

		k = j;
		var4 = 0.1F;
		double var14;
		if ((l > 0) && (j == 0.0F) && (f == null) && (h == null)) {
			double var11 = var1 + 0.5D;
			var14 = var3 + 0.5D;
			if (i != null) {
				var14 += 0.5D;
			}

			if (g != null) {
				var11 += 0.5D;
			}

			world.makeSound(var11, var2 + 0.5D, var14, "random.chestopen", 0.5F, (world.random.nextFloat() * 0.1F) + 0.9F);
		}

		if (((l == 0) && (j > 0.0F)) || ((l > 0) && (j < 1.0F))) {
			float var12 = j;
			if (l > 0) {
				j += var4;
			} else {
				j -= var4;
			}

			if (j > 1.0F) {
				j = 1.0F;
			}

			float var13 = 0.5F;
			if ((j < var13) && (var12 >= var13) && (f == null) && (h == null)) {
				var14 = var1 + 0.5D;
				double var9 = var3 + 0.5D;
				if (i != null) {
					var9 += 0.5D;
				}

				if (g != null) {
					var14 += 0.5D;
				}

				world.makeSound(var14, var2 + 0.5D, var9, "random.chestclosed", 0.5F, (world.random.nextFloat() * 0.1F) + 0.9F);
			}

			if (j < 0.0F) {
				j = 0.0F;
			}
		}

	}

	@Override
	public boolean handleClientInput(int var1, int var2) {
		if (var1 == 1) {
			l = var2;
			return true;
		} else {
			return super.handleClientInput(var1, var2);
		}
	}

	@Override
	public void startOpen(EntityHuman var1) {
		if (!var1.isSpectator()) {
			if (l < 0) {
				l = 0;
			}

			++l;
			world.c(position, getBlock(), 1, l);
			world.c(position, getBlock());
			world.c(position.down(), getBlock());
		}

	}

	@Override
	public void closeContainer(EntityHuman var1) {
		if (!var1.isSpectator() && (getBlock() instanceof BlockChest)) {
			--l;
			world.c(position, getBlock(), 1, l);
			world.c(position, getBlock());
			world.c(position.down(), getBlock());
		}

	}

	@Override
	public boolean canPlaceItem(int var1, ItemStack var2) {
		return true;
	}

	@Override
	public void setInvalid() {
		super.setInvalid();
		resetBlockCache();
		m();
	}

	public int n() {
		if (o == -1) {
			if ((world == null) || !(getBlock() instanceof BlockChest)) {
				return 0;
			}

			o = ((BlockChest) getBlock()).b;
		}

		return o;
	}

	@Override
	public String getContainerName() {
		return "minecraft:chest";
	}

	@Override
	public Container createContainer(PlayerInventory var1, EntityHuman var2) {
		return new ContainerChest(var1, this, var2);
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

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[EnumDirection.values().length];

		static {
			try {
				a[EnumDirection.NORTH.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[EnumDirection.SOUTH.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[EnumDirection.EAST.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[EnumDirection.WEST.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
