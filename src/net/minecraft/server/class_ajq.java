package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_ajq extends class_agd {
   private static final List a = Lists.newArrayList((Object[])(new String[]{"harp", "bd", "snare", "hat", "bassattack"}));

   public class_ajq() {
      super(class_atk.d);
      this.a(CreativeTab.d);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, Block var4) {
      boolean var5 = var1.z(var2);
      class_amg var6 = var1.s(var2);
      if(var6 instanceof class_amw) {
         class_amw var7 = (class_amw)var6;
         if(var7.f != var5) {
            if(var5) {
               var7.a(var1, var2);
            }

            var7.f = var5;
         }
      }

   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amw) {
            class_amw var12 = (class_amw)var11;
            var12.b();
            var12.a(var1, var2);
            var4.b(class_nc.S);
         }

         return true;
      }
   }

   public void a(class_aen var1, class_cj var2, class_xa var3) {
      if(!var1.D) {
         class_amg var4 = var1.s(var2);
         if(var4 instanceof class_amw) {
            ((class_amw)var4).a(var1, var2);
            var3.b(class_nc.R);
         }

      }
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amw();
   }

   private String b(int var1) {
      if(var1 < 0 || var1 >= a.size()) {
         var1 = 0;
      }

      return (String)a.get(var1);
   }

   public boolean a(class_aen var1, class_cj var2, IBlockData var3, int var4, int var5) {
      float var6 = (float)Math.pow(2.0D, (double)(var5 - 12) / 12.0D);
      var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "note." + this.b(var4), 3.0F, var6);
      var1.a(class_cy.x, (double)var2.n() + 0.5D, (double)var2.o() + 1.2D, (double)var2.p() + 0.5D, (double)var5 / 24.0D, 0.0D, 0.0D, new int[0]);
      return true;
   }

   public int b() {
      return 3;
   }
}
