package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;

public abstract class class_aql {
   private final boolean a;

   public class_aql() {
      this(false);
   }

   public class_aql(boolean var1) {
      this.a = var1;
   }

   public abstract boolean b(class_aen var1, Random var2, class_cj var3);

   public void e() {
   }

   protected void a(class_aen var1, class_cj var2, class_anl var3) {
      if(this.a) {
         var1.a((class_cj)var2, (class_anl)var3, 3);
      } else {
         var1.a((class_cj)var2, (class_anl)var3, 2);
      }

   }
}
