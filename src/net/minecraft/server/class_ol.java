package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.IInventory;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityItem;

public class class_ol {
   private static final Random a = new Random();

   public static void a(World var0, BlockPosition var1, IInventory var2) {
      a(var0, (double)var1.getX(), (double)var1.getY(), (double)var1.getZ(), var2);
   }

   public static void a(World var0, Entity var1, IInventory var2) {
      a(var0, var1.s, var1.t, var1.u, var2);
   }

   private static void a(World var0, double var1, double var3, double var5, IInventory var7) {
      for(int var8 = 0; var8 < var7.getSize(); ++var8) {
         ItemStack var9 = var7.getItem(var8);
         if(var9 != null) {
            a(var0, var1, var3, var5, var9);
         }
      }

   }

   private static void a(World var0, double var1, double var3, double var5, ItemStack var7) {
      float var8 = a.nextFloat() * 0.8F + 0.1F;
      float var9 = a.nextFloat() * 0.8F + 0.1F;
      float var10 = a.nextFloat() * 0.8F + 0.1F;

      while(var7.count > 0) {
         int var11 = a.nextInt(21) + 10;
         if(var11 > var7.count) {
            var11 = var7.count;
         }

         var7.count -= var11;
         EntityItem var12 = new EntityItem(var0, var1 + (double)var8, var3 + (double)var9, var5 + (double)var10, new ItemStack(var7.getItem(), var11, var7.i()));
         if(var7.hasTag()) {
            var12.l().setTag((NBTTagCompound)var7.getTag().clone());
         }

         float var13 = 0.05F;
         var12.v = a.nextGaussian() * (double)var13;
         var12.motY = a.nextGaussian() * (double)var13 + 0.20000000298023224D;
         var12.x = a.nextGaussian() * (double)var13;
         var0.addEntity((Entity)var12);
      }

   }
}
