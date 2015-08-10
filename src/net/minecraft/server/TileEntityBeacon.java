package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class TileEntityBeacon extends TileEntityContainer implements ITickAble, IInventory {

	public static final MobEffectType[][] a;
	private final List f = Lists.newArrayList();
	private boolean i;
	private int j = -1;
	private MobEffectType k;
	private MobEffectType l;
	private ItemStack m;
	private String n;

	@Override
	public void tick() {
		if ((world.L() % 80L) == 0L) {
			m();
		}

	}

	public void m() {
		B();
		A();
	}

	private void A() {
		if (i && (j > 0) && !world.isClientSide && (k != null)) {
			double var1 = (j * 10) + 10;
			byte var3 = 0;
			if ((j >= 4) && (k == l)) {
				var3 = 1;
			}

			int var4 = position.getX();
			int var5 = position.getY();
			int var6 = position.getZ();
			AxisAlignedBB var7 = (new AxisAlignedBB(var4, var5, var6, var4 + 1, var5 + 1, var6 + 1)).grow(var1, var1, var1).add(0.0D, world.V(), 0.0D);
			List var8 = world.getEntities(EntityHuman.class, var7);
			Iterator var9 = var8.iterator();

			EntityHuman var10;
			while (var9.hasNext()) {
				var10 = (EntityHuman) var9.next();
				var10.addEffect(new MobEffect(k, 180, var3, true, true));
			}

			if ((j >= 4) && (k != l) && (l != null)) {
				var9 = var8.iterator();

				while (var9.hasNext()) {
					var10 = (EntityHuman) var9.next();
					var10.addEffect(new MobEffect(l, 180, 0, true, true));
				}
			}
		}

	}

	private void B() {
		int var1 = j;
		int var2 = position.getX();
		int var3 = position.getY();
		int var4 = position.getZ();
		j = 0;
		f.clear();
		i = true;
		TileEntityBeacon.class_a_in_class_amf var5 = new TileEntityBeacon.class_a_in_class_amf(EntitySheep.a(EnumColor.a));
		f.add(var5);
		boolean var6 = true;
		BlockPosition.MutableBlockPosition var7 = new BlockPosition.MutableBlockPosition();

		int var8;
		for (var8 = var3 + 1; var8 < 256; ++var8) {
			IBlockData var9 = world.getType(var7.setPosition(var2, var8, var4));
			float[] var10;
			if (var9.getBlock() == Blocks.STAINED_GLASS) {
				var10 = EntitySheep.a((EnumColor) var9.get(BlockStainedGlass.a));
			} else {
				if (var9.getBlock() != Blocks.STAINED_GLASS_PANE) {
					if ((var9.getBlock().getLightOpacity() >= 15) && (var9.getBlock() != Blocks.BEDROCK)) {
						i = false;
						f.clear();
						break;
					}

					var5.a();
					continue;
				}

				var10 = EntitySheep.a((EnumColor) var9.get(BlockStainedGlassPane.a));
			}

			if (!var6) {
				var10 = new float[] { (var5.b()[0] + var10[0]) / 2.0F, (var5.b()[1] + var10[1]) / 2.0F, (var5.b()[2] + var10[2]) / 2.0F };
			}

			if (Arrays.equals(var10, var5.b())) {
				var5.a();
			} else {
				var5 = new TileEntityBeacon.class_a_in_class_amf(var10);
				f.add(var5);
			}

			var6 = false;
		}

		if (i) {
			for (var8 = 1; var8 <= 4; j = var8++) {
				int var15 = var3 - var8;
				if (var15 < 0) {
					break;
				}

				boolean var17 = true;

				for (int var11 = var2 - var8; (var11 <= (var2 + var8)) && var17; ++var11) {
					for (int var12 = var4 - var8; var12 <= (var4 + var8); ++var12) {
						Block var13 = world.getType(new BlockPosition(var11, var15, var12)).getBlock();
						if ((var13 != Blocks.EMERALD_BLOCK) && (var13 != Blocks.GOLD_BLOCK) && (var13 != Blocks.DIAMOND_BLOCK) && (var13 != Blocks.IRON_BLOCK)) {
							var17 = false;
							break;
						}
					}
				}

				if (!var17) {
					break;
				}
			}

			if (j == 0) {
				i = false;
			}
		}

		if (!world.isClientSide && (j == 4) && (var1 < j)) {
			Iterator var14 = world.getEntities(EntityHuman.class, (new AxisAlignedBB(var2, var3, var4, var2, var3 - 4, var4)).grow(10.0D, 5.0D, 10.0D)).iterator();

			while (var14.hasNext()) {
				EntityHuman var16 = (EntityHuman) var14.next();
				var16.b(class_mt.K);
			}
		}

	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTTagCompound var1 = new NBTTagCompound();
		write(var1);
		return new PacketPlayOutTileEntityData(position, 3, var1);
	}

	private static MobEffectType f(int var0) {
		MobEffectType var1 = MobEffectType.getById(var0);
		return (var1 != MobEffectList.FASTER_MOVEMENT) && (var1 != MobEffectList.FASTER_DIG) && (var1 != MobEffectList.RESISTANCE) && (var1 != MobEffectList.JUMP) && (var1 != MobEffectList.INCREASE_DAMAGE) && (var1 != MobEffectList.REGENERATION) ? null : var1;
	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		k = f(var1.getInt("Primary"));
		l = f(var1.getInt("Secondary"));
		j = var1.getInt("Levels");
	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		var1.put("Primary", MobEffectType.getId(k));
		var1.put("Secondary", MobEffectType.getId(l));
		var1.put("Levels", j);
	}

	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public ItemStack getItem(int var1) {
		return var1 == 0 ? m : null;
	}

	@Override
	public ItemStack splitStack(int var1, int var2) {
		if ((var1 == 0) && (m != null)) {
			if (var2 >= m.count) {
				ItemStack var3 = m;
				m = null;
				return var3;
			} else {
				m.count -= var2;
				return new ItemStack(m.getItem(), var2, m.i());
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack splitWithoutUpdate(int var1) {
		if ((var1 == 0) && (m != null)) {
			ItemStack var2 = m;
			m = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void setItem(int var1, ItemStack var2) {
		if (var1 == 0) {
			m = var2;
		}

	}

	@Override
	public String getName() {
		return hasCustomName() ? n : "container.beacon";
	}

	@Override
	public boolean hasCustomName() {
		return (n != null) && !n.isEmpty();
	}

	public void a(String var1) {
		n = var1;
	}

	@Override
	public int getMaxStackSize() {
		return 1;
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
		return (var2.getItem() == Items.EMERALD) || (var2.getItem() == Items.DIAMOND) || (var2.getItem() == Items.GOLD_INGOT) || (var2.getItem() == Items.IRON_INGOT);
	}

	@Override
	public String getContainerName() {
		return "minecraft:beacon";
	}

	@Override
	public Container createContainer(PlayerInventory var1, EntityHuman var2) {
		return new ContainerBeacon(var1, this);
	}

	@Override
	public int getProperty(int var1) {
		switch (var1) {
			case 0:
				return j;
			case 1:
				return MobEffectType.getId(k);
			case 2:
				return MobEffectType.getId(l);
			default:
				return 0;
		}
	}

	@Override
	public void setProperty(int var1, int var2) {
		switch (var1) {
			case 0:
				j = var2;
				break;
			case 1:
				k = f(var2);
				break;
			case 2:
				l = f(var2);
		}

	}

	@Override
	public int getPropertyCount() {
		return 3;
	}

	@Override
	public void remove() {
		m = null;
	}

	@Override
	public boolean handleClientInput(int var1, int var2) {
		if (var1 == 1) {
			m();
			return true;
		} else {
			return super.handleClientInput(var1, var2);
		}
	}

	static {
		a = new MobEffectType[][] { { MobEffectList.FASTER_MOVEMENT, MobEffectList.FASTER_DIG }, { MobEffectList.RESISTANCE, MobEffectList.JUMP }, { MobEffectList.INCREASE_DAMAGE }, { MobEffectList.REGENERATION } };
	}

	public static class class_a_in_class_amf {
		private final float[] a;
		private int b;

		public class_a_in_class_amf(float[] var1) {
			a = var1;
			b = 1;
		}

		protected void a() {
			++b;
		}

		public float[] b() {
			return a;
		}
	}
}
