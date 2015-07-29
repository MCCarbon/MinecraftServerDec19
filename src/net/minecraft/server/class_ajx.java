package net.minecraft.server;

import com.google.common.cache.LoadingCache;
import java.util.Random;
import net.minecraft.server.class_abt;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiq;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_ano;
import net.minecraft.server.class_anp;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pr;

public class class_ajx extends class_aiq {
   public static final BlockStateEnum a;

   public class_ajx() {
      super(Material.E, false);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_cq.class_a_in_class_cq.a));
      this.setTicking(true);
   }

   public void b(World var1, class_cj var2, IBlockData var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.t.d() && var1.R().b("doMobSpawning") && var4.nextInt(2000) < var1.ab().a()) {
         int var5 = var2.o();

         class_cj var6;
         for(var6 = var2; !World.a((class_aer)var1, (class_cj)var6) && var6.o() > 0; var6 = var6.b()) {
            ;
         }

         if(var5 > 0 && !var1.p(var6.a()).getBlock().isOccluding()) {
            class_pr var7 = class_abt.a(var1, 57, (double)var6.n() + 0.5D, (double)var6.o() + 1.1D, (double)var6.p() + 0.5D);
            if(var7 != null) {
               var7.aj = var7.aq();
            }
         }
      }

   }

   public class_awf a(World var1, class_cj var2, IBlockData var3) {
      return null;
   }

   public void a(class_aer var1, class_cj var2) {
      class_cq.class_a_in_class_cq var3 = (class_cq.class_a_in_class_cq)var1.p(var2).get(a);
      float var4 = 0.125F;
      float var5 = 0.125F;
      if(var3 == class_cq.class_a_in_class_cq.a) {
         var4 = 0.5F;
      }

      if(var3 == class_cq.class_a_in_class_cq.c) {
         var5 = 0.5F;
      }

      this.setSizes(0.5F - var4, 0.0F, 0.5F - var5, 0.5F + var4, 1.0F, 0.5F + var5);
   }

   public static int a(class_cq.class_a_in_class_cq var0) {
      return var0 == class_cq.class_a_in_class_cq.a?1:(var0 == class_cq.class_a_in_class_cq.c?2:0);
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean e(World var1, class_cj var2) {
      class_ajx.class_a_in_class_ajx var3 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.a);
      if(var3.d() && var3.e == 0) {
         var3.e();
         return true;
      } else {
         class_ajx.class_a_in_class_ajx var4 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.c);
         if(var4.d() && var4.e == 0) {
            var4.e();
            return true;
         } else {
            return false;
         }
      }
   }

   public void a(World var1, class_cj var2, IBlockData var3, Block var4) {
      class_cq.class_a_in_class_cq var5 = (class_cq.class_a_in_class_cq)var3.get(a);
      class_ajx.class_a_in_class_ajx var6;
      if(var5 == class_cq.class_a_in_class_cq.a) {
         var6 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.a);
         if(!var6.d() || var6.e < var6.h * var6.g) {
            var1.a(var2, Blocks.AIR.getBlockData());
         }
      } else if(var5 == class_cq.class_a_in_class_cq.c) {
         var6 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.c);
         if(!var6.d() || var6.e < var6.h * var6.g) {
            var1.a(var2, Blocks.AIR.getBlockData());
         }
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public void a(World var1, class_cj var2, IBlockData var3, class_pr var4) {
      if(var4.m == null && var4.l == null) {
         var4.d(var2);
      }

   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, (var1 & 3) == 2?class_cq.class_a_in_class_cq.c:class_cq.class_a_in_class_cq.a);
   }

   public int toLegacyData(IBlockData var1) {
      return a((class_cq.class_a_in_class_cq)var1.get(a));
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         switch(class_ajx.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
         case 2:
            switch(class_ajx.SyntheticClass_1.a[((class_cq.class_a_in_class_cq)var1.get(a)).ordinal()]) {
            case 1:
               return var1.set(a, class_cq.class_a_in_class_cq.c);
            case 2:
               return var1.set(a, class_cq.class_a_in_class_cq.a);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public class_anp.class_b_in_class_anp f(World var1, class_cj var2) {
      class_cq.class_a_in_class_cq var3 = class_cq.class_a_in_class_cq.c;
      class_ajx.class_a_in_class_ajx var4 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.a);
      LoadingCache var5 = class_anp.a(var1, true);
      if(!var4.d()) {
         var3 = class_cq.class_a_in_class_cq.a;
         var4 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.c);
      }

      if(!var4.d()) {
         return new class_anp.class_b_in_class_anp(var2, class_cq.c, class_cq.b, var5, 1, 1, 1);
      } else {
         int[] var6 = new int[class_cq.class_b_in_class_cq.values().length];
         class_cq var7 = var4.c.f();
         class_cj var8 = var4.f.b(var4.a() - 1);
         class_cq.class_b_in_class_cq[] var9 = class_cq.class_b_in_class_cq.values();
         int var10 = var9.length;

         int var11;
         for(var11 = 0; var11 < var10; ++var11) {
            class_cq.class_b_in_class_cq var12 = var9[var11];
            class_anp.class_b_in_class_anp var13 = new class_anp.class_b_in_class_anp(var7.c() == var12?var8:var8.a(var4.c, var4.b() - 1), class_cq.a(var12, var3), class_cq.b, var5, var4.b(), var4.a(), 1);

            for(int var14 = 0; var14 < var4.b(); ++var14) {
               for(int var15 = 0; var15 < var4.a(); ++var15) {
                  class_ano var16 = var13.a(var14, var15, 1);
                  if(var16.a() != null && var16.a().getBlock().getMaterial() != Material.a) {
                     ++var6[var12.ordinal()];
                  }
               }
            }
         }

         class_cq.class_b_in_class_cq var17 = class_cq.class_b_in_class_cq.a;
         class_cq.class_b_in_class_cq[] var18 = class_cq.class_b_in_class_cq.values();
         var11 = var18.length;

         for(int var19 = 0; var19 < var11; ++var19) {
            class_cq.class_b_in_class_cq var20 = var18[var19];
            if(var6[var20.ordinal()] < var6[var17.ordinal()]) {
               var17 = var20;
            }
         }

         return new class_anp.class_b_in_class_anp(var7.c() == var17?var8:var8.a(var4.c, var4.b() - 1), class_cq.a(var17, var3), class_cq.b, var5, var4.b(), var4.a(), 1);
      }
   }

   static {
      a = BlockStateEnum.a("axis", class_cq.class_a_in_class_cq.class, (Enum[])(new class_cq.class_a_in_class_cq[]{class_cq.class_a_in_class_cq.a, class_cq.class_a_in_class_cq.c}));
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_c_in_class_agj.values().length];

      static {
         try {
            b[Block.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            b[Block.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         a = new int[class_cq.class_a_in_class_cq.values().length];

         try {
            a[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.class_a_in_class_cq.c.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static class class_a_in_class_ajx {
      private final World a;
      private final class_cq.class_a_in_class_cq b;
      private final class_cq c;
      private final class_cq d;
      private int e = 0;
      private class_cj f;
      private int g;
      private int h;

      public class_a_in_class_ajx(World var1, class_cj var2, class_cq.class_a_in_class_cq var3) {
         this.a = var1;
         this.b = var3;
         if(var3 == class_cq.class_a_in_class_cq.a) {
            this.d = class_cq.f;
            this.c = class_cq.e;
         } else {
            this.d = class_cq.c;
            this.c = class_cq.d;
         }

         for(class_cj var4 = var2; var2.o() > var4.o() - 21 && var2.o() > 0 && this.a(var1.p(var2.b()).getBlock()); var2 = var2.b()) {
            ;
         }

         int var5 = this.a(var2, this.d) - 1;
         if(var5 >= 0) {
            this.f = var2.a(this.d, var5);
            this.h = this.a(this.f, this.c);
            if(this.h < 2 || this.h > 21) {
               this.f = null;
               this.h = 0;
            }
         }

         if(this.f != null) {
            this.g = this.c();
         }

      }

      protected int a(class_cj var1, class_cq var2) {
         int var3;
         for(var3 = 0; var3 < 22; ++var3) {
            class_cj var4 = var1.a(var2, var3);
            if(!this.a(this.a.p(var4).getBlock()) || this.a.p(var4.b()).getBlock() != Blocks.OBSIDIAN) {
               break;
            }
         }

         Block var5 = this.a.p(var1.a(var2, var3)).getBlock();
         return var5 == Blocks.OBSIDIAN?var3:0;
      }

      public int a() {
         return this.g;
      }

      public int b() {
         return this.h;
      }

      protected int c() {
         int var1;
         label56:
         for(this.g = 0; this.g < 21; ++this.g) {
            for(var1 = 0; var1 < this.h; ++var1) {
               class_cj var2 = this.f.a(this.c, var1).b(this.g);
               Block var3 = this.a.p(var2).getBlock();
               if(!this.a(var3)) {
                  break label56;
               }

               if(var3 == Blocks.PORTAL) {
                  ++this.e;
               }

               if(var1 == 0) {
                  var3 = this.a.p(var2.a(this.d)).getBlock();
                  if(var3 != Blocks.OBSIDIAN) {
                     break label56;
                  }
               } else if(var1 == this.h - 1) {
                  var3 = this.a.p(var2.a(this.c)).getBlock();
                  if(var3 != Blocks.OBSIDIAN) {
                     break label56;
                  }
               }
            }
         }

         for(var1 = 0; var1 < this.h; ++var1) {
            if(this.a.p(this.f.a(this.c, var1).b(this.g)).getBlock() != Blocks.OBSIDIAN) {
               this.g = 0;
               break;
            }
         }

         if(this.g <= 21 && this.g >= 3) {
            return this.g;
         } else {
            this.f = null;
            this.h = 0;
            this.g = 0;
            return 0;
         }
      }

      protected boolean a(Block var1) {
         return var1.material == Material.a || var1 == Blocks.FIRE || var1 == Blocks.PORTAL;
      }

      public boolean d() {
         return this.f != null && this.h >= 2 && this.h <= 21 && this.g >= 3 && this.g <= 21;
      }

      public void e() {
         for(int var1 = 0; var1 < this.h; ++var1) {
            class_cj var2 = this.f.a(this.c, var1);

            for(int var3 = 0; var3 < this.g; ++var3) {
               this.a.a((class_cj)var2.b(var3), (IBlockData)Blocks.PORTAL.getBlockData().set(class_ajx.a, this.b), 2);
            }
         }

      }
   }
}
