package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class ItemPotion extends Item {

	public ItemPotion() {
		this.d(1);
		this.setUsesData(true);
		this.setCreativeTab(CreativeTab.BREWING);
	}

	public static List<MobEffect> h(ItemStack itemstack) {
		ArrayList<MobEffect> effects = Lists.newArrayList();
		effects.addAll(i(itemstack).b());
		if (itemstack.hasTag() && itemstack.getTag().hasOfType("CustomPotionEffects", 9)) {
			NBTTagList potioneffectstag = itemstack.getTag().getList("CustomPotionEffects", 10);
			for (int i = 0; i < potioneffectstag.getSize(); ++i) {
				NBTTagCompound effectcompound = potioneffectstag.getCompound(i);
				MobEffect effect = MobEffect.fromTag(effectcompound);
				if (effect != null) {
					effects.add(effect);
				}
			}
		}

		return effects;
	}

	@Override
	public ItemStack onUseFinish(ItemStack var1, World var2, EntityLiving var3) {
		EntityHuman var4 = var3 instanceof EntityHuman ? (EntityHuman) var3 : null;
		if ((var4 == null) || !var4.abilities.instabuild) {
			--var1.count;
		}

		if (!var2.isClientSide) {
			List<MobEffect> var5 = h(var1);
			Iterator<MobEffect> var6 = var5.iterator();

			while (var6.hasNext()) {
				MobEffect var7 = var6.next();
				var3.addEffect(new MobEffect(var7));
			}
		}

		if (var4 != null) {
			var4.b(StatisticList.ad[Item.getId(this)]);
		}

		if ((var4 == null) || !var4.abilities.instabuild) {
			if (var1.count <= 0) {
				return new ItemStack(Items.GLASS_BOTTLE);
			}

			if (var4 != null) {
				var4.inventory.pickup(new ItemStack(Items.GLASS_BOTTLE));
			}
		}

		return var1;
	}

	@Override
	public int getUseDuration(ItemStack var1) {
		return 32;
	}

	@Override
	public EnumAnimation getAnimation(ItemStack var1) {
		return EnumAnimation.DRINK;
	}

	@Override
	public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
		var3.c(var4);
		return new UseResultWithValue(UseResult.SUCCESS, var1);
	}

	public static int a(Collection<?> var0) {
		int var1 = 3694022;
		if (var0.isEmpty()) {
			return 3694022;
		} else {
			float var2 = 0.0F;
			float var3 = 0.0F;
			float var4 = 0.0F;
			int var5 = 0;
			Iterator<?> var6 = var0.iterator();

			while (true) {
				MobEffect var7;
				do {
					if (!var6.hasNext()) {
						if (var5 == 0) {
							return 0;
						}

						var2 = (var2 / var5) * 255.0F;
						var3 = (var3 / var5) * 255.0F;
						var4 = (var4 / var5) * 255.0F;
						return ((int) var2 << 16) | ((int) var3 << 8) | (int) var4;
					}

					var7 = (MobEffect) var6.next();
				} while (!var7.isShowParticles());

				int var8 = var7.getEffectType().g();

				for (int var9 = 0; var9 <= var7.getAmplifier(); ++var9) {
					var2 += ((var8 >> 16) & 255) / 255.0F;
					var3 += ((var8 >> 8) & 255) / 255.0F;
					var4 += ((var8 >> 0) & 255) / 255.0F;
					++var5;
				}
			}
		}
	}

	@Override
	public String getLocalizedName(ItemStack var1) {
		return LocaleI18n.get(i(var1).a());
	}

	public static RegistryPotions i(ItemStack var0) {
		return !var0.hasTag() ? class_acf.a : RegistryPotions.a(var0.getTag().getString("Potion"));
	}

	public static ItemStack a(ItemStack var0, RegistryPotions var1) {
		MinecraftKey var2 = RegistryPotions.REGISTRY.getKey(var1);
		if (var2 != null) {
			NBTTagCompound var3 = var0.hasTag() ? var0.getTag() : new NBTTagCompound();
			var3.put("Potion", var2.toString());
			var0.setTag(var3);
		}

		return var0;
	}
}
