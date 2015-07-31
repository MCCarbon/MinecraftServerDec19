package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cy;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class class_akj extends Block {
   private final boolean a;

   public class_akj(boolean var1) {
      super(Material.STONE);
      if(var1) {
         this.setTicking(true);
      }

      this.a = var1;
   }

   public int a(World var1) {
      return 30;
   }

   public void a(World var1, BlockPosition var2, class_xa var3) {
      this.e(var1, var2);
      super.a(var1, var2, var3);
   }

   public void a(World var1, BlockPosition var2, class_pr var3) {
      this.e(var1, var2);
      super.a(var1, var2, var3);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      this.e(var1, var2);
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   private void e(World var1, BlockPosition var2) {
      this.f(var1, var2);
      if(this == Blocks.REDSTONE_ORE) {
         var1.a(var2, Blocks.LIT_REDSTONE_ORE.getBlockData());
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(this == Blocks.LIT_REDSTONE_ORE) {
         var1.a(var2, Blocks.REDSTONE_ORE.getBlockData());
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.aE;
   }

   public int a(int var1, Random var2) {
      return this.a(var2) + var2.nextInt(var1 + 1);
   }

   public int a(Random var1) {
      return 4 + var1.nextInt(2);
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      super.dropNaturally(var1, var2, var3, var4, var5);
      if(this.getDropType(var3, var1.s, var5) != Item.getByBlock((Block)this)) {
         int var6 = 1 + var1.s.nextInt(5);
         this.b(var1, var2, var6);
      }

   }

   private void f(World var1, BlockPosition var2) {
      Random var3 = var1.s;
      double var4 = 0.0625D;

      for(int var6 = 0; var6 < 6; ++var6) {
         double var7 = (double)((float)var2.getX() + var3.nextFloat());
         double var9 = (double)((float)var2.getY() + var3.nextFloat());
         double var11 = (double)((float)var2.getZ() + var3.nextFloat());
         if(var6 == 0 && !var1.p(var2.shiftUp()).getBlock().isOpaqueCube()) {
            var9 = (double)var2.getY() + var4 + 1.0D;
         }

         if(var6 == 1 && !var1.p(var2.shiftDown()).getBlock().isOpaqueCube()) {
            var9 = (double)var2.getY() - var4;
         }

         if(var6 == 2 && !var1.p(var2.shiftSouth()).getBlock().isOpaqueCube()) {
            var11 = (double)var2.getZ() + var4 + 1.0D;
         }

         if(var6 == 3 && !var1.p(var2.shiftNorth()).getBlock().isOpaqueCube()) {
            var11 = (double)var2.getZ() - var4;
         }

         if(var6 == 4 && !var1.p(var2.shiftEast()).getBlock().isOpaqueCube()) {
            var7 = (double)var2.getX() + var4 + 1.0D;
         }

         if(var6 == 5 && !var1.p(var2.shiftWest()).getBlock().isOpaqueCube()) {
            var7 = (double)var2.getX() - var4;
         }

         if(var7 < (double)var2.getX() || var7 > (double)(var2.getX() + 1) || var9 < 0.0D || var9 > (double)(var2.getY() + 1) || var11 < (double)var2.getZ() || var11 > (double)(var2.getZ() + 1)) {
            var1.a(class_cy.E, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

   }

   protected ItemStack i(IBlockData var1) {
      return new ItemStack(Blocks.REDSTONE_ORE);
   }
}
