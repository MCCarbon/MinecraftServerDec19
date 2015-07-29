package net.minecraft.server;

import java.util.EnumSet;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_fi;
import net.minecraft.server.class_i;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;

public class class_bn extends class_i {
   public String c() {
      return "tp";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.tp.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 1) {
         throw new class_cf("commands.tp.usage", new Object[0]);
      } else {
         byte var3 = 0;
         Object var4;
         if(var2.length != 2 && var2.length != 4 && var2.length != 6) {
            var4 = b(var1);
         } else {
            var4 = b(var1, var2[0]);
            var3 = 1;
         }

         if(var2.length != 1 && var2.length != 2) {
            if(var2.length < var3 + 3) {
               throw new class_cf("commands.tp.usage", new Object[0]);
            } else if(((class_pr)var4).o != null) {
               int var14 = var3 + 1;
               class_i.class_a_in_class_i var6 = a(((class_pr)var4).s, var2[var3], true);
               class_i.class_a_in_class_i var7 = a(((class_pr)var4).t, var2[var14++], 0, 0, false);
               class_i.class_a_in_class_i var8 = a(((class_pr)var4).u, var2[var14++], true);
               class_i.class_a_in_class_i var9 = a((double)((class_pr)var4).y, var2.length > var14?var2[var14++]:"~", false);
               class_i.class_a_in_class_i var10 = a((double)((class_pr)var4).z, var2.length > var14?var2[var14]:"~", false);
               float var12;
               if(var4 instanceof class_lh) {
                  EnumSet var11 = EnumSet.noneOf(class_fi.class_a_in_class_fi.class);
                  if(var6.c()) {
                     var11.add(class_fi.class_a_in_class_fi.a);
                  }

                  if(var7.c()) {
                     var11.add(class_fi.class_a_in_class_fi.b);
                  }

                  if(var8.c()) {
                     var11.add(class_fi.class_a_in_class_fi.c);
                  }

                  if(var10.c()) {
                     var11.add(class_fi.class_a_in_class_fi.e);
                  }

                  if(var9.c()) {
                     var11.add(class_fi.class_a_in_class_fi.d);
                  }

                  var12 = (float)var9.b();
                  if(!var9.c()) {
                     var12 = class_nu.g(var12);
                  }

                  float var13 = (float)var10.b();
                  if(!var10.c()) {
                     var13 = class_nu.g(var13);
                  }

                  if(var13 > 90.0F || var13 < -90.0F) {
                     var13 = class_nu.g(180.0F - var13);
                     var12 = class_nu.g(var12 + 180.0F);
                  }

                  ((class_pr)var4).a((class_pr)null);
                  ((class_lh)var4).a.a(var6.b(), var7.b(), var8.b(), var12, var13, var11);
                  ((class_pr)var4).f(var12);
               } else {
                  float var15 = (float)class_nu.g(var9.a());
                  var12 = (float)class_nu.g(var10.a());
                  if(var12 > 90.0F || var12 < -90.0F) {
                     var12 = class_nu.g(180.0F - var12);
                     var15 = class_nu.g(var15 + 180.0F);
                  }

                  ((class_pr)var4).b(var6.a(), var7.a(), var8.a(), var15, var12);
                  ((class_pr)var4).f(var15);
               }

               a(var1, this, "commands.tp.success.coordinates", new Object[]{((class_pr)var4).e_(), Double.valueOf(var6.a()), Double.valueOf(var7.a()), Double.valueOf(var8.a())});
            }
         } else {
            class_pr var5 = b(var1, var2[var2.length - 1]);
            if(var5.o != ((class_pr)var4).o) {
               throw new class_bz("commands.tp.notSameDimension", new Object[0]);
            } else {
               ((class_pr)var4).a((class_pr)null);
               if(var4 instanceof class_lh) {
                  ((class_lh)var4).a.a(var5.s, var5.t, var5.u, var5.y, var5.z);
               } else {
                  ((class_pr)var4).b(var5.s, var5.t, var5.u, var5.y, var5.z);
               }

               a(var1, this, "commands.tp.success", new Object[]{((class_pr)var4).e_(), var5.e_()});
            }
         }
      }
   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return var2.length != 1 && var2.length != 2?null:a(var2, MinecraftServer.N().K());
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
