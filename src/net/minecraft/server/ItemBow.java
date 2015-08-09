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
				int diff = this.getUseDuration(itemstack) - usedFor;
				float ready = getPercentReady(diff);
				if (ready >= 0.1D) {
					EntityArrow arrow = arrowItem.createArrowEntity(world, arrowItemStack, player);
					arrow.startShoot(player.pitch, player.yaw, 0.0F, ready * 3.0F, 1.0F);
					if (ready == 1.0F) {
						arrow.setCritical(true);
					}

					int var13 = EnchantmentManager.getLevel(RegistryEnchantments.t, itemstack);
					if (var13 > 0) {
						arrow.b(arrow.l() + (var13 * 0.5D) + 0.5D);
					}

					int var14 = EnchantmentManager.getLevel(RegistryEnchantments.u, itemstack);
					if (var14 > 0) {
						arrow.a(var14);
					}

					if (EnchantmentManager.getLevel(RegistryEnchantments.v, itemstack) > 0) {
						arrow.f(100);
					}

					itemstack.a(1, player);
					world.a((Entity) player, "random.bow", 1.0F, (1.0F / ((random.nextFloat() * 0.4F) + 1.2F)) + (ready * 0.5F));
					if (infiniteArrows) {
						arrow.fromPlayer = 2;
					} else {
						player.inventory.splitStack(arrowSlot, 1);
					}

					player.b(StatisticList.ad[Item.getId(this)]);
					if (!world.isClientSide) {
						world.addEntity(arrow);
					}

				}
			}
		}
	}

	public static float getPercentReady(int input) {
		float i = input / 20.0F;
		i = ((i * i) + (i * 2.0F)) / 3.0F;
		if (i > 1.0F) {
			i = 1.0F;
		}
		return i;
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
