package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahd;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_alg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;

public class class_ahy extends Block {
   public static final class_anz a = class_anz.a("moisture", 0, 7);

   protected class_ahy() {
      super(Material.EARTH);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.setTicking(true);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.setLightOpacity(255);
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      return new class_awf((double)var2.getX(), (double)var2.getY(), (double)var2.getZ(), (double)(var2.getX() + 1), (double)(var2.getY() + 1), (double)(var2.getZ() + 1));
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      int var5 = ((Integer)var3.get(a)).intValue();
      if(!this.f(var1, var2) && !var1.C(var2.shiftUp())) {
         if(var5 > 0) {
            var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(var5 - 1)), 2);
         } else if(!this.e(var1, var2)) {
            var1.a(var2, Blocks.DIRT.getBlockData());
         }
      } else if(var5 < 7) {
         var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(7)), 2);
      }

   }

   public void a(World var1, BlockPosition var2, class_pr var3, float var4) {
      if(var3 instanceof class_qa) {
         if(!var1.D && var1.s.nextFloat() < var4 - 0.5F) {
            if(!(var3 instanceof class_xa) && !var1.R().b("mobGriefing")) {
               return;
            }

            var1.a(var2, Blocks.DIRT.getBlockData());
         }

         super.a(var1, var2, var3, var4);
      }
   }

   private boolean e(World var1, BlockPosition var2) {
      Block var3 = var1.p(var2.shiftUp()).getBlock();
      return var3 instanceof class_ahd || var3 instanceof class_alg;
   }

   private boolean f(World var1, BlockPosition var2) {
      Iterator var3 = BlockPosition.allInCubeM(var2.add(-4, 0, -4), var2.add(4, 1, 4)).iterator();

      BlockPosition.MutableBlockPosition var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (BlockPosition.MutableBlockPosition)var3.next();
      } while(var1.p(var4).getBlock().getMaterial() != Material.WATER);

      return true;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      super.a(var1, var2, var3, var4);
      if(var1.p(var2.shiftUp()).getBlock().getMaterial().isBuildable()) {
         var1.a(var2, Blocks.DIRT.getBlockData());
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Blocks.DIRT.getDropType(Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.a), var2, var3);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1 & 7));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
