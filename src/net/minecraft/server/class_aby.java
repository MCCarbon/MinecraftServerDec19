package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_abe;
import net.minecraft.server.World;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xt;
import net.minecraft.server.class_zc;

public class class_aby extends class_zc {
   public class_xd a(World var1, ItemStack var2, EntityLiving var3) {
      return new class_xt(var1, var3, var2);
   }

   public String getLocalizedName(ItemStack var1) {
      return LocaleI18n.get("tipped_arrow.effect." + ((MinecraftKey) class_acd.a.getKey(class_abe.i(var1))).getName());
   }
}
