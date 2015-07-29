package net.minecraft.server;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ez;
import net.minecraft.server.class_fa;

public abstract class class_es implements class_eu {
   protected List a = Lists.newArrayList();
   private class_ez b;

   public class_eu a(class_eu var1) {
      var1.b().a(this.b());
      this.a.add(var1);
      return this;
   }

   public List a() {
      return this.a;
   }

   public class_eu a(String var1) {
      return this.a((class_eu)(new class_fa(var1)));
   }

   public class_eu a(class_ez var1) {
      this.b = var1;
      Iterator var2 = this.a.iterator();

      while(var2.hasNext()) {
         class_eu var3 = (class_eu)var2.next();
         var3.b().a(this.b());
      }

      return this;
   }

   public class_ez b() {
      if(this.b == null) {
         this.b = new class_ez();
         Iterator var1 = this.a.iterator();

         while(var1.hasNext()) {
            class_eu var2 = (class_eu)var1.next();
            var2.b().a(this.b);
         }
      }

      return this.b;
   }

   public Iterator iterator() {
      return Iterators.concat(Iterators.forArray(new class_es[]{this}), a((Iterable)this.a));
   }

   public final String c() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         class_eu var3 = (class_eu)var2.next();
         var1.append(var3.e());
      }

      return var1.toString();
   }

   public static Iterator a(Iterable var0) {
      Iterator var1 = Iterators.concat(Iterators.transform(var0.iterator(), new Function() {
         public Iterator a(class_eu var1) {
            return var1.iterator();
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_eu)var1);
         }
      }));
      var1 = Iterators.transform(var1, new Function() {
         public class_eu a(class_eu var1) {
            class_eu var2 = var1.f();
            var2.a(var2.b().n());
            return var2;
         }

         // $FF: synthetic method
         public Object apply(Object var1) {
            return this.a((class_eu)var1);
         }
      });
      return var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_es)) {
         return false;
      } else {
         class_es var2 = (class_es)var1;
         return this.a.equals(var2.a) && this.b().equals(var2.b());
      }
   }

   public int hashCode() {
      return 31 * this.b.hashCode() + this.a.hashCode();
   }

   public String toString() {
      return "BaseComponent{style=" + this.b + ", siblings=" + this.a + '}';
   }
}
