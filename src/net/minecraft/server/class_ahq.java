package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amo;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_op;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_ahq extends class_agd {
   protected class_ahq() {
      super(Material.STONE, MaterialMapColor.COLOR29);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.setLightOpacity(0);
      this.a(CreativeTab.c);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public int getRenderType() {
      return 3;
   }

   public class_amg a(World var1, int var2) {
      return new class_amo();
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amo) {
            var4.a((class_op)((class_amo)var11));
         }

         return true;
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, ItemStack var5) {
      super.a(var1, var2, var3, var4, var5);
      if(var5.hasDisplayName()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amo) {
            ((class_amo)var6).a(var5.getDisplayName());
         }
      }

   }
}
