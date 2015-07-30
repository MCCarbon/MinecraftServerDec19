package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aeh;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_all;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_ast;
import net.minecraft.server.class_asu;
import net.minecraft.server.class_asv;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.BaseBlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.Packet;
import net.minecraft.server.class_ft;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.INamable;
import net.minecraft.server.class_nz;
import net.minecraft.server.class_pr;

public class class_amz extends class_amg {
   private String a = "";
   private String f = "";
   private String g = "";
   private BlockPosition h = new BlockPosition(1, 1, 1);
   private BlockPosition i = new BlockPosition(0, 0, 0);
   private Block.class_a_in_class_agj j;
   private Block.class_c_in_class_agj k;
   private class_amz.class_a_in_class_amz l;
   private boolean m;

   public class_amz() {
      this.j = Block.class_a_in_class_agj.a;
      this.k = Block.class_c_in_class_agj.a;
      this.l = class_amz.class_a_in_class_amz.d;
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("name", this.a);
      var1.a("author", this.f);
      var1.a("metadata", this.g);
      var1.a("posX", this.h.getX());
      var1.a("posY", this.h.getY());
      var1.a("posZ", this.h.getZ());
      var1.a("sizeX", this.i.getX());
      var1.a("sizeY", this.i.getY());
      var1.a("sizeZ", this.i.getZ());
      var1.a("rotation", this.k.toString());
      var1.a("mirror", this.j.toString());
      var1.a("mode", this.l.toString());
      var1.a("ignoreEntities", this.m);
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.a = var1.k("name");
      this.f = var1.k("author");
      this.g = var1.k("metadata");
      this.h = new BlockPosition(var1.g("posX"), var1.g("posY"), var1.g("posZ"));
      this.i = new BlockPosition(var1.g("sizeX"), var1.g("sizeY"), var1.g("sizeZ"));

      try {
         this.k = Block.class_c_in_class_agj.valueOf(var1.k("rotation"));
      } catch (IllegalArgumentException var5) {
         this.k = Block.class_c_in_class_agj.a;
      }

      try {
         this.j = Block.class_a_in_class_agj.valueOf(var1.k("mirror"));
      } catch (IllegalArgumentException var4) {
         this.j = Block.class_a_in_class_agj.a;
      }

      try {
         this.l = class_amz.class_a_in_class_amz.valueOf(var1.k("mode"));
      } catch (IllegalArgumentException var3) {
         this.l = class_amz.class_a_in_class_amz.d;
      }

      this.m = var1.o("ignoreEntities");
   }

   public Packet z_() {
      class_dn var1 = new class_dn();
      this.b(var1);
      return new class_ft(this.c, 7, var1);
   }

   public void a(String var1) {
      this.a = var1;
   }

   public void b(BlockPosition var1) {
      this.h = var1;
   }

   public void c(BlockPosition var1) {
      this.i = var1;
   }

   public void a(Block.class_a_in_class_agj var1) {
      this.j = var1;
   }

   public void a(Block.class_c_in_class_agj var1) {
      this.k = var1;
   }

   public void b(String var1) {
      this.g = var1;
   }

   public void a(class_amz.class_a_in_class_amz var1) {
      this.l = var1;
      IBlockData var2 = this.b.p(this.v());
      if(var2.getBlock() == Blocks.STRUCTURE_BLOCK) {
         this.b.a((BlockPosition)this.v(), (IBlockData)var2.set(class_all.a, var1), 2);
      }

   }

   public void a(boolean var1) {
      this.m = var1;
   }

   public boolean l() {
      if(this.l != class_amz.class_a_in_class_amz.a) {
         return false;
      } else {
         BlockPosition var1 = this.v();
         boolean var2 = true;
         BlockPosition var3 = new BlockPosition(var1.getX() - 128, 0, var1.getZ() - 128);
         BlockPosition var4 = new BlockPosition(var1.getX() + 128, 255, var1.getZ() + 128);
         List var5 = this.a(var3, var4);
         List var6 = this.a(var5);
         if(var6.size() < 1) {
            return false;
         } else {
            class_arw var7 = this.a(var1, var6);
            if(var7.d - var7.a > 1 && var7.e - var7.b > 1 && var7.f - var7.c > 1) {
               this.h = new BlockPosition(var7.a - var1.getX() + 1, var7.b - var1.getY() + 1, var7.c - var1.getZ() + 1);
               this.i = new BlockPosition(var7.d - var7.a - 1, var7.e - var7.b - 1, var7.f - var7.c - 1);
               this.p_();
               this.b.h(var1);
               return true;
            } else {
               return false;
            }
         }
      }
   }

   private List a(List var1) {
      Iterable var2 = Iterables.filter(var1, (Predicate)(new Predicate() {
         public boolean a(class_amz var1) {
            return var1.l == class_amz.class_a_in_class_amz.c && class_amz.this.a.equals(var1.a);
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_amz)var1);
         }
      }));
      return Lists.newArrayList(var2);
   }

   private List a(BlockPosition var1, BlockPosition var2) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = BlockPosition.allInCubeM(var1, var2).iterator();

      while(var4.hasNext()) {
         BlockPosition.MutableBlockPosition var5 = (BlockPosition.MutableBlockPosition)var4.next();
         IBlockData var6 = this.b.p(var5);
         if(var6.getBlock() == Blocks.STRUCTURE_BLOCK) {
            class_amg var7 = this.b.s(var5);
            if(var7 != null && var7 instanceof class_amz) {
               var3.add((class_amz)var7);
            }
         }
      }

      return var3;
   }

   private class_arw a(BlockPosition var1, List var2) {
      class_arw var3;
      if(var2.size() > 1) {
         BlockPosition var4 = ((class_amz)var2.get(0)).v();
         var3 = new class_arw(var4, var4);
      } else {
         var3 = new class_arw(var1, var1);
      }

      Iterator var7 = var2.iterator();

      while(var7.hasNext()) {
         class_amz var5 = (class_amz)var7.next();
         BlockPosition var6 = var5.v();
         if(var6.getX() < var3.a) {
            var3.a = var6.getX();
         } else if(var6.getX() > var3.d) {
            var3.d = var6.getX();
         }

         if(var6.getY() < var3.b) {
            var3.b = var6.getY();
         } else if(var6.getY() > var3.e) {
            var3.e = var6.getY();
         }

         if(var6.getZ() < var3.c) {
            var3.c = var6.getZ();
         } else if(var6.getZ() > var3.f) {
            var3.f = var6.getZ();
         }
      }

      return var3;
   }

   public boolean m() {
      if(this.l != class_amz.class_a_in_class_amz.a) {
         return false;
      } else {
         BlockPosition var1 = this.v().add((BaseBlockPosition)this.h);
         class_ast var2 = ((class_all)this.w()).l();
         class_asv var3 = var2.a(new MinecraftKey(this.a));
         var3.a(this.b, var1, this.i, !this.m);
         var3.a(this.f);
         var2.c(new MinecraftKey(this.a));
         return true;
      }
   }

   public boolean n() {
      if(this.l != class_amz.class_a_in_class_amz.b) {
         return false;
      } else {
         BlockPosition var1 = this.v().add((BaseBlockPosition)this.h);
         class_ast var2 = ((class_all)this.w()).l();
         class_asv var3 = var2.a(new MinecraftKey(this.a));
         if(!class_nz.b(var3.b())) {
            this.f = var3.b();
         }

         if(!this.i.equals(var3.a())) {
            this.i = var3.a();
            return false;
         } else {
            BlockPosition var4 = var3.a(this.k);
            Iterator var5 = this.b.b((class_pr)null, (class_awf)(new class_awf(var1, var4.add((BaseBlockPosition)var1).add(-1, -1, -1)))).iterator();

            while(var5.hasNext()) {
               class_pr var6 = (class_pr)var5.next();
               this.b.f(var6);
            }

            class_asu var7 = (new class_asu()).a(this.j).a(this.k).a(this.m).a((class_aeh)null).b(false).c(false);
            var3.a(this.b, var1, var7);
            return true;
         }
      }
   }

   public static enum class_a_in_class_amz implements INamable {
      a("save", 0),
      b("load", 1),
      c("corner", 2),
      d("data", 3);

      private static final class_amz.class_a_in_class_amz[] e;
      private final String f;
      private final int g;

      private class_a_in_class_amz(String var3, int var4) {
         this.f = var3;
         this.g = var4;
      }

      public String getName() {
         return this.f;
      }

      public int a() {
         return this.g;
      }

      public static class_amz.class_a_in_class_amz a(int var0) {
         if(var0 < 0 || var0 >= e.length) {
            var0 = 0;
         }

         return e[var0];
      }

      static {
         e = new class_amz.class_a_in_class_amz[values().length];
         class_amz.class_a_in_class_amz[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_amz.class_a_in_class_amz var3 = var0[var2];
            e[var3.a()] = var3;
         }

      }
   }
}
