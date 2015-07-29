package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.class_anv;
import net.minecraft.server.class_ny;

public class class_any extends class_anv {
   private final ImmutableSet a;
   private final Map b = Maps.newHashMap();

   protected class_any(String var1, Class var2, Collection var3) {
      super(var1, var2);
      this.a = ImmutableSet.copyOf(var3);
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Enum var5 = (Enum)var4.next();
         String var6 = ((class_ny)var5).l();
         if(this.b.containsKey(var6)) {
            throw new IllegalArgumentException("Multiple values have the same name \'" + var6 + "\'");
         }

         this.b.put(var6, var5);
      }

   }

   public Collection c() {
      return this.a;
   }

   public String a(Enum var1) {
      return ((class_ny)var1).l();
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 instanceof class_any && super.equals(var1)) {
         class_any var2 = (class_any)var1;
         return this.a.equals(var2.a) && this.b.equals(var2.b);
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = 31 * var1 + this.a.hashCode();
      var1 = 31 * var1 + this.b.hashCode();
      return var1;
   }

   public static class_any a(String var0, Class var1) {
      return a(var0, var1, Predicates.alwaysTrue());
   }

   public static class_any a(String var0, Class var1, Predicate var2) {
      return a(var0, var1, Collections2.filter(Lists.newArrayList(var1.getEnumConstants()), var2));
   }

   public static class_any a(String var0, Class var1, Enum... var2) {
      return a(var0, var1, (Collection)Lists.newArrayList((Object[])var2));
   }

   public static class_any a(String var0, Class var1, Collection var2) {
      return new class_any(var0, var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String a(Comparable var1) {
      return this.a((Enum)var1);
   }
}
