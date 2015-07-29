package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_cj;

public class class_ano {
   private final class_aen a;
   private final class_cj b;
   private final boolean c;
   private IBlockData d;
   private class_amg e;
   private boolean f;

   public class_ano(class_aen var1, class_cj var2, boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public IBlockData a() {
      if(this.d == null && (this.c || this.a.e(this.b))) {
         this.d = this.a.p(this.b);
      }

      return this.d;
   }

   public class_amg b() {
      if(this.e == null && !this.f) {
         this.e = this.a.s(this.b);
         this.f = true;
      }

      return this.e;
   }

   public class_cj d() {
      return this.b;
   }

   public static Predicate a(final Predicate var0) {
      return new Predicate() {
         public boolean a(class_ano var1) {
            return var1 != null && var0.apply(var1.a());
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_ano)var1);
         }
      };
   }
}
