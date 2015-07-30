package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_aew;
import net.minecraft.server.class_auv;
import net.minecraft.server.class_auw;
import net.minecraft.server.class_awf;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_wl;

public abstract class class_tg {
   protected class_qb b;
   protected World c;
   protected class_auv d;
   protected double e;
   private final class_ql a;
   private int f;
   private int g;
   private Vec3D h = new Vec3D(0.0D, 0.0D, 0.0D);
   private float i = 1.0F;
   private final class_auw j;

   public class_tg(class_qb var1, World var2) {
      this.b = var1;
      this.c = var2;
      this.a = var1.a((class_qk)class_wl.b);
      this.j = this.a();
   }

   protected abstract class_auw a();

   public void a(double var1) {
      this.e = var1;
   }

   public float i() {
      return (float)this.a.e();
   }

   public final class_auv a(double var1, double var3, double var5) {
      return this.a(new BlockPosition(MathHelper.floor(var1), (int)var3, MathHelper.floor(var5)));
   }

   public class_auv a(BlockPosition var1) {
      if(!this.b()) {
         return null;
      } else {
         float var2 = this.i();
         this.c.B.a("pathfind");
         BlockPosition var3 = new BlockPosition(this.b);
         int var4 = (int)(var2 + 8.0F);
         class_aew var5 = new class_aew(this.c, var3.add(-var4, -var4, -var4), var3.add(var4, var4, var4), 0);
         class_auv var6 = this.j.a((class_aer)var5, (class_pr)this.b, (BlockPosition)var1, var2);
         this.c.B.b();
         return var6;
      }
   }

   public boolean a(double var1, double var3, double var5, double var7) {
      class_auv var9 = this.a((double)MathHelper.floor(var1), (double)((int)var3), (double)MathHelper.floor(var5));
      return this.a(var9, var7);
   }

   public void a(float var1) {
      this.i = var1;
   }

   public class_auv a(class_pr var1) {
      if(!this.b()) {
         return null;
      } else {
         float var2 = this.i();
         this.c.B.a("pathfind");
         BlockPosition var3 = (new BlockPosition(this.b)).shiftUp();
         int var4 = (int)(var2 + 16.0F);
         class_aew var5 = new class_aew(this.c, var3.add(-var4, -var4, -var4), var3.add(var4, var4, var4), 0);
         class_auv var6 = this.j.a((class_aer)var5, (class_pr)this.b, (class_pr)var1, var2);
         this.c.B.b();
         return var6;
      }
   }

   public boolean a(class_pr var1, double var2) {
      class_auv var4 = this.a(var1);
      return var4 != null?this.a(var4, var2):false;
   }

   public boolean a(class_auv var1, double var2) {
      if(var1 == null) {
         this.d = null;
         return false;
      } else {
         if(!var1.a(this.d)) {
            this.d = var1;
         }

         this.d();
         if(this.d.d() == 0) {
            return false;
         } else {
            this.e = var2;
            Vec3D var4 = this.c();
            this.g = this.f;
            this.h = var4;
            return true;
         }
      }
   }

   public class_auv j() {
      return this.d;
   }

   public void k() {
      ++this.f;
      if(!this.m()) {
         Vec3D var1;
         if(this.b()) {
            this.l();
         } else if(this.d != null && this.d.e() < this.d.d()) {
            var1 = this.c();
            Vec3D var2 = this.d.a(this.b, this.d.e());
            if(var1.y > var2.y && !this.b.C && MathHelper.floor(var1.x) == MathHelper.floor(var2.x) && MathHelper.floor(var1.z) == MathHelper.floor(var2.z)) {
               this.d.c(this.d.e() + 1);
            }
         }

         if(!this.m()) {
            var1 = this.d.a((class_pr)this.b);
            if(var1 != null) {
               class_awf var8 = (new class_awf(var1.x, var1.y, var1.z, var1.x, var1.y, var1.z)).b(0.5D, 0.5D, 0.5D);
               List var3 = this.c.a((class_pr)this.b, (class_awf)var8.a(0.0D, -1.0D, 0.0D));
               double var4 = -1.0D;
               var8 = var8.c(0.0D, 1.0D, 0.0D);

               class_awf var7;
               for(Iterator var6 = var3.iterator(); var6.hasNext(); var4 = var7.b(var8, var4)) {
                  var7 = (class_awf)var6.next();
               }

               this.b.r().a(var1.x, var1.y + var4, var1.z, this.e);
            }
         }
      }
   }

   protected void l() {
      Vec3D var1 = this.c();
      int var2 = this.d.d();

      for(int var3 = this.d.e(); var3 < this.d.d(); ++var3) {
         if(this.d.a(var3).b != (int)var1.y) {
            var2 = var3;
            break;
         }
      }

      float var8 = this.b.J * this.b.J * this.i;

      int var4;
      for(var4 = this.d.e(); var4 < var2; ++var4) {
         Vec3D var5 = this.d.a(this.b, var4);
         if(var1.distanceSquared(var5) < (double)var8) {
            this.d.c(var4 + 1);
         }
      }

      var4 = MathHelper.ceil(this.b.J);
      int var9 = (int)this.b.K + 1;
      int var6 = var4;

      for(int var7 = var2 - 1; var7 >= this.d.e(); --var7) {
         if(this.a(var1, this.d.a(this.b, var7), var4, var9, var6)) {
            this.d.c(var7);
            break;
         }
      }

      this.a(var1);
   }

   protected void a(Vec3D var1) {
      if(this.f - this.g > 100) {
         if(var1.distanceSquared(this.h) < 2.25D) {
            this.n();
         }

         this.g = this.f;
         this.h = var1;
      }

   }

   public boolean m() {
      return this.d == null || this.d.b();
   }

   public void n() {
      this.d = null;
   }

   protected abstract Vec3D c();

   protected abstract boolean b();

   protected boolean o() {
      return this.b.V() || this.b.ab();
   }

   protected void d() {
   }

   protected abstract boolean a(Vec3D var1, Vec3D var2, int var3, int var4, int var5);
}
