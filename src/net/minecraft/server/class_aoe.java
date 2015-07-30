package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_aoc;
import net.minecraft.server.class_aod;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_pr;

public class class_aoe {
   private final List a = Lists.newArrayList();
   private double b = 0.0D;
   private double c = 0.0D;
   private double d = 6.0E7D;
   private double e;
   private long f;
   private long g;
   private int h;
   private double i;
   private double j;
   private int k;
   private int l;

   public class_aoe() {
      this.e = this.d;
      this.h = 29999984;
      this.i = 0.2D;
      this.j = 5.0D;
      this.k = 15;
      this.l = 5;
   }

   public boolean a(BlockPosition var1) {
      return (double)(var1.getX() + 1) > this.b() && (double)var1.getX() < this.d() && (double)(var1.getZ() + 1) > this.c() && (double)var1.getZ() < this.e();
   }

   public boolean a(class_aeh var1) {
      return (double)var1.e() > this.b() && (double)var1.c() < this.d() && (double)var1.f() > this.c() && (double)var1.d() < this.e();
   }

   public boolean a(class_awf var1) {
      return var1.d > this.b() && var1.a < this.d() && var1.f > this.c() && var1.c < this.e();
   }

   public double a(class_pr var1) {
      return this.b(var1.s, var1.u);
   }

   public double b(double var1, double var3) {
      double var5 = var3 - this.c();
      double var7 = this.e() - var3;
      double var9 = var1 - this.b();
      double var11 = this.d() - var1;
      double var13 = Math.min(var9, var11);
      var13 = Math.min(var13, var5);
      return Math.min(var13, var7);
   }

   public class_aod a() {
      return this.e < this.d?class_aod.b:(this.e > this.d?class_aod.a:class_aod.c);
   }

   public double b() {
      double var1 = this.f() - this.h() / 2.0D;
      if(var1 < (double)(-this.h)) {
         var1 = (double)(-this.h);
      }

      return var1;
   }

   public double c() {
      double var1 = this.g() - this.h() / 2.0D;
      if(var1 < (double)(-this.h)) {
         var1 = (double)(-this.h);
      }

      return var1;
   }

   public double d() {
      double var1 = this.f() + this.h() / 2.0D;
      if(var1 > (double)this.h) {
         var1 = (double)this.h;
      }

      return var1;
   }

   public double e() {
      double var1 = this.g() + this.h() / 2.0D;
      if(var1 > (double)this.h) {
         var1 = (double)this.h;
      }

      return var1;
   }

   public double f() {
      return this.b;
   }

   public double g() {
      return this.c;
   }

   public void c(double var1, double var3) {
      this.b = var1;
      this.c = var3;
      Iterator var5 = this.k().iterator();

      while(var5.hasNext()) {
         class_aoc var6 = (class_aoc)var5.next();
         var6.a(this, var1, var3);
      }

   }

   public double h() {
      if(this.a() != class_aod.c) {
         double var1 = (double)((float)(System.currentTimeMillis() - this.g) / (float)(this.f - this.g));
         if(var1 < 1.0D) {
            return this.d + (this.e - this.d) * var1;
         }

         this.a(this.e);
      }

      return this.d;
   }

   public long i() {
      return this.a() != class_aod.c?this.f - System.currentTimeMillis():0L;
   }

   public double j() {
      return this.e;
   }

   public void a(double var1) {
      this.d = var1;
      this.e = var1;
      this.f = System.currentTimeMillis();
      this.g = this.f;
      Iterator var3 = this.k().iterator();

      while(var3.hasNext()) {
         class_aoc var4 = (class_aoc)var3.next();
         var4.a(this, var1);
      }

   }

   public void a(double var1, double var3, long var5) {
      this.d = var1;
      this.e = var3;
      this.g = System.currentTimeMillis();
      this.f = this.g + var5;
      Iterator var7 = this.k().iterator();

      while(var7.hasNext()) {
         class_aoc var8 = (class_aoc)var7.next();
         var8.a(this, var1, var3, var5);
      }

   }

   protected List k() {
      return Lists.newArrayList((Iterable)this.a);
   }

   public void a(class_aoc var1) {
      this.a.add(var1);
   }

   public void a(int var1) {
      this.h = var1;
   }

   public int l() {
      return this.h;
   }

   public double m() {
      return this.j;
   }

   public void b(double var1) {
      this.j = var1;
      Iterator var3 = this.k().iterator();

      while(var3.hasNext()) {
         class_aoc var4 = (class_aoc)var3.next();
         var4.c(this, var1);
      }

   }

   public double n() {
      return this.i;
   }

   public void c(double var1) {
      this.i = var1;
      Iterator var3 = this.k().iterator();

      while(var3.hasNext()) {
         class_aoc var4 = (class_aoc)var3.next();
         var4.b(this, var1);
      }

   }

   public int p() {
      return this.k;
   }

   public void b(int var1) {
      this.k = var1;
      Iterator var2 = this.k().iterator();

      while(var2.hasNext()) {
         class_aoc var3 = (class_aoc)var2.next();
         var3.a(this, var1);
      }

   }

   public int q() {
      return this.l;
   }

   public void c(int var1) {
      this.l = var1;
      Iterator var2 = this.k().iterator();

      while(var2.hasNext()) {
         class_aoc var3 = (class_aoc)var2.next();
         var3.b(this, var1);
      }

   }
}
