package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.World;
import net.minecraft.server.class_agf;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.BlockPosition;

public class class_aka extends class_agf {
   public static final BlockStateEnum b = BlockStateEnum.a("shape", class_agf.class_b_in_class_agf.class, new Predicate() {
      public boolean a(class_agf.class_b_in_class_agf var1) {
         return var1 != class_agf.class_b_in_class_agf.j && var1 != class_agf.class_b_in_class_agf.i && var1 != class_agf.class_b_in_class_agf.g && var1 != class_agf.class_b_in_class_agf.h;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_agf.class_b_in_class_agf)var1);
      }
   });
   public static final class_anw N = class_anw.a("powered");

   protected class_aka() {
      super(true);
      this.setBlockData(this.blockStateList.getFirst().set(b, class_agf.class_b_in_class_agf.a).set(N, Boolean.valueOf(false)));
   }

   protected boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4, int var5) {
      if(var5 >= 8) {
         return false;
      } else {
         int var6 = var2.getX();
         int var7 = var2.getY();
         int var8 = var2.getZ();
         boolean var9 = true;
         class_agf.class_b_in_class_agf var10 = (class_agf.class_b_in_class_agf)var3.get(b);
         switch(class_aka.SyntheticClass_1.a[var10.ordinal()]) {
         case 1:
            if(var4) {
               ++var8;
            } else {
               --var8;
            }
            break;
         case 2:
            if(var4) {
               --var6;
            } else {
               ++var6;
            }
            break;
         case 3:
            if(var4) {
               --var6;
            } else {
               ++var6;
               ++var7;
               var9 = false;
            }

            var10 = class_agf.class_b_in_class_agf.b;
            break;
         case 4:
            if(var4) {
               --var6;
               ++var7;
               var9 = false;
            } else {
               ++var6;
            }

            var10 = class_agf.class_b_in_class_agf.b;
            break;
         case 5:
            if(var4) {
               ++var8;
            } else {
               --var8;
               ++var7;
               var9 = false;
            }

            var10 = class_agf.class_b_in_class_agf.a;
            break;
         case 6:
            if(var4) {
               ++var8;
               ++var7;
               var9 = false;
            } else {
               --var8;
            }

            var10 = class_agf.class_b_in_class_agf.a;
         }

         return this.a(var1, new BlockPosition(var6, var7, var8), var4, var5, var10)?true:var9 && this.a(var1, new BlockPosition(var6, var7 - 1, var8), var4, var5, var10);
      }
   }

   protected boolean a(World var1, BlockPosition var2, boolean var3, int var4, class_agf.class_b_in_class_agf var5) {
      IBlockData var6 = var1.p(var2);
      if(var6.getBlock() != this) {
         return false;
      } else {
         class_agf.class_b_in_class_agf var7 = (class_agf.class_b_in_class_agf)var6.get(b);
         return var5 == class_agf.class_b_in_class_agf.b && (var7 == class_agf.class_b_in_class_agf.a || var7 == class_agf.class_b_in_class_agf.e || var7 == class_agf.class_b_in_class_agf.f)?false:(var5 == class_agf.class_b_in_class_agf.a && (var7 == class_agf.class_b_in_class_agf.b || var7 == class_agf.class_b_in_class_agf.c || var7 == class_agf.class_b_in_class_agf.d)?false:(((Boolean)var6.get(N)).booleanValue()?(var1.z(var2)?true:this.a(var1, var2, var6, var3, var4 + 1)):false));
      }
   }

   protected void b(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      boolean var5 = ((Boolean)var3.get(N)).booleanValue();
      boolean var6 = var1.z(var2) || this.a(var1, var2, var3, true, 0) || this.a(var1, var2, var3, false, 0);
      if(var6 != var5) {
         var1.a((BlockPosition)var2, (IBlockData)var3.set(N, Boolean.valueOf(var6)), 3);
         var1.c((BlockPosition)var2.shiftDown(), (Block)this);
         if(((class_agf.class_b_in_class_agf)var3.get(b)).c()) {
            var1.c((BlockPosition)var2.shiftUp(), (Block)this);
         }
      }

   }

   public IBlockState n() {
      return b;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(b, class_agf.class_b_in_class_agf.a(var1 & 7)).set(N, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_agf.class_b_in_class_agf)var1.get(b)).a();
      if(((Boolean)var1.get(N)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_aka.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            switch(class_aka.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
            case 3:
               return var1.set(b, class_agf.class_b_in_class_agf.d);
            case 4:
               return var1.set(b, class_agf.class_b_in_class_agf.c);
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.f);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.e);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 9:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            case 10:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            }
         case 2:
            switch(class_aka.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
            case 1:
               return var1.set(b, class_agf.class_b_in_class_agf.b);
            case 2:
               return var1.set(b, class_agf.class_b_in_class_agf.a);
            case 3:
               return var1.set(b, class_agf.class_b_in_class_agf.e);
            case 4:
               return var1.set(b, class_agf.class_b_in_class_agf.f);
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.d);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.c);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            case 9:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            case 10:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            }
         case 3:
            switch(class_aka.SyntheticClass_1.a[((class_agf.class_b_in_class_agf)var1.get(b)).ordinal()]) {
            case 1:
               return var1.set(b, class_agf.class_b_in_class_agf.b);
            case 2:
               return var1.set(b, class_agf.class_b_in_class_agf.a);
            case 3:
               return var1.set(b, class_agf.class_b_in_class_agf.f);
            case 4:
               return var1.set(b, class_agf.class_b_in_class_agf.e);
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.c);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.d);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            case 9:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 10:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            }
         default:
            return var1;
         }
      }
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         class_agf.class_b_in_class_agf var3 = (class_agf.class_b_in_class_agf)var1.get(b);
         switch(class_aka.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
            switch(class_aka.SyntheticClass_1.a[var3.ordinal()]) {
            case 5:
               return var1.set(b, class_agf.class_b_in_class_agf.f);
            case 6:
               return var1.set(b, class_agf.class_b_in_class_agf.e);
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            case 9:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            case 10:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            default:
               return super.a(var1, var2);
            }
         case 2:
            switch(class_aka.SyntheticClass_1.a[var3.ordinal()]) {
            case 3:
               return var1.set(b, class_agf.class_b_in_class_agf.d);
            case 4:
               return var1.set(b, class_agf.class_b_in_class_agf.c);
            case 5:
            case 6:
            default:
               break;
            case 7:
               return var1.set(b, class_agf.class_b_in_class_agf.h);
            case 8:
               return var1.set(b, class_agf.class_b_in_class_agf.g);
            case 9:
               return var1.set(b, class_agf.class_b_in_class_agf.j);
            case 10:
               return var1.set(b, class_agf.class_b_in_class_agf.i);
            }
         }

         return super.a(var1, var2);
      }
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{b, N});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            c[Block.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
            ;
         }

         try {
            c[Block.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
            ;
         }

         b = new int[Block.class_c_in_class_agj.values().length];

         try {
            b[Block.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            b[Block.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            b[Block.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var11) {
            ;
         }

         a = new int[class_agf.class_b_in_class_agf.values().length];

         try {
            a[class_agf.class_b_in_class_agf.a.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.b.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.c.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.d.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.e.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.f.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.g.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.h.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.i.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_agf.class_b_in_class_agf.j.ordinal()] = 10;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
