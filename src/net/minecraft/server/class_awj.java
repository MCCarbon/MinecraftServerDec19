package net.minecraft.server;

import net.minecraft.server.Scoreboard;
import net.minecraft.server.class_awt;

public class class_awj {
   private final Scoreboard a;
   private final String b;
   private final class_awt c;
   private class_awt.class_a_in_class_awt d;
   private String e;

   public class_awj(Scoreboard var1, String var2, class_awt var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.e = var2;
      this.d = var3.c();
   }

   public String b() {
      return this.b;
   }

   public class_awt c() {
      return this.c;
   }

   public String d() {
      return this.e;
   }

   public void a(String var1) {
      this.e = var1;
      this.a.b(this);
   }

   public class_awt.class_a_in_class_awt e() {
      return this.d;
   }

   public void a(class_awt.class_a_in_class_awt var1) {
      this.d = var1;
      this.a.b(this);
   }
}
