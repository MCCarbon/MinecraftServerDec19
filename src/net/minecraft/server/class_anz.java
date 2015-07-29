package net.minecraft.server;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import net.minecraft.server.class_anv;

public class class_anz extends class_anv {
   private final ImmutableSet a;

   protected class_anz(String var1, int var2, int var3) {
      super(var1, Integer.class);
      if(var2 < 0) {
         throw new IllegalArgumentException("Min value of " + var1 + " must be 0 or greater");
      } else if(var3 <= var2) {
         throw new IllegalArgumentException("Max value of " + var1 + " must be greater than min (" + var2 + ")");
      } else {
         HashSet var4 = Sets.newHashSet();

         for(int var5 = var2; var5 <= var3; ++var5) {
            var4.add(Integer.valueOf(var5));
         }

         this.a = ImmutableSet.copyOf((Collection)var4);
      }
   }

   public Collection c() {
      return this.a;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 instanceof class_anz && super.equals(var1)) {
         class_anz var2 = (class_anz)var1;
         return this.a.equals(var2.a);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return 31 * super.hashCode() + this.a.hashCode();
   }

   public static class_anz a(String var0, int var1, int var2) {
      return new class_anz(var0, var1, var2);
   }

   public String a(Integer var1) {
      return var1.toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String a(Comparable var1) {
      return this.a((Integer)var1);
   }
}
