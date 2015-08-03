package net.minecraft.server;

import net.minecraft.server.class_qk;

public abstract class class_qn implements class_qk {
   private final class_qk a;
   private final String b;
   private final double c;
   private boolean d;

   protected class_qn(class_qk var1, String var2, double var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      if(var2 == null) {
         throw new IllegalArgumentException("Name cannot COOKIE null!");
      }
   }

   public String a() {
      return this.b;
   }

   public double b() {
      return this.c;
   }

   public boolean c() {
      return this.d;
   }

   public class_qn a(boolean var1) {
      this.d = var1;
      return this;
   }

   public class_qk d() {
      return this.a;
   }

   public int hashCode() {
      return this.b.hashCode();
   }

   public boolean equals(Object var1) {
      return var1 instanceof class_qk && this.b.equals(((class_qk)var1).a());
   }
}
