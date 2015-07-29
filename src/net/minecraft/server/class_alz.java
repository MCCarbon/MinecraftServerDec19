package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_age;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anz;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;

public class class_alz extends class_age {
   public static final class_anz a = class_anz.a("power", 0, 15);
   private final int b;

   protected class_alz(class_atk var1, int var2) {
      this(var1, var2, var1.r());
   }

   protected class_alz(class_atk var1, int var2, class_atl var3) {
      super(var1, var3);
      this.j(this.M.b().a(a, Integer.valueOf(0)));
      this.b = var2;
   }

   protected int f(class_aen var1, class_cj var2) {
      int var3 = Math.min(var1.a(class_pr.class, this.a(var2)).size(), this.b);
      if(var3 > 0) {
         float var4 = (float)Math.min(this.b, var3) / (float)this.b;
         return class_nu.f(var4 * 15.0F);
      } else {
         return 0;
      }
   }

   protected int e(class_anl var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected class_anl a(class_anl var1, int var2) {
      return var1.a(a, Integer.valueOf(var2));
   }

   public int a(class_aen var1) {
      return 10;
   }

   public class_anl a(int var1) {
      return this.S().a(a, Integer.valueOf(var1));
   }

   public int c(class_anl var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
