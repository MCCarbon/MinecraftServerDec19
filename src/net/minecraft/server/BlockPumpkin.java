package net.minecraft.server;

import com.google.common.base.Predicate;

public class BlockPumpkin extends BlockDirectional {
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

   protected BlockPumpkin() {
      super(Material.PUMPKIN, MaterialMapColor.COLOR16);
      this.setBlockData(this.blockStateList.getFirst().set(FACING, EnumDirection.NORTH));
      this.setTicking(true);
      this.setCreativeTab(CreativeTab.BUILDING_BLOCKS);
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      super.onPlace(var1, var2, var3);
      this.f(var1, var2);
   }

   public boolean e(World var1, BlockPosition var2) {
      return this.l().a(var1, var2) != null || this.o().a(var1, var2) != null;
   }

   private void f(World var1, BlockPosition var2) {
      class_anp.class_b_in_class_anp var3;
      int var4;
      int var6;
      if((var3 = this.n().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.n().b(); ++var4) {
            class_ano var5 = var3.a(0, var4, 0);
            var1.setTypeAndData((BlockPosition)var5.d(), (IBlockData)Blocks.AIR.getBlockData(), 2);
         }

         EntitySnowman var9 = new EntitySnowman(var1);
         BlockPosition var10 = var3.a(0, 2, 0).d();
         var9.b((double)var10.getX() + 0.5D, (double)var10.getY() + 0.05D, (double)var10.getZ() + 0.5D, 0.0F, 0.0F);
         var1.addEntity((Entity)var9);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.addParticle(EnumParticle.G, (double)var10.getX() + var1.random.nextDouble(), (double)var10.getY() + var1.random.nextDouble() * 2.5D, (double)var10.getZ() + var1.random.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
         }

         for(var6 = 0; var6 < this.n().b(); ++var6) {
            class_ano var7 = var3.a(0, var6, 0);
            var1.update(var7.d(), Blocks.AIR);
         }
      } else if((var3 = this.p().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.p().c(); ++var4) {
            for(int var12 = 0; var12 < this.p().b(); ++var12) {
               var1.setTypeAndData((BlockPosition)var3.a(var4, var12, 0).d(), (IBlockData)Blocks.AIR.getBlockData(), 2);
            }
         }

         BlockPosition var11 = var3.a(1, 2, 0).d();
         EntityVillagerGolem var13 = new EntityVillagerGolem(var1);
         var13.m(true);
         var13.b((double)var11.getX() + 0.5D, (double)var11.getY() + 0.05D, (double)var11.getZ() + 0.5D, 0.0F, 0.0F);
         var1.addEntity((Entity)var13);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.addParticle(EnumParticle.F, (double)var11.getX() + var1.random.nextDouble(), (double)var11.getY() + var1.random.nextDouble() * 3.9D, (double)var11.getZ() + var1.random.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
         }

         for(var6 = 0; var6 < this.p().c(); ++var6) {
            for(int var14 = 0; var14 < this.p().b(); ++var14) {
               class_ano var8 = var3.a(var6, var14, 0);
               var1.update(var8.d(), Blocks.AIR);
            }
         }
      }

   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return var1.getType(var2).getBlock().material.isReplaceable() && World.a((IBlockAccess)var1, (BlockPosition)var2.down());
   }

   public IBlockData a(IBlockData var1, Block.EnumRotation var2) {
      return var1.getBlock() != this?var1:var1.set(FACING, var2.a((EnumDirection)var1.get(FACING)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(FACING)));
   }

   public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.getBlockData().set(FACING, var8.aR().opposite());
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(FACING, EnumDirection.getByHorizontalId(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumDirection)var1.get(FACING)).getHorizontalId();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{FACING});
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
