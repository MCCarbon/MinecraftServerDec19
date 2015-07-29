package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ami;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_od;
import net.minecraft.server.class_oj;

public class class_aqa extends class_aql {
   private final List a;
   private final int b;

   public class_aqa(List var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(World var1, Random var2, class_cj var3) {
      Block var4;
      while(((var4 = var1.p(var3).getBlock()).getMaterial() == Material.a || var4.getMaterial() == Material.j) && var3.o() > 1) {
         var3 = var3.b();
      }

      if(var3.o() < 1) {
         return false;
      } else {
         var3 = var3.a();

         for(int var5 = 0; var5 < 4; ++var5) {
            class_cj var6 = var3.a(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
            if(var1.d(var6) && World.a((class_aer)var1, (class_cj)var6.b())) {
               var1.a((class_cj)var6, (IBlockData)Blocks.CHEST.getBlockData(), 2);
               class_amg var7 = var1.s(var6);
               if(var7 instanceof class_ami) {
                  class_od.a(var2, this.a, (class_oj)((class_ami)var7), this.b);
               }

               class_cj var8 = var6.f();
               class_cj var9 = var6.e();
               class_cj var10 = var6.c();
               class_cj var11 = var6.d();
               if(var1.d(var9) && World.a((class_aer)var1, (class_cj)var9.b())) {
                  var1.a((class_cj)var9, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.d(var8) && World.a((class_aer)var1, (class_cj)var8.b())) {
                  var1.a((class_cj)var8, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.d(var10) && World.a((class_aer)var1, (class_cj)var10.b())) {
                  var1.a((class_cj)var10, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               if(var1.d(var11) && World.a((class_aer)var1, (class_cj)var11.b())) {
                  var1.a((class_cj)var11, (IBlockData)Blocks.TORCH.getBlockData(), 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}
