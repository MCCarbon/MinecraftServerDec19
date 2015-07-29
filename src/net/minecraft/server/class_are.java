package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;

public class class_are extends class_aql {
   public boolean b(World var1, Random var2, class_cj var3) {
      for(int var4 = 0; var4 < 20; ++var4) {
         class_cj var5 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         if(var1.d(var5)) {
            class_cj var6 = var5.b();
            if(var1.p(var6.e()).getBlock().getMaterial() == Material.h || var1.p(var6.f()).getBlock().getMaterial() == Material.h || var1.p(var6.c()).getBlock().getMaterial() == Material.h || var1.p(var6.d()).getBlock().getMaterial() == Material.h) {
               int var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

               for(int var8 = 0; var8 < var7; ++var8) {
                  if(Blocks.REEDS.e(var1, var5)) {
                     var1.a((class_cj)var5.b(var8), (IBlockData)Blocks.REEDS.getBlockData(), 2);
                  }
               }
            }
         }
      }

      return true;
   }
}
