package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;

public class class_ajs extends class_aja {
   public static final class_any Q = class_any.a("variant", class_ajw.class_a_in_class_ajw.class, new Predicate() {
      public boolean a(class_ajw.class_a_in_class_ajw var1) {
         return var1.a() < 4;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_ajw.class_a_in_class_ajw)var1);
      }
   });

   public class_ajs() {
      this.j(this.M.b().a(Q, class_ajw.class_a_in_class_ajw.a).a(b, Boolean.valueOf(true)).a(a, Boolean.valueOf(true)));
   }

   protected void a(class_aen var1, class_cj var2, class_anl var3, int var4) {
      if(var3.b(Q) == class_ajw.class_a_in_class_ajw.a && var1.s.nextInt(var4) == 0) {
         a(var1, var2, new class_aas(class_aau.e));
      }

   }

   protected int d(class_anl var1) {
      return var1.b(Q) == class_ajw.class_a_in_class_ajw.d?40:super.d(var1);
   }

   protected class_aas i(class_anl var1) {
      return new class_aas(class_aar.a((class_agj)this), 1, ((class_ajw.class_a_in_class_ajw)var1.b(Q)).a());
   }

   public class_anl a(int var1) {
      return this.S().a(Q, this.b(var1)).a(a, Boolean.valueOf((var1 & 4) == 0)).a(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajw.class_a_in_class_ajw)var1.b(Q)).a();
      if(!((Boolean)var1.b(a)).booleanValue()) {
         var3 |= 4;
      }

      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public class_ajw.class_a_in_class_ajw b(int var1) {
      return class_ajw.class_a_in_class_ajw.a((var1 & 3) % 4);
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{Q, b, a});
   }

   public int a(class_anl var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.b(Q)).a();
   }

   public void a(class_aen var1, class_xa var2, class_cj var3, class_anl var4, class_amg var5, class_aas var6) {
      if(!var1.D && var6 != null && var6.b() == class_aau.bg) {
         var2.b(class_nc.ab[class_agj.a((class_agj)this)]);
         a(var1, var3, new class_aas(class_aar.a((class_agj)this), 1, ((class_ajw.class_a_in_class_ajw)var4.b(Q)).a()));
      } else {
         super.a(var1, var2, var3, var4, var5, var6);
      }
   }
}
