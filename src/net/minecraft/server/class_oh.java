package net.minecraft.server;

import java.util.UUID;
import net.minecraft.server.class_eu;

public abstract class class_oh {
   private final UUID g;
   protected class_eu a;
   protected float b;
   protected class_oh.class_a_in_class_oh c;
   protected class_oh.class_b_in_class_oh d;
   protected boolean e;
   protected boolean f;

   public class_oh(UUID var1, class_eu var2, class_oh.class_a_in_class_oh var3, class_oh.class_b_in_class_oh var4, boolean var5, boolean var6) {
      this.g = var1;
      this.a = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.b = 1.0F;
   }

   public UUID d() {
      return this.g;
   }

   public class_eu e() {
      return this.a;
   }

   public float f() {
      return this.b;
   }

   public void a(float var1) {
      this.b = var1;
   }

   public class_oh.class_a_in_class_oh g() {
      return this.c;
   }

   public class_oh.class_b_in_class_oh h() {
      return this.d;
   }

   public boolean i() {
      return this.e;
   }

   public boolean j() {
      return this.f;
   }

   public static enum class_b_in_class_oh {
      a,
      b,
      c,
      d,
      e;
   }

   public static enum class_a_in_class_oh {
      a,
      b,
      c,
      d,
      e,
      f,
      g;
   }
}
