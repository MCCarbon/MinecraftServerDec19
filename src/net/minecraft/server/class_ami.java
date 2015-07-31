package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Block;
import net.minecraft.server.class_agu;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amu;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_oi;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yf;

public class class_ami extends class_amu implements class_kn, class_oj {
   private ItemStack[] m = new ItemStack[27];
   public boolean a;
   public class_ami f;
   public class_ami g;
   public class_ami h;
   public class_ami i;
   public float j;
   public float k;
   public int l;
   private int n;
   private int o = -1;
   private String p;

   public int o_() {
      return 27;
   }

   public ItemStack a(int var1) {
      return this.m[var1];
   }

   public ItemStack a(int var1, int var2) {
      if(this.m[var1] != null) {
         ItemStack var3;
         if(this.m[var1].count <= var2) {
            var3 = this.m[var1];
            this.m[var1] = null;
            this.p_();
            return var3;
         } else {
            var3 = this.m[var1].a(var2);
            if(this.m[var1].count == 0) {
               this.m[var1] = null;
            }

            this.p_();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack b(int var1) {
      if(this.m[var1] != null) {
         ItemStack var2 = this.m[var1];
         this.m[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, ItemStack var2) {
      this.m[var1] = var2;
      if(var2 != null && var2.count > this.q_()) {
         var2.count = this.q_();
      }

      this.p_();
   }

   public String e_() {
      return this.l_()?this.p:"container.chest";
   }

   public boolean l_() {
      return this.p != null && !this.p.isEmpty();
   }

   public void a(String var1) {
      this.p = var1;
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      NBTTagList var2 = var1.getList("Items", 10);
      this.m = new ItemStack[this.o_()];
      if(var1.hasOfType("CustomName", 8)) {
         this.p = var1.getString("CustomName");
      }

      for(int var3 = 0; var3 < var2.getSize(); ++var3) {
         NBTTagCompound var4 = var2.getCompound(var3);
         int var5 = var4.getByte("Slot") & 255;
         if(var5 >= 0 && var5 < this.m.length) {
            this.m[var5] = ItemStack.a(var4);
         }
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.m.length; ++var3) {
         if(this.m[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.put("Slot", (byte)var3);
            this.m[var3].write(var4);
            var2.add((NBTTag)var4);
         }
      }

      var1.put((String)"Items", (NBTTag)var2);
      if(this.l_()) {
         var1.put("CustomName", this.p);
      }

   }

   public int q_() {
      return 64;
   }

   public boolean a(class_xa var1) {
      return this.b.s(this.c) != this?false:var1.e((double)this.c.getX() + 0.5D, (double)this.c.getY() + 0.5D, (double)this.c.getZ() + 0.5D) <= 64.0D;
   }

   public void E() {
      super.E();
      this.a = false;
   }

   private void a(class_ami var1, EnumDirection var2) {
      if(var1.x()) {
         this.a = false;
      } else if(this.a) {
         switch(class_ami.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            if(this.f != var1) {
               this.a = false;
            }
            break;
         case 2:
            if(this.i != var1) {
               this.a = false;
            }
            break;
         case 3:
            if(this.g != var1) {
               this.a = false;
            }
            break;
         case 4:
            if(this.h != var1) {
               this.a = false;
            }
         }
      }

   }

   public void m() {
      if(!this.a) {
         this.a = true;
         this.h = this.a(EnumDirection.WEST);
         this.g = this.a(EnumDirection.EAST);
         this.f = this.a(EnumDirection.NORTH);
         this.i = this.a(EnumDirection.SOUTH);
      }
   }

   protected class_ami a(EnumDirection var1) {
      BlockPosition var2 = this.c.shift(var1);
      if(this.b(var2)) {
         class_amg var3 = this.b.s(var2);
         if(var3 instanceof class_ami) {
            class_ami var4 = (class_ami)var3;
            var4.a(this, var1.getOpposite());
            return var4;
         }
      }

      return null;
   }

   private boolean b(BlockPosition var1) {
      if(this.b == null) {
         return false;
      } else {
         Block var2 = this.b.p(var1).getBlock();
         return var2 instanceof class_agu && ((class_agu)var2).b == this.n();
      }
   }

   public void c() {
      this.m();
      int var1 = this.c.getX();
      int var2 = this.c.getY();
      int var3 = this.c.getZ();
      ++this.n;
      float var4;
      if(!this.b.D && this.l != 0 && (this.n + var1 + var2 + var3) % 200 == 0) {
         this.l = 0;
         var4 = 5.0F;
         List var5 = this.b.a(class_xa.class, new class_awf((double)((float)var1 - var4), (double)((float)var2 - var4), (double)((float)var3 - var4), (double)((float)(var1 + 1) + var4), (double)((float)(var2 + 1) + var4), (double)((float)(var3 + 1) + var4)));
         Iterator var6 = var5.iterator();

         label93:
         while(true) {
            class_oj var8;
            do {
               class_xa var7;
               do {
                  if(!var6.hasNext()) {
                     break label93;
                  }

                  var7 = (class_xa)var6.next();
               } while(!(var7.br instanceof class_yf));

               var8 = ((class_yf)var7.br).e();
            } while(var8 != this && (!(var8 instanceof class_oi) || !((class_oi)var8).a((class_oj)this)));

            ++this.l;
         }
      }

      this.k = this.j;
      var4 = 0.1F;
      double var14;
      if(this.l > 0 && this.j == 0.0F && this.f == null && this.h == null) {
         double var11 = (double)var1 + 0.5D;
         var14 = (double)var3 + 0.5D;
         if(this.i != null) {
            var14 += 0.5D;
         }

         if(this.g != null) {
            var11 += 0.5D;
         }

         this.b.a(var11, (double)var2 + 0.5D, var14, "random.chestopen", 0.5F, this.b.s.nextFloat() * 0.1F + 0.9F);
      }

      if(this.l == 0 && this.j > 0.0F || this.l > 0 && this.j < 1.0F) {
         float var12 = this.j;
         if(this.l > 0) {
            this.j += var4;
         } else {
            this.j -= var4;
         }

         if(this.j > 1.0F) {
            this.j = 1.0F;
         }

         float var13 = 0.5F;
         if(this.j < var13 && var12 >= var13 && this.f == null && this.h == null) {
            var14 = (double)var1 + 0.5D;
            double var9 = (double)var3 + 0.5D;
            if(this.i != null) {
               var9 += 0.5D;
            }

            if(this.g != null) {
               var14 += 0.5D;
            }

            this.b.a(var14, (double)var2 + 0.5D, var9, "random.chestclosed", 0.5F, this.b.s.nextFloat() * 0.1F + 0.9F);
         }

         if(this.j < 0.0F) {
            this.j = 0.0F;
         }
      }

   }

   public boolean c(int var1, int var2) {
      if(var1 == 1) {
         this.l = var2;
         return true;
      } else {
         return super.c(var1, var2);
      }
   }

   public void b(class_xa var1) {
      if(!var1.v()) {
         if(this.l < 0) {
            this.l = 0;
         }

         ++this.l;
         this.b.c(this.c, this.w(), 1, this.l);
         this.b.c(this.c, this.w());
         this.b.c(this.c.shiftDown(), this.w());
      }

   }

   public void c(class_xa var1) {
      if(!var1.v() && this.w() instanceof class_agu) {
         --this.l;
         this.b.c(this.c, this.w(), 1, this.l);
         this.b.c(this.c, this.w());
         this.b.c(this.c.shiftDown(), this.w());
      }

   }

   public boolean b(int var1, ItemStack var2) {
      return true;
   }

   public void y() {
      super.y();
      this.E();
      this.m();
   }

   public int n() {
      if(this.o == -1) {
         if(this.b == null || !(this.w() instanceof class_agu)) {
            return 0;
         }

         this.o = ((class_agu)this.w()).b;
      }

      return this.o;
   }

   public String k() {
      return "minecraft:chest";
   }

   public class_xz a(class_wz var1, class_xa var2) {
      return new class_yf(var1, this, var2);
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {
   }

   public int g() {
      return 0;
   }

   public void l() {
      for(int var1 = 0; var1 < this.m.length; ++var1) {
         this.m[var1] = null;
      }

   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.NORTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.SOUTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.EAST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
