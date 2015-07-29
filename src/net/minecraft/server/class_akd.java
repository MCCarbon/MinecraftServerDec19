package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_ano;
import net.minecraft.server.class_anp;
import net.minecraft.server.class_anq;
import net.minecraft.server.class_ant;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_uh;
import net.minecraft.server.class_uj;
import net.minecraft.server.CreativeTab;

public class class_akd extends class_aiv {
   private class_anp a;
   private class_anp b;
   private class_anp N;
   private class_anp P;
   private static final Predicate Q = new Predicate() {
      public boolean a(IBlockData var1) {
         return var1 != null && (var1.getBlock() == Blocks.PUMPKIN || var1.getBlock() == Blocks.LIT_PUMPKIN);
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((IBlockData)var1);
      }
   };

   protected class_akd() {
      super(Material.C, MaterialMapColor.q);
      this.setBlockData(this.blockStateList.getFirst().set(O, class_cq.c));
      this.setTicking(true);
      this.a(CreativeTab.b);
   }

   public void c(World var1, class_cj var2, IBlockData var3) {
      super.c(var1, var2, var3);
      this.f(var1, var2);
   }

   public boolean e(World var1, class_cj var2) {
      return this.l().a(var1, var2) != null || this.o().a(var1, var2) != null;
   }

   private void f(World var1, class_cj var2) {
      class_anp.class_b_in_class_anp var3;
      int var4;
      int var6;
      if((var3 = this.n().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.n().b(); ++var4) {
            class_ano var5 = var3.a(0, var4, 0);
            var1.a((class_cj)var5.d(), (IBlockData)Blocks.AIR.getBlockData(), 2);
         }

         class_uh var9 = new class_uh(var1);
         class_cj var10 = var3.a(0, 2, 0).d();
         var9.b((double)var10.n() + 0.5D, (double)var10.o() + 0.05D, (double)var10.p() + 0.5D, 0.0F, 0.0F);
         var1.a((class_pr)var9);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.a(class_cy.G, (double)var10.n() + var1.s.nextDouble(), (double)var10.o() + var1.s.nextDouble() * 2.5D, (double)var10.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
         }

         for(var6 = 0; var6 < this.n().b(); ++var6) {
            class_ano var7 = var3.a(0, var6, 0);
            var1.b(var7.d(), Blocks.AIR);
         }
      } else if((var3 = this.p().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.p().c(); ++var4) {
            for(int var12 = 0; var12 < this.p().b(); ++var12) {
               var1.a((class_cj)var3.a(var4, var12, 0).d(), (IBlockData)Blocks.AIR.getBlockData(), 2);
            }
         }

         class_cj var11 = var3.a(1, 2, 0).d();
         class_uj var13 = new class_uj(var1);
         var13.m(true);
         var13.b((double)var11.n() + 0.5D, (double)var11.o() + 0.05D, (double)var11.p() + 0.5D, 0.0F, 0.0F);
         var1.a((class_pr)var13);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.a(class_cy.F, (double)var11.n() + var1.s.nextDouble(), (double)var11.o() + var1.s.nextDouble() * 3.9D, (double)var11.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
         }

         for(var6 = 0; var6 < this.p().c(); ++var6) {
            for(int var14 = 0; var14 < this.p().b(); ++var14) {
               class_ano var8 = var3.a(var6, var14, 0);
               var1.b(var8.d(), Blocks.AIR);
            }
         }
      }

   }

   public boolean d(World var1, class_cj var2) {
      return var1.p(var2).getBlock().material.j() && World.a((class_aer)var1, (class_cj)var2.b());
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(O, var2.a((class_cq)var1.get(O)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((class_cq)var1.get(O)));
   }

   public IBlockData a(World var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(O, var8.aR().d());
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(O, class_cq.b(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_cq)var1.get(O)).b();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{O});
   }

   protected class_anp l() {
      if(this.a == null) {
         this.a = class_anq.a().a(new String[]{" ", "#", "#"}).a('#', class_ano.a(class_ant.a(Blocks.SNOW))).b();
      }

      return this.a;
   }

   protected class_anp n() {
      if(this.b == null) {
         this.b = class_anq.a().a(new String[]{"^", "#", "#"}).a('^', class_ano.a(Q)).a('#', class_ano.a(class_ant.a(Blocks.SNOW))).b();
      }

      return this.b;
   }

   protected class_anp o() {
      if(this.N == null) {
         this.N = class_anq.a().a(new String[]{"~ ~", "###", "~#~"}).a('#', class_ano.a(class_ant.a(Blocks.IRON_BLOCK))).a('~', class_ano.a(class_ant.a(Blocks.AIR))).b();
      }

      return this.N;
   }

   protected class_anp p() {
      if(this.P == null) {
         this.P = class_anq.a().a(new String[]{"~^~", "###", "~#~"}).a('^', class_ano.a(Q)).a('#', class_ano.a(class_ant.a(Blocks.IRON_BLOCK))).a('~', class_ano.a(class_ant.a(Blocks.AIR))).b();
      }

      return this.P;
   }
}
