package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_ask;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_aso;
import net.minecraft.server.class_asr;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_nu;

public class class_asq extends class_ask {
   public static final List d;
   private int f;
   private int g;
   private int h;

   public class_asq() {
      this.g = 32;
      this.h = 8;
   }

   public class_asq(Map var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("size")) {
            this.f = class_nu.a((String)((String)var3.getValue()), this.f, 0);
         } else if(((String)var3.getKey()).equals("distance")) {
            this.g = class_nu.a((String)var3.getValue(), this.g, this.h + 1);
         }
      }

   }

   public String a() {
      return "Village";
   }

   protected boolean a(int var1, int var2) {
      int var3 = var1;
      int var4 = var2;
      if(var1 < 0) {
         var1 -= this.g - 1;
      }

      if(var2 < 0) {
         var2 -= this.g - 1;
      }

      int var5 = var1 / this.g;
      int var6 = var2 / this.g;
      Random var7 = this.c.a(var5, var6, 10387312);
      var5 *= this.g;
      var6 *= this.g;
      var5 += var7.nextInt(this.g - this.h);
      var6 += var7.nextInt(this.g - this.h);
      if(var3 == var5 && var4 == var6) {
         boolean var8 = this.c.w().a(var3 * 16 + 8, var4 * 16 + 8, 0, d);
         if(var8) {
            return true;
         }
      }

      return false;
   }

   protected class_aso b(int var1, int var2) {
      return new class_asq.class_a_in_class_asq(this.c, this.b, var1, var2, this.f);
   }

   static {
      d = Arrays.asList(new class_aez[]{class_aez.q, class_aez.r, class_aez.Y});
   }

   public static class class_a_in_class_asq extends class_aso {
      private boolean c;

      public class_a_in_class_asq() {
      }

      public class_a_in_class_asq(class_aen var1, Random var2, int var3, int var4, int var5) {
         super(var3, var4);
         List var6 = class_asr.a(var2, var5);
         class_asr.class_k_in_class_asr var7 = new class_asr.class_k_in_class_asr(var1.w(), 0, var2, (var3 << 4) + 2, (var4 << 4) + 2, var6, var5);
         this.a.add(var7);
         var7.a(var7, this.a, var2);
         List var8 = var7.g;
         List var9 = var7.f;

         int var10;
         while(!var8.isEmpty() || !var9.isEmpty()) {
            class_asn var11;
            if(var8.isEmpty()) {
               var10 = var2.nextInt(var9.size());
               var11 = (class_asn)var9.remove(var10);
               var11.a((class_asn)var7, (List)this.a, (Random)var2);
            } else {
               var10 = var2.nextInt(var8.size());
               var11 = (class_asn)var8.remove(var10);
               var11.a((class_asn)var7, (List)this.a, (Random)var2);
            }
         }

         this.d();
         var10 = 0;
         Iterator var13 = this.a.iterator();

         while(var13.hasNext()) {
            class_asn var12 = (class_asn)var13.next();
            if(!(var12 instanceof class_asr.class_o_in_class_asr)) {
               ++var10;
            }
         }

         this.c = var10 > 2;
      }

      public boolean a() {
         return this.c;
      }

      public void a(class_dn var1) {
         super.a(var1);
         var1.a("Valid", this.c);
      }

      public void b(class_dn var1) {
         super.b(var1);
         this.c = var1.o("Valid");
      }
   }
}
