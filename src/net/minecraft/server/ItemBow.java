package net.minecraft.server;

public class ItemBow extends Item {
	public ItemBow() {
		this.maxStackSize = 1;
		this.setMaxDurability(384);
		this.setCreativeTab(CreativeTab.COMBAT);
		this.registerItemState(new MinecraftKey("pull"), new ItemState() {
		});
		this.registerItemState(new MinecraftKey("pulling"), new ItemState() {
		});
	}

	private int findArrowSlot(PlayerInventory inventory) {
		if (this.isArrow(inventory.getItem(40))) {
			return 40;
		} else {
			for (int i = 0; i < inventory.getSize(); ++i) {
				ItemStack var3 = inventory.getItem(i);
				if (this.isArrow(var3)) {
					return i;
				}
			}
			return -1;
		}
	}

	protected boolean isArrow(ItemStack item) {
		return (item != null) && (item.getItem() instanceof ItemArrow);
	}

	@Override
	public void onStopUse(ItemStack itemstack, World world, EntityLiving entity, int usedFor) {
		if (entity instanceof EntityHuman) {
			EntityHuman player = (EntityHuman) entity;
			boolean infiniteArrows = player.abilities.instabuild || (EnchantmentManager.getLevel(RegistryEnchantments.w, itemstack) > 0);
			int arrowSlot = this.findArrowSlot(player.inventory);
			if (infiniteArrows || (arrowSlot > -1)) {
				ItemStack arrowItemStack = arrowSlot > -1 ? player.inventory.getItem(arrowSlot) : null;
				if (arrowItemStack == null) {
					arrowItemStack = new ItemStack(Items.ARROW);
				}

				ItemArrow arrowItem = ((ItemArrow) (arrowItemStack.getItem() instanceof ItemArrow ? arrowItemStack.getItem() : Items.ARROW));
				int var10 = this.getUseDuration(itemstack) - usedFor;
				float var11 = b(var10);
				if (var11 >= 0.1D) {
					EntityArrow var12 = arrowItem.createArrowEntity(world, arrowItemStack, player);
					var12.a(player.pitch, player.yaw, 0.0F, var11 * 3.0F, 1.0F);
					if (var11 == 1.0F) {
						var12.a(true);
					}

					int var13 = EnchantmentManager.getLevel(RegistryEnchantments.t, itemstack);
					if (var13 > 0) {
						var12.b(var12.l() + (var13 * 0.5D) + 0.5D);
					}

					int var14 = EnchantmentManager.getLevel(RegistryEnchantments.u, itemstack);
					if (var14 > 0) {
						var12.a(var14);
					}

					if (EnchantmentManager.getLevel(RegistryEnchantments.v, itemstack) > 0) {
						var12.f(100);
					}

					itemstack.a(1, player);
					world.a((Entity) player, "random.bow", 1.0F, (1.0F / ((random.nextFloat() * 0.4F) + 1.2F)) + (var11 * 0.5F));
					if (infiniteArrows) {
						var12.c = 2;
					} else {
						player.inventory.splitStack(arrowSlot, 1);
					}

					player.b(StatisticList.ad[Item.getId(this)]);
					if (!world.isClientSide) {
						world.addEntity(var12);
					}

				}
			}
		}
	}

	public static float b(int var0) {
		float var1 = var0 / 20.0F;
		var1 = ((var1 * var1) + (var1 * 2.0F)) / 3.0F;
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		return var1;
	}

	@Override
	public int getUseDuration(ItemStack var1) {
		return 72000;
	}

	@Override
	public EnumAnimation getAnimation(ItemStack var1) {
		return EnumAnimation.BOW;
	}

	@Override
	public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
		if ((var3.abilities.instabuild || (this.findArrowSlot(var3.inventory) > -1)) && (var4 == EnumUsedHand.MAIN_HAND)) {
			var3.c(var4);
			return new UseResultWithValue(UseResult.SUCCESS, var1);
		} else {
			return new UseResultWithValue(UseResult.CANT_USE, var1);
		}
	}

	@Override
	public int getItemEnchantability() {
		return 1;
	}
}
