package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.class_age;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;

public class BlockPressurePlateBinary extends class_age {
   public static final BlockStateBoolean a = BlockStateBoolean.of("powered");
   private final BlockPressurePlateBinary.class_a_in_class_akb b;

   protected BlockPressurePlateBinary(Material var1, BlockPressurePlateBinary.class_a_in_class_akb var2) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
      this.b = var2;
   }

   protected int e(IBlockData var1) {
      return ((Boolean)var1.get(a)).booleanValue()?15:0;
   }

   protected IBlockData a(IBlockData var1, int var2) {
      return var1.set(a, Boolean.valueOf(var2 > 0));
   }

   protected int f(World var1, BlockPosition var2) {
      AxisAlignedBB var3 = this.a(var2);
      List var4;
      switch(BlockPressurePlateBinary.SyntheticClass_1.a[this.b.ordinal()]) {
      case 1:
         var4 = var1.getEntities((Entity)null, (AxisAlignedBB)var3);
         break;
      case 2:
         var4 = var1.getEntities(EntityLiving.class, var3);
         break;
      default:
         return 0;
      }

      if(!var4.isEmpty()) {
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            Entity var6 = (Entity)var5.next();
            if(!var6.aK()) {
               return 15;
            }
         }
      }

      return 0;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf(var1 == 1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((Boolean)var1.get(a)).booleanValue()?1:0;
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[BlockPressurePlateBinary.class_a_in_class_akb.values().length];

      static {
         try {
            a[BlockPressurePlateBinary.class_a_in_class_akb.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[BlockPressurePlateBinary.class_a_in_class_akb.b.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_akb {
      a,
      b;
   }
}
