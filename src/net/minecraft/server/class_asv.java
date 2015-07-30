package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amz;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_asu;
import net.minecraft.server.class_awf;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dp;
import net.minecraft.server.class_dt;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_vc;
import net.minecraft.server.class_xa;

public class class_asv {
   private final List a = Lists.newArrayList();
   private final List b = Lists.newArrayList();
   private BlockPosition c = new BlockPosition(0, 0, 0);
   private String d = "?";

   public BlockPosition a() {
      return this.c;
   }

   public void a(String var1) {
      this.d = var1;
   }

   public String b() {
      return this.d;
   }

   public void a(World var1, BlockPosition var2, BlockPosition var3, boolean var4) {
      if(var3.getX() >= 1 && var3.getY() >= 1 && var3.getZ() >= 1) {
         BlockPosition var5 = var2.add((BaseBlockPosition)var3).add(-1, -1, -1);
         ArrayList var6 = Lists.newArrayList();
         ArrayList var7 = Lists.newArrayList();
         ArrayList var8 = Lists.newArrayList();
         BlockPosition var9 = new BlockPosition(Math.min(var2.getX(), var5.getX()), Math.min(var2.getY(), var5.getY()), Math.min(var2.getZ(), var5.getZ()));
         BlockPosition var10 = new BlockPosition(Math.max(var2.getX(), var5.getX()), Math.max(var2.getY(), var5.getY()), Math.max(var2.getZ(), var5.getZ()));
         this.c = var3;
         Iterator var11 = BlockPosition.allInCubeM(var9, var10).iterator();

         while(true) {
            while(var11.hasNext()) {
               BlockPosition.MutableBlockPosition var12 = (BlockPosition.MutableBlockPosition)var11.next();
               BlockPosition var13 = var12.substract(var9);
               IBlockData var14 = var1.p(var12);
               class_amg var15 = var1.s(var12);
               if(var15 != null) {
                  class_dn var16 = new class_dn();
                  var15.b(var16);
                  var16.p("x");
                  var16.p("y");
                  var16.p("z");
                  var7.add(new class_asv.class_a_in_class_asv(var13, var14, var16, null));
               } else if(!var14.getBlock().isFullBlock() && !var14.getBlock().isFullCube()) {
                  var8.add(new class_asv.class_a_in_class_asv(var13, var14, (class_dn)null, null));
               } else {
                  var6.add(new class_asv.class_a_in_class_asv(var13, var14, (class_dn)null, null));
               }
            }

            this.a.clear();
            this.a.addAll(var6);
            this.a.addAll(var7);
            this.a.addAll(var8);
            if(var4) {
               this.a(var1, var9, var10.add(1, 1, 1));
            } else {
               this.b.clear();
            }

            return;
         }
      }
   }

   private void a(World var1, BlockPosition var2, BlockPosition var3) {
      List var4 = var1.a(class_pr.class, new class_awf(var2, var3), new Predicate() {
         public boolean a(class_pr var1) {
            return !(var1 instanceof class_xa);
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_pr)var1);
         }
      });
      this.b.clear();

      Vec3D var7;
      class_dn var8;
      BlockPosition var9;
      for(Iterator var5 = var4.iterator(); var5.hasNext(); this.b.add(new class_asv.class_b_in_class_asv(var7, var9, var8, null))) {
         class_pr var6 = (class_pr)var5.next();
         var7 = new Vec3D(var6.s - (double)var2.getX(), var6.t - (double)var2.getY(), var6.u - (double)var2.getZ());
         var8 = new class_dn();
         var6.d(var8);
         if(var6 instanceof class_vc) {
            var9 = ((class_vc)var6).n().substract(var2);
         } else {
            var9 = new BlockPosition(var7);
         }
      }

   }

   public Map a(BlockPosition var1, class_asu var2) {
      HashMap var3 = Maps.newHashMap();
      class_arw var4 = var2.g();
      Iterator var5 = this.a.iterator();

      while(true) {
         class_asv.class_a_in_class_asv var6;
         BlockPosition var7;
         do {
            if(!var5.hasNext()) {
               return var3;
            }

            var6 = (class_asv.class_a_in_class_asv)var5.next();
            var7 = this.a(var2, var6.a).add((BaseBlockPosition)var1);
         } while(var4 != null && !var4.b((BaseBlockPosition)var7));

         IBlockData var8 = var6.b;
         if(var8.getBlock() == Blocks.STRUCTURE_BLOCK && var6.c != null) {
            class_amz.class_a_in_class_amz var9 = class_amz.class_a_in_class_amz.valueOf(var6.c.k("mode"));
            if(var9 == class_amz.class_a_in_class_amz.d) {
               var3.put(var7, var6.c.k("metadata"));
            }
         }
      }
   }

   public BlockPosition a(class_asu var1, BlockPosition var2, class_asv var3, class_asu var4, BlockPosition var5) {
      BlockPosition var6 = this.a(var1, var2);
      BlockPosition var7 = var3.a(var4, var5);
      return var6.substract(var7);
   }

   public BlockPosition a(class_asu var1, BlockPosition var2) {
      return this.a(var2, var1.b(), var1.c());
   }

   public void a(World var1, BlockPosition var2, class_asu var3) {
      var3.i();
      this.b(var1, var2, var3);
   }

   public void b(World var1, BlockPosition var2, class_asu var3) {
      if(!this.a.isEmpty() && this.c.getX() >= 1 && this.c.getY() >= 1 && this.c.getZ() >= 1) {
         class_arw var4 = var3.g();
         Iterator var5 = this.a.iterator();

         while(true) {
            class_asv.class_a_in_class_asv var6;
            Block var7;
            BlockPosition var8;
            do {
               do {
                  do {
                     if(!var5.hasNext()) {
                        var5 = this.a.iterator();

                        while(true) {
                           BlockPosition var12;
                           do {
                              do {
                                 if(!var5.hasNext()) {
                                    if(!var3.e()) {
                                       this.a(var1, var2, var3.b(), var3.c(), var4);
                                    }

                                    return;
                                 }

                                 var6 = (class_asv.class_a_in_class_asv)var5.next();
                              } while(var3.f() && var6.b.getBlock() == Blocks.AIR);

                              var12 = this.a(var3, var6.a).add((BaseBlockPosition)var2);
                           } while(var4 != null && !var4.b((BaseBlockPosition)var12));

                           var1.b(var12, var6.b.getBlock());
                           if(var6.c != null) {
                              class_amg var13 = var1.s(var12);
                              if(var13 != null) {
                                 var13.p_();
                              }
                           }
                        }
                     }

                     var6 = (class_asv.class_a_in_class_asv)var5.next();
                     var7 = var6.b.getBlock();
                  } while(var3.f() && var7 == Blocks.AIR);
               } while(var3.h() && var7 == Blocks.STRUCTURE_BLOCK);

               var8 = this.a(var3, var6.a).add((BaseBlockPosition)var2);
            } while(var4 != null && !var4.b((BaseBlockPosition)var8));

            IBlockData var9 = var7.a(var6.b, var3.b());
            IBlockData var10 = var7.a(var9, var3.c());
            class_amg var11;
            if(var6.c != null) {
               var11 = var1.s(var8);
               if(var11 != null) {
                  if(var11 instanceof class_oj) {
                     ((class_oj)var11).l();
                  }

                  var1.a((BlockPosition)var8, (IBlockData)Blocks.BARRIER.getBlockData(), 4);
               }
            }

            if(var1.a((BlockPosition)var8, (IBlockData)var10, 2) && var6.c != null) {
               var11 = var1.s(var8);
               if(var11 != null) {
                  var6.c.a("x", var8.getX());
                  var6.c.a("y", var8.getY());
                  var6.c.a("z", var8.getZ());
                  var11.a(var6.c);
               }
            }
         }
      }
   }

   private void a(World var1, BlockPosition var2, Block.class_a_in_class_agj var3, Block.class_c_in_class_agj var4, class_arw var5) {
      Iterator var6 = this.b.iterator();

      while(true) {
         class_asv.class_b_in_class_asv var7;
         BlockPosition var8;
         do {
            if(!var6.hasNext()) {
               return;
            }

            var7 = (class_asv.class_b_in_class_asv)var6.next();
            var8 = this.a(var7.b, var3, var4).add((BaseBlockPosition)var2);
         } while(var5 != null && !var5.b((BaseBlockPosition)var8));

         class_dn var9 = var7.c;
         Vec3D var10 = this.a(var7.a, var3, var4);
         Vec3D var11 = var10.add((double)var2.getX(), (double)var2.getY(), (double)var2.getZ());
         class_du var12 = new class_du();
         var12.a((class_eb)(new class_dp(var11.x)));
         var12.a((class_eb)(new class_dp(var11.y)));
         var12.a((class_eb)(new class_dp(var11.z)));
         var9.a((String)"Pos", (class_eb)var12);
         UUID var13 = UUID.randomUUID();
         var9.a("UUIDMost", var13.getMostSignificantBits());
         var9.a("UUIDLeast", var13.getLeastSignificantBits());

         class_pr var14;
         try {
            var14 = class_pt.a(var9, var1);
         } catch (Exception var16) {
            var14 = null;
         }

         if(var14 != null) {
            if(var14 instanceof class_vc) {
               var14.a(var3);
               var14.a(var4);
               var14.b((double)var8.getX(), (double)var8.getY(), (double)var8.getZ());
               var14.b(var11.x, var11.y, var11.z, var14.y, var14.z);
            } else {
               float var15 = var14.a(var3);
               var15 += var14.y - var14.a(var4);
               var14.b(var11.x, var11.y, var11.z, var15, var14.z);
            }

            var1.a(var14);
         }
      }
   }

   public BlockPosition a(Block.class_c_in_class_agj var1) {
      switch(class_asv.SyntheticClass_1.a[var1.ordinal()]) {
      case 1:
      case 2:
         return new BlockPosition(this.c.getZ(), this.c.getY(), this.c.getX());
      default:
         return this.c;
      }
   }

   private BlockPosition a(BlockPosition var1, Block.class_a_in_class_agj var2, Block.class_c_in_class_agj var3) {
      int var4 = var1.getX();
      int var5 = var1.getY();
      int var6 = var1.getZ();
      boolean var7 = true;
      switch(class_asv.SyntheticClass_1.b[var2.ordinal()]) {
      case 1:
         var6 = -var6;
         break;
      case 2:
         var4 = -var4;
         break;
      default:
         var7 = false;
      }

      switch(class_asv.SyntheticClass_1.a[var3.ordinal()]) {
      case 1:
         return new BlockPosition(var6, var5, -var4);
      case 2:
         return new BlockPosition(-var6, var5, var4);
      case 3:
         return new BlockPosition(-var4, var5, -var6);
      default:
         return var7?new BlockPosition(var4, var5, var6):var1;
      }
   }

   private Vec3D a(Vec3D var1, Block.class_a_in_class_agj var2, Block.class_c_in_class_agj var3) {
      double var4 = var1.x;
      double var6 = var1.y;
      double var8 = var1.z;
      boolean var10 = true;
      switch(class_asv.SyntheticClass_1.b[var2.ordinal()]) {
      case 1:
         var8 = 1.0D - var8;
         break;
      case 2:
         var4 = 1.0D - var4;
         break;
      default:
         var10 = false;
      }

      switch(class_asv.SyntheticClass_1.a[var3.ordinal()]) {
      case 1:
         return new Vec3D(var8, var6, 1.0D - var4);
      case 2:
         return new Vec3D(1.0D - var8, var6, var4);
      case 3:
         return new Vec3D(1.0D - var4, var6, 1.0D - var8);
      default:
         return var10?new Vec3D(var4, var6, var8):var1;
      }
   }

   public void a(class_dn var1) {
      class_du var2 = new class_du();

      class_dn var5;
      for(Iterator var3 = this.a.iterator(); var3.hasNext(); var2.a((class_eb)var5)) {
         class_asv.class_a_in_class_asv var4 = (class_asv.class_a_in_class_asv)var3.next();
         var5 = new class_dn();
         var5.a((String)"pos", (class_eb)this.a(new int[]{var4.a.getX(), var4.a.getY(), var4.a.getZ()}));
         var5.a("state", Block.getCombinedId(var4.b));
         if(var4.c != null) {
            var5.a((String)"nbt", (class_eb)var4.c);
         }
      }

      class_du var7 = new class_du();

      class_dn var6;
      for(Iterator var8 = this.b.iterator(); var8.hasNext(); var7.a((class_eb)var6)) {
         class_asv.class_b_in_class_asv var9 = (class_asv.class_b_in_class_asv)var8.next();
         var6 = new class_dn();
         var6.a((String)"pos", (class_eb)this.a(new double[]{var9.a.x, var9.a.y, var9.a.z}));
         var6.a((String)"blockPos", (class_eb)this.a(new int[]{var9.b.getX(), var9.b.getY(), var9.b.getZ()}));
         if(var9.c != null) {
            var6.a((String)"nbt", (class_eb)var9.c);
         }
      }

      var1.a((String)"blocks", (class_eb)var2);
      var1.a((String)"entities", (class_eb)var7);
      var1.a((String)"size", (class_eb)this.a(new int[]{this.c.getX(), this.c.getY(), this.c.getZ()}));
      var1.a("version", (int)1);
      var1.a("author", this.d);
   }

   public void b(class_dn var1) {
      this.a.clear();
      this.b.clear();
      class_du var2 = var1.c("size", 3);
      this.c = new BlockPosition(var2.c(0), var2.c(1), var2.c(2));
      this.d = var1.k("author");
      class_du var3 = var1.c("blocks", 10);

      for(int var4 = 0; var4 < var3.c(); ++var4) {
         class_dn var5 = var3.b(var4);
         class_du var6 = var5.c("pos", 3);
         BlockPosition var7 = new BlockPosition(var6.c(0), var6.c(1), var6.c(2));
         int var8 = var5.g("state");
         IBlockData var9 = Block.getByCombinedId(var8);
         class_dn var10;
         if(var5.d("nbt")) {
            var10 = var5.n("nbt");
         } else {
            var10 = null;
         }

         this.a.add(new class_asv.class_a_in_class_asv(var7, var9, var10, null));
      }

      class_du var12 = var1.c("entities", 10);

      for(int var13 = 0; var13 < var12.c(); ++var13) {
         class_dn var14 = var12.b(var13);
         class_du var15 = var14.c("pos", 6);
         Vec3D var16 = new Vec3D(var15.e(0), var15.e(1), var15.e(2));
         class_du var17 = var14.c("blockPos", 3);
         BlockPosition var18 = new BlockPosition(var17.c(0), var17.c(1), var17.c(2));
         if(var14.d("nbt")) {
            class_dn var11 = var14.n("nbt");
            this.b.add(new class_asv.class_b_in_class_asv(var16, var18, var11, null));
         }
      }

   }

   private class_du a(int... var1) {
      class_du var2 = new class_du();
      int[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var3[var5];
         var2.a((class_eb)(new class_dt(var6)));
      }

      return var2;
   }

   private class_du a(double... var1) {
      class_du var2 = new class_du();
      double[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.a((class_eb)(new class_dp(var6)));
      }

      return var2;
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            b[Block.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[Block.class_c_in_class_agj.values().length];

         try {
            a[Block.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.c.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   static class class_b_in_class_asv {
      public final Vec3D a;
      public final BlockPosition b;
      public final class_dn c;

      private class_b_in_class_asv(Vec3D var1, BlockPosition var2, class_dn var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      class_b_in_class_asv(Vec3D var1, BlockPosition var2, class_dn var3, Object var4) {
         this(var1, var2, var3);
      }
   }

   static class class_a_in_class_asv {
      public final BlockPosition a;
      public final IBlockData b;
      public final class_dn c;

      private class_a_in_class_asv(BlockPosition var1, IBlockData var2, class_dn var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      // $FF: synthetic method
      class_a_in_class_asv(BlockPosition var1, IBlockData var2, class_dn var3, Object var4) {
         this(var1, var2, var3);
      }
   }
}
