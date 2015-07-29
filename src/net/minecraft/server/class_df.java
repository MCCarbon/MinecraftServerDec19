package net.minecraft.server;

import com.google.common.base.Objects;
import net.minecraft.server.class_nu;

public class class_df implements Comparable {
   public static final class_df b = new class_df(0, 0, 0);
   private final int a;
   private final int c;
   private final int d;

   public class_df(int var1, int var2, int var3) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
   }

   public class_df(double var1, double var3, double var5) {
      this(class_nu.c(var1), class_nu.c(var3), class_nu.c(var5));
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_df)) {
         return false;
      } else {
         class_df var2 = (class_df)var1;
         return this.n() != var2.n()?false:(this.o() != var2.o()?false:this.p() == var2.p());
      }
   }

   public int hashCode() {
      return (this.o() + this.p() * 31) * 31 + this.n();
   }

   public int g(class_df var1) {
      return this.o() == var1.o()?(this.p() == var1.p()?this.n() - var1.n():this.p() - var1.p()):this.o() - var1.o();
   }

   public int n() {
      return this.a;
   }

   public int o() {
      return this.c;
   }

   public int p() {
      return this.d;
   }

   public class_df d(class_df var1) {
      return new class_df(this.o() * var1.p() - this.p() * var1.o(), this.p() * var1.n() - this.n() * var1.p(), this.n() * var1.o() - this.o() * var1.n());
   }

   public double d(int var1, int var2, int var3) {
      double var4 = (double)(this.n() - var1);
      double var6 = (double)(this.o() - var2);
      double var8 = (double)(this.p() - var3);
      return Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
   }

   public double c(double var1, double var3, double var5) {
      double var7 = (double)this.n() - var1;
      double var9 = (double)this.o() - var3;
      double var11 = (double)this.p() - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double d(double var1, double var3, double var5) {
      double var7 = (double)this.n() + 0.5D - var1;
      double var9 = (double)this.o() + 0.5D - var3;
      double var11 = (double)this.p() + 0.5D - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double i(class_df var1) {
      return this.c((double)var1.n(), (double)var1.o(), (double)var1.p());
   }

   public String toString() {
      return Objects.toStringHelper((Object)this).add("x", this.n()).add("y", this.o()).add("z", this.p()).toString();
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.g((class_df)var1);
   }
}
