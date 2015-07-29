package net.minecraft.server;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import net.minecraft.server.class_anv;

public class class_anw extends class_anv {
   private final ImmutableSet a = ImmutableSet.of(Boolean.valueOf(true), Boolean.valueOf(false));

   protected class_anw(String var1) {
      super(var1, Boolean.class);
   }

   public Collection c() {
      return this.a;
   }

   public static class_anw a(String var0) {
      return new class_anw(var0);
   }

   public String a(Boolean var1) {
      return var1.toString();
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 instanceof class_anw && super.equals(var1)) {
         class_anw var2 = (class_anw)var1;
         return this.a.equals(var2.a);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return 31 * super.hashCode() + this.a.hashCode();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String a(Comparable var1) {
      return this.a((Boolean)var1);
   }
}
