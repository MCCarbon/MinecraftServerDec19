package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.server.class_ads;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_vw;
import net.minecraft.server.class_xa;

public class class_aej {
   private final boolean a;
   private final boolean b;
   private final Random c = new Random();
   private final World d;
   private final double e;
   private final double f;
   private final double g;
   private final class_pr h;
   private final float i;
   private final List j = Lists.newArrayList();
   private final Map k = Maps.newHashMap();

   public class_aej(World var1, class_pr var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11) {
      this.d = var1;
      this.h = var2;
      this.i = var9;
      this.e = var3;
      this.f = var5;
      this.g = var7;
      this.a = var10;
      this.b = var11;
   }

   public void a() {
      HashSet var1 = Sets.newHashSet();
      boolean var2 = true;

      int var4;
      int var5;
      for(int var3 = 0; var3 < 16; ++var3) {
         for(var4 = 0; var4 < 16; ++var4) {
            for(var5 = 0; var5 < 16; ++var5) {
               if(var3 == 0 || var3 == 15 || var4 == 0 || var4 == 15 || var5 == 0 || var5 == 15) {
                  double var6 = (double)((float)var3 / 15.0F * 2.0F - 1.0F);
                  double var8 = (double)((float)var4 / 15.0F * 2.0F - 1.0F);
                  double var10 = (double)((float)var5 / 15.0F * 2.0F - 1.0F);
                  double var12 = Math.sqrt(var6 * var6 + var8 * var8 + var10 * var10);
                  var6 /= var12;
                  var8 /= var12;
                  var10 /= var12;
                  float var14 = this.i * (0.7F + this.d.s.nextFloat() * 0.6F);
                  double var15 = this.e;
                  double var17 = this.f;
                  double var19 = this.g;

                  for(float var21 = 0.3F; var14 > 0.0F; var14 -= 0.22500001F) {
                     class_cj var22 = new class_cj(var15, var17, var19);
                     IBlockData var23 = this.d.p(var22);
                     if(var23.getBlock().getMaterial() != Material.a) {
                        float var24 = this.h != null?this.h.a(this, this.d, var22, var23):var23.getBlock().a((class_pr)null);
                        var14 -= (var24 + 0.3F) * 0.3F;
                     }

                     if(var14 > 0.0F && (this.h == null || this.h.a(this, this.d, var22, var23, var14))) {
                        var1.add(var22);
                     }

                     var15 += var6 * 0.30000001192092896D;
                     var17 += var8 * 0.30000001192092896D;
                     var19 += var10 * 0.30000001192092896D;
                  }
               }
            }
         }
      }

      this.j.addAll(var1);
      float var30 = this.i * 2.0F;
      var4 = class_nu.c(this.e - (double)var30 - 1.0D);
      var5 = class_nu.c(this.e + (double)var30 + 1.0D);
      int var31 = class_nu.c(this.f - (double)var30 - 1.0D);
      int var7 = class_nu.c(this.f + (double)var30 + 1.0D);
      int var32 = class_nu.c(this.g - (double)var30 - 1.0D);
      int var9 = class_nu.c(this.g + (double)var30 + 1.0D);
      List var33 = this.d.b(this.h, new class_awf((double)var4, (double)var31, (double)var32, (double)var5, (double)var7, (double)var9));
      class_awh var11 = new class_awh(this.e, this.f, this.g);

      for(int var34 = 0; var34 < var33.size(); ++var34) {
         class_pr var13 = (class_pr)var33.get(var34);
         if(!var13.aX()) {
            double var35 = var13.f(this.e, this.f, this.g) / (double)var30;
            if(var35 <= 1.0D) {
               double var16 = var13.s - this.e;
               double var18 = var13.t + (double)var13.aU() - this.f;
               double var20 = var13.u - this.g;
               double var36 = (double)class_nu.a(var16 * var16 + var18 * var18 + var20 * var20);
               if(var36 != 0.0D) {
                  var16 /= var36;
                  var18 /= var36;
                  var20 /= var36;
                  double var37 = (double)this.d.a(var11, var13.aT());
                  double var26 = (1.0D - var35) * var37;
                  var13.a(class_pc.a(this), (float)((int)((var26 * var26 + var26) / 2.0D * 8.0D * (double)var30 + 1.0D)));
                  double var28 = 1.0D;
                  if(var13 instanceof class_qa) {
                     var28 = class_ads.a((class_qa)var13, var26);
                  }

                  var13.v += var16 * var28;
                  var13.w += var18 * var28;
                  var13.x += var20 * var28;
                  if(var13 instanceof class_xa && !((class_xa)var13).bH.a) {
                     this.k.put((class_xa)var13, new class_awh(var16 * var26, var18 * var26, var20 * var26));
                  }
               }
            }
         }
      }

   }

   public void a(boolean var1) {
      this.d.a(this.e, this.f, this.g, "random.explode", 4.0F, (1.0F + (this.d.s.nextFloat() - this.d.s.nextFloat()) * 0.2F) * 0.7F);
      if(this.i >= 2.0F && this.b) {
         this.d.a(class_cy.c, this.e, this.f, this.g, 1.0D, 0.0D, 0.0D, new int[0]);
      } else {
         this.d.a(class_cy.b, this.e, this.f, this.g, 1.0D, 0.0D, 0.0D, new int[0]);
      }

      Iterator var2;
      class_cj var3;
      if(this.b) {
         var2 = this.j.iterator();

         while(var2.hasNext()) {
            var3 = (class_cj)var2.next();
            Block var4 = this.d.p(var3).getBlock();
            if(var1) {
               double var5 = (double)((float)var3.n() + this.d.s.nextFloat());
               double var7 = (double)((float)var3.o() + this.d.s.nextFloat());
               double var9 = (double)((float)var3.p() + this.d.s.nextFloat());
               double var11 = var5 - this.e;
               double var13 = var7 - this.f;
               double var15 = var9 - this.g;
               double var17 = (double)class_nu.a(var11 * var11 + var13 * var13 + var15 * var15);
               var11 /= var17;
               var13 /= var17;
               var15 /= var17;
               double var19 = 0.5D / (var17 / (double)this.i + 0.1D);
               var19 *= (double)(this.d.s.nextFloat() * this.d.s.nextFloat() + 0.3F);
               var11 *= var19;
               var13 *= var19;
               var15 *= var19;
               this.d.a(class_cy.a, (var5 + this.e * 1.0D) / 2.0D, (var7 + this.f * 1.0D) / 2.0D, (var9 + this.g * 1.0D) / 2.0D, var11, var13, var15, new int[0]);
               this.d.a(class_cy.l, var5, var7, var9, var11, var13, var15, new int[0]);
            }

            if(var4.getMaterial() != Material.a) {
               if(var4.a(this)) {
                  var4.a(this.d, var3, this.d.p(var3), 1.0F / this.i, 0);
               }

               this.d.a((class_cj)var3, (IBlockData)Blocks.AIR.getBlockData(), 3);
               var4.a(this.d, var3, this);
            }
         }
      }

      if(this.a) {
         var2 = this.j.iterator();

         while(var2.hasNext()) {
            var3 = (class_cj)var2.next();
            if(this.d.p(var3).getBlock().getMaterial() == Material.a && this.d.p(var3.b()).getBlock().isFullBlock() && this.c.nextInt(3) == 0) {
               this.d.a(var3, Blocks.FIRE.getBlockData());
            }
         }
      }

   }

   public Map b() {
      return this.k;
   }

   public class_qa c() {
      return this.h == null?null:(this.h instanceof class_vw?((class_vw)this.h).j():(this.h instanceof class_qa?(class_qa)this.h:null));
   }

   public void d() {
      this.j.clear();
   }

   public List e() {
      return this.j;
   }
}
