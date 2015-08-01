package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockFluids;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class class_zn extends Item {
   private Block a;

   public class_zn(Block var1) {
      this.h = 1;
      this.a = var1;
      this.a(CreativeTab.MISC);
   }

   public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      boolean var5 = this.a == Blocks.AIR;
      MovingObjectPosition var6 = this.a(var2, var3, var5);
      if(var6 == null) {
         return new class_or(class_oq.b, var1);
      } else {
         if(var6.a == MovingObjectPosition.class_a_in_class_awg.b) {
            BlockPosition var7 = var6.a();
            if(!var2.a(var3, var7)) {
               return new class_or(class_oq.b, var1);
            }

            if(!var5) {
               if(this.a == Blocks.AIR) {
                  return new class_or(class_oq.a, new ItemStack(Items.ay));
               }

               BlockPosition var10 = var7.shift(var6.b);
               if(!var3.a(var10, var6.b, var1)) {
                  return new class_or(class_oq.b, var1);
               }

               if(this.a(var2, var10) && !var3.bH.instabuild) {
                  var3.b(StatisticList.ad[Item.getId((Item)this)]);
                  return new class_or(class_oq.a, new ItemStack(Items.ay));
               }

               return new class_or(class_oq.a, var1);
            }

            if(!var3.a(var7.shift(var6.b), var6.b, var1)) {
               return new class_or(class_oq.b, var1);
            }

            IBlockData var8 = var2.getType(var7);
            Material var9 = var8.getBlock().getMaterial();
            if(var9 == Material.WATER && ((Integer)var8.get(BlockFluids.LEVEL)).intValue() == 0) {
               var2.setAir(var7);
               var3.b(StatisticList.ad[Item.getId((Item)this)]);
               return new class_or(class_oq.a, this.a(var1, var3, Items.az));
            }

            if(var9 == Material.LAVA && ((Integer)var8.get(BlockFluids.LEVEL)).intValue() == 0) {
               var2.setAir(var7);
               var3.b(StatisticList.ad[Item.getId((Item)this)]);
               return new class_or(class_oq.a, this.a(var1, var3, Items.aA));
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }

   private ItemStack a(ItemStack var1, EntityHuman var2, Item var3) {
      if(var2.bH.instabuild) {
         return var1;
      } else if(--var1.count <= 0) {
         return new ItemStack(var3);
      } else {
         if(!var2.bp.a(new ItemStack(var3))) {
            var2.a(new ItemStack(var3), false);
         }

         return var1;
      }
   }

   public boolean a(World var1, BlockPosition var2) {
      if(this.a == Blocks.AIR) {
         return false;
      } else {
         Material var3 = var1.getType(var2).getBlock().getMaterial();
         boolean var4 = !var3.isBuildable();
         if(!var1.isEmpty(var2) && !var4) {
            return false;
         } else {
            if(var1.worldProvider.l() && this.a == Blocks.FLOWING_WATER) {
               int var5 = var2.getX();
               int var6 = var2.getY();
               int var7 = var2.getZ();
               var1.a((double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.random.nextFloat() - var1.random.nextFloat()) * 0.8F);

               for(int var8 = 0; var8 < 8; ++var8) {
                  var1.a(class_cy.m, (double)var5 + Math.random(), (double)var6 + Math.random(), (double)var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
               }
            } else {
               if(!var1.isClientSide && var4 && !var3.isLiquid()) {
                  var1.b(var2, true);
               }

               var1.setTypeAndData((BlockPosition)var2, (IBlockData)this.a.getBlockData(), 3);
            }

            return true;
         }
      }
   }
}
