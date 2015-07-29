package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aio;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public abstract class class_ake extends class_aio {
   public static final BlockStateEnum b = BlockStateEnum.of("variant", class_ake.class_c_in_class_ake.class);

   public class_ake() {
      super(Material.e);
      IBlockData var1 = this.blockStateList.getFirst();
      if(!this.l()) {
         var1 = var1.set(a, class_aio.class_a_in_class_aio.b);
      }

      this.setBlockData(var1.set(b, class_ake.class_c_in_class_ake.a));
      this.a(CreativeTab.b);
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData().set(b, class_ake.class_c_in_class_ake.a);
      if(!this.l()) {
         var2 = var2.set(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;
      if(!this.l() && var1.get(a) == class_aio.class_a_in_class_aio.a) {
         var2 |= 8;
      }

      return var2;
   }

   protected BlockStateList createBlockStateList() {
      return this.l()?new BlockStateList(this, new IBlockState[]{b}):new BlockStateList(this, new IBlockState[]{a, b});
   }

   public String b(int var1) {
      return super.getInternalName();
   }

   public IBlockState n() {
      return b;
   }

   public Object a(class_aas var1) {
      return class_ake.class_c_in_class_ake.a;
   }

   public static enum class_c_in_class_ake implements INamable {
      a;

      public String getName() {
         return "default";
      }
   }

   public static class class_a_in_class_ake extends class_ake {
      public boolean l() {
         return true;
      }
   }

   public static class class_b_in_class_ake extends class_ake {
      public boolean l() {
         return false;
      }
   }
}
