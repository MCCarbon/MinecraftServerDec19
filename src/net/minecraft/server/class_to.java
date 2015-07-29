package net.minecraft.server;

import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_to {
   private final class_cj a;
   private final class_cj b;
   private final class_cq c;
   private int d;
   private boolean e;
   private int f;

   public class_to(class_cj var1, int var2, int var3, int var4) {
      this(var1, a(var2, var3), var4);
   }

   private static class_cq a(int var0, int var1) {
      return var0 < 0?class_cq.e:(var0 > 0?class_cq.f:(var1 < 0?class_cq.c:class_cq.d));
   }

   public class_to(class_cj var1, class_cq var2, int var3) {
      this.a = var1;
      this.c = var2;
      this.b = var1.a(var2, 2);
      this.d = var3;
   }

   public int b(int var1, int var2, int var3) {
      return (int)this.a.c((double)var1, (double)var2, (double)var3);
   }

   public int a(class_cj var1) {
      return (int)var1.i(this.d());
   }

   public int b(class_cj var1) {
      return (int)this.b.i(var1);
   }

   public boolean c(class_cj var1) {
      int var2 = var1.n() - this.a.n();
      int var3 = var1.p() - this.a.o();
      return var2 * this.c.g() + var3 * this.c.i() >= 0;
   }

   public void a() {
      this.f = 0;
   }

   public void b() {
      ++this.f;
   }

   public int c() {
      return this.f;
   }

   public class_cj d() {
      return this.a;
   }

   public class_cj e() {
      return this.b;
   }

   public int f() {
      return this.c.g() * 2;
   }

   public int g() {
      return this.c.i() * 2;
   }

   public int h() {
      return this.d;
   }

   public void a(int var1) {
      this.d = var1;
   }

   public boolean i() {
      return this.e;
   }

   public void a(boolean var1) {
      this.e = var1;
   }
}
