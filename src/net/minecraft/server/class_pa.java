package net.minecraft.server;

import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_qa;

public class class_pa {
   private final class_pc a;
   private final int b;
   private final float c;
   private final float d;
   private final String e;
   private final float f;

   public class_pa(class_pc var1, int var2, float var3, float var4, String var5, float var6) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var3;
      this.e = var5;
      this.f = var6;
   }

   public class_pc a() {
      return this.a;
   }

   public float c() {
      return this.c;
   }

   public boolean f() {
      return this.a.j() instanceof class_qa;
   }

   public String g() {
      return this.e;
   }

   public IChatBaseComponent h() {
      return this.a().j() == null?null:this.a().j().f_();
   }

   public float i() {
      return this.a == class_pc.j?Float.MAX_VALUE:this.f;
   }
}
