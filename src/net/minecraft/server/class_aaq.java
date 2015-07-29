package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahj;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aaq extends Item {
   protected Item.class_a_in_class_aar a;

   public class_aaq(Item.class_a_in_class_aar var1) {
      this.a = var1;
      this.h = 1;
      this.e(var1.a());
      this.a(CreativeTab.i);
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(!var2.a(var4.a(var6), var6, var1)) {
         return class_oq.b;
      } else {
         IBlockData var10 = var3.p(var4);
         Block var11 = var10.getBlock();
         if(var6 != class_cq.a && var3.p(var4.a()).getBlock().getMaterial() == Material.a) {
            if(var11 == Blocks.GRASS || var11 == Blocks.GRASS_PATH) {
               return this.a(var1, var2, var3, var4, Blocks.FARMLAND.getBlockData());
            }

            if(var11 == Blocks.DIRT) {
               switch(class_aaq.SyntheticClass_1.a[((class_ahj.class_a_in_class_ahj)var10.get(class_ahj.a)).ordinal()]) {
               case 1:
                  return this.a(var1, var2, var3, var4, Blocks.FARMLAND.getBlockData());
               case 2:
                  return this.a(var1, var2, var3, var4, Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.a));
               }
            }
         }

         return class_oq.b;
      }
   }

   protected class_oq a(class_aas var1, class_xa var2, World var3, class_cj var4, IBlockData var5) {
      var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), var5.getBlock().stepSound.c(), (var5.getBlock().stepSound.d() + 1.0F) / 2.0F, var5.getBlock().stepSound.e() * 0.8F);
      if(var3.D) {
         return class_oq.a;
      } else {
         var3.a(var4, var5);
         var1.a(1, (class_qa)var2);
         return class_oq.a;
      }
   }

   public String g() {
      return this.a.toString();
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_ahj.class_a_in_class_ahj.values().length];

      static {
         try {
            a[class_ahj.class_a_in_class_ahj.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_ahj.class_a_in_class_ahj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
