package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aee;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahz;
import net.minecraft.server.class_ajd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_awg;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_nc;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_on;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_abt extends Item {
   public class_abt() {
      this.a(true);
      this.a(CreativeTab.f);
   }

   public String a(class_aas var1) {
      String var2 = ("" + LocaleI18n.get(this.a() + ".name")).trim();
      String var3 = class_pt.b(var1.i());
      if(var3 != null) {
         var2 = var2 + " " + LocaleI18n.get("entity." + var3 + ".name");
      }

      return var2;
   }

   public class_oq a(class_aas var1, class_xa var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var3.D) {
         return class_oq.a;
      } else if(!var2.a(var4.shift(var6), var6, var1)) {
         return class_oq.b;
      } else {
         IBlockData var10 = var3.p(var4);
         if(var10.getBlock() == Blocks.MOB_SPAWNER) {
            class_amg var11 = var3.s(var4);
            if(var11 instanceof class_amv) {
               class_aee var12 = ((class_amv)var11).b();
               var12.a(class_pt.b(var1.i()));
               var11.p_();
               var3.h(var4);
               if(!var2.bH.d) {
                  --var1.b;
               }

               return class_oq.a;
            }
         }

         var4 = var4.shift(var6);
         double var14 = 0.0D;
         if(var6 == EnumDirection.UP && var10 instanceof class_ahz) {
            var14 = 0.5D;
         }

         class_pr var13 = a(var3, var1.i(), (double)var4.getX() + 0.5D, (double)var4.getY() + var14, (double)var4.getZ() + 0.5D);
         if(var13 != null) {
            if(var13 instanceof class_qa && var1.s()) {
               var13.a(var1.q());
            }

            if(!var2.bH.d) {
               --var1.b;
            }
         }

         return class_oq.a;
      }
   }

   public class_or a(class_aas var1, World var2, class_xa var3, EnumUsedHand var4) {
      if(var2.D) {
         return new class_or(class_oq.b, var1);
      } else {
         class_awg var5 = this.a(var2, var3, true);
         if(var5 == null) {
            return new class_or(class_oq.b, var1);
         } else {
            if(var5.a == class_awg.class_a_in_class_awg.b) {
               BlockPosition var6 = var5.a();
               if(!var2.a(var3, var6)) {
                  return new class_or(class_oq.b, var1);
               }

               if(!var3.a(var6, var5.b, var1)) {
                  return new class_or(class_oq.b, var1);
               }

               if(var2.p(var6).getBlock() instanceof class_ajd) {
                  class_pr var7 = a(var2, var1.i(), (double)var6.getX() + 0.5D, (double)var6.getY() + 0.5D, (double)var6.getZ() + 0.5D);
                  if(var7 != null) {
                     if(var7 instanceof class_qa && var1.s()) {
                        var7.a(var1.q());
                     }

                     if(!var3.bH.d) {
                        --var1.b;
                     }

                     var3.b(class_nc.ad[Item.getId((Item)this)]);
                     return new class_or(class_oq.a, var1);
                  }
               }
            }

            return new class_or(class_oq.b, var1);
         }
      }
   }

   public static class_pr a(World var0, int var1, double var2, double var4, double var6) {
      if(!class_pt.a.containsKey(Integer.valueOf(var1))) {
         return null;
      } else {
         class_pr var8 = null;

         for(int var9 = 0; var9 < 1; ++var9) {
            var8 = class_pt.a(var1, var0);
            if(var8 instanceof class_qa) {
               class_qb var10 = (class_qb)var8;
               var8.b(var2, var4, var6, MathHelper.clampAngle(var0.s.nextFloat() * 360.0F), 0.0F);
               var10.aN = var10.y;
               var10.aL = var10.y;
               var10.a((class_on)var0.E(new BlockPosition(var10)), (class_qd)null);
               var0.a(var8);
               var10.z();
            }
         }

         return var8;
      }
   }
}
