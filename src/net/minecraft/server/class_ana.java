package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_apd;
import net.minecraft.server.class_aqi;
import net.minecraft.server.class_aqj;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dy;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ft;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ana extends class_amg implements class_kn {
   private static final Logger a = LogManager.getLogger();
   private long f = 0L;
   private int g = 0;
   private class_cj h;

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("Life", this.f);
      if(this.h != null) {
         var1.a((String)"ExitPortal", (class_eb)class_dy.a(this.h));
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      this.f = var1.h("Life");
      if(var1.b("ExitPortal", 10)) {
         this.h = class_dy.c(var1.n("ExitPortal"));
      }

   }

   public void c() {
      boolean var1 = this.b();
      boolean var2 = this.d();
      ++this.f;
      if(var2) {
         --this.g;
      } else if(!this.b.D) {
         List var3 = this.b.a(class_pr.class, new class_awf(this.v()));
         if(!var3.isEmpty()) {
            this.a((class_pr)var3.get(0));
         }
      }

      if(var1 != this.b() || var2 != this.d()) {
         this.p_();
      }

   }

   public boolean b() {
      return this.f < 200L;
   }

   public boolean d() {
      return this.g > 0;
   }

   public class_ff z_() {
      class_dn var1 = new class_dn();
      this.b(var1);
      return new class_ft(this.c, 8, var1);
   }

   public void h() {
      if(!this.b.D) {
         this.g = 20;
         this.b.c(this.v(), this.w(), 1, 0);
         this.p_();
      }

   }

   public boolean c(int var1, int var2) {
      if(var1 == 1) {
         this.g = 20;
         return true;
      } else {
         return super.c(var1, var2);
      }
   }

   public void a(class_pr var1) {
      if(!this.b.D && !this.d()) {
         this.g = 100;
         if(this.h == null && this.b.t instanceof class_apd) {
            this.j();
         }

         if(this.h != null) {
            class_cj var2 = this.i();
            var1.a((double)var2.n() + 0.5D, (double)var2.o() + 1.5D, (double)var2.p() + 0.5D);
         }

         this.h();
      }
   }

   private class_cj i() {
      class_cj var1 = a(this.b, this.h, 5, false);
      a.debug("Best exit position for portal at " + this.h + " is " + var1);
      return var1.a();
   }

   private void j() {
      class_awh var1 = (new class_awh((double)this.v().n(), 0.0D, (double)this.v().p())).a();
      class_awh var2 = var1.a(1024.0D);

      int var3;
      for(var3 = 16; a(this.b, var2).g() > 0 && var3-- > 0; var2 = var2.e(var1.a(-16.0D))) {
         a.debug("Skipping backwards past nonempty chunk at " + var2);
      }

      for(var3 = 16; a(this.b, var2).g() == 0 && var3-- > 0; var2 = var2.e(var1.a(16.0D))) {
         a.debug("Skipping forward past empty chunk at " + var2);
      }

      a.debug("Found chunk at " + var2);
      class_aok var4 = a(this.b, var2);
      this.h = a(var4);
      if(this.h == null) {
         this.h = new class_cj(var2.a + 0.5D, 75.0D, var2.c + 0.5D);
         a.debug("Failed to find suitable block, settling on " + this.h);
         (new class_aqj()).b(this.b, new Random(this.h.g()), this.h);
      } else {
         a.debug("Found block at " + this.h);
      }

      this.h = a(this.b, this.h, 16, true);
      a.debug("Creating portal at " + this.h);
      this.h = this.h.b(10);
      this.b(this.h);
      this.p_();
   }

   private static class_cj a(World var0, class_cj var1, int var2, boolean var3) {
      class_cj var4 = null;

      for(int var5 = -var2; var5 <= var2; ++var5) {
         for(int var6 = -var2; var6 <= var2; ++var6) {
            if(var5 != 0 || var6 != 0 || var3) {
               for(int var7 = 255; var7 > (var4 == null?0:var4.o()); --var7) {
                  class_cj var8 = new class_cj(var1.n() + var5, var7, var1.p() + var6);
                  IBlockData var9 = var0.p(var8);
                  if(var9.getBlock().isSoildFullCube() && (var3 || var9.getBlock() != Blocks.BEDROCK)) {
                     var4 = var8;
                     break;
                  }
               }
            }
         }
      }

      return var4 == null?var1:var4;
   }

   private static class_aok a(World var0, class_awh var1) {
      return var0.a(class_nu.c(var1.a / 16.0D), class_nu.c(var1.c / 16.0D));
   }

   private static class_cj a(class_aok var0) {
      class_cj var1 = new class_cj(var0.a * 16, 30, var0.b * 16);
      int var2 = var0.g() + 16 - 1;
      class_cj var3 = new class_cj(var0.a * 16 + 16 - 1, var2, var0.b * 16 + 16 - 1);
      class_cj var4 = null;
      double var5 = 0.0D;
      Iterator var7 = class_cj.a(var1, var3).iterator();

      while(true) {
         class_cj var8;
         double var10;
         do {
            do {
               IBlockData var9;
               do {
                  do {
                     if(!var7.hasNext()) {
                        return var4;
                     }

                     var8 = (class_cj)var7.next();
                     var9 = var0.g(var8);
                  } while(var9.getBlock() != Blocks.END_STONE);
               } while(var0.a(var8.b(1)).isSoildFullCube());
            } while(var0.a(var8.b(2)).isSoildFullCube());

            var10 = var8.d(0.0D, 0.0D, 0.0D);
         } while(var4 != null && var10 >= var5);

         var4 = var8;
         var5 = var10;
      }
   }

   private void b(class_cj var1) {
      (new class_aqi()).b(this.b, new Random(), var1);
      class_amg var2 = this.b.s(var1);
      if(var2 instanceof class_ana) {
         class_ana var3 = (class_ana)var2;
         var3.h = new class_cj(this.v());
         var3.p_();
      } else {
         a.warn("Couldn\'t save exit portal at " + var1);
      }

   }
}
