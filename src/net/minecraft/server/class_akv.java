package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahi;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amy;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_ano;
import net.minecraft.server.class_anp;
import net.minecraft.server.class_anq;
import net.minecraft.server.class_ant;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cy;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.class_dy;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.class_om;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_uw;
import net.minecraft.server.class_xa;

public class class_akv extends class_agd {
   public static final class_anx a;
   public static final class_anw b;
   private static final Predicate N;
   private class_anp O;
   private class_anp P;

   protected class_akv() {
      super(Material.ORIENTABLE);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, Boolean.valueOf(false)));
      this.setSizes(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
   }

   public String getName() {
      return LocaleI18n.get("tile.skull.skeleton.name");
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void a(class_aer var1, BlockPosition var2) {
      switch(class_akv.SyntheticClass_1.a[((EnumDirection)var1.p(var2).get(a)).ordinal()]) {
      case 1:
      default:
         this.setSizes(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
         break;
      case 2:
         this.setSizes(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
         break;
      case 3:
         this.setSizes(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
         break;
      case 4:
         this.setSizes(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
         break;
      case 5:
         this.setSizes(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
      }

   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      this.a((class_aer)var1, (BlockPosition)var2);
      return super.a(var1, var2, var3);
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(a, var8.aR()).set(b, Boolean.valueOf(false));
   }

   public class_amg a(World var1, int var2) {
      return new class_amy();
   }

   public int j(World var1, BlockPosition var2) {
      class_amg var3 = var1.s(var2);
      return var3 instanceof class_amy?((class_amy)var3).d():super.j(var1, var2);
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_xa var4) {
      if(var4.bH.instabuild) {
         var3 = var3.set(b, Boolean.valueOf(true));
         var1.a((BlockPosition)var2, (IBlockData)var3, 4);
      }

      super.a(var1, var2, var3, var4);
   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.D) {
         if(!((Boolean)var3.get(b)).booleanValue()) {
            class_amg var4 = var1.s(var2);
            if(var4 instanceof class_amy) {
               class_amy var5 = (class_amy)var4;
               ItemStack var6 = new ItemStack(Items.ca, 1, this.j(var1, var2));
               if(var5.d() == 3 && var5.b() != null) {
                  var6.setTag(new NBTTagCompound());
                  NBTTagCompound var7 = new NBTTagCompound();
                  class_dy.a(var7, var5.b());
                  var6.getTag().put((String)"SkullOwner", (NBTTag)var7);
               }

               a(var1, var2, (ItemStack)var6);
            }
         }

         super.b(var1, var2, var3);
      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.ca;
   }

   public boolean b(World var1, BlockPosition var2, ItemStack var3) {
      return var3.i() == 1 && var2.getY() >= 2 && var1.ab() != class_om.a && !var1.D?this.l().a(var1, var2) != null:false;
   }

   public void a(World var1, BlockPosition var2, class_amy var3) {
      if(var3.d() == 1 && var2.getY() >= 2 && var1.ab() != class_om.a && !var1.D) {
         class_anp var4 = this.n();
         class_anp.class_b_in_class_anp var5 = var4.a(var1, var2);
         if(var5 != null) {
            int var6;
            for(var6 = 0; var6 < 3; ++var6) {
               class_ano var7 = var5.a(var6, 0, 0);
               var1.a((BlockPosition)var7.d(), (IBlockData)var7.a().set(b, Boolean.valueOf(true)), 2);
            }

            for(var6 = 0; var6 < var4.c(); ++var6) {
               for(int var13 = 0; var13 < var4.b(); ++var13) {
                  class_ano var8 = var5.a(var6, var13, 0);
                  var1.a((BlockPosition)var8.d(), (IBlockData)Blocks.AIR.getBlockData(), 2);
               }
            }

            BlockPosition var12 = var5.a(1, 0, 0).d();
            class_uw var14 = new class_uw(var1);
            BlockPosition var15 = var5.a(1, 2, 0).d();
            var14.b((double)var15.getX() + 0.5D, (double)var15.getY() + 0.55D, (double)var15.getZ() + 0.5D, var5.b().getAxis() == EnumDirection.EnumAxis.X?0.0F:90.0F, 0.0F);
            var14.aL = var5.b().getAxis() == EnumDirection.EnumAxis.X?0.0F:90.0F;
            var14.n();
            Iterator var9 = var1.a(class_xa.class, var14.aT().b(50.0D, 50.0D, 50.0D)).iterator();

            while(var9.hasNext()) {
               class_xa var10 = (class_xa)var9.next();
               var10.b((class_my)class_mt.I);
            }

            var1.a((class_pr)var14);

            int var16;
            for(var16 = 0; var16 < 120; ++var16) {
               var1.a(class_cy.F, (double)var12.getX() + var1.s.nextDouble(), (double)(var12.getY() - 2) + var1.s.nextDouble() * 3.9D, (double)var12.getZ() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
            }

            for(var16 = 0; var16 < var4.c(); ++var16) {
               for(int var17 = 0; var17 < var4.b(); ++var17) {
                  class_ano var11 = var5.a(var16, var17, 0);
                  var1.b(var11.d(), Blocks.AIR);
               }
            }

         }
      }
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, EnumDirection.getById(var1 & 7)).set(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getId();
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b});
   }

   protected class_anp l() {
      if(this.O == null) {
         this.O = class_anq.a().a(new String[]{"   ", "###", "~#~"}).a('#', class_ano.a(class_ant.a(Blocks.SOUL_SAND))).a('~', class_ano.a(class_ant.a(Blocks.AIR))).b();
      }

      return this.O;
   }

   protected class_anp n() {
      if(this.P == null) {
         this.P = class_anq.a().a(new String[]{"^^^", "###", "~#~"}).a('#', class_ano.a(class_ant.a(Blocks.SOUL_SAND))).a('^', N).a('~', class_ano.a(class_ant.a(Blocks.AIR))).b();
      }

      return this.P;
   }

   static {
      a = class_ahi.b;
      b = class_anw.a("nodrop");
      N = new Predicate() {
         public boolean a(class_ano var1) {
            return var1.a() != null && var1.a().getBlock() == Blocks.SKULL && var1.b() instanceof class_amy && ((class_amy)var1.b()).d() == 1;
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_ano)var1);
         }
      };
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.UP.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[EnumDirection.NORTH.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EAST.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
