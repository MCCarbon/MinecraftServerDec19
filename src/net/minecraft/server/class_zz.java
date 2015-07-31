package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_uf;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_zz extends Item {
   public static final int[] a = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};

   public class_zz() {
      this.a(true);
      this.e(0);
      this.a(CreativeTab.l);
   }

   public String e_(ItemStack var1) {
      int var2 = var1.i();
      return super.a() + "." + class_zy.a(var2).d();
   }

   public class_oq a(ItemStack var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(!var2.a(var4.shift(var6), var6, var1)) {
         return class_oq.b;
      } else {
         class_zy var10 = class_zy.a(var1.i());
         if(var10 == class_zy.a) {
            if(a(var1, var3, var4)) {
               if(!var3.D) {
                  var3.b(2005, var4, 0);
               }

               return class_oq.a;
            }
         } else if(var10 == class_zy.m) {
            IBlockData var11 = var3.p(var4);
            Block var12 = var11.getBlock();
            if(var12 == Blocks.LOG && var11.get(class_ajt.b) == class_ajw.class_a_in_class_ajw.d) {
               if(var6 == EnumDirection.DOWN) {
                  return class_oq.b;
               }

               if(var6 == EnumDirection.UP) {
                  return class_oq.b;
               }

               var4 = var4.shift(var6);
               if(var3.d(var4)) {
                  IBlockData var13 = Blocks.COCOA.a(var3, var4, var6, var7, var8, var9, 0, var2);
                  var3.a((BlockPosition)var4, (IBlockData)var13, 2);
                  if(!var2.bH.d) {
                     --var1.count;
                  }
               }

               return class_oq.a;
            }
         }

         return class_oq.b;
      }
   }

   public static boolean a(ItemStack var0, World var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      if(var3.getBlock() instanceof class_agl) {
         class_agl var4 = (class_agl)var3.getBlock();
         if(var4.a(var1, var2, var3, var1.D)) {
            if(!var1.D) {
               if(var4.a(var1, var1.s, var2, var3)) {
                  var4.b(var1, var1.s, var2, var3);
               }

               --var0.count;
            }

            return true;
         }
      }

      return false;
   }

   public boolean a(ItemStack var1, class_xa var2, class_qa var3, EnumUsedHand var4) {
      if(var3 instanceof class_uf) {
         class_uf var5 = (class_uf)var3;
         class_zy var6 = class_zy.a(var1.i());
         if(!var5.cB() && var5.cA() != var6) {
            var5.b(var6);
            --var1.count;
         }

         return true;
      } else {
         return false;
      }
   }
}
