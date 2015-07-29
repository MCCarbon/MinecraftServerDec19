package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;
import net.minecraft.server.class_pr;

public class class_ml implements class_m {
   private static final class_ml a = new class_ml();
   private StringBuffer b = new StringBuffer();

   public static class_ml h() {
      return a;
   }

   public void i() {
      this.b.setLength(0);
   }

   public String j() {
      return this.b.toString();
   }

   public String e_() {
      return "Rcon";
   }

   public class_eu f_() {
      return new class_fa(this.e_());
   }

   public void a(class_eu var1) {
      this.b.append(var1.c());
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public class_cj c() {
      return new class_cj(0, 0, 0);
   }

   public class_awh d() {
      return new class_awh(0.0D, 0.0D, 0.0D);
   }

   public class_aen e() {
      return MinecraftServer.N().e();
   }

   public class_pr f() {
      return null;
   }

   public boolean u_() {
      return true;
   }

   public void a(class_n.class_a_in_class_n var1, int var2) {
   }
}
