package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_ek;
import net.minecraft.server.class_el;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_jd;
import net.minecraft.server.class_je;
import net.minecraft.server.class_jk;
import net.minecraft.server.class_lq;
import net.minecraft.server.class_lr;

public class class_lp implements class_je {
   private final MinecraftServer a;
   private final class_ek b;

   public class_lp(MinecraftServer var1, class_ek var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(class_jd var1) {
      switch(class_lp.SyntheticClass_1.a[var1.a().ordinal()]) {
      case 1:
         this.b.a(class_el.d);
         class_fa var2;
         if(var1.b() > 50) {
            var2 = new class_fa("Outdated server! I\'m still on 15w31b");
            this.b.a((class_ff)(new class_jk(var2)));
            this.b.a((class_eu)var2);
         } else if(var1.b() < 50) {
            var2 = new class_fa("Outdated client! Please use 15w31b");
            this.b.a((class_ff)(new class_jk(var2)));
            this.b.a((class_eu)var2);
         } else {
            this.b.a((class_ep)(new class_lq(this.a, this.b)));
         }
         break;
      case 2:
         this.b.a(class_el.c);
         this.b.a((class_ep)(new class_lr(this.a, this.b)));
         break;
      default:
         throw new UnsupportedOperationException("Invalid intention " + var1.a());
      }

   }

   public void a(class_eu var1) {
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_el.values().length];

      static {
         try {
            a[class_el.d.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_el.c.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
