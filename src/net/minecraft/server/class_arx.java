package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apq;
import net.minecraft.server.class_ary;
import net.minecraft.server.class_ask;
import net.minecraft.server.class_aso;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;

public class class_arx extends class_ask {
   private int d = 20;
   private int f = 11;
   private final class_apq g;

   public class_arx(class_apq var1) {
      this.g = var1;
   }

   public String a() {
      return "EndCity";
   }

   protected boolean a(int var1, int var2) {
      int var3 = var1;
      int var4 = var2;
      if(var1 < 0) {
         var1 -= this.d - 1;
      }

      if(var2 < 0) {
         var2 -= this.d - 1;
      }

      int var5 = var1 / this.d;
      int var6 = var2 / this.d;
      Random var7 = this.c.a(var5, var6, 10387313);
      var5 *= this.d;
      var6 *= this.d;
      var5 += (var7.nextInt(this.d - this.f) + var7.nextInt(this.d - this.f)) / 2;
      var6 += (var7.nextInt(this.d - this.f) + var7.nextInt(this.d - this.f)) / 2;
      return var3 == var5 && var4 == var6 && this.g.b(var3, var4);
   }

   protected class_aso b(int var1, int var2) {
      return new class_arx.class_a_in_class_arx(this.c, this.g, this.b, var1, var2);
   }

   public static class class_a_in_class_arx extends class_aso {
      private boolean c;

      public class_a_in_class_arx() {
      }

      public class_a_in_class_arx(World var1, class_apq var2, Random var3, int var4, int var5) {
         super(var4, var5);
         this.a(var1, var2, var3, var4, var5);
      }

      private void a(World var1, class_apq var2, Random var3, int var4, int var5) {
         Block.EnumRotation var6 = Block.EnumRotation.values()[var3.nextInt(Block.EnumRotation.values().length)];
         class_aph var7 = new class_aph();
         var2.a(var4, var5, var7);
         byte var8 = 5;
         byte var9 = 5;
         if(var6 == Block.EnumRotation.CLOCKWISE_90) {
            var8 = -5;
         } else if(var6 == Block.EnumRotation.CLOCKWISE_180) {
            var8 = -5;
            var9 = -5;
         } else if(var6 == Block.EnumRotation.COUNTERCLOCKWISE_90) {
            var9 = -5;
         }

         int var10 = var7.a(7, 7);
         int var11 = var7.a(7, 7 + var9);
         int var12 = var7.a(7 + var8, 7);
         int var13 = var7.a(7 + var8, 7 + var9);
         int var14 = Math.min(Math.min(var10, var11), Math.min(var12, var13));
         if(var14 < 60) {
            this.c = false;
         } else {
            BlockPosition var15 = new BlockPosition(var4 * 16 + 8, var14, var5 * 16 + 8);
            class_ary.a(var15, var6, this.a, var3);
            this.d();
            this.c = true;
         }
      }

      public boolean a() {
         return this.c;
      }

      public void a(NBTTagCompound var1) {
         super.a(var1);
      }

      public void b(NBTTagCompound var1) {
         super.b(var1);
      }
   }
}
