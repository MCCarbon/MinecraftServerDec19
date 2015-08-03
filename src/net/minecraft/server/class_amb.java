package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockStepAbstract;
import net.minecraft.server.BlockWood;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.CreativeTab;

public abstract class class_amb extends BlockStepAbstract {
   public static final BlockStateEnum b = BlockStateEnum.of("variant", BlockWood.EnumLogVariant.class);

   public class_amb() {
      super(Material.WOOD);
      IBlockData var1 = this.blockStateList.getFirst();
      if(!this.isDouble()) {
         var1 = var1.set(HALF, BlockStepAbstract.EnumSlabHalf.BOTTOM);
      }

      this.setBlockData(var1.set(b, BlockWood.EnumLogVariant.OAK));
      this.setCreativeTab((CreativeTab)CreativeTab.BUILDING_BLOCKS);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((BlockWood.EnumLogVariant)var1.get(b)).getMapColor();
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf((Block)Blocks.WOODEN_SLAB);
   }

   public String b(int var1) {
      return super.getInternalName() + "." + BlockWood.EnumLogVariant.getById(var1).d();
   }

   public IBlockState getVariant() {
      return b;
   }

   public Object a(ItemStack var1) {
      return BlockWood.EnumLogVariant.getById(var1.i() & 7);
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData().set(b, BlockWood.EnumLogVariant.getById(var1 & 7));
      if(!this.isDouble()) {
         var2 = var2.set(HALF, (var1 & 8) == 0?BlockStepAbstract.EnumSlabHalf.BOTTOM:BlockStepAbstract.EnumSlabHalf.TOP);
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((BlockWood.EnumLogVariant)var1.get(b)).getId();
      if(!this.isDouble() && var1.get(HALF) == BlockStepAbstract.EnumSlabHalf.TOP) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockStateList getStateList() {
      return this.isDouble()?new BlockStateList(this, new IBlockState[]{b}):new BlockStateList(this, new IBlockState[]{HALF, b});
   }

   public int getDropData(IBlockData var1) {
      return ((BlockWood.EnumLogVariant)var1.get(b)).getId();
   }
}
