package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahi;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_ahu extends class_ahi {
   protected class_ahu() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(b, EnumDirection.UP));
      this.a(CreativeTab.c);
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(b, var2.a((EnumDirection)var1.get(b)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(b, var2.b((EnumDirection)var1.get(b)));
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      EnumDirection var4 = (EnumDirection)var3.get(b);
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      return var4 != EnumDirection.EAST && var4 != EnumDirection.WEST?(var4 != EnumDirection.SOUTH && var4 != EnumDirection.NORTH?new class_awf((double)((float)var2.getX() + var5), (double)(var2.getY() + 0), (double)((float)var2.getZ() + var5), (double)((float)var2.getX() + var6), (double)(var2.getY() + 1), (double)((float)var2.getZ() + var6)):new class_awf((double)((float)var2.getX() + var5), (double)((float)var2.getY() + var5), (double)(var2.getZ() + 0), (double)((float)var2.getX() + var6), (double)((float)var2.getY() + var6), (double)(var2.getZ() + 1))):new class_awf((double)(var2.getX() + 0), (double)((float)var2.getY() + var5), (double)((float)var2.getZ() + var5), (double)(var2.getX() + 1), (double)((float)var2.getY() + var6), (double)((float)var2.getZ() + var6));
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean d(World var1, BlockPosition var2) {
      Iterator var3 = b.c().iterator();

      EnumDirection var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (EnumDirection)var3.next();
      } while(!this.a(var1, var2, var4));

      return true;
   }

   private boolean a(World var1, BlockPosition var2, EnumDirection var3) {
      return true;
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      IBlockData var9 = var1.p(var2.shift(var3.getOpposite()));
      if(var9.getBlock() == Blocks.END_ROD) {
         EnumDirection var10 = (EnumDirection)var9.get(b);
         System.out.println("hslsdjfksdlk");
         if(var10 == var3) {
            return this.getBlockData().set(b, var3.getOpposite());
         }
      }

      return this.getBlockData().set(b, var3);
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
   }

   public class_awg a(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
      EnumDirection var5 = (EnumDirection)var1.p(var2).get(b);
      float var6 = 0.375F;
      float var7 = 0.625F;
      if(var5 != EnumDirection.EAST && var5 != EnumDirection.WEST) {
         if(var5 != EnumDirection.SOUTH && var5 != EnumDirection.NORTH) {
            this.setSizes(var6, 0.0F, var6, var7, 1.0F, var7);
         } else {
            this.setSizes(var6, var6, 0.0F, var7, var7, 1.0F);
         }
      } else {
         this.setSizes(0.0F, var6, var6, 1.0F, var7, var7);
      }

      return super.a(var1, var2, var3, var4);
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData();
      var2 = var2.set(b, EnumDirection.getById(var1));
      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumDirection)var1.get(b)).getId();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b});
   }

   public int getPushReaction() {
      return 0;
   }
}
