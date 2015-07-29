package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.CreativeTab;

public class class_agw extends Block {
   public static final class_anw a = class_anw.a("north");
   public static final class_anw b = class_anw.a("east");
   public static final class_anw N = class_anw.a("south");
   public static final class_anw O = class_anw.a("west");
   public static final class_anw P = class_anw.a("up");
   public static final class_anw Q = class_anw.a("down");

   protected class_agw() {
      super(Material.k);
      this.a(CreativeTab.c);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)).set(O, Boolean.valueOf(false)).set(P, Boolean.valueOf(false)).set(Q, Boolean.valueOf(false)));
   }

   public IBlockData a(IBlockData var1, class_aer var2, class_cj var3) {
      Block var4 = var2.p(var3.b()).getBlock();
      Block var5 = var2.p(var3.a()).getBlock();
      Block var6 = var2.p(var3.c()).getBlock();
      Block var7 = var2.p(var3.f()).getBlock();
      Block var8 = var2.p(var3.d()).getBlock();
      Block var9 = var2.p(var3.e()).getBlock();
      return var1.set(Q, Boolean.valueOf(var4 == this || var4 == Blocks.CHORUS_FLOWER || var4 == Blocks.END_STONE)).set(P, Boolean.valueOf(var5 == this || var5 == Blocks.CHORUS_FLOWER)).set(a, Boolean.valueOf(var6 == this || var6 == Blocks.CHORUS_FLOWER)).set(b, Boolean.valueOf(var7 == this || var7 == Blocks.CHORUS_FLOWER)).set(N, Boolean.valueOf(var8 == this || var8 == Blocks.CHORUS_FLOWER)).set(O, Boolean.valueOf(var9 == this || var9 == Blocks.CHORUS_FLOWER));
   }

   public int toLegacyData(IBlockData var1) {
      return 0;
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      if(!this.e(var1, var2)) {
         var1.b(var2, true);
      }

   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.cI;
   }

   public int a(Random var1) {
      return var1.nextInt(2);
   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return super.a(var1, var2, var3);
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
         var1.a((class_cj)var2, (Block)this, 1);
      }

   }

   public boolean e(World var1, class_cj var2) {
      boolean var3 = var1.d(var2.a());
      boolean var4 = var1.d(var2.b());
      Iterator var5 = class_cq.class_c_in_class_cq.a.iterator();

      Block var9;
      do {
         class_cj var7;
         Block var8;
         do {
            if(!var5.hasNext()) {
               Block var10 = var1.p(var2.b()).getBlock();
               if(var10 != this && var10 != Blocks.END_STONE) {
                  return false;
               }

               return true;
            }

            class_cq var6 = (class_cq)var5.next();
            var7 = var2.a(var6);
            var8 = var1.p(var7).getBlock();
         } while(var8 != this);

         if(!var3 && !var4) {
            return false;
         }

         var9 = var1.p(var7.b()).getBlock();
      } while(var9 != this && var9 != Blocks.END_STONE);

      return true;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N, O, P, Q});
   }
}
