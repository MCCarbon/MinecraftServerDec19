package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;

public class class_ajs extends class_aja {
   public static final BlockStateEnum Q = BlockStateEnum.a("variant", class_ajw.class_a_in_class_ajw.class, new Predicate() {
      public boolean a(class_ajw.class_a_in_class_ajw var1) {
         return var1.a() < 4;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_ajw.class_a_in_class_ajw)var1);
      }
   });

   public class_ajs() {
      this.setBlockData(this.blockStateList.getFirst().set(Q, class_ajw.class_a_in_class_ajw.a).set(b, Boolean.valueOf(true)).set(a, Boolean.valueOf(true)));
   }

   protected void a(World var1, BlockPosition var2, IBlockData var3, int var4) {
      if(var3.get(Q) == class_ajw.class_a_in_class_ajw.a && var1.s.nextInt(var4) == 0) {
         a(var1, var2, new class_aas(Items.e));
      }

   }

   protected int d(IBlockData var1) {
      return var1.get(Q) == class_ajw.class_a_in_class_ajw.d?40:super.d(var1);
   }

   protected class_aas i(IBlockData var1) {
      return new class_aas(Item.getByBlock((Block)this), 1, ((class_ajw.class_a_in_class_ajw)var1.get(Q)).a());
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(Q, this.b(var1)).set(a, Boolean.valueOf((var1 & 4) == 0)).set(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajw.class_a_in_class_ajw)var1.get(Q)).a();
      if(!((Boolean)var1.get(a)).booleanValue()) {
         var3 |= 4;
      }

      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public class_ajw.class_a_in_class_ajw b(int var1) {
      return class_ajw.class_a_in_class_ajw.a((var1 & 3) % 4);
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{Q, b, a});
   }

   public int getDropData(IBlockData var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.get(Q)).a();
   }

   public void a(World var1, class_xa var2, BlockPosition var3, IBlockData var4, class_amg var5, class_aas var6) {
      if(!var1.D && var6 != null && var6.b() == Items.bg) {
         var2.b(class_nc.ab[Block.getId((Block)this)]);
         a(var1, var3, new class_aas(Item.getByBlock((Block)this), 1, ((class_ajw.class_a_in_class_ajw)var4.get(Q)).a()));
      } else {
         super.a(var1, var2, var3, var4, var5, var6);
      }
   }
}
