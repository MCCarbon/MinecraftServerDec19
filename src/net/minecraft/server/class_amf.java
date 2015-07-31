package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_alb;
import net.minecraft.server.class_alc;
import net.minecraft.server.class_amu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.Packet;
import net.minecraft.server.class_ft;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_pk;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_uf;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yc;
import net.minecraft.server.class_zy;

public class class_amf extends class_amu implements class_kn, class_oj {
   public static final class_pk[][] a;
   private final List f = Lists.newArrayList();
   private boolean i;
   private int j = -1;
   private class_pk k;
   private class_pk l;
   private ItemStack m;
   private String n;

   public void c() {
      if(this.b.L() % 80L == 0L) {
         this.m();
      }

   }

   public void m() {
      this.B();
      this.A();
   }

   private void A() {
      if(this.i && this.j > 0 && !this.b.D && this.k != null) {
         double var1 = (double)(this.j * 10 + 10);
         byte var3 = 0;
         if(this.j >= 4 && this.k == this.l) {
            var3 = 1;
         }

         int var4 = this.c.getX();
         int var5 = this.c.getY();
         int var6 = this.c.getZ();
         class_awf var7 = (new class_awf((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1))).b(var1, var1, var1).a(0.0D, (double)this.b.V(), 0.0D);
         List var8 = this.b.a(class_xa.class, var7);
         Iterator var9 = var8.iterator();

         class_xa var10;
         while(var9.hasNext()) {
            var10 = (class_xa)var9.next();
            var10.c(new class_pl(this.k, 180, var3, true, true));
         }

         if(this.j >= 4 && this.k != this.l && this.l != null) {
            var9 = var8.iterator();

            while(var9.hasNext()) {
               var10 = (class_xa)var9.next();
               var10.c(new class_pl(this.l, 180, 0, true, true));
            }
         }
      }

   }

   private void B() {
      int var1 = this.j;
      int var2 = this.c.getX();
      int var3 = this.c.getY();
      int var4 = this.c.getZ();
      this.j = 0;
      this.f.clear();
      this.i = true;
      class_amf.class_a_in_class_amf var5 = new class_amf.class_a_in_class_amf(class_uf.a(class_zy.a));
      this.f.add(var5);
      boolean var6 = true;
      BlockPosition.MutableBlockPosition var7 = new BlockPosition.MutableBlockPosition();

      int var8;
      for(var8 = var3 + 1; var8 < 256; ++var8) {
         IBlockData var9 = this.b.p(var7.setPosition(var2, var8, var4));
         float[] var10;
         if(var9.getBlock() == Blocks.STAINED_GLASS) {
            var10 = class_uf.a((class_zy)var9.get(class_alb.a));
         } else {
            if(var9.getBlock() != Blocks.STAINED_GLASS_PANE) {
               if(var9.getBlock().getLightOpacity() >= 15 && var9.getBlock() != Blocks.BEDROCK) {
                  this.i = false;
                  this.f.clear();
                  break;
               }

               var5.a();
               continue;
            }

            var10 = class_uf.a((class_zy)var9.get(class_alc.a));
         }

         if(!var6) {
            var10 = new float[]{(var5.b()[0] + var10[0]) / 2.0F, (var5.b()[1] + var10[1]) / 2.0F, (var5.b()[2] + var10[2]) / 2.0F};
         }

         if(Arrays.equals(var10, var5.b())) {
            var5.a();
         } else {
            var5 = new class_amf.class_a_in_class_amf(var10);
            this.f.add(var5);
         }

         var6 = false;
      }

      if(this.i) {
         for(var8 = 1; var8 <= 4; this.j = var8++) {
            int var15 = var3 - var8;
            if(var15 < 0) {
               break;
            }

            boolean var17 = true;

            for(int var11 = var2 - var8; var11 <= var2 + var8 && var17; ++var11) {
               for(int var12 = var4 - var8; var12 <= var4 + var8; ++var12) {
                  Block var13 = this.b.p(new BlockPosition(var11, var15, var12)).getBlock();
                  if(var13 != Blocks.EMERALD_BLOCK && var13 != Blocks.GOLD_BLOCK && var13 != Blocks.DIAMOND_BLOCK && var13 != Blocks.IRON_BLOCK) {
                     var17 = false;
                     break;
                  }
               }
            }

            if(!var17) {
               break;
            }
         }

         if(this.j == 0) {
            this.i = false;
         }
      }

      if(!this.b.D && this.j == 4 && var1 < this.j) {
         Iterator var14 = this.b.a(class_xa.class, (new class_awf((double)var2, (double)var3, (double)var4, (double)var2, (double)(var3 - 4), (double)var4)).b(10.0D, 5.0D, 10.0D)).iterator();

         while(var14.hasNext()) {
            class_xa var16 = (class_xa)var14.next();
            var16.b((class_my)class_mt.K);
         }
      }

   }

   public Packet z_() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.b(var1);
      return new class_ft(this.c, 3, var1);
   }

   private static class_pk f(int var0) {
      class_pk var1 = class_pk.a(var0);
      return var1 != class_pm.a && var1 != class_pm.c && var1 != class_pm.k && var1 != class_pm.h && var1 != class_pm.e && var1 != class_pm.j?null:var1;
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.k = f(var1.getInt("Primary"));
      this.l = f(var1.getInt("Secondary"));
      this.j = var1.getInt("Levels");
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("Primary", class_pk.a(this.k));
      var1.put("Secondary", class_pk.a(this.l));
      var1.put("Levels", this.j);
   }

   public int o_() {
      return 1;
   }

   public ItemStack a(int var1) {
      return var1 == 0?this.m:null;
   }

   public ItemStack a(int var1, int var2) {
      if(var1 == 0 && this.m != null) {
         if(var2 >= this.m.count) {
            ItemStack var3 = this.m;
            this.m = null;
            return var3;
         } else {
            this.m.count -= var2;
            return new ItemStack(this.m.getItem(), var2, this.m.i());
         }
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      if(var1 == 0 && this.m != null) {
         ItemStack var2 = this.m;
         this.m = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      if(var1 == 0) {
         this.m = var2;
      }

   }

   public String e_() {
      return this.l_()?this.n:"container.beacon";
   }

   public boolean l_() {
      return this.n != null && !this.n.isEmpty();
   }

   public void a(String var1) {
      this.n = var1;
   }

   public int q_() {
      return 1;
   }

   public boolean a(class_xa var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.getX() + 0.5D, (double)this.c.getY() + 0.5D, (double)this.c.getZ() + 0.5D) <= 64.0D;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, ItemStack var2) {
      return var2.getItem() == Items.bR || var2.getItem() == Items.k || var2.getItem() == Items.m || var2.getItem() == Items.l;
   }

   public String k() {
      return "minecraft:beacon";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yc(var1, this);
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.j;
      case 1:
         return class_pk.a(this.k);
      case 2:
         return class_pk.a(this.l);
      default:
         return 0;
      }
   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.j = var2;
         break;
      case 1:
         this.k = f(var2);
         break;
      case 2:
         this.l = f(var2);
      }

   }

   public int g() {
      return 3;
   }

   public void l() {
      this.m = null;
   }

   public boolean c(int var1, int var2) {
      if(var1 == 1) {
         this.m();
         return true;
      } else {
         return super.c(var1, var2);
      }
   }

   static {
      a = new class_pk[][]{{class_pm.a, class_pm.c}, {class_pm.k, class_pm.h}, {class_pm.e}, {class_pm.j}};
   }

   public static class class_a_in_class_amf {
      private final float[] a;
      private int b;

      public class_a_in_class_amf(float[] var1) {
         this.a = var1;
         this.b = 1;
      }

      protected void a() {
         ++this.b;
      }

      public float[] b() {
         return this.a;
      }
   }
}
