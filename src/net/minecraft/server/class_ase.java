package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asf;
import net.minecraft.server.class_ask;
import net.minecraft.server.class_aso;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_wg;

public class class_ase extends class_ask {
   private int f;
   private int g;
   public static final List d;
   private static final List h;

   public class_ase() {
      this.f = 32;
      this.g = 5;
   }

   public class_ase(Map var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("spacing")) {
            this.f = class_nu.a((String)((String)var3.getValue()), this.f, 1);
         } else if(((String)var3.getKey()).equals("separation")) {
            this.g = class_nu.a((String)((String)var3.getValue()), this.g, 1);
         }
      }

   }

   public String a() {
      return "Monument";
   }

   protected boolean a(int var1, int var2) {
      int var3 = var1;
      int var4 = var2;
      if(var1 < 0) {
         var1 -= this.f - 1;
      }

      if(var2 < 0) {
         var2 -= this.f - 1;
      }

      int var5 = var1 / this.f;
      int var6 = var2 / this.f;
      Random var7 = this.c.a(var5, var6, 10387313);
      var5 *= this.f;
      var6 *= this.f;
      var5 += (var7.nextInt(this.f - this.g) + var7.nextInt(this.f - this.g)) / 2;
      var6 += (var7.nextInt(this.f - this.g) + var7.nextInt(this.f - this.g)) / 2;
      if(var3 == var5 && var4 == var6) {
         if(this.c.w().a(new class_cj(var3 * 16 + 8, 64, var4 * 16 + 8), (class_aez)null) != class_aez.N) {
            return false;
         }

         boolean var8 = this.c.w().a(var3 * 16 + 8, var4 * 16 + 8, 29, d);
         if(var8) {
            return true;
         }
      }

      return false;
   }

   protected class_aso b(int var1, int var2) {
      return new class_ase.class_a_in_class_ase(this.c, this.b, var1, var2);
   }

   public List b() {
      return h;
   }

   static {
      d = Arrays.asList(new class_aez[]{class_aez.p, class_aez.N, class_aez.w, class_aez.z, class_aez.A});
      h = Lists.newArrayList();
      h.add(new class_aez.class_c_in_class_aez(class_wg.class, 1, 2, 4));
   }

   public static class class_a_in_class_ase extends class_aso {
      private Set c = Sets.newHashSet();
      private boolean d;

      public class_a_in_class_ase() {
      }

      public class_a_in_class_ase(class_aen var1, Random var2, int var3, int var4) {
         super(var3, var4);
         this.b(var1, var2, var3, var4);
      }

      private void b(class_aen var1, Random var2, int var3, int var4) {
         var2.setSeed(var1.K());
         long var5 = var2.nextLong();
         long var7 = var2.nextLong();
         long var9 = (long)var3 * var5;
         long var11 = (long)var4 * var7;
         var2.setSeed(var9 ^ var11 ^ var1.K());
         int var13 = var3 * 16 + 8 - 29;
         int var14 = var4 * 16 + 8 - 29;
         class_cq var15 = class_cq.class_c_in_class_cq.a.a(var2);
         this.a.add(new class_asf.class_h_in_class_asf(var2, var13, var14, var15));
         this.d();
         this.d = true;
      }

      public void a(class_aen var1, Random var2, class_arw var3) {
         if(!this.d) {
            this.a.clear();
            this.b(var1, var2, this.e(), this.f());
         }

         super.a(var1, var2, var3);
      }

      public boolean a(class_aeh var1) {
         return this.c.contains(var1)?false:super.a(var1);
      }

      public void b(class_aeh var1) {
         super.b(var1);
         this.c.add(var1);
      }

      public void a(class_dn var1) {
         super.a(var1);
         class_du var2 = new class_du();
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            class_aeh var4 = (class_aeh)var3.next();
            class_dn var5 = new class_dn();
            var5.a("X", var4.a);
            var5.a("Z", var4.b);
            var2.a((class_eb)var5);
         }

         var1.a((String)"Processed", (class_eb)var2);
      }

      public void b(class_dn var1) {
         super.b(var1);
         if(var1.b("Processed", 9)) {
            class_du var2 = var1.c("Processed", 10);

            for(int var3 = 0; var3 < var2.c(); ++var3) {
               class_dn var4 = var2.b(var3);
               this.c.add(new class_aeh(var4.g("X"), var4.g("Z")));
            }
         }

      }
   }
}
