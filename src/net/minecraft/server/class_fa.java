package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_es;
import net.minecraft.server.IChatBaseComponent;

public class class_fa extends class_es {
   private final String b;

   public class_fa(String var1) {
      this.b = var1;
   }

   public String g() {
      return this.b;
   }

   public String e() {
      return this.b;
   }

   public class_fa h() {
      class_fa var1 = new class_fa(this.b);
      var1.a(this.b().m());
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         IChatBaseComponent var3 = (IChatBaseComponent)var2.next();
         var1.a(var3.f());
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_fa)) {
         return false;
      } else {
         class_fa var2 = (class_fa)var1;
         return this.b.equals(var2.g()) && super.equals(var1);
      }
   }

   public String toString() {
      return "TextComponent{text=\'" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.b() + '}';
   }

   // $FF: synthetic method
   public IChatBaseComponent f() {
      return this.h();
   }
}
