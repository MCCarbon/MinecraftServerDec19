package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_es;
import net.minecraft.server.class_eu;

public class class_ey extends class_es {
   private final String b;

   public class_ey(String var1) {
      this.b = var1;
   }

   public String g() {
      return this.b;
   }

   public String e() {
      return this.b;
   }

   public class_ey h() {
      class_ey var1 = new class_ey(this.b);
      var1.a(this.b().m());
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         class_eu var3 = (class_eu)var2.next();
         var1.a(var3.f());
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_ey)) {
         return false;
      } else {
         class_ey var2 = (class_ey)var1;
         return this.b.equals(var2.b) && super.equals(var1);
      }
   }

   public String toString() {
      return "SelectorComponent{pattern=\'" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.b() + '}';
   }

   // $FF: synthetic method
   public class_eu f() {
      return this.h();
   }
}
