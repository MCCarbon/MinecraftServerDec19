package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahj;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CreativeTab;

public class class_ajj extends Block {
   public static final class_anw a = class_anw.a("snowy");

   protected class_ajj() {
      super(Material.GRASS, MaterialMapColor.COLOR25);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
      this.setTicking(true);
      this.a(CreativeTab.b);
   }

   public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
      Block var4 = var2.p(var3.shiftUp()).getBlock();
      return var1.set(a, Boolean.valueOf(var4 == Blocks.SNOW || var4 == Blocks.SNOW_LAYER));
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         if(var1.l(var2.shiftUp()) < 4 && var1.p(var2.shiftUp()).getBlock().getLightOpacity() > 2) {
            var1.a(var2, Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.a));
         } else {
            if(var1.l(var2.shiftUp()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  BlockPosition var6 = var2.add(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
                  IBlockData var7 = var1.p(var6);
                  Block var8 = var1.p(var6.shiftUp()).getBlock();
                  if(var7.getBlock() == Blocks.DIRT && var7.get(class_ahj.a) == class_ahj.class_a_in_class_ahj.a && var1.l(var6.shiftUp()) >= 4 && var8.getLightOpacity() <= 2) {
                     var1.a(var6, this.getBlockData());
                  }
               }
            }

         }
      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Blocks.DIRT.getDropType(Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.a), var2, var3);
   }

   public int toLegacyData(IBlockData var1) {
      return 0;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
