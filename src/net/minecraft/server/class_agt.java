package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_acf;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_ame;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_nc;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_za;
import net.minecraft.server.class_ze;

public class class_agt extends Block {
   public static final class_anz a = class_anz.a("level", 0, 3);

   public class_agt() {
      super(Material.ORE, MaterialMapColor.COLOR12);
      this.setBlockData(this.blockStateList.getFirst().set(a, Integer.valueOf(0)));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.setSizes(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.a(var1, var2, var3, var4, var5, var6);
      this.setSizes(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.j();
   }

   public void j() {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_pr var4) {
      int var5 = ((Integer)var3.get(a)).intValue();
      float var6 = (float)var2.getY() + (6.0F + (float)(3 * var5)) / 16.0F;
      if(!var1.D && var4.av() && var5 > 0 && var4.aT().b <= (double)var6) {
         var4.N();
         this.a(var1, var2, var3, var5 - 1);
      }

   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else if(var6 == null) {
         return true;
      } else {
         int var11 = ((Integer)var3.get(a)).intValue();
         Item var12 = var6.getItem();
         if(var12 == Items.az) {
            if(var11 < 3) {
               if(!var4.bH.d) {
                  var4.a((EnumUsedHand)var5, (ItemStack)(new ItemStack(Items.ay)));
               }

               var4.b(class_nc.I);
               this.a(var1, var2, var3, 3);
            }

            return true;
         } else {
            ItemStack var14;
            if(var12 == Items.bD) {
               if(var11 > 0) {
                  if(!var4.bH.d) {
                     var14 = class_abe.a(new ItemStack(Items.bB), class_acf.a);
                     var4.b(class_nc.J);
                     if(--var6.count == 0) {
                        var4.a((EnumUsedHand)var5, (ItemStack)var14);
                     } else if(!var4.bp.a(var14)) {
                        var4.a(var14, false);
                     } else if(var4 instanceof class_lh) {
                        ((class_lh)var4).a(var4.bq);
                     }
                  }

                  this.a(var1, var2, var3, var11 - 1);
               }

               return true;
            } else {
               if(var11 > 0 && var12 instanceof class_za) {
                  class_za var13 = (class_za)var12;
                  if(var13.d() == class_za.class_a_in_class_za.a && var13.d_(var6)) {
                     var13.c(var6);
                     this.a(var1, var2, var3, var11 - 1);
                     var4.b(class_nc.K);
                     return true;
                  }
               }

               if(var11 > 0 && var12 instanceof class_ze && class_ame.c(var6) > 0) {
                  var14 = var6.clone();
                  var14.count = 1;
                  class_ame.e(var14);
                  var4.b(class_nc.L);
                  if(var4.bH.d) {
                     --var6.count;
                  }

                  if(var6.count == 0) {
                     var4.a((EnumUsedHand)var5, (ItemStack)var14);
                  } else if(!var4.bp.a(var14)) {
                     var4.a(var14, false);
                  } else if(var4 instanceof class_lh) {
                     ((class_lh)var4).a(var4.bq);
                  }

                  if(!var4.bH.d) {
                     this.a(var1, var2, var3, var11 - 1);
                  }

                  return true;
               } else {
                  return false;
               }
            }
         }
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, int var4) {
      var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(MathHelper.clamp(var4, 0, 3))), 2);
      var1.e(var2, this);
   }

   public void k(World var1, BlockPosition var2) {
      if(var1.s.nextInt(20) == 1) {
         IBlockData var3 = var1.p(var2);
         if(((Integer)var3.get(a)).intValue() < 3) {
            var1.a((BlockPosition)var2, (IBlockData)var3.a(a), 2);
         }

      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.bJ;
   }

   public boolean Q() {
      return true;
   }

   public int l(World var1, BlockPosition var2) {
      return ((Integer)var1.p(var2).get(a)).intValue();
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
