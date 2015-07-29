package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_akv;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amy;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_di;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dy;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_abp extends class_aar {
   private static final String[] a = new String[]{"skeleton", "wither", "zombie", "char", "creeper", "dragon"};

   public class_abp() {
      this.a((class_zu)class_zu.c);
      this.e(0);
      this.a(true);
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var6 == class_cq.a) {
         return class_oq.b;
      } else {
         class_anl var10 = var3.p(var4);
         class_agj var11 = var10.c();
         boolean var12 = var11.a(var3, var4);
         if(!var12) {
            if(!var3.p(var4).c().v().a()) {
               return class_oq.b;
            }

            var4 = var4.a(var6);
         }

         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else if(!class_agk.ce.d(var3, var4)) {
            return class_oq.b;
         } else {
            if(!var3.D) {
               var3.a((class_cj)var4, (class_anl)class_agk.ce.S().a(class_akv.a, var6), 3);
               int var13 = 0;
               if(var6 == class_cq.b) {
                  var13 = class_nu.c((double)(var2.y * 16.0F / 360.0F) + 0.5D) & 15;
               }

               class_amg var14 = var3.s(var4);
               if(var14 instanceof class_amy) {
                  class_amy var15 = (class_amy)var14;
                  if(var1.i() == 3) {
                     GameProfile var16 = null;
                     if(var1.n()) {
                        class_dn var17 = var1.o();
                        if(var17.b("SkullOwner", 10)) {
                           var16 = class_dy.a(var17.n("SkullOwner"));
                        } else if(var17.b("SkullOwner", 8) && !var17.k("SkullOwner").isEmpty()) {
                           var16 = new GameProfile((UUID)null, var17.k("SkullOwner"));
                        }
                     }

                     var15.a(var16);
                  } else {
                     var15.a(var1.i());
                  }

                  var15.b(var13);
                  class_agk.ce.a(var3, var4, var15);
               }

               --var1.b;
            }

            return class_oq.a;
         }
      }
   }

   public int a(int var1) {
      return var1;
   }

   public String e_(class_aas var1) {
      int var2 = var1.i();
      if(var2 < 0 || var2 >= a.length) {
         var2 = 0;
      }

      return super.a() + "." + a[var2];
   }

   public String a(class_aas var1) {
      if(var1.i() == 3 && var1.n()) {
         if(var1.o().b("SkullOwner", 8)) {
            return class_di.a("item.skull.player.name", new Object[]{var1.o().k("SkullOwner")});
         }

         if(var1.o().b("SkullOwner", 10)) {
            class_dn var2 = var1.o().n("SkullOwner");
            if(var2.b("Name", 8)) {
               return class_di.a("item.skull.player.name", new Object[]{var2.k("Name")});
            }
         }
      }

      return super.a(var1);
   }

   public boolean a(class_dn var1) {
      super.a(var1);
      if(var1.b("SkullOwner", 8) && !var1.k("SkullOwner").isEmpty()) {
         GameProfile var2 = new GameProfile((UUID)null, var1.k("SkullOwner"));
         var2 = class_amy.b(var2);
         var1.a((String)"SkullOwner", (class_eb)class_dy.a(new class_dn(), var2));
         return true;
      } else {
         return false;
      }
   }
}
