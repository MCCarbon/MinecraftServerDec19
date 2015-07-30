package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aht;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_awg;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xe;
import net.minecraft.server.CreativeTab;

public class class_aae extends Item {
   public class_aae() {
      this.a(CreativeTab.f);
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, class_oo var5, EnumDirection var6, float var7, float var8, float var9) {
      IBlockData var10 = var3.p(var4);
      if(var2.a(var4.shift(var6), var6, var1) && var10.getBlock() == Blocks.END_PORTAL_FRAME && !((Boolean)var10.get(class_aht.b)).booleanValue()) {
         if(var3.D) {
            return class_oq.a;
         } else {
            var3.a((BlockPosition)var4, (IBlockData)var10.set(class_aht.b, Boolean.valueOf(true)), 2);
            var3.e(var4, Blocks.END_PORTAL_FRAME);
            --var1.b;

            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = (double)((float)var4.getX() + (5.0F + random.nextFloat() * 6.0F) / 16.0F);
               double var14 = (double)((float)var4.getY() + 0.8125F);
               double var16 = (double)((float)var4.getZ() + (5.0F + random.nextFloat() * 6.0F) / 16.0F);
               double var18 = 0.0D;
               double var20 = 0.0D;
               double var22 = 0.0D;
               var3.a(class_cy.l, var12, var14, var16, var18, var20, var22, new int[0]);
            }

            EnumDirection var24 = (EnumDirection)var10.get(class_aht.a);
            int var25 = 0;
            int var13 = 0;
            boolean var26 = false;
            boolean var15 = true;
            EnumDirection var27 = var24.rotateY();

            for(int var17 = -2; var17 <= 2; ++var17) {
               BlockPosition var29 = var4.shift(var27, var17);
               IBlockData var19 = var3.p(var29);
               if(var19.getBlock() == Blocks.END_PORTAL_FRAME) {
                  if(!((Boolean)var19.get(class_aht.b)).booleanValue()) {
                     var15 = false;
                     break;
                  }

                  var13 = var17;
                  if(!var26) {
                     var25 = var17;
                     var26 = true;
                  }
               }
            }

            if(var15 && var13 == var25 + 2) {
               BlockPosition var28 = var4.shift(var24, 4);

               int var30;
               for(var30 = var25; var30 <= var13; ++var30) {
                  BlockPosition var31 = var28.shift(var27, var30);
                  IBlockData var33 = var3.p(var31);
                  if(var33.getBlock() != Blocks.END_PORTAL_FRAME || !((Boolean)var33.get(class_aht.b)).booleanValue()) {
                     var15 = false;
                     break;
                  }
               }

               int var32;
               BlockPosition var34;
               for(var30 = var25 - 1; var30 <= var13 + 1; var30 += 4) {
                  var28 = var4.shift(var27, var30);

                  for(var32 = 1; var32 <= 3; ++var32) {
                     var34 = var28.shift(var24, var32);
                     IBlockData var21 = var3.p(var34);
                     if(var21.getBlock() != Blocks.END_PORTAL_FRAME || !((Boolean)var21.get(class_aht.b)).booleanValue()) {
                        var15 = false;
                        break;
                     }
                  }
               }

               if(var15) {
                  for(var30 = var25; var30 <= var13; ++var30) {
                     var28 = var4.shift(var27, var30);

                     for(var32 = 1; var32 <= 3; ++var32) {
                        var34 = var28.shift(var24, var32);
                        var3.a((BlockPosition)var34, (IBlockData)Blocks.END_PORTAL.getBlockData(), 2);
                     }
                  }
               }
            }

            return class_oq.a;
         }
      } else {
         return class_oq.b;
      }
   }

   public class_or a(class_aas var1, World var2, class_xa var3, class_oo var4) {
      class_awg var5 = this.a(var2, var3, false);
      if(var5 != null && var5.a == class_awg.class_a_in_class_awg.b && var2.p(var5.a()).getBlock() == Blocks.END_PORTAL_FRAME) {
         return new class_or(class_oq.a, var1);
      } else {
         if(!var2.D) {
            BlockPosition var6 = var2.a("Stronghold", new BlockPosition(var3));
            if(var6 != null) {
               class_xe var7 = new class_xe(var2, var3.s, var3.t, var3.u);
               var7.a(var6);
               var2.a((class_pr)var7);
               var2.a((class_pr)var3, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
               var2.a((class_xa)null, 1002, new BlockPosition(var3), 0);
               if(!var3.bH.d) {
                  --var1.b;
               }

               var3.b(class_nc.ad[Item.getId((Item)this)]);
               return new class_or(class_oq.a, var1);
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }
}