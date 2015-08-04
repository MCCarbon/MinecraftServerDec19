package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class class_asg extends class_ask {
   private static final List d;
   private List f;
   private int g;
   private int h;

   public class_asg() {
      this.f = Lists.newArrayList();
      this.g = 32;
      this.h = 8;
      this.f.add(new BiomeBase.class_c_in_class_aez(EntityWitch.class, 1, 1, 1));
   }

   public class_asg(Map var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("distance")) {
            this.g = MathHelper.max((String)var3.getValue(), this.g, this.h + 1);
         }
      }

   }

   public String a() {
      return "Temple";
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
      Random var7 = this.c.a(var5, var6, 14357617);
      var5 *= this.g;
      var6 *= this.g;
      var5 += var7.nextInt(this.g - this.h);
      var6 += var7.nextInt(this.g - this.h);
      if(var3 == var5 && var4 == var6) {
         BiomeBase var8 = this.c.w().a(new BlockPosition(var3 * 16 + 8, 0, var4 * 16 + 8));
         if(var8 == null) {
            return false;
         }

         Iterator var9 = d.iterator();

         while(var9.hasNext()) {
            BiomeBase var10 = (BiomeBase)var9.next();
            if(var8 == var10) {
               return true;
            }
         }
      }

      return false;
   }

   protected class_aso b(int var1, int var2) {
      return new class_asg.class_a_in_class_asg(this.c, this.b, var1, var2);
   }

   public boolean a(BlockPosition var1) {
      class_aso var2 = this.c(var1);
      if(var2 != null && var2 instanceof class_asg.class_a_in_class_asg && !var2.a.isEmpty()) {
         class_asn var3 = (class_asn)var2.a.get(0);
         return var3 instanceof class_ash.class_d_in_class_ash;
      } else {
         return false;
      }
   }

   public List b() {
      return this.f;
   }

   static {
      d = Arrays.asList(new BiomeBase[]{BiomeBase.r, BiomeBase.G, BiomeBase.K, BiomeBase.L, BiomeBase.v});
   }

   public static class class_a_in_class_asg extends class_aso {
      public class_a_in_class_asg() {
      }

      public class_a_in_class_asg(World var1, Random var2, int var3, int var4) {
         this(var1, var2, var3, var4, var1.b(new BlockPosition(var3 * 16 + 8, 0, var4 * 16 + 8)));
      }

      public class_a_in_class_asg(World var1, Random var2, int var3, int var4, BiomeBase var5) {
         super(var3, var4);
         if(var5 != BiomeBase.K && var5 != BiomeBase.L) {
            if(var5 == BiomeBase.v) {
               class_ash.class_d_in_class_ash var7 = new class_ash.class_d_in_class_ash(var2, var3 * 16, var4 * 16);
               this.a.add(var7);
            } else if(var5 == BiomeBase.r || var5 == BiomeBase.G) {
               class_ash.class_a_in_class_ash var8 = new class_ash.class_a_in_class_ash(var2, var3 * 16, var4 * 16);
               this.a.add(var8);
            }
         } else {
            class_ash.class_b_in_class_ash var6 = new class_ash.class_b_in_class_ash(var2, var3 * 16, var4 * 16);
            this.a.add(var6);
         }

         this.d();
      }
   }
}
