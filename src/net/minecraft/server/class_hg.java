package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aoe;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fj;

public class class_hg implements class_ff {
   private class_hg.class_a_in_class_hg a;
   private int b;
   private double c;
   private double d;
   private double e;
   private double f;
   private long g;
   private int h;
   private int i;

   public class_hg() {
   }

   public class_hg(class_aoe var1, class_hg.class_a_in_class_hg var2) {
      this.a = var2;
      this.c = var1.f();
      this.d = var1.g();
      this.f = var1.h();
      this.e = var1.j();
      this.g = var1.i();
      this.b = var1.l();
      this.i = var1.q();
      this.h = var1.p();
   }

   public void a(class_em var1) throws IOException {
      this.a = (class_hg.class_a_in_class_hg)var1.a(class_hg.class_a_in_class_hg.class);
      switch(class_hg.SyntheticClass_1.a[this.a.ordinal()]) {
      case 1:
         this.e = var1.readDouble();
         break;
      case 2:
         this.f = var1.readDouble();
         this.e = var1.readDouble();
         this.g = var1.f();
         break;
      case 3:
         this.c = var1.readDouble();
         this.d = var1.readDouble();
         break;
      case 4:
         this.i = var1.e();
         break;
      case 5:
         this.h = var1.e();
         break;
      case 6:
         this.c = var1.readDouble();
         this.d = var1.readDouble();
         this.f = var1.readDouble();
         this.e = var1.readDouble();
         this.g = var1.f();
         this.b = var1.e();
         this.i = var1.e();
         this.h = var1.e();
      }

   }

   public void b(class_em var1) throws IOException {
      var1.a((Enum)this.a);
      switch(class_hg.SyntheticClass_1.a[this.a.ordinal()]) {
      case 1:
         var1.writeDouble(this.e);
         break;
      case 2:
         var1.writeDouble(this.f);
         var1.writeDouble(this.e);
         var1.b(this.g);
         break;
      case 3:
         var1.writeDouble(this.c);
         var1.writeDouble(this.d);
         break;
      case 4:
         var1.b(this.i);
         break;
      case 5:
         var1.b(this.h);
         break;
      case 6:
         var1.writeDouble(this.c);
         var1.writeDouble(this.d);
         var1.writeDouble(this.f);
         var1.writeDouble(this.e);
         var1.b(this.g);
         var1.b(this.b);
         var1.b(this.i);
         var1.b(this.h);
      }

   }

   public void a(class_fj var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_fj)var1);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_hg.class_a_in_class_hg.values().length];

      static {
         try {
            a[class_hg.class_a_in_class_hg.a.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_hg.class_a_in_class_hg.b.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_hg.class_a_in_class_hg.c.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_hg.class_a_in_class_hg.f.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_hg.class_a_in_class_hg.e.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_hg.class_a_in_class_hg.d.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_hg {
      a,
      b,
      c,
      d,
      e,
      f;
   }
}
