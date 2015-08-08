package net.minecraft.server;

public class ItemSplashPotion extends ItemPotion {

	@Override
	public String getLocalizedName(ItemStack var1) {
		return LocaleI18n.get("splash_" + i(var1).a());
	}

	@Override
	public UseResultWithValue onUse(ItemStack itemstack, World world, EntityHuman player, EnumUsedHand hand) {
		if (!player.abilities.instabuild) {
			--itemstack.count;
		}

		world.a((Entity) player, "random.bow", 0.5F, 0.4F / ((random.nextFloat() * 0.4F) + 0.8F));
		if (!world.isClientSide) {
			EntityPotion var5 = new EntityPotion(world, player, itemstack);
			var5.a(player.z, player.y, -20.0F, 0.5F, 1.0F);
			world.addEntity(var5);
		}

		player.b(StatisticList.ad[Item.getId(this)]);
		return new UseResultWithValue(UseResult.SUCCESS, itemstack);
	}

}
