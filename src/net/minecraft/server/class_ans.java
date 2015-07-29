package net.minecraft.server;

import com.google.common.base.Predicate;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;

public class class_ans implements Predicate {
   private final class_agj a;

   private class_ans(class_agj var1) {
      this.a = var1;
   }

   public static class_ans a(class_agj var0) {
      return new class_ans(var0);
   }

   public boolean a(class_anl var1) {
      return var1 != null && var1.c() == this.a;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((class_anl)var1);
   }
}
