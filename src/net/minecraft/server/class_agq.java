package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.CreativeTab;

public class class_agq extends Block {
   public static final class_anz a = class_anz.a("age", 0, 15);

   protected class_agq() {
      super(Material.A);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
      this.setTicking(true);
      this.a(CreativeTab.c);
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      class_cj var5 = var2.a();
      if(var1.d(var5)) {
         int var6;
         for(var6 = 1; var1.p(var2.c(var6)).getBlock() == this; ++var6) {
            ;
         }

         if(var6 < 3) {
            int var7 = ((Integer)var3.get(a)).intValue();
            if(var7 == 15) {
               var1.a(var5, this.getBlockData());
               IBlockData var8 = var3.set(a, Integer.valueOf(0));
               var1.a((class_cj)var2, (IBlockData)var8, 4);
               this.a(var1, var5, var8, (Block)this);
            } else {
               var1.a((class_cj)var2, (IBlockData)var3.set(a, Integer.valueOf(var7 + 1)), 4);
            }

         }
      }
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      float var4 = 0.0625F;
      return new class_awf((double)((float)var2.n() + var4), (double)var2.o(), (double)((float)var2.p() + var4), (double)((float)(var2.n() + 1) - var4), (double)((float)(var2.o() + 1) - var4), (double)((float)(var2.p() + 1) - var4));
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean d(World var1, class_cj var2) {
      return super.d(var1, var2)?this.e(var1, var2):false;
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      if(!this.e(var1, var2)) {
         var1.b(var2, true);
      }

   }

   public boolean e(World var1, class_cj var2) {
      Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

      while(var3.hasNext()) {
         class_cq var4 = (class_cq)var3.next();
         if(var1.p(var2.a(var4)).getBlock().getMaterial().a()) {
            return false;
         }
      }

      Block var5 = var1.p(var2.b()).getBlock();
      return var5 == Blocks.CACTUS || var5 == Blocks.SAND;
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_pr var4) {
      var4.a(class_pc.h, 1.0F);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
