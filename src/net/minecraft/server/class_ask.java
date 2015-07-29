package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.server.class_aeh;
import net.minecraft.server.World;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apn;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asl;
import net.minecraft.server.class_asm;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_aso;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_df;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_e;
import net.minecraft.server.class_eb;

public abstract class class_ask extends class_apn {
   private class_asm d;
   protected Map e = Maps.newHashMap();

   public abstract String a();

   protected final synchronized void a(World var1, final int var2, final int var3, int var4, int var5, class_aph var6) {
      this.a(var1);
      if(!this.e.containsKey(Long.valueOf(class_aeh.a(var2, var3)))) {
         this.b.nextInt();

         try {
            if(this.a(var2, var3)) {
               class_aso var7 = this.b(var2, var3);
               this.e.put(Long.valueOf(class_aeh.a(var2, var3)), var7);
               if(var7.a()) {
                  this.a(var2, var3, var7);
               }
            }

         } catch (Throwable var10) {
            class_b var8 = class_b.a(var10, "Exception preparing structure feature");
            class_c var9 = var8.a("Feature being prepared");
            var9.a("Is feature chunk", new Callable() {
               public String a() throws Exception {
                  return class_ask.this.a(var2, var3)?"True":"False";
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            var9.a((String)"Chunk location", (Object)String.format("%d,%d", new Object[]{Integer.valueOf(var2), Integer.valueOf(var3)}));
            var9.a("Chunk pos hash", new Callable() {
               public String a() throws Exception {
                  return String.valueOf(class_aeh.a(var2, var3));
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            var9.a("Structure type", new Callable() {
               public String a() throws Exception {
                  return class_ask.this.getClass().getCanonicalName();
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new class_e(var8);
         }
      }
   }

   public synchronized boolean a(World var1, Random var2, class_aeh var3) {
      this.a(var1);
      int var4 = (var3.a << 4) + 8;
      int var5 = (var3.b << 4) + 8;
      boolean var6 = false;
      Iterator var7 = this.e.values().iterator();

      while(var7.hasNext()) {
         class_aso var8 = (class_aso)var7.next();
         if(var8.a() && var8.a(var3) && var8.b().a(var4, var5, var4 + 15, var5 + 15)) {
            var8.a(var1, var2, new class_arw(var4, var5, var4 + 15, var5 + 15));
            var8.b(var3);
            var6 = true;
            this.a(var8.e(), var8.f(), var8);
         }
      }

      return var6;
   }

   public boolean b(class_cj var1) {
      this.a(this.c);
      return this.c(var1) != null;
   }

   protected class_aso c(class_cj var1) {
      Iterator var2 = this.e.values().iterator();

      while(true) {
         class_aso var3;
         do {
            do {
               if(!var2.hasNext()) {
                  return null;
               }

               var3 = (class_aso)var2.next();
            } while(!var3.a());
         } while(!var3.b().b((class_df)var1));

         Iterator var4 = var3.c().iterator();

         while(var4.hasNext()) {
            class_asn var5 = (class_asn)var4.next();
            if(var5.c().b((class_df)var1)) {
               return var3;
            }
         }
      }
   }

   public boolean a(World var1, class_cj var2) {
      this.a(var1);
      Iterator var3 = this.e.values().iterator();

      class_aso var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (class_aso)var3.next();
      } while(!var4.a() || !var4.b().b((class_df)var2));

      return true;
   }

   public class_cj b(World var1, class_cj var2) {
      this.c = var1;
      this.a(var1);
      this.b.setSeed(var1.K());
      long var3 = this.b.nextLong();
      long var5 = this.b.nextLong();
      long var7 = (long)(var2.n() >> 4) * var3;
      long var9 = (long)(var2.p() >> 4) * var5;
      this.b.setSeed(var7 ^ var9 ^ var1.K());
      this.a(var1, var2.n() >> 4, var2.p() >> 4, 0, 0, (class_aph)null);
      double var11 = Double.MAX_VALUE;
      class_cj var13 = null;
      Iterator var14 = this.e.values().iterator();

      class_cj var17;
      double var18;
      while(var14.hasNext()) {
         class_aso var15 = (class_aso)var14.next();
         if(var15.a()) {
            class_asn var16 = (class_asn)var15.c().get(0);
            var17 = var16.a();
            var18 = var17.i(var2);
            if(var18 < var11) {
               var11 = var18;
               var13 = var17;
            }
         }
      }

      if(var13 != null) {
         return var13;
      } else {
         List var20 = this.A_();
         if(var20 != null) {
            class_cj var21 = null;
            Iterator var22 = var20.iterator();

            while(var22.hasNext()) {
               var17 = (class_cj)var22.next();
               var18 = var17.i(var2);
               if(var18 < var11) {
                  var11 = var18;
                  var21 = var17;
               }
            }

            return var21;
         } else {
            return null;
         }
      }
   }

   protected List A_() {
      return null;
   }

   private void a(World var1) {
      if(this.d == null) {
         this.d = (class_asm)var1.a(class_asm.class, this.a());
         if(this.d == null) {
            this.d = new class_asm(this.a());
            var1.a((String)this.a(), (class_avd)this.d);
         } else {
            class_dn var2 = this.d.a();
            Iterator var3 = var2.c().iterator();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               class_eb var5 = var2.b(var4);
               if(var5.a() == 10) {
                  class_dn var6 = (class_dn)var5;
                  if(var6.d("ChunkX") && var6.d("ChunkZ")) {
                     int var7 = var6.g("ChunkX");
                     int var8 = var6.g("ChunkZ");
                     class_aso var9 = class_asl.a(var6, var1);
                     if(var9 != null) {
                        this.e.put(Long.valueOf(class_aeh.a(var7, var8)), var9);
                     }
                  }
               }
            }
         }
      }

   }

   private void a(int var1, int var2, class_aso var3) {
      this.d.a(var3.a(var1, var2), var1, var2);
      this.d.c();
   }

   protected abstract boolean a(int var1, int var2);

   protected abstract class_aso b(int var1, int var2);
}
