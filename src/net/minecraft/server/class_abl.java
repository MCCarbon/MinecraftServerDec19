package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.CreativeTab;

public class class_abl extends Item {
   public class_abl() {
      this.d(1);
      this.e(238);
      this.a(CreativeTab.TOOLS);
   }

   public boolean a(ItemStack var1, World var2, Block var3, BlockPosition var4, EntityLiving var5) {
      if(var3.getMaterial() != Material.LEAVES && var3 != BlockStainedGlassPane.WEB && var3 != BlockStainedGlassPane.TALLGRASS && var3 != BlockStainedGlassPane.VINE && var3 != BlockStainedGlassPane.TRIPWIRE && var3 != BlockStainedGlassPane.WOOL) {
         return super.a(var1, var2, var3, var4, var5);
      } else {
         var1.a(1, (EntityLiving)var5);
         return true;
      }
   }

   public boolean b(Block var1) {
      return var1 == BlockStainedGlassPane.WEB || var1 == BlockStainedGlassPane.REDSTONE_WIRE || var1 == BlockStainedGlassPane.TRIPWIRE;
   }

   public float a(ItemStack var1, Block var2) {
      return var2 != BlockStainedGlassPane.WEB && var2.getMaterial() != Material.LEAVES?(var2 == BlockStainedGlassPane.WOOL?5.0F:super.a(var1, var2)):15.0F;
   }
}
