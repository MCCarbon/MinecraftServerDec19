package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_asj;
import net.minecraft.server.class_ask;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_aso;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;

public class class_asi extends class_ask {
   private List d;
   private boolean f;
   private class_aeh[] g;
   private double h;
   private int i;

   public class_asi() {
      this.g = new class_aeh[3];
      this.h = 32.0D;
      this.i = 3;
      this.d = Lists.newArrayList();
      class_aez[] var1 = class_aez.n();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_aez var4 = var1[var3];
         if(var4 != null && var4.an > 0.0F) {
            this.d.add(var4);
         }
      }

   }

   public class_asi(Map var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("distance")) {
            this.h = class_nu.a((String)var3.getValue(), this.h, 1.0D);
         } else if(((String)var3.getKey()).equals("count")) {
            this.g = new class_aeh[class_nu.a((String)((String)var3.getValue()), this.g.length, 1)];
         } else if(((String)var3.getKey()).equals("spread")) {
            this.i = class_nu.a((String)((String)var3.getValue()), this.i, 1);
         }
      }

   }

   public String a() {
      return "Stronghold";
   }

   protected boolean a(int var1, int var2) {
      if(!this.f) {
         Random var3 = new Random();
         var3.setSeed(this.c.K());
         double var4 = var3.nextDouble() * 3.141592653589793D * 2.0D;
         int var6 = 1;

         for(int var7 = 0; var7 < this.g.length; ++var7) {
            double var8 = (1.25D * (double)var6 + var3.nextDouble()) * this.h * (double)var6;
            int var10 = (int)Math.round(Math.cos(var4) * var8);
            int var11 = (int)Math.round(Math.sin(var4) * var8);
            class_cj var12 = this.c.w().a((var10 << 4) + 8, (var11 << 4) + 8, 112, this.d, var3);
            if(var12 != null) {
               var10 = var12.n() >> 4;
               var11 = var12.p() >> 4;
            }

            this.g[var7] = new class_aeh(var10, var11);
            var4 += 6.283185307179586D * (double)var6 / (double)this.i;
            if(var7 == this.i) {
               var6 += 2 + var3.nextInt(5);
               this.i += 1 + var3.nextInt(2);
            }
         }

         this.f = true;
      }

      class_aeh[] var13 = this.g;
      int var14 = var13.length;

      for(int var5 = 0; var5 < var14; ++var5) {
         class_aeh var15 = var13[var5];
         if(var1 == var15.a && var2 == var15.b) {
            return true;
         }
      }

      return false;
   }

   protected List A_() {
      ArrayList var1 = Lists.newArrayList();
      class_aeh[] var2 = this.g;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_aeh var5 = var2[var4];
         if(var5 != null) {
            var1.add(var5.a(64));
         }
      }

      return var1;
   }

   protected class_aso b(int var1, int var2) {
      class_asi.class_a_in_class_asi var3;
      for(var3 = new class_asi.class_a_in_class_asi(this.c, this.b, var1, var2); var3.c().isEmpty() || ((class_asj.class_m_in_class_asj)var3.c().get(0)).b == null; var3 = new class_asi.class_a_in_class_asi(this.c, this.b, var1, var2)) {
         ;
      }

      return var3;
   }

   public static class class_a_in_class_asi extends class_aso {
      public class_a_in_class_asi() {
      }

      public class_a_in_class_asi(class_aen var1, Random var2, int var3, int var4) {
         super(var3, var4);
         class_asj.b();
         class_asj.class_m_in_class_asj var5 = new class_asj.class_m_in_class_asj(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
         this.a.add(var5);
         var5.a(var5, this.a, var2);
         List var6 = var5.c;

         while(!var6.isEmpty()) {
            int var7 = var2.nextInt(var6.size());
            class_asn var8 = (class_asn)var6.remove(var7);
            var8.a((class_asn)var5, (List)this.a, (Random)var2);
         }

         this.d();
         this.a(var1, var2, 10);
      }
   }
}
