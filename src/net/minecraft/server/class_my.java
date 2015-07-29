package net.minecraft.server;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.server.class_a;
import net.minecraft.server.class_awt;
import net.minecraft.server.class_awu;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ew;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_mz;
import net.minecraft.server.class_nc;

public class class_my {
   public final String e;
   private final class_eu a;
   public boolean f;
   private final class_mz b;
   private final class_awt c;
   private Class d;
   private static NumberFormat k;
   public static class_mz g;
   private static DecimalFormat l;
   public static class_mz h;
   public static class_mz i;
   public static class_mz j;

   public class_my(String var1, class_eu var2, class_mz var3) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = new class_awu(this);
      class_awt.a.put(this.c.a(), this.c);
   }

   public class_my(String var1, class_eu var2) {
      this(var1, var2, g);
   }

   public class_my i() {
      this.f = true;
      return this;
   }

   public class_my h() {
      if(class_nc.a.containsKey(this.e)) {
         throw new RuntimeException("Duplicate stat id: \"" + ((class_my)class_nc.a.get(this.e)).a + "\" and \"" + this.a + "\" at id " + this.e);
      } else {
         class_nc.b.add(this);
         class_nc.a.put(this.e, this);
         return this;
      }
   }

   public boolean d() {
      return false;
   }

   public class_eu e() {
      class_eu var1 = this.a.f();
      var1.b().a(class_a.h);
      var1.b().a(new class_ew(class_ew.class_a_in_class_ew.b, new class_fa(this.e)));
      return var1;
   }

   public class_eu j() {
      class_eu var1 = this.e();
      class_eu var2 = (new class_fa("[")).a(var1).a("]");
      var2.a(var1.b());
      return var2;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         class_my var2 = (class_my)var1;
         return this.e.equals(var2.e);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.e.hashCode();
   }

   public String toString() {
      return "Stat{id=" + this.e + ", nameId=" + this.a + ", awardLocallyOnly=" + this.f + ", formatter=" + this.b + ", objectiveCriteria=" + this.c + '}';
   }

   public class_awt k() {
      return this.c;
   }

   public Class l() {
      return this.d;
   }

   public class_my b(Class var1) {
      this.d = var1;
      return this;
   }

   static {
      k = NumberFormat.getIntegerInstance(Locale.US);
      g = new class_mz() {
      };
      l = new DecimalFormat("########0.00");
      h = new class_mz() {
      };
      i = new class_mz() {
      };
      j = new class_mz() {
      };
   }
}
