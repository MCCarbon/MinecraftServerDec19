package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.class_nm;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qo;
import net.minecraft.server.class_qq;
import net.minecraft.server.class_qs;

public class class_qr extends class_qo {
   private final Set e = Sets.newHashSet();
   protected final Map d = new class_nm();

   public class_qq e(class_qk var1) {
      return (class_qq)super.a(var1);
   }

   public class_qq b(String var1) {
      class_ql var2 = super.a(var1);
      if(var2 == null) {
         var2 = (class_ql)this.d.get(var1);
      }

      return (class_qq)var2;
   }

   public class_ql b(class_qk var1) {
      class_ql var2 = super.b(var1);
      if(var1 instanceof class_qs && ((class_qs)var1).g() != null) {
         this.d.put(((class_qs)var1).g(), var2);
      }

      return var2;
   }

   protected class_ql c(class_qk var1) {
      return new class_qq(this, var1);
   }

   public void a(class_ql var1) {
      if(var1.a().c()) {
         this.e.add(var1);
      }

      Iterator var2 = this.c.get(var1.a()).iterator();

      while(var2.hasNext()) {
         class_qk var3 = (class_qk)var2.next();
         class_qq var4 = this.e(var3);
         if(var4 != null) {
            var4.f();
         }
      }

   }

   public Set b() {
      return this.e;
   }

   public Collection c() {
      HashSet var1 = Sets.newHashSet();
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         class_ql var3 = (class_ql)var2.next();
         if(var3.a().c()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   // $FF: synthetic method
   public class_ql a(String var1) {
      return this.b(var1);
   }

   // $FF: synthetic method
   public class_ql a(class_qk var1) {
      return this.e(var1);
   }
}
