package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockFalling;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cy;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityFallingBlock;
import net.minecraft.server.EntityHuman;

public class class_ahn extends Block {
   public class_ahn() {
      super(Material.DRAGON_EGG, MaterialMapColor.COLOR30);
      this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      var1.a((BlockPosition)var2, (Block)this, this.tickInterval(var1));
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      var1.a((BlockPosition)var2, (Block)this, this.tickInterval(var1));
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      this.e(var1, var2);
   }

   private void e(World var1, BlockPosition var2) {
      if(BlockFalling.canFall(var1, var2.down()) && var2.getY() >= 0) {
         byte var3 = 32;
         if(!BlockFalling.instaFall && var1.areChunksLoadedBetween(var2.add(-var3, -var3, -var3), var2.add(var3, var3, var3))) {
            var1.addEntity((Entity)(new EntityFallingBlock(var1, (double)((float)var2.getX() + 0.5F), (double)var2.getY(), (double)((float)var2.getZ() + 0.5F), this.getBlockData())));
         } else {
            var1.setAir(var2);

            BlockPosition var4;
            for(var4 = var2; BlockFalling.canFall(var1, var4) && var4.getY() > 0; var4 = var4.down()) {
               ;
            }

            if(var4.getY() > 0) {
               var1.setTypeAndData((BlockPosition)var4, (IBlockData)this.getBlockData(), 2);
            }
         }

      }
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      this.f(var1, var2);
      return true;
   }

   public void attack(World var1, BlockPosition var2, EntityHuman var3) {
      this.f(var1, var2);
   }

   private void f(World var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      if(var3.getBlock() == this) {
         for(int var4 = 0; var4 < 1000; ++var4) {
            BlockPosition var5 = var2.add(var1.random.nextInt(16) - var1.random.nextInt(16), var1.random.nextInt(8) - var1.random.nextInt(8), var1.random.nextInt(16) - var1.random.nextInt(16));
            if(var1.getType(var5).getBlock().material == Material.AIR) {
               if(var1.isClientSide) {
                  for(int var6 = 0; var6 < 128; ++var6) {
                     double var7 = var1.random.nextDouble();
                     float var9 = (var1.random.nextFloat() - 0.5F) * 0.2F;
                     float var10 = (var1.random.nextFloat() - 0.5F) * 0.2F;
                     float var11 = (var1.random.nextFloat() - 0.5F) * 0.2F;
                     double var12 = (double)var5.getX() + (double)(var2.getX() - var5.getX()) * var7 + (var1.random.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     double var14 = (double)var5.getY() + (double)(var2.getY() - var5.getY()) * var7 + var1.random.nextDouble() * 1.0D - 0.5D;
                     double var16 = (double)var5.getZ() + (double)(var2.getZ() - var5.getZ()) * var7 + (var1.random.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     var1.a(class_cy.y, var12, var14, var16, (double)var9, (double)var10, (double)var11, new int[0]);
                  }
               } else {
                  var1.setTypeAndData((BlockPosition)var5, (IBlockData)var3, 2);
                  var1.setAir(var2);
               }

               return;
            }
         }

      }
   }

   public int tickInterval(World var1) {
      return 5;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }
}
