package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.class_aje;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.MaterialMapColor;

public class class_ajo extends class_aje {
   public static final BlockStateEnum b = BlockStateEnum.a("variant", class_ajw.class_a_in_class_ajw.class, new Predicate() {
      public boolean a(class_ajw.class_a_in_class_ajw var1) {
         return var1.a() >= 4;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_ajw.class_a_in_class_ajw)var1);
      }
   });

   public class_ajo() {
      this.setBlockData(this.blockStateList.getFirst().set(b, class_ajw.class_a_in_class_ajw.e).set(a, class_aje.class_a_in_class_aje.b));
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      class_ajw.class_a_in_class_ajw var2 = (class_ajw.class_a_in_class_ajw)var1.get(b);
      switch(class_ajo.SyntheticClass_1.b[((class_aje.class_a_in_class_aje)var1.get(a)).ordinal()]) {
      case 1:
      case 2:
      case 3:
      default:
         switch(class_ajo.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
         default:
            return MaterialMapColor.COLOR12;
         case 2:
            return class_ajw.class_a_in_class_ajw.f.c();
         }
      case 4:
         return var2.c();
      }
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData().set(b, class_ajw.class_a_in_class_ajw.a((var1 & 3) + 4));
      switch(var1 & 12) {
      case 0:
         var2 = var2.set(a, class_aje.class_a_in_class_aje.b);
         break;
      case 4:
         var2 = var2.set(a, class_aje.class_a_in_class_aje.a);
         break;
      case 8:
         var2 = var2.set(a, class_aje.class_a_in_class_aje.c);
         break;
      default:
         var2 = var2.set(a, class_aje.class_a_in_class_aje.d);
      }

      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajw.class_a_in_class_ajw)var1.get(b)).a() - 4;
      switch(class_ajo.SyntheticClass_1.b[((class_aje.class_a_in_class_aje)var1.get(a)).ordinal()]) {
      case 1:
         var3 |= 4;
         break;
      case 2:
         var3 |= 8;
         break;
      case 3:
         var3 |= 12;
      }

      return var3;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b, a});
   }

   protected ItemStack i(IBlockData var1) {
      return new ItemStack(Item.getByBlock((Block)this), 1, ((class_ajw.class_a_in_class_ajw)var1.get(b)).a() - 4);
   }

   public int getDropData(IBlockData var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.get(b)).a() - 4;
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[class_aje.class_a_in_class_aje.values().length];

      static {
         try {
            b[class_aje.class_a_in_class_aje.a.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            b[class_aje.class_a_in_class_aje.c.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[class_aje.class_a_in_class_aje.d.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            b[class_aje.class_a_in_class_aje.b.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         a = new int[class_ajw.class_a_in_class_ajw.values().length];

         try {
            a[class_ajw.class_a_in_class_ajw.e.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_ajw.class_a_in_class_ajw.f.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
