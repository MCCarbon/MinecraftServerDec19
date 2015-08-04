package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_aea;
import net.minecraft.server.class_aeb;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.EntityHuman;

public interface IMerchant {
   void a(EntityHuman var1);

   EntityHuman v_();

   class_aeb a_(EntityHuman var1);

   void a(class_aea var1);

   void a_(ItemStack var1);

   IChatBaseComponent getScoreboardDisplayName();
}
