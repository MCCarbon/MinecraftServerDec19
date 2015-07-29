package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aat;
import net.minecraft.server.Items;
import net.minecraft.server.class_abz;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adm;
import net.minecraft.server.World;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_zc;
import net.minecraft.server.CreativeTab;

public class class_zl extends Item {
   public class_zl() {
      this.h = 1;
      this.e(384);
      this.a(CreativeTab.j);
      this.a(new MinecraftKey("pull"), new class_aat() {
      });
      this.a(new MinecraftKey("pulling"), new class_aat() {
      });
   }

   private int a(class_wz var1) {
      if(this.g_(var1.a(40))) {
         return 40;
      } else {
         for(int var2 = 0; var2 < var1.o_(); ++var2) {
            class_aas var3 = var1.a(var2);
            if(this.g_(var3)) {
               return var2;
            }
         }

         return -1;
      }
   }

   protected boolean g_(class_aas var1) {
      return var1 != null && var1.b() instanceof class_zc;
   }

   public void a(class_aas var1, World var2, class_qa var3, int var4) {
      if(var3 instanceof class_xa) {
         class_xa var5 = (class_xa)var3;
         boolean var6 = var5.bH.d || class_adk.a(class_adm.w, var1) > 0;
         int var7 = this.a(var5.bp);
         if(var6 || var7 > -1) {
            class_aas var8 = var7 > -1?var5.bp.a(var7):null;
            if(var8 == null) {
               var8 = new class_aas(Items.g);
            }

            class_zc var9 = (class_zc)((class_zc)(var8.b() instanceof class_zc?var8.b():Items.g));
            int var10 = this.e(var1) - var4;
            float var11 = b(var10);
            if((double)var11 >= 0.1D) {
               class_xd var12 = var9.a(var2, var8, var5);
               var12.a(var5.z, var5.y, 0.0F, var11 * 3.0F, 1.0F);
               if(var11 == 1.0F) {
                  var12.a(true);
               }

               int var13 = class_adk.a(class_adm.t, var1);
               if(var13 > 0) {
                  var12.b(var12.l() + (double)var13 * 0.5D + 0.5D);
               }

               int var14 = class_adk.a(class_adm.u, var1);
               if(var14 > 0) {
                  var12.a(var14);
               }

               if(class_adk.a(class_adm.v, var1) > 0) {
                  var12.f(100);
               }

               var1.a(1, (class_qa)var5);
               var2.a((class_pr)var5, "random.bow", 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + var11 * 0.5F);
               if(var6) {
                  var12.c = 2;
               } else {
                  var5.bp.a(var7, 1);
               }

               var5.b(class_nc.ad[Item.getId((Item)this)]);
               if(!var2.D) {
                  var2.a((class_pr)var12);
               }

            }
         }
      }
   }

   public static float b(int var0) {
      float var1 = (float)var0 / 20.0F;
      var1 = (var1 * var1 + var1 * 2.0F) / 3.0F;
      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      return var1;
   }

   public int e(class_aas var1) {
      return 72000;
   }

   public class_abz f(class_aas var1) {
      return class_abz.e;
   }

   public class_or a(class_aas var1, World var2, class_xa var3, class_oo var4) {
      if((var3.bH.d || this.a(var3.bp) > -1) && var4 == class_oo.a) {
         var3.c(var4);
         return new class_or(class_oq.a, var1);
      } else {
         return new class_or(class_oq.b, var1);
      }
   }

   public int c() {
      return 1;
   }
}
