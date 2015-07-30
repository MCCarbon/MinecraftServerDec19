package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.server.World;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_ash;
import net.minecraft.server.class_ask;
import net.minecraft.server.class_asn;
import net.minecraft.server.class_aso;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_wq;

public class class_asg extends class_ask {
   private static final List d;
   private List f;
   private int g;
   private int h;

   public class_asg() {
      this.f = Lists.newArrayList();
      this.g = 32;
      this.h = 8;
      this.f.add(new class_aez.class_c_in_class_aez(class_wq.class, 1, 1, 1));
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
         class_aez var8 = this.c.w().a(new BlockPosition(var3 * 16 + 8, 0, var4 * 16 + 8));
         if(var8 == null) {
            return false;
         }

         Iterator var9 = d.iterator();

         while(var9.hasNext()) {
            class_aez var10 = (class_aez)var9.next();
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
         class_asn var3 = (class_asn)var2.a.getFirst();
         return var3 instanceof class_ash.class_d_in_class_ash;
      } else {
         return false;
      }
   }

   public List b() {
      return this.f;
   }

   static {
      d = Arrays.asList(new class_aez[]{class_aez.r, class_aez.G, class_aez.K, class_aez.L, class_aez.v});
   }

   public static class class_a_in_class_asg extends class_aso {
      public class_a_in_class_asg() {
      }

      public class_a_in_class_asg(World var1, Random var2, int var3, int var4) {
         this(var1, var2, var3, var4, var1.b(new BlockPosition(var3 * 16 + 8, 0, var4 * 16 + 8)));
      }

      public class_a_in_class_asg(World var1, Random var2, int var3, int var4, class_aez var5) {
         super(var3, var4);
         if(var5 != class_aez.K && var5 != class_aez.L) {
            if(var5 == class_aez.v) {
               class_ash.class_d_in_class_ash var7 = new class_ash.class_d_in_class_ash(var2, var3 * 16, var4 * 16);
               this.a.add(var7);
            } else if(var5 == class_aez.r || var5 == class_aez.G) {
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
