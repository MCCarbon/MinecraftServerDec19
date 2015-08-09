package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.MerchantRecipe;
import net.minecraft.server.MerchantRecipeList;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.EntityHuman;

public interface IMerchant {
   void a(EntityHuman var1);

   EntityHuman v_();

   MerchantRecipeList getOffers(EntityHuman var1);

   void a(MerchantRecipe var1);

   void a_(ItemStack var1);

   IChatBaseComponent getScoreboardDisplayName();
}
