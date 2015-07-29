package net.minecraft.server;

import net.minecraft.server.class_ath;
import net.minecraft.server.class_ati;
import net.minecraft.server.class_atj;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_atm;

public class class_atk {
   public static final class_atk a;
   public static final class_atk b;
   public static final class_atk c;
   public static final class_atk d;
   public static final class_atk e;
   public static final class_atk f;
   public static final class_atk g;
   public static final class_atk h;
   public static final class_atk i;
   public static final class_atk j;
   public static final class_atk k;
   public static final class_atk l;
   public static final class_atk m;
   public static final class_atk n;
   public static final class_atk o;
   public static final class_atk p;
   public static final class_atk q;
   public static final class_atk r;
   public static final class_atk s;
   public static final class_atk t;
   public static final class_atk u;
   public static final class_atk v;
   public static final class_atk w;
   public static final class_atk x;
   public static final class_atk y;
   public static final class_atk z;
   public static final class_atk A;
   public static final class_atk B;
   public static final class_atk C;
   public static final class_atk D;
   public static final class_atk E;
   public static final class_atk F;
   public static final class_atk G;
   public static final class_atk H;
   public static final class_atk I;
   private boolean J;
   private boolean K;
   private boolean L;
   private final class_atl M;
   private boolean N = true;
   private int O;
   private boolean P;

   public class_atk(class_atl var1) {
      this.M = var1;
   }

   public boolean d() {
      return false;
   }

   public boolean a() {
      return true;
   }

   public boolean b() {
      return true;
   }

   public boolean c() {
      return true;
   }

   private class_atk s() {
      this.L = true;
      return this;
   }

   protected class_atk f() {
      this.N = false;
      return this;
   }

   protected class_atk g() {
      this.J = true;
      return this;
   }

   public boolean h() {
      return this.J;
   }

   public class_atk i() {
      this.K = true;
      return this;
   }

   public boolean j() {
      return this.K;
   }

   public boolean k() {
      return this.L?false:this.c();
   }

   public boolean l() {
      return this.N;
   }

   public int m() {
      return this.O;
   }

   protected class_atk n() {
      this.O = 1;
      return this;
   }

   protected class_atk o() {
      this.O = 2;
      return this;
   }

   protected class_atk p() {
      this.P = true;
      return this;
   }

   public class_atl r() {
      return this.M;
   }

   static {
      a = new class_ati(class_atl.b);
      b = new class_atk(class_atl.c);
      c = new class_atk(class_atl.l);
      d = (new class_atk(class_atl.o)).g();
      e = (new class_atk(class_atl.m)).f();
      f = (new class_atk(class_atl.h)).f();
      g = (new class_atk(class_atl.h)).f().o();
      h = (new class_atj(class_atl.n)).n();
      i = (new class_atj(class_atl.f)).n();
      j = (new class_atk(class_atl.i)).g().s().n();
      k = (new class_ath(class_atl.i)).n();
      l = (new class_ath(class_atl.i)).g().n().i();
      m = new class_atk(class_atl.t);
      n = (new class_atk(class_atl.e)).g();
      o = (new class_ati(class_atl.b)).n();
      p = new class_atk(class_atl.d);
      q = (new class_ath(class_atl.b)).n();
      r = (new class_ath(class_atl.e)).g();
      s = (new class_atk(class_atl.b)).s().p();
      t = (new class_atk(class_atl.b)).p();
      u = (new class_atk(class_atl.f)).g().s();
      v = (new class_atk(class_atl.i)).n();
      w = (new class_atk(class_atl.g)).s().p();
      x = (new class_atk(class_atl.g)).p();
      y = (new class_ath(class_atl.j)).i().s().f().n();
      z = (new class_atk(class_atl.j)).f();
      A = (new class_atk(class_atl.i)).s().n();
      B = new class_atk(class_atl.k);
      C = (new class_atk(class_atl.i)).n();
      D = (new class_atk(class_atl.i)).n();
      E = (new class_atm(class_atl.b)).o();
      F = (new class_atk(class_atl.b)).n();
      G = (new class_atk(class_atl.e) {
         public boolean c() {
            return false;
         }
      }).f().n();
      H = (new class_atk(class_atl.m)).o();
      I = (new class_atk(class_atl.b)).f().o();
   }
}
