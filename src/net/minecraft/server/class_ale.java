package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_aku;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_cj;

public class class_ale extends class_aku {
   public static final class_anz a = class_anz.a("rotation", 0, 15);

   public class_ale() {
      this.j(this.M.b().a(a, Integer.valueOf(0)));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(!var1.p(var2.b()).c().v().a()) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   public class_anl a(int var1) {
      return this.S().a(a, Integer.valueOf(var1));
   }

   public int c(class_anl var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(a, Integer.valueOf(var2.a(((Integer)var1.b(a)).intValue(), 16)));
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(a, Integer.valueOf(var2.a(((Integer)var1.b(a)).intValue(), 16)));
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
