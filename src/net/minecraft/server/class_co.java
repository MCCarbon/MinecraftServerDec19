package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_cx;
import org.apache.commons.lang3.Validate;

public class class_co extends class_cx {
   private final Object d;
   private Object e;

   public class_co(Object var1) {
      this.d = var1;
   }

   public void a(int var1, Object var2, Object var3) {
      if(this.d.equals(var2)) {
         this.e = var3;
      }

      super.a(var1, var2, var3);
   }

   public void a() {
      Validate.notNull(this.d);
   }

   public int a(Object var1) {
      int var2 = super.a(var1);
      return var2 == -1?super.a(this.e):var2;
   }

   public Object b(Object var1) {
      Object var2 = super.b(var1);
      return var2 == null?this.d:var2;
   }

   public Object c(Object var1) {
      Object var2 = super.c(var1);
      return var2 == null?this.e:var2;
   }

   public Object a(int var1) {
      Object var2 = super.a(var1);
      return var2 == null?this.e:var2;
   }

   public Object a(Random var1) {
      Object var2 = super.a(var1);
      return var2 == null?this.e:var2;
   }
}
