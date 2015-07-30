package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.server.class_aeh;
import net.minecraft.server.World;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_aet;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_afd;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahw;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aoh;
import net.minecraft.server.class_aol;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apj;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_e;
import net.minecraft.server.class_ng;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_aok {
   private static final Logger c = LogManager.getLogger();
   private final class_aol[] d;
   private final byte[] e;
   private final int[] f;
   private final boolean[] g;
   private boolean h;
   private final World i;
   private final int[] j;
   public final int a;
   public final int b;
   private boolean k;
   private final Map l;
   private final class_ng[] m;
   private boolean n;
   private boolean o;
   private boolean p;
   private boolean q;
   private boolean r;
   private long s;
   private int t;
   private long u;
   private int v;
   private ConcurrentLinkedQueue w;

   public class_aok(World var1, int var2, int var3) {
      this.d = new class_aol[16];
      this.e = new byte[256];
      this.f = new int[256];
      this.g = new boolean[256];
      this.l = Maps.newHashMap();
      this.v = 4096;
      this.w = Queues.newConcurrentLinkedQueue();
      this.m = (class_ng[])(new class_ng[16]);
      this.i = var1;
      this.a = var2;
      this.b = var3;
      this.j = new int[256];

      for(int var4 = 0; var4 < this.m.length; ++var4) {
         this.m[var4] = new class_ng(class_pr.class);
      }

      Arrays.fill(this.f, -999);
      Arrays.fill(this.e, (byte)-1);
   }

   public class_aok(World var1, class_aph var2, int var3, int var4) {
      this(var1, var3, var4);
      short var5 = 256;
      boolean var6 = !var1.t.m();

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            for(int var9 = 0; var9 < var5; ++var9) {
               int var10 = var7 * var5 * 16 | var8 * var5 | var9;
               IBlockData var11 = var2.a(var10);
               if(var11.getBlock().getMaterial() != Material.AIR) {
                  int var12 = var9 >> 4;
                  if(this.d[var12] == null) {
                     this.d[var12] = new class_aol(var12 << 4, var6);
                  }

                  this.d[var12].a(var7, var9 & 15, var8, var11);
               }
            }
         }
      }

   }

   public boolean a(int var1, int var2) {
      return var1 == this.a && var2 == this.b;
   }

   public int f(BlockPosition var1) {
      return this.b(var1.getX() & 15, var1.getZ() & 15);
   }

   public int b(int var1, int var2) {
      return this.j[var2 << 4 | var1];
   }

   public int g() {
      for(int var1 = this.d.length - 1; var1 >= 0; --var1) {
         if(this.d[var1] != null) {
            return this.d[var1].d();
         }
      }

      return 0;
   }

   public class_aol[] h() {
      return this.d;
   }

   public void b() {
      int var1 = this.g();
      this.t = Integer.MAX_VALUE;

      for(int var2 = 0; var2 < 16; ++var2) {
         for(int var3 = 0; var3 < 16; ++var3) {
            this.f[var2 + (var3 << 4)] = -999;

            int var4;
            for(var4 = var1 + 16; var4 > 0; --var4) {
               if(this.e(var2, var4 - 1, var3) != 0) {
                  this.j[var3 << 4 | var2] = var4;
                  if(var4 < this.t) {
                     this.t = var4;
                  }
                  break;
               }
            }

            if(!this.i.t.m()) {
               var4 = 15;
               int var5 = var1 + 16 - 1;

               do {
                  int var6 = this.e(var2, var5, var3);
                  if(var6 == 0 && var4 != 15) {
                     var6 = 1;
                  }

                  var4 -= var6;
                  if(var4 > 0) {
                     class_aol var7 = this.d[var5 >> 4];
                     if(var7 != null) {
                        var7.a(var2, var5 & 15, var3, var4);
                        this.i.n(new BlockPosition((this.a << 4) + var2, var5, (this.b << 4) + var3));
                     }
                  }

                  --var5;
               } while(var5 > 0 && var4 > 0);
            }
         }
      }

      this.q = true;
   }

   private void d(int var1, int var2) {
      this.g[var1 + var2 * 16] = true;
      this.k = true;
   }

   private void h(boolean var1) {
      this.i.B.a("recheckGaps");
      if(this.i.a((BlockPosition)(new BlockPosition(this.a * 16 + 8, 0, this.b * 16 + 8)), (int)16)) {
         for(int var2 = 0; var2 < 16; ++var2) {
            for(int var3 = 0; var3 < 16; ++var3) {
               if(this.g[var2 + var3 * 16]) {
                  this.g[var2 + var3 * 16] = false;
                  int var4 = this.b(var2, var3);
                  int var5 = this.a * 16 + var2;
                  int var6 = this.b * 16 + var3;
                  int var7 = Integer.MAX_VALUE;

                  Iterator var8;
                  EnumDirection var9;
                  for(var8 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator(); var8.hasNext(); var7 = Math.min(var7, this.i.b(var5 + var9.getAdjacentX(), var6 + var9.getAdjacentZ()))) {
                     var9 = (EnumDirection)var8.next();
                  }

                  this.c(var5, var6, var7);
                  var8 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

                  while(var8.hasNext()) {
                     var9 = (EnumDirection)var8.next();
                     this.c(var5 + var9.getAdjacentX(), var6 + var9.getAdjacentZ(), var4);
                  }

                  if(var1) {
                     this.i.B.b();
                     return;
                  }
               }
            }
         }

         this.k = false;
      }

      this.i.B.b();
   }

   private void c(int var1, int var2, int var3) {
      int var4 = this.i.m(new BlockPosition(var1, 0, var2)).getY();
      if(var4 > var3) {
         this.a(var1, var2, var3, var4 + 1);
      } else if(var4 < var3) {
         this.a(var1, var2, var4, var3 + 1);
      }

   }

   private void a(int var1, int var2, int var3, int var4) {
      if(var4 > var3 && this.i.a((BlockPosition)(new BlockPosition(var1, 0, var2)), (int)16)) {
         for(int var5 = var3; var5 < var4; ++var5) {
            this.i.c(class_aet.a, new BlockPosition(var1, var5, var2));
         }

         this.q = true;
      }

   }

   private void d(int var1, int var2, int var3) {
      int var4 = this.j[var3 << 4 | var1] & 255;
      int var5 = var4;
      if(var2 > var4) {
         var5 = var2;
      }

      while(var5 > 0 && this.e(var1, var5 - 1, var3) == 0) {
         --var5;
      }

      if(var5 != var4) {
         this.i.a(var1 + this.a * 16, var3 + this.b * 16, var5, var4);
         this.j[var3 << 4 | var1] = var5;
         int var6 = this.a * 16 + var1;
         int var7 = this.b * 16 + var3;
         int var8;
         int var13;
         if(!this.i.t.m()) {
            class_aol var9;
            if(var5 < var4) {
               for(var8 = var5; var8 < var4; ++var8) {
                  var9 = this.d[var8 >> 4];
                  if(var9 != null) {
                     var9.a(var1, var8 & 15, var3, 15);
                     this.i.n(new BlockPosition((this.a << 4) + var1, var8, (this.b << 4) + var3));
                  }
               }
            } else {
               for(var8 = var4; var8 < var5; ++var8) {
                  var9 = this.d[var8 >> 4];
                  if(var9 != null) {
                     var9.a(var1, var8 & 15, var3, 0);
                     this.i.n(new BlockPosition((this.a << 4) + var1, var8, (this.b << 4) + var3));
                  }
               }
            }

            var8 = 15;

            while(var5 > 0 && var8 > 0) {
               --var5;
               var13 = this.e(var1, var5, var3);
               if(var13 == 0) {
                  var13 = 1;
               }

               var8 -= var13;
               if(var8 < 0) {
                  var8 = 0;
               }

               class_aol var10 = this.d[var5 >> 4];
               if(var10 != null) {
                  var10.a(var1, var5 & 15, var3, var8);
               }
            }
         }

         var8 = this.j[var3 << 4 | var1];
         var13 = var4;
         int var14 = var8;
         if(var8 < var4) {
            var13 = var8;
            var14 = var4;
         }

         if(var8 < this.t) {
            this.t = var8;
         }

         if(!this.i.t.m()) {
            Iterator var11 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

            while(var11.hasNext()) {
               EnumDirection var12 = (EnumDirection)var11.next();
               this.a(var6 + var12.getAdjacentX(), var7 + var12.getAdjacentZ(), var13, var14);
            }

            this.a(var6, var7, var13, var14);
         }

         this.q = true;
      }
   }

   public int b(BlockPosition var1) {
      return this.a(var1).getLightOpacity();
   }

   private int e(int var1, int var2, int var3) {
      return this.f(var1, var2, var3).getLightOpacity();
   }

   private Block f(int var1, int var2, int var3) {
      Block var4 = Blocks.AIR;
      if(var2 >= 0 && var2 >> 4 < this.d.length) {
         class_aol var5 = this.d[var2 >> 4];
         if(var5 != null) {
            try {
               var4 = var5.b(var1, var2 & 15, var3);
            } catch (Throwable var8) {
               class_b var7 = class_b.a(var8, "Getting block");
               throw new class_e(var7);
            }
         }
      }

      return var4;
   }

   public Block a(final int var1, final int var2, final int var3) {
      try {
         return this.f(var1 & 15, var2, var3 & 15);
      } catch (class_e var6) {
         class_c var5 = var6.a().a("Block being got");
         var5.a("Location", new Callable() {
            public String a() throws Exception {
               return class_c.a(new BlockPosition(class_aok.this.a * 16 + var1, var2, class_aok.this.b * 16 + var3));
            }

            // $FF: synthetic method
            public Object call() throws Exception {
               return this.a();
            }
         });
         throw var6;
      }
   }

   public Block a(final BlockPosition var1) {
      try {
         return this.f(var1.getX() & 15, var1.getY(), var1.getZ() & 15);
      } catch (class_e var4) {
         class_c var3 = var4.a().a("Block being got");
         var3.a("Location", new Callable() {
            public String a() throws Exception {
               return class_c.a(var1);
            }

            // $FF: synthetic method
            public Object call() throws Exception {
               return this.a();
            }
         });
         throw var4;
      }
   }

   public IBlockData g(final BlockPosition var1) {
      if(this.i.H() == class_aes.g) {
         IBlockData var7 = null;
         if(var1.getY() == 60) {
            var7 = Blocks.BARRIER.getBlockData();
         }

         if(var1.getY() == 70) {
            var7 = class_apj.b(var1.getX(), var1.getZ());
         }

         return var7 == null?Blocks.AIR.getBlockData():var7;
      } else {
         try {
            if(var1.getY() >= 0 && var1.getY() >> 4 < this.d.length) {
               class_aol var2 = this.d[var1.getY() >> 4];
               if(var2 != null) {
                  int var8 = var1.getX() & 15;
                  int var9 = var1.getY() & 15;
                  int var5 = var1.getZ() & 15;
                  return var2.a(var8, var9, var5);
               }
            }

            return Blocks.AIR.getBlockData();
         } catch (Throwable var6) {
            class_b var3 = class_b.a(var6, "Getting block state");
            class_c var4 = var3.a("Block being got");
            var4.a("Location", new Callable() {
               public String a() throws Exception {
                  return class_c.a(var1);
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new class_e(var3);
         }
      }
   }

   private int g(int var1, int var2, int var3) {
      if(var2 >> 4 >= this.d.length) {
         return 0;
      } else {
         class_aol var4 = this.d[var2 >> 4];
         return var4 != null?var4.c(var1, var2 & 15, var3):0;
      }
   }

   public int c(BlockPosition var1) {
      return this.g(var1.getX() & 15, var1.getY(), var1.getZ() & 15);
   }

   public IBlockData a(BlockPosition var1, IBlockData var2) {
      int var3 = var1.getX() & 15;
      int var4 = var1.getY();
      int var5 = var1.getZ() & 15;
      int var6 = var5 << 4 | var3;
      if(var4 >= this.f[var6] - 1) {
         this.f[var6] = -999;
      }

      int var7 = this.j[var6];
      IBlockData var8 = this.g(var1);
      if(var8 == var2) {
         return null;
      } else {
         Block var9 = var2.getBlock();
         Block var10 = var8.getBlock();
         class_aol var11 = this.d[var4 >> 4];
         boolean var12 = false;
         if(var11 == null) {
            if(var9 == Blocks.AIR) {
               return null;
            }

            var11 = this.d[var4 >> 4] = new class_aol(var4 >> 4 << 4, !this.i.t.m());
            var12 = var4 >= var7;
         }

         var11.a(var3, var4 & 15, var5, var2);
         if(var10 != var9) {
            if(!this.i.D) {
               var10.b(this.i, var1, var8);
            } else if(var10 instanceof class_ahw) {
               this.i.t(var1);
            }
         }

         if(var11.b(var3, var4 & 15, var5) != var9) {
            return null;
         } else {
            if(var12) {
               this.b();
            } else {
               int var13 = var9.getLightOpacity();
               int var14 = var10.getLightOpacity();
               if(var13 > 0) {
                  if(var4 >= var7) {
                     this.d(var3, var4 + 1, var5);
                  }
               } else if(var4 == var7 - 1) {
                  this.d(var3, var4, var5);
               }

               if(var13 != var14 && (var13 < var14 || this.a(class_aet.a, var1) > 0 || this.a(class_aet.b, var1) > 0)) {
                  this.d(var3, var5);
               }
            }

            class_amg var15;
            if(var10 instanceof class_ahw) {
               var15 = this.a(var1, class_aok.class_a_in_class_aok.c);
               if(var15 != null) {
                  var15.E();
               }
            }

            if(!this.i.D && var10 != var9) {
               var9.c(this.i, var1, var2);
            }

            if(var9 instanceof class_ahw) {
               var15 = this.a(var1, class_aok.class_a_in_class_aok.c);
               if(var15 == null) {
                  var15 = ((class_ahw)var9).a(this.i, var9.toLegacyData(var2));
                  this.i.a(var1, var15);
               }

               if(var15 != null) {
                  var15.E();
               }
            }

            this.q = true;
            return var8;
         }
      }
   }

   public int a(class_aet var1, BlockPosition var2) {
      int var3 = var2.getX() & 15;
      int var4 = var2.getY();
      int var5 = var2.getZ() & 15;
      class_aol var6 = this.d[var4 >> 4];
      return var6 == null?(this.d(var2)?var1.c:0):(var1 == class_aet.a?(this.i.t.m()?0:var6.d(var3, var4 & 15, var5)):(var1 == class_aet.b?var6.e(var3, var4 & 15, var5):var1.c));
   }

   public void a(class_aet var1, BlockPosition var2, int var3) {
      int var4 = var2.getX() & 15;
      int var5 = var2.getY();
      int var6 = var2.getZ() & 15;
      class_aol var7 = this.d[var5 >> 4];
      if(var7 == null) {
         var7 = this.d[var5 >> 4] = new class_aol(var5 >> 4 << 4, !this.i.t.m());
         this.b();
      }

      this.q = true;
      if(var1 == class_aet.a) {
         if(!this.i.t.m()) {
            var7.a(var4, var5 & 15, var6, var3);
         }
      } else if(var1 == class_aet.b) {
         var7.b(var4, var5 & 15, var6, var3);
      }

   }

   public int a(BlockPosition var1, int var2) {
      int var3 = var1.getX() & 15;
      int var4 = var1.getY();
      int var5 = var1.getZ() & 15;
      class_aol var6 = this.d[var4 >> 4];
      if(var6 == null) {
         return !this.i.t.m() && var2 < class_aet.a.c?class_aet.a.c - var2:0;
      } else {
         int var7 = this.i.t.m()?0:var6.d(var3, var4 & 15, var5);
         var7 -= var2;
         int var8 = var6.e(var3, var4 & 15, var5);
         if(var8 > var7) {
            var7 = var8;
         }

         return var7;
      }
   }

   public void a(class_pr var1) {
      this.r = true;
      int var2 = MathHelper.floor(var1.s / 16.0D);
      int var3 = MathHelper.floor(var1.u / 16.0D);
      if(var2 != this.a || var3 != this.b) {
         c.warn("Wrong location! (" + var2 + ", " + var3 + ") should be (" + this.a + ", " + this.b + "), " + var1, new Object[]{var1});
         var1.J();
      }

      int var4 = MathHelper.floor(var1.t / 16.0D);
      if(var4 < 0) {
         var4 = 0;
      }

      if(var4 >= this.m.length) {
         var4 = this.m.length - 1;
      }

      var1.ad = true;
      var1.ae = this.a;
      var1.af = var4;
      var1.ag = this.b;
      this.m[var4].add(var1);
   }

   public void b(class_pr var1) {
      this.a(var1, var1.af);
   }

   public void a(class_pr var1, int var2) {
      if(var2 < 0) {
         var2 = 0;
      }

      if(var2 >= this.m.length) {
         var2 = this.m.length - 1;
      }

      this.m[var2].remove(var1);
   }

   public boolean d(BlockPosition var1) {
      int var2 = var1.getX() & 15;
      int var3 = var1.getY();
      int var4 = var1.getZ() & 15;
      return var3 >= this.j[var4 << 4 | var2];
   }

   private class_amg i(BlockPosition var1) {
      Block var2 = this.a(var1);
      return !var2.isTileEntity()?null:((class_ahw)var2).a(this.i, this.c(var1));
   }

   public class_amg a(BlockPosition var1, class_aok.class_a_in_class_aok var2) {
      class_amg var3 = (class_amg)this.l.get(var1);
      if(var3 == null) {
         if(var2 == class_aok.class_a_in_class_aok.a) {
            var3 = this.i(var1);
            this.i.a(var1, var3);
         } else if(var2 == class_aok.class_a_in_class_aok.b) {
            this.w.add(var1);
         }
      } else if(var3.x()) {
         this.l.remove(var1);
         return null;
      }

      return var3;
   }

   public void a(class_amg var1) {
      this.a(var1.v(), var1);
      if(this.h) {
         this.i.a(var1);
      }

   }

   public void a(BlockPosition var1, class_amg var2) {
      var2.a(this.i);
      var2.a(var1);
      if(this.a(var1) instanceof class_ahw) {
         if(this.l.containsKey(var1)) {
            ((class_amg)this.l.get(var1)).y();
         }

         var2.D();
         this.l.put(var1, var2);
      }
   }

   public void e(BlockPosition var1) {
      if(this.h) {
         class_amg var2 = (class_amg)this.l.remove(var1);
         if(var2 != null) {
            var2.y();
         }
      }

   }

   public void c() {
      this.h = true;
      this.i.b(this.l.values());

      for(int var1 = 0; var1 < this.m.length; ++var1) {
         Iterator var2 = this.m[var1].iterator();

         while(var2.hasNext()) {
            class_pr var3 = (class_pr)var2.next();
            var3.ah();
         }

         this.i.a((Collection)this.m[var1]);
      }

   }

   public void d() {
      this.h = false;
      Iterator var1 = this.l.values().iterator();

      while(var1.hasNext()) {
         class_amg var2 = (class_amg)var1.next();
         this.i.b(var2);
      }

      for(int var3 = 0; var3 < this.m.length; ++var3) {
         this.i.c((Collection)this.m[var3]);
      }

   }

   public void e() {
      this.q = true;
   }

   public void a(class_pr var1, class_awf var2, List var3, Predicate var4) {
      int var5 = MathHelper.floor((var2.b - 2.0D) / 16.0D);
      int var6 = MathHelper.floor((var2.e + 2.0D) / 16.0D);
      var5 = MathHelper.clamp(var5, 0, this.m.length - 1);
      var6 = MathHelper.clamp(var6, 0, this.m.length - 1);

      label68:
      for(int var7 = var5; var7 <= var6; ++var7) {
         if(!this.m[var7].isEmpty()) {
            Iterator var8 = this.m[var7].iterator();

            while(true) {
               class_pr var9;
               class_pr[] var10;
               do {
                  do {
                     do {
                        if(!var8.hasNext()) {
                           continue label68;
                        }

                        var9 = (class_pr)var8.next();
                     } while(!var9.aT().b(var2));
                  } while(var9 == var1);

                  if(var4 == null || var4.apply(var9)) {
                     var3.add(var9);
                  }

                  var10 = var9.aD();
               } while(var10 == null);

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  var9 = var10[var11];
                  if(var9 != var1 && var9.aT().b(var2) && (var4 == null || var4.apply(var9))) {
                     var3.add(var9);
                  }
               }
            }
         }
      }

   }

   public void a(Class var1, class_awf var2, List var3, Predicate var4) {
      int var5 = MathHelper.floor((var2.b - 2.0D) / 16.0D);
      int var6 = MathHelper.floor((var2.e + 2.0D) / 16.0D);
      var5 = MathHelper.clamp(var5, 0, this.m.length - 1);
      var6 = MathHelper.clamp(var6, 0, this.m.length - 1);

      label33:
      for(int var7 = var5; var7 <= var6; ++var7) {
         Iterator var8 = this.m[var7].c(var1).iterator();

         while(true) {
            class_pr var9;
            do {
               do {
                  if(!var8.hasNext()) {
                     continue label33;
                  }

                  var9 = (class_pr)var8.next();
               } while(!var9.aT().b(var2));
            } while(var4 != null && !var4.apply(var9));

            var3.add(var9);
         }
      }

   }

   public boolean a(boolean var1) {
      if(var1) {
         if(this.r && this.i.L() != this.s || this.q) {
            return true;
         }
      } else if(this.r && this.i.L() >= this.s + 600L) {
         return true;
      }

      return this.q;
   }

   public Random a(long var1) {
      return new Random(this.i.K() + (long)(this.a * this.a * 4987142) + (long)(this.a * 5947611) + (long)(this.b * this.b) * 4392871L + (long)(this.b * 389711) ^ var1);
   }

   public boolean f() {
      return false;
   }

   public void a(class_aoh var1, class_aoh var2, int var3, int var4) {
      boolean var5 = var1.a(var3, var4 - 1);
      boolean var6 = var1.a(var3 + 1, var4);
      boolean var7 = var1.a(var3, var4 + 1);
      boolean var8 = var1.a(var3 - 1, var4);
      boolean var9 = var1.a(var3 - 1, var4 - 1);
      boolean var10 = var1.a(var3 + 1, var4 + 1);
      boolean var11 = var1.a(var3 - 1, var4 + 1);
      boolean var12 = var1.a(var3 + 1, var4 - 1);
      if(var6 && var7 && var10) {
         if(!this.n) {
            var1.a(var2, var3, var4);
         } else {
            var1.a(var2, this, var3, var4);
         }
      }

      class_aok var13;
      if(var8 && var7 && var11) {
         var13 = var1.d(var3 - 1, var4);
         if(!var13.n) {
            var1.a(var2, var3 - 1, var4);
         } else {
            var1.a(var2, var13, var3 - 1, var4);
         }
      }

      if(var5 && var6 && var12) {
         var13 = var1.d(var3, var4 - 1);
         if(!var13.n) {
            var1.a(var2, var3, var4 - 1);
         } else {
            var1.a(var2, var13, var3, var4 - 1);
         }
      }

      if(var9 && var5 && var8) {
         var13 = var1.d(var3 - 1, var4 - 1);
         if(!var13.n) {
            var1.a(var2, var3 - 1, var4 - 1);
         } else {
            var1.a(var2, var13, var3 - 1, var4 - 1);
         }
      }

   }

   public BlockPosition h(BlockPosition var1) {
      int var2 = var1.getX() & 15;
      int var3 = var1.getZ() & 15;
      int var4 = var2 | var3 << 4;
      BlockPosition var5 = new BlockPosition(var1.getX(), this.f[var4], var1.getZ());
      if(var5.getY() == -999) {
         int var6 = this.g() + 15;
         var5 = new BlockPosition(var1.getX(), var6, var1.getZ());
         int var7 = -1;

         while(true) {
            while(var5.getY() > 0 && var7 == -1) {
               Block var8 = this.a(var5);
               Material var9 = var8.getMaterial();
               if(!var9.isSolid() && !var9.isLiquid()) {
                  var5 = var5.shiftDown();
               } else {
                  var7 = var5.getY() + 1;
               }
            }

            this.f[var4] = var7;
            break;
         }
      }

      return new BlockPosition(var1.getX(), this.f[var4], var1.getZ());
   }

   public void b(boolean var1) {
      if(this.k && !this.i.t.m() && !var1) {
         this.h(this.i.D);
      }

      this.p = true;
      if(!this.o && this.n) {
         this.n();
      }

      while(!this.w.isEmpty()) {
         BlockPosition var2 = (BlockPosition)this.w.poll();
         if(this.a(var2, class_aok.class_a_in_class_aok.c) == null && this.a(var2).isTileEntity()) {
            class_amg var3 = this.i(var2);
            this.i.a(var2, var3);
            this.i.b(var2, var2);
         }
      }

   }

   public boolean i() {
      return this.p && this.n && this.o;
   }

   public class_aeh j() {
      return new class_aeh(this.a, this.b);
   }

   public boolean c(int var1, int var2) {
      if(var1 < 0) {
         var1 = 0;
      }

      if(var2 >= 256) {
         var2 = 255;
      }

      for(int var3 = var1; var3 <= var2; var3 += 16) {
         class_aol var4 = this.d[var3 >> 4];
         if(var4 != null && !var4.a()) {
            return false;
         }
      }

      return true;
   }

   public void a(class_aol[] var1) {
      if(this.d.length != var1.length) {
         c.warn("Could not set level chunk sections, array length is " + var1.length + " instead of " + this.d.length);
      } else {
         for(int var2 = 0; var2 < this.d.length; ++var2) {
            this.d[var2] = var1[var2];
         }

      }
   }

   public class_aez a(BlockPosition var1, class_afd var2) {
      int var3 = var1.getX() & 15;
      int var4 = var1.getZ() & 15;
      int var5 = this.e[var4 << 4 | var3] & 255;
      class_aez var6;
      if(var5 == 255) {
         var6 = var2.a(var1, class_aez.q);
         var5 = var6.az;
         this.e[var4 << 4 | var3] = (byte)(var5 & 255);
      }

      var6 = class_aez.e(var5);
      return var6 == null?class_aez.q:var6;
   }

   public byte[] k() {
      return this.e;
   }

   public void a(byte[] var1) {
      if(this.e.length != var1.length) {
         c.warn("Could not set level chunk biomes, array length is " + var1.length + " instead of " + this.e.length);
      } else {
         for(int var2 = 0; var2 < this.e.length; ++var2) {
            this.e[var2] = var1[var2];
         }

      }
   }

   public void l() {
      this.v = 0;
   }

   public void m() {
      BlockPosition var1 = new BlockPosition(this.a << 4, 0, this.b << 4);

      for(int var2 = 0; var2 < 8; ++var2) {
         if(this.v >= 4096) {
            return;
         }

         int var3 = this.v % 16;
         int var4 = this.v / 16 % 16;
         int var5 = this.v / 256;
         ++this.v;

         for(int var6 = 0; var6 < 16; ++var6) {
            BlockPosition var7 = var1.add(var4, (var3 << 4) + var6, var5);
            boolean var8 = var6 == 0 || var6 == 15 || var4 == 0 || var4 == 15 || var5 == 0 || var5 == 15;
            if(this.d[var3] == null && var8 || this.d[var3] != null && this.d[var3].b(var4, var6, var5).getMaterial() == Material.AIR) {
               EnumDirection[] var9 = EnumDirection.values();
               int var10 = var9.length;

               for(int var11 = 0; var11 < var10; ++var11) {
                  EnumDirection var12 = var9[var11];
                  BlockPosition var13 = var7.shift(var12);
                  if(this.i.p(var13).getBlock().getLightLevel() > 0) {
                     this.i.x(var13);
                  }
               }

               this.i.x(var7);
            }
         }
      }

   }

   public void n() {
      this.n = true;
      this.o = true;
      BlockPosition var1 = new BlockPosition(this.a << 4, 0, this.b << 4);
      if(!this.i.t.m()) {
         if(this.i.a(var1.add(-1, 0, -1), var1.add(16, this.i.G(), 16))) {
            label44:
            for(int var2 = 0; var2 < 16; ++var2) {
               for(int var3 = 0; var3 < 16; ++var3) {
                  if(!this.e(var2, var3)) {
                     this.o = false;
                     break label44;
                  }
               }
            }

            if(this.o) {
               Iterator var5 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

               while(var5.hasNext()) {
                  EnumDirection var6 = (EnumDirection)var5.next();
                  int var4 = var6.getAxisDirection() == EnumDirection.EnumAxisDirection.POSITIVE?16:1;
                  this.i.f(var1.shift(var6, var4)).a(var6.getOpposite());
               }

               this.y();
            }
         } else {
            this.o = false;
         }
      }

   }

   private void y() {
      for(int var1 = 0; var1 < this.g.length; ++var1) {
         this.g[var1] = true;
      }

      this.h(false);
   }

   private void a(EnumDirection var1) {
      if(this.n) {
         int var2;
         if(var1 == EnumDirection.EAST) {
            for(var2 = 0; var2 < 16; ++var2) {
               this.e(15, var2);
            }
         } else if(var1 == EnumDirection.WEST) {
            for(var2 = 0; var2 < 16; ++var2) {
               this.e(0, var2);
            }
         } else if(var1 == EnumDirection.SOUTH) {
            for(var2 = 0; var2 < 16; ++var2) {
               this.e(var2, 15);
            }
         } else if(var1 == EnumDirection.NORTH) {
            for(var2 = 0; var2 < 16; ++var2) {
               this.e(var2, 0);
            }
         }

      }
   }

   private boolean e(int var1, int var2) {
      int var3 = this.g();
      boolean var4 = false;
      boolean var5 = false;
      BlockPosition.MutableBlockPosition var6 = new BlockPosition.MutableBlockPosition((this.a << 4) + var1, 0, (this.b << 4) + var2);

      int var7;
      for(var7 = var3 + 16 - 1; var7 > this.i.G() || var7 > 0 && !var5; --var7) {
         var6.setPosition(var6.getX(), var7, var6.getZ());
         int var8 = this.b((BlockPosition)var6);
         if(var8 == 255 && var6.getY() < this.i.G()) {
            var5 = true;
         }

         if(!var4 && var8 > 0) {
            var4 = true;
         } else if(var4 && var8 == 0 && !this.i.x(var6)) {
            return false;
         }
      }

      for(var7 = var6.getY(); var7 > 0; --var7) {
         var6.setPosition(var6.getX(), var7, var6.getZ());
         if(this.a((BlockPosition)var6).getLightLevel() > 0) {
            this.i.x(var6);
         }
      }

      return true;
   }

   public boolean o() {
      return this.h;
   }

   public World p() {
      return this.i;
   }

   public int[] q() {
      return this.j;
   }

   public void a(int[] var1) {
      if(this.j.length != var1.length) {
         c.warn("Could not set level chunk heightmap, array length is " + var1.length + " instead of " + this.j.length);
      } else {
         for(int var2 = 0; var2 < this.j.length; ++var2) {
            this.j[var2] = var1[var2];
         }

      }
   }

   public Map r() {
      return this.l;
   }

   public class_ng[] s() {
      return this.m;
   }

   public boolean t() {
      return this.n;
   }

   public void d(boolean var1) {
      this.n = var1;
   }

   public boolean u() {
      return this.o;
   }

   public void e(boolean var1) {
      this.o = var1;
   }

   public void f(boolean var1) {
      this.q = var1;
   }

   public void g(boolean var1) {
      this.r = var1;
   }

   public void b(long var1) {
      this.s = var1;
   }

   public int v() {
      return this.t;
   }

   public long w() {
      return this.u;
   }

   public void c(long var1) {
      this.u = var1;
   }

   public static enum class_a_in_class_aok {
      a,
      b,
      c;
   }
}
