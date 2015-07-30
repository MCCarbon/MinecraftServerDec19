package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_aet;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aky extends Block {
   public static final class_anz a = class_anz.a("layers", 1, 8);

   protected class_aky() {
      super(Material.PACKED_ICE);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(1)));
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.setTicking(true);
      this.a(CreativeTab.c);
      this.j();
   }

   public boolean isPassable(class_aer var1, BlockPosition var2) {
      return ((Integer)var1.p(var2).get(a)).intValue() < 5;
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      int var4 = ((Integer)var3.get(a)).intValue() - 1;
      float var5 = 0.125F;
      return new class_awf((double)var2.getX() + this.minX, (double)var2.getY() + this.minY, (double)var2.getZ() + this.minZ, (double)var2.getX() + this.maxX, (double)((float)var2.getY() + (float)var4 * var5), (double)var2.getZ() + this.maxZ);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void j() {
      this.b(0);
   }

   public void a(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      this.b(((Integer)var3.get(a)).intValue());
   }

   protected void b(int var1) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, (float)var1 / 8.0F, 1.0F);
   }

   public boolean d(World var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2.shiftDown());
      Block var4 = var3.getBlock();
      return var4 != Blocks.ICE && var4 != Blocks.PACKED_ICE?(var4.getMaterial() == Material.LEAVES?true:(var4 == this && ((Integer)var3.get(a)).intValue() >= 7?true:var4.isOpaqueCube() && var4.material.isSolid())):false;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private boolean e(World var1, BlockPosition var2, IBlockData var3) {
      if(!this.d(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   public void a(World var1, class_xa var2, BlockPosition var3, IBlockData var4, class_amg var5, class_aas var6) {
      a(var1, var3, new class_aas(Items.aF, ((Integer)var4.get(a)).intValue() + 1, 0));
      var1.g(var3);
      var2.b(class_nc.ab[Block.getId((Block)this)]);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.aF;
   }

   public int a(Random var1) {
      return 0;
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(var1.b(class_aet.b, var2) > 11) {
         this.b(var1, var2, var1.p(var2), 0);
         var1.g(var2);
      }

   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf((var1 & 7) + 1));
   }

   public boolean isReplaceable(World var1, BlockPosition var2) {
      return ((Integer)var1.p(var2).get(a)).intValue() == 1;
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue() - 1;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
