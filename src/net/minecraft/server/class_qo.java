package net.minecraft.server;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.server.class_nm;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;

public abstract class class_qo {
   protected final Map a = Maps.newHashMap();
   protected final Map b = new class_nm();
   protected final Multimap c = HashMultimap.create();

   public class_ql a(class_qk var1) {
      return (class_ql)this.a.get(var1);
   }

   public class_ql a(String var1) {
      return (class_ql)this.b.get(var1);
   }

   public class_ql b(class_qk var1) {
      if(this.b.containsKey(var1.a())) {
         throw new IllegalArgumentException("Attribute is already registered!");
      } else {
         class_ql var2 = this.c(var1);
         this.b.put(var1.a(), var2);
         this.a.put(var1, var2);

         for(class_qk var3 = var1.d(); var3 != null; var3 = var3.d()) {
            this.c.put(var3, var1);
         }

         return var2;
      }
   }

   protected abstract class_ql c(class_qk var1);

   public Collection a() {
      return this.b.values();
   }

   public void a(class_ql var1) {
   }

   public void a(Multimap var1) {
      Iterator var2 = var1.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         class_ql var4 = this.a((String)var3.getKey());
         if(var4 != null) {
            var4.c((class_qm)var3.getValue());
         }
      }

   }

   public void b(Multimap var1) {
      Iterator var2 = var1.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         class_ql var4 = this.a((String)var3.getKey());
         if(var4 != null) {
            var4.c((class_qm)var3.getValue());
            var4.b((class_qm)var3.getValue());
         }
      }

   }
}
