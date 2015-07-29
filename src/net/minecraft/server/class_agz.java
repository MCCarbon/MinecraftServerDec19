package net.minecraft.server;

import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_zu;
import net.minecraft.server.class_zy;

public class class_agz extends class_agj {
   public static final class_any a = class_any.a("color", class_zy.class);

   public class_agz(class_atk var1) {
      super(var1);
      this.j(this.M.b().a(a, class_zy.a));
      this.a(class_zu.b);
   }

   public int a(class_anl var1) {
      return ((class_zy)var1.b(a)).a();
   }

   public class_atl g(class_anl var1) {
      return ((class_zy)var1.b(a)).e();
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_zy.b(var1));
   }

   public int c(class_anl var1) {
      return ((class_zy)var1.b(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }
}
