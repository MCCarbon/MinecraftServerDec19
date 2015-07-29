package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_zu;

public abstract class class_ake extends class_aio {
   public static final class_any b = class_any.a("variant", class_ake.class_c_in_class_ake.class);

   public class_ake() {
      super(class_atk.e);
      class_anl var1 = this.M.b();
      if(!this.l()) {
         var1 = var1.a(a, class_aio.class_a_in_class_aio.b);
      }

      this.j(var1.a(b, class_ake.class_c_in_class_ake.a));
      this.a(class_zu.b);
   }

   public class_anl a(int var1) {
      class_anl var2 = this.S().a(b, class_ake.class_c_in_class_ake.a);
      if(!this.l()) {
         var2 = var2.a(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int c(class_anl var1) {
      int var2 = 0;
      if(!this.l() && var1.b(a) == class_aio.class_a_in_class_aio.a) {
         var2 |= 8;
      }

      return var2;
   }

   protected class_anm e() {
      return this.l()?new class_anm(this, new class_aoa[]{b}):new class_anm(this, new class_aoa[]{a, b});
   }

   public String b(int var1) {
      return super.a();
   }

   public class_aoa n() {
      return b;
   }

   public Object a(class_aas var1) {
      return class_ake.class_c_in_class_ake.a;
   }

   public static enum class_c_in_class_ake implements class_ny {
      a;

      public String l() {
         return "default";
      }
   }

   public static class class_a_in_class_ake extends class_ake {
      public boolean l() {
         return true;
      }
   }

   public static class class_b_in_class_ake extends class_ake {
      public boolean l() {
         return false;
      }
   }
}
