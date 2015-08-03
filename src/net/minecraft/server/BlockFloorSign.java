package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_aku;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateInteger;
import net.minecraft.server.IBlockState;
import net.minecraft.server.BlockPosition;

public class BlockFloorSign extends class_aku {
   public static final BlockStateInteger a = BlockStateInteger.of("rotation", 0, 15);

   public BlockFloorSign() {
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
   }

   public void doPhysics(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.getType(var2.down()).getBlock().getMaterial().isBuildable()) {
         this.dropNaturallyForSure(var1, var2, var3, 0);
         var1.setAir(var2);
      }

      super.doPhysics(var1, var2, var3, var4);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(a, Integer.valueOf(var2.a(((Integer)var1.get(a)).intValue(), 16)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, Integer.valueOf(var2.a(((Integer)var1.get(a)).intValue(), 16)));
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
