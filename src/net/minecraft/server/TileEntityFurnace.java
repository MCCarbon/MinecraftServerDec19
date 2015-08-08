package net.minecraft.server;

public class TileEntityFurnace extends TileEntityContainer implements ITickAble, IWorldInventory {

	private static final int[] a = new int[] { 0 };
	private static final int[] f = new int[] { 2, 1 };
	private static final int[] g = new int[] { 1 };
	private ItemStack[] h = new ItemStack[3];
	private int i;
	private int j;
	private int k;
	private int l;
	private String m;

	@Override
	public int getSize() {
		return h.length;
	}

	@Override
	public ItemStack getItem(int var1) {
		return h[var1];
	}

	@Override
	public ItemStack splitStack(int var1, int var2) {
		if (h[var1] != null) {
			ItemStack var3;
			if (h[var1].count <= var2) {
				var3 = h[var1];
				h[var1] = null;
				return var3;
			} else {
				var3 = h[var1].a(var2);
				if (h[var1].count == 0) {
					h[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack splitWithoutUpdate(int var1) {
		if (h[var1] != null) {
			ItemStack var2 = h[var1];
			h[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void setItem(int var1, ItemStack var2) {
		boolean var3 = (var2 != null) && var2.a(h[var1]) && ItemStack.a(var2, h[var1]);
		h[var1] = var2;
		if ((var2 != null) && (var2.count > getMaxStackSize())) {
			var2.count = getMaxStackSize();
		}

		if ((var1 == 0) && !var3) {
			l = this.a(var2);
			k = 0;
			update();
		}

	}

	@Override
	public String getName() {
		return hasCustomName() ? m : "container.furnace";
	}

	@Override
	public boolean hasCustomName() {
		return (m != null) && !m.isEmpty();
	}

	public void a(String var1) {
		m = var1;
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		NBTTagList var2 = var1.getList("Items", 10);
		h = new ItemStack[getSize()];

		for (int var3 = 0; var3 < var2.getSize(); ++var3) {
			NBTTagCompound var4 = var2.getCompound(var3);
			byte var5 = var4.getByte("Slot");
			if ((var5 >= 0) && (var5 < h.length)) {
				h[var5] = ItemStack.a(var4);
			}
		}

		i = var1.getShort("BurnTime");
		k = var1.getShort("CookTime");
		l = var1.getShort("CookTimeTotal");
		j = b(h[1]);
		if (var1.hasOfType("CustomName", 8)) {
			m = var1.getString("CustomName");
		}

	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("BurnTime", (short) i);
		var1.put("CookTime", (short) k);
		var1.put("CookTimeTotal", (short) l);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < h.length; ++var3) {
			if (h[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.put("Slot", (byte) var3);
				h[var3].write(var4);
				var2.add(var4);
			}
		}

		var1.put("Items", var2);
		if (hasCustomName()) {
			var1.put("CustomName", m);
		}

	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	public boolean m() {
		return i > 0;
	}

	@Override
	public void tick() {
		boolean var1 = m();
		boolean var2 = false;
		if (m()) {
			--i;
		}

		if (!world.isClientSide) {
			if (!m() && ((h[1] == null) || (h[0] == null))) {
				if (!m() && (k > 0)) {
					k = MathHelper.clamp(k - 2, 0, l);
				}
			} else {
				if (!m() && o()) {
					j = i = b(h[1]);
					if (m()) {
						var2 = true;
						if (h[1] != null) {
							--h[1].count;
							if (h[1].count == 0) {
								Item var3 = h[1].getItem().getCraftingResult();
								h[1] = var3 != null ? new ItemStack(var3) : null;
							}
						}
					}
				}

				if (m() && o()) {
					++k;
					if (k == l) {
						k = 0;
						l = this.a(h[0]);
						n();
						var2 = true;
					}
				} else {
					k = 0;
				}
			}

			if (var1 != m()) {
				var2 = true;
				BlockFurnace.a(m(), world, position);
			}
		}

		if (var2) {
			update();
		}

	}

	public int a(ItemStack var1) {
		return 200;
	}

	private boolean o() {
		if (h[0] == null) {
			return false;
		} else {
			ItemStack var1 = class_aco.a().a(h[0]);
			return var1 == null ? false : (h[2] == null ? true : (!h[2].a(var1) ? false : ((h[2].count < getMaxStackSize()) && (h[2].count < h[2].c()) ? true : h[2].count < var1.c())));
		}
	}

	public void n() {
		if (o()) {
			ItemStack var1 = class_aco.a().a(h[0]);
			if (h[2] == null) {
				h[2] = var1.clone();
			} else if (h[2].getItem() == var1.getItem()) {
				++h[2].count;
			}

			if ((h[0].getItem() == Item.getItemOf(Blocks.SPONGE)) && (h[0].i() == 1) && (h[1] != null) && (h[1].getItem() == Items.BUCKET)) {
				h[1] = new ItemStack(Items.WATER_BUCKET);
			}

			--h[0].count;
			if (h[0].count <= 0) {
				h[0] = null;
			}

		}
	}

	public static int b(ItemStack var0) {
		if (var0 == null) {
			return 0;
		} else {
			Item var1 = var0.getItem();
			if ((var1 instanceof ItemBlock) && (Block.getByItem(var1) != Blocks.AIR)) {
				Block var2 = Block.getByItem(var1);
				if (var2 == Blocks.WOODEN_SLAB) {
					return 150;
				}

				if (var2.getMaterial() == Material.WOOD) {
					return 300;
				}

				if (var2 == Blocks.COAL_BLOCK) {
					return 16000;
				}
			}

			return (var1 instanceof class_zv) && ((class_zv) var1).h().equals("WOOD") ? 200 : ((var1 instanceof ItemSword) && ((ItemSword) var1).h().equals("WOOD") ? 200 : ((var1 instanceof ItemHoe) && ((ItemHoe) var1).g().equals("WOOD") ? 200 : (var1 == Items.STICK ? 100 : (var1 == Items.COAL ? 1600 : (var1 == Items.LAVA_BUCKET ? 20000 : (var1 == Item.getItemOf(Blocks.SAPLING) ? 100 : (var1 == Items.BLAZE_ROD ? 2400 : 0)))))));
		}
	}

	public static boolean c(ItemStack var0) {
		return b(var0) > 0;
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
		return var1 == 2 ? false : (var1 != 1 ? true : c(var2) || class_yk.c_(var2));
	}

	@Override
	public int[] getSlotsForFace(EnumDirection var1) {
		return var1 == EnumDirection.DOWN ? f : (var1 == EnumDirection.UP ? a : g);
	}

	@Override
	public boolean canPlaceItemThroughFace(int var1, ItemStack var2, EnumDirection var3) {
		return this.canPlaceItem(var1, var2);
	}

	@Override
	public boolean canTakeItemThroughFace(int var1, ItemStack var2, EnumDirection var3) {
		if ((var3 == EnumDirection.DOWN) && (var1 == 1)) {
			Item var4 = var2.getItem();
			if ((var4 != Items.WATER_BUCKET) && (var4 != Items.BUCKET)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String getContainerName() {
		return "minecraft:furnace";
	}

	@Override
	public Container createContainer(PlayerInventory var1, EntityHuman var2) {
		return new class_yl(var1, this);
	}

	@Override
	public int getProperty(int var1) {
		switch (var1) {
			case 0:
				return i;
			case 1:
				return j;
			case 2:
				return k;
			case 3:
				return l;
			default:
				return 0;
		}
	}

	@Override
	public void setProperty(int var1, int var2) {
		switch (var1) {
			case 0:
				i = var2;
				break;
			case 1:
				j = var2;
				break;
			case 2:
				k = var2;
				break;
			case 3:
				l = var2;
		}

	}

	@Override
	public int getPropertyCount() {
		return 4;
	}

	@Override
	public void remove() {
		for (int var1 = 0; var1 < h.length; ++var1) {
			h[var1] = null;
		}

	}
}
