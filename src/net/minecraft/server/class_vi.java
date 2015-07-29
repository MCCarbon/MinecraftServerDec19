package net.minecraft.server;

import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.Blocks;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_om;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_vh;

public class class_vi extends class_vh {
   private int b;
   public long a;
   private int c;

   public class_vi(World var1, double var2, double var4, double var6) {
      super(var1);
      this.b(var2, var4, var6, 0.0F, 0.0F);
      this.b = 2;
      this.a = this.V.nextLong();
      this.c = this.V.nextInt(3) + 1;
      class_cj var8 = new class_cj(this);
      if(!var1.D && var1.R().b("doFireTick") && (var1.ab() == class_om.c || var1.ab() == class_om.d) && var1.a((class_cj)var8, (int)10)) {
         if(var1.p(var8).getBlock().getMaterial() == Material.a && Blocks.FIRE.d(var1, var8)) {
            var1.a(var8, Blocks.FIRE.getBlockData());
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            class_cj var10 = var8.a(this.V.nextInt(3) - 1, this.V.nextInt(3) - 1, this.V.nextInt(3) - 1);
            if(var1.p(var10).getBlock().getMaterial() == Material.a && Blocks.FIRE.d(var1, var10)) {
               var1.a(var10, Blocks.FIRE.getBlockData());
            }
         }
      }

   }

   public void t_() {
      super.t_();
      if(this.b == 2) {
         this.o.a(this.s, this.t, this.u, "ambient.weather.thunder", 10000.0F, 0.8F + this.V.nextFloat() * 0.2F);
         this.o.a(this.s, this.t, this.u, "random.explode", 2.0F, 0.5F + this.V.nextFloat() * 0.2F);
      }

      --this.b;
      if(this.b < 0) {
         if(this.c == 0) {
            this.J();
         } else if(this.b < -this.V.nextInt(10)) {
            --this.c;
            this.b = 1;
            this.a = this.V.nextLong();
            class_cj var1 = new class_cj(this);
            if(!this.o.D && this.o.R().b("doFireTick") && this.o.a((class_cj)var1, (int)10) && this.o.p(var1).getBlock().getMaterial() == Material.a && Blocks.FIRE.d(this.o, var1)) {
               this.o.a(var1, Blocks.FIRE.getBlockData());
            }
         }
      }

      if(this.b >= 0) {
         if(this.o.D) {
            this.o.d(2);
         } else {
            double var6 = 3.0D;
            List var3 = this.o.b((class_pr)this, (class_awf)(new class_awf(this.s - var6, this.t - var6, this.u - var6, this.s + var6, this.t + 6.0D + var6, this.u + var6)));

            for(int var4 = 0; var4 < var3.size(); ++var4) {
               class_pr var5 = (class_pr)var3.get(var4);
               var5.a(this);
            }
         }
      }

   }

   protected void h() {
   }

   protected void a(class_dn var1) {
   }

   protected void b(class_dn var1) {
   }
}
