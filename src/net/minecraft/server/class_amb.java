package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_zu;

public abstract class class_amb extends class_aio {
   public static final class_any b = class_any.a("variant", class_ajw.class_a_in_class_ajw.class);

   public class_amb() {
      super(class_atk.d);
      class_anl var1 = this.M.b();
      if(!this.l()) {
         var1 = var1.a(a, class_aio.class_a_in_class_aio.b);
      }

      this.j(var1.a(b, class_ajw.class_a_in_class_ajw.a));
      this.a((class_zu)class_zu.b);
   }

   public class_atl g(class_anl var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.b(b)).c();
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_aar.a((class_agj)class_agk.bM);
   }

   public String b(int var1) {
      return super.a() + "." + class_ajw.class_a_in_class_ajw.a(var1).d();
   }

   public class_aoa n() {
      return b;
   }

   public Object a(class_aas var1) {
      return class_ajw.class_a_in_class_ajw.a(var1.i() & 7);
   }

   public class_anl a(int var1) {
      class_anl var2 = this.S().a(b, class_ajw.class_a_in_class_ajw.a(var1 & 7));
      if(!this.l()) {
         var2 = var2.a(a, (var1 & 8) == 0?class_aio.class_a_in_class_aio.b:class_aio.class_a_in_class_aio.a);
      }

      return var2;
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_ajw.class_a_in_class_ajw)var1.b(b)).a();
      if(!this.l() && var1.b(a) == class_aio.class_a_in_class_aio.a) {
         var3 |= 8;
      }

      return var3;
   }

   protected class_anm e() {
      return this.l()?new class_anm(this, new class_aoa[]{b}):new class_anm(this, new class_aoa[]{a, b});
   }

   public int a(class_anl var1) {
      return ((class_ajw.class_a_in_class_ajw)var1.b(b)).a();
   }
}
