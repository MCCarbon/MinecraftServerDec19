package net.minecraft.server;

import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pr;

public class class_awg {
   private class_cj e;
   public class_awg.class_a_in_class_awg a;
   public class_cq b;
   public class_awh c;
   public class_pr d;

   public class_awg(class_awh var1, class_cq var2, class_cj var3) {
      this(class_awg.class_a_in_class_awg.b, var1, var2, var3);
   }

   public class_awg(class_awh var1, class_cq var2) {
      this(class_awg.class_a_in_class_awg.b, var1, var2, class_cj.a);
   }

   public class_awg(class_pr var1) {
      this(var1, new class_awh(var1.s, var1.t, var1.u));
   }

   public class_awg(class_awg.class_a_in_class_awg var1, class_awh var2, class_cq var3, class_cj var4) {
      this.a = var1;
      this.e = var4;
      this.b = var3;
      this.c = new class_awh(var2.a, var2.b, var2.c);
   }

   public class_awg(class_pr var1, class_awh var2) {
      this.a = class_awg.class_a_in_class_awg.c;
      this.d = var1;
      this.c = var2;
   }

   public class_cj a() {
      return this.e;
   }

   public String toString() {
      return "HitResult{type=" + this.a + ", blockpos=" + this.e + ", f=" + this.b + ", pos=" + this.c + ", entity=" + this.d + '}';
   }

   public static enum class_a_in_class_awg {
      a,
      b,
      c;
   }
}
