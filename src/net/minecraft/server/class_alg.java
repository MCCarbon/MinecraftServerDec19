package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ago;
import net.minecraft.server.class_ahd;
import net.minecraft.server.class_alp;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nu;
import net.minecraft.server.CreativeTab;

public class class_alg extends class_ago implements class_agl {
   public static final class_anz a = class_anz.a("age", 0, 7);
   public static final class_anx b;
   private final Block N;

   protected class_alg(Block var1) {
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)).set(b, class_cq.b));
      this.N = var1;
      this.setTicking(true);
      float var2 = 0.125F;
      this.setSizes(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
      this.a((CreativeTab)null);
   }

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      var1 = var1.set(b, class_cq.b);
      Iterator var4 = class_cq.class_c_in_class_cq.a.iterator();

      while(var4.hasNext()) {
         class_cq var5 = (class_cq)var4.next();
         if(var2.p(var3.a(var5)).getBlock() == this.N) {
            var1 = var1.set(b, var5);
            break;
         }
      }

      return var1;
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.FARMLAND;
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.l(var2.a()) >= 9) {
         float var5 = class_ahd.a(this, var1, var2);
         if(var4.nextInt((int)(25.0F / var5) + 1) == 0) {
            int var6 = ((Integer)var3.get(a)).intValue();
            if(var6 < 7) {
               var3 = var3.set(a, Integer.valueOf(var6 + 1));
               var1.a((class_cj)var2, (IBlockData)var3, 2);
            } else {
               Iterator var7 = class_cq.class_c_in_class_cq.a.iterator();

               while(var7.hasNext()) {
                  class_cq var8 = (class_cq)var7.next();
                  if(var1.p(var2.a(var8)).getBlock() == this.N) {
                     return;
                  }
               }

               var2 = var2.a(class_cq.class_c_in_class_cq.a.a(var4));
               Block var9 = var1.p(var2.b()).getBlock();
               if(var1.p(var2).getBlock().material == Material.a && (var9 == Blocks.FARMLAND || var9 == Blocks.DIRT || var9 == Blocks.GRASS)) {
                  var1.a(var2, this.N.getBlockData());
               }
            }
         }

      }
   }

   public void g(World var1, class_cj var2, IBlockData var3) {
      int var4 = ((Integer)var3.get(a)).intValue() + class_nu.a((Random)var1.s, 2, 5);
      var1.a((class_cj)var2, (IBlockData)var3.set(a, Integer.valueOf(Math.min(7, var4))), 2);
   }

   public void j() {
      float var1 = 0.125F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
   }

   public void a(class_aer var1, class_cj var2) {
      this.maxY = (double)((float)(((Integer)var1.p(var2).get(a)).intValue() * 2 + 2) / 16.0F);
      float var3 = 0.125F;
      this.setSizes(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, (float)this.maxY, 0.5F + var3);
   }

   public void a(World var1, class_cj var2, IBlockData var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(!var1.D) {
         Item var6 = this.l();
         if(var6 != null) {
            int var7 = ((Integer)var3.get(a)).intValue();

            for(int var8 = 0; var8 < 3; ++var8) {
               if(var1.s.nextInt(15) <= var7) {
                  a(var1, var2, new class_aas(var6));
               }
            }

         }
      }
   }

   protected Item l() {
      return this.N == Blocks.PUMPKIN?Items.bi:(this.N == Blocks.MELON_BLOCK?Items.bj:null);
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public boolean a(World var1, class_cj var2, IBlockData var3, boolean var4) {
      return ((Integer)var3.get(a)).intValue() != 7;
   }

   public boolean a(World var1, Random var2, class_cj var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, class_cj var3, IBlockData var4) {
      this.g(var1, var3, var4);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Integer.valueOf(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Integer)var1.get(a)).intValue();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b});
   }

   static {
      b = class_alp.a;
   }
}
