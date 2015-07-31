package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_aej;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_vw;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.CreativeTab;

public class class_alo extends Block {
   public static final class_anw a = class_anw.a("explode");

   public class_alo() {
      super(Material.TNT);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
      this.a(CreativeTab.d);
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      super.c(var1, var2, var3);
      if(var1.z(var2)) {
         this.d(var1, var2, var3.set(a, Boolean.valueOf(true)));
         var1.g(var2);
      }

   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(var1.z(var2)) {
         this.d(var1, var2, var3.set(a, Boolean.valueOf(true)));
         var1.g(var2);
      }

   }

   public void a(World var1, BlockPosition var2, class_aej var3) {
      if(!var1.D) {
         class_vw var4 = new class_vw(var1, (double)((float)var2.getX() + 0.5F), (double)var2.getY(), (double)((float)var2.getZ() + 0.5F), var3.c());
         var4.a = var1.s.nextInt(var4.a / 4) + var4.a / 8;
         var1.a((class_pr)var4);
      }
   }

   public void d(World var1, BlockPosition var2, IBlockData var3) {
      this.a(var1, var2, var3, (class_qa)null);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4) {
      if(!var1.D) {
         if(((Boolean)var3.get(a)).booleanValue()) {
            class_vw var5 = new class_vw(var1, (double)((float)var2.getX() + 0.5F), (double)var2.getY(), (double)((float)var2.getZ() + 0.5F), var4);
            var1.a((class_pr)var5);
            var1.a((class_pr)var5, "game.tnt.primed", 1.0F, 1.0F);
         }

      }
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var6 != null && (var6.getItem() == Items.d || var6.getItem() == Items.bO)) {
         this.a(var1, var2, var3.set(a, Boolean.valueOf(true)), (class_qa)var4);
         var1.g(var2);
         if(var6.getItem() == Items.d) {
            var6.a(1, (class_qa)var4);
         } else if(!var4.bH.d) {
            --var6.count;
         }

         return true;
      } else {
         return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_pr var4) {
      if(!var1.D && var4 instanceof class_xd) {
         class_xd var5 = (class_xd)var4;
         if(var5.av()) {
            this.a(var1, var2, var1.p(var2).set(a, Boolean.valueOf(true)), var5.e instanceof class_qa?(class_qa)var5.e:null);
            var1.g(var2);
         }
      }

   }

   public boolean a(class_aej var1) {
      return false;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf((var1 & 1) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Boolean)var1.get(a)).booleanValue()?1:0;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
