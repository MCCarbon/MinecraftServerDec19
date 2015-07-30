package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.INamable;
import net.minecraft.server.CreativeTab;

public abstract class class_agf extends Block {
   protected final boolean a;

   public static boolean e(World var0, BlockPosition var1) {
      return d(var0.p(var1));
   }

   public static boolean d(IBlockData var0) {
      Block var1 = var0.getBlock();
      return var1 == Blocks.RAIL || var1 == Blocks.GOLDEN_RAIL || var1 == Blocks.DETECTOR_RAIL || var1 == Blocks.ACTIVATOR_RAIL;
   }

   protected class_agf(boolean var1) {
      super(Material.ORIENTABLE);
      this.a = var1;
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.a(CreativeTab.e);
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public class_awg a(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
      this.isReplaceable(var1, var2);
      return super.a(var1, var2, var3, var4);
   }

   public void a(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      class_agf.class_b_in_class_agf var4 = var3.getBlock() == this?(class_agf.class_b_in_class_agf)var3.get(this.n()):null;
      if(var4 != null && var4.c()) {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      } else {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      }

   }

   public boolean isFullCube() {
      return false;
   }

   public boolean d(World var1, BlockPosition var2) {
      return World.a((class_aer)var1, (BlockPosition)var2.shiftDown());
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.D) {
         var3 = this.a(var1, var2, var3, true);
         if(this.a) {
            this.a(var1, var2, (IBlockData)var3, (Block)this);
         }
      }

   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.D) {
         class_agf.class_b_in_class_agf var5 = (class_agf.class_b_in_class_agf)var3.get(this.n());
         boolean var6 = false;
         if(!World.a((class_aer)var1, (BlockPosition)var2.shiftDown())) {
            var6 = true;
         }

         if(var5 == class_agf.class_b_in_class_agf.c && !World.a((class_aer)var1, (BlockPosition)var2.shiftEast())) {
            var6 = true;
         } else if(var5 == class_agf.class_b_in_class_agf.d && !World.a((class_aer)var1, (BlockPosition)var2.shiftWest())) {
            var6 = true;
         } else if(var5 == class_agf.class_b_in_class_agf.e && !World.a((class_aer)var1, (BlockPosition)var2.shiftNorth())) {
            var6 = true;
         } else if(var5 == class_agf.class_b_in_class_agf.f && !World.a((class_aer)var1, (BlockPosition)var2.shiftSouth())) {
            var6 = true;
         }

         if(var6) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         } else {
            this.b(var1, var2, var3, var4);
         }

      }
   }

   protected void b(World var1, BlockPosition var2, IBlockData var3, Block var4) {
   }

   protected IBlockData a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
      return var1.D?var3:(new class_agf.class_a_in_class_agf(var1, var2, var3)).a(var1.z(var2), var4).b();
   }

   public int getPushReaction() {
      return 0;
   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      super.b(var1, var2, var3);
      if(((class_agf.class_b_in_class_agf)var3.get(this.n())).c()) {
         var1.c((BlockPosition)var2.shiftUp(), (Block)this);
      }

      if(this.a) {
         var1.c((BlockPosition)var2, (Block)this);
         var1.c((BlockPosition)var2.shiftDown(), (Block)this);
      }

   }

   public abstract IBlockState n();

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_agf.class_b_in_class_agf.values().length];

      static {
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

   public static enum class_b_in_class_agf implements INamable {
      a(0, "north_south"),
      b(1, "east_west"),
      c(2, "ascending_east"),
      d(3, "ascending_west"),
      e(4, "ascending_north"),
      f(5, "ascending_south"),
      g(6, "south_east"),
      h(7, "south_west"),
      i(8, "north_west"),
      j(9, "north_east");

      private static final class_agf.class_b_in_class_agf[] k;
      private final int l;
      private final String m;

      private class_b_in_class_agf(int var3, String var4) {
         this.l = var3;
         this.m = var4;
      }

      public int a() {
         return this.l;
      }

      public String toString() {
         return this.m;
      }

      public boolean c() {
         return this == e || this == c || this == f || this == d;
      }

      public static class_agf.class_b_in_class_agf a(int var0) {
         if(var0 < 0 || var0 >= k.length) {
            var0 = 0;
         }

         return k[var0];
      }

      public String getName() {
         return this.m;
      }

      static {
         k = new class_agf.class_b_in_class_agf[values().length];
         class_agf.class_b_in_class_agf[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_agf.class_b_in_class_agf var3 = var0[var2];
            k[var3.a()] = var3;
         }

      }
   }

   public class class_a_in_class_agf {
      private final World b;
      private final BlockPosition c;
      private final class_agf d;
      private IBlockData e;
      private final boolean f;
      private final List g = Lists.newArrayList();

      public class_a_in_class_agf(World var2, BlockPosition var3, IBlockData var4) {
         this.b = var2;
         this.c = var3;
         this.e = var4;
         this.d = (class_agf)var4.getBlock();
         class_agf.class_b_in_class_agf var5 = (class_agf.class_b_in_class_agf)var4.get(d.n());
         this.f = this.d.a;
         this.a(var5);
      }

      private void a(class_agf.class_b_in_class_agf var1) {
         this.g.clear();
         switch(class_agf.SyntheticClass_1.a[var1.ordinal()]) {
         case 1:
            this.g.add(this.c.shiftNorth());
            this.g.add(this.c.shiftSouth());
            break;
         case 2:
            this.g.add(this.c.shiftWest());
            this.g.add(this.c.shiftEast());
            break;
         case 3:
            this.g.add(this.c.shiftWest());
            this.g.add(this.c.shiftEast().shiftUp());
            break;
         case 4:
            this.g.add(this.c.shiftWest().shiftUp());
            this.g.add(this.c.shiftEast());
            break;
         case 5:
            this.g.add(this.c.shiftNorth().shiftUp());
            this.g.add(this.c.shiftSouth());
            break;
         case 6:
            this.g.add(this.c.shiftNorth());
            this.g.add(this.c.shiftSouth().shiftUp());
            break;
         case 7:
            this.g.add(this.c.shiftEast());
            this.g.add(this.c.shiftSouth());
            break;
         case 8:
            this.g.add(this.c.shiftWest());
            this.g.add(this.c.shiftSouth());
            break;
         case 9:
            this.g.add(this.c.shiftWest());
            this.g.add(this.c.shiftNorth());
            break;
         case 10:
            this.g.add(this.c.shiftEast());
            this.g.add(this.c.shiftNorth());
         }

      }

      private void c() {
         for(int var1 = 0; var1 < this.g.size(); ++var1) {
            class_agf.class_a_in_class_agf var2 = this.b((BlockPosition)this.g.get(var1));
            if(var2 != null && var2.a(this)) {
               this.g.set(var1, var2.c);
            } else {
               this.g.remove(var1--);
            }
         }

      }

      private boolean a(BlockPosition var1) {
         return class_agf.e(this.b, var1) || class_agf.e(this.b, var1.shiftUp()) || class_agf.e(this.b, var1.shiftDown());
      }

      private class_agf.class_a_in_class_agf b(BlockPosition var1) {
         IBlockData var3 = this.b.p(var1);
         if(class_agf.d(var3)) {
            return class_agf.this.new class_a_in_class_agf(this.b, var1, var3);
         } else {
            BlockPosition var2 = var1.shiftUp();
            var3 = this.b.p(var2);
            if(class_agf.d(var3)) {
               return class_agf.this.new class_a_in_class_agf(this.b, var2, var3);
            } else {
               var2 = var1.shiftDown();
               var3 = this.b.p(var2);
               return class_agf.d(var3)?class_agf.this.new class_a_in_class_agf(this.b, var2, var3):null;
            }
         }
      }

      private boolean a(class_agf.class_a_in_class_agf var1) {
         return this.c(var1.c);
      }

      private boolean c(BlockPosition var1) {
         for(int var2 = 0; var2 < this.g.size(); ++var2) {
            BlockPosition var3 = (BlockPosition)this.g.get(var2);
            if(var3.getX() == var1.getX() && var3.getZ() == var1.getZ()) {
               return true;
            }
         }

         return false;
      }

      protected int a() {
         int var1 = 0;
         Iterator var2 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

         while(var2.hasNext()) {
            EnumDirection var3 = (EnumDirection)var2.next();
            if(this.a(this.c.shift(var3))) {
               ++var1;
            }
         }

         return var1;
      }

      private boolean b(class_agf.class_a_in_class_agf var1) {
         return this.a(var1) || this.g.size() != 2;
      }

      private void c(class_agf.class_a_in_class_agf var1) {
         this.g.add(var1.c);
         BlockPosition var2 = this.c.shiftNorth();
         BlockPosition var3 = this.c.shiftSouth();
         BlockPosition var4 = this.c.shiftWest();
         BlockPosition var5 = this.c.shiftEast();
         boolean var6 = this.c(var2);
         boolean var7 = this.c(var3);
         boolean var8 = this.c(var4);
         boolean var9 = this.c(var5);
         class_agf.class_b_in_class_agf var10 = null;
         if(var6 || var7) {
            var10 = class_agf.class_b_in_class_agf.a;
         }

         if(var8 || var9) {
            var10 = class_agf.class_b_in_class_agf.b;
         }

         if(!this.f) {
            if(var7 && var9 && !var6 && !var8) {
               var10 = class_agf.class_b_in_class_agf.g;
            }

            if(var7 && var8 && !var6 && !var9) {
               var10 = class_agf.class_b_in_class_agf.h;
            }

            if(var6 && var8 && !var7 && !var9) {
               var10 = class_agf.class_b_in_class_agf.i;
            }

            if(var6 && var9 && !var7 && !var8) {
               var10 = class_agf.class_b_in_class_agf.j;
            }
         }

         if(var10 == class_agf.class_b_in_class_agf.a) {
            if(class_agf.e(this.b, var2.shiftUp())) {
               var10 = class_agf.class_b_in_class_agf.e;
            }

            if(class_agf.e(this.b, var3.shiftUp())) {
               var10 = class_agf.class_b_in_class_agf.f;
            }
         }

         if(var10 == class_agf.class_b_in_class_agf.b) {
            if(class_agf.e(this.b, var5.shiftUp())) {
               var10 = class_agf.class_b_in_class_agf.c;
            }

            if(class_agf.e(this.b, var4.shiftUp())) {
               var10 = class_agf.class_b_in_class_agf.d;
            }
         }

         if(var10 == null) {
            var10 = class_agf.class_b_in_class_agf.a;
         }

         this.e = this.e.set(this.d.n(), var10);
         this.b.a((BlockPosition)this.c, (IBlockData)this.e, 3);
      }

      private boolean d(BlockPosition var1) {
         class_agf.class_a_in_class_agf var2 = this.b(var1);
         if(var2 == null) {
            return false;
         } else {
            var2.c();
            return var2.b(this);
         }
      }

      public class_agf.class_a_in_class_agf a(boolean var1, boolean var2) {
         BlockPosition var3 = this.c.shiftNorth();
         BlockPosition var4 = this.c.shiftSouth();
         BlockPosition var5 = this.c.shiftWest();
         BlockPosition var6 = this.c.shiftEast();
         boolean var7 = this.d(var3);
         boolean var8 = this.d(var4);
         boolean var9 = this.d(var5);
         boolean var10 = this.d(var6);
         class_agf.class_b_in_class_agf var11 = null;
         if((var7 || var8) && !var9 && !var10) {
            var11 = class_agf.class_b_in_class_agf.a;
         }

         if((var9 || var10) && !var7 && !var8) {
            var11 = class_agf.class_b_in_class_agf.b;
         }

         if(!this.f) {
            if(var8 && var10 && !var7 && !var9) {
               var11 = class_agf.class_b_in_class_agf.g;
            }

            if(var8 && var9 && !var7 && !var10) {
               var11 = class_agf.class_b_in_class_agf.h;
            }

            if(var7 && var9 && !var8 && !var10) {
               var11 = class_agf.class_b_in_class_agf.i;
            }

            if(var7 && var10 && !var8 && !var9) {
               var11 = class_agf.class_b_in_class_agf.j;
            }
         }

         if(var11 == null) {
            if(var7 || var8) {
               var11 = class_agf.class_b_in_class_agf.a;
            }

            if(var9 || var10) {
               var11 = class_agf.class_b_in_class_agf.b;
            }

            if(!this.f) {
               if(var1) {
                  if(var8 && var10) {
                     var11 = class_agf.class_b_in_class_agf.g;
                  }

                  if(var9 && var8) {
                     var11 = class_agf.class_b_in_class_agf.h;
                  }

                  if(var10 && var7) {
                     var11 = class_agf.class_b_in_class_agf.j;
                  }

                  if(var7 && var9) {
                     var11 = class_agf.class_b_in_class_agf.i;
                  }
               } else {
                  if(var7 && var9) {
                     var11 = class_agf.class_b_in_class_agf.i;
                  }

                  if(var10 && var7) {
                     var11 = class_agf.class_b_in_class_agf.j;
                  }

                  if(var9 && var8) {
                     var11 = class_agf.class_b_in_class_agf.h;
                  }

                  if(var8 && var10) {
                     var11 = class_agf.class_b_in_class_agf.g;
                  }
               }
            }
         }

         if(var11 == class_agf.class_b_in_class_agf.a) {
            if(class_agf.e(this.b, var3.shiftUp())) {
               var11 = class_agf.class_b_in_class_agf.e;
            }

            if(class_agf.e(this.b, var4.shiftUp())) {
               var11 = class_agf.class_b_in_class_agf.f;
            }
         }

         if(var11 == class_agf.class_b_in_class_agf.b) {
            if(class_agf.e(this.b, var6.shiftUp())) {
               var11 = class_agf.class_b_in_class_agf.c;
            }

            if(class_agf.e(this.b, var5.shiftUp())) {
               var11 = class_agf.class_b_in_class_agf.d;
            }
         }

         if(var11 == null) {
            var11 = class_agf.class_b_in_class_agf.a;
         }

         this.a(var11);
         this.e = this.e.set(this.d.n(), var11);
         if(var2 || this.b.p(this.c) != this.e) {
            this.b.a((BlockPosition)this.c, (IBlockData)this.e, 3);

            for(int var12 = 0; var12 < this.g.size(); ++var12) {
               class_agf.class_a_in_class_agf var13 = this.b((BlockPosition)this.g.get(var12));
               if(var13 != null) {
                  var13.c();
                  if(var13.b(this)) {
                     var13.c(this);
                  }
               }
            }
         }

         return this;
      }

      public IBlockData b() {
         return this.e;
      }
   }
}
