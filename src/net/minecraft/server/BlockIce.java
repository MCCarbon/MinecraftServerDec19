package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.EnchantmentManager;
import net.minecraft.server.RegistryEnchantments;
import net.minecraft.server.World;
import net.minecraft.server.class_aet;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockHalfTransparent;
import net.minecraft.server.TileEntity;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.StatisticList;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class BlockIce extends BlockHalfTransparent {
   public BlockIce() {
      super(Material.ICE, false);
      this.frictionFactor = 0.98F;
      this.setTicking(true);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public void breakBlockNaturally(World var1, EntityHuman var2, BlockPosition var3, IBlockData var4, TileEntity var5, ItemStack var6) {
      var2.b(StatisticList.ab[Block.getId((Block)this)]);
      var2.applyExhaustion(0.025F);
      if(this.canApplySilkTouch() && EnchantmentManager.getLevel(RegistryEnchantments.q, var6) > 0) {
         ItemStack var9 = this.createItemStack(var4);
         if(var9 != null) {
            dropItem(var1, var3, var9);
         }
      } else {
         if(var1.worldProvider.l()) {
            var1.setAir(var3);
            return;
         }

         int var7 = EnchantmentManager.getLevel(RegistryEnchantments.s, var6);
         this.dropNaturallyForSure(var1, var3, var4, var7);
         Material var8 = var1.getType(var3.down()).getBlock().getMaterial();
         if(var8.isSolid() || var8.isLiquid()) {
            var1.setTypeUpdate(var3, Blocks.FLOWING_WATER.getBlockData());
         }
      }

   }

   public int getDropCount(Random var1) {
      return 0;
   }

   public void tick(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(var1.b(class_aet.b, var2) > 11 - this.getLightOpacity()) {
         if(var1.worldProvider.l()) {
            var1.setAir(var2);
         } else {
            this.dropNaturallyForSure(var1, var2, var1.getType(var2), 0);
            var1.setTypeUpdate(var2, Blocks.WATER.getBlockData());
         }
      }
   }

   public int getPushReaction() {
      return 0;
   }
}
