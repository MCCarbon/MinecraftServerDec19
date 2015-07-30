package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_ave;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.Packet;
import net.minecraft.server.class_gu;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_va;
import net.minecraft.server.class_xa;

public class class_avf extends class_avd {
   public int b;
   public int c;
   public byte d;
   public byte e;
   public byte[] f = new byte[16384];
   public List g = Lists.newArrayList();
   private Map i = Maps.newHashMap();
   public Map h = Maps.newLinkedHashMap();

   public class_avf(String var1) {
      super(var1);
   }

   public void a(double var1, double var3, int var5) {
      int var6 = 128 * (1 << var5);
      int var7 = MathHelper.floor((var1 + 64.0D) / (double)var6);
      int var8 = MathHelper.floor((var3 + 64.0D) / (double)var6);
      this.b = var7 * var6 + var6 / 2 - 64;
      this.c = var8 * var6 + var6 / 2 - 64;
   }

   public void a(class_dn var1) {
      this.d = var1.e("dimension");
      this.b = var1.g("xCenter");
      this.c = var1.g("zCenter");
      this.e = var1.e("scale");
      this.e = (byte)MathHelper.clamp(this.e, 0, 4);
      short var2 = var1.f("width");
      short var3 = var1.f("height");
      if(var2 == 128 && var3 == 128) {
         this.f = var1.l("colors");
      } else {
         byte[] var4 = var1.l("colors");
         this.f = new byte[16384];
         int var5 = (128 - var2) / 2;
         int var6 = (128 - var3) / 2;

         for(int var7 = 0; var7 < var3; ++var7) {
            int var8 = var7 + var6;
            if(var8 >= 0 || var8 < 128) {
               for(int var9 = 0; var9 < var2; ++var9) {
                  int var10 = var9 + var5;
                  if(var10 >= 0 || var10 < 128) {
                     this.f[var10 + var8 * 128] = var4[var9 + var7 * var2];
                  }
               }
            }
         }
      }

   }

   public void b(class_dn var1) {
      var1.a("dimension", this.d);
      var1.a("xCenter", this.b);
      var1.a("zCenter", this.c);
      var1.a("scale", this.e);
      var1.a("width", (short)128);
      var1.a("height", (short)128);
      var1.a("colors", this.f);
   }

   public void a(class_xa var1, class_aas var2) {
      if(!this.i.containsKey(var1)) {
         class_avf.class_a_in_class_avf var3 = new class_avf.class_a_in_class_avf(var1);
         this.i.put(var1, var3);
         this.g.add(var3);
      }

      if(!var1.bp.c(var2)) {
         this.h.remove(var1.e_());
      }

      for(int var6 = 0; var6 < this.g.size(); ++var6) {
         class_avf.class_a_in_class_avf var4 = (class_avf.class_a_in_class_avf)this.g.get(var6);
         if(var4.a.I || !var4.a.bp.c(var2) && !var2.y()) {
            this.i.remove(var4.a);
            this.g.remove(var4);
         } else if(!var2.y() && var4.a.am == this.d) {
            this.a(0, var4.a.o, var4.a.e_(), var4.a.s, var4.a.u, (double)var4.a.y);
         }
      }

      if(var2.y()) {
         class_va var7 = var2.z();
         BlockPosition var8 = var7.n();
         this.a(1, var1.o, "frame-" + var7.getId(), (double)var8.getX(), (double)var8.getZ(), (double)(var7.b.getHorizontalId() * 90));
      }

      if(var2.n() && var2.o().b("Decorations", 9)) {
         class_du var9 = var2.o().c("Decorations", 10);

         for(int var10 = 0; var10 < var9.c(); ++var10) {
            class_dn var5 = var9.b(var10);
            if(!this.h.containsKey(var5.k("id"))) {
               this.a(var5.e("type"), var1.o, var5.k("id"), var5.j("x"), var5.j("z"), var5.j("rot"));
            }
         }
      }

   }

   private void a(int var1, World var2, String var3, double var4, double var6, double var8) {
      int var10 = 1 << this.e;
      float var11 = (float)(var4 - (double)this.b) / (float)var10;
      float var12 = (float)(var6 - (double)this.c) / (float)var10;
      byte var13 = (byte)((int)((double)(var11 * 2.0F) + 0.5D));
      byte var14 = (byte)((int)((double)(var12 * 2.0F) + 0.5D));
      byte var16 = 63;
      byte var15;
      if(var11 >= (float)(-var16) && var12 >= (float)(-var16) && var11 <= (float)var16 && var12 <= (float)var16) {
         var8 += var8 < 0.0D?-8.0D:8.0D;
         var15 = (byte)((int)(var8 * 16.0D / 360.0D));
         if(this.d < 0) {
            int var17 = (int)(var2.Q().g() / 10L);
            var15 = (byte)(var17 * var17 * 34187121 + var17 * 121 >> 15 & 15);
         }
      } else {
         if(Math.abs(var11) >= 320.0F || Math.abs(var12) >= 320.0F) {
            this.h.remove(var3);
            return;
         }

         var1 = 6;
         var15 = 0;
         if(var11 <= (float)(-var16)) {
            var13 = (byte)((int)((double)(var16 * 2) + 2.5D));
         }

         if(var12 <= (float)(-var16)) {
            var14 = (byte)((int)((double)(var16 * 2) + 2.5D));
         }

         if(var11 >= (float)var16) {
            var13 = (byte)(var16 * 2 + 1);
         }

         if(var12 >= (float)var16) {
            var14 = (byte)(var16 * 2 + 1);
         }
      }

      this.h.put(var3, new class_ave((byte)var1, var13, var14, var15));
   }

   public Packet a(class_aas var1, World var2, class_xa var3) {
      class_avf.class_a_in_class_avf var4 = (class_avf.class_a_in_class_avf)this.i.get(var3);
      return var4 == null?null:var4.a(var1);
   }

   public void a(int var1, int var2) {
      super.c();
      Iterator var3 = this.g.iterator();

      while(var3.hasNext()) {
         class_avf.class_a_in_class_avf var4 = (class_avf.class_a_in_class_avf)var3.next();
         var4.a(var1, var2);
      }

   }

   public class_avf.class_a_in_class_avf a(class_xa var1) {
      class_avf.class_a_in_class_avf var2 = (class_avf.class_a_in_class_avf)this.i.get(var1);
      if(var2 == null) {
         var2 = new class_avf.class_a_in_class_avf(var1);
         this.i.put(var1, var2);
         this.g.add(var2);
      }

      return var2;
   }

   public class class_a_in_class_avf {
      public final class_xa a;
      private boolean d = true;
      private int e = 0;
      private int f = 0;
      private int g = 127;
      private int h = 127;
      private int i;
      public int b;

      public class_a_in_class_avf(class_xa var2) {
         this.a = var2;
      }

      public Packet a(class_aas var1) {
         if(this.d) {
            this.d = false;
            return new class_gu(var1.i(), class_avf.this.e, class_avf.this.h.values(), class_avf.this.f, this.e, this.f, this.g + 1 - this.e, this.h + 1 - this.f);
         } else {
            return this.i++ % 5 == 0?new class_gu(var1.i(), class_avf.this.e, class_avf.this.h.values(), class_avf.this.f, 0, 0, 0, 0):null;
         }
      }

      public void a(int var1, int var2) {
         if(this.d) {
            this.e = Math.min(this.e, var1);
            this.f = Math.min(this.f, var2);
            this.g = Math.max(this.g, var1);
            this.h = Math.max(this.h, var2);
         } else {
            this.d = true;
            this.e = var1;
            this.f = var2;
            this.g = var1;
            this.h = var2;
         }

      }
   }
}
