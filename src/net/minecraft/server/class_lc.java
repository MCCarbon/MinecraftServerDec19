package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aep;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fs;
import net.minecraft.server.class_gq;
import net.minecraft.server.class_gs;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class class_lc implements class_aep {
   private MinecraftServer a;
   private class_lg b;

   public class_lc(MinecraftServer var1, class_lg var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
   }

   public void a(class_pr var1) {
      this.b.t().a(var1);
      if(var1 instanceof class_lh) {
         this.b.t.a((class_lh)var1);
      }

   }

   public void b(class_pr var1) {
      this.b.t().b(var1);
      this.b.aa().a(var1);
      if(var1 instanceof class_lh) {
         this.b.t.b((class_lh)var1);
      }

   }

   public void a(String var1, double var2, double var4, double var6, float var8, float var9) {
      this.a.ap().a(var2, var4, var6, var8 > 1.0F?(double)(16.0F * var8):16.0D, this.b.t.p().a(), new class_gs(var1, var2, var4, var6, var8, var9));
   }

   public void a(class_xa var1, String var2, double var3, double var5, double var7, float var9, float var10) {
      this.a.ap().a(var1, var3, var5, var7, var9 > 1.0F?(double)(16.0F * var9):16.0D, this.b.t.p().a(), new class_gs(var2, var3, var5, var7, var9, var10));
   }

   public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   public void a(BlockPosition var1) {
      this.b.u().a(var1);
   }

   public void b(BlockPosition var1) {
   }

   public void a(String var1, BlockPosition var2) {
   }

   public void a(class_xa var1, int var2, BlockPosition var3, int var4) {
      this.a.ap().a(var1, (double)var3.getX(), (double)var3.getY(), (double)var3.getZ(), 64.0D, this.b.t.p().a(), new class_gq(var2, var3, var4, false));
   }

   public void a(int var1, BlockPosition var2, int var3) {
      this.a.ap().a((class_ff)(new class_gq(var1, var2, var3, true)));
   }

   public void b(int var1, BlockPosition var2, int var3) {
      Iterator var4 = this.a.ap().v().iterator();

      while(var4.hasNext()) {
         class_lh var5 = (class_lh)var4.next();
         if(var5 != null && var5.o == this.b && var5.F() != var1) {
            double var6 = (double)var2.getX() - var5.s;
            double var8 = (double)var2.getY() - var5.t;
            double var10 = (double)var2.getZ() - var5.u;
            if(var6 * var6 + var8 * var8 + var10 * var10 < 1024.0D) {
               var5.a.a((class_ff)(new class_fs(var1, var2, var3)));
            }
         }
      }

   }
}
