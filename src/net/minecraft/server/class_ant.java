package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_aoa;

public class class_ant implements Predicate {
   private final class_anm a;
   private final Map b = Maps.newHashMap();

   private class_ant(class_anm var1) {
      this.a = var1;
   }

   public static class_ant a(class_agj var0) {
      return new class_ant(var0.R());
   }

   public boolean a(class_anl var1) {
      if(var1 != null && var1.c().equals(this.a.c())) {
         Iterator var2 = this.b.entrySet().iterator();

         Entry var3;
         Comparable var4;
         do {
            if(!var2.hasNext()) {
               return true;
            }

            var3 = (Entry)var2.next();
            var4 = var1.b((class_aoa)var3.getKey());
         } while(((Predicate)var3.getValue()).apply(var4));

         return false;
      } else {
         return false;
      }
   }

   public class_ant a(class_aoa var1, Predicate var2) {
      if(!this.a.d().contains(var1)) {
         throw new IllegalArgumentException(this.a + " cannot support property " + var1);
      } else {
         this.b.put(var1, var2);
         return this;
      }
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((class_anl)var1);
   }
}
