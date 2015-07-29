package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_pp;
import net.minecraft.server.class_pr;

public interface class_wd extends class_pp {
   Predicate d = new Predicate() {
      public boolean a(class_pr var1) {
         return var1 instanceof class_wd;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_pr)var1);
      }
   };
   Predicate e = new Predicate() {
      public boolean a(class_pr var1) {
         return var1 instanceof class_wd && !var1.aA();
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_pr)var1);
      }
   };
}
