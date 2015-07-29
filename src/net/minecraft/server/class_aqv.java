package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_aqv extends class_aql {
   public boolean b(World var1, Random var2, class_cj var3) {
      if(!var1.d(var3)) {
         return false;
      } else if(var1.p(var3.a()).getBlock() != Blocks.NETHERRACK) {
         return false;
      } else {
         var1.a((class_cj)var3, (IBlockData)Blocks.GLOWSTONE.getBlockData(), 2);

         for(int var4 = 0; var4 < 1500; ++var4) {
            class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), -var2.nextInt(12), var2.nextInt(8) - var2.nextInt(8));
            if(var1.p(var5).getBlock().getMaterial() == Material.a) {
               int var6 = 0;
               class_cq[] var7 = class_cq.values();
               int var8 = var7.length;

               for(int var9 = 0; var9 < var8; ++var9) {
                  class_cq var10 = var7[var9];
                  if(var1.p(var5.a(var10)).getBlock() == Blocks.GLOWSTONE) {
                     ++var6;
                  }

                  if(var6 > 1) {
                     break;
                  }
               }

               if(var6 == 1) {
                  var1.a((class_cj)var5, (IBlockData)Blocks.GLOWSTONE.getBlockData(), 2);
               }
            }
         }

         return true;
      }
   }
}
