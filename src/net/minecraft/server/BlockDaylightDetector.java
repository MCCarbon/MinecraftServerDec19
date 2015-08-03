package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.IBlockAccess;
import net.minecraft.server.class_aet;
import net.minecraft.server.BlockContainer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.TileEntity;
import net.minecraft.server.TileEntityLightDetector;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateInteger;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.CreativeTab;

public class BlockDaylightDetector extends BlockContainer {
   public static final BlockStateInteger a = BlockStateInteger.of("power", 0, 15);
   private final boolean b;

   public BlockDaylightDetector(boolean var1) {
      super(Material.WOOD);
      this.b = var1;
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
      this.setCreativeTab(CreativeTab.REDSTONE);
      this.setStrength(0.2F);
      this.setStepSound(STEP_SOUND_WOOD);
      this.setName("daylightDetector");
   }

   public void updateShape(IBlockAccess var1, BlockPosition var2) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
   }

   public int a(IBlockAccess var1, BlockPosition var2, IBlockData var3, EnumDirection var4) {
      return ((Integer)var3.get(a)).intValue();
   }

   public void f(World var1, BlockPosition var2) {
      if(!var1.worldProvider.m()) {
         IBlockData var3 = var1.getType(var2);
         int var4 = var1.b(class_aet.a, var2) - var1.ac();
         float var5 = var1.d(1.0F);
         float var6 = var5 < 3.1415927F?0.0F:6.2831855F;
         var5 += (var6 - var5) * 0.2F;
         var4 = Math.round((float)var4 * MathHelper.cos(var5));
         var4 = MathHelper.clamp(var4, 0, 15);
         if(this.b) {
            var4 = 15 - var4;
         }

         if(((Integer)var3.get(a)).intValue() != var4) {
            var1.setTypeAndData((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(var4)), 3);
         }

      }
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var4.cp()) {
         if(var1.isClientSide) {
            return true;
         } else {
            if(this.b) {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)Blocks.DAYLIGHT_DETECTOR.getBlockData().set(a, var3.get(a)), 4);
               Blocks.DAYLIGHT_DETECTOR.f(var1, var2);
            } else {
               var1.setTypeAndData((BlockPosition)var2, (IBlockData)Blocks.DAYLIGHT_DETECTOR_INVERTED.getBlockData().set(a, var3.get(a)), 4);
               Blocks.DAYLIGHT_DETECTOR_INVERTED.f(var1, var2);
            }

            return true;
         }
      } else {
         return super.interact(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf((Block)Blocks.DAYLIGHT_DETECTOR);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public int getRenderType() {
      return 3;
   }

   public boolean isPowerSource() {
      return true;
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntityLightDetector();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
