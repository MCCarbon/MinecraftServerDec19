package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_ob;
import net.minecraft.server.CreativeTab;

public class class_ala extends Block {
   public static final class_anw a = class_anw.a("wet");

   protected class_ala() {
      super(Material.m);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
      this.a(CreativeTab.b);
   }

   public String getName() {
      return LocaleI18n.get(this.getInternalName() + ".dry.name");
   }

   public int getDropData(IBlockData var1) {
      return ((Boolean)var1.get(a)).booleanValue()?1:0;
   }

   public void c(World var1, class_cj var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
      super.a(var1, var2, var3, var4);
   }

   protected void e(World var1, class_cj var2, IBlockData var3) {
      if(!((Boolean)var3.get(a)).booleanValue() && this.e(var1, var2)) {
         var1.a((class_cj)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 2);
         var1.b(2001, var2, Block.getId((Block)Blocks.WATER));
      }

   }

   private boolean e(World var1, class_cj var2) {
      LinkedList var3 = Lists.newLinkedList();
      ArrayList var4 = Lists.newArrayList();
      var3.add(new class_ob(var2, Integer.valueOf(0)));
      int var5 = 0;

      class_cj var7;
      while(!var3.isEmpty()) {
         class_ob var6 = (class_ob)var3.poll();
         var7 = (class_cj)var6.a();
         int var8 = ((Integer)var6.b()).intValue();
         class_cq[] var9 = class_cq.values();
         int var10 = var9.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            class_cq var12 = var9[var11];
            class_cj var13 = var7.a(var12);
            if(var1.p(var13).getBlock().getMaterial() == Material.h) {
               var1.a((class_cj)var13, (IBlockData)Blocks.AIR.getBlockData(), 2);
               var4.add(var13);
               ++var5;
               if(var8 < 6) {
                  var3.add(new class_ob(var13, Integer.valueOf(var8 + 1)));
               }
            }
         }

         if(var5 > 64) {
            break;
         }
      }

      Iterator var14 = var4.iterator();

      while(var14.hasNext()) {
         var7 = (class_cj)var14.next();
         var1.c(var7, Blocks.AIR);
      }

      return var5 > 0;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf((var1 & 1) == 1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Boolean)var1.get(a)).booleanValue()?1:0;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
