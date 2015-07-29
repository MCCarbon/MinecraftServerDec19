package net.minecraft.server;

import com.google.common.base.Objects;
import net.minecraft.server.IBlockState;

public abstract class class_anv implements IBlockState {
   private final Class a;
   private final String b;

   protected class_anv(String var1, Class var2) {
      this.a = var2;
      this.b = var1;
   }

   public String a() {
      return this.b;
   }

   public Class b() {
      return this.a;
   }

   public String toString() {
      return Objects.toStringHelper((Object)this).add("name", this.b).add("clazz", this.a).add("values", this.c()).toString();
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_anv)) {
         return false;
      } else {
         class_anv var2 = (class_anv)var1;
         return this.a.equals(var2.a) && this.b.equals(var2.b);
      }
   }

   public int hashCode() {
      return 31 * this.a.hashCode() + this.b.hashCode();
   }
}
