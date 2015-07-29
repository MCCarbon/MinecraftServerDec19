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
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_qa;
import net.minecraft.server.CreativeTab;

public class class_ahu extends class_ahi {
   protected class_ahu() {
      super(Material.q);
      this.setBlockData(this.blockStateList.getFirst().set(b, class_cq.b));
      this.a(CreativeTab.c);
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(b, var2.a((class_cq)var1.get(b)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(b, var2.b((class_cq)var1.get(b)));
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      class_cq var4 = (class_cq)var3.get(b);
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      return var4 != class_cq.f && var4 != class_cq.e?(var4 != class_cq.d && var4 != class_cq.c?new class_awf((double)((float)var2.n() + var5), (double)(var2.o() + 0), (double)((float)var2.p() + var5), (double)((float)var2.n() + var6), (double)(var2.o() + 1), (double)((float)var2.p() + var6)):new class_awf((double)((float)var2.n() + var5), (double)((float)var2.o() + var5), (double)(var2.p() + 0), (double)((float)var2.n() + var6), (double)((float)var2.o() + var6), (double)(var2.p() + 1))):new class_awf((double)(var2.n() + 0), (double)((float)var2.o() + var5), (double)((float)var2.p() + var5), (double)(var2.n() + 1), (double)((float)var2.o() + var6), (double)((float)var2.p() + var6));
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean d(World var1, class_cj var2) {
      Iterator var3 = b.c().iterator();

      class_cq var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (class_cq)var3.next();
      } while(!this.a(var1, var2, var4));

      return true;
   }

   private boolean a(World var1, class_cj var2, class_cq var3) {
      return true;
   }

   public IBlockData a(World var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      IBlockData var9 = var1.p(var2.a(var3.d()));
      if(var9.getBlock() == Blocks.END_ROD) {
         class_cq var10 = (class_cq)var9.get(b);
         System.out.println("hslsdjfksdlk");
         if(var10 == var3) {
            return this.getBlockData().set(b, var3.d());
         }
      }

      return this.getBlockData().set(b, var3);
   }

   public void c(World var1, class_cj var2, IBlockData var3) {
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
   }

   public class_awg a(World var1, class_cj var2, class_awh var3, class_awh var4) {
      class_cq var5 = (class_cq)var1.p(var2).get(b);
      float var6 = 0.375F;
      float var7 = 0.625F;
      if(var5 != class_cq.f && var5 != class_cq.e) {
         if(var5 != class_cq.d && var5 != class_cq.c) {
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
      var2 = var2.set(b, class_cq.a(var1));
      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_cq)var1.get(b)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b});
   }

   public int k() {
      return 0;
   }
}
