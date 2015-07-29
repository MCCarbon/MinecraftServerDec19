package net.minecraft.server;

import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aoi;

public class class_aol {
   private int a;
   private int b;
   private int c;
   private char[] d;
   private class_aoi e;
   private class_aoi f;

   public class_aol(int var1, boolean var2) {
      this.a = var1;
      this.d = new char[4096];
      this.e = new class_aoi();
      if(var2) {
         this.f = new class_aoi();
      }

   }

   public class_anl a(int var1, int var2, int var3) {
      class_anl var4 = (class_anl)class_agj.d.a(this.d[var2 << 8 | var3 << 4 | var1]);
      return var4 != null?var4:class_agk.a.S();
   }

   public void a(int var1, int var2, int var3, class_anl var4) {
      class_anl var5 = this.a(var1, var2, var3);
      class_agj var6 = var5.c();
      class_agj var7 = var4.c();
      if(var6 != class_agk.a) {
         --this.b;
         if(var6.A()) {
            --this.c;
         }
      }

      if(var7 != class_agk.a) {
         ++this.b;
         if(var7.A()) {
            ++this.c;
         }
      }

      this.d[var2 << 8 | var3 << 4 | var1] = (char)class_agj.d.a(var4);
   }

   public class_agj b(int var1, int var2, int var3) {
      return this.a(var1, var2, var3).c();
   }

   public int c(int var1, int var2, int var3) {
      class_anl var4 = this.a(var1, var2, var3);
      return var4.c().c(var4);
   }

   public boolean a() {
      return this.b == 0;
   }

   public boolean b() {
      return this.c > 0;
   }

   public int d() {
      return this.a;
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.f.a(var1, var2, var3, var4);
   }

   public int d(int var1, int var2, int var3) {
      return this.f.a(var1, var2, var3);
   }

   public void b(int var1, int var2, int var3, int var4) {
      this.e.a(var1, var2, var3, var4);
   }

   public int e(int var1, int var2, int var3) {
      return this.e.a(var1, var2, var3);
   }

   public void e() {
      this.b = 0;
      this.c = 0;

      for(int var1 = 0; var1 < 16; ++var1) {
         for(int var2 = 0; var2 < 16; ++var2) {
            for(int var3 = 0; var3 < 16; ++var3) {
               class_agj var4 = this.b(var1, var2, var3);
               if(var4 != class_agk.a) {
                  ++this.b;
                  if(var4.A()) {
                     ++this.c;
                  }
               }
            }
         }
      }

   }

   public char[] g() {
      return this.d;
   }

   public void a(char[] var1) {
      this.d = var1;
   }

   public class_aoi h() {
      return this.e;
   }

   public class_aoi i() {
      return this.f;
   }

   public void a(class_aoi var1) {
      this.e = var1;
   }

   public void b(class_aoi var1) {
      this.f = var1;
   }
}
