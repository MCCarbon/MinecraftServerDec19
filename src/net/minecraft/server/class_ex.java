package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_es;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_nz;

public class class_ex extends class_es {
   private final String b;
   private final String c;
   private String d = "";

   public class_ex(String var1, String var2) {
      this.b = var1;
      this.c = var2;
   }

   public String g() {
      return this.b;
   }

   public String h() {
      return this.c;
   }

   public void b(String var1) {
      this.d = var1;
   }

   public String e() {
      MinecraftServer var1 = MinecraftServer.N();
      if(var1 != null && var1.O() && class_nz.b(this.d)) {
         class_awn var2 = var1.a(0).aa();
         class_awj var3 = var2.b(this.c);
         if(var2.b(this.b, var3)) {
            class_awl var4 = var2.c(this.b, var3);
            this.b(String.format("%d", new Object[]{Integer.valueOf(var4.c())}));
         } else {
            this.d = "";
         }
      }

      return this.d;
   }

   public class_ex i() {
      class_ex var1 = new class_ex(this.b, this.c);
      var1.b(this.d);
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
      } else if(!(var1 instanceof class_ex)) {
         return false;
      } else {
         class_ex var2 = (class_ex)var1;
         return this.b.equals(var2.b) && this.c.equals(var2.c) && super.equals(var1);
      }
   }

   public String toString() {
      return "ScoreComponent{name=\'" + this.b + '\'' + "objective=\'" + this.c + '\'' + ", siblings=" + this.a + ", style=" + this.b() + '}';
   }

   // $FF: synthetic method
   public class_eu f() {
      return this.i();
   }
}
