package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_any;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;

public abstract class class_aio extends Block {
   public static final class_any a = class_any.a("half", class_aio.class_a_in_class_aio.class);

   public class_aio(class_atk var1) {
      super(var1);
      if(this.l()) {
         this.r = true;
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

      this.e(255);
   }

   protected boolean K() {
      return false;
   }

   public void a(class_aer var1, class_cj var2) {
      if(this.l()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         IBlockData var3 = var1.p(var2);
         if(var3.getBlock() == this) {
            if(var3.get(a) == class_aio.class_a_in_class_aio.a) {
               this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            }
         }

      }
   }

   public void j() {
      if(this.l()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      this.a(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
   }

   public boolean c() {
      return this.l();
   }

   public IBlockData a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      IBlockData var9 = super.a(var1, var2, var3, var4, var5, var6, var7, var8).set(a, class_aio.class_a_in_class_aio.b);
      return this.l()?var9:(var3 != class_cq.a && (var3 == class_cq.b || (double)var5 <= 0.5D)?var9:var9.set(a, class_aio.class_a_in_class_aio.a));
   }

   public int a(Random var1) {
      return this.l()?2:1;
   }

   public boolean d() {
      return this.l();
   }

   public abstract String b(int var1);

   public int j(class_aen var1, class_cj var2) {
      return super.j(var1, var2) & 7;
   }

   public abstract boolean l();

   public abstract IBlockState n();

   public abstract Object a(class_aas var1);

   public static enum class_a_in_class_aio implements class_ny {
      a("top"),
      b("bottom");

      private final String c;

      private class_a_in_class_aio(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String l() {
         return this.c;
      }
   }
}
