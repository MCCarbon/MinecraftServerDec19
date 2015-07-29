package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_arj extends class_aql {
   private class_agj a;

   public class_arj(class_agj var1) {
      this.a = var1;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      if(var1.p(var3.a()).c() != class_agk.b) {
         return false;
      } else if(var1.p(var3.b()).c() != class_agk.b) {
         return false;
      } else if(var1.p(var3).c().v() != class_atk.a && var1.p(var3).c() != class_agk.b) {
         return false;
      } else {
         int var4 = 0;
         if(var1.p(var3.e()).c() == class_agk.b) {
            ++var4;
         }

         if(var1.p(var3.f()).c() == class_agk.b) {
            ++var4;
         }

         if(var1.p(var3.c()).c() == class_agk.b) {
            ++var4;
         }

         if(var1.p(var3.d()).c() == class_agk.b) {
            ++var4;
         }

         int var5 = 0;
         if(var1.d(var3.e())) {
            ++var5;
         }

         if(var1.d(var3.f())) {
            ++var5;
         }

         if(var1.d(var3.c())) {
            ++var5;
         }

         if(var1.d(var3.d())) {
            ++var5;
         }

         if(var4 == 3 && var5 == 1) {
            var1.a((class_cj)var3, (class_anl)this.a.S(), 2);
            var1.a(this.a, var3, var2);
         }

         return true;
      }
   }
}
