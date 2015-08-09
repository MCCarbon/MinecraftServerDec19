package net.minecraft.server;

import java.util.Comparator;
import java.util.List;
import net.minecraft.server.class_awj;
import net.minecraft.server.Scoreboard;

public class class_awl {
   public static final Comparator a = new Comparator() {
      public int a(class_awl var1, class_awl var2) {
         return var1.c() > var2.c()?1:(var1.c() < var2.c()?-1:var2.e().compareToIgnoreCase(var1.e()));
      }

      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.a((class_awl)var1, (class_awl)var2);
      }
   };
   private final Scoreboard b;
   private final class_awj c;
   private final String d;
   private int e;
   private boolean f;
   private boolean g;

   public class_awl(Scoreboard var1, class_awj var2, String var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.g = true;
   }

   public void a(int var1) {
      if(this.c.c().b()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.c(this.c() + var1);
      }
   }

   public void b(int var1) {
      if(this.c.c().b()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.c(this.c() - var1);
      }
   }

   public void a() {
      if(this.c.c().b()) {
         throw new IllegalStateException("Cannot modify read-only score");
      } else {
         this.a(1);
      }
   }

   public int c() {
      return this.e;
   }

   public void c(int var1) {
      int var2 = this.e;
      this.e = var1;
      if(var2 != var1 || this.g) {
         this.g = false;
         this.f().a(this);
      }

   }

   public class_awj d() {
      return this.c;
   }

   public String e() {
      return this.d;
   }

   public Scoreboard f() {
      return this.b;
   }

   public boolean g() {
      return this.f;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void a(List var1) {
      this.c(this.c.c().a(var1));
   }
}
